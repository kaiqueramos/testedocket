package br.com.docket.testecartorio.cartorios.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.docket.testecartorio.cartorio.model.Cartorio;
import br.com.docket.testecartorio.cartorios.service.CartorioService;
import br.com.docket.testecartorio.certidao.model.Certidao;
import br.com.docket.testecartorio.certidao.service.CertidaoService;
import br.com.docket.testecartorio.exceptions.CartorioNotFoundException;

/**
 * Controlador para rotas referentes a Cartorio
 * @author kaique
 *
 */
@Controller
@RequestMapping("/")
public class CartoriosController {
	
	@Autowired
	private CartorioService cartorioService;
	@Autowired 
	private CertidaoService certidaoService;
	
	/**
	 * Recebe requisições GET para /cartorios
	 * @param model
	 * @return a página cartórios
	 */
	@GetMapping("cartorios")
	public String getCartorios(Model model) {
		List<Cartorio> list = cartorioService.getAll();
		
		model.addAttribute("cartorios", list);
		
		return "cartorios";
	}
	
	/**
	 * Recebe requisições GET par a página cadastro
	 * @return a página cadastro
	 */
	@GetMapping("cadastro")
	public String getCadastro() {
		return "cadastro";
	}
	
	/**
	 * Recebe requisições POST para a página cadastro
	 * Executa um cadastro de um novo cartório
	 * @param cartorio
	 * @return um redirecionamento para a página cartórios
	 */
	@PostMapping("cadastro")
	public String postCadastro(Cartorio cartorio) {
		if(StringUtils.isEmpty(cartorio.getNome()) || StringUtils.isEmpty(cartorio.getEndereco())) {
			return "redirect:/cadastro";
		}
		int id = cartorioService.save(cartorio);
		return "redirect:/cartorios";
	}
	
	/**
	 * Recebe requisições GET para a rota /cartorios/update
	 * Disponibiliza um formulário para atualizar regístros de cartórios
	 * @param id
	 * @param model
	 * @return um redirecionamento para a página editarcartórios
	 */
	@GetMapping("cartorios/update")
	public String getUpdate(@RequestParam("id") Integer id, Model model) {
		Cartorio cartorio;
		try {
			cartorio = cartorioService.getById(id);
			List<Certidao> certidoesNotHave = certidaoService.getAllCertidoesNotInCartorio(id);
			model.addAttribute("cartorio", cartorio);
			model.addAttribute("certidoesNotHave", certidoesNotHave);
			return "editarcartorio";
		} catch (CartorioNotFoundException | NullPointerException e) {
			return "redirect:/";
		}
	}
	
	/**
	 * Recebe requisições POST para a rota cartorios/update
	 * Realiza um update na tabela TB_CARTÓRIOS
	 * @param cartorio
	 * @param id
	 * @param atr
	 * @return um redirecionamento para a página cartórios
	 */
	@PostMapping("cartorios/update")
	public String postUpdate(Cartorio cartorio, @RequestParam("id") Integer id, RedirectAttributes atr) {
		if(StringUtils.isEmpty(cartorio.getNome()) || StringUtils.isEmpty(cartorio.getEndereco())) {
			return "redirect:/cartorios/update?id=" + id;
		}
		cartorio.setId_cartorio(id);
		int ok = cartorioService.update(cartorio);
		return "redirect:/cartorios";
	}
	
	/**
	 * Recebe requisições para a rota /cartorios/updatecertidao
	 * Ao clicar em emitir, permite ao cartório informar que pode emitir essa certidao
	 * Realiza um INSERT na tabela TB_CARTORIOS_CERTIDAO
	 * @param id_cartorio
	 * @param id_certidao
	 * @return um redirecionamento para a página de update de cartórios referente ao cartório encontrado na url
	 */
	@PostMapping("cartorios/updatecertidao")
	public String postUpdateCertidao(Integer id_cartorio, Integer id_certidao) {
		cartorioService.getNewCertidao(id_cartorio, id_certidao);
		return "redirect:/cartorios/update?id=" + id_cartorio;
	}
	
	/**
	 * Recebe requisições GET para a rota /cartorios/delete
	 * Deleta um cartório e todos seus registros relacionados das tabelas TB_CARTORIOS e TB_CARTORIOS_CERTIDOES
	 * @param id
	 * @param attributes
	 * @return um redirecionamento para a página cartórios
	 */
	@GetMapping("cartorios/delete")
	public String delete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
		Cartorio cartorio;
		try {
			cartorio = cartorioService.getById(id);
			int ok = cartorioService.delete(cartorio);
			return "redirect:/cartorios";
		} catch (CartorioNotFoundException | NullPointerException e) {
			return "redirect:/";
		}
	}
}

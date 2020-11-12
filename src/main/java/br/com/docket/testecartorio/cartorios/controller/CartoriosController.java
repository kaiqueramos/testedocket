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

@Controller
@RequestMapping("/")
public class CartoriosController {
	
	@Autowired
	private CartorioService cartorioService;
	@Autowired 
	private CertidaoService certidaoService;
	
	@GetMapping("cartorios")
	public String getCartorios(Model model) {
		List<Cartorio> list = cartorioService.getAll();
		
		model.addAttribute("cartorios", list);
		
		return "cartorios";
	}
	
	@GetMapping("cadastro")
	public String getCadastro() {
		return "cadastro";
	}
	
	@PostMapping("cadastro")
	public String postCadastro(Cartorio cartorio) {
		if(StringUtils.isEmpty(cartorio.getNome()) || StringUtils.isEmpty(cartorio.getEndereco())) {
			return "redirect:/cadastro";
		}
		int id = cartorioService.save(cartorio);
		return "redirect:/cartorios";
	}
	
	@GetMapping("cartorios/update")
	public String getUpdate(@RequestParam("id") Integer id, Model model) {
		Cartorio cartorio = cartorioService.getById(id);
		List<Certidao> certidoesNotHave = certidaoService.getAllCertidoesNotInCartorio(id);
		certidoesNotHave.forEach(System.out::println);
		model.addAttribute("cartorio", cartorio);
		model.addAttribute("certidoesNotHave", certidoesNotHave);
		return "editarcartorio";
	}
	
	@PostMapping("cartorios/update")
	public String postUpdate(Cartorio cartorio, @RequestParam("id") Integer id, RedirectAttributes atr) {
		if(StringUtils.isEmpty(cartorio.getNome()) || StringUtils.isEmpty(cartorio.getEndereco())) {
			System.out.println(cartorio.getNome());
			return "redirect:/cartorios/update?id=" + id;
		}
		cartorio.setId_cartorio(id);
		int ok = cartorioService.update(cartorio);
		return "redirect:/cartorios";
	}
	
	@PostMapping("cartorios/updatecertidao")
	public String postUpdateCertidao(Integer id_cartorio, Integer id_certidao) {
		cartorioService.getNewCertidao(id_cartorio, id_certidao);
		return "redirect:/cartorios/update?id=" + id_cartorio;
	}
	
	@GetMapping("cartorios/delete")
	public String delete(@RequestParam("id") Integer id, RedirectAttributes attributes) {
		Cartorio cartorio = cartorioService.getById(id);
		int ok = cartorioService.delete(cartorio);
		return "redirect:/cartorios";
	}
}

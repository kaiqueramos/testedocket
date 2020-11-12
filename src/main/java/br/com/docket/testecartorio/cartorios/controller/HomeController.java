package br.com.docket.testecartorio.cartorios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para a rota / (Rota raiz)
 * @author kaique
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	/**
	 * Recebe requisições GET da rota raiz
	 * @return a pagina home
	 */
	@GetMapping
	public String home() {
		return "home";
	}
}

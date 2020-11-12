package br.com.docket.testecartorio.exceptions;

/**
 * Exceção usada caso um cartório não seja encontrado
 * @author kaique
 *
 */
public class CartorioNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CartorioNotFoundException(String msg) {
		super(msg);
	}
}

package br.com.docket.testecartorio.certidao.service;

import java.util.List;

import br.com.docket.testecartorio.certidao.model.Certidao;

/**
 * Interface de serviços para a entidade Certidao
 * @author kaique
 *
 */
public interface CertidaoService {

	/**
	 * Método para buscar uma certidao por id
	 * @param id
	 * @return uma certidao
	 */
	Certidao getById(Integer id);
	
	/**
	 * Método para buscar todas as certidões
	 * @return uma lista de certidões
	 */
	List<Certidao> getAll();
	
	/**
	 * Método para buscar todas as certidões que um cartorio pode emitir
	 * @param cartorio
	 * @return uma lista de certidoes
	 */
	List<Certidao> getAllCertidoesByCartorio(Integer id_cartorio);
	
	/**
	 * Método para mostrar todas as certidões que um cartório não pode emitir.
	 * @return uma lista de certidões
	 */
	List<Certidao> getAllCertidoesNotInCartorio(Integer id_cartorio);
}

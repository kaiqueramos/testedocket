package br.com.docket.testecartorio.certidao.dao;

import java.util.List;

import br.com.docket.testecartorio.cartorio.model.Cartorio;
import br.com.docket.testecartorio.certidao.model.Certidao;

/**
 * Interface DAO para a entidade Certidao
 * @author kaique
 *
 */
public interface CertidaoDao {
	
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
}

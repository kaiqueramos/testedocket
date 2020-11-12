package br.com.docket.testecartorio.certidao.dao;

import java.util.List;

import br.com.docket.testecartorio.cartorio.model.Cartorio;
import br.com.docket.testecartorio.certidao.model.Certidao;

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
	 * Método para inserir uma nova certidao
	 * @param certidao
	 * @return o ID da certidao salva
	 */
	Integer save(Certidao certidao);
	
	/**
	 * Método para atualizar uma certidao
	 * @param certidao
	 * @return 1 para OK e 0 para não OK/sem sucesso
	 */
	Integer update(Certidao certidao);
	
	/**
	 * Método para deletar uma certidao
	 * @param certidao
	 * @return 1 para OK e 0 para não OK/sem sucesso
	 */
	Integer delete(Certidao certidao);
	
	/**
	 * Método para buscar todas as certidões que um cartorio pode emitir
	 * @param cartorio
	 * @return uma lista de certidoes
	 */
	List<Certidao> getAllCertidoesByCartorio(Integer id_cartorio);
}

package br.com.docket.testecartorio.cartorios.dao;

import java.util.List;

import br.com.docket.testecartorio.cartorio.model.Cartorio;

public interface CartorioDao {
	
	/**
	 * Método para buscar um cartório por id
	 * @param id
	 * @return um cartório
	 */
	Cartorio getById(Integer id);
	
	/**
	 * Método para buscar todos os cartórios
	 * @return uma lista de cartórios
	 */
	List<Cartorio> getAll();
	
	/**
	 * Método para inserir um novo cartório
	 * @param cartorio
	 * @return o ID do cartório salvo
	 */
	Integer save(Cartorio cartorio);
	
	/**
	 * Método para atualizar um cartório
	 * @param cartorio
	 * @return 1 para OK e 0 para não OK/sem sucesso
	 */
	Integer update(Cartorio cartorio);
	
	/**
	 * Método para deletar um cartório
	 * @param cartorio
	 * @return 1 para OK e 0 para não OK/sem sucesso
	 */
	Integer delete(Cartorio cartorio);
	
	/**
	 * Método para um cartório adquirir uma nova certidao	
	 * @param id_cartorio
	 * @param id_certidao
	 */
	void getNewCertidao(Integer id_cartorio, Integer id_certidao);
}

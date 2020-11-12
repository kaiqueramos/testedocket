package br.com.docket.testecartorio.cartorio.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.docket.testecartorio.certidao.model.Certidao;

/**
 * Classe referente a tabela TB_CARTORIOS
 * {@link List<Certidao> certidoes} Referentes a tabel TB_CARTORIOS_CERTIDOES
 * @author kaique
 *
 */
public class Cartorio {
	private Integer id_cartorio;
	private String nome;
	private String endereco;
	private List<Certidao> certidoes = new ArrayList<>();
	
	public Integer getId_cartorio() {
		return id_cartorio;
	}
	public void setId_cartorio(Integer id) {
		this.id_cartorio = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Certidao> getCertidoes() {
		return certidoes;
	}	
	
}

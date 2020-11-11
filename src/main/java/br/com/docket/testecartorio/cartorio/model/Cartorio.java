package br.com.docket.testecartorio.cartorio.model;

import java.util.ArrayList;
import java.util.List;

import br.com.docket.testecartorio.certidao.model.Certidao;

public class Cartorio {
	private Integer id;
	private String nome;
	private String endereco;
	private List<Certidao> certidoes = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

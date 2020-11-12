package br.com.docket.testecartorio.certidao.model;


/**
 * Classe referente a tabela TB_CERTIDOES
 * @author kaique
 *
 */
public class Certidao {
	private Integer id_certidao;
	private String nome_certidao;
	
	public Integer getId_certidao() {
		return id_certidao;
	}
	public void setId_certidao(Integer id) {
		this.id_certidao = id;
	}
	public String getNome_certidao() {
		return nome_certidao;
	}
	public void setNome_certidao(String nome) {
		this.nome_certidao = nome;
	}
	@Override
	public String toString() {
		return "Certidao [nome_certidao=" + nome_certidao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_certidao == null) ? 0 : id_certidao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certidao other = (Certidao) obj;
		if (id_certidao == null) {
			if (other.id_certidao != null)
				return false;
		} else if (!id_certidao.equals(other.id_certidao))
			return false;
		return true;
	}
	
	
	
}

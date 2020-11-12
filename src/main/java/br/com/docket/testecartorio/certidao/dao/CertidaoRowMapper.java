package br.com.docket.testecartorio.certidao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.docket.testecartorio.certidao.model.Certidao;

public class CertidaoRowMapper implements RowMapper<Certidao> {

	@Override
	public Certidao mapRow(ResultSet rs, int rowNum) throws SQLException {
		Certidao certidao = new Certidao();
		certidao.setId_certidao(rs.getInt("id_certidao"));
		certidao.setNome_certidao(rs.getString("nome_certidao"));
		return certidao;
	}

}

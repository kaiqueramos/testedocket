package br.com.docket.testecartorio.cartorios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import br.com.docket.testecartorio.cartorio.model.Cartorio;
import br.com.docket.testecartorio.certidao.dao.CertidaoDao;
import br.com.docket.testecartorio.certidao.model.Certidao;

public class CartorioRowMapper implements RowMapper<Cartorio> {

	@Autowired
	private CertidaoDao dao;
	
	@Override
	public Cartorio mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cartorio cartorio = new Cartorio();
		cartorio.setId_cartorio(rs.getInt("id_cartorio"));
		cartorio.setNome(rs.getString("nome"));
		cartorio.setEndereco(rs.getString("endereco"));
		return cartorio;
	}

	

}

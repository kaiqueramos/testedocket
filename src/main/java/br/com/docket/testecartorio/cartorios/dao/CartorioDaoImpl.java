package br.com.docket.testecartorio.cartorios.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.docket.testecartorio.cartorio.model.Cartorio;

@Repository
public class CartorioDaoImpl implements CartorioDao{

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource ds;
	
	@Override
	public Cartorio getById(Integer id) {
		try {
			String sql = "SELECT * FROM TB_CARTORIOS WHERE id_cartorio = :id_cartorio";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("id_cartorio", id);
			Cartorio cartorio = template.queryForObject(sql, param, new CartorioRowMapper());
			return cartorio;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Cartorio> getAll() {
		try {
			String sql = "SELECT * FROM TB_CARTORIOS";
			MapSqlParameterSource param = new MapSqlParameterSource();
			List<Cartorio> cartorios = template.query(sql, param, new CartorioRowMapper());
			return cartorios;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Integer save(Cartorio cartorio) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds)
				.withTableName("TB_CARTORIOS")
				.usingColumns("nome", "endereco")
				.usingGeneratedKeyColumns("id_cartorio");
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("nome", cartorio.getNome())
				.addValue("endereco", cartorio.getEndereco());
		
		Integer id = (Integer) insert.executeAndReturnKey(param);
		
		return id;
	}

	@Override
	public Integer update(Cartorio cartorio) {
		String sql = "UPDATE TB_CARTORIOS SET nome = :nome, endereco = :endereco WHERE id_cartorio = :id_cartorio";
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("nome", cartorio.getNome())
				.addValue("endereco", cartorio.getEndereco())
				.addValue("id_cartorio", cartorio.getId_cartorio());
		return template.update(sql, param);
	}

	@Override
	public Integer delete(Cartorio cartorio) {
		String sql = "DELETE FROM TB_CARTORIOS WHERE id_cartorio = :id_cartorio";
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("id_cartorio", cartorio.getId_cartorio());
		int ok = template.update(sql, param);
		return ok;
	}

	@Override
	public void getNewCertidao(Integer id_cartorio, Integer id_certidao) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds)
				.withTableName("TB_CARTORIOS_CERTIDOES")
				.usingColumns("fk_id_cartorio", "fk_id_certidao");
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("fk_id_cartorio", id_cartorio)
				.addValue("fk_id_certidao", id_certidao);
		insert.execute(param);
	}
	
	
}

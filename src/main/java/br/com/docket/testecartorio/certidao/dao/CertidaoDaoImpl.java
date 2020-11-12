package br.com.docket.testecartorio.certidao.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.docket.testecartorio.cartorio.model.Cartorio;
import br.com.docket.testecartorio.cartorios.dao.CartorioRowMapper;
import br.com.docket.testecartorio.certidao.model.Certidao;

@Repository
public class CertidaoDaoImpl implements CertidaoDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public Certidao getById(Integer id) {
		try {
			String sql = "SELECT * FROM TB_CERTIDOES WHERE id_certidao = :id_certidao ON DELETE CASCADES";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("id_certidao", id);
			Certidao certidao = template.queryForObject(sql, param, new CertidaoRowMapper());
			return certidao;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Certidao> getAll() {
		try {
			String sql = "SELECT * FROM TB_CERTIDOES";
			MapSqlParameterSource param = new MapSqlParameterSource();
			List<Certidao> certidao = template.query(sql, param, new CertidaoRowMapper());
			return certidao;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public Integer save(Certidao certidao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Certidao certidao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Certidao certidao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certidao> getAllCertidoesByCartorio(Integer id_cartorio) {
		try {
			String sql = "SELECT cart.nome, cart.endereco, cert.nome_certidao, cc.fk_id_cartorio AS id_cartorio, cc.fk_id_certidao AS id_certidao FROM TB_CARTORIOS cart, TB_CERTIDOES cert, TB_CARTORIOS_CERTIDOES cc WHERE fk_id_cartorio = id_cartorio AND fk_id_certidao = id_certidao AND id_cartorio = :id_cartorio";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("id_cartorio", id_cartorio);
			List<Certidao> list = template.query(sql, param, new CertidaoRowMapper());
			return list;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}

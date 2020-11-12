package br.com.docket.testecartorio.certidao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docket.testecartorio.certidao.dao.CertidaoDao;
import br.com.docket.testecartorio.certidao.model.Certidao;

@Service
public class CertidaoServiceImpl implements CertidaoService {

	@Autowired
	private CertidaoDao dao;
	
	@Override
	public Certidao getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Certidao> getAll() {
		return dao.getAll();
	}

	@Override
	public Integer save(Certidao certidao) {
		return dao.save(certidao);
	}

	@Override
	public Integer update(Certidao certidao) {
		return dao.update(certidao);
	}

	@Override
	public Integer delete(Certidao certidao) {
		return dao.delete(certidao);
	}

	@Override
	public List<Certidao> getAllCertidoesByCartorio(Integer id_cartorio) {
		return dao.getAllCertidoesByCartorio(id_cartorio);
	}

	@Override
	public List<Certidao> getAllCertidoesNotInCartorio(Integer id_cartorio) {
		List<Certidao> cartorioHave = getAllCertidoesByCartorio(id_cartorio);
		List<Certidao> list = getAll();
		
		list.removeAll(cartorioHave);		
		return list;
	}

}

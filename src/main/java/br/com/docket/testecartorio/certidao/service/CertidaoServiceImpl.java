package br.com.docket.testecartorio.certidao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.docket.testecartorio.certidao.dao.CertidaoDao;
import br.com.docket.testecartorio.certidao.model.Certidao;
/**
 * Classe de serviços para a entidade Certidao
 * @author kaique
 *
 */
@Service
public class CertidaoServiceImpl implements CertidaoService {

	@Autowired
	private CertidaoDao dao;
	
	@Override
	@Transactional
	public Certidao getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	@Transactional
	public List<Certidao> getAll() {
		return dao.getAll();
	}

	@Override
	@Transactional
	public List<Certidao> getAllCertidoesByCartorio(Integer id_cartorio) {
		return dao.getAllCertidoesByCartorio(id_cartorio);
	}

	@Override
	@Transactional
	public List<Certidao> getAllCertidoesNotInCartorio(Integer id_cartorio) {
		List<Certidao> cartorioHave = getAllCertidoesByCartorio(id_cartorio);
		List<Certidao> list = getAll();
		
		list.removeAll(cartorioHave);		
		return list;
	}

}

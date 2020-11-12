package br.com.docket.testecartorio.cartorios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.docket.testecartorio.cartorio.model.Cartorio;
import br.com.docket.testecartorio.cartorios.dao.CartorioDao;
import br.com.docket.testecartorio.certidao.service.CertidaoService;
import br.com.docket.testecartorio.exceptions.CartorioNotFoundException;

/**
 * Classe de serviços para a entidade Cartorio
 * @author kaique
 *
 */
@Service
public class CartorioServiceImpl implements CartorioService {

	@Autowired
	private CartorioDao dao;
	@Autowired 
	private CertidaoService service;
	
	
	@Override
	@Transactional
	public Cartorio getById(Integer id) throws CartorioNotFoundException {
		
		Cartorio cartorio = dao.getById(id);
		cartorio.getCertidoes().addAll(service.getAllCertidoesByCartorio(cartorio.getId_cartorio()));
		return cartorio;
		
	}

	@Override
	@Transactional
	public List<Cartorio> getAll() {
		List<Cartorio> list = dao.getAll();
		
		list.forEach(l -> l.getCertidoes().addAll(service.getAllCertidoesByCartorio(l.getId_cartorio())));
		
		return list;
	}

	@Override
	@Transactional
	public Integer save(Cartorio cartorio) {
		return dao.save(cartorio);
	}

	@Override
	@Transactional
	public Integer update(Cartorio cartorio) {
		return dao.update(cartorio);
	}

	@Override
	@Transactional
	public Integer delete(Cartorio cartorio) {
		return dao.delete(cartorio);
	}

	@Override
	@Transactional
	public void getNewCertidao(Integer id_cartorio, Integer id_certidao) {
		dao.getNewCertidao(id_cartorio, id_certidao);
	}

}

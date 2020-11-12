package br.com.docket.testecartorio.cartorios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docket.testecartorio.cartorio.model.Cartorio;
import br.com.docket.testecartorio.cartorios.dao.CartorioDao;
import br.com.docket.testecartorio.certidao.service.CertidaoService;

@Service
public class CartorioServiceImpl implements CartorioService {

	@Autowired
	private CartorioDao dao;
	@Autowired 
	private CertidaoService service;
	
	
	@Override
	public Cartorio getById(Integer id) {
		Cartorio cartorio = dao.getById(id);
		cartorio.getCertidoes().addAll(service.getAllCertidoesByCartorio(cartorio.getId_cartorio()));
		return cartorio;
	}

	@Override
	public List<Cartorio> getAll() {
		List<Cartorio> list = dao.getAll();
		
		list.forEach(l -> l.getCertidoes().addAll(service.getAllCertidoesByCartorio(l.getId_cartorio())));
		
		return list;
	}

	@Override
	public Integer save(Cartorio cartorio) {
		return dao.save(cartorio);
	}

	@Override
	public Integer update(Cartorio cartorio) {
		return dao.update(cartorio);
	}

	@Override
	public Integer delete(Cartorio cartorio) {
		return dao.delete(cartorio);
	}

	@Override
	public void getNewCertidao(Integer id_cartorio, Integer id_certidao) {
		dao.getNewCertidao(id_cartorio, id_certidao);
	}

}

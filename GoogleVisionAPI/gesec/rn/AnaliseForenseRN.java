package br.com.gesec.rn;

import br.com.gesec.dao.AnaliseForenseDAO;
import br.com.gesec.entity.AnaliseForense;

public class AnaliseForenseRN {
	private AnaliseForenseDAO analiseForenseDao;

	public AnaliseForenseRN() {
		analiseForenseDao = new AnaliseForenseDAO();
	}

	// SALVAR NO BANCO DE DADOS
	public void salvar(AnaliseForense analiseForense) {
		analiseForenseDao.salvar(analiseForense);

	}

	public Object buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

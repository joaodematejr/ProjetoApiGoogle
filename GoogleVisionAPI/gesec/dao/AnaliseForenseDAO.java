package br.com.gesec.dao;

import br.com.gesec.entity.AnaliseForense;

public class AnaliseForenseDAO extends DAO {

	public void salvar(AnaliseForense analiseForense) {
		getEM().merge(analiseForense);

	}

}

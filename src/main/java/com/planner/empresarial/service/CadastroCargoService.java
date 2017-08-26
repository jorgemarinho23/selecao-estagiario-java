package com.planner.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.repository.Cargos;
import com.planner.empresarial.util.jpa.Transactional;

public class CadastroCargoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cargos cargos;
	@Transactional
	public void Salvar(Cargo cargo){
		cargos.Salvar(cargo);
	}
}

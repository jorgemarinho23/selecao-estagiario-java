package com.planner.empresarial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.repository.Funcionarios;
import com.planner.empresarial.util.jpa.Transactional;

public class CadastroFuncionarioService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios funcionarios;
	
	@Transactional
	public void Salvar(Funcionario funcionario){
		
		this.funcionarios.Salvar(funcionario);
		
	}

}

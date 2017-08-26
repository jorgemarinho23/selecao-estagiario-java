package com.planner.empresarial.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.repository.Cargos;
import com.planner.empresarial.service.CadastroFuncionarioService;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	private List<Cargo> cargos;
	
	@Inject
	private CadastroFuncionarioService cadastroFuncionarioService;
	@Inject
	private Cargos cargosRepository;
	
	
	public void salvar(){
		this.cadastroFuncionarioService.Salvar(funcionario);
		FacesUtil.addInfoMessage("Funcionario salvo com sucesso !");
		this.limpar();
	}
	
	@PostConstruct
	public void iniciar(){
		this.limpar();
	}

	public void limpar(){
		this.funcionario = new Funcionario();
		this.cargos = cargosRepository.buscarTodos();
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

}

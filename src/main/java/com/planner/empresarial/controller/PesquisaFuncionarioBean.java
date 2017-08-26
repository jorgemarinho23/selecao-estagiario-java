package com.planner.empresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.repository.Funcionarios;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	private Funcionario funcionarioSelecionado;
	@Inject
	private Funcionarios funcionariosRepository;
	
	public void excluir(){
		this.funcionariosRepository.Excluir(funcionarioSelecionado);
		this.funcionarios.remove(funcionarioSelecionado);
		FacesUtil.addInfoMessage("Funcionário "+funcionarioSelecionado.getNome()+" Excluído com sucesso ! ");
	}
	
	@PostConstruct
	public void iniciar(){
		this.funcionarios = funcionariosRepository.buscarTodos();
	}
	
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	
	

}

package com.planner.empresarial.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.service.CadastroCargoService;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCargoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Cargo cargo;
	@Inject
	private CadastroCargoService cadastroCargoService;
	
	public void salvar(){
		this.cadastroCargoService.Salvar(this.cargo);
		this.limpar();
		FacesUtil.addInfoMessage("Cargo salvo com sucesso !");
	}
	
	@PostConstruct
	public void iniciar(){
		this.limpar();
	}
	
	public void limpar(){
		this.cargo = new Cargo();
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}

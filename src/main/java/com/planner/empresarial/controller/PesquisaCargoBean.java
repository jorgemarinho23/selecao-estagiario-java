package com.planner.empresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.repository.Cargos;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCargoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Cargo> cargos = new ArrayList<>();
	private Cargo cargoSelecionado;
	@Inject
	private Cargos cargosRepository;
	
	public void excluir(){
	
			this.cargosRepository.Excluir(cargoSelecionado);
			this.cargos.remove(cargoSelecionado);
			FacesUtil.addInfoMessage("Cargo "+cargoSelecionado.getDescricao()+" Excluido com sucesso !");
		
		
	}
	
	@PostConstruct
	public void iniciar(){
		this.cargos = cargosRepository.buscarTodos();
	}

	public Cargo getCargoSelecionado() {
		return cargoSelecionado;
	}

	public void setCargoSelecionado(Cargo cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

}

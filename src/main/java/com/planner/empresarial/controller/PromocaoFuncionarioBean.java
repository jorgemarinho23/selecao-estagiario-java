package com.planner.empresarial.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.repository.Cargos;
import com.planner.empresarial.repository.Funcionarios;
import com.planner.empresarial.service.PromocaoFuncionarioService;
import com.planner.empresarial.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PromocaoFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Funcionario> funcionarios;
	private Cargo cargoSelecionado;
	private List<Cargo> cargos;
	private BigDecimal percentualAumento = BigDecimal.ZERO;
	
	@Inject
	private Funcionarios funcionariosRepository;
	@Inject
	private Cargos cargosRepository;
	@Inject
	private PromocaoFuncionarioService promocaoFuncionarioService;
	
	
	public void buscarPorCargo(){
		this.funcionarios = this.funcionariosRepository.buscarPorCargo(cargoSelecionado);
	}

	
	public void calcularPercentual(){
		try {
			this.promocaoFuncionarioService.AtualizarSalario(percentualAumento,cargoSelecionado);
			this.buscarPorCargo();
			FacesUtil.addInfoMessage("Salários atualizados com sucesso !");
			this.percentualAumento = BigDecimal.ZERO;
			
			
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
	
	
	@PostConstruct
	public void iniciar(){
		this.cargos = cargosRepository.buscarTodos();
	}
	@NotNull
	public Cargo getCargoSelecionado() {
		return cargoSelecionado;
	}

	public void setCargoSelecionado(Cargo cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public BigDecimal getPercentualAumento() {
		return percentualAumento;
	}

	public void setPercentualAumento(BigDecimal percentualAumento) {
		this.percentualAumento = percentualAumento;
	}	
}

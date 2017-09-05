package com.planner.empresarial.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.repository.Funcionarios;
import com.planner.empresarial.util.jpa.Transactional;

public class PromocaoFuncionarioService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<Funcionario> funcionarios;
	
	@Inject
	private Funcionarios funcionariosRepository;
	
	@Transactional
	public void AtualizarSalario(BigDecimal percentual,Cargo cargo) throws NegocioException{
		this.funcionarios =  this.funcionariosRepository.buscarPorCargo(cargo);
		BigDecimal novoSalario = BigDecimal.ZERO;

		if (funcionarios.isEmpty()) {
			throw new NegocioException("Nenhum funcionário cadastrado para o cargo selecionado !");
		}

		if (percentual.doubleValue() < 0.1 ) {			
	     throw new NegocioException("Percentual inválido !");
		}

	    for (Funcionario funcionario : funcionarios) { 

		    novoSalario = percentual.divide(new BigDecimal(100)).multiply(funcionario.getSalario());
		    System.out.println("Percentual "+novoSalario+"-"+funcionario.getNome());
		    
		    novoSalario = novoSalario.add(funcionario.getSalario());
			System.out.println("Novo salario "+novoSalario+"-"+funcionario.getNome());

            funcionario.setSalario(novoSalario);
		}
	}
}

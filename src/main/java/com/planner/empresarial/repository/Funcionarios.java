package com.planner.empresarial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.ObjectUtils.Null;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.model.Funcionario;
import com.planner.empresarial.service.NegocioException;
import com.planner.empresarial.util.jpa.Transactional;

public class Funcionarios implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void Salvar(Funcionario funcionario){
		em.merge(funcionario);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos() {
		return em.createQuery("from Funcionario").getResultList();
	}

	@Transactional
	public void Excluir(Funcionario funcionario) {
		Funcionario funcionarioExcluir = em.find(Funcionario.class, funcionario.getMatricula());
		
		em.remove(funcionarioExcluir);
		em.flush();
	}

	public Funcionario porMatricula(Long matricula) {
		
		return em.find(Funcionario.class, matricula);
		
	}

	public List<Funcionario> buscarPorCargo(Cargo cargo)  {
		
		String jpql ="from Funcionario where cargo = :cargo";
		
	
			List<Funcionario> funcionarios = em.createQuery(jpql, Funcionario.class)
	                .setParameter("cargo", cargo)
	                .getResultList();
   
           return funcionarios;
		
	}
}

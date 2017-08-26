package com.planner.empresarial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.planner.empresarial.model.Cargo;
import com.planner.empresarial.service.NegocioException;
import com.planner.empresarial.util.jpa.Transactional;

public class Cargos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void Salvar(Cargo cargo){
		em.merge(cargo);
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> buscarTodos() {
		return em.createQuery("from Cargo").getResultList();
	}
	
    @Transactional
	public void Excluir(Cargo cargo) { 
		Cargo CargoExcluir = em.find(Cargo.class, cargo.getCodigo());
		try {
			em.remove(CargoExcluir);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Existem funcionarios cadastrados com este cargo !");
		}
	}

	public Cargo porCodigo(Long codigo) {
		
		return em.find(Cargo.class, codigo);
	}
}

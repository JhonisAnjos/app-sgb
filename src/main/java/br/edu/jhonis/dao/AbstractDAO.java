package br.edu.jhonis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.jhonis.util.JpaUtil;

public abstract class AbstractDAO<T,I> {
	
	private EntityManager getEntityManager(){
		return JpaUtil.getEntityManager();
	}
	
	private void closeEntityManager(){
		JpaUtil.closeEntityManager();
	}
	
	public T atualizar(T object){
		this.getEntityManager().merge(object);
		return object;
	}
	
	public void excluir(T object){		
		this.getEntityManager().remove(object);
	}
	
	public void excluir(Class<T> type,I id){		
		T object = this.getById(type, id);
		this.getEntityManager().remove(object);
	}
	
	public T salvar(T object){
		this.getEntityManager().persist(object);
		return object;
	}
	
	public T getById(Class<T> type,I id){
		return (T)this.getEntityManager().find(type, id);
	}

	public List<T> find(String jpql){
		 Query query = getEntityManager().createQuery(jpql);
		 return query.getResultList(); 
	}

}

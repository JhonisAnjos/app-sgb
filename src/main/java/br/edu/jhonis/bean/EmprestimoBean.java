package br.edu.jhonis.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.jhonis.util.JpaUtil;

@ManagedBean
@ViewScoped
public class EmprestimoBean {


	public String getTeste(){
		JpaUtil.getEntityManager();
		return "testets";
	}
}

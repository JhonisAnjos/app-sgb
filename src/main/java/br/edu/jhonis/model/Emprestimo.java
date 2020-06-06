package br.edu.jhonis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo implements Serializable{

	private static final long serialVersionUID = 8204586995793422394L;

	@Id
	@SequenceGenerator(name = "emprestimoGenerator", sequenceName = "seq_emprestimo", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emprestimoGenerator")
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEmprestimo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDevolucao;
	
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="livro_id")
	private Livro livro;
	
	@ManyToOne
	@JoinColumn(name="leitor_id")
	private Leitor leitor;
	
	public static final Integer STATUS_PENDENTE= new Integer(1);
	public static final Integer STATUS_CONCLUIDO= new Integer(1);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

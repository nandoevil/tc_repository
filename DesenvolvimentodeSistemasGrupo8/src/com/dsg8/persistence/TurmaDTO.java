package com.dsg8.persistence;

import java.io.Serializable;

public class TurmaDTO implements Serializable{
	
	private Integer codigo;
	private String nome;
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}

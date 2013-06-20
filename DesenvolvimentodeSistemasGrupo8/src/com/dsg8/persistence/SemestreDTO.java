package com.dsg8.persistence;

import java.io.Serializable;

public class SemestreDTO implements Serializable{
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

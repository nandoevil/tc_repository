package com.dsg8.persistence;

public class AlocacaoDTO {

	private Integer codigoAlocacao;
	private Integer codigoProfessor;
	private Integer codigoTurma;
	private long codigoDisciplina;

	public AlocacaoDTO(){
		
	}
	
	public long getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(long codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}



	public Integer getCodigoAlocacao() {
		return codigoAlocacao;
	}
	
	public void setCodigoAlocacao(Integer codigoAlocacao) {
		this.codigoAlocacao = codigoAlocacao;
	}
	
	public Integer getCodigoProfessor() {
		return codigoProfessor;
	}
	
	public void setCodigoProfessor(Integer codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}
	
	public Integer getCodigoTurma() {
		return codigoTurma;
	}
	
	public void setCodigoTurma(Integer codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	
}

package br.com.facear.model;



public class Empregador {
	
	
	private Integer idEmpregador;
	private String nome;
	private String cpf;

	
	
	public Empregador() {
		
	}
	public Empregador(Integer idEmpregador, String nome, String cpf) {
		super();
		this.idEmpregador = idEmpregador;
		this.nome = nome;
		this.cpf = cpf;
	}

	
	public Integer getIdEmpregador() {
		return idEmpregador;
	}
	public void setIdEmpregador(Integer idEmpregador) {
		this.idEmpregador = idEmpregador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

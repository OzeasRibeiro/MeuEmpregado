package br.com.facear.model;



public class Contrato {

	private Integer idContrato;
	private Empregador empregador = new Empregador();
	private Empregado empregado = new Empregado();
	private double salario;
	private boolean status;
	
	
	public Contrato() {
		
	}
	public Contrato(Integer idContrato, Empregador empregador, Empregado empregado, double salario, boolean status) {
		super();
		this.idContrato = idContrato;
		this.empregador = empregador;
		this.empregado = empregado;
		this.salario = salario;
		this.status = status;
	}


	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Empregador getEmpregador() {
		return empregador;
	}
	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

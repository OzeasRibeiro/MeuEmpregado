package br.com.facear.model;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImpostoEmpregado {
	DecimalFormat dcm = new DecimalFormat("#0.00");
	SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
	
	private Integer idImpostoEmpregado = 0;
	private Contrato contrato = new Contrato();
	private Date mes = null;
	private double salario, inss, irf, total;
	
	private String mesFormated;
	private double salarioFormated, inssFormated, irfFormated, totalFormated;
	
	
	public ImpostoEmpregado() {
	}
	public ImpostoEmpregado(Integer idImpostoEmpregado, Contrato contrato, Date mes, double salario, double inss,
			double irf, double total) {
		super();
		this.idImpostoEmpregado = idImpostoEmpregado;
		this.contrato = contrato;
		this.mes = mes;
		this.salario = salario;
		this.inss = inss;
		this.irf = irf;
		this.total = total;
	}
	
	
	public Integer getIdImpostoEmpregado() {
		return idImpostoEmpregado;
	}
	public void setIdImpostoEmpregado(Integer idImpostoEmpregado) {
		this.idImpostoEmpregado = idImpostoEmpregado;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public Date getMes() {
		return mes;
	}
	public void setMes(Date mes) {
		this.mes = mes;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getInss() {
		return inss;
	}
	public void setInss(double inss) {
		this.inss = inss;
	}
	public double getIrf() {
		return irf;
	}
	public void setIrf(double irf) {
		this.irf = irf;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMesFormated() {
		return sdf.format(this.mes);
	}
	public String getSalarioFormated() {
		return dcm.format(salario);
	}
	public String getInssFormated() {
		return dcm.format(inss);
	}
	public String getIrfFormated() {
		return dcm.format(irf);
	}
	public String getTotalFormated() {
		return dcm.format(total);
	}
	
	
	
	
	
}

package br.com.facear.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.facear.model.ImpostoEmpregado;
import br.com.facear.service.ImpostoEmpregadoService;

@ManagedBean(name = "impostoEmpregadoMB")
@SessionScoped
public class ImpostoEmpregadoMB implements Serializable{
	private static final long serialVersionUID = -8601847806759673229L;
	
	private Integer idEmpregado;
	private ImpostoEmpregadoService service = new ImpostoEmpregadoService();
	private List<ImpostoEmpregado> lista = new ArrayList<>();
	private ImpostoEmpregado imposto = new ImpostoEmpregado();
	
	public ImpostoEmpregadoMB() {
		lista = service.selecionar(2);
	}
	public String listAll() {
		lista = service.selecionar(2);
		return "imposto-empregado";
	}

	//----------------------------------------------------------------------------------------------------------------------//
	
	
	public Integer getIdEmpregado() {
		return idEmpregado;
	}
	public void setIdEmpregado(Integer idEmpregado) {
		this.idEmpregado = idEmpregado;
	}
	public ImpostoEmpregadoService getService() {
		return service;
	}
	public void setService(ImpostoEmpregadoService service) {
		this.service = service;
	}
	public List<ImpostoEmpregado> getLista() {
		return lista;
	}
	public void setLista(List<ImpostoEmpregado> lista) {
		this.lista = lista;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ImpostoEmpregado getImposto() {
		return imposto;
	}


	public void setImposto(ImpostoEmpregado imposto) {
		this.imposto = imposto;
	}
	
	
	
}

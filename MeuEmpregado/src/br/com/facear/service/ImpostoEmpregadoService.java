package br.com.facear.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.facear.dao.FactoryDao;
import br.com.facear.model.Contrato;
import br.com.facear.model.Empregado;
import br.com.facear.model.ImpostoEmpregado;

public class ImpostoEmpregadoService{
	
	FactoryDao factory = new FactoryDao();
	
	private double calcularInss(double salario) {
		
		double retorno = 0;
		
		if(salario <= 1659.38) {
			retorno = (salario * 8) / 100;
		}
		else if(salario<=2765.66) {
			retorno = (salario * 9) / 100;
		}
		else{
			retorno = (salario * 11) / 100;
		}
		
		return retorno;
	}
	private double calcularIrf(double salario) {
		
		double retorno = 0;
		
		if(salario <= 1903.98) {
			retorno = 0;
		}
		else if(salario <= 2679.29) {
			retorno = ((salario * 7.5) / 100) - 134.08;
		}
		else if(salario <= 3572.43) {
			retorno = ((salario * 15) / 100) - 335.03;
		}
		else if(salario <= 4463.81) {
			retorno = ((salario * 22.5) / 100) - 602.96;
		}
		else {
			retorno = ((salario * 27.5) / 100) - 826.15;
		}
		
		if(retorno<10)
			retorno = 0;
		
		return retorno;
	}
	
	
	
	public void calcularImpostos() {
		
		ArrayList<Contrato> listaContrato;
		ArrayList<ImpostoEmpregado> listaImposto;
		ImpostoEmpregado imposto;
		double salario, inss, irf, total;
		
		if(new Date().getDate()==1) {
			try {
				listaContrato = factory.createContratoDao().selecionarContratosValidos();
				listaImposto = new ArrayList<>();
				
				for (Contrato contrato : listaContrato) {
					salario = contrato.getSalario();
					inss = calcularInss(salario);
					irf = calcularIrf(salario);
					total = inss + irf;
					
					imposto = new ImpostoEmpregado(null, contrato, new Date(), salario, inss, irf, total);
					listaImposto.add(imposto);
				}
				
				for (ImpostoEmpregado impostoEmpregado : listaImposto) {
					factory.createImpostoEmpregadoDao().cadastrar(impostoEmpregado);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<ImpostoEmpregado> selecionar(){
		try {
			return factory.createImpostoEmpregadoDao().selecionar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ImpostoEmpregado> selecionar(Integer idEmpregado){
		
		try {
		Empregado empregado = new Empregado();
		empregado.setId(idEmpregado);
		ArrayList<ImpostoEmpregado> retorno;
		
		
		retorno = factory.createImpostoEmpregadoDao().selecionar(empregado);
		
		
		for (ImpostoEmpregado impostoEmpregado : retorno) {
			impostoEmpregado.setContrato(factory.createContratoDao().selecionar(impostoEmpregado.getContrato().getIdContrato()));
		}
		
		return retorno;
		
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	
}

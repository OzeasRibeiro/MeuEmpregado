package br.com.facear.dao;

import br.com.facear.dao.interfaces.ContratoDaoInterface;
import br.com.facear.dao.interfaces.EmpregadoDaoInterface;
import br.com.facear.dao.interfaces.EmpregadorDaoInterface;
import br.com.facear.dao.interfaces.ImpostoEmpregadoDaoInterface;

public class FactoryDao {

	public ContratoDaoInterface createContratoDao() {
		return new ContratoDao();
	}
	
	public EmpregadoDaoInterface createEmpregadoDao() {
		return new EmpregadoDao();
	}
	
	public EmpregadorDaoInterface createEmpregadorDao() {
		return new EmpregadorDao();
	}
	
	public ImpostoEmpregadoDaoInterface createImpostoEmpregadoDao() {
		return new ImpostoEmpregadoDao();
	}
}

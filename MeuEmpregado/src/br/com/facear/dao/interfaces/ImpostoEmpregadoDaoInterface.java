package br.com.facear.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import br.com.facear.model.Empregado;
import br.com.facear.model.ImpostoEmpregado;

public interface ImpostoEmpregadoDaoInterface extends DaoInterface<ImpostoEmpregado>{

	public ArrayList<ImpostoEmpregado> selecionar(Empregado empregado) throws ClassNotFoundException, SQLException;
	
	public ArrayList<ImpostoEmpregado> selecionar(Empregado empregado,Date mes) throws ClassNotFoundException, SQLException;

	public ArrayList<ImpostoEmpregado> selecionar(Empregado empregado,String pesquisa) throws ClassNotFoundException, SQLException;
}

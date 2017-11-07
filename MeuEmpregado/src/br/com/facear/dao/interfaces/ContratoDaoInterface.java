package br.com.facear.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.facear.model.Contrato;

public interface ContratoDaoInterface extends DaoInterface<Contrato>{

	public ArrayList<Contrato> selecionarContratosValidos() throws ClassNotFoundException, SQLException;
	
}

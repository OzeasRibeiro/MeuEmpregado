package br.com.facear.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DaoInterface<Objeto> {

	public Integer cadastrar(Objeto obj) throws ClassNotFoundException, SQLException;
	
	public void alterar(Objeto obj) throws ClassNotFoundException, SQLException;
	
	public void excluir(Objeto obj) throws ClassNotFoundException, SQLException;
	
	public Objeto selecionar(Integer id) throws ClassNotFoundException, SQLException;
	
	public ArrayList<Objeto> selecionar() throws ClassNotFoundException, SQLException;
	
}

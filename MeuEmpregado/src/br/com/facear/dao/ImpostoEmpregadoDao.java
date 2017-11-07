package br.com.facear.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import br.com.facear.dao.interfaces.ImpostoEmpregadoDaoInterface;
import br.com.facear.model.Empregado;
import br.com.facear.model.ImpostoEmpregado;

class ImpostoEmpregadoDao implements ImpostoEmpregadoDaoInterface{

	
	private StringBuffer cadastrar,alterar,excluir, selecionarId, selecionarTodos, selecionarEmpregado, selecionarPorMes, selecionarPorPesquisa;
	
	
	public ImpostoEmpregadoDao() {
		cadastrar = new StringBuffer();
		cadastrar.append(" insert into ImpostoEmpregado (idContrato, mes, salario, inss, irf, total)");
		cadastrar.append(" values (?,?,?,?,?,?)");
		
		
		alterar = new StringBuffer();
		alterar.append(" update ImpostoEmpregado set idContrato = ?, mes = ?, salario = ?, inss = ?, irf = ?, total = ?");
		alterar.append(" where id idImpostoEmpregado = ?");
		
		
		excluir = new StringBuffer();
		excluir.append(" delete from ImpostoEmpregado where idImpostoEmpregado = ?");
		
		
		selecionarId = new StringBuffer();
		selecionarId.append(" select * from ImpostoEmpregado where idImpostoEmpregado = ?");
		
		
		selecionarTodos = new StringBuffer();
		selecionarTodos.append(" select * from ImpostoEmpregado");
		
		
		selecionarEmpregado = new StringBuffer();
		selecionarEmpregado.append(" select * from ImpostoEmpregado");
		selecionarEmpregado.append(" inner join Contrato");
		selecionarEmpregado.append(" on ImpostoEmpregado.idContrato = Contrato.idContrato");
		selecionarEmpregado.append(" where Contrato.idEmpregado = ?");
		selecionarEmpregado.append(" order by mes desc");
		
		
		selecionarPorMes = new StringBuffer();
		selecionarPorMes.append(" select * from ImpostoEmpregado");
		selecionarPorMes.append(" inner join Contrato");
		selecionarPorMes.append(" on ImpostoEmpregado.idContrato = Contrato.idContrato");
		selecionarPorMes.append(" where Contrato.idEmpregado = ? && (DATE_FORMAT(mes, '%M/%y')) = (DATE_FORMAT(?, '%M/%y'))");
		selecionarPorMes.append(" order by mes desc");
		
		
		selecionarPorPesquisa = new StringBuffer();
		selecionarPorPesquisa.append(" select * from ImpostoEmpregado");
		selecionarPorPesquisa.append(" inner join Contrato");
		selecionarPorPesquisa.append(" on ImpostoEmpregado.idContrato = Contrato.idContrato");
		selecionarPorPesquisa.append(" inner join Empregador");
		selecionarPorPesquisa.append(" on Contrato.idEmpregador = Empregador.idEmpregador");
		selecionarPorPesquisa.append(" where Contrato.idEmpregado = ? && Empregador.nome like ?");
		selecionarPorPesquisa.append(" order by mes desc");
	}
	
	
	@Override
	public Integer cadastrar(ImpostoEmpregado obj) throws ClassNotFoundException, SQLException {
		Integer retorno = null;
		
		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(cadastrar.toString(),1)){
				ps.setInt(1, obj.getContrato().getIdContrato());
				ps.setDate(2, new Date(obj.getMes().getTime()));
				ps.setDouble(3, obj.getSalario());
				ps.setDouble(4, obj.getInss());
				ps.setDouble(5, obj.getIrf());
				ps.setDouble(6, obj.getTotal());

				ps.execute();
				
				try(ResultSet rs = ps.getGeneratedKeys()){
					rs.next();
					retorno = rs.getInt(1);
				}
			}
		}
		
		return retorno;
	}

	@Override
	public void alterar(ImpostoEmpregado obj) throws ClassNotFoundException, SQLException {

		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(alterar.toString())){
				ps.setInt(1, obj.getContrato().getIdContrato());
				ps.setDate(2, new Date(obj.getMes().getTime()));
				ps.setDouble(3, obj.getSalario());
				ps.setDouble(4, obj.getInss());
				ps.setDouble(5, obj.getIrf());
				ps.setDouble(6, obj.getTotal());
				ps.setInt(7, obj.getIdImpostoEmpregado());
				
				ps.execute();
			}
		}
		
	}

	@Override
	public void excluir(ImpostoEmpregado obj) throws ClassNotFoundException, SQLException {

		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(excluir.toString())){
				ps.setInt(1, obj.getIdImpostoEmpregado());
				ps.execute();
			}
		}
		
	}

	@Override
	public ImpostoEmpregado selecionar(Integer id) throws ClassNotFoundException, SQLException {
		ImpostoEmpregado retorno = null;
		
		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(selecionarId.toString())){
				ps.setInt(1, id);
				
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						retorno = new ImpostoEmpregado();
						retorno.getContrato().setIdContrato(rs.getInt("idContrato"));
						retorno.setIdImpostoEmpregado(id);
						retorno.setInss(rs.getDouble("inss"));
						retorno.setIrf(rs.getDouble("irf"));
						retorno.setMes(rs.getDate("mes"));
						retorno.setSalario(rs.getDouble("salario"));
						retorno.setTotal(rs.getDouble("total"));
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public ArrayList<ImpostoEmpregado> selecionar() throws ClassNotFoundException, SQLException {

		ArrayList<ImpostoEmpregado> retorno = new ArrayList<>();
		ImpostoEmpregado imposto = null;
		
		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(selecionarTodos.toString())){
				
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						imposto = new ImpostoEmpregado();
						imposto.getContrato().setIdContrato(rs.getInt("idContrato"));
						imposto.setIdImpostoEmpregado(rs.getInt("idImpostoEmpregado"));
						imposto.setInss(rs.getDouble("inss"));
						imposto.setIrf(rs.getDouble("irf"));
						imposto.setMes(rs.getDate("mes"));
						imposto.setSalario(rs.getDouble("salario"));
						imposto.setTotal(rs.getDouble("total"));
						
						retorno.add(imposto);
					}
				}
			}
		}
		
		return retorno;
	}

	@Override
	public ArrayList<ImpostoEmpregado> selecionar(Empregado empregado) throws ClassNotFoundException, SQLException {
		ArrayList<ImpostoEmpregado> retorno = new ArrayList<>();
		ImpostoEmpregado imposto = null;
		
		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(selecionarEmpregado.toString())){
				ps.setInt(1, empregado.getId());
				
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						imposto = new ImpostoEmpregado();
						imposto.getContrato().setIdContrato(rs.getInt("idContrato"));
						imposto.setIdImpostoEmpregado(rs.getInt("idImpostoEmpregado"));
						imposto.setInss(rs.getDouble("inss"));
						imposto.setIrf(rs.getDouble("irf"));
						imposto.setMes(rs.getDate("mes"));
						imposto.setSalario(rs.getDouble("salario"));
						imposto.setTotal(rs.getDouble("total"));
						
						retorno.add(imposto);
					}
				}
			}
		}
		
		return retorno;
	}

	@Override
	public ArrayList<ImpostoEmpregado> selecionar(Empregado empregado,java.util.Date mes)
			throws ClassNotFoundException, SQLException {

		ArrayList<ImpostoEmpregado> retorno = new ArrayList<>();
		ImpostoEmpregado imposto = null;
		
		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(selecionarPorMes.toString())){
				
				ps.setInt(1, empregado.getId());
				ps.setDate(2, new Date(mes.getTime()));
				
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						imposto = new ImpostoEmpregado();
						imposto.getContrato().setIdContrato(rs.getInt("idContrato"));
						imposto.setIdImpostoEmpregado(rs.getInt("idImpostoEmpregado"));
						imposto.setInss(rs.getDouble("inss"));
						imposto.setIrf(rs.getDouble("irf"));
						imposto.setMes(rs.getDate("mes"));
						imposto.setSalario(rs.getDouble("salario"));
						imposto.setTotal(rs.getDouble("total"));
						
						retorno.add(imposto);
					}
				}
			}
		}
		
		return retorno;
	}

	@Override
	public ArrayList<ImpostoEmpregado> selecionar(Empregado empregado, String pesquisa)
			throws ClassNotFoundException, SQLException {
		ArrayList<ImpostoEmpregado> retorno = new ArrayList<>();
		ImpostoEmpregado imposto = null;
		
		try(Connection con = Conexao.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(selecionarPorPesquisa.toString())){
				
				ps.setInt(1, empregado.getId());
				ps.setString(2, pesquisa + "%");
				
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						imposto = new ImpostoEmpregado();
						imposto.getContrato().setIdContrato(rs.getInt("idContrato"));
						imposto.setIdImpostoEmpregado(rs.getInt("idImpostoEmpregado"));
						imposto.setInss(rs.getDouble("inss"));
						imposto.setIrf(rs.getDouble("irf"));
						imposto.setMes(rs.getDate("mes"));
						imposto.setSalario(rs.getDouble("salario"));
						imposto.setTotal(rs.getDouble("total"));
						
						retorno.add(imposto);
					}
				}
			}
		}
		
		return retorno;
	}

	

	
	

}

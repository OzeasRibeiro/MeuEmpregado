package br.com.facear.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import br.com.facear.dao.Conexao;
import br.com.facear.model.ImpostoEmpregado;
import br.com.facear.service.ImpostoEmpregadoService;

public class TesteDao {


	public void testarConexao() {

		try {
			Connection con = Conexao.getConnection();



		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testarCalculos() {

		new ImpostoEmpregadoService().calcularImpostos();

	}


	public void testeSelecionarMes() {

		ArrayList<ImpostoEmpregado> list;


		list = new ImpostoEmpregadoService().selecionar(1);
		for (ImpostoEmpregado impostoEmpregado : list) {
			System.out.println(impostoEmpregado.getMes());
		}


	}


	public void testeSelecionarPesquisa() {

		ArrayList<ImpostoEmpregado> list;


		list = new ImpostoEmpregadoService().selecionar(1);
		System.out.println(list.size());
		for (ImpostoEmpregado impostoEmpregado : list) {
			System.out.println(impostoEmpregado.getContrato().getEmpregador().getNome());


		}

	}
}

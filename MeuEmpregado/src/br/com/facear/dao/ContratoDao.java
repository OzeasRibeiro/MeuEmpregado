package br.com.facear.dao;

import java.util.ArrayList;

import br.com.facear.dao.interfaces.ContratoDaoInterface;
import br.com.facear.model.Contrato;
import br.com.facear.model.Empregado;
import br.com.facear.model.Empregador;

class ContratoDao implements ContratoDaoInterface{

	
	@Override
	public Integer cadastrar(Contrato obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void alterar(Contrato obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void excluir(Contrato obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Contrato selecionar(Integer id) {
		Empregado empregado = new Empregado(2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Empregador empregador = new Empregador(2, "Empregador", "000.000.000-00");
		return new Contrato(1, empregador, empregado, 1000, true);
	}
	@Override
	public ArrayList<Contrato> selecionar() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Contrato> selecionarContratosValidos() {
		ArrayList<Contrato> retorno = new  ArrayList<>();
		for(int i = 1; i<17; i++) {
			Empregado empregado = new Empregado(i, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			Empregador empregador = new Empregador(i, "Empregador", "000.000.000-00");
			retorno.add(new Contrato(i, empregador, empregado, 2000, true));
		}
		return retorno;
	}
	

}

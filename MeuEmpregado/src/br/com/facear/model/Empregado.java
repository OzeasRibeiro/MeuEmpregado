package br.com.facear.model;


import java.util.Date;


//Espa�o para anota��es. (Hibernate)
public class Empregado {
	
	//Espa�o para anota��es. (Hibernate)
	private Integer id;
	
	
	private String nomeCompleto;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String telefoneFixo;
	private String telefoneCelular;
	private String cep;
	private String enderecoRua;
	private Integer enderecoNumero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String email;
	private String senha;
	private Boolean ativo;
	private Boolean sexo; //1-Masculino 0-Feminino
	
	//Construtor vazio
	public Empregado() {
		
	}
	
	//Construtor para altera��o de dados. (Para buscar o registro que vai ser alterado, precisa do id do registro)
	public Empregado(Integer id, String nomeCompleto, Date dataNascimento, String cpf, String rg, String telefoneFixo,
			String telefoneCelular, String cep, String enderecoRua, Integer enderecoNumero, String complemento,
			String bairro, String cidade, String uf, String email, String senha, Boolean ativo, Boolean sexo) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.cep = cep;
		this.enderecoRua = enderecoRua;
		this.enderecoNumero = enderecoNumero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
		this.sexo = sexo;
	}
	
	//Construtor para inserir novos Empregados. (N�o h� necessidade de id por par�metro, pois a fun��o AUTO INCREMENT do banco de dados seta automaticamente o id do pr�ximo registro)
	public Empregado(String nomeCompleto, Date dataNascimento, String cpf, String rg, String telefoneFixo,
			String telefoneCelular, String cep, String enderecoRua, Integer enderecoNumero, String complemento,
			String bairro, String cidade, String uf, String email, String senha, Boolean ativo, Boolean sexo) {
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.cep = cep;
		this.enderecoRua = enderecoRua;
		this.enderecoNumero = enderecoNumero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
		this.sexo = sexo;
	}

	//M�todo toString
	@Override
	public String toString() {
		return "Empregado [id=" + id + ", nomeCompleto=" + nomeCompleto + ", dataNascimento=" + dataNascimento
				+ ", cpf=" + cpf + ", rg=" + rg + ", telefoneFixo=" + telefoneFixo + ", telefoneCelular="
				+ telefoneCelular + ", cep=" + cep + ", enderecoRua=" + enderecoRua + ", enderecoNumero="
				+ enderecoNumero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", uf=" + uf + ", email=" + email + ", senha=" + senha + ", ativo=" + ativo + ", sexo=" + sexo + "]";
	}
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEnderecoRua() {
		return enderecoRua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}

	public Integer getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(Integer enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}
}

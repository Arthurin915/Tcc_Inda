package br.edu.ifrs.canoas.lds.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String cep;
	private String email;
	private String cidade;
	private String uf;
	private String endereco;
	private int numero;
	private String senha;
	private String telefone;
	private String confirmar;
	
	public Usuario(){
		
	}
	public Usuario(Long id, String nome, String cep, String email, String cidade, String uf, String endereco,
			int numero, String senha, String telefone, String confirmar) {
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.email = email;
		this.cidade = cidade;
		this.uf = uf;
		this.endereco = endereco;
		this.numero = numero;
		this.senha = senha;
		this.telefone = telefone;
		this.confirmar = confirmar;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getConfSenha() {
		return confirmar;
	}
	public void setConfSenha(String confSenha) {
		this.confirmar = confSenha;
	}
	public String getConfirmar() {
		return confirmar;
	}
	public void setConfirmar(String confirmar) {
		this.confirmar = confirmar;
	}
		
}

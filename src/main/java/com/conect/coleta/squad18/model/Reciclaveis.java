package com.conect.coleta.squad18.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reciclaveis")
public class Reciclaveis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReciclavel;
	private String tipo;
	private String quantidade;
	
	@ManyToMany(mappedBy = "reciclaveis",fetch = FetchType.EAGER)
	private Set<Doadores> doadores = new HashSet<>();

	public Reciclaveis() {
		super();
	}

	public Reciclaveis(Long idReciclavel, String tipo, String quantidade, Set<Doadores> doadores) {
		super();
		this.idReciclavel = idReciclavel;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.doadores = doadores;
	}

	public Long getIdReciclavel() {
		return idReciclavel;
	}

	public void setIdReciclavel(Long idReciclavel) {
		this.idReciclavel = idReciclavel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Set<Doadores> getDoadores() {
		return doadores;
	}

	public void setDoadores(Set<Doadores> doadores) {
		this.doadores = doadores;
	}
	
}

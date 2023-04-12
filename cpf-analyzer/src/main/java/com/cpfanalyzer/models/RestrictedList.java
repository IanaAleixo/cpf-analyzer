package com.cpfanalyzer.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.validator.constraints.br.CPF;


@Entity
public class RestrictedList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
	
	@CPF
	@Column(unique=true)
	private String CPF;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;
	
	public RestrictedList() {
		super();
	}

	public RestrictedList(long id, String CPF, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.CPF = CPF;
		this.createdAt = createdAt;
	}
	
	public RestrictedList(long id) {
		super();
		this.id = id;
	}

	public RestrictedList(String CPF) {
		super();
		this.CPF = CPF;
	}

	public long getId() {
		return id;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = CPF;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "RestrictedList [id=" + id + ", CPF=" + CPF + ", createdAt=" + createdAt + "]";
	}
	
	
}
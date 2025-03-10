package com.jujutsu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pasiva")
public class Pasiva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pas")
	private Integer codigoPasiva;
	
	@Column(name = "nom_pas")
	private String nombrePasiva;
	
	@Column(name = "des_pas")
	private String descripcionPasiva;
	
	@Column(name = "img_pas")
	private String imagenPasiva;
	
	@ManyToOne
	@JoinColumn(name="cod_per")
	private Personaje personaje;
}

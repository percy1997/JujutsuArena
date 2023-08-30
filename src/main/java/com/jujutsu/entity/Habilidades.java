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
@Table(name = "habilidades")
public class Habilidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_hab")
	private Integer codigoHabilidad;
	
	@Column(name = "nom_hab")
	private String nombreHabilidad;
	
	@Column(name = "des_hab")
	private String descripcionHabilidad;
	
	@Column(name = "img_hab")
	private String imagenHabilidad;
	
	@ManyToOne
	@JoinColumn(name="cod_per")
	private Personaje personaje;
	
	
}

package com.jujutsu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="personaje")
public class Personaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_per")
	private Integer codigoPersonaje;
		
	@Column(name = "nom_per")
	private String nombrePersonaje;
	
	@Column(name = "des_per")
	private String descripcionPersonaje;
	
	@Column(name = "img_per")
	private String imagenPersonaje;

}

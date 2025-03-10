package com.jujutsu.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="grado")
public class Grado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_gra")
	private Integer codigoGrado;
		
	@Column(name = "des_gra")
	private String descripcionGrado;
	
	@OneToMany(mappedBy = "grado")
	@JsonIgnore
	List<Personaje> listaPersonajes;
}

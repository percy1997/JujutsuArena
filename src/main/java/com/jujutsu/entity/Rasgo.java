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
@Table(name="rasgo")
public class Rasgo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_ras")
	private Integer codigoRasgo;
		
	@Column(name = "des_ras")
	private String descripcionRasgo;
	
	@OneToMany(mappedBy = "rasgo")
	@JsonIgnore
	List<Personaje> listaPersonajes;
}

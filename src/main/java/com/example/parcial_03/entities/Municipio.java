package com.example.parcial_03.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_municipio")
public class Municipio {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer codigoMunicipio;
	private String nombre;
	@ManyToOne
	@JoinColumn(name="codigo_zona",nullable=false,
			foreignKey=@ForeignKey(name="FK_municipio_zona"))
	@JsonBackReference
	private Zona codigoZona;

}

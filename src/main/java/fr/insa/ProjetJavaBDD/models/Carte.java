package fr.insa.ProjetJavaBDD.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carte {
	private int Plafond;
	@Id
	@Size(min=16, max=16)
	private int NumeroCarte;
	private String MotDePasse;
	@ManyToOne 
	private Compte compte;
}

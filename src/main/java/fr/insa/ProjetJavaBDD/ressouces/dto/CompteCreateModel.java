package fr.insa.ProjetJavaBDD.ressouces.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompteCreateModel implements Serializable{

	private int agenceCode;
	private int num_Compte;
	private int solde;

}

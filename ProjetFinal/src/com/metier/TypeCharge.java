package com.metier;

public class TypeCharge {

	//D�claration des propri�t�s de la classe
	private int codeTypeCharge;
	private String libelleTypeCharge;
	private int puissanceTypeCharge;

	/***
	 * Premier constructeur d'un type de charge
	 * @param codeTypeCharge
	 * 						code du nouveau Type Charge
	 * @param libelleTypeCharge
	 * 						libelle du nouveau Type Charge
	 * @param puissanceTypeCharge
	 * 							puissance du nouveau Type Charge
	 */
	public TypeCharge(int codeTypeCharge, String libelleTypeCharge,
			int puissanceTypeCharge) {
		super();
		this.codeTypeCharge = codeTypeCharge;
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissanceTypeCharge = puissanceTypeCharge;
	}

	
	/**
	 * Deuxieme constructeur d'un type de charge
	 * @param libelleTypeCharge
	 * 						libelle du nouveau type charge
	 * @param puissanceTypeCharge
	 * 							puissance du nouveau type charge
	 */
	public TypeCharge(String libelleTypeCharge, int puissanceTypeCharge) {
		super();
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissanceTypeCharge = puissanceTypeCharge;
	}

	
	/**
	 * Accesseur sur le libelle d'un type de charge
	 * @return le libelle du type charge concernée
	 */
	public String getLibelleTypeCharge() {
		return libelleTypeCharge;
	}

	
	/**
	 * Modificateur sur le libelle d'un type de charge
	 * @param libelleTypeCharge
	 * 						nouveau libelle du type charge concerner
	 */
	public void setLibelleTypeCharge(String libelleTypeCharge) {
		this.libelleTypeCharge = libelleTypeCharge;
	}

	
	/**
	 * Accesseur sur la puissance d'un type de charge
	 * @return la puissance du type charge 
	 */
	public int getPuissanceTypeCharge() {
		return puissanceTypeCharge;
	}

	
	/**
	 * Modificateur sur la puissance d'un type de charge
	 * @param puissanceTypeCharge
	 * 							nouvelle puissance du type charge 
	 */
	public void setPuissanceTypeCharge(int puissanceTypeCharge) {
		this.puissanceTypeCharge = puissanceTypeCharge;
	}

	
	/**
	 * Accesseur sur le code du TypeCharge
	 * @return le code type charge de la borne 
	 */
	public int getCodeTypeCharge() {
		return codeTypeCharge;
	}

	/**
	 * M�thode toString permettant l'affichage des informations concernant un type de charge
	 * @return les information sur le type de charge
	 */
	@Override
	public String toString() {
		return "TypeCharge [codeTypeCharge=" + codeTypeCharge
				+ ", libelleTypeCharge=" + libelleTypeCharge
				+ ", puissanceTypeCharge=" + puissanceTypeCharge + "]";
	}

}
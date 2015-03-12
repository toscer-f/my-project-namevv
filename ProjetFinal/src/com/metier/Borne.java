package com.metier;


/**
 * 
 * @author ollivier-pl
 * 
 * ProjetFinal
 * 
 * @version 1.0
 * 
 * 
 */


public class Borne {
	//D�claration des propri�t�s de la classe
	private int idBorne;
	private String dateMiseEnService;
	private String etat;
	private TypeCharge typeCharge;
	private int idStation;
	
	/**
	 * 
	 * Premier constructeur de Borne avec 4 param�tres
	 * 
	 * @param idBorne
	 * 				id de la nouvelle borne
	 * @param dateMiseEnService
	 * 						date de mise en service de la nouvelle borne
	 * @param typeCharge
	 * 					type de charge de la nouvelle borne
	 * @param idStation
	 * 				id station de la nouvelle borne
	 * 
	 */
	
	public Borne(int idBorne, String dateMiseEnService, TypeCharge typeCharge, int idStation){
		super();
		this.idBorne = idBorne;
		this.dateMiseEnService = dateMiseEnService;
		this.etat="ES";
		this.typeCharge = typeCharge;
		this.idStation=idStation;
	}
	
	/**
	 * 
	 * Deuxi�me construteur de Borne avec 3 param�tres
	 * 
	 * @param dateMiseEnService
	 * 						date de mise en service de la nouvelle borne
	 * @param typeCharge
	 * 				type de charge de la nouvelle borne
	 * @param idStation
	 * 				id station de la nouvelle borne
	 */
	public Borne(String dateMiseEnService, TypeCharge typeCharge, int idStation) {
		super();
		this.dateMiseEnService = dateMiseEnService;
		this.etat = "ES";
		this.typeCharge = typeCharge;
		this.idStation=idStation;
	}
	
	
	/**
	 * M�thode toString permettant d'afficher les informations d'une borne
	 * @return les information sur la borne
	 */
	@Override
	public String toString() {
		return "Borne [idBorne=" + idBorne + ", dateMiseEnService="
				+ dateMiseEnService + ", etat=" + etat + ", typeCharge="
				+ typeCharge + "]";
	}
	
	
	/**
	 * Accesseur sur l'idStation de la borne
	 * 
	 * @return l'id de la station		
	 */
	public int getidStation(){
		return idStation;
	}
	
	
	/**
	 * Met � jour l'idStation de la Borne
	 * @param idStation
	 * 		Le nouvel idStation de la borne
	 */
	public void setIdStation(int idStation){
		this.idStation=idStation;
	}
	
	
	/**
	 * Accesseur sur la date de mise en service
	 * @return la date de mise en service de la borne
	 */
	public String getDateMiseEnService() {
		return dateMiseEnService;
	}
	
	
	/**
	 * Met � jour la date de mise en service
	 * @param dateMiseEnService
	 * 		la nouvelle date de mise en service
	 */
	public void setDateMiseEnService(String dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}
	
	/**
	 * Accesseur sur l'etat de la borne
	 * @return l'etat de la borne
	 */
	public String getEtat() {
		return etat;
	}
	
	/**
	 * Met � jour l'etat de la borne
	 * @param etat
	 * 		Le nouvel etat de la borne
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	/**
	 * Accesseur sur le type de charge de la borne
	 * @return l'objet typeCharge
	 */
	public TypeCharge getTypeCharge() {
		return typeCharge;
	}
	
	/**
	 * Met � jour le type de charge de la borne
	 * @param typeCharge
	 * 		Le nouveau TypeCharge de la Borne
	 */
	public void setTypeCharge(TypeCharge typeCharge) {
		this.typeCharge = typeCharge;
	}
	
	/**
	 * Accesseur sur l'id de la borne (identifiant)
	 * @return l'id de la Borne
	 */
	public int getIdBorne() {
		return idBorne;
	}


}

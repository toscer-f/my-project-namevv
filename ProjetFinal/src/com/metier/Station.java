package com.metier;

/**
 * @author toscer-f
 */
import java.util.ArrayList;

public class Station {
	private int idStation;
	private String libelleEmplacement;
	private ArrayList<Borne> lesBornes;

	/**
	 * Premier constructeur de Station avec 2 paramètres
	 *  
	 * @param idStation
	 * 		id de la nouvelle station
	 * @param libelleEmplacement
	 * 		libelle de la nouvelle station
	 */
	
	public Station(int idStation, String libelleEmplacement) {
		super();
		this.idStation = idStation;
		this.libelleEmplacement = libelleEmplacement;
		this.lesBornes = new ArrayList<Borne>();
	}
	
	/** 
	 * Deuxieme constructeur de Station avec 1 seul paramètre
	 * 
	 * @param libelleEmplacement
	 * 		le libelleEmplacement de la nouvelle station
	 */
	public Station(String libelleEmplacement) {
		super();
		this.libelleEmplacement = libelleEmplacement;
		this.lesBornes = new ArrayList<Borne>();
	}
	
	
	/**
	 *  Methode permettant d'afficher les informations d'une Station
	 */
	@Override
	public String toString() {
		return "Station [idStation=" + idStation + ", libelleEmplacement="
				+ libelleEmplacement + ", lesBornes=" + lesBornes + "]";
	}
	
	
	/**
	 * Acccesseur sur le libelle emplacement d'une station
	 * 
	 * @return le libelleEmplacement de la station
	 */
	public String getLibelleEmplacement() {
		return libelleEmplacement;
	}
	
	
	/**
	 *  Met à jour le libelle emplacement 
	 * @param libelleEmplacement
	 * 		Le nouveau libelleEmplacement de la station
	 */
	public void setLibelleEmplacement(String libelleEmplacement) {
		this.libelleEmplacement = libelleEmplacement;
	}
	
	/**
	 * Acesseur sur la liste de borne
	 * @return une liste de Bornes
	 */
	public ArrayList<Borne> getLesBornes() {
		return lesBornes;
	}
	
	
	/**
	 *  Met à jour la liste des bornes d'une station
	 *  @param lesBornes
	 *  	La nouvelle liste de bornes
	 */
	public void setLesBornes(ArrayList<Borne> lesBornes) {
		this.lesBornes = lesBornes;
	}
	
	
	/**
	 * Acesseur sur l'id de la station
	 * @return l'idStation
	 * 		
	 */
	public int getIdStation() {
		return idStation;
	}
}
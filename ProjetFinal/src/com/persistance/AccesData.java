package com.persistance;

import java.util.*;
import com.metier.*;

public class AccesData {

	public static TypeChargeDAO tcDAO;
	public static BorneDAO bDAO;
	public static StationDAO sDAO;

	
	/**
	 * Permet de récupérer la liste de tous les types de charge
	 * 
	 * @return une liste de typeCharge
	 */
	public static ArrayList<TypeCharge> getListeTypeCharge() {
		return getTypeChargeDAO().retrieve();
	}

	
	/**
	 * Permet de récupérer la liste de toutes les stations
	 * 
	 * @return une liste de stations
	 */
	public static ArrayList<Station> getListeStation() {
		return getStationDAO().retrieve();
	}

	
	/**
	 * Permet de récupérer la liste de toutes les bornes
	 * 
	 * @return une liste de bornes
	 */
	public static ArrayList<Borne> getListBorne() {
		return getBorneDAO().retrieve();
	}

	/**
	 * Permet de récupérer une liste de bornes à partir d'un idStation
	 * 
	 * @param idStation
	 * 		l'id d'une station dont on veut connaître les bornes
	 * @return une liste de bornes
	 */
	public static ArrayList<Borne> getBorneStation(int idStation) {
		return getBorneDAO().retrieve2(idStation);
	}

	
	/**
	 * Permet de récupérer un objet TypeCharge en fonction de son id
	 * 
	 * @param idType
	 * 		l'id d'un type de charge
	 * @return un objet TypeCharge
	 */
	public static TypeCharge getTypeCharge(int idType) {
		return getTypeChargeDAO().find(idType);
	}

	/**
	 * Permet de récupérer un objet Borne en fonction de son id
	 * 
	 * @param idBorne
	 * 		l'id d'une Borne
	 * @return un objet Borne
	 */
	public static Borne getBorne(int idBorne) {
		return getBorneDAO().find(idBorne);
	}

	/**
	 * Permet de récupérer un objet Station en fonction de son id
	 * 
	 * @param idStation
	 * 		l'id d'une Station
	 * @return un objet Station
	 */
	public static Station getStation(int idStation) {
		return getStationDAO().find(idStation);
	}

	
	/**
	 * Permet d'ajouter une Borne dans la base de données
	 * @param b
	 * 		l'objet Borne que l'on veut ajouter
	 * @return true si l'ajouté a marché, false si elle a échoué
	 */
	public static boolean addBorne(Borne b) {
		boolean result = getBorneDAO().create(b);
		return result;
	}
	
	
	/**
	 * Permet de supprimer une Borne dans la base de données
	 * 
	 * @param b
	 * 		l'objet Borne que l'on veut supprimer
	 * @return true si la suppression a marché, false si elle a échoué
	 */
	public static Boolean DeleteBorne(Borne b) {
		return getBorneDAO().delete(b);
	}

	/**
	 * Permet de mettre à jour une Borne dans la base de données
	 * 
	 * @param b
	 * 		l'objet Borne que l'on veut mettre à jour
	 * @return true si la mise à jour a marché, false si elle a échoué
	 */
	public static Boolean UpdateBorne(Borne b) {
		return getBorneDAO().update(b);
	}

	/**
	 * Permet d'ajouter une Station dans la base de données
	 * @param s
	 * 		l'objet Station que l'on veut ajouter
	 * @return true si l'ajouté a marché, false si elle a échoué
	 */
	public static Boolean AddStation(Station s) {
		return getStationDAO().create(s);
	}

	
	/**
	 * Permet de supprimer une Station dans la base de données
	 * 
	 * @param s
	 * 		l'objet Station que l'on veut supprimer
	 * @return true si la suppression a marché, false si elle a échoué
	 */
	public static Boolean DeleteStation(Station s) {
		return getStationDAO().delete(s);
	}

	
	/**
	 * Permet de mettre à jour une Station dans la base de données
	 * 
	 * @param s
	 * 		l'objet Station que l'on veut mettre à jour
	 * @return true si la mise à jour a marché, false si elle a échoué
	 */
	public static Boolean UpdateStation(Station s) {
		return getStationDAO().update(s);
	}

	
	/**
	 * Permet d'ajouter un TypeCharge dans la base de données
	 * @param t
	 * 		l'objet TypeCharge que l'on veut ajouter
	 * @return true si l'ajouté a marché, false si elle a échoué
	 */
	public static Boolean addTypeCharge(TypeCharge t) {
		boolean result = getTypeChargeDAO().create(t);
		return result;
	}

	/**
	 * Permet de supprimer un TypeCharge dans la base de données
	 * 
	 * @param t
	 * 		l'objet TypeCharge que l'on veut supprimer
	 * @return true si la suppression a marché, false si elle a échoué
	 */
	public static boolean deleteTypeCharge(TypeCharge t) {
		boolean resultat = getTypeChargeDAO().delete(t);
		return resultat;
	}

	/**
	 * Permet de mettre à jour une TypeCharge dans la base de données
	 * 
	 * @param t
	 * 		l'objet TypeCharge que l'on veut mettre à jour
	 * @return true si la mise à jour a marché, false si elle a échoué
	 */
	public static boolean updateTypeCharge(TypeCharge t) {
		boolean resultat = getTypeChargeDAO().update(t);
		return resultat;
	}
	
	/**
	 * Permet de récupérer un objet BorneDAO 
	 * 
	 * @return un objet BorneDAO
	 */
	private static BorneDAO getBorneDAO() {
		bDAO = new BorneDAO();
		return bDAO;
	}

	
	/**
	 * Permet de récupérer un objet TypeChargeDAO 
	 * 
	 * @return un objet TypeChargeDAO
	 */
	private static TypeChargeDAO getTypeChargeDAO() {
		tcDAO = new TypeChargeDAO();
		return tcDAO;
	}

	
	/**
	 * Permet de récupérer un objet StationDAO 
	 * 
	 * @return un objet StationDAO
	 */	
	private static StationDAO getStationDAO() {
		sDAO = new StationDAO();
		return sDAO;
	}

	

	
}

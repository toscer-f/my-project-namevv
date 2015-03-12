package com.persistance;

import java.sql.Connection;
import java.util.*;
//classe DAO generique indiquée par DAO<T>
	public abstract class DAO<T> {
	   public Connection cnx=null;
	   
	   /**
	    * Constructeur  de la classe DAO
	    * 
	    * Connexion à la base de données
	    */
	   public DAO(){
	      this.cnx = AccesBd.getInstance("DSN-PierreLouisOllivier");
	   }
	   
	   
	   /**
	    * Méthode de création d'un objet
	    * 
	    * @param obj
	    * 		objet que l'on veut créer
	    * @return true si l'ajout a fonctionné, false si il a échoué 
	    * 
	    */
	   public abstract boolean create(T obj);
	   /**
	    * Méthode pour effacer
	    * @param obj
	    * @return boolean 
	    */
	   
	   /**
	    * Méthode de suppression d'un objet
	    * 
	    * @param obj
	    * 		objet que l'on veut supprimer
	    * @return true si la suppression a fonctionné, false si elle a échoué
	    */
	   public abstract boolean delete(T obj);
	   
	   
	   /**
	    * Méthode de mise à jour d'un objet
	    * 
	    * @param obj
	    * 		objet que l'on veut mettre à jour
	    * @return true si la mise à jour a fonctionné, false si elle a échoué
	    */
	   public abstract boolean update(T obj);
	   
	   
	   /**
	    * Permet de rechercher un ou plusieurs objet(s) dans une liste
	    * 
	    * @param id
	    * 		id de l'objet que l'on veut chercher
	    * @return une liste d'objet qui ont l'id recherché
	    * 		
	    */
	   public abstract T find(int id);
	   
	   
	   /**
	    * Permet de récupérer une liste d'objet
	    * 
	    * @return une liste d'objet
	    */
	   public abstract ArrayList<T> retrieve();
	}
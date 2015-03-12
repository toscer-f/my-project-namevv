package com.persistance;

import java.sql.Connection;
import java.util.*;
//classe DAO generique indiqu�e par DAO<T>
	public abstract class DAO<T> {
	   public Connection cnx=null;
	   
	   /**
	    * Constructeur  de la classe DAO
	    * 
	    * Connexion � la base de donn�es
	    */
	   public DAO(){
	      this.cnx = AccesBd.getInstance("DSN-PierreLouisOllivier");
	   }
	   
	   
	   /**
	    * M�thode de cr�ation d'un objet
	    * 
	    * @param obj
	    * 		objet que l'on veut cr�er
	    * @return true si l'ajout a fonctionn�, false si il a �chou� 
	    * 
	    */
	   public abstract boolean create(T obj);
	   /**
	    * M�thode pour effacer
	    * @param obj
	    * @return boolean 
	    */
	   
	   /**
	    * M�thode de suppression d'un objet
	    * 
	    * @param obj
	    * 		objet que l'on veut supprimer
	    * @return true si la suppression a fonctionn�, false si elle a �chou�
	    */
	   public abstract boolean delete(T obj);
	   
	   
	   /**
	    * M�thode de mise � jour d'un objet
	    * 
	    * @param obj
	    * 		objet que l'on veut mettre � jour
	    * @return true si la mise � jour a fonctionn�, false si elle a �chou�
	    */
	   public abstract boolean update(T obj);
	   
	   
	   /**
	    * Permet de rechercher un ou plusieurs objet(s) dans une liste
	    * 
	    * @param id
	    * 		id de l'objet que l'on veut chercher
	    * @return une liste d'objet qui ont l'id recherch�
	    * 		
	    */
	   public abstract T find(int id);
	   
	   
	   /**
	    * Permet de r�cup�rer une liste d'objet
	    * 
	    * @return une liste d'objet
	    */
	   public abstract ArrayList<T> retrieve();
	}
package com.persistance;

import java.util.ArrayList;

import com.metier.*;

import java.sql.*;

public class StationDAO extends DAO<Station> {

	public StationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permet d'ajouter une Station dans la base de données
	 * 
	 * @param obj
	 *            l'objet station que l'on veut ajouter à la base
	 * @return true si l'ajout a fonctionné, false si il a échoué
	 */
	@Override
	public boolean create(Station obj) {
		String emplacement = obj.getLibelleEmplacement();
		boolean result;
		try {
			Statement requete = this.cnx.createStatement();
			requete.executeUpdate("insert into Station (libelleEmplacement) values ('"
					+ emplacement + "');");
			result = true;
			this.retrieve();
		} catch (SQLException e) {
			System.out.println("Problème d'accès à la base !");
			result = false;
		}
		return result;
	}

	/**
	 * Permet de supprimer une Station dans la base de données
	 * 
	 * @param obj
	 *            l'objet station que l'on veut supprimer dans la base
	 * @return true si la suppression a fonctionné, false si elle a échoué
	 */
	@Override
	public boolean delete(Station obj) {
		int idStation = obj.getIdStation();
		boolean result;
		try {
			Statement requete = this.cnx.createStatement();
			requete.executeUpdate("delete from Station where idStation= "
					+ idStation + ";");
			result = true;
			this.retrieve();
		} catch (SQLException e) {
			System.out.println("Problème d'accès à la base !");
			result = false;
		}
		return result;
	}

	/**
	 * Permet de mettre à jour une Station dans la base de données
	 * 
	 * @param obj
	 *            l'objet station que l'on veut mettre à jour dans la base
	 * @return true si la mise à jour a fonctionné, false si elle a échoué
	 */
	@Override
	public boolean update(Station obj) {
		int idStation = obj.getIdStation();
		String libelleEmplacement = obj.getLibelleEmplacement();
		boolean result;
		try {
			Statement requete = this.cnx.createStatement();
			requete.executeUpdate("Update Station set libelleEmplacement = '"
					+ libelleEmplacement + "' where idStation = " + idStation
					+ ";");
			result = true;
			this.retrieve();
		} catch (SQLException e) {
			System.out.println("Problème d'accès à la base !");
			result = false;
		}
		return result;
	}

	/**
	 * Permet de récupérer un objet Station à partir de la base de données, en fonction de son id
	 * 
	 * @param id
	 *            l'id de la station que l'on veut récupérer
	 * @return s l'objet Station trouvé
	 */
	@Override
	public Station find(int id) {
		Station s = null;

		int idStation;
		String libelle;

		BorneDAO b;
		b = new BorneDAO();

		String sql = "select* from Station where idStation=" + id;

		ResultSet rs;

		try {
			rs = this.cnx.createStatement().executeQuery(sql);
			while (rs.next()) {
				idStation = rs.getInt(1);
				libelle = rs.getString(2);

				s = new Station(idStation, libelle);
				s.setLesBornes(b.retrieve2(idStation));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return s;
	}

	/**
	 * Permet de récupérer un liste de stations situées de la base de données
	 * 
	 * @return la liste des stations
	 */
	@Override
	public ArrayList<Station> retrieve() {
		ArrayList<Station> Stations = new ArrayList<Station>();
		Station s = null;
		Statement req;
		ResultSet resultat;
		try {
			req = this.cnx.createStatement();
			resultat = req.executeQuery("select idStation from Station;");
			while (resultat.next()) {
				int idStation = resultat.getInt(1);
				s = find(idStation);
				Stations.add(s);
			}

		} catch (SQLException e) {
			System.out.println("Problème d'accès à la base !");
			System.out.println(e);
		}
		return Stations;
	}

}
package com.persistance;

import java.sql.*;

//classe permettant l'ouverture, la fermeture d'une base et le retour du statement
public class AccesBd {
	// description des propri�t�s
	private static Connection con = null;
	private static String url;

	
	/**
	 * Constructeur de la connexion � la base de donn�es
	 * @param nomdsn
	 * 		le nom de la DSN access
	 */
	public static Connection getInstance(String nomdsn) {
		url = "jdbc:odbc:" + nomdsn;
		if (con == null) {
			try {// chargement du driver
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection(url, "", "");
			}
			// ouverture de la connexion
			catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("�chec driver");
			}

			catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("�chec de connexion bd ");
			}
		}
		return con;
	}

	
	/**
	 * Permet la fermeture de la connexion 
	 */
	public static void close() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("probl�me lors de la fermeture");
		}
	}
}
package com.persistance;
import java.util.ArrayList;

import com.metier.*;

import java.sql.*;
public class BorneDAO extends DAO<Borne> {

	public BorneDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Permet d'ajouter un enregistrement dans la base
	 * 
	 * @param borne
	 * 			l'objet borne à cree dans la base
	 * @return true si l'ajout à été effectuer flase sinon 
	 */

	@Override
	public boolean create(Borne obj) {
		String sql="insert into Borne(dateMiseEnService,idStation,idTypeRecharge) Values('"+obj.getDateMiseEnService()+"',"+obj.getidStation()+","+obj.getTypeCharge().getCodeTypeCharge()+");";
		
		boolean result = false;
		
		try{
			cnx.createStatement().executeUpdate(sql);
			result=true;
		}
		catch(SQLException e){
			System.out.println("probleme create");
		}
		this.retrieve();
		return result;
	}
	
	/**
	 * Permet de supprimer une borne de la base de donnée
	 * @param borne
	 * 			objet borne à suprimer de la base de donnée
	 * 
	 * @return true si l'ajout à été effectuer flase sinon 
	 */
	@Override
	public boolean delete(Borne obj) {
		String sql="delete from Borne where idBorne="+obj.getIdBorne()+";";
		
		boolean result = false;
		try{
			cnx.createStatement().executeUpdate(sql);
			result=true;
		}
		catch(SQLException e){
			System.out.println("probleme delete");
		}
		this.retrieve();
		return result;	
	}

	@Override
	/**
	 * Permet de metre à jour les information d'une borne
	 * @param borne
	 * 			objet borne à mettre à jour dans la base de donnée
	 * 
	 * @return true si l'ajout à été effectuer flase sinon 
	 */
	public boolean update(Borne obj) {
		String sql="Update Borne set dateMiseEnService='"+obj.getDateMiseEnService()+"',idStation="+obj.getidStation()+",idTypeRecharge="+obj.getTypeCharge().getCodeTypeCharge()+" where idBorne="+obj.getIdBorne()+";";
		boolean result = false;
		
		try{
			cnx.createStatement().executeUpdate(sql);
			result=true;
		}
		catch(SQLException e){
			System.out.println("probleme update");
		}
		this.retrieve();
		return result;
	}

	@Override
	/**
	 *  retourne une borne grace à sont id
	 *  @param id
	 *  		id de la borne à retourner
	 *  @return un objet borne 
	 *  			
	 */
	public Borne find(int id) {
		Borne b = null;
		
		int idBorne;
		String date;
		int idType;
		int idStation;
		
		TypeChargeDAO t;
		t= new TypeChargeDAO();
		
		String sql ="select * from Borne where idBorne="+id;
		
		ResultSet rs;
		
		try{
			rs = this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				idBorne = rs.getInt(1);
				date=rs.getString(2);
				idType=rs.getInt(4);
				idStation=rs.getInt(3);
				
				b=new Borne(idBorne,date,t.find(idType),idStation);
			}
		}catch(SQLException e){
        	e.printStackTrace();
		}
	return b;
	}

	@Override
	/**
	 * Permet de recuprer toutes les bornes de la base de donnée
	 * @return une collection d'objet borne
	 */
	public ArrayList<Borne> retrieve() {
		Borne b =null;
		ArrayList<Borne> lesBornes = new ArrayList<Borne>();
		int idBorne;
		String date;
		TypeCharge t;
		int idStation;
		TypeChargeDAO typeCharge = new TypeChargeDAO();
		String sql;
		sql="select * from Borne;";
		
		ResultSet rs;
		
		try{
			rs= this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				idBorne=rs.getInt(1);
				date = rs.getString(2);
				t=typeCharge.find(rs.getInt(4));
				idStation=rs.getInt(3);
				b=new Borne(idBorne,date,t,idStation);
				lesBornes.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
        	
        }
		return lesBornes;
		}
	
	/**
	 * Permet de recuprer les bornes de la base de donnée
	 * @param idStation
	 * 				id de la station dont on veut recuperer les borne
	 * 
	 * @return une collection d'objet borne
	 */
	
	public ArrayList<Borne> retrieve2(int idStation){
		Borne b =null;
		ArrayList<Borne> lesBornes = new ArrayList<Borne>();
		int idBorne;
		String date;
		TypeCharge t;
		TypeChargeDAO typeCharge = new TypeChargeDAO();
		String sql;
		sql="select * from Borne where idStation="+idStation;
		
		ResultSet rs;
		
		try{
			rs= this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				idBorne=rs.getInt(1);
				date = rs.getString(2);
				t=typeCharge.find(rs.getInt(4));
				b=new Borne(idBorne,date,t,idStation);
				lesBornes.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
        	
        }
		return lesBornes;
	}
	
}


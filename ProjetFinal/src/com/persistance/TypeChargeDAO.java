package com.persistance;
import java.util.ArrayList;

import com.metier.*;

import java.sql.*;
public class TypeChargeDAO extends DAO<TypeCharge> {

	public TypeChargeDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Permet d'ajouter un Type de charge dans la base de donn�es
	 * 
	 * @param obj
	 *            l'objet Type charge que l'on veut ajouter � la base
	 * @return true si l'ajout a fonctionn�, false si il a �chou�
	 */

	@Override
	public boolean create(TypeCharge obj) {
		String sql="insert into TypeRecharge(libelleType,puissance) Values('"+obj.getLibelleTypeCharge()+"',"+obj.getPuissanceTypeCharge()+");";
	
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
	 * Permet de supprimer un type charge dans la base de donn�es
	 * 
	 * @param obj
	 *            l'objet type charge que l'on veut supprimer dans la base
	 * @return true si la suppression a fonctionn�, false si elle a �chou�
	 */

	@Override
	public boolean delete(TypeCharge obj) {
		String sql="delete from TypeRecharge where idTypeRecharge="+obj.getCodeTypeCharge()+";";
		
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
	
	/**
	 * Permet de mettre � jour un type charge dans la base de donn�es
	 * 
	 * @param obj
	 *            l'objet Type charge que l'on veut mettre � jour dans la base
	 * @return true si la mise � jour a fonctionn�, false si elle a �chou�
	 */

	@Override
	public boolean update(TypeCharge obj) {
		String sql="Update TypeRecharge set libelleType = '"+obj.getLibelleTypeCharge()+"' , puissance= "+obj.getPuissanceTypeCharge()+" where idTypeRecharge= "+obj.getCodeTypeCharge()+";";
		
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
	
	/**
	 * Permet de r�cup�rer un objet type charge � partir de la base de donn�es, en fonction de son id
	 * 
	 * @param id
	 *            l'id de la Type Charge que l'on veut r�cup�rer
	 * @return  l'objet Type Charge trouv�
	 */

	@Override
	public TypeCharge find(int id) {
		TypeCharge t =null;
		
		int codeType;
        String libelle;
        int puissance;
		
        String sql;
        sql="select * from TypeRecharge where idTypeRecharge="+id;
        
        ResultSet rs;
        
        try{
        	rs = this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				codeType = rs.getInt(1);
				libelle=rs.getString(2);
				puissance = rs.getInt(3);
				
				t = new TypeCharge(codeType,libelle,puissance);
			}
			}catch(SQLException e){
	        	e.printStackTrace();
	        	
	        }
			return t;
	}
	
	/**
	 * Permet de r�cup�rer un liste de Type Charge situ�es de la base de donn�es
	 * 
	 * @return la liste de Type Charge
	 */

	@Override
	public ArrayList<TypeCharge> retrieve() {
		
		TypeCharge t = null;
		
		ArrayList<TypeCharge> lesTypes = new ArrayList<TypeCharge>();
        int codeType;
        String libelle;
        int puissance;

        String sql;
        sql = "select * from TypeRecharge;";

        ResultSet rs;
        
        try{
        	rs = this.cnx.createStatement().executeQuery(sql);
			while(rs.next())
			{
				codeType = rs.getInt(1);
				libelle=rs.getString(2);
				puissance = rs.getInt(3);
				t = new TypeCharge(codeType,libelle,puissance);
				lesTypes.add(t);
			}
			
        }catch(SQLException e){
        	e.printStackTrace();
        	
        }
        return lesTypes;
        
	}
	
}

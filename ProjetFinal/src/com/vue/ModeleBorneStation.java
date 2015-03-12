package com.vue;
import java.util.*;

import com.metier.*;
import com.persistance.*;

import javax.swing.table.AbstractTableModel;

public class ModeleBorneStation extends AbstractTableModel {

	private String[] enetetes={"idBorne","dateMiseService","libelleType","puissance"};
	private ArrayList<Borne>listeBorne;
	
	
	public ModeleBorneStation(ArrayList<Borne>listeBorne) {
		
		this.listeBorne=listeBorne;
	}


	/**
	 * retourne la taille de la liste
	 * 
	 * @return retourne la taille de la liste
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeBorne.size();
	}

	/**
	 * retourne la longueur du tableau
	 * 
	 * @return la longueur du tableau
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return enetetes.length;
	}
	
	/**
	 * recupère le contenu de la colone en fonction de son index
	 * 
	 * @param colum
	 * 			index de la colonne
	 * @return le contenu de la colonne , ici une chaine 
	 */

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return enetetes[column];
	}

	/**
	 * retourne les elements du tableau en fonction de leurs index de ligne et colonne
	 * @param rowIndex
	 * 				index de la ligne
	 * @param columnIndex
	 * 					index de la colonne
	 * 
	 * @return retourne les elements du tableau en fonction de leurs index de ligne et colonne
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return listeBorne.get(rowIndex).getIdBorne();
		
		case 1:
			return listeBorne.get(rowIndex).getDateMiseEnService();
			
		case 2:
			return listeBorne.get(rowIndex).getTypeCharge().getLibelleTypeCharge();
			
		case 3:
			return listeBorne.get(rowIndex).getTypeCharge().getPuissanceTypeCharge();
		
		default:
			throw new IllegalArgumentException();
		}
	}

}

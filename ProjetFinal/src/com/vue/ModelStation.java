package com.vue;
import com.metier.*;
import com.persistance.*;

import java.util.*;

import javax.swing.table.AbstractTableModel;

public class ModelStation extends AbstractTableModel {

	
	private ArrayList<Station> listeStation;
	private String[] entete = { "idStation","emplacement","nombre bornes"};
	
	@Override
	public String getColumnName(int index) {
		// TODO Auto-generated method stub
		return entete[index];
	}

	public ModelStation() {
		// TODO Auto-generated constructor stub
		listeStation= AccesData.getListeStation();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entete.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeStation.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex){
		case 0 :
			return listeStation.get(rowIndex).getIdStation();
			
		case 1 : 
			return listeStation.get(rowIndex).getLibelleEmplacement();
			
		case 2 :
			return listeStation.get(rowIndex).getLesBornes().size();
			
		default :
			throw new IllegalArgumentException();			
		}
	}

}

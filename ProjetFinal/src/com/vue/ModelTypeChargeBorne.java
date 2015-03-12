package com.vue;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.metier.Borne;
import com.metier.*;
import com.persistance.AccesData;

public class ModelTypeChargeBorne extends AbstractTableModel {
	
	private String[] entetes={"idBorne","date mise en service","libelle emplacement","puissance"};
	private ArrayList<Borne> listeBorne;
	private ArrayList<Station> listeStation= AccesData.getListeStation();

	public ModelTypeChargeBorne(ArrayList<Borne> listeBorne) {
		// TODO Auto-generated constructor stub
		this.listeBorne=listeBorne;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return entetes[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeBorne.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return listeBorne.get(rowIndex).getIdBorne();
		
		case 1:
			return listeBorne.get(rowIndex).getDateMiseEnService();
			
		case 2:
			return listeStation.get(listeBorne.get(rowIndex).getidStation()).getLibelleEmplacement();
			
		case 3:
			return listeBorne.get(rowIndex).getTypeCharge().getPuissanceTypeCharge();
		
		default:
			throw new IllegalArgumentException();
		}
	}

}

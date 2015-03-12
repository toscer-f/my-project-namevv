package com.vue;

import javax.swing.table.AbstractTableModel;

import com.metier.*;
import com.persistance.*;

import java.util.*;

public class ModeleData extends AbstractTableModel {
	
	private String[] enetetes={"idStation","emplacement","Nombre de bornes"};
	private ArrayList<Station>listeStation;

	public ModeleData() {
		listeStation=AccesData.getListeStation();
		System.out.println(listeStation.size());
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return enetetes[column];
	}

	@Override
	public int getColumnCount() {
		
		return enetetes.length;
	}

	@Override
	public int getRowCount() {
		return listeStation.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listeStation.get(rowIndex).getIdStation();
		
		case 1:
			return listeStation.get(rowIndex).getLibelleEmplacement();
			
		case 2:
			return listeStation.get(rowIndex).getLesBornes().size();
		
		default:
			throw new IllegalArgumentException();
		}
	}

}

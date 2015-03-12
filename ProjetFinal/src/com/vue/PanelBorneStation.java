package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.util.*;

import com.metier.*;
import com.persistance.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBorneStation extends JPanel {
	private JLabel lblStation;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboBox;
	private ModeleBorneStation modele;
	private ArrayList<Station>ListeStation;
	private JLabel lblNombresDeStations;
	private JLabel lblNombreDeBornes;
	private JLabel lblNbStation;
	private JLabel lblNbBorne;

	/**
	 * Create the panel.
	 */
	public PanelBorneStation() {
		
		setLayout(null);
		modele=null;
		ListeStation=AccesData.getListeStation();
		add(getLblStation());
		add(getScrollPane());
		add(getComboBox());
		add(getLblNombresDeStations());
		add(getLblNombreDeBornes());
		add(getLblNbStation());
		add(getLblNbBorne());
	}
	public JLabel getLblStation() {
		if (lblStation == null) {
			lblStation = new JLabel("Station");
			lblStation.setBounds(60, 26, 114, 14);
		}
		return lblStation;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 89, 430, 161);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable(modele);
		}
		return table;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			
			for(Station s:ListeStation)
			{
				comboBox.addItem(s.getLibelleEmplacement());
			}
			
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(comboBox.getSelectedIndex()!=-1)
					{
						modele=new ModeleBorneStation(ListeStation.get(comboBox.getSelectedIndex()).getLesBornes());
						table.setModel(modele);
					}
				}
			});
			comboBox.setBounds(235, 23, 140, 17);
			comboBox.setSelectedIndex(0);
			
			
		}
		
		return comboBox;
	}
	public JLabel getLblNombresDeStations() {
		if (lblNombresDeStations == null) {
			lblNombresDeStations = new JLabel("Nombres de stations :");
			lblNombresDeStations.setBounds(25, 53, 114, 14);
		}
		return lblNombresDeStations;
	}
	public JLabel getLblNombreDeBornes() {
		if (lblNombreDeBornes == null) {
			lblNombreDeBornes = new JLabel("Nombre de bornes :");
			lblNombreDeBornes.setBounds(219, 51, 114, 14);
		}
		return lblNombreDeBornes;
	}
	public JLabel getLblNbStation() {
		if (lblNbStation == null) {
			lblNbStation = new JLabel("");
			lblNbStation.setBounds(142, 53, 46, 14);
		}
		return lblNbStation;
	}
	public JLabel getLblNbBorne() {
		if (lblNbBorne == null) {
			lblNbBorne = new JLabel("");
			lblNbBorne.setBounds(318, 51, 46, 14);
		}
		return lblNbBorne;
	}
	
	public void setIndex(int i)
	{
		comboBox.setSelectedIndex(i);;
	}
}

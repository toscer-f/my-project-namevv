package com.vue;

import com.metier.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.*;

import com.persistance.AccesData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTypeChargeBorne extends JPanel {
	private JLabel lblTypeCharge;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboBox;	
	private ModelTypeChargeBorne modele;	
	
	private ArrayList<TypeCharge> listeTc = AccesData.getListeTypeCharge();	

	/**
	 * Create the panel.
	 */
	public PanelTypeChargeBorne() {
		setLayout(null);
		modele = null;
		add(getLblTypeCharge());
		add(getScrollPane());
		add(getCbxTypeCharge());		

	}
	private JLabel getLblTypeCharge() {
		if (lblTypeCharge == null) {
			lblTypeCharge = new JLabel("Type de charge");
			lblTypeCharge.setBounds(41, 48, 108, 14);
		}
		return lblTypeCharge;
	}
	private JComboBox getCbxTypeCharge() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedIndex()!=-1)
					{
						modele=new ModelTypeChargeBorne(getBorneTC(comboBox.getSelectedItem().toString()));
						table.setModel(modele);
					}
				}
			});
			
			for(TypeCharge tc:listeTc)
			{
				comboBox.addItem(tc.getLibelleTypeCharge());
			}
			
			comboBox.setBounds(389, 45, 158, 20);
		}
		return comboBox;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(79, 133, 507, 223);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable(modele);
		}
		return table;
	}
	
	private ArrayList<Borne> getBorneTC(String libelleTc)
	{
		ArrayList<Borne> listeBorneTC= new ArrayList<Borne>();
		ArrayList<Borne> listeBorne= AccesData.getListBorne();
		
		for(Borne b : listeBorne)
		{
			if(b.getTypeCharge().getLibelleTypeCharge().equals(libelleTc))
			{
				listeBorneTC.add(b);
			}
		}
		return listeBorneTC;
	}
	
	
}

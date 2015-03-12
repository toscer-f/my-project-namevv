package com.vue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.*;

import com.metier.*;
import com.persistance.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAjoutBorne extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox cbxStation;
	private JComboBox cbxTypeCharge;
	private JTextField textField;
	private JButton btnAnnuler;
	private JButton btnValider;
	private ArrayList<Station>listeStation;
	private ArrayList<TypeCharge>listeTypeCharge;

	/**
	 * Create the panel.
	 */
	public PanelAjoutBorne() {
		setLayout(null);
		listeStation=AccesData.getListeStation();
		listeTypeCharge=AccesData.getListeTypeCharge();
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getCbxStation());
		add(getCbxTypeCharge());
		add(getTextField());
		add(getBtnAnnuler());
		add(getBtnValider());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Station");
			lblNewLabel.setBounds(27, 45, 79, 24);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Type de charge");
			lblNewLabel_1.setBounds(29, 92, 89, 14);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Date de mise en service jj/mm/aaaa");
			lblNewLabel_2.setBounds(29, 135, 177, 14);
		}
		return lblNewLabel_2;
	}
	public JComboBox getCbxStation() {
		if (cbxStation == null) {
			cbxStation = new JComboBox();
			
			for(Station s:listeStation)
			{
				cbxStation.addItem(s.getLibelleEmplacement());
			}
			
			cbxStation.setBounds(218, 47, 148, 22);
		}
		return cbxStation;
	}
	public JComboBox getCbxTypeCharge() {
		if (cbxTypeCharge == null) {
			cbxTypeCharge = new JComboBox();
			
			for(TypeCharge t:listeTypeCharge)
			{
				cbxTypeCharge.addItem(t.getLibelleTypeCharge());
			}
			cbxTypeCharge.setBounds(218, 89, 148, 17);
		}
		return cbxTypeCharge;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();			
			textField.setBounds(222, 132, 86, 20);
			textField.setColumns(10);
		}	
		return textField;
	}
	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cbxStation.setSelectedIndex(0);
					cbxTypeCharge.setSelectedIndex(0);
					textField.setText("");
				}
			});
			
			btnAnnuler.setBounds(173, 213, 89, 23);
		}
		return btnAnnuler;
	}
	public JButton getBtnValider() {
		
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Borne b;
					AccesData a=new AccesData();
					TypeCharge t=listeTypeCharge.get(cbxTypeCharge.getSelectedIndex());
					
					String dateMiseService=textField.getText();
					if(controleDate(dateMiseService)==true)
					{					
						b=new Borne(dateMiseService,t,listeStation.get(cbxStation.getSelectedIndex()).getIdStation());
						a.addBorne(b);
						AfficherMessage("Ajout effectué");
					}
					else
					{
						AfficherMessage("Date incorrecte");
					}				
				}
			});
			btnValider.setBounds(310, 213, 89, 23);
		}
		return btnValider;
	}
	
	public Boolean controleDate(String date)
	{
		Boolean ok;
		if(date.length()==10)
		{
		int amin=1000;
		int amax=2999;
		int j=Integer.parseInt(date.substring(0,2));
		int m=Integer.parseInt(date.substring(3,5));
		int a=Integer.parseInt(date.substring(6));
		ok=true;
		if ( ((j<1)||(j>31)) && (ok==true) ) {
	        ok=false;
	      }
	      if ( ((m<1)||(m>12)) && (ok==true) ) {
	        ok=false;
	      }
	      if ( (a<amin)||(a>amax) && (ok==true) ) {
	         ok=false;
	      }       	   
		}
		else
		{
			ok =false;
		}
		return ok;
	}
	
	public void AfficherMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
}

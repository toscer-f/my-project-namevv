package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormStation extends JFrame {

	private JPanel FormStation;

	
	/**
	 * Lancer l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormStation frame = new FormStation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Cree la fenetre principale (cadre).
	 */
	public FormStation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Affichage Stations");	
		setBounds(100, 100, 747, 399);
		this.FormStation = new PanelStation();
		this.FormStation.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.FormStation.setLayout(new BorderLayout(0, 0));
		setContentPane(this.FormStation);
	}

}

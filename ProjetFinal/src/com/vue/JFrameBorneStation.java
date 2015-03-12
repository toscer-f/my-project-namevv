package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameBorneStation extends JFrame {

	private JPanel contentPane;

	/**
	 * Lancer l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameBorneStation frame = new JFrameBorneStation();
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
	public JFrameBorneStation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Consultation bornes par station");	
		setBounds(100, 100, 666, 423);		
		this.contentPane = new PanelBorneStation();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
	}

}

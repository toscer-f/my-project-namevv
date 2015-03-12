package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameAjoutBorne extends JFrame {

	private JPanel contentPane;

	/**
	 * Lancer l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAjoutBorne frame = new JFrameAjoutBorne();
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
	public JFrameAjoutBorne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ajout Borne à une station");
		setBounds(100, 100, 706, 471);
		this.contentPane = new PanelAjoutBorne();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
	}

}

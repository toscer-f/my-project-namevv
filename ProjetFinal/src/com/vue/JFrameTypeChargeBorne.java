package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameTypeChargeBorne extends JFrame {

	private PanelTypeChargeBorne contentPane;

	/**
	 * Lance l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTypeChargeBorne frame = new JFrameTypeChargeBorne();
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
	public JFrameTypeChargeBorne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bornes par type de charge");
		setBounds(100, 100, 782, 458);
		this.contentPane = new PanelTypeChargeBorne();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
	}

}

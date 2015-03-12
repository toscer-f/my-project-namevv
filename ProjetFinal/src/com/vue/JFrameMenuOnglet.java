package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JFrameMenuOnglet extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private PanelStation panelLstStation;
	private PanelBorneStation panelConsultation;
	private PanelAjoutBorne panelAjoutBorne;	

	/**
	 * Lancer l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMenuOnglet frame = new JFrameMenuOnglet();
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
	public JFrameMenuOnglet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 419);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.contentPane.add(getTabbedPane());
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			panelConsultation = new PanelBorneStation();
			tabbedPane.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if(tabbedPane.getSelectedIndex()==1)
					{
						System.out.println("ok");
						panelConsultation.setIndex(0);
					}
				}
			});
			tabbedPane.setBounds(5, 5, 540, 365);
			tabbedPane.addTab("Liste stations", null, getPanelLstStation(), null);
			
			tabbedPane.addTab("Consultation bornes par station", null, getPanelConsultation(), null);
			tabbedPane.addTab("Ajout borne station", null, getPanel_1(), null);
		}
		return tabbedPane;
	}
	
	
	private PanelStation getPanelLstStation() {
		if (panelLstStation == null) {
			panelLstStation = new PanelStation();
			panelLstStation.setToolTipText("");
		}
		
		return panelLstStation;
	}
	
	
	private PanelBorneStation getPanelConsultation() {
		if (panelConsultation == null) {
			panelConsultation = new PanelBorneStation();
		}
		return panelConsultation;
	}
	
	
	private PanelAjoutBorne getPanel_1() {
		if (panelAjoutBorne == null) {
			panelAjoutBorne = new PanelAjoutBorne();
		}
		return panelAjoutBorne;
	}
}

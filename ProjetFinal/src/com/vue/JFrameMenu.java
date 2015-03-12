package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameMenu extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu MenuFichier;
	private JMenuItem ItemQuitter;
	private JMenu MenuStation;
	private JMenuItem ItemListeStation;
	private JMenu MenuBorne;
	private JMenuItem ItemListeBorne;
	private JMenuItem ItemAjoutBorne;
	private JMenuItem BorneParTC;

	/**
	 * Lance l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMenu frame = new JFrameMenu();
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
	public JFrameMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 415);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	/**
	 * Permet de créer la barre de menu
	 * 
	 * @return menuBar
	 * 		la barre de menu 
	 */
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuFichier());
			menuBar.add(getMenuStation());
			menuBar.add(getMenuBorne());
		}
		return menuBar;
	}
	
	
	public JMenu getMenuFichier() {
		if (MenuFichier == null) {
			MenuFichier = new JMenu("Fichier");
			MenuFichier.add(getItemQuitter());
		}
		return MenuFichier;
	}
	
	
	public JMenuItem getItemQuitter() {
		if (ItemQuitter == null) {
			ItemQuitter = new JMenuItem("Quitter");
			ItemQuitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			
		}
		return ItemQuitter;
	}
	
	
	public JMenu getMenuStation() {
		if (MenuStation == null) {
			MenuStation = new JMenu("Station");
			MenuStation.add(getItemListeStation());
		}
		return MenuStation;
	}
	
	
	public JMenuItem getItemListeStation() {
		if (ItemListeStation == null) {
			ItemListeStation = new JMenuItem("Liste Station");
			ItemListeStation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					afficheStation();
				}
			});
		}
		return ItemListeStation;
	}
	
	
	public JMenu getMenuBorne() {
		if (MenuBorne == null) {
			MenuBorne = new JMenu("Borne");
			MenuBorne.add(getItemAjoutBorne());
			MenuBorne.add(getItemListeBorne());
			MenuBorne.add(getBorneParTC());
		}
		return MenuBorne;
	}
	
	
	public JMenuItem getItemListeBorne() {
		if (ItemListeBorne == null) {
			ItemListeBorne = new JMenuItem("Liste borne par station");
			ItemListeBorne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					afficheBorne();
				}
			});
		}
		return ItemListeBorne;
	}
	
	
	public JMenuItem getItemAjoutBorne() {
		if (ItemAjoutBorne == null) {
			ItemAjoutBorne = new JMenuItem("Ajout borne");
			ItemAjoutBorne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ajoutBorne();
				}
			});
		}
		return ItemAjoutBorne;
	}
	
	private void afficheStation()
	{
		this.setContentPane(new PanelStation());
		this.revalidate();
	}
	
	
	private void ajoutBorne()
	{
		this.setContentPane(new PanelAjoutBorne());
		this.revalidate();
	}
	
	
	private void afficheBorne()
	{
		this.setContentPane(new PanelBorneStation());
		this.revalidate();
	}
	
	
	private void afficherBorneTC()
	{
		this.setContentPane(new PanelTypeChargeBorne());
		this.revalidate();
	}
	
	
	private JMenuItem getBorneParTC() {
		if (BorneParTC == null) {
			BorneParTC = new JMenuItem("Borne par type charge");
			BorneParTC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					afficherBorneTC();
				}
			});
		}
		return BorneParTC;
	}
}

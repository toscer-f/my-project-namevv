package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelStation extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	private ModeleData modele;
	/**
	 * Create the panel.
	 */
	public PanelStation() {
		setLayout(null);
		add(getLblNewLabel());
		modele=new ModeleData();
		add(getScrollPane());
		
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Liste des stations");
			lblNewLabel.setBounds(34, 21, 164, 14);
		}
		return lblNewLabel;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 57, 409, 200);
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
}
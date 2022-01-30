package com.provApp.gestionApp.models;

import javax.swing.JOptionPane;


public class Alert {

	public Alert(String msg) {
		super();
		JOptionPane.showMessageDialog(null, msg, "Attention", JOptionPane.INFORMATION_MESSAGE);
	}

	public Alert(String msg, String imge) {
		super();
		JOptionPane.showMessageDialog(null, msg, "Attention", JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}

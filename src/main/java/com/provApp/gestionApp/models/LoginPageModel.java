package com.provApp.gestionApp.models;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.LoginClickListener;
import com.provApp.gestionApp.controlleurs.LoginFocusListener;
import com.provApp.gestionApp.controlleurs.LoginMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Data
public class LoginPageModel {

	JPanel principalContainer ;
	JPanel gridBagImageContainer ;
	JPanel gridBagFormContainer ;
	JFrame frame  ;
	JComboBox<String> listeDeroulant ;
	JLabel userName ;
	JLabel userNameFocus ;
	JTextField userNameTextField ;
	JLabel password ;
	JLabel passwordFocus ;
	JTextField passwordTextField ;
	JButton loginButton ;
	//JButton showHidePass ;
	LoginClickListener clickClassListener ;
	LoginMouseListener mouseClassListener ;
	LoginFocusListener focusClassListener ;
	Border focusBorder ;
	Border focuBorderUName ;
	Border borderLeft ;
	GridBagConstraints gridBagConstraint ;

	@Autowired
	public LoginPageModel(LoginClickListener clickClassListener, LoginMouseListener mouseClassListener,
			LoginFocusListener focusClassListener) {
		super();
		this.clickClassListener = clickClassListener;
		this.mouseClassListener = mouseClassListener;
		this.focusClassListener = focusClassListener;
	}
}

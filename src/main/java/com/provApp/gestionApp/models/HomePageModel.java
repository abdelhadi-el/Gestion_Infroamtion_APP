package com.provApp.gestionApp.models;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.HomePageClickListener;
import com.provApp.gestionApp.controlleurs.HomePageMouseListener;
import com.provApp.gestionApp.views.RightPartOfAdminView;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor
@Scope("prototype") @Data
public class HomePageModel {

	JFrame frame;
	JPanel containerP = new JPanel(new BorderLayout()) ;
	JScrollPane scroll = new JScrollPane();
	JButton rechInfo = new JButton(); // butt1
	JButton addInfo = new JButton(); // butt2
	JButton setInfo = new JButton(); //butt3
	JButton sortir = new JButton() ; // exit
	JButton seDeconnecter = new JButton() ; 
	Boolean button1 = false, button2 = false, button3 = false ;
	Boolean adminRightPartExists = false ;
	
	HomePageClickListener clickClassListener ;
	HomePageMouseListener mouseClassListener ;
	JLabel welcomeLabel  ; 
	JPanel flowText ;
	
	@Autowired
	RightPartOfAdminView righViewAdmin ;

	@Autowired
	public HomePageModel(HomePageClickListener clickClassListener, HomePageMouseListener mouseClassListener) {
		super();
		this.clickClassListener = clickClassListener ;
		this.mouseClassListener = mouseClassListener ;
	}
}


package com.provApp.gestionApp.models;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.controlleurs.RightAdminClickLisntener;
import com.provApp.gestionApp.controlleurs.RightAdminMouseListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component @NoArgsConstructor @Data
public class RightPartAdminModel {

	JButton rechPersonnel ;
	JButton addPersonnel ;
	JButton setPersonnel ;
	JPanel principalContainer ;
	JPanel panel_container ;
	Boolean button1 = false, button2 = false, button3 = false ;
	RightAdminClickLisntener clickClassListener ;
	RightAdminMouseListener mouseClassListener ;
	
	@Autowired
	public RightPartAdminModel(RightAdminClickLisntener clickClassListener,
			RightAdminMouseListener mouseClassListener) {
		super();
		this.clickClassListener = clickClassListener;
		this.mouseClassListener = mouseClassListener;
	}
}

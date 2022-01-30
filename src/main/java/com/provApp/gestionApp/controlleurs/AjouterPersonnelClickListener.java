package com.provApp.gestionApp.controlleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.PersonnelEntity;
import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.views.AjouterPersonnel;

import lombok.Data;

@Component @Data
public class AjouterPersonnelClickListener implements ActionListener{

	AjouterPersonnel page ;
	String type = "Administrateur" ;

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == page.getModelPage().getListeDeroulant() ) {
			int indexChoosed = page.getModelPage().getListeDeroulant().getSelectedIndex();
			if (indexChoosed == 0) {
				type = "administrateur" ;
			}else {
				type = "normal" ;
			}
		}else {
		AjouterInforamtion inistialisation = page.getAppContext().getBean(AjouterInforamtion.class) ;
		
		if ( page.getModelPage().getDesignationTextField().getText().isEmpty() || page.getModelPage().getAnalyseTextField().getText().isEmpty() ) {
			new Alert("Veuillez remplir tous les champs") ; // traiter si les champs sont vides
		}else {
		Boolean boolResult = Pattern.matches("[0-9]*", page.getModelPage().getOrdAnnuelTextField().getText());
	
		if (boolResult || page.getModelPage().getOrdAnnuelTextField().getText().isEmpty()) { 
			ChercherPersonnel cherchIfAlreadyExist  = page.getAppContext().getBean(ChercherPersonnel.class) ;

			int intToSearch = 0 ;
			if (page.getModelPage().getOrdAnnuelTextField().getText().isEmpty()) {
				intToSearch = -1 ;
			}else {
				intToSearch = Integer.parseInt( page.getModelPage().getOrdAnnuelTextField().getText() ) ;
			}
			Optional<PersonnelEntity> result = cherchIfAlreadyExist.checkExistenceById(intToSearch) ;

			int existedRow = -1;
			if (result.isEmpty() || intToSearch == -1) {
				existedRow = 0 ;
			}
			if ( existedRow == 0 ) {
				PersonnelEntity persoEntity = page.getAppContext().getBean(PersonnelEntity.class) ;
				if (intToSearch != -1) {
					persoEntity.setId(intToSearch);
				}
				persoEntity.setUserName( page.getModelPage().getDesignationTextField().getText());
				persoEntity.setPassword(page.getModelPage().getAnalyseTextField().getText());
				persoEntity.setType(type);
				inistialisation.ajouterPersonnel(persoEntity) ;
			}else {
				new Alert("Erreur : L'identifiant saisi existe déjà") ;
			}
			
		}else {
			new Alert("Erreur : L'identifiant doit être un nombre") ;
		}
		}		
	}
	}
	
}

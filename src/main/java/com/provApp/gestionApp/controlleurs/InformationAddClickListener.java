package com.provApp.gestionApp.controlleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.DataEntity;
import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.views.InformationAdd;

@Component
public class InformationAddClickListener implements ActionListener {
	public InformationAdd page ;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		AjouterInforamtion inistialisation = page.getAppContext().getBean(AjouterInforamtion.class) ;

		Date selectedDate = (java.sql.Date) page.getModelPage().getDatePicker().getModel().getValue() ;
		if ( selectedDate == (null) || page.getModelPage().getDesignationTextField().getText().isEmpty() || page.getModelPage().getAnalyseTextField().getText().isEmpty() || page.getModelPage().getDivisionTextField().getText().isEmpty()) {
			new Alert("Veuillez remplir tous les champs") ; // traiter si les champs sont vides
		}else {
			Boolean boolResult = true; 
			if (!page.getModelPage().getOrdAnnuelTextField().getText().isEmpty()) {

				boolResult = Pattern.matches("[0-9]*", page.getModelPage().getOrdAnnuelTextField().getText());
			}
		if (boolResult || page.getModelPage().getOrdAnnuelTextField().getText().isEmpty()) { 
			ChercherInformation cherchIfAlreadyExist = page.getAppContext().getBean(ChercherInformation.class) ;
			int intToSearch = 0 ;
			if (page.getModelPage().getOrdAnnuelTextField().getText().isEmpty()) {
				intToSearch = -1 ;
			}else {
				intToSearch = Integer.parseInt( page.getModelPage().getOrdAnnuelTextField().getText() ) ;
			}
			Optional<DataEntity> res = cherchIfAlreadyExist.faireLaRecherche(intToSearch) ;
			Boolean addBoolean = true ;
			if (res != null ) {
				if ( !res.isEmpty() ) {
					addBoolean = false ;
				}
			}
			if ( addBoolean  ) {
				DataEntity dataEntity = page.getAppContext().getBean(DataEntity.class) ;
				if (intToSearch != -1) {
					dataEntity.setId(intToSearch);
				}
				dataEntity.setDate( selectedDate);
				dataEntity.setDesignation(page.getModelPage().getDesignationTextField().getText());
				dataEntity.setAnalyse(page.getModelPage().getDesignationTextField().getText());
				dataEntity.setDivision(page.getModelPage().getDivisionTextField().getText());
				inistialisation.ajouterDonnees(dataEntity);
			}else {
				new Alert("Erreur : Le numéro d'ordre annuel saisi existe déjà") ;
			}
		}else {
			new Alert("Erreur : Le numéro d'ordre annuel doit être un nombre") ;
		}
		}
	}
}

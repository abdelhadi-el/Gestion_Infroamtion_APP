package com.provApp.gestionApp.controlleurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.DataEntity;
import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.views.InformationCherche;

@Component @Scope("prototype")
public class InformationChercheClickListener implements ActionListener {

	public InformationCherche page; 
	
	ActionEvent eSrc ;
	String lastButtonClicked ; // for buttons 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == page.getPageModel().getListeDeroulant() ) { //////////////////////////////////////////////////////////  1
			int indexChoosed = page.getPageModel().getListeDeroulant().getSelectedIndex();
			page.getPageModel().getListeDeroulant().setBackground(new Color(146, 135, 60));
			switch (indexChoosed) {
			case 0:
				page.getPageModel().getNumOrderAnnuel().setEditable(false) ; page.getPageModel().getDesignationField().setEditable(false) ;
				page.getPageModel().getDivisionField().setEditable(false) ;	page.getPageModel().getDatePicker().getComponent(1).setEnabled(false);
				page.getPageModel().getDatePicker1().getComponent(1).setEnabled(false);
				page.getPageModel().getRechInfo().setEnabled(false);  page.getPageModel().getRechInfoDate().setEnabled(false);
				page.getPageModel().getRechInfoDesignation().setEnabled(false); page.getPageModel().getRechInfodivision().setEnabled(false);
				break;
			case 1 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(true) ; page.getPageModel().getDesignationField().setEditable(false) ;
				page.getPageModel().getDivisionField().setEditable(false) ;	page.getPageModel().getDatePicker().getComponent(1).setEnabled(false);
				page.getPageModel().getDatePicker1().getComponent(1).setEnabled(false);
				page.getPageModel().getRechInfo().setEnabled(true);  page.getPageModel().getRechInfoDate().setEnabled(false);
				page.getPageModel().getRechInfoDesignation().setEnabled(false); page.getPageModel().getRechInfodivision().setEnabled(false);
				break ;
			case 2 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(false) ; page.getPageModel().getDesignationField().setEditable(false) ;
				page.getPageModel().getDivisionField().setEditable(false) ;	page.getPageModel().getDatePicker().getComponent(1).setEnabled(true);
				page.getPageModel().getDatePicker1().getComponent(1).setEnabled(true);
				page.getPageModel().getRechInfo().setEnabled(false);  page.getPageModel().getRechInfoDate().setEnabled(true);
				page.getPageModel().getRechInfoDesignation().setEnabled(false); page.getPageModel().getRechInfodivision().setEnabled(false);
				break ;
			case 3 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(false) ; page.getPageModel().getDesignationField().setEditable(true) ;
				page.getPageModel().getDivisionField().setEditable(false) ;	page.getPageModel().getDatePicker().getComponent(1).setEnabled(false);
				page.getPageModel().getDatePicker1().getComponent(1).setEnabled(false);
				page.getPageModel().getRechInfo().setEnabled(false);  page.getPageModel().getRechInfoDate().setEnabled(false);
				page.getPageModel().getRechInfoDesignation().setEnabled(true); page.getPageModel().getRechInfodivision().setEnabled(false);
				break ;
			case 4 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(false) ; page.getPageModel().getDesignationField().setEditable(false) ;
				page.getPageModel().getDivisionField().setEditable(true) ;	page.getPageModel().getDatePicker().getComponent(1).setEnabled(false);
				page.getPageModel().getDatePicker1().getComponent(1).setEnabled(false);
				page.getPageModel().getRechInfo().setEnabled(false);  page.getPageModel().getRechInfoDate().setEnabled(false);
				page.getPageModel().getRechInfoDesignation().setEnabled(false); page.getPageModel().getRechInfodivision().setEnabled(true);
				break ;
			case 5 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(true) ; page.getPageModel().getDesignationField().setEditable(true) ;
				page.getPageModel().getDivisionField().setEditable(true) ;	page.getPageModel().getDatePicker().getComponent(1).setEnabled(true);
				page.getPageModel().getDatePicker1().getComponent(1).setEnabled(true);
				page.getPageModel().getRechInfo().setEnabled(true);  page.getPageModel().getRechInfoDate().setEnabled(true);
				page.getPageModel().getRechInfoDesignation().setEnabled(true); page.getPageModel().getRechInfodivision().setEnabled(true);
				break ;
			default:
				break;
			}

		} else if ( e.getSource() == page.getPageModel().getRechInfo() ) { //////////////////////////////////////////////////////////  2
			
			deleteFieldContent(e);
			if (page.getPageModel().getTableContainer().getComponentCount() != 0) { // supprimer des composants s'ils sont existants
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
			}
			
			page.getPageModel().getNumOrderAnnuel().setText( page.getPageModel().getNumOrderAnnuel().getText());
			if (page.getPageModel().getNumOrderAnnuel().getText().isEmpty()) {
				new Alert("Remplir d'abord le champ");
			}else {
				int value_to_search = -1;
			try {
				Boolean boolResult = Pattern.matches("[0-9]*", page.getPageModel().getNumOrderAnnuel().getText());
				
				if (boolResult) { 
					value_to_search = Integer.parseInt( page.getPageModel().getNumOrderAnnuel().getText() ) ;

					ChercherInformation inistialisation = page.getAppContext().getBean(ChercherInformation.class) ;
					Optional<DataEntity> res_to_search = inistialisation.faireLaRecherche(value_to_search);
					if (res_to_search.isEmpty()) {   // to avoid creating a new Jframe when there is no result for the query
						new Alert("Aucun résultat pour votre recherche");
						page.getPageModel().getPana().setVisible(false);
					}else {
						page.getPageModel().getPana().setVisible(true);
						// for having view updated, to supprimer button purpose
						lastButtonClicked = "RechNumOrd" ;
						
					Object[][] dataTable = new Object[1][5] ;  Object[] tabi = new Object[5] ; 
					tabi[0]=res_to_search.get().getId(); tabi[1]=res_to_search.get().getDate(); tabi[2]=res_to_search.get().getDesignation();
					tabi[3]=res_to_search.get().getAnalyse(); tabi[4]=res_to_search.get().getDivision();	
						for(int i=0;i<tabi.length;i++)
						{
							dataTable[0][i]=tabi[i];	
						}
					String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
					DefaultTableModel newTable = new DefaultTableModel(dataTable, title){
						private static final long serialVersionUID = -155916927919935585L;

						@Override
						   public boolean isCellEditable(int row, int column) {       //to disallow changing content of table
							 
							       return false; // or a condition at your choice with row and column
							}
						   
					} ; 
					page.getPageModel().setTable( new JTable(newTable) ); 
					page.getPageModel().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
				          @Override
				          public void valueChanged(ListSelectionEvent e) {
				        	  
				        	  int i = page.getPageModel().getTable().getSelectedRow();
				        	  	page.getPageModel().getText1().setText(page.getPageModel().getTable().getValueAt(i, 0).toString() );
				        	  	page.getPageModel().getText2().setText(page.getPageModel().getTable().getValueAt(i, 1).toString());
				        	  	page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
				        	  	page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
				        	  	page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
				          }
				        });
					page.getPageModel().getTable().setShowVerticalLines(true);
					page.getPageModel().getTable().setFillsViewportHeight(true);
					page.getPageModel().getTable().setBackground(new Color(235, 242, 234)); 
					page.getPageModel().getTable().setRowHeight(30);
				    JScrollPane scrollPane = new JScrollPane(page.getPageModel().getTable(),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBorder(null);
					GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
					gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ;
					gridBagConstraints.gridx = 0;  
					gridBagConstraints.gridy = 0; 
					gridBagConstraints.weightx = 0.5;
					gridBagConstraints.weighty = 0.5 ;
					gridBagConstraints.insets = new Insets(30,0,0,0) ;
					page.getPageModel().setPanel( new JPanel( new GridBagLayout() ) );
					page.getPageModel().getPanel().setBackground(new Color(242, 234, 237));
					//page.getPageModel().setTableContainer( new JPanel(new GridLayout()) ) ;
					//page.getPageModel().getTableContainer().setBorder(new EmptyBorder(35, 0, 35, 0));
					page.getPageModel().getTableContainer().setBackground(new Color(242, 234, 237));
					if (page.getPageModel().getTable().getRowCount() == 1) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,100));
					}else if (page.getPageModel().getTable().getRowCount() < 8) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
					}else {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
					}
					page.getPageModel().getTableContainer().add(scrollPane);
					page.getPageModel().getTableContainer().setBorder(new EmptyBorder(35, 0, 0, 0));
					page.getPageModel().getPanel().add(page.getPageModel().getTableContainer(), gridBagConstraints);
					page.getPageModel().getFl().add(page.getPageModel().getPanel(), BorderLayout.CENTER) ;
					page. getPageModel().getFl().validate();
					}
					}else {
					new Alert("Erreur : Le numéro d'ordre annuel doit être un nombre") ;
				}
				
			} catch (Exception e2) {
				new Alert("Erreur" + e2);
			}
			
			}
		} 
		
		else if ( e.getSource() == page.getPageModel().getRechAllInfo() ) { //////////////////////////////////////////////////////////  3
			
			deleteFieldContent(e);
			if (page.getPageModel().getTableContainer().getComponentCount() != 0) {
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
			}
			ChercherInformation inistialisation1 = page.getAppContext().getBean(ChercherInformation.class) ;

			List<DataEntity> res_of_search = inistialisation1.faireLaRecherche1() ;
			if (res_of_search == null) {   // to avoid creating a new Jframe when there is no result for the query // we put null cuz the controller return the null
				new Alert("Aucun résultat pour votre recherche");
				page.getPageModel().getPana().setVisible(false);
			}else {
			
				// for having view updated, to supprimer button purpose
				lastButtonClicked = "RechAll" ;
				eSrc = e ;
			Object[][] listPerso = new Object[res_of_search.size()][5] ;
			for (int i = 0; i < res_of_search.size(); i++) {
				listPerso[i][0] =res_of_search.get(i).getId() ;
				listPerso[i][1] =res_of_search.get(i).getDate() ;
				listPerso[i][2] =res_of_search.get(i).getDesignation() ;
				listPerso[i][3] =res_of_search.get(i).getAnalyse() ;
				listPerso[i][4] =res_of_search.get(i).getDivision() ;
			}
			String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
			DefaultTableModel newTable = new DefaultTableModel(listPerso, title){
				private static final long serialVersionUID = -155916927919935585L;

				@Override
				   public boolean isCellEditable(int row, int column) {       //to disallow changing content of table
					 
					       return false; // or a condition at your choice with row and column
					}
				   
			}; 
			page.getPageModel().getPana().setVisible(true);
			page.getPageModel().setTable( new JTable(newTable) ); 
			page.getPageModel().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
		          @Override
		          public void valueChanged(ListSelectionEvent e) {
		        	  int i = page.getPageModel().getTable().getSelectedRow();
		        	  	page.getPageModel().getText1().setText(page.getPageModel().getTable().getValueAt(i, 0).toString() );
		        	  	page.getPageModel().getText2().setText(page.getPageModel().getTable().getValueAt(i, 1).toString());
		        	  	page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
		        	  	page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
		        	  	page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
		          }
		        });
			page.getPageModel().getTable().setShowVerticalLines(true);
			page.getPageModel().getTable().setBackground(new Color(235, 242, 234)); 
			page.getPageModel().getTable().setRowHeight(30);
			page.getPageModel().getTable().setFillsViewportHeight(true);
			JScrollPane scrollPane = new JScrollPane(page.getPageModel().getTable());
			scrollPane.setBorder(null);
			
			page.getPageModel().setPanel(  new JPanel(new GridBagLayout()) );
			GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ;
			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = 0; 
			gridBagConstraints.weightx = 0.5;
			gridBagConstraints.weighty = 0.5 ;
			gridBagConstraints.insets = new Insets(30,0,0,0) ;
			page.getPageModel().getPanel().setBackground(new Color(242, 234, 237));
			
			if (page.getPageModel().getTable().getRowCount() == 1) {
				page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,100));
			}else if (page.getPageModel().getTable().getRowCount() < 8) {
				page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
			}else {
				page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
			}
			page.getPageModel().getTableContainer().setBorder(new EmptyBorder(35, 0, 0, 0));
		    page.getPageModel().getTableContainer().setBackground(new Color(242, 234, 237));
		    page.getPageModel().getTableContainer().add(scrollPane);
		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); 
	        
			page.getPageModel().getPanel().add(page.getPageModel().getTableContainer(), gridBagConstraints);

	        page.getPageModel().getFl().add(page.getPageModel().getPanel(), BorderLayout.CENTER) ;
	        page.getPageModel().getFl().revalidate();

			}
			
		}else if ( e.getSource() == page.getPageModel().getRechInfoDate() ) { //////////////////////////////////////////////////////////  4
			
			deleteFieldContent(e);
			if (page.getPageModel().getTableContainer().getComponentCount() != 0) { // supprimer des composants s'ils sont existants
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
			}
			Date selectedDate = (java.sql.Date) page.getPageModel().getDatePicker().getModel().getValue() ;
			Date selectedDate1 = (java.sql.Date) page.getPageModel().getDatePicker1().getModel().getValue() ;
		
			if ( selectedDate == null || selectedDate1 == null ) {
				new Alert("Remplir d'abord le champ");
			}else {

				ChercherInformation inistialisation = page.getAppContext().getBean(ChercherInformation.class) ;
					List<DataEntity> res_to_search = inistialisation.trouverDonnees2(selectedDate, selectedDate1) ;
					if (res_to_search == null) {   // to avoid creating a new Jframe when there is no result for the query
						new Alert("Aucun résultat pour votre recherche");
						page.getPageModel().getPana().setVisible(false);
					}else {
						
						// for having view updated, to supprimer button purpose
						lastButtonClicked = "RechDate" ;
						eSrc = e ;
					Object[][] listPerso = new Object[res_to_search.size()][5] ;
					for (int i = 0; i < res_to_search.size(); i++) {
						listPerso[i][0] =res_to_search.get(i).getId() ;
						listPerso[i][1] =res_to_search.get(i).getDate() ;
						listPerso[i][2] =res_to_search.get(i).getDesignation() ;
						listPerso[i][3] =res_to_search.get(i).getAnalyse() ;
						listPerso[i][4] =res_to_search.get(i).getDivision() ;

					}	
					String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
					DefaultTableModel newTable = new DefaultTableModel(listPerso, title){
						private static final long serialVersionUID = -155916927919935585L;

						@Override
						   public boolean isCellEditable(int row, int column) {       //to disallow changing content of table
							 
							       return false; // or a condition at your choice with row and column
							}
						   
					} ;  
					page.getPageModel().getPana().setVisible(true);
					page.getPageModel().setTable( new JTable(newTable) ); 
					page.getPageModel().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
				          @Override
				          public void valueChanged(ListSelectionEvent e) {
				        	  
				        	  int i = page.getPageModel().getTable().getSelectedRow();
				        	  	page.getPageModel().getText1().setText(page.getPageModel().getTable().getValueAt(i, 0).toString() );
				        	  	page.getPageModel().getText2().setText(page.getPageModel().getTable().getValueAt(i, 1).toString());
				        	  	page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
				        	  	page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
				        	  	page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
				          }
				        });
					page.getPageModel().getTable().setShowVerticalLines(true);
				    page.getPageModel().getTable().setBackground(new Color(235, 242, 234)); 
				    page.getPageModel().getTable().setRowHeight(30);
				    page.getPageModel().getTable().setFillsViewportHeight(true);
					JScrollPane scrollPane = new JScrollPane(page.getPageModel().getTable(),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBorder(null);
					page.getPageModel().setPanel( new JPanel(new GridBagLayout()) );
					GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
					gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ;
					gridBagConstraints.gridx = 0;  
					gridBagConstraints.gridy = 0; 
					gridBagConstraints.weightx = 0.5;
					gridBagConstraints.weighty = 0.5 ;
					gridBagConstraints.insets = new Insets(30,0,0,0) ;
					if (page.getPageModel().getTable().getRowCount() == 1) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,100));
					}else if (page.getPageModel().getTable().getRowCount() < 8) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
					}else {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
					}
					page.getPageModel().getPanel().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().setBorder(new EmptyBorder(35, 0, 0, 0));
					page.getPageModel().getTableContainer().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().setPreferredSize(new Dimension(600,200));
					page.getPageModel().getTableContainer().add(scrollPane);
					page.getPageModel().getPanel().add(page.getPageModel().getTableContainer(), gridBagConstraints);
					page.getPageModel().getFl().add(page.getPageModel().getPanel(), BorderLayout.CENTER) ;
					page.getPageModel().getFl().revalidate();
					}
			}
			
		}else if ( e.getSource() == page.getPageModel().getRechInfoDesignation() ) { //////////////////////////////////////////////////////////  5
			
			deleteFieldContent(e);
			if (page.getPageModel().getTableContainer().getComponentCount() != 0) { // supprimer des composants s'ils sont existants
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
			}
			String designation = page.getPageModel().getDesignationField().getText() ;
			if ( designation.isEmpty() ) {
				new Alert("Remplir d'abord le champ");
			}else {
					
					ChercherInformation inistialisation = page.getAppContext().getBean(ChercherInformation.class) ;
					List<DataEntity> res_to_search = inistialisation.trouverDonnees3(designation) ;
					if (res_to_search == null) {   // to avoid creating a new Jframe when there is no result for the query
						new Alert("Aucun résultat pour votre recherche");
						page.getPageModel().getPana().setVisible(false);
					}else {
						
						// for having view updated, to supprimer button purpose
						lastButtonClicked = "RechDesignation" ;
						eSrc = e ;
					Object[][] listPerso = new Object[res_to_search.size()][5] ;
					for (int i = 0; i < res_to_search.size(); i++) {
						listPerso[i][0] =res_to_search.get(i).getId() ;
						listPerso[i][1] =res_to_search.get(i).getDate() ;
						listPerso[i][2] =res_to_search.get(i).getDesignation() ;
						listPerso[i][3] =res_to_search.get(i).getAnalyse() ;
						listPerso[i][4] =res_to_search.get(i).getDivision() ;

					}	
					String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
					DefaultTableModel newTable = new DefaultTableModel(listPerso, title){
						private static final long serialVersionUID = -155916927919935585L;

						@Override
						   public boolean isCellEditable(int row, int column) {       //to disallow changing content of table
							 
							       return false; // or a condition at your choice with row and column
							}
						   
					} ;  
					 page.getPageModel().getPana().setVisible(true);
					page.getPageModel().setTable( new JTable(newTable) ); 
					page.getPageModel().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
				          @Override
				          public void valueChanged(ListSelectionEvent e) {
				        	 
				        	  int i = page.getPageModel().getTable().getSelectedRow();
				        	  	page.getPageModel().getText1().setText(page.getPageModel().getTable().getValueAt(i, 0).toString() );
				        	  	page.getPageModel().getText2().setText(page.getPageModel().getTable().getValueAt(i, 1).toString());
				        	  	page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
				        	  	page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
				        	  	page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
				          }
				        });
					page.getPageModel().getTable().setShowVerticalLines(true);
					page.getPageModel().getTable().setFillsViewportHeight(true);
					page.getPageModel().getTable().setBackground(new Color(235, 242, 234)); 
					page.getPageModel().getTable().setRowHeight(30);
					JScrollPane scrollPane = new JScrollPane(page.getPageModel().getTable(),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBorder(null);
					page.getPageModel().setPanel( new JPanel(new GridBagLayout()) );
					GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
					gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ;
					gridBagConstraints.gridx = 0;  
					gridBagConstraints.gridy = 0; 
					gridBagConstraints.weightx = 0.5;
					gridBagConstraints.weighty = 0.5 ;
					gridBagConstraints.insets = new Insets(30,0,0,0) ;
					
					if (page.getPageModel().getTable().getRowCount() == 1) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,100));
					}else if (page.getPageModel().getTable().getRowCount() < 8) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
					}else {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
					}
					page.getPageModel().getPanel().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().setBorder(new EmptyBorder(35, 0, 0, 0));
				    page.getPageModel().getTableContainer().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().add(scrollPane);
					page.getPageModel().getPanel().add(page.getPageModel().getTableContainer(), gridBagConstraints);
				    page.getPageModel().getFl().add(page.getPageModel().getPanel(), BorderLayout.CENTER) ;
			        page.getPageModel().getFl().revalidate();
					}
			}
		}else if ( e.getSource() == page.getPageModel().getRechInfodivision() ) { //////////////////////////////////////////////////////////  6
			
			deleteFieldContent(e);
			if (page.getPageModel().getTableContainer().getComponentCount() != 0) { // supprimer des composants s'ils sont existants
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
			}
			String division = page.getPageModel().getDivisionField().getText() ;
			if ( division.isEmpty() ) {
				new Alert("Remplir d'abord le champ");
			}else {
					
					ChercherInformation inistialisation = page.getAppContext().getBean(ChercherInformation.class) ;
					List<DataEntity> res_to_search = inistialisation.trouverDonnees4(division) ;
					if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
						new Alert("Aucun résultat pour votre recherche");
						page.getPageModel().getPana().setVisible(false);
					}else {
						
						// for having view updated, to supprimer button purpose
						lastButtonClicked = "RechDivision" ;
						eSrc = e ;
					Object[][] listPerso = new Object[res_to_search.size()][5] ;
					for (int i = 0; i < res_to_search.size(); i++) {
						listPerso[i][0] =res_to_search.get(i).getId() ;
						listPerso[i][1] =res_to_search.get(i).getDate() ;
						listPerso[i][2] =res_to_search.get(i).getDesignation() ;
						listPerso[i][3] =res_to_search.get(i).getAnalyse() ;
						listPerso[i][4] =res_to_search.get(i).getDivision() ;

					}	
					String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
					DefaultTableModel newTable = new DefaultTableModel(listPerso, title){
						private static final long serialVersionUID = -155916927919935585L;

						@Override
						   public boolean isCellEditable(int row, int column) {       //to disallow changing content of table
							 
							       return false; // or a condition at your choice with row and column
							}
						   
					} ;  
					page.getPageModel().setTable( new JTable(newTable) ); 
					page.getPageModel().getPana().setVisible(true);
					
					page.getPageModel().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
			          @Override
			          public void valueChanged(ListSelectionEvent e) {
			        	  
			        	  int i = page.getPageModel().getTable().getSelectedRow();
			        	  	page.getPageModel().getText1().setText(page.getPageModel().getTable().getValueAt(i, 0).toString() );
			                page.getPageModel().getText2().setText(page.getPageModel().getTable().getValueAt(i, 1).toString());
			                page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
			                page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
			                page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
			          }
			        });
					page.getPageModel().getTable().setShowVerticalLines(true);
					page.getPageModel().getTable().setFillsViewportHeight(true);
					page.getPageModel().getTable().setBackground(new Color(235, 242, 234)); 
					page.getPageModel().getTable().setRowHeight(30);
					JScrollPane scrollPane = new JScrollPane(page.getPageModel().getTable(),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBorder(null);
					page.getPageModel().setPanel( new JPanel(new GridBagLayout()) );
					GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
					gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ;
					gridBagConstraints.gridx = 0;  
					gridBagConstraints.gridy = 0; 
					gridBagConstraints.weightx = 0.5;
					gridBagConstraints.weighty = 0.5 ;
					gridBagConstraints.insets = new Insets(30,0,0,0) ;
					
					if (page.getPageModel().getTable().getRowCount() == 1) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,100));
					}else if (page.getPageModel().getTable().getRowCount() < 8) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
					}else {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
					}
					page.getPageModel().getPanel().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().setBorder(new EmptyBorder(35, 0, 0, 0));
					page.getPageModel().getTableContainer().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().add(scrollPane);
					page.getPageModel().getPanel().add(page.getPageModel().getTableContainer(), gridBagConstraints);
				    page.getPageModel().getFl().add(page.getPageModel().getPanel(), BorderLayout.CENTER) ;
				    page.getPageModel().getFl().revalidate();
					}
			}
		}else if ( e.getSource() == page.getPageModel().getSupprimer() ) { //////////////////////////////////////////////////////////  7
		
			int reponse = JOptionPane.showConfirmDialog(null,
		            "Vous voulez vraiment supprimer cette donnée", "Faite attention !!",
		            JOptionPane.YES_NO_OPTION); 
			switch (reponse) {
			case JOptionPane.YES_OPTION:
        	SupprimerInformation suppInfo = page.getAppContext().getBean(SupprimerInformation.class) ;
			suppInfo.suppInformation(Integer.parseInt(page.getPageModel().getText1().getText()));
			if ( lastButtonClicked == "RechNumOrd" ) {   // to have view updated
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				page.getPageModel().getPana().setVisible(false);
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
				
				
			} else if ( lastButtonClicked == "RechAll" ) {
				actionPerformed(eSrc);
			} else if ( lastButtonClicked == "RechDate" ) {
				actionPerformed(eSrc);
			} else if ( lastButtonClicked == "RechDesignation" ) {
				actionPerformed(eSrc);
			} else if ( lastButtonClicked == "RechDivision" ) {
				actionPerformed(eSrc);
			}
            break;
			case JOptionPane.NO_OPTION:
      
            break;
			case JOptionPane.CLOSED_OPTION:
            
            break;
    }
		} 
		
				
	}

	
	public void deleteFieldContent( ActionEvent e ) {
		if ( e.getSource() == page.getPageModel().getRechInfo() ) {
			
			page.getPageModel().getDatePicker().getModel().setValue(null);
			page.getPageModel().getDatePicker1().getModel().setValue(null);
			page.getPageModel().getDesignationField().setText("");
			page.getPageModel().getDivisionField().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText2().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		} else if ( e.getSource() == page.getPageModel().getRechAllInfo() ) {
			
			page.getPageModel().getDatePicker().getModel().setValue(null);
			page.getPageModel().getDatePicker1().getModel().setValue(null);
			page.getPageModel().getDesignationField().setText("");
			page.getPageModel().getDivisionField().setText("");
			page.getPageModel().getNumOrderAnnuel().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText2().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		} else if (  e.getSource() == page.getPageModel().getRechInfoDate() ) {
			
			page.getPageModel().getDesignationField().setText("");
			page.getPageModel().getDivisionField().setText("");
			page.getPageModel().getNumOrderAnnuel().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText2().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		} else if ( e.getSource() == page.getPageModel().getRechInfoDesignation() ) {
			
			page.getPageModel().getDivisionField().setText("");
			page.getPageModel().getNumOrderAnnuel().setText("");
			page.getPageModel().getDatePicker().getModel().setValue(null);
			page.getPageModel().getDatePicker1().getModel().setValue(null);
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText2().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		} else if ( e.getSource() == page.getPageModel().getRechInfodivision() ) {
			
			page.getPageModel().getNumOrderAnnuel().setText("");
			page.getPageModel().getDatePicker().getModel().setValue(null);
			page.getPageModel().getDatePicker1().getModel().setValue(null) ;
			page.getPageModel().getDesignationField().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText2().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		}
		
	}
			
}



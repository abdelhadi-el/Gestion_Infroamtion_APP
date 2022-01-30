package com.provApp.gestionApp.controlleurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.PersonnelEntity;
import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.views.ModifierPersonnel;

@Component
public class ModifierPersonnelClickListener implements ActionListener{
	
	public ModifierPersonnel page ;
	public JPanel container  ;
	public Boolean tableauCheckBox[] = {false,false,false};
	public int ordAnnuel ;  public String designation ;public String analyse ;public String division ;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == page.getPageModel().getButtonMontrer() ) {
			
			page.getPageModel().getButtonMontrer().setEnabled(false);
			
			container = new JPanel() ; 
			container.setBackground(new Color(242, 234, 237));
			page.getPageModel().setCompteur( 0 ) ; // le nombre de champs qui sont deja existant
			GridBagConstraints gridBagConstraints = new GridBagConstraints();  // for the the gridBagLayout 
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ; 
			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = 0; 
			gridBagConstraints.weightx = 0.5;
			gridBagConstraints.insets = new Insets(0,20,0,0) ;
			JPanel flowLayoutForGrid = new JPanel(new FlowLayout()) ;// important for the flow effect in field created // last modification suppr this suppr add to container at the last
			flowLayoutForGrid.setBackground(new Color(220, 217, 214)); // we can have the same color in the edge that is black (yellow )
			JPanel panelGridBag = new JPanel(new GridBagLayout());
			flowLayoutForGrid.add(panelGridBag) ;
			panelGridBag.setBorder(new EmptyBorder(3, 0, 7, 20));
			
			panelGridBag.setBackground(new Color(235, 242, 234));
			if (page.getPageModel().getCheckBox1().isSelected()) {
				JLabel ordAnnuel = new JLabel(" Identifiant :");
				ordAnnuel.setFont(new Font(null, Font.BOLD, 14));
				panelGridBag.add(ordAnnuel, gridBagConstraints);
				
					gridBagConstraints.gridx = 1;  
					gridBagConstraints.gridy = 0;
				page.getPageModel().setOrdAnnuelTextField( new JTextField() );
				page.getPageModel().getOrdAnnuelTextField().setFont(new Font(null, Font.BOLD, 12));
				page.getPageModel().getOrdAnnuelTextField().setPreferredSize(new Dimension(80, 30));
				panelGridBag.add(page.getPageModel().getOrdAnnuelTextField(), gridBagConstraints);
				page.getPageModel().setCompteur(page.getPageModel().getCompteur() + 1);
			}

			if (page.getPageModel().getCheckBox2().isSelected()) {
				gridBagConstraints.gridx = 0;  
				gridBagConstraints.gridy = page.getPageModel().getCompteur();
				JLabel designationLabel = new JLabel("Nom d'utilisateur :");
				designationLabel.setFont(new Font(null, Font.BOLD, 14));
				panelGridBag.add(designationLabel, gridBagConstraints);
				
					gridBagConstraints.gridx = 1;  
					gridBagConstraints.gridy = page.getPageModel().getCompteur();
				page.getPageModel().setDesignationTextField( new JTextField() );
				page.getPageModel().getDesignationTextField().setFont(new Font(null, Font.BOLD, 12));
				page.getPageModel().getDesignationTextField().setPreferredSize(new Dimension(80, 30));
				panelGridBag.add(page.getPageModel().getDesignationTextField(), gridBagConstraints);
				page.getPageModel().setCompteur(page.getPageModel().getCompteur() + 1);
				}
			if (page.getPageModel().getCheckBox3().isSelected()) {
				gridBagConstraints.gridx = 0;  
				gridBagConstraints.gridy = page.getPageModel().getCompteur();
				JLabel analyseLabel = new JLabel("Type :");
				analyseLabel.setFont(new Font(null, Font.BOLD, 14));
				panelGridBag.add(analyseLabel, gridBagConstraints);
				
					gridBagConstraints.gridx = 1;  
					gridBagConstraints.gridy = page.getPageModel().getCompteur();
//					page.getPageModel().setAnalyseTextField( new JTextField() );
//					page.getPageModel().getAnalyseTextField().setFont(new Font(null, Font.BOLD, 12));
//					page.getPageModel().getAnalyseTextField().setPreferredSize(new Dimension(80, 30));
//				panelGridBag.add(page.getPageModel().getAnalyseTextField(), gridBagConstraints);
					
					panelGridBag.add(page.getPageModel().getListeDeroulantFirst(), gridBagConstraints);

					page.getPageModel().setCompteur(page.getPageModel().getCompteur() + 1);
			}

			//insertion of button "remontrer champs"
			gridBagConstraints.gridx = 1;  
			gridBagConstraints.gridy = page.getPageModel().getCompteur();
			gridBagConstraints.insets = new Insets(15,20,15,0) ;
			panelGridBag.add(page.getPageModel().getButtonReMontrer() , gridBagConstraints);
			//insertion of button "chercher"
			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = page.getPageModel().getCompteur();
			gridBagConstraints.insets = new Insets(15,20,15,0) ;
			panelGridBag.add(page.getPageModel().getButtonChercher(), gridBagConstraints);
			// !!!!!!!!!!!!!!IMPORTANT
			 // we have in the header of "frame" the "modification label" after in the center of the "frame" the "panelContainerBorder ( scroll )" , 
			//after in his center(panelContainerBorder) we have "containerPanel1" layout,  and in the PAGE_START the "panelContainerFlow"  
			// in the center of (containerPanel1) we have the "containerPanel2", AND in the PAGE_START the "container" that containes the "panelGridBag" that are fields
			// in the center of (containerPanel2) we have the "scrollPane" that is applicated in the the same JPanel, 
			container.add(flowLayoutForGrid);
			page.getPageModel().getContainerPanel1().add(container, BorderLayout.PAGE_START) ;
			page.getPageModel().getContainerPanel1().validate(); // to show directly the content changed without need resizing  
			
		}else if ( e.getSource() == page.getPageModel().getButtonReMontrer() ) {
			page.getPageModel().getButtonMontrer().setEnabled(true);
			page.getPageModel().setCompteur(0);
			page.getPageModel().getContainerPanel1().remove(container);
			if (page.getPageModel().getContainerPanel2().getComponentCount() != 0) {
		     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
		     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
				page.getPageModel().getContainerPanel2().remove(page.getPageModel().getPana());
				page.getPageModel().getContainerPanel1().remove(page.getPageModel().getContainerPanel2());
				page.getPageModel().getTableContainer().removeAll();
				}
			
			page.getPageModel().getContainerPanel1().repaint();
			page.getPageModel().getContainerPanel1().validate();
		
		}else if ( e.getSource() == page.getPageModel().getButtonChercher() ) {
			ChercherPersonnel inistialisation = page.getAppContext().getBean(ChercherPersonnel.class) ;
			tableauCheckBox[0] = page.getPageModel().getCheckBox1().isSelected();
			tableauCheckBox[1] = page.getPageModel().getCheckBox2().isSelected();
			tableauCheckBox[2] = page.getPageModel().getCheckBox3().isSelected();
			
			if (( tableauCheckBox[0] && page.getPageModel().getOrdAnnuelTextField().getText().isEmpty() ) /* || ( tableauCheckBox[1] && selectedDateForSearch == (null) ) */ ||( tableauCheckBox[1] && page.getPageModel().getDesignationTextField().getText().isEmpty() ) /*|| ( tableauCheckBox[2] && page.getPageModel().getAnalyseTextField().getText().isEmpty() )*/ ) {
				new Alert("Veuillez remplir tous les champs") ; // traiter si les champs sont vides
			}else {
				Boolean boolResult ;
				if (tableauCheckBox[0]) {  // to avoid having a problem
					boolResult = Pattern.matches("[0-9]*", page.getPageModel().getOrdAnnuelTextField().getText());
				}else {
					boolResult = true ;
				}
			
			
			if (boolResult) {
				if (tableauCheckBox[0]) {
					ordAnnuel = Integer.parseInt(page.getPageModel().getOrdAnnuelTextField().getText()) ;
				}else {
					ordAnnuel = -1 ;
				}
				if (tableauCheckBox[1]) {
					designation = page.getPageModel().getDesignationTextField().getText() ;
				}else {
					designation = "" ;
				}
				if (tableauCheckBox[2]) {
					//String division = "administrateur";
					int indexChoosed = page.getPageModel().getListeDeroulantFirst().getSelectedIndex();
					if (indexChoosed == 0) {
						analyse = "administrateur" ;
					}else {
						analyse = "normal" ;
					}
					//analyse = page.getPageModel().getAnalyseTextField().getText() ;
				}else {
					analyse = "" ;
				}
				
				List<PersonnelEntity> res_to_search = inistialisation.findPersoToSet(ordAnnuel, designation, analyse, tableauCheckBox) ;
				if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
					new Alert("Aucun résultat pour votre recherche");
				}else {
				Object[][] listPerso = new Object[res_to_search.size()][4] ;
				for (int i = 0; i < res_to_search.size(); i++) {
					listPerso[i][0] =res_to_search.get(i).getId() ;
					listPerso[i][1] =res_to_search.get(i).getUserName() ;
					listPerso[i][2] =res_to_search.get(i).getPassword() ;
					listPerso[i][3] =res_to_search.get(i).getType() ;

				}
					String title[] = {"Identifiant","Nom d'utilisateur","Mot De Passe","Type"};
				DefaultTableModel newTable = new DefaultTableModel(listPerso, title) {
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
			                page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 1));
			                page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
			                String type = (String)page.getPageModel().getTable().getValueAt(i, 3) ;
			                if (type.equals("administrateur") ) {
			                	page.getPageModel().getListeDeroulant().setSelectedIndex(0) ;
							}else if (type.equals("normal") ){
			                	page.getPageModel().getListeDeroulant().setSelectedIndex(1) ;
							}				          }
			        });

			    page.getPageModel().getTable().setRowHeight(30);
				page.getPageModel().getTable().setBackground(new Color(235, 242, 234));   // pink color
				
				if (page.getPageModel().getTable().getRowCount() == 1) {
					page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
				}else if (page.getPageModel().getTable().getRowCount() < 8) {
					page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
				}else {
					page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,250));
				}
				 // this is for the size of the JTable
				JScrollPane scrollPane=new JScrollPane(page.getPageModel().getTable());// j'ai supprim� �a rien de difference --> // table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
				page.getPageModel().getTable().setShowVerticalLines(true);
			    scrollPane.setBorder(null); 
			    page.getPageModel().getTable().setFillsViewportHeight(true);
			 
			    if ( page.getPageModel().getTableContainer().getComponentCount() != 0) {
			    	page.getPageModel().getTableContainer().removeAll();
			     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
			     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
			    	page.getPageModel().getContainerPanel2().removeAll();
			    	
			    	
				} // to avoid creating a new table for each click
					
				page.getPageModel().getTableContainer().add(scrollPane);
			    page.getPageModel().getContainerPanel2().add(page.getPageModel().getTableContainer(), BorderLayout.PAGE_START) ; // the center because it doesen't work in page start
				page.getPageModel().getContainerPanel2().add(page.getPageModel().getPana(), BorderLayout.CENTER);
				page.getPageModel().getContainerPanel1().add(page.getPageModel().getContainerPanel2(), BorderLayout.CENTER) ;
				
				page.getPageModel().getContainerPanel1().repaint();
				page.getPageModel().getContainerPanel1().validate();
			    
				}
			}else {
				new Alert("Erreur : L'identifiant doit être un nombre") ;
			}
			
			}
			
		}else if ( e.getSource() == page.getPageModel().getValiderUpdate() ) {
			
			UpdateInformation updtInfo = page.getAppContext().getBean(UpdateInformation.class) ;
			if (page.getPageModel().getText1().getText().isEmpty() /*|| selectedDate == (null) */ || page.getPageModel().getText3().getText().isEmpty() || page.getPageModel().getText4().getText().isEmpty() ) {
				new Alert("Veuillez remplir tous les champs") ; // traiter si les champs sont vides
			}else {
			Boolean boolResult = Pattern.matches("[0-9]*", page.getPageModel().getText1().getText());
			Boolean boolResult1 = true ;
			if (page.getPageModel().getText1New().getText().isEmpty()) {
				page.getPageModel().getText1New().setText("-1") ;
			}else {
				boolResult1 = Pattern.matches("[0-9]*", page.getPageModel().getText1New().getText());
			}
			
			
			if (boolResult && boolResult1) {
				if ( page.getPageModel().getText1New().getText().equals("-1") ) { // that's mean that the field was empty on submit and we don't want to change the "ordAnnuel" primary just other fields
					String division1 = "administrateur";
					int indexChoosed = page.getPageModel().getListeDeroulant().getSelectedIndex();
					if (indexChoosed == 0) {
						division1 = "administrateur" ;
					}else {
						division1 = "normal" ;
					}
					updtInfo.updtPersonnel(Integer.parseInt(page.getPageModel().getText1().getText()),Integer.parseInt(page.getPageModel().getText1New().getText()) /* , selectedDate */ , page.getPageModel().getText3().getText(), page.getPageModel().getText4().getText(), division1);
					//// from here  the content changes when we click update we have the table get updated too
					String userN = "" ;
					if (tableauCheckBox[1]) {
						userN = page.getPageModel().getText3().getText() ;
					}else {
						userN = designation ;
					}	
					String divType = "" ;
					int indexChoosed2 = -1 ;
					if (tableauCheckBox[2]) {
						indexChoosed2 = page.getPageModel().getListeDeroulant().getSelectedIndex();
						if (indexChoosed2 == 0) {
							divType = "administrateur" ;
						}else {
							divType = "normal" ;
						}
					}else {
						divType = "" ;
					}
					ChercherPersonnel inistialisation = page.getAppContext().getBean(ChercherPersonnel.class) ;

						List<PersonnelEntity>res_to_search = inistialisation.findPersoToSet(ordAnnuel, userN, divType, tableauCheckBox) ;
						if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
							 if ( page.getPageModel().getTableContainer().getComponentCount() != 0) {
									     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
									     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
									    	page.getPageModel().getContainerPanel1().remove(page.getPageModel().getContainerPanel2());
									    	page.getPageModel().getContainerPanel1().repaint();
											page.getPageModel().getContainerPanel1().validate();	    	
										}
						}else {
							if (tableauCheckBox[1]) {
								page.getPageModel().getDesignationTextField().setText(userN);
							}
							if (tableauCheckBox[2]) {
								page.getPageModel().getListeDeroulantFirst().setSelectedIndex(indexChoosed2);
							}
							Object[][] listPerso = new Object[res_to_search.size()][4] ;
							for (int i = 0; i < res_to_search.size(); i++) {
								listPerso[i][0] =res_to_search.get(i).getId() ;
								listPerso[i][1] =res_to_search.get(i).getUserName() ;
								listPerso[i][2] =res_to_search.get(i).getPassword() ;
								listPerso[i][3] =res_to_search.get(i).getType() ;

							}
						 	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
						 	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
							String title[] = {"Identifiant","Nom d'utilisateur","Mot De Passe","Type"};
						DefaultTableModel newTable = new DefaultTableModel(listPerso, title) {
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
						            page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 1));
						            page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
						            String type = (String)page.getPageModel().getTable().getValueAt(i, 3) ;
						            if (type.equals("administrateur") ) {
						            	page.getPageModel().getListeDeroulant().setSelectedIndex(0) ;
									}else if (type.equals("normal") ){
						            	page.getPageModel().getListeDeroulant().setSelectedIndex(1) ;
									}								          }
						    });
					   page.getPageModel().getTable().setRowHeight(30);
					   page.getPageModel().getTable().setBackground(new Color(235, 242, 234));
					   page.getPageModel().getTable().setShowVerticalLines(true); 
					   page.getPageModel().getTable().setFillsViewportHeight(true);
					   if (page.getPageModel().getTable().getRowCount() == 1) {
							page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
						}else if (page.getPageModel().getTable().getRowCount() < 8) {
							page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
						}else {
							page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,250));
						}
					   JScrollPane scrollPane=new JScrollPane(page.getPageModel().getTable());
					   scrollPane.setBorder(null);
					   page.getPageModel().getTableContainer().removeAll();
					   page.getPageModel().getTableContainer().add(scrollPane);
					   page.getPageModel().getContainerPanel1().validate();
						}
						
					
				} else {
					ChercherPersonnel cherchIfAlreadyExist = page.getAppContext().getBean(ChercherPersonnel.class) ;
					Optional<PersonnelEntity> existedRow = cherchIfAlreadyExist.checkExistenceById( Integer.parseInt(page.getPageModel().getText1New().getText()) ) ;
					if ( existedRow.isEmpty() ) {
						String divisionElse = "administrateur";
						int indexChoosed = page.getPageModel().getListeDeroulant().getSelectedIndex();
						if (indexChoosed == 0) {
							divisionElse = "administrateur" ;
						}else {
							divisionElse = "normal" ;
						}
						updtInfo.updtPersonnel(Integer.parseInt(page.getPageModel().getText1().getText()),Integer.parseInt(page.getPageModel().getText1New().getText()) /*,  selectedDate */ , page.getPageModel().getText3().getText(), page.getPageModel().getText4().getText(), divisionElse);
						//// from here  the content changes when we click update we have the table get updated too
							ChercherPersonnel inistialisation = page.getAppContext().getBean(ChercherPersonnel.class) ;

							int identifiantArg ;
							if (tableauCheckBox[0]) {
								identifiantArg = Integer.parseInt( page.getPageModel().getText1New().getText() );
							}else {
								identifiantArg = ordAnnuel ;
							}
							String userN = "" ;
							if (tableauCheckBox[1]) {
								userN = page.getPageModel().getText3().getText() ;
							}else {
								userN = designation ;
							}
							String divType1 = "" ;
							int indexChoosed3 = -1;
							if (tableauCheckBox[2]) {
								indexChoosed3 = page.getPageModel().getListeDeroulant().getSelectedIndex();
								if (indexChoosed3 == 0) {
									divType1 = "administrateur" ;
								}else {
									divType1 = "normal" ;
								}
							}else {
								divType1 = "" ;
							}
							List<PersonnelEntity> res_to_search = inistialisation.findPersoToSet(identifiantArg, userN, divType1, tableauCheckBox) ;
							if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
								 if ( page.getPageModel().getTableContainer().getComponentCount() != 0) {
										     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
										     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
										    	page.getPageModel().getContainerPanel1().remove(page.getPageModel().getContainerPanel2());
										    	page.getPageModel().getContainerPanel1().repaint();
												page.getPageModel().getContainerPanel1().validate();
										    	
											}
							}else {
								if (tableauCheckBox[0]) {
									page.getPageModel().getOrdAnnuelTextField().setText(Integer.toString(identifiantArg ));
								}
								if (tableauCheckBox[1]) {
									page.getPageModel().getDesignationTextField().setText(userN);
								}
								if (tableauCheckBox[2]) {
									page.getPageModel().getListeDeroulantFirst().setSelectedIndex(indexChoosed3);
								}
						     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
						     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
								
						     	Object[][] listPerso = new Object[res_to_search.size()][4] ;
								for (int i = 0; i < res_to_search.size(); i++) {
									listPerso[i][0] =res_to_search.get(i).getId() ;
									listPerso[i][1] =res_to_search.get(i).getUserName() ;
									listPerso[i][2] =res_to_search.get(i).getPassword() ;
									listPerso[i][3] =res_to_search.get(i).getType() ;

								}
						     	String title[] = {"Identifiant","Nom d'utilisateur","Mot De Passe","Type"};
							DefaultTableModel newTable = new DefaultTableModel(listPerso, title) {
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
						                page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 1));
						                page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
						                String type = (String)page.getPageModel().getTable().getValueAt(i, 3) ;
						                if (type.equals("administrateur") ) {
						                	page.getPageModel().getListeDeroulant().setSelectedIndex(0) ;
										}else if (type.equals("normal") ){
						                	page.getPageModel().getListeDeroulant().setSelectedIndex(1) ;
										}		
						          }
						        });
						   page.getPageModel().getTable().setRowHeight(30);
						   page.getPageModel().getTable().setBackground(new Color(235, 242, 234));
						   page.getPageModel().getTable().setShowVerticalLines(true); 
						   page.getPageModel().getTable().setFillsViewportHeight(true);
						   if (page.getPageModel().getTable().getRowCount() == 1) {
								page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
							}else if (page.getPageModel().getTable().getRowCount() < 8) {
								page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
							}else {
								page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,250));
							}
						   JScrollPane scrollPane=new JScrollPane(page.getPageModel().getTable());
						   scrollPane.setBorder(null);
						   page.getPageModel().getTableContainer().removeAll();
						   page.getPageModel().getTableContainer().add(scrollPane);
						   page.getPageModel().getContainerPanel1().validate();
							}					
							
					}else {
						new Alert("Erreur : Le nouveau identifiant saisi existe déjà") ;
					}
					
				}
			}else {
				new Alert("Erreur : L'identifiant doit être un nombre") ;
			}
			}
		}
		
		
	}

}

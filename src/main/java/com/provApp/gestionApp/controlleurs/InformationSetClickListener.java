package com.provApp.gestionApp.controlleurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.DataEntity;
import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.models.DateLabelFormatter;
import com.provApp.gestionApp.views.InformationSet;

@Component
public class InformationSetClickListener implements ActionListener{

	public InformationSet page ;
	public JPanel container  ;
	public Boolean tableauCheckBox[] = {false,false,false,false,false};
	public int ordAnnuel ;public Date date ;public String designation ;public String analyse ;public String division ;

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
				JLabel ordAnnuel = new JLabel("Numéro d'ordre annuel :");
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
					gridBagConstraints.gridy = page.getPageModel().getCompteur() ;
					JLabel dateArrivee = new JLabel("Date d'arrivée :");
					dateArrivee.setFont(new Font(null, Font.BOLD, 14));
					panelGridBag.add(dateArrivee, gridBagConstraints);
					
						gridBagConstraints.gridx = 1;  
						gridBagConstraints.gridy = page.getPageModel().getCompteur();
					
						// date field
					SqlDateModel model = new SqlDateModel();
					JPanel dateP = new JPanel(new GridLayout()) ;
					dateP.setBorder(new EmptyBorder(6,0,0,0));
					Properties p = new Properties();
				    p.put("text.today", "Today");
				    p.put("text.month", "Month");
				    p.put("text.year", "Year");
					JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
					page.getPageModel().setDatePicker( new JDatePickerImpl(datePanel, new DateLabelFormatter()) );
					page.getPageModel().getDatePicker().setBackground(new Color(235, 242, 234));
					page.getPageModel().getDatePicker().getComponent(0).setFont(new Font(null, Font.BOLD, 12));
					page.getPageModel().getDatePicker().getComponent(1).setBackground(new Color(136, 140, 70));
					
					page.getPageModel().getDatePicker().getComponent(1).addMouseListener(page.getPageModel().getMouseClassListener());

					dateP.setBackground(new Color(235, 242, 234));
					dateP.add(page.getPageModel().getDatePicker()) ;	
					panelGridBag.add(dateP, gridBagConstraints);
					page.getPageModel().setCompteur(page.getPageModel().getCompteur() + 1);
				
			}
			if (page.getPageModel().getCheckBox3().isSelected()) {
				gridBagConstraints.gridx = 0;  
				gridBagConstraints.gridy = page.getPageModel().getCompteur();
				JLabel designationLabel = new JLabel("Expéditeur :");
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
			if (page.getPageModel().getCheckBox4().isSelected()) {
				gridBagConstraints.gridx = 0;  
				gridBagConstraints.gridy = page.getPageModel().getCompteur();
				JLabel analyseLabel = new JLabel("Objet :");
				analyseLabel.setFont(new Font(null, Font.BOLD, 14));
				panelGridBag.add(analyseLabel, gridBagConstraints);
				
					gridBagConstraints.gridx = 1;  
					gridBagConstraints.gridy = page.getPageModel().getCompteur();
					page.getPageModel().setAnalyseTextField( new JTextField() );
					page.getPageModel().getAnalyseTextField().setFont(new Font(null, Font.BOLD, 12));
					page.getPageModel().getAnalyseTextField().setPreferredSize(new Dimension(80, 30));
				panelGridBag.add(page.getPageModel().getAnalyseTextField(), gridBagConstraints);
				page.getPageModel().setCompteur(page.getPageModel().getCompteur() + 1);
			}
			if (page.getPageModel().getCheckBox5().isSelected()) {
				gridBagConstraints.gridx = 0;  
				gridBagConstraints.gridy = page.getPageModel().getCompteur();
				JLabel divisionLabel = new JLabel("Division :");
				divisionLabel.setFont(new Font(null, Font.BOLD, 14));
				panelGridBag.add(divisionLabel, gridBagConstraints);
				
					gridBagConstraints.gridx = 1;  
					gridBagConstraints.gridy = page.getPageModel().getCompteur();
					page.getPageModel().setDivisionTextField( new JTextField() );
					page.getPageModel().getDivisionTextField().setFont(new Font(null, Font.BOLD, 12));
					page.getPageModel().getDivisionTextField().setPreferredSize(new Dimension(80, 30));
				panelGridBag.add(page.getPageModel().getDivisionTextField(), gridBagConstraints);
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
				page.getPageModel().getText5().setText("") ; // textField
		     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
		     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
				page.getPageModel().getContainerPanel2().remove(page.getPageModel().getPana());
				page.getPageModel().getContainerPanel1().remove(page.getPageModel().getContainerPanel2());
				page.getPageModel().getTableContainer().removeAll();
			}
			
			page.getPageModel().getContainerPanel1().repaint();
			page.getPageModel().getContainerPanel1().validate();
		
		}else if ( e.getSource() == page.getPageModel().getButtonChercher() ) {
			ChercherInformation inistialisation = page.getAppContext().getBean(ChercherInformation.class) ;
			tableauCheckBox[0] = page.getPageModel().getCheckBox1().isSelected();
			tableauCheckBox[1] = page.getPageModel().getCheckBox2().isSelected();
			tableauCheckBox[2] = page.getPageModel().getCheckBox3().isSelected();
			tableauCheckBox[3] = page.getPageModel().getCheckBox4().isSelected();
			tableauCheckBox[4] = page.getPageModel().getCheckBox5().isSelected();
			Date selectedDateForSearch ;
			if (tableauCheckBox[1]) {
				selectedDateForSearch = (java.sql.Date) page.getPageModel().getDatePicker().getModel().getValue() ;
			}else {
				selectedDateForSearch = null ;
			}
			
			if (( tableauCheckBox[0] && page.getPageModel().getOrdAnnuelTextField().getText().isEmpty() ) || ( tableauCheckBox[1] && selectedDateForSearch == (null) ) ||( tableauCheckBox[2] && page.getPageModel().getDesignationTextField().getText().isEmpty() ) || ( tableauCheckBox[3] && page.getPageModel().getAnalyseTextField().getText().isEmpty() ) || ( tableauCheckBox[4] && page.getPageModel().getDivisionTextField().getText().isEmpty() )) {
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
					date = selectedDateForSearch ;
				}else {
					String str="1000-01-01";  
				    date=Date.valueOf(str);
				}
				if (tableauCheckBox[2]) {
					designation = page.getPageModel().getDesignationTextField().getText() ;
				}else {
					designation = "" ;
				}
				if (tableauCheckBox[3]) {
					analyse = page.getPageModel().getAnalyseTextField().getText() ;
				}else {
					analyse = "" ;
				}
				if (tableauCheckBox[4]) {
					division = page.getPageModel().getDivisionTextField().getText() ;
				}else {
					division = "" ;
				}
				
				
				List<DataEntity> res_to_search = inistialisation.trouverDonnees1(ordAnnuel, date, designation, analyse, division, tableauCheckBox) ;
				if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
					new Alert("Aucun résultat pour votre recherche");
				}else {
					Object[][] dataPerso = new Object[res_to_search.size()][5] ;
					for (int i = 0; i < res_to_search.size(); i++) {
						dataPerso[i][0] =res_to_search.get(i).getId() ;
						dataPerso[i][1] =res_to_search.get(i).getDate() ;
						dataPerso[i][2] =res_to_search.get(i).getDesignation() ;
						dataPerso[i][3] =res_to_search.get(i).getAnalyse() ;
						dataPerso[i][4] =res_to_search.get(i).getDivision() ;

					}
				String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
				DefaultTableModel newTable = new DefaultTableModel(dataPerso, title) {
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
			                int year =Integer.parseInt( page.getPageModel().getTable().getValueAt(i, 1).toString().substring(0, 4) ) ; // to help setting a new date
			                int month = Integer.parseInt( page.getPageModel().getTable().getValueAt(i, 1).toString().substring(5, 7) );
			                int day = Integer.parseInt(  page.getPageModel().getTable().getValueAt(i, 1).toString().substring(8, 10) );
			                page.getPageModel().getDatePickerForResult().getModel().setYear(year) ;
			                page.getPageModel().getDatePickerForResult().getModel().setMonth(month - 1) ; page.getPageModel().getDatePickerForResult().getModel().setDay(day) ;
			                page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
			                page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
			                page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
			          }
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
			     	page.getPageModel().getText5().setText("") ; // textField
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
				new Alert("Erreur : Le numéro d'ordre annuel doit être un nombre") ;
			}
			
			}
		}else if ( e.getSource() == page.getPageModel().getValiderUpdate() ) {
			
			
			UpdateInformation updtInfo = page.getAppContext().getBean(UpdateInformation.class) ;
			Date selectedDate = (java.sql.Date) page.getPageModel().getDatePickerForResult().getModel().getValue() ;
			if (page.getPageModel().getText1().getText().isEmpty() || selectedDate == (null) || page.getPageModel().getText3().getText().isEmpty() || page.getPageModel().getText4().getText().isEmpty() || page.getPageModel().getText5().getText().isEmpty()) {
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
					
					updtInfo.updtInformation(Integer.parseInt(page.getPageModel().getText1().getText()),Integer.parseInt(page.getPageModel().getText1New().getText()) , selectedDate , page.getPageModel().getText3().getText(), page.getPageModel().getText4().getText(), page.getPageModel().getText5().getText());
					//// from here  the content changes when we click update we have the table get updated too
					Date camDate = null ;
					if (tableauCheckBox[1]) {
						camDate = selectedDate;
					}else {
						camDate = date ;
					}
					String camDesig = "" ;
					if (tableauCheckBox[2]) {
						camDesig = page.getPageModel().getText3().getText();
					}else {
						camDesig = designation ;
					}
					String camAnalyse = "" ;
					if (tableauCheckBox[3]) {
						camAnalyse = page.getPageModel().getText4().getText();
					}else {
						camAnalyse = analyse ;
					}
					String camDiv = "" ;
					if (tableauCheckBox[4]) {
						camDiv = page.getPageModel().getText5().getText();
					}else {
						camDiv = division ;
					}	
					ChercherInformation inistialisation = page.getAppContext().getBean(ChercherInformation.class) ;

						List<DataEntity> res_to_search = inistialisation.trouverDonnees1(ordAnnuel, camDate, camDesig, camAnalyse, camDiv, tableauCheckBox) ;
						if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
							 if ( page.getPageModel().getTableContainer().getComponentCount() != 0) {
							     	page.getPageModel().getText5().setText("") ; // textField
							     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
							     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
							    	page.getPageModel().getContainerPanel1().remove(page.getPageModel().getContainerPanel2());
							    	page.getPageModel().getContainerPanel1().repaint();
									page.getPageModel().getContainerPanel1().validate();
							    	
								}
						}else {
							if (tableauCheckBox[1]) {
								page.getPageModel().getDatePicker().getModel().setDay(camDate.toLocalDate().getDayOfMonth());
								page.getPageModel().getDatePicker().getModel().setMonth(camDate.toLocalDate().getMonthValue() -1 );
								page.getPageModel().getDatePicker().getModel().setYear(camDate.toLocalDate().getYear());
							}
							if (tableauCheckBox[2]) {
								page.getPageModel().getDesignationTextField().setText(camDesig);
							}
							if (tableauCheckBox[3]) {
								page.getPageModel().getAnalyseTextField().setText(camAnalyse);
							}
							if (tableauCheckBox[4]) {
								page.getPageModel().getDivisionTextField().setText(camDiv);
							}
							page.getPageModel().getText5().setText("") ; // textField
					     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
					     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
						
					     	Object[][] dataPerso = new Object[res_to_search.size()][5] ;
							for (int i = 0; i < res_to_search.size(); i++) {
								dataPerso[i][0] =res_to_search.get(i).getId() ;
								dataPerso[i][1] =res_to_search.get(i).getDate() ;
								dataPerso[i][2] =res_to_search.get(i).getDesignation() ;
								dataPerso[i][3] =res_to_search.get(i).getAnalyse() ;
								dataPerso[i][4] =res_to_search.get(i).getDivision() ;

							}	
					     String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
						DefaultTableModel newTable = new DefaultTableModel(dataPerso, title) {
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
					                int year =Integer.parseInt( page.getPageModel().getTable().getValueAt(i, 1).toString().substring(0, 4) ) ; // to help setting a new date
					                int month = Integer.parseInt( page.getPageModel().getTable().getValueAt(i, 1).toString().substring(5, 7) );
					                int day = Integer.parseInt(  page.getPageModel().getTable().getValueAt(i, 1).toString().substring(8, 10) );
					                page.getPageModel().getDatePickerForResult().getModel().setYear(year) ;
					                page.getPageModel().getDatePickerForResult().getModel().setMonth(month - 1) ; page.getPageModel().getDatePickerForResult().getModel().setDay(day) ;
					                page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
					                page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
					                page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
					          }
					        });
					   page.getPageModel().getTable().setRowHeight(30);
					   page.getPageModel().getTable().setBackground(new Color(235, 242, 234));
					   page.getPageModel().getTable().setShowVerticalLines(true); 
					   page.getPageModel().getTable().setFillsViewportHeight(true);
					   
					   JScrollPane scrollPane=new JScrollPane(page.getPageModel().getTable());
					   scrollPane.setBorder(null);
					   page.getPageModel().getTableContainer().removeAll();
					   page.getPageModel().getTableContainer().add(scrollPane);
					   page.getPageModel().getContainerPanel1().validate();
						}
					
				} else {
					ChercherInformation cherchIfAlreadyExist = page.getAppContext().getBean(ChercherInformation.class) ;

					Optional<DataEntity> result = cherchIfAlreadyExist.faireLaRecherche( Integer.parseInt(page.getPageModel().getText1New().getText()) ) ;
					if ( result.isEmpty()) {
						updtInfo.updtInformation(Integer.parseInt(page.getPageModel().getText1().getText()),Integer.parseInt(page.getPageModel().getText1New().getText()) , selectedDate , page.getPageModel().getText3().getText(), page.getPageModel().getText4().getText(), page.getPageModel().getText5().getText());
						//// from here  the content changes when we click update we have the table get updated too
						ChercherInformation inistialisation = page.getAppContext().getBean(ChercherInformation.class) ;	
							int ordAnnuelArg ;// Date dateArg ;// 				selectedDateForSearch = (java.sql.Date) page.getPageModel().getDatePicker().getModel().getValue() ;
							if (tableauCheckBox[0]) {
								ordAnnuelArg = Integer.parseInt( page.getPageModel().getText1New().getText() );
							}else {
								ordAnnuelArg = ordAnnuel ;
							}
							Date camDate = null ;
							if (tableauCheckBox[1]) {
								camDate = selectedDate;
							}else {
								camDate = date ;
							}
							String camDesig = "" ;
							if (tableauCheckBox[2]) {
								camDesig = page.getPageModel().getText3().getText();
							}else {
								camDesig = designation ;
							}
							String camAnalyse = "" ;
							if (tableauCheckBox[3]) {
								camAnalyse = page.getPageModel().getText4().getText();
							}else {
								camAnalyse = analyse ;
							}
							String camDiv = "" ;
							if (tableauCheckBox[4]) {
								camDiv = page.getPageModel().getText5().getText();
							}else {
								camDiv = division ;
							}
							List<DataEntity> resultData = inistialisation.trouverDonnees1(ordAnnuelArg /* ordAnnuel */, camDate, camDesig, camAnalyse, camDiv, tableauCheckBox) ;
							if (resultData.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
								 if ( page.getPageModel().getTableContainer().getComponentCount() != 0) {
										     	page.getPageModel().getText5().setText("") ; // textField
										     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
										     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
										    	page.getPageModel().getContainerPanel1().remove(page.getPageModel().getContainerPanel2());
										    	page.getPageModel().getContainerPanel1().repaint();
												page.getPageModel().getContainerPanel1().validate();
								 }
							}else {
								if (tableauCheckBox[0]) {
									page.getPageModel().getOrdAnnuelTextField().setText(Integer.toString(ordAnnuelArg ));
								}
								if (tableauCheckBox[1]) {
									page.getPageModel().getDatePicker().getModel().setDay(camDate.toLocalDate().getDayOfMonth());
									page.getPageModel().getDatePicker().getModel().setMonth(camDate.toLocalDate().getMonthValue() - 1);
									page.getPageModel().getDatePicker().getModel().setYear(camDate.toLocalDate().getYear());
								}
								if (tableauCheckBox[2]) {
									page.getPageModel().getDesignationTextField().setText(camDesig);
								}
								if (tableauCheckBox[3]) {
									page.getPageModel().getAnalyseTextField().setText(camAnalyse);
								}
								if (tableauCheckBox[4]) {
									page.getPageModel().getDivisionTextField().setText(camDiv);
								}
								page.getPageModel().getText5().setText("") ; // textField
						     	page.getPageModel().getText4().setText("") ;  page.getPageModel().getText3().setText("") ;  // textArea
						     	page.getPageModel().getText1().setText("") ; page.getPageModel().getText1New().setText("") ; // textField
							
					     	Object[][] listPerso = new Object[resultData.size()][5] ;
							for (int i = 0; i < resultData.size(); i++) {
								listPerso[i][0] =resultData.get(i).getId() ;
								listPerso[i][1] =resultData.get(i).getDate() ;
								listPerso[i][2] =resultData.get(i).getDesignation() ;
								listPerso[i][3] =resultData.get(i).getAnalyse() ;
								listPerso[i][4] =resultData.get(i).getDivision() ;
							} 	
						    String title[] = {"Numéro Ordre Annuel","Date Arrivée","Expéditeur","Objet","Division"};
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
						                int year =Integer.parseInt( page.getPageModel().getTable().getValueAt(i, 1).toString().substring(0, 4) ) ; // to help setting a new date
						                int month = Integer.parseInt( page.getPageModel().getTable().getValueAt(i, 1).toString().substring(5, 7) );
						                int day = Integer.parseInt(  page.getPageModel().getTable().getValueAt(i, 1).toString().substring(8, 10) );
						                page.getPageModel().getDatePickerForResult().getModel().setYear(year) ;
						                page.getPageModel().getDatePickerForResult().getModel().setMonth(month - 1) ; page.getPageModel().getDatePickerForResult().getModel().setDay(day) ;
						                page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
						                page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
						                page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 4));
						          }
						        });
						   page.getPageModel().getTable().setRowHeight(30);
						   page.getPageModel().getTable().setBackground(new Color(235, 242, 234));
						   page.getPageModel().getTable().setShowVerticalLines(true); 
						   page.getPageModel().getTable().setFillsViewportHeight(true);
						   
						   JScrollPane scrollPane=new JScrollPane(page.getPageModel().getTable());
						   scrollPane.setBorder(null);
						   page.getPageModel().getTableContainer().removeAll();
						   page.getPageModel().getTableContainer().add(scrollPane);
						   page.getPageModel().getContainerPanel1().validate();
							}					
							
					}else {
						new Alert("Erreur : Le nouveau numéro d'ordre annuel saisi existe déjà") ;
					}
				}
				

				
			}else {
				new Alert("Erreur : Le numéro d'ordre annuel doit être un nombre") ;
			}
			}
		}
		

	} 
}

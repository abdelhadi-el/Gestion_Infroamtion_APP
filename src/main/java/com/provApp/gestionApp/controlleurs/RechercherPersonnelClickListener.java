package com.provApp.gestionApp.controlleurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.entities.PersonnelEntity;
import com.provApp.gestionApp.models.Alert;
import com.provApp.gestionApp.views.RechercherPersonnel;

@Component
public class RechercherPersonnelClickListener implements ActionListener{

	RechercherPersonnel page ;
	ActionEvent eSrc ;
	String lastButtonClicked ; // for buttons 

	
	public RechercherPersonnel getPage() {
		return page;
	}

	public void setPage(RechercherPersonnel page) {
		this.page = page;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == page.getPageModel().getListeDeroulant() ) { //////////////////////////////////////////////////////////  1
			int indexChoosed = page.getPageModel().getListeDeroulant().getSelectedIndex();
			page.getPageModel().getListeDeroulant().setBackground(new Color(146, 135, 60));
			switch (indexChoosed) {
			case 0:
				page.getPageModel().getNumOrderAnnuel().setEditable(false) ; page.getPageModel().getDesignationField().setEditable(false) ;
				page.getPageModel().getListeDeroulant1().setEnabled(false) ;	
				page.getPageModel().getRechInfo().setEnabled(false); 
				page.getPageModel().getRechInfoDesignation().setEnabled(false); page.getPageModel().getRechInfodivision().setEnabled(false);
				break;
			case 1 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(true) ; page.getPageModel().getDesignationField().setEditable(false) ;
				page.getPageModel().getListeDeroulant1().setEnabled(false) ;	
				page.getPageModel().getRechInfo().setEnabled(true);  
				page.getPageModel().getRechInfoDesignation().setEnabled(false); page.getPageModel().getRechInfodivision().setEnabled(false);
				break ;
			case 2 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(false) ; page.getPageModel().getDesignationField().setEditable(true) ;
				page.getPageModel().getListeDeroulant1().setEnabled(false) ;	
				page.getPageModel().getRechInfo().setEnabled(false);  
				page.getPageModel().getRechInfoDesignation().setEnabled(true); page.getPageModel().getRechInfodivision().setEnabled(false);
				break ;
			case 3 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(false) ; page.getPageModel().getDesignationField().setEditable(false) ;
				page.getPageModel().getListeDeroulant1().setEnabled(true) ;	
				page.getPageModel().getRechInfo().setEnabled(false);
				page.getPageModel().getRechInfoDesignation().setEnabled(false); page.getPageModel().getRechInfodivision().setEnabled(true);
				break ;
			case 4 : 
				page.getPageModel().getNumOrderAnnuel().setEditable(true) ; page.getPageModel().getDesignationField().setEditable(true) ;
				page.getPageModel().getListeDeroulant1().setEnabled(true) ;	
				page.getPageModel().getRechInfo().setEnabled(true); 
				page.getPageModel().getRechInfoDesignation().setEnabled(true); page.getPageModel().getRechInfodivision().setEnabled(true);
				break ;
			default:
				break;
			}

		} else if ( e.getSource() == page.getPageModel().getRechInfo() ) { //////////IDENTIFIANT/////////////////////////////////////  2
			
			deleteFieldContent(e);
			page.getPageModel().getNumOrderAnnuel().setText( page.getPageModel().getNumOrderAnnuel().getText());
			if (page.getPageModel().getNumOrderAnnuel().getText().isEmpty()) {
				new Alert("Remplir d'abord le champ");
			}else {
				int value_to_search = -1;
			try {
				Boolean boolResult = Pattern.matches("[0-9]*", page.getPageModel().getNumOrderAnnuel().getText());
				
				if (boolResult) { 
					
					value_to_search = Integer.parseInt( page.getPageModel().getNumOrderAnnuel().getText() ) ;
					ChercherPersonnel inistialisation  = page.getAppContext().getBean(ChercherPersonnel.class) ;

					Object[] res_to_search = inistialisation.faireLaRecherche(value_to_search);
					if (res_to_search == null) {   // to avoid creating a new Jframe when there is no result for the query
						new Alert("Aucun résultat pour votre recherche");
						page.getPageModel().getPana().setVisible(false);
					}else {
						if (page.getPageModel().getTableContainer().getComponentCount() != 0) { // supprimer des composants s'ils sont existants
							page.getPageModel().getTableContainer().removeAll();
							page.getPageModel().getPanel().removeAll();
							page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
							page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
							page.getPageModel().getFl().repaint();
							page.getPageModel().getFl().validate();
						}
						page.getPageModel().getPana().setVisible(true);
						// for having view updated, to supprimer button purpose
						lastButtonClicked = "RechNumOrd" ;
						
					String title[] = {"Identifiant","Nom d'utilisateur","Mot De Passe","Type"};
					Object[][] dataTable = new Object[1][4] ;
					for(int i=0;i<res_to_search.length;i++)
					{
						dataTable[0][i]=res_to_search[i];	
					}
					
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
				        	  	page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 1));
				        	  	page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
				        	  	page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
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
					page.getPageModel().getPanel().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().setBackground(new Color(242, 234, 237));
					page.getPageModel().getTableContainer().setBorder(new EmptyBorder(35, 0, 0, 0));
					if (page.getPageModel().getTable().getRowCount() == 1) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,100));
					}else if (page.getPageModel().getTable().getRowCount() < 8) {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,150));
					}else {
						page.getPageModel().getTableContainer().setPreferredSize(new Dimension(140,190));
					}		
					page.getPageModel().getTableContainer().add(scrollPane);
					page.getPageModel().getPanel().add(page.getPageModel().getTableContainer(), gridBagConstraints);
					page.getPageModel().getFl().add(page.getPageModel().getPanel(), BorderLayout.CENTER) ;
					page. getPageModel().getFl().validate();
					}
					}else {
					new Alert("Erreur : L'identifiant doit être un nombre") ;
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
			ChercherPersonnel inistialisation1 = page.getAppContext().getBean(ChercherPersonnel.class);
			List<PersonnelEntity> listPerso= inistialisation1.faireLaRecherche1() ;
			
			if (listPerso.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
				new Alert("Aucun résultat pour votre recherche");
				page.getPageModel().getPana().setVisible(false);
			}else {
			
				// for having view updated, to supprimer button purpose
				lastButtonClicked = "RechAll" ;
				eSrc = e ;
			Object[][] res_of_search = new Object[listPerso.size()][4] ;
			for (int i = 0; i < listPerso.size(); i++) {
				res_of_search[i][0] =listPerso.get(i).getId() ;
				res_of_search[i][1] =listPerso.get(i).getUserName() ;
				res_of_search[i][2] =listPerso.get(i).getPassword() ;
				res_of_search[i][3] =listPerso.get(i).getType() ;

			}
				
			String title[] = {"Identifiant","Nom d'utilisateur","Mot De Passe","Type"};
			DefaultTableModel newTable = new DefaultTableModel(res_of_search, title){
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
			    	  	page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 1));
			    	  	page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
			    	  	page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
			      }
			    });

			page.getPageModel().getTable().setShowVerticalLines(true);
			page.getPageModel().getTable().setBackground(new Color(235, 242, 234)); 
			page.getPageModel().getTable().setRowHeight(30);
			page.getPageModel().getTable().setFillsViewportHeight(true);
			JScrollPane scrollPane = new JScrollPane(page.getPageModel().getTable());
			scrollPane.setBorder(null);
			page.getPageModel().setPanel( new JPanel(new GridBagLayout()) );
			GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL ;
			gridBagConstraints.gridx = 0;  
			gridBagConstraints.gridy = 0; 
			gridBagConstraints.weightx = 0.5;
			gridBagConstraints.weighty = 0.5 ;
			
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
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); 
			
			page.getPageModel().getPanel().add(page.getPageModel().getTableContainer(), gridBagConstraints);
			page.getPageModel().getFl().add(page.getPageModel().getPanel(), BorderLayout.CENTER) ;
			page.getPageModel().getFl().revalidate();

			}
			
			
		}else if ( e.getSource() == page.getPageModel().getRechInfoDesignation() ) { ////////USERNAME////////////////////////////////  5
			
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
					
					ChercherPersonnel inistialisation = page.getAppContext().getBean(ChercherPersonnel.class);
					List<PersonnelEntity> res_to_search = inistialisation.trouverDonnees3(designation) ;
					if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
						new Alert("Aucun résultat pour votre recherche");
						page.getPageModel().getPana().setVisible(false);
					}else {
						
						// for having view updated, to supprimer button purpose
						lastButtonClicked = "RechDesignation" ;
						eSrc = e ;
						Object[][] dataPerso = new Object[res_to_search.size()][4] ;
						for (int i = 0; i < res_to_search.size(); i++) {
							dataPerso[i][0] =res_to_search.get(i).getId() ;
							dataPerso[i][1] =res_to_search.get(i).getUserName() ;
							dataPerso[i][2] =res_to_search.get(i).getPassword() ;
							dataPerso[i][3] =res_to_search.get(i).getType() ;

						}
						String title[] = {"Identifiant","Nom d'utilisateur","Mot De Passe","Type"};
					DefaultTableModel newTable = new DefaultTableModel(dataPerso, title){
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
					    	  	page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 1));
					    	  	page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
					    	  	page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
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
		}else if ( e.getSource() == page.getPageModel().getRechInfodivision() ) { //////////TYPE////////////////////////////  6
			
			deleteFieldContent(e);
			if (page.getPageModel().getTableContainer().getComponentCount() != 0) { // supprimer des composants s'ils sont existants
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
			}
			String division = "administrateur";
			int indexChoosed = page.getPageModel().getListeDeroulant1().getSelectedIndex();
			if (indexChoosed == 0) {
				division = "administrateur" ;
			}else {
				division = "normal" ;
			}
					ChercherPersonnel inistialisation = page.getAppContext().getBean(ChercherPersonnel.class);
					List<PersonnelEntity> res_to_search = inistialisation.trouverDonnees4(division) ;
					if (res_to_search.size() == 0) {   // to avoid creating a new Jframe when there is no result for the query
						new Alert("Aucun résultat pour votre recherche");
						page.getPageModel().getPana().setVisible(false);
					}else {
						
						// for having view updated, to supprimer button purpose
						lastButtonClicked = "RechDivision" ;
						eSrc = e ;
						Object[][] dataPerso = new Object[res_to_search.size()][4] ;
						for (int i = 0; i < res_to_search.size(); i++) {
							dataPerso[i][0] =res_to_search.get(i).getId() ;
							dataPerso[i][1] =res_to_search.get(i).getUserName() ;
							dataPerso[i][2] =res_to_search.get(i).getPassword() ;
							dataPerso[i][3] =res_to_search.get(i).getType() ;

						}
						String title[] = {"Identifiant","Nom d'utilisateur","Mot De Passe","Type"};
					DefaultTableModel newTable = new DefaultTableModel(dataPerso, title){
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
					        page.getPageModel().getText3().setText((String)page.getPageModel().getTable().getValueAt(i, 1));
					        page.getPageModel().getText4().setText((String)page.getPageModel().getTable().getValueAt(i, 2));
					        page.getPageModel().getText5().setText((String)page.getPageModel().getTable().getValueAt(i, 3));
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
					
			
		}else if ( e.getSource() == page.getPageModel().getSupprimer() ) { //////////////////////////////////////////////////////////  7
		
			int reponse = JOptionPane.showConfirmDialog(null,
		            "Vous voulez vraiment supprimer cette donnée", "Faite attention !!",
		            JOptionPane.YES_NO_OPTION); 
			switch (reponse) {
			case JOptionPane.YES_OPTION:
			SupprimerInformation suppInfo = page.getAppContext().getBean(SupprimerInformation.class);
			suppInfo.suppPersonnel(Integer.parseInt(page.getPageModel().getText1().getText()));
			if ( lastButtonClicked == "RechNumOrd" ) {   // to have view updated
				page.getPageModel().getTableContainer().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getTableContainer() );
				page.getPageModel().getPana().setVisible(false);
				
				page.getPageModel().getPanel().removeAll();
				page.getPageModel().getFl().remove( page.getPageModel().getPanel() );
				
				page.getPageModel().getFl().repaint();
				page.getPageModel().getFl().validate();
			} else if ( lastButtonClicked == "RechAll" ) { //  we could just call the method actionPerf directly
				actionPerformed(eSrc);
			}else if ( lastButtonClicked == "RechDesignation" ) {
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
			
			page.getPageModel().getDesignationField().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		} else if ( e.getSource() == page.getPageModel().getRechAllInfo() ) {
			
			page.getPageModel().getDesignationField().setText("");
			page.getPageModel().getNumOrderAnnuel().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		} else if ( e.getSource() == page.getPageModel().getRechInfoDesignation() ) {
			
			page.getPageModel().getNumOrderAnnuel().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		} else if ( e.getSource() == page.getPageModel().getRechInfodivision() ) {
			
			page.getPageModel().getNumOrderAnnuel().setText("");
			page.getPageModel().getDesignationField().setText("");
			
			page.getPageModel().getText1().setText("");
			page.getPageModel().getText3().setText("");
			page.getPageModel().getText4().setText("");
			page.getPageModel().getText5().setText("");
			
		}
		
	}

	
}

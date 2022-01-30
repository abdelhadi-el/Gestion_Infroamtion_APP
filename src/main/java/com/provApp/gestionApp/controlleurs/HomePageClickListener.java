package com.provApp.gestionApp.controlleurs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.WindowConstants;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.HomePage;
import com.provApp.gestionApp.views.InformationAdd;
import com.provApp.gestionApp.views.InformationCherche;
import com.provApp.gestionApp.views.InformationSet;

@Component
public class HomePageClickListener implements ActionListener {
	
	public HomePage pageModel ;
//	@Autowired
//	HomePage newHomeP ;
//	@Autowired
//	@Qualifier("homePageModel")
//	HomePageModel homePModel ;
//	@Autowired
//	HomePageClickListener clickClassForNewConn ;
//	@Autowired
//	HomePageMouseListener mouseClassForNewConn ;
	
	Boolean inLoginPage = true;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == pageModel.getPageModel().getRechInfo() ) {
			pageModel.getPageModel().getRechInfo().setEnabled(false);
			pageModel.getPageModel().getRechInfo().setForeground(new Color(255,255,255));

//			if ( pageModel.getAdminRightPartExists() == true ) {
//				ap
//			}
			
			if (pageModel.getPageModel().getAddInfo().isEnabled() == false) {
				pageModel.getPageModel().setButton2( true ) ;
			}else if ( pageModel.getPageModel().getSetInfo().isEnabled() == false ) {
				pageModel.getPageModel().setButton3( true ) ;
			}
			System.out.println(pageModel.getPageModel().getAdminRightPartExists());
//			if ( pageModel.getRighViewAdmin() != null ) {
//				System.out.println("okk");
//			}
			if ( pageModel.getPageModel().getAdminRightPartExists() ) {
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getRechPersonnel().setEnabled(true);
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getAddPersonnel().setEnabled(true);
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getSetPersonnel().setEnabled(true);
			}
			//pageModel.getPageModel().getRighViewAdmin().getPageModel().getRechPersonnel().setEnabled(true);
//			if ( pageModel.getAdminRightPartExists() ) {
//			 	BorderLayout lay = (BorderLayout) pageModel.getPageModel().getFrame().getLayout() ;
//			 	pageModel.getPageModel().getFrame().remove( lay.getLayoutComponent(BorderLayout.LINE_END) );
//			 	RightPartOfAdminView rightView = new RightPartOfAdminView( pageModel ) ;
//				
//				pageModel.getPageModel().getFrame().getContentPane().add( rightView.getPageModel().getPanel_container() , BorderLayout.LINE_END) ;
//			}
			if ( pageModel.getPageModel().getButton2() || pageModel.getPageModel().getButton3() || inLoginPage || true) { //not first click
				inLoginPage = false ;
				pageModel.getPageModel().getContainerP().removeAll() ;
				pageModel.getPageModel().getFrame().repaint();
				pageModel.getPageModel().getFrame().revalidate();
				//InformationCherche window = new InformationCherche();
				ApplicationContext contextRoot = pageModel.getAppContext() ; // we can try to use app field in the homePage class
				InformationCherche window = pageModel.getAppContext().getBean(InformationCherche.class) ;
				window.setAppContext(contextRoot);
				
				pageModel.getPageModel().getContainerP().add(	window.getPageModel().getPrincipalContainer(), BorderLayout.CENTER ) ;    //// aattention variable window.prin..... !!!!!!!! ????
				pageModel.getPageModel().getContainerP().setPreferredSize(new Dimension(865,960));
				pageModel.getPageModel().getFrame().repaint();
				pageModel.getPageModel().getFrame().revalidate();
				pageModel.getPageModel().getAddInfo().setEnabled(true) ; pageModel.getPageModel().getSetInfo().setEnabled(true) ;
			} // pay attention here we have supress this cuz we have true in if section
//			else { //first click
//				inLoginPage = false ;
//				InformationCherche window = new InformationCherche();
//				pageModel.getPageModel().getContainerP().add(	window.getPageModel().getPrincipalContainer(), BorderLayout.CENTER ) ; //// aattention variable window.prin..... !!!!!!!! ????
//				pageModel.getPageModel().getContainerP().setPreferredSize(new Dimension(865,960));
//				pageModel.getPageModel().setScroll( new JScrollPane( pageModel.getPageModel().getContainerP()) ) ;
//				pageModel.getPageModel().getFrame().getContentPane().add(	pageModel.getPageModel().getScroll(), BorderLayout.CENTER );
//				pageModel.getPageModel().getFrame().revalidate();
//			}

		}
		else if ( e.getSource() == pageModel.getPageModel().getAddInfo() ) { // button ajouter info cliqué
			pageModel.getPageModel().getAddInfo().setForeground(new Color(255,255,255));
			pageModel.getPageModel().getAddInfo().setEnabled(false);
			if ( pageModel.getPageModel().getRechInfo().isEnabled() == false) {
				pageModel.getPageModel().setButton1( true );
			}else if (pageModel.getPageModel().getSetInfo().isEnabled() == false) {
				pageModel.getPageModel().setButton3( true ) ;
			}
			if ( pageModel.getPageModel().getAdminRightPartExists() ) {
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getRechPersonnel().setEnabled(true);
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getAddPersonnel().setEnabled(true);
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getSetPersonnel().setEnabled(true);
			}
			if ( pageModel.getPageModel().getButton1() || pageModel.getPageModel().getButton3() || inLoginPage || true) { //not first click
				inLoginPage = false ;
				pageModel.getPageModel().getContainerP().removeAll() ;
				pageModel.getPageModel().getFrame().repaint();
				pageModel.getPageModel().getFrame().revalidate();
			//	InformationAdd window = new InformationAdd();
				
				ApplicationContext contextRoot = pageModel.getAppContext() ; // we can try to use app field in the homePage class
				InformationAdd window = pageModel.getAppContext().getBean(InformationAdd.class) ;
				window.setAppContext(contextRoot);
				pageModel.getPageModel().getContainerP().add(	window.getModelPage().getPrincipalContainer() , BorderLayout.CENTER ) ; /// aattention !!!!! ???
				pageModel.getPageModel().getContainerP().setPreferredSize(new Dimension(700,550));
				pageModel.getPageModel().getFrame().repaint();
				pageModel.getPageModel().getFrame().revalidate();
				pageModel.getPageModel().getRechInfo().setEnabled(true) ; pageModel.getPageModel().getSetInfo().setEnabled(true) ;
			}// pay attention here we have supress this cuz we have true in if section
//			else { //first click
//				inLoginPage = false ;
//				InformationAdd window = new InformationAdd();
//				pageModel.getPageModel().getContainerP().add(	window.getModelPage().getPrincipalContainer() , BorderLayout.CENTER ) ;// ???? §§§§§§!!!!!!!
//				pageModel.getPageModel().getContainerP().setPreferredSize(new Dimension(500,500));
//				pageModel.getPageModel().setScroll( new JScrollPane(pageModel.getPageModel().getContainerP()) ) ;
//				pageModel.getPageModel().getFrame().getContentPane().add(	pageModel.getPageModel().getScroll(), BorderLayout.CENTER );
//				pageModel.getPageModel().getFrame().revalidate();
//			}
		}else if ( e.getSource() == pageModel.getPageModel().getSetInfo() ) {
			pageModel.getPageModel().getSetInfo().setForeground(new Color(255,255,255));
			pageModel.getPageModel().getSetInfo().setEnabled(false);
			if ( pageModel.getPageModel().getRechInfo().isEnabled() == false ) {
				pageModel.getPageModel().setButton1( true );
			}else if ( pageModel.getPageModel().getAddInfo().isEnabled() == false ) {
				pageModel.getPageModel().setButton2( true );
			}
			if ( pageModel.getPageModel().getAdminRightPartExists() ) {
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getRechPersonnel().setEnabled(true);
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getAddPersonnel().setEnabled(true);
				pageModel.getPageModel().getRighViewAdmin().getPageModel().getSetPersonnel().setEnabled(true);
			}
			if ( pageModel.getPageModel().getButton1() || pageModel.getPageModel().getButton2() || inLoginPage || true) { //not first click
				inLoginPage = false ;
				pageModel.getPageModel().getContainerP().removeAll() ;
				pageModel.getPageModel().getFrame().repaint();
				pageModel.getPageModel().getFrame().revalidate();
			//	InformationSet window = new InformationSet();
				
				ApplicationContext contextRoot = pageModel.getAppContext() ; // we can try to use app field in the homePage class
				InformationSet window = pageModel.getAppContext().getBean(InformationSet.class) ;
				window.setAppContext(contextRoot);
				
				pageModel.getPageModel().getContainerP().add(	window.getPageModel().getPrincipalContainer(), BorderLayout.CENTER ) ; /// ????? !!!!!!!!!!
				pageModel.getPageModel().getContainerP().setPreferredSize(new Dimension(830,750));
				pageModel.getPageModel().getFrame().repaint();
				pageModel.getPageModel().getFrame().revalidate();
				pageModel.getPageModel().getRechInfo().setEnabled(true) ; pageModel.getPageModel().getAddInfo().setEnabled(true) ;
			}// pay attention here we have supress this cuz we have true in if section
//			else { //first click
//				inLoginPage = false ;
//				InformationSet window = new InformationSet();
//				pageModel.getPageModel().getContainerP().add(	window.getPageModel().getPrincipalContainer(), BorderLayout.CENTER ) ; //// ???????????!!!!!!!
//				pageModel.getPageModel().getContainerP().setPreferredSize(new Dimension(830,750));
//				pageModel.getPageModel().setScroll( new JScrollPane(pageModel.getPageModel().getContainerP()) ) ;
//				pageModel.getPageModel().getFrame().getContentPane().add(	pageModel.getPageModel().getScroll(), BorderLayout.CENTER );
//				pageModel.getPageModel().getFrame().revalidate();
//			}
		}else if( e.getSource() == pageModel.getPageModel().getSortir() ){
			pageModel.getPageModel().getFrame().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pageModel.getPageModel().getFrame().dispose();
		}else if( e.getSource() == pageModel.getPageModel().getSeDeconnecter() ){
			pageModel.getPageModel().getFrame().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pageModel.getPageModel().getFrame().dispose();
			
			//HomePage ff = new HomePage(new HomePageModel(new HomePageClickListener(), new HomePageMouseListener())) ;
			//app = new Ges
//			ApplicationContext context = new AnnotationConfigApplicationContext(conf.class);
//			if (pageModel.getAppContext() == null) {
//				ApplicationContext context = new AnnotationConfigApplicationContext(conf.class);
//
//				pageModel.setAppContext(context);
//			}
			
			//System.out.println(pageModel.getAppContext() +"\n");
			ApplicationContext contextRoot = pageModel.getAppContext() ; // we can try to use app field in the homePage class
			HomePage homep = pageModel.getAppContext().getBean(HomePage.class) ;
			homep.setAppContext(contextRoot);
//			newHomeP.setPageModel(homePModel);
			homep.getPageModel().getFrame().setVisible(true);
		}
	}
	

	


}


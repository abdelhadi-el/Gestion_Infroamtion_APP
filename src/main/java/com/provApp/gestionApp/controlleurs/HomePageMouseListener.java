package com.provApp.gestionApp.controlleurs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.HomePage;

@Component
public class HomePageMouseListener extends MouseAdapter {

	public HomePage pageModel ;
	
	@Override
	public void mouseExited(MouseEvent e) {
		if ( e.getSource() == pageModel.getPageModel().getRechInfo() ) {
			//System.out.println("here");
			Icon img = new ImageIcon(getClass().getResource("/images/search_click.png")) ;
			pageModel.getPageModel().getRechInfo().setIcon(img);
			pageModel.getPageModel().getRechInfo().setForeground(new Color(255,255,255));
		}else if ( e.getSource() == pageModel.getPageModel().getAddInfo() ) {
			Icon img1 = new ImageIcon(getClass().getResource("/images/add_click.png")) ;
			pageModel.getPageModel().getAddInfo().setIcon(img1);
			pageModel.getPageModel().getAddInfo().setForeground(new Color(255,255,255));
		}else if ( e.getSource() == pageModel.getPageModel().getSetInfo() ) {
			Icon img2 = new ImageIcon(getClass().getResource("/images/update_click.png")) ;
			pageModel.getPageModel().getSetInfo().setIcon(img2);
			pageModel.getPageModel().getSetInfo().setForeground(new Color(255,255,255));
		}else if ( e.getSource() == pageModel.getPageModel().getSortir() ) {
			Icon img3 = new ImageIcon(getClass().getResource("/images/exit_click.png")) ;
			pageModel.getPageModel().getSortir().setIcon(img3);
			pageModel.getPageModel().getSortir().setForeground(new Color(255,255,255));
		}else if ( e.getSource() == pageModel.getPageModel().getSeDeconnecter() ) {
			Icon img3 = new ImageIcon(getClass().getResource("/images/exit_click.png")) ;
			pageModel.getPageModel().getSeDeconnecter().setIcon(img3);
			pageModel.getPageModel().getSeDeconnecter().setForeground(new Color(255, 255, 255));
		}
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if ( e.getSource() == pageModel.getPageModel().getRechInfo() ) {
			Icon img = new ImageIcon(getClass().getResource("/images/search_hover.png")) ;
			pageModel.getPageModel().getRechInfo().setIcon(img);
			if (pageModel.getPageModel().getRechInfo().isEnabled()) {
				pageModel.getPageModel().getRechInfo().setForeground(new Color(102, 240, 0));
			}
			pageModel.getPageModel().getRechInfo().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}else if ( e.getSource() == pageModel.getPageModel().getAddInfo() ) {
			Icon img1 = new ImageIcon(getClass().getResource("/images/add_hover.png")) ;
			pageModel.getPageModel().getAddInfo().setIcon(img1);
			if (pageModel.getPageModel().getAddInfo().isEnabled()) {
				pageModel.getPageModel().getAddInfo().setForeground(new Color(102, 240, 0));
			}
			pageModel.getPageModel().getAddInfo().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		
		}else if ( e.getSource() == pageModel.getPageModel().getSetInfo() ) {
			Icon img2 = new ImageIcon(getClass().getResource("/images/update_hover.png")) ;
			pageModel.getPageModel().getSetInfo().setIcon(img2); 
			if (pageModel.getPageModel().getSetInfo().isEnabled()) {
				pageModel.getPageModel().getSetInfo().setForeground(new Color(102, 240, 0));
			}
			pageModel.getPageModel().getSetInfo().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}else if ( e.getSource() == pageModel.getPageModel().getSortir() ) {
			Icon img3 = new ImageIcon(getClass().getResource("/images/exit_hover.png")) ;
			pageModel.getPageModel().getSortir().setIcon(img3);
			pageModel.getPageModel().getSortir().setForeground(new Color(255, 0, 0));
			pageModel.getPageModel().getSortir().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}
		else if ( e.getSource() == pageModel.getPageModel().getSeDeconnecter() ) {
			Icon img3 = new ImageIcon(getClass().getResource("/images/exit_hover.png")) ;
			pageModel.getPageModel().getSeDeconnecter().setIcon(img3);
			pageModel.getPageModel().getSeDeconnecter().setForeground(new Color(255, 0, 0));
			pageModel.getPageModel().getSeDeconnecter().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}
		
	}
	
	
	
}

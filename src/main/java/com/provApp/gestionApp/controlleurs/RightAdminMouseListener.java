package com.provApp.gestionApp.controlleurs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.RightPartOfAdminView;

@Component
public class RightAdminMouseListener extends MouseAdapter{

	public RightPartOfAdminView pageModel ;

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if ( e.getSource() == pageModel.getPageModel().getRechPersonnel() ) {
			Icon img = new ImageIcon(getClass().getResource("/images/search_hover.png")) ;
			pageModel.getPageModel().getRechPersonnel().setIcon(img);
			if (pageModel.getPageModel().getRechPersonnel().isEnabled()) {
				pageModel.getPageModel().getRechPersonnel().setForeground(new Color(102, 240, 0));
			}
			pageModel.getPageModel().getRechPersonnel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
			
		}else if ( e.getSource() == pageModel.getPageModel().getAddPersonnel() ) {
			Icon img1 = new ImageIcon(getClass().getResource("/images/add_hover.png")) ;
			pageModel.getPageModel().getAddPersonnel().setIcon(img1);
			if (pageModel.getPageModel().getAddPersonnel().isEnabled()) {
				pageModel.getPageModel().getAddPersonnel().setForeground(new Color(102, 240, 0));
			}
			pageModel.getPageModel().getAddPersonnel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
			
		}else if (  e.getSource() == pageModel.getPageModel().getSetPersonnel() ) {
			Icon img2 = new ImageIcon(getClass().getResource("/images/update_hover.png")) ;
			pageModel.getPageModel().getSetPersonnel().setIcon(img2); 
			if (pageModel.getPageModel().getSetPersonnel().isEnabled()) {
				pageModel.getPageModel().getSetPersonnel().setForeground(new Color(102, 240, 0));
			}
			pageModel.getPageModel().getSetPersonnel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)) ;
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if ( e.getSource() == pageModel.getPageModel().getRechPersonnel() ) {
			//System.out.println("here");
			Icon img = new ImageIcon(getClass().getResource("/images/search_click.png")) ;
			pageModel.getPageModel().getRechPersonnel().setIcon(img);
			pageModel.getPageModel().getRechPersonnel().setForeground(new Color(255,255,255));
		}else if ( e.getSource() == pageModel.getPageModel().getAddPersonnel() ) {
			Icon img1 = new ImageIcon(getClass().getResource("/images/add_click.png")) ;
			pageModel.getPageModel().getAddPersonnel().setIcon(img1);
			pageModel.getPageModel().getAddPersonnel().setForeground(new Color(255,255,255));
		}else if ( e.getSource() == pageModel.getPageModel().getSetPersonnel() ) {
			Icon img2 = new ImageIcon(getClass().getResource("/images/update_click.png")) ;
			pageModel.getPageModel().getSetPersonnel().setIcon(img2);
			pageModel.getPageModel().getSetPersonnel().setForeground(new Color(255,255,255));
		}
		
		
	}
}

package com.provApp.gestionApp.controlleurs;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

@SuppressWarnings("serial")  @org.springframework.stereotype.Component
public class CustomeBorder extends AbstractBorder{
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y,
            int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(Color.black);
       // System.out.println(g2d.set);
        Shape shape = new RoundRectangle2D.Float(0, 0, c.getWidth()-3 , c.getHeight()-3, 20, 20);
        g2d.draw(shape);
    }
}
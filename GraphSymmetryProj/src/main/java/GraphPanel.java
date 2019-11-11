import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel{
	private ArrayList<Point> pointsList;
	 public GraphPanel() {
	    	setPreferredSize(new Dimension(1250, 750));
	    	setLayout(null);
	    	
	    	this.setBackground(Color.cyan);
	 }
	 
	 public void setuppointList(ArrayList<Point> pointList) {
		 pointsList = pointList;
	 }
	 
	 public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		drawPoints(page);
		
	}
	 
	 public void drawPoints(Graphics page) {
		 	int n = 100;
		 	this.setPreferredSize(new Dimension(1250 + n*3, 750 + n*3));
		 	int a = this.getWidth() / 2;
	        int b = this.getHeight() / 2;
	        int m = Math.min(a, b);
	        int r = 4 * m / 5;
	        int r2 = Math.abs(m - r) / 2;
	        for (int i = 0; i < n; i++) {
	            double t = 2 * Math.PI * i / n;
	            int x = (int) Math.round(a + r * Math.cos(t));
	            int y = (int) Math.round(b + r * Math.sin(t));
	            page.fillOval(x - r2, y - r2, 15, 15);
	        }
	 }
}

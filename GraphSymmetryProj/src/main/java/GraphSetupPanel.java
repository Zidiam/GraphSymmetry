import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GraphSetupPanel extends JPanel{
	private JTextField verticiesT;
	private JLabel verticiesF;
	private JRadioButton[][] radioButtonList;
	private ArrayList <JLabel> rowLabelList;
	private ArrayList <JLabel> colLabelList;
	private int verticies;
	private JButton enter, randomize;
	private ArrayList<Point> pointList;
	private boolean random = false;
	private Random rand = new Random();
	
	public GraphSetupPanel() {
		setPreferredSize(new Dimension(1250, 900));
    	setLayout(null);
    	
    	
    	verticies = 5;
    	rowLabelList = new ArrayList<JLabel>();
		colLabelList = new ArrayList<JLabel>();
    	setupComponents();

    	this.setBackground(Color.yellow);
	}
	
	public int getVerticies() {
		return verticies;
	}
	
	public ArrayList<Point> getpointList(){
		ArrayList<Point> points = new ArrayList<Point>();
		
		for(int row = 0; row < radioButtonList.length; row++) {
			for(int col = 0; col < radioButtonList[row].length; col++) {
				if(radioButtonList[row][col].isSelected()) {
					points.add(new Point(row+1, col+1));
				}
			}
		}
		
		pointList = points;
		return points;
	}
	
	private void setupComponents() {
		verticiesT = new JTextField("5");
		verticiesF = new JLabel("Verticies:");
		enter = new JButton("Enter");
		randomize = new JButton("Randomize");
		
    	verticiesF.setBounds(25, 25, 75, 25);
    	verticiesT.setBounds(100, 25, 75, 25);
    	enter.setBounds(200, 25, 75, 25);
    	randomize.setBounds(300, 25, 100, 25);
    	
    	enter.addActionListener(new ButtonListener());
    	randomize.addActionListener(new ButtonListener());
    	
    	add(verticiesF);
    	add(verticiesT);
    	add(enter);
    	add(randomize);
    	
    	setupradioButtons();
	}
	
	private void setupradioButtons() {
		
		if(radioButtonList != null) {
			for(int row = 0; row < radioButtonList.length; row++) {
				for(int col = 0; col < radioButtonList[row].length; col++) {
					remove(radioButtonList[row][col]);
				}
			}
		}
		
		
		for(int scan = 0; scan < rowLabelList.size(); scan ++) {
			remove(rowLabelList.get(scan));
		}
		
		for(int scan = 0; scan < colLabelList.size(); scan ++) {
			remove(colLabelList.get(scan));
		}
		
		radioButtonList = new JRadioButton[verticies][verticies];
		rowLabelList = new ArrayList<JLabel>();
		colLabelList = new ArrayList<JLabel>();
		for(int row = 0; row < radioButtonList.length; row++) {
			JLabel rowLabel = new JLabel((row + 1) + "");
			rowLabel.setBounds(0, 75+row*25, 25, 25);
			add(rowLabel);
			rowLabelList.add(rowLabel);
			for(int col = 0; col < radioButtonList[row].length; col++) {
				JLabel colLabel = new JLabel((col+1) + "");
				colLabel.setBounds(30+col*75, 50, 25, 25);
				add(colLabel);
				colLabelList.add(colLabel);
				JRadioButton radio = new JRadioButton((col+1) + "," + (row+1));
				radio.setBounds(25+row*75, 75+col*25, 75, 25);
				if(random == true) {
					radio.setSelected(rand.nextBoolean());
				}
				add(radio);
				radioButtonList[row][col] = radio;
			}
		}
		
		setPreferredSize(new Dimension(100 + 75*verticies, 100 + 25*verticies));
		super.updateUI();
	}
	
	
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == enter) {
				verticies = Integer.parseInt(verticiesT.getText());
				random = false;
				setupradioButtons();
			}
			if(event.getSource() == randomize) {
				verticies = Integer.parseInt(verticiesT.getText());
				random = true;
				setupradioButtons();
			}
		}
	}
	
	
	
	
}

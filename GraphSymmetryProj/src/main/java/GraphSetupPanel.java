import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GraphSetupPanel extends JPanel{
	private JTextField verticies;
	
	public GraphSetupPanel() {
		setPreferredSize(new Dimension(1250, 900));
    	setLayout(null);
    	
    	verticies = new JTextField("5");
    	verticies.setBounds(25, 25, 75, 25);
    	
    	add(verticies);
    	this.setBackground(Color.yellow);
	}
	
	
	
	
}

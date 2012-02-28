package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	//not much that is too confusing going on in here hopefully - P
	DiagramPanel dPanel;
	ButtonPanel bPanel;
	MyMouseListener mL;
	Model m;
	
	MainFrame() {
		m = new Model();
		dPanel = new DiagramPanel();
		bPanel = new ButtonPanel(dPanel, m);
		this.setSize(400,400);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("The Worlds Greatest IDE");
		this.add(dPanel, BorderLayout.CENTER);
		this.add(bPanel, BorderLayout.WEST);
		
		mL= new MyMouseListener(dPanel, bPanel);
		dPanel.addMouseListener(mL);
		dPanel.addMouseMotionListener(mL);
	}

}

package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class MyMenuListener implements ActionListener{
	private JMenuBar jMB;
	private DiagramPanel dP;
	private Model m;
	
	public MyMenuListener(JMenuBar b, DiagramPanel dP, Model m){
		jMB = b;
		this.dP = dP;
		this.m = m;
		
	}
	
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();
		String fileName;
		JFileChooser chooser = new JFileChooser();
		
		
		if (action.equals("Save")) {
			fileName = JOptionPane.showInputDialog("Enter name to save file as:");
			
			if (fileName != null && !fileName.contains("/") && !fileName.isEmpty()) {
				try {
					m.save(fileName+ ".xml");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		
		else if(action.equals("Load")){
			fileName = JOptionPane.showInputDialog("Enter name of file to load from:");
			
			// Note this won't actually work properly because of the ArrayList<NJClass> and the VectorOfBoxes clusterfuck of code duplication
			// TODO Sort that shit out man
			
			//int returnVal = chooser.showOpenDialog();
		    //if(returnVal == JFileChooser.APPROVE_OPTION) {
		    //	loadFile = chooser.getSelectedFile().getName();
		    //}
			//if (loadFile != null)
			
			//TODO this file chooser will work eventually promise
			try {
				m.load(fileName);
				dP.repaint();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		else if(action.equals("Exit")) {
			System.exit(1); //is this right?
		}
		
		else if(action.equals("\"New Class\" Help")){
			JOptionPane.showMessageDialog(null, "Click the \"New Class\" button to create a new class. You will be able to enter a custom name for the class", 
					"Help", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(action.equals("\"Delete Selected\" Help")) {
			JOptionPane.showMessageDialog(null, "Click the \"Delete Selected\" button to delete the currently selected (orange outlined) class",
					"Help", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(action.equals("\"Delete All\" Help")) {
			JOptionPane.showMessageDialog(null,  "Click the \"Delete All\" button to clear all classes and connections from the screen",
					"Help", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}

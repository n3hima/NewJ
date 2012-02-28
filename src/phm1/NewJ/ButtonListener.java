package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener {
	private ButtonPanel bP;
	private DiagramPanel dP;
	private Model m;
	
	public ButtonListener(ButtonPanel b, DiagramPanel d, Model m) {
		this.m = m;
		bP=b;
		dP=d;
	}
	
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();
		
		if(action.equals("newClass")){ 
			//this is the shit that happens when you click the new class button - p
			String className;
			className = JOptionPane.showInputDialog("enter class name");
			//pops up a dialog box to get the name for the new class
						
				if (className != null && !className.equals("")) { 
				//if they cancel or don't enter anything then no new class is created
					NJClass c = new NJClass("Unnamed" + Integer.toString(m.getClassCount() + 1), new ArrayList<NJField>(), new ArrayList<NJMethod>());
					// what does this line of code do? ^^^^^ - p
					m.addClass(c);
					dP.addClass(100, 100, 100, 100, c);
				}
		
			//TODO put the box somewhere useful - maybe work out where is blank on the screen
			//TODO work out a sensible size for the box based on input text
			//TODO stop a class with no name being created
		}
		else if(action.equals("compile")){
			//this is the shit that happens when you click the compile button
			System.out.println("compile");
			//compile the code, duh
		}
		else if(action.equals("clear")){ //change to delete all
			dP.deleteAll();
			//TODO clear the screen of all classes - delete files as well? or separate delete button
		}
		else if(action.equals("Save")){
			// Need to pop up a filename dialog box here, for the moment we'll use newjtest.xml
			try {
				m.save("newjtest.xml");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("Load")){
			// Note this won't actually work properly because of the ArrayList<NJClass> and the VectorOfBoxes clusterfuck of code duplication
			// TODO Sort that shit out man
			// Again, need to pop up a filename dialog box here
			try {
				m.load("newjtest.xml");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

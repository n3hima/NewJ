package phm1.NewJ;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menus extends JMenuBar{

	//TODO HEY JOE WHAT OTHER BUTTONS DO YOU WANT IN THE MENU - p
	JMenu mainMenu, helpMenu;
	EditMenu editMenu;
	JMenuItem saveProject, loadProject, exitProgram;
	JMenuItem helpNew, helpDelete, helpDelAll;
	MyMenuListener mML;
	GUI gui;

	public JMenu getMainMenu() {
		return mainMenu;
	}

	public EditMenu getEditMenu() {
		return editMenu;
	}

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public JMenuItem getSaveProject() {
		return saveProject;
	}

	public JMenuItem getLoadProject() {
		return loadProject;
	}

	public JMenuItem getExitProgram() {
		return exitProgram;
	}

	public JMenuItem getHelpNew() {
		return helpNew;
	}

	public JMenuItem getHelpDelete() {
		return helpDelete;
	}

	public JMenuItem getHelpDelAll() {
		return helpDelAll;
	}

	public MyMenuListener getmML() {
		return mML;
	}

	public GUI getGui() {
		return gui;
	}

	public Menus(GUI g){
		this.gui = g;
		mML = new MyMenuListener(gui);

		mainMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		editMenu = new EditMenu(gui);

		saveProject = new JMenuItem("Save");
		loadProject = new JMenuItem("Load");
		exitProgram = new JMenuItem("Exit");

		helpNew = new JMenuItem("\"New Class\" Help");
		helpDelete = new JMenuItem("\"Delete Selected\" Help");
		helpDelAll = new JMenuItem("\"Delete All\" Help");

		this.add(mainMenu);
		this.add(editMenu);
		this.add(helpMenu);

		mainMenu.add(saveProject);
		mainMenu.add(loadProject);
		mainMenu.add(exitProgram);
		
		helpMenu.add(helpNew);
		helpMenu.add(helpDelete);
		helpMenu.add(helpDelAll);
		
		saveProject.addActionListener(mML);
		loadProject.addActionListener(mML);
		exitProgram.addActionListener(mML);

		helpNew.addActionListener(mML);
		helpDelete.addActionListener(mML);
		helpDelAll.addActionListener(mML);
	}
}

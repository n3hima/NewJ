package phm1.NewJ;

import java.awt.*;

import java.util.Vector;

public class VectorOfBoxes {
	//store name of class
	//more text - eg methods and attributes - don't worry about what is in the text box - can improve later if there is time
	private Vector<NJClass> boxes;
	
	VectorOfBoxes() {
		boxes = new Vector<NJClass>();
	}
	
	public void addBox(NJClass c) {
		boxes.add(c);
	}
	
	public int getNoBoxes() {
		return boxes.size();
	}
	
	public void drawAll(Graphics g) {
		for (NJClass c : boxes) {
			c.draw(g);
		}
	}
	
	public void deleteAll() {
		boxes.clear();
	}
	
	public void unselectAll() {
		for (NJClass c : boxes) {
			c.setSelected(false);
		}
	}
	
	public NJClass clickedInBox(int x, int y) {
		//finds the box that has been clicked on, if any - p
		int xPlusA;
		int yPlusB;
		for (NJClass c : boxes){ //loop through boxes - p

			xPlusA = c.getX()+c.getA();
			yPlusB = c.getY()+c.getB();
			
			if ((c.getX() < x) && (x < xPlusA) && (c.getY() < y) && (y < yPlusB)) {
				// We found it! Let's get outta here - J
				return c;
			}
		}
		// Just return null if we didn't return earlier - J
		return null;
	}
}

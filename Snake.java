/**
 * @(#)Snake.java
 *
 *
 * @author Terry
 * @version 1.00 2015/2/25
 */

import java.util.Vector;

public class Snake {
	
	Vector<Cell> Coords = new Vector<Cell>();
	public int currDir, lastDir, x, y; // 0 = left, 1 = right, 2 = up, 3 = down
	
    public Snake() {
    	Coords.addElement(new Cell(1, 1));
    	Coords.addElement(new Cell(2, 1));
    	x = 1;
    	y = 1;
    	currDir = 3;
    }
    
    public Vector<Cell> getCoords() {
    	return Coords;
    }
    
    public int getDir() {
    	return currDir;
    }
    
    public void updateCoords(Boolean eaten) {
    	Coords.add(0, new Cell(x, y));
    	if (!eaten) {
    		Coords.removeElementAt(Coords.size() - 1);
    	} else {
    		grow();
    	}
    }
    
    public void grow() {
    	Coords.addElement(new Cell(Coords.get(Coords.size() - 1).getX(), Coords.get(Coords.size() - 1).getY()));
    }

    public Cell getLoc() {
        return new Cell(Coords.get(0).getX(), Coords.get(0).getY());
    }
    
    public void printLoc(Boolean vector) {
    	if (vector) {
    		for (int i = 0; i < Coords.size(); i++) {
    			System.out.println("X: " + Coords.get(i).getX() + ", Y: " + Coords.get(i).getY());
    		}
    	} else {
    		System.out.println("X: " + Coords.get(0).getX() + ", Y: " + Coords.get(0).getY());
    	}
    }
    

    public void move() {
        switch (currDir) {
            case 0:
                x--;
                break;
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                y++;
                break;
            default:
                break;
        }
    }
    
    public void setDir(int input) {
	    if (input == 0) {
	    	switch (currDir) {
	    		case 2:
	    			currDir = 0;
	    			break;
	    		case 3:
	    			currDir = 0;
	    			break;
	    		default:
	    			break;
	    	}
	    } else if (input == 1) {
	    	switch (currDir) {
	    		case 2:
	    			currDir = 1;
	    			break;
	    		case 3:
	    			currDir = 1;
	    			break;
	    		default:
	    			break;
	    	}
	    } else if (input == 2) {
	    	switch (currDir) {
	    		case 0:
	    			currDir = 2;
	    			break;
	    		case 1:
	    			currDir = 2;
	    			break;
	    		default:
	    			break;
	    	}
	    } else if (input == 3) {
	    	switch (currDir) {
	    		case 0:
	    			currDir = 3;
	    			break;
	    		case 1:
	    			currDir = 3;
	    			break;
	    		default:
	    			break;
	    	}
	    }
    }
}
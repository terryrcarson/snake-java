/**
 * @(#)Cell.java
 *
 *
 * @author Terry
 * @version 1.00 2015/2/25
 */


public class Cell {
	
	//Types: 0 = Empty, 2 = Snake, 1 = Food
	private int x, y, type;
	
	public Cell() {}
	
    public Cell(int x, int y) { 
    	this.x = x;
    	this.y = y;
    }
    
    public void setType(int type) {
    	this.type = type;
    }
    
    public int getType(){
    	return type;
    }
    
    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }
    
    @Override
    public boolean equals(Object o) {
    	if (o instanceof Cell) {
    		Cell other = (Cell) o;
    		return (x == other.x && y == other.y);
    	}
    	return false;
    }
}
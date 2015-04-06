/**
 * @(#)Game.java
 *
 *
 * @author Terry
 * @version 1.00 2015/2/25
 */
import java.util.Vector;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;


public class Game {

	private final int xSize = 40, ySize = 40;
	Cell[][] board = new Cell[40][40];
	Cell food = new Cell();
	Snake snake = new Snake();

    public Game() {
    	for (int y = 0; y < ySize; y++) {
    		for (int x = 0; x < xSize; x++) {
    			board[x][y] = new Cell(x, y);
    			board[x][y].setType(0);
    		}
    	}
    	genFood();
    	try {
    	      File file = new File("yee.mp3");
    	      AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
    	      Clip clip = AudioSystem.getClip();
    	      clip.open(inputStream);
    	      clip.start(); 
    	    } catch (Exception e) {
    	      System.err.println(e.getMessage());
    	    }
    }

    public void setSnakeDir(int dir) {
    	snake.setDir(dir);
    }
    
    public void resetBoard() {
    	for (int y = 0; y < ySize; y++) {
    		for (int x = 0; x < xSize; x++) {
    			board[x][y].setType(0);
    		}
    	}
    	board[food.getX()][food.getY()].setType(2);
    }
    
    public void printCell(int x, int y) {
    	System.out.print(board[x][y].getType());
    }
    
    public void updateSnakeCoords() {
    	Vector<Cell> snakeCoords = snake.getCoords();
    	for (int i = 0; i < snakeCoords.size(); i++) {
    		board[snakeCoords.get(i).getX()][snakeCoords.get(i).getY()].setType(1);
    	}
    }
    
    public Cell[][] getBoard() {
    	return board;
    }
    
    public void genFood() {
    	int fx, fy;
    	food.setType(0);
    	do {
    		fx = (int)(Math.random() * 39);
    		fy = (int)(Math.random() * 39);
    	} while (snake.getCoords().contains(new Cell(fx, fy)));
    	food.setX(fx);
    	food.setY(fy);
    }
    
    public Boolean isCrashed() {
    	if (snake.getLoc().getX() < 0 || snake.getLoc().getX() > 39 || snake.getLoc().getY() < 0 || snake.getLoc().getY() > 39) {
    		return true;
    	}
    	if (snake.getCoords().contains(new Cell(snake.x, snake.y))) {
    		System.out.println("Snake hit itself");
    		return true;
    	}
    	return false;
    }
    
    public Boolean hasEaten() {
    	if(snake.getLoc().getX() == food.getX() && snake.getLoc().getY() == food.getY()) {
    		genFood();
    		return true;
    	}
    	return false;
    }
}
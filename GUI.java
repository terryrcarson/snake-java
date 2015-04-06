/**
 * @(#)GUI.java
 *
 *
 * @author Terry
 * @version 1.00 2015/3/3
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;


import javax.swing.*;

public class GUI implements KeyListener{

    JFrame frame = new JFrame();
    public SnakeDraw drawer;
    
    public GUI() {
    	frame.setTitle("Snake");
    	frame.setSize(400, 420);
    	frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	frame.add(drawer = new SnakeDraw());
    	frame.addKeyListener(this);
    }
    
    @Override
	public void keyPressed(KeyEvent e)
	{
		int i = e.getKeyCode();

		if ((i == KeyEvent.VK_LEFT) )
		{
			drawer.game.snake.setDir(0);
		}

		else if ((i == KeyEvent.VK_RIGHT) )
		{
			drawer.game.snake.setDir(1);
		}
		
		else if ((i == KeyEvent.VK_UP) )
		{
			drawer.game.snake.setDir(2);
		}

		else if ((i == KeyEvent.VK_DOWN) )
		{
			drawer.game.snake.setDir(3);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
    
    public static void main(String args[]) {
    	System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
    	GUI gui = new GUI();
    	gui.frame.setVisible(true);
    	while (true) {
    		gui.drawer.game.snake.move();
    		if (gui.drawer.game.isCrashed()) { break; }
    		gui.drawer.game.snake.updateCoords(gui.drawer.game.hasEaten());
    		try {
    			Thread.sleep(60);
    		} catch(InterruptedException ex) {
    		    Thread.currentThread().interrupt();
    		}
    		gui.frame.revalidate();
    		gui.frame.repaint();
    	}
    	System.out.println("Game over");
    }
    
}

class SnakeDraw extends JPanel {
	Game game = new Game();

	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 400, 400);
		//g.drawImage(bg, 0, 0, null);
		g.setColor(Color.GREEN);
		for (int i = 0; i < game.snake.getCoords().size(); i++) {
			g.fillRect(game.snake.getCoords().get(i).getX() * 10, game.snake.getCoords().get(i).getY() * 10, 10, 10);
		}
		g.setColor(Color.YELLOW);
		g.fillRect(game.food.getX() * 10, game.food.getY() * 10, 10, 10);
		g.drawString("Score: " + game.snake.getCoords().size() * 10, 5, 390);
	}
}
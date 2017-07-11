package controller;

import java.applet.Applet;

import java.awt.Color;

import java.awt.Event;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

public class GameLoop extends Applet implements Runnable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Updater engine = new Updater();


	public void start() {
	  new Thread(this).start();
	 }
	
	 
	
	 public void run() {
		setSize(600,400);
			  // Set up the graphics stuff, double-buffering.
	  BufferedImage screen = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);

	  Graphics g = screen.getGraphics();
	
	  Graphics appletGraphics = getGraphics();

	  long delta = 0l;

	  // Game loop.
	  while (true) {

	   long lastTime = System.nanoTime();
	   
	   // Update the state (convert to seconds)
	      engine.update((float)(delta / 1000000000.0));
	   // Render the world
	      engine.render(g);

	   // Draw the entire results on the screen.
	   appletGraphics.drawImage(screen, 0, 0, null);
	
	 

	   // Lock the frame rate
	   delta = System.nanoTime() - lastTime;

	   if (delta < 20000000L) {
	    try {
	     Thread.sleep((20000000L - delta) / 1000000L);
	    } catch (Exception e) {
	    
	    }
	
	   }
	   if (!isActive()) {
	    return;
	
	   }

	  }

	 }

	 

	 public boolean handleEvent(Event e) {
		 return engine.handleEvent(e);

	
	 }
	 
	}

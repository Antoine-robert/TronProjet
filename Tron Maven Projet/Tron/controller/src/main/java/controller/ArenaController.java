package controller;

import model.Arena;
import model.Lightcyles1;
import model.Lightcyles2;

public class ArenaController {
	 private static final int unit = 32;
	 private Arena arena;

	  /** the target cell **/
	  private float targetX1, targetY1;
	  private float targetX2, targetY2;

	  /** true if the Lightcycles moves **/
	  private boolean moving1 = false;
	  private boolean moving2 = false;

	  

	  public ArenaController(Arena arena) {
	   this.arena = arena;
	  }

	  public void update(float delta) {

		  Lightcyles1 lightcyles1 = arena.getMoto1();
		  Lightcyles2 lightcyles2 = arena.getMoto2();

	   if (moving1) {

	    // move on X
	    int bearing = 1;

	    if (lightcyles1.getX() > targetX1) {
	     bearing = -1;

	    }

	    if (lightcyles1.getX() != targetX1) {

	    	lightcyles1.setX(lightcyles1.getX() + bearing * lightcyles1.getSpeed() * delta);

	     if ((lightcyles1.getX() < targetX1 && bearing == -1)|| (lightcyles1.getX() > targetX1 && bearing == 1)) lightcyles1.setX(targetX1);

	    }
	    // move on Y
	    bearing = 1;

	    if (lightcyles1.getY() > targetY1) {

	     bearing = -1;
	    }
	 
	    if (lightcyles1.getY() != targetY1) {
	    	
	    	lightcyles1.setY(lightcyles1.getY() + bearing * lightcyles1.getSpeed() * delta);

	     // check if arrived
	     if ((lightcyles1.getY() < targetY1 && bearing == -1)|| (lightcyles1.getY() > targetY1 && bearing == 1)) lightcyles1.setY(targetY1);
	    }
	    // check if arrived
	    if (lightcyles1.getX() == targetX1 && lightcyles1.getY() == targetY1)
	     moving1 = false;

	   }
	   if (moving2) {

		    // move on X
		    int bearing = 1;

		    if (lightcyles2.getX() > targetX2) {
		     bearing = -1;

		    }

		    if (lightcyles2.getX() != targetX2) {

		    	lightcyles2.setX(lightcyles2.getX() + bearing * lightcyles2.getSpeed() * delta);

		     if ((lightcyles2.getX() < targetX2 && bearing == -1)|| (lightcyles2.getX() > targetX2 && bearing == 1)) lightcyles2.setX(targetX2);

		    }
		    // move on Y
		    bearing = 1;

		    if (lightcyles2.getY() > targetY2) {

		     bearing = -1;
		    }
		 
		    if (lightcyles2.getY() != targetY2) {
		    	
		    	lightcyles2.setY(lightcyles2.getY() + bearing * lightcyles2.getSpeed() * delta);

		     // check if arrived
		     if ((lightcyles2.getY() < targetY2 && bearing == -1)|| (lightcyles2.getY() > targetY2 && bearing == 1)) lightcyles2.setY(targetY2);
		    }
		    // check if arrived
		    if (lightcyles2.getX() == targetX2 && lightcyles2.getY() == targetY2)
		     moving2 = false;

		   }
	  }
	  
	  /** triggered with the coordinates every click **/
	  public boolean onClick1(int x, int y) {
		 
	   targetX1 = x / unit;
	   targetY1 = y / unit;
	 
	   if (arena.getGrid()[(int) targetY1][(int) targetX1] == null) {
	    // start moving the droid towards the target
	    moving1 = true;
	    return true;
	   }
	   return false;
	  }
	  public boolean onClick2(int x, int y) {
			 
		   targetX2 = x / unit;
		   targetY2 = y / unit;
		 
		   if (arena.getGrid()[(int) targetY2][(int) targetX2] == null) {
		    // start moving the droid towards the target
		    moving2 = true;
		    return true;
		   }
		   return false;
		  }
	}



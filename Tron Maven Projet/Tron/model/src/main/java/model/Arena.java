package model;

import java.util.ArrayList;


public class Arena {
	 public static final int WIDTH = 600/30;
	  public static final int HEIGHT = 400/30;


	  private Object[][] grid;

	  private ArrayList<LightWalls> obstacles = new ArrayList<LightWalls>();
	  //private ArrayList<Lightcyles> players = new ArrayList<Lightcyles>();
	  private Lightcyles1 lightcycles1;
	  private Lightcyles2 lightcycles2;

	  public Arena(Lightcyles1 lightcycles1,Lightcyles2 lightcycles2) {
		  
	   this.lightcycles1 = lightcycles1;
	   this.lightcycles2 = lightcycles2;
	   
	   grid = new Object[HEIGHT][WIDTH];
	   for (int i = 0; i < WIDTH; i++) {
	    for (int j = 0; j < HEIGHT; j++) {
	     grid[j][i] = null;
	    }
	   }
	   //add Lightcycles
	   grid[(int)lightcycles1.getY()][(int) lightcycles1.getX()] = lightcycles1;
	   grid[(int)lightcycles1.getY()][(int) lightcycles1.getX()] = lightcycles1;
	   
	   // tets d'affichage de Litghwall random
	   //for (int i = 0; i < 5 ; i++) {
	    //int x = random.nextInt(WIDTH);
	    //int y = random.nextInt(HEIGHT);
	    //while (grid[y][x] != null) {
	     //x = random.nextInt(WIDTH);
	     //y = random.nextInt(HEIGHT);
	    //}
	    //grid[y][x] = new LightWalls(x, y);
	    //obstacles.add((LightWalls) grid[y][x]);
	   }

	  //}

	  

	  public ArrayList<LightWalls> getObstacles() {

	   return obstacles;

	  }


	  public Lightcyles1 getMoto1() {
	   return lightcycles1;

	  }
	  public Lightcyles2 getMoto2() {
		   return lightcycles2;

		  }



	public Object[][] getGrid() {
		return grid;
	}
	 }

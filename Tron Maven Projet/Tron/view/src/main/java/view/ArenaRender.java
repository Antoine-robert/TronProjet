package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Arena;
import model.Lightcyles1;
import model.Lightcyles2;



public class ArenaRender implements Render {
	private Arena arena;
	ArrayList<Integer> pathx1 = new ArrayList<Integer>();
	ArrayList<Integer> pathy1 = new ArrayList<Integer>();
	ArrayList<Integer> pathx2 = new ArrayList<Integer>();
	ArrayList<Integer> pathy2 = new ArrayList<Integer>();
	 
	 public ArenaRender(Arena arena) {
		this.arena = arena;
	 }


	 public void render(Graphics g) throws InterruptedException {
		 
	  // render the grid
	  int cellSize = 32; // hard coded
	  //g.setColor(new Color(0, 0.5f, 0, 0.75f));
	  
	  //for (int i = 0; i <= Arena.WIDTH; i++) {

	   //g.drawLine(i * cellSize, 0, i * cellSize, Arena.HEIGHT * cellSize);
	   //if (i <= Arena.WIDTH)
	    //g.drawLine(0, i * cellSize, Arena.WIDTH * cellSize, i * cellSize);
	  
	  // render the obstacles
	  //g.setColor(new Color(0, 0, 1f));

	  //for (LightWalls obs : arena.getObstacles()) {

	  // int x = (int) (obs.getX() * cellSize) + 2;
	   //int y = (int) (obs.getY() * cellSize) + 2;
	
	   //g.fillRect(x, y, cellSize - 4, cellSize - 4);
	  


	 

	  // render players
	 g.setColor(new Color(0, 1f, 0));
	
	  Lightcyles1 lightcyles1 = arena.getMoto1();
	  Lightcyles2 lightcyles2 = arena.getMoto2();
	  

	  int x1 = (int) (lightcyles1.getX() * cellSize);
	  int y1 = (int) (lightcyles1.getY() * cellSize);
	  pathx1.add(x1);
	  pathy1.add(y1);
	  
	  checkCollision1(pathx2,pathy2,x1,y1);
	  
	  g.fillRect(x1 + 2, y1 + 2, cellSize , cellSize );
	  for (int j=0; j<pathx1.size();j++)
      {
		 g.fillRect(x1 + 2, y1 + 2, cellSize , cellSize );  
      }
	  for (int j=0; j<pathy1.size();j++)
      {
		 g.fillRect(x1 + 2, y1 + 2, cellSize , cellSize );  
      }
	  
	  g.setColor(new Color(0, 0, 1f));
	  int x2 = (int) (lightcyles2.getX() * cellSize);
	  int y2 = (int) (lightcyles2.getY() * cellSize);
	  pathy2.add(y2);
	  pathx2.add(x2);
	  checkCollision1(pathx1,pathy1,x2,y2);
	  
	  g.fillRect(x2 + 2, y2 + 2, cellSize , cellSize );
	  
	  for (int j=0; j<pathx2.size();j++)
      {
		 g.fillRect(x2 + 2, y2 + 2, cellSize , cellSize );  
      }
	  for (int j=0; j<pathy2.size();j++)
      {
		 g.fillRect(x2 + 2, y2 + 2, cellSize , cellSize );  
      }
	  
	  // render square 
	  g.setColor(new Color(0.7f, 0.5f, 0f));
	  g.fillRect(x1 + 10, y1 + 10, cellSize - 20, cellSize - 20);
	  g.fillRect(x2 + 10, y2+ 10, cellSize - 20, cellSize - 20);
	 
	}

 public void checkCollision2(ArrayList<Integer> pathx1,ArrayList<Integer> pathy1, int x2, int y2 ) throws InterruptedException{
	     for(int i=0;i<pathx1.size();i++)
	     {
	     if(pathx1.get(i) == x2 && pathy1.get(i) == y2)
	     {
	    	 
	    	 JOptionPane.showMessageDialog(null, "le Joueur Bleu gagne");
	    	 Thread.sleep(200);
	    	 System.exit(0);
	     }
	     }
	     return;
	 } 
 public void checkCollision1(ArrayList<Integer> pathx2,ArrayList<Integer> pathy2, int x1, int y1) throws InterruptedException{
	 for(int i=0;i<pathx2.size();i++)
     {
     if(pathx2.get(i) == x1 && pathy2.get(i) == y1)
     {
    	 JOptionPane.showMessageDialog(null, "le Joueur Vert gagne");
    	 Thread.sleep(200);
    	 System.exit(0);
     }
     }
     return;
 }
	
 }

package controller;

import java.awt.Event;
import java.awt.Graphics;

import model.Arena;
import model.Lightcyles1;
import model.Lightcyles2;
import view.ArenaRender;

public class Updater {
	private Arena arena;
	private Lightcyles1 lightcycles1;
	private Lightcyles2 lightcycles2;
	
	private ArenaRender renderer;
	private ArenaController controller;


	
	public Updater() {
		lightcycles1 = new Lightcyles1();
		 // position player1 
		lightcycles1.setX(Arena.WIDTH / 2);
		lightcycles1.setY(Arena.HEIGHT / 8);
		
		lightcycles2 = new Lightcyles2();
		// position player 
		lightcycles2.setX(Arena.WIDTH /2);
		lightcycles2.setY(Arena.HEIGHT/2);
		
		 arena = new Arena(lightcycles1,lightcycles2);
		 //setup Arena controller (controler)
		 controller = new ArenaController(arena);

		// setup renderer (view)
		   renderer = new ArenaRender(arena);

		}

	/** handle the Event passed from the main applet **/
	 public boolean handleEvent(Event e) {
	  switch (e.id) {
	  case Event.MOUSE_UP:
		  controller.onClick1(e.x, e.y);
	   break;
	  case Event.MOUSE_MOVE:
		  controller.onClick2(e.x, e.y);
	   break;
	  }
	  return false;
	 }
	 /** the update method with the deltaTime in seconds **/
	 public void update(float deltaTime) {
		 controller.update(deltaTime);
	 }
	/** this will render the whole world **/
	 public void render(Graphics g) {
		 renderer.render(g);
	 }
	}

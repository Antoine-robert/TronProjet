package model;

public class LightWalls {
	private float x;
	private float y;
	private float damage = 2f;

	 

	 public LightWalls(float x, float y) {
	  this.x = x;
	  this.y = y;
	 }
	 public float getX() {
	  return x;
	 }
	 public float getY() {
	  return y;
	 }
	 
	 public float getDamage() {
		   return damage ;

		  }

		  public void setDamage(float damage) {
		   this.damage = damage;
		  }

}

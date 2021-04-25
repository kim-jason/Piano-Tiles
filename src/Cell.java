
import info.gridworld.grid.Location;
import java.awt.Color;

public class Cell {
	public Color myColor;
	public Location myLocation;
	
	public Cell() {
		myColor = Color.WHITE;
	}
	public String toString(){
		return "";
	}
	public void setColor(Color c) {
		myColor = c;
	}
	public Color getColor(){
		return myColor;
	}
	public Location getLoc() {
		return myLocation;
	}
	
	public void setLoc(Location loc) {
		myLocation = loc;
	}
	
}
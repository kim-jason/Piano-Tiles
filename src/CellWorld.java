import java.awt.Color;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;


public class CellWorld extends World<Cell> {
	public int counter = 0;
	public int[][] loc = new int[4][4];
	public final int BLACK = 1;
	public final int WHITE = 0;
	public boolean alreadyFinished;
	public boolean gameStarted;
	public long time1;

	public CellWorld(BoundedGrid<Cell> grid) {
		this.setGrid(grid);
		placeBlack(0,0);
		placeBlack(1,2);
		placeBlack(2,0);
		placeBlack(3,0);
	}

	public void placeBlack(int a, int b) {
		Cell t = new Cell();
		t.setColor(Color.BLACK);
		loc[a][b] = BLACK;
		this.getGrid().put(new Location(a,b), t);
	}

	public void refresh() {
		for (int a = 0; a < loc.length; a++) {
			for (int b = 0; b < loc[a].length; b++) {
				if (loc[a][b] == BLACK) {
					placeBlack(a,b);
				}
				if (loc[a][b] == WHITE) {
					remove(new Location(a,b));
				}
			}
		}
		Random random = new Random();
		int a = random.nextInt(4);
		loc[0][a] = BLACK;
		placeBlack(0,a);
	}
	
	public boolean keyPressed(String description, Location loc) {
		if (description.equals("1")) {
			onePressed();
			return true;
		}
		if (description.equals("2")) {
			twoPressed();
			return true;
		}
		if (description.equals("3")) {
			threePressed();
			return true;
		}
		if (description.equals("4")) {
			fourPressed();
			return true;
		}
		return false;
	}

	private void shiftDown() {
		int[][] newLoc = new int[4][4];
		for (int a = 1; a < loc.length; a++) {
			for (int b = 0; b < loc[a].length; b++) {
				newLoc[a][b] = loc[a-1][b];
			}
		}
		loc = newLoc;
		refresh();
	}

	public void gameOver() {
		alreadyFinished = true;
		for (int a = 0; a < loc.length; a++) {
			for (int b = 0; b < loc[a].length; b++) {
				Cell x = new Cell();
				x.setColor(Color.RED);
				this.getGrid().put(new Location(a,b), x);
				loc[a][b] = WHITE;
			}
		}
	}

	public void gameIsFinished () {
		alreadyFinished = true;
		for (int a = 0; a < loc.length; a++) {
			for (int b = 0; b < loc[a].length; b++) {
				Cell x = new Cell();
				x.setColor(Color.GREEN);
				this.getGrid().put(new Location(a,b), x);
				loc[a][b] = WHITE;
			}
		}
		System.out.println("Congratulations, you won!");
		System.out.println("Time: " + returnTime() + " seconds");
	}

	public boolean gameFinished() {
		if (counter == 19) {

			return true;
		}
		else {
			return false;
		}
	}

	public void setTime() {
		if (counter == 1) {
			time1 = System.currentTimeMillis();
		}
	}
	
	public double returnTime() {
		long time2 = System.currentTimeMillis();
		long durationTime = time2 - time1;
		double seconds = durationTime / 1000.0;
		return seconds;
	}

	public void onePressed() {
		if (gameFinished()) {
			if (!alreadyFinished) {
				gameIsFinished();
			}

		}
		else {
			if (loc[3][0] == 0) {
				if (!alreadyFinished) {
					System.out.println("GAME OVER");
					System.out.println("SCORE: " + counter);
					gameOver();
				}
			}


			else {
				setTime();
				counter++;
				shiftDown();
			}
		}
	}

	public void twoPressed() {
		if (gameFinished()) {
			if (!alreadyFinished) {
				gameIsFinished();
			}

		}
		else {
			if (loc[3][1] == 0) {
				if (!alreadyFinished) {
					System.out.println("GAME OVER");
					System.out.println("SCORE: " + counter);
					gameOver();
				}
			}
			else {

				setTime();
				counter++;
				shiftDown();
			}


		}
	}

	public void threePressed() {
		if (gameFinished()) {
			if (!alreadyFinished) {
				gameIsFinished();
			}

		}
		else {
			if (loc[3][2] == 0) {
				if (!alreadyFinished) {
					System.out.println("GAME OVER");
					System.out.println("SCORE: " + counter);
					gameOver();
				}
			}
			else {
				setTime();

				counter++;
				shiftDown();
			}
		}
	}

	public void fourPressed() {
		if (gameFinished()) {
			if (!alreadyFinished) {
				gameIsFinished();
			}

		}
		else{
			if (loc[3][3] == 0) {
				if (!alreadyFinished) {
					System.out.println("GAME OVER");
					System.out.println("SCORE: " + counter);
					gameOver();
				}
			}
			else {
				setTime();
				counter++;
				shiftDown();
			}
		}
	}
	
	public void step(){
		for (int a = 0; a < loc.length; a++) {
			for (int b = 0; b < loc[a].length; b++) {
				loc[a][b] = WHITE;
			}
		}
		refresh();
		
		placeBlack(0,0);
		placeBlack(1,2);
		placeBlack(2,0);
		placeBlack(3,0);
	}
}

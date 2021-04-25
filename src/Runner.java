import info.gridworld.grid.BoundedGrid;

public class Runner {
	public static void main(String[] args) {
		CellWorld world = new CellWorld(new BoundedGrid<Cell>(4,4));
		world.show();
	}
}

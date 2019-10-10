
/**
 * A 2D grid implemented as an array.
 * Each (x,y) coordinate can hold a single item of type <T>.
 *
 * @param <T> The type of element held in the data structure
 */
public class ArrayGrid<T> implements Grid<T> {
	private Object[][] grid;
	/**
	 * Constructs a new ArrayGrid object with a given width and height.
	 *
	 * @param width The width of the grid
	 * @param height The height of the grid
     * @throws IllegalArgumentException If the width or height is less than or equal to zero
	 */
	public ArrayGrid(int width, int height) throws IllegalArgumentException {
	    // TODO: implement the constructor
		this.grid = new Object[width][height];
	}

	@Override
	public void add(int x, int y, T element) throws IllegalArgumentException {
		this.grid[x][y] = element;
	}

	@Override
	public T get(int x, int y) throws IndexOutOfBoundsException {
		return (T)this.grid[x][y];
	}

	@Override
	public boolean remove(int x, int y) throws IndexOutOfBoundsException {
		if (this.grid[x][y] == null) {
			return false;
		}else {
			this.grid[x][y] = null;
			return true;
		}
	}

	@Override
	public void clear() {
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length; j++){
				grid[i][j] = null;
			}
		}
	}

	@Override
	public void resize(int newWidth, int newHeight) throws IllegalArgumentException {
		Object[][] temp = new Object[newWidth][newHeight];
		int rowMaxIndex = 0;
		int columnMaxIndex = 0;
		/* Find the max index of not null value */
		for (int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if (grid[i][j] != null && i > rowMaxIndex){
					rowMaxIndex = i;
				}
				if (grid[i][j] != null && j > columnMaxIndex){
					columnMaxIndex = j;
				}
			}
		}

		if (newWidth < rowMaxIndex || newHeight < columnMaxIndex){
			ArrayIndexOutOfBoundsException exception = new ArrayIndexOutOfBoundsException("This operation may cause elements lost");
			throw exception;
		}

		for (int i = 0; i <= rowMaxIndex; i++){
			for (int j = 0; j <= columnMaxIndex; j++){
				temp[i][j] = grid[i][j];
			}
		}

		grid = temp;

	}

}
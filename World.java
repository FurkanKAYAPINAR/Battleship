
import java.util.Arrays;

public class World {

    private int[][] world;

    public int[][] getWorld() {
        return world;
    }

    public void setWorld(int[][] world) {
        this.world = world;

        for (int[] row : this.world) {
            Arrays.fill(row, 0);
        }
    }

    public void setPointWorld(int x, int y, int value) {
        this.world[x][y] = value;
    }

    public int getPointWorld(int x, int y) {
        return this.world[x][y];
    }

    public void GridPrint() {
        System.out.print("  ");
        for (int i = 0; i < getWorld().length; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < getWorld().length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < getWorld()[0].length; j++) {
                if (this.world[i][j] >= 2) // ships
                {
                    System.out.print("S ");
                } else if (this.world[i][j] == 1) // shot
                {
                    System.out.print("x ");
                } else if (this.world[i][j] == 0) // free
                {
                    System.out.print(". ");
                } else // missed shot
                {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

package Java102.ClassTesting;

import Java102.Classes.Grid;

public class GridClassTest {
    public static void main(String[] args) {
        Grid<Integer> grid = new Grid<>(5, 0);
        grid.set(2, 2, 4);
        System.out.println(grid);
        System.out.println(grid.diagonal());
        System.out.println(Grid.maxSideLength());
    }
}

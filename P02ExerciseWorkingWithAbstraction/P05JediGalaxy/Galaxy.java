package P02ExerciseWorkingWithAbstraction.P05JediGalaxy;

public class Galaxy {
    int[][] galaxyMatrix;
    public final int numRows;
    public final int numCols;

    public Galaxy(int[][] galaxyMatrix) {
        this.galaxyMatrix = galaxyMatrix;
        this.numRows = galaxyMatrix.length;
        this.numCols = galaxyMatrix[1].length;
    }

    public boolean isInside(Coords coords) {
        return coords.row >= 0 && coords.row < this.numRows && coords.col >= 0 && coords.col < this.numCols;
    }

    public void setValueAt(Coords coords, int value) {
        galaxyMatrix[coords.row][coords.col] = value;
    }

    public long getValueAt(Coords coords) {
        return galaxyMatrix[coords.row][coords.col];
    }
}

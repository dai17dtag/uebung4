package main;

import matrix.MatrixDimension;
import matrix.MatrixTools;

public class Main
{
    public static void main (String[] args) throws Exception
    {
        int[][] matrix = MatrixTools.getMatrixFromFile("test.txt");
        MatrixTools.printMatrix(matrix);
    }
}

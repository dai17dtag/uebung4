package matrix;

import exception.InvalidMatrixException;
import exception.MatrixNotInitializedException;


public class MatrixDimension
{
    private int width, height;

    public MatrixDimension(int[][] matrix) throws MatrixNotInitializedException, InvalidMatrixException
    {
        nullCheck(matrix);

        validationCheck(matrix);

        height = matrix.length;
        width = matrix[0].length;

    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    private void nullCheck(int[][] matrix) throws MatrixNotInitializedException
    {
        if (matrix == null)
        {
            throw new MatrixNotInitializedException("Matrix is null");
        }

        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i] == null)
            {
                throw new MatrixNotInitializedException("Line " + i + " is null");
            }
        }
    }

    private void validationCheck(int[][] matrix) throws InvalidMatrixException
    {
        if(!(matrix.length > 0))
        {
            throw new InvalidMatrixException("Matrix has no lines");
        }

        int length = matrix[0].length;

        for (int i = 0; i < matrix.length - 1; i++)
        {
            if (matrix[i].length != matrix[i+1].length || matrix[i].length == 0)
            {
                throw new InvalidMatrixException("Error: Line " + i + " not identical in length");
            }
        }
    }
}

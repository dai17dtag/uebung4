package matrix;

import exception.InvalidMatrixException;
import exception.MatricesNotMultipliableException;
import exception.MatrixNotInitializedException;
import exception.MatrixSpurNotAvailableException;

public class MatrixTools
{
    public static int[][] createMatrix(int m, int n)
    {
        boolean correctValues = true;
        int[][] matrix;

        if (m <= 0 || n <= 0)
        {
            correctValues = false;
        }

        if (correctValues)
        {
            matrix = new int[m][n];
            for (int mCounter = 0; mCounter < m; mCounter++)
            {
                for (int nCounter = 0; nCounter < n; nCounter++)
                {
                    matrix[mCounter][nCounter] = (int) (Math.random() * 10) + 1;
                }
            }
        } else
        {
            matrix = null;
        }

        return matrix;
    }

    public static void printMatrix(int[][] m)
    {
        boolean isNull = matrixIsNull(m);

        if (!isNull)
        {
            for (int[] line : m)
            {
                StringBuilder lineStringBuilder = new StringBuilder();

                for (int value : line)
                {
                    lineStringBuilder.append(value);
                }
                System.out.println(lineStringBuilder.toString());
            }
        } else
        {
            System.out.println("");
        }
    }

    public static int[][] getTransposedMatrix(int[][] m)
    {
        if (matrixIsNull(m))
        {
            return null;
        }

        int[][] transposedMatrix;
        boolean isRectangle = true;

        int lineCount = m.length;
        int columnCount = m[0].length;

        for (int lineCounter = 0; lineCounter < lineCount; lineCounter++)
        {
            if (m[lineCounter].length != m[0].length)
            {
                isRectangle = false;
            }
        }

        if (isRectangle)
        {
            transposedMatrix = new int[columnCount][lineCount]; //reversed line and column count

            for (int lineCounter = 0; lineCounter < lineCount; lineCounter++)
            {
                for (int columnCounter = 0; columnCounter < columnCount; columnCounter++)
                {
                    transposedMatrix[columnCounter][lineCounter] = m[lineCounter][columnCounter];
                }
            }
        } else
        {
            return null;
        }

        return transposedMatrix;
    }

    public static int matrixSpur(int[][] matrix) throws MatrixNotInitializedException, InvalidMatrixException, MatrixSpurNotAvailableException
    {
        MatrixDimension matrixDimension = new MatrixDimension(matrix);

        int spur = 0;

        if (matrix.length != matrix[0].length)
        {
            throw new MatrixSpurNotAvailableException("Height is " + matrixDimension.getHeight() + ", width is " + matrixDimension.getWidth());
        }

        for (int i = 0; i < matrix.length; i++)
        {
            spur += matrix[i][i];
        }

        return spur;
    }

    public static int[][] matrixMul(int[][] a, int[][] b) throws MatrixNotInitializedException, InvalidMatrixException, MatricesNotMultipliableException
    {
        MatrixDimension matrixDimensionA = new MatrixDimension(a);
        MatrixDimension matrixDimensionB = new MatrixDimension(b);

        if (matrixIsNull(a) || matrixIsNull(b))
        {
            return null;
        }

        boolean isMultiplicable = false;
        int linesA = matrixDimensionA.getHeight();
        int linesB = matrixDimensionB.getHeight();
        int columnsA = matrixDimensionA.getWidth();
        int columnsB = matrixDimensionB.getWidth();

        int[][] sum;

        if (!(columnsA == linesB))
        {
            throw new MatricesNotMultipliableException("Coulumns A: " + columnsA + " , lines B: " + linesB + ", not compatible!");
        }

        if (isMultiplicable)
        {
            sum = new int[linesA][columnsB];

            for (int resultLinesCounter = 0; resultLinesCounter < linesA; resultLinesCounter++)
            {
                for (int resultColumnsCounter = 0; resultColumnsCounter < columnsB; resultColumnsCounter++)
                {
                    int buffer = 0;

                    for (int multiplyCounter = 0; multiplyCounter < linesB; multiplyCounter++)
                    {
                        buffer += a[resultLinesCounter][multiplyCounter] * b[multiplyCounter][resultColumnsCounter];
                    }
                    sum[resultLinesCounter][resultColumnsCounter] = buffer;
                }
            }
        } else
        {
            sum = null;
        }

        return sum;
    }

    private static boolean matrixIsNull(int[][] matrix)
    {
        boolean isNull = false;

        if (matrix == null)
        {
            isNull = true;
        }

        if (!isNull)
        {
            for (int counter = 0; counter < matrix.length; counter++)
            {
                if (matrix[counter] == null)
                {
                    isNull = true;
                    break;
                }
            }
        }
        return isNull;
    }
}

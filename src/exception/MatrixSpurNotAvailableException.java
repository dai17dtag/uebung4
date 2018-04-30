package exception;

public class MatrixSpurNotAvailableException extends Exception
{
    private static final String stdErrMsg = "Matrix Spur not available";

    public MatrixSpurNotAvailableException ()
    {
        super(stdErrMsg);
    }

    public MatrixSpurNotAvailableException (String errorMessage)
    {
        super(stdErrMsg + ", Cause: " + errorMessage);
    }
}

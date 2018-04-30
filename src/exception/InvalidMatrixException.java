package exception;

public class InvalidMatrixException extends Exception
{
    private static final String stdErrMsg = "Matrix is invalid";

    public InvalidMatrixException ()
    {
        super(stdErrMsg);
    }

    public InvalidMatrixException (String errorMessage)
    {
        super(stdErrMsg + ", Cause: " + errorMessage);
    }
}

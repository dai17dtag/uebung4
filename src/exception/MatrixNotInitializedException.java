package exception;

public class MatrixNotInitializedException extends Exception
{
    private static final String stdErrMsg = "Matrix not initialized";

    public MatrixNotInitializedException ()
    {
        super(stdErrMsg);
    }

    public MatrixNotInitializedException (String errorMessage)
    {
        super(stdErrMsg + ", Cause: " + errorMessage);
    }
}

package exception;

public class MatricesNotMultipliableException extends Exception
{
    private static final String stdErrMsg = "Matrix not multipliable";

    public MatricesNotMultipliableException ()
    {
        super(stdErrMsg);
    }

    public MatricesNotMultipliableException (String errorMessage)
    {
        super(stdErrMsg + ", Cause: " + errorMessage);
    }
}

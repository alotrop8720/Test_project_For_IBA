package by.IBA.task.exceptions;


/**
 * Class for writing exceptions with key -rk.
 */
public class RKKeyExceptionWriter extends ExceptionWriter
        implements WriterExceptionFactory{
    @Override
    public ExceptionWriter getWriter() {
        return new RKKeyExceptionWriter("rk_err.txt");
    }

    public RKKeyExceptionWriter(String fileName) {
        super(fileName);
    }
}

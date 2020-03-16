package by.IBA.task.exceptions;
/**
 * Class for writing exceptions with key -f.
 */
public class FKeyExceptionWriter extends ExceptionWriter
    implements WriterExceptionFactory{
    @Override
    public ExceptionWriter getWriter() {
        return new FKeyExceptionWriter("file_err.txt");
    }

    public FKeyExceptionWriter(String fileName) {
        super(fileName);
    }
}

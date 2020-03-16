package by.IBA.task.exceptions;

/**
 * Class for writing exceptions with key -cmd.
 */
public class CMDKeyExceptionWriter extends ExceptionWriter
    implements WriterExceptionFactory{
    @Override
    public ExceptionWriter getWriter() {
        return new CMDKeyExceptionWriter("cmd_err.txt");
    }

    public CMDKeyExceptionWriter(String fileName) {
        super(fileName);
    }
}

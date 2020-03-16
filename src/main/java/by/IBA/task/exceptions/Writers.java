package by.IBA.task.exceptions;

public class Writers {
    /**
     * Write exception to file.
     * @param exceptionFactory class include interface WriterExceptionFactory
     * @param ex exception which need to write
     */
    public static void writeError(WriterExceptionFactory exceptionFactory, Exception ex){
        exceptionFactory.getWriter().writeError(ex);
    }
}

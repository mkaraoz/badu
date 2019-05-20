
package tt.badu.base;

/**
 *
 * @author mk
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    private final ExceptionCallback callback;
    
    private ExceptionHandler(ExceptionCallback ec) {
        callback = ec;
    }
    
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        handle(e);
    }

    public void handle(Throwable throwable) {
        try {
            callback.call(throwable);
        } catch (Throwable t) {
            // don't let the exception get thrown out, will cause infinite looping!
        }
    }

    public static void registerExceptionHandler(ExceptionCallback ec) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(ec));
        System.setProperty("sun.awt.exception.handler", ExceptionHandler.class.getName());
    }
    
    public interface ExceptionCallback
    {
        void call(Throwable t);
    }
}

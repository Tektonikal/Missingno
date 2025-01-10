package tektonikal.missingno.enterprise.pub;

public interface ConditionalRunnable {
    Runnable emptyRunnable = () -> {};

    static void check(boolean conditional, Runnable toRun) {
       (conditional ? toRun : emptyRunnable).run();
    }

}

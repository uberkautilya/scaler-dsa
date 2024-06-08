package references.streams_exception_handling.ai_dealing_with_it;

public final class Failure<T> implements Outcome<T> {
    private final Throwable throwable;

    Failure(Throwable throwable) {
        this.throwable = throwable;
    }

    public Throwable getError() {
        return throwable;
    }
}

package references.streams_exception_handling.ai_dealing_with_it;

public final class Success<T> implements Outcome<T> {
    private final T result;

    Success(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}

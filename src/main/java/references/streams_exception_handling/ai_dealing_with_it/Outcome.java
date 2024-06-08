package references.streams_exception_handling.ai_dealing_with_it;

import java.util.concurrent.Callable;
import java.util.function.Function;

public sealed interface Outcome<T> permits Failure, Success {

    static <T> Outcome<T> of(Callable<T> callable) {
        try {
            return new Success<T>(callable.call());
        } catch (Throwable throwable) {
            return new Failure<T>(throwable);
        }
    }

    default <R> Outcome<R> map(Function<T, R> mapper) {
        if (this instanceof Success<T>) {
            return of(() -> mapper.apply(((Success<T>) this).getResult()));
        } else {
            return new Failure<R>(((Failure<T>) this).getError());
        }
    }
}

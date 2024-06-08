package references.streams_exception_handling.ai_dealing_with_it;

public final class Failure<T> implements Try<T> {
  private final Throwable throwable;
  
  Failure(Throwable throwable) { this.throwable = throwable; }
  
  @Override
  public T getResult() { throw new RuntimeException("Invalid invocation"); }

  @Override
  public Throwable getError() { return throwable; }    
}

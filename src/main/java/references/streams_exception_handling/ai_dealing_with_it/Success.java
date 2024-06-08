package references.streams_exception_handling.ai_dealing_with_it;

public final class Success<T> implements Try<T> {
  private final T result;
  
  Success(T result) { this.result = result; }
  
  @Override
  public T getResult() { return result; }

  @Override
  public Throwable getError() { 
    throw new RuntimeException("Invalid invocation"); 
  }
}

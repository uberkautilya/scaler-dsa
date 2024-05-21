* Overhead in creating threads is minimized with a fixed thread pool, using an executor service
* In the example in the package, thread pool approach is actually quicker
* Typically, the thread count is equal to 2 x Cores

* If you want the task to return a value, use Callable
* The Runnable does not allow returning any data
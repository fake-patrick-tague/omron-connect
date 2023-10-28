package androidx.work.impl.utils.futures;

final class AsyncHttpClient
{
  static final AsyncHttpClient log = new AsyncHttpClient(new a.d.a("Failure occurred while trying to finish a future."));
  final Throwable cause;
  
  AsyncHttpClient(Throwable paramThrowable)
  {
    cause = ((Throwable)AbstractFuture.create(paramThrowable));
  }
}

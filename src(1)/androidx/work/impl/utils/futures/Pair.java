package androidx.work.impl.utils.futures;

final class Pair
{
  static final Pair a = new Pair(true, null);
  static final Pair c;
  final Throwable exception;
  final boolean value;
  
  static
  {
    if (AbstractFuture.id)
    {
      c = null;
      a = null;
      return;
    }
    c = new Pair(false, null);
  }
  
  Pair(boolean paramBoolean, Throwable paramThrowable)
  {
    value = paramBoolean;
    exception = paramThrowable;
  }
}

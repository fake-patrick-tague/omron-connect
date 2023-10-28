package androidx.concurrent.futures;

final class Type
{
  static final Type type = new Type(true, null);
  static final Type value;
  final Throwable exception;
  final boolean this$0;
  
  static
  {
    if (AbstractFuture.id)
    {
      value = null;
      type = null;
      return;
    }
    value = new Type(false, null);
  }
  
  Type(boolean paramBoolean, Throwable paramThrowable)
  {
    this$0 = paramBoolean;
    exception = paramThrowable;
  }
}

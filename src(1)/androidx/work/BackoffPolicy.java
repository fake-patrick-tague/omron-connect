package androidx.work;

public enum BackoffPolicy
{
  static
  {
    BackoffPolicy localBackoffPolicy1 = new BackoffPolicy("EXPONENTIAL", 0);
    c = localBackoffPolicy1;
    BackoffPolicy localBackoffPolicy2 = new BackoffPolicy("LINEAR", 1);
    b = localBackoffPolicy2;
    d = new BackoffPolicy[] { localBackoffPolicy1, localBackoffPolicy2 };
  }
}

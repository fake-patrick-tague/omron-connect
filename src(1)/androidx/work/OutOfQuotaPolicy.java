package androidx.work;

public enum OutOfQuotaPolicy
{
  static
  {
    OutOfQuotaPolicy localOutOfQuotaPolicy1 = new OutOfQuotaPolicy("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
    a = localOutOfQuotaPolicy1;
    OutOfQuotaPolicy localOutOfQuotaPolicy2 = new OutOfQuotaPolicy("DROP_WORK_REQUEST", 1);
    b = localOutOfQuotaPolicy2;
    d = new OutOfQuotaPolicy[] { localOutOfQuotaPolicy1, localOutOfQuotaPolicy2 };
  }
}

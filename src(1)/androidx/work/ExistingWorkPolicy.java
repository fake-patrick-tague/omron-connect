package androidx.work;

public enum ExistingWorkPolicy
{
  static
  {
    ExistingWorkPolicy localExistingWorkPolicy1 = new ExistingWorkPolicy("REPLACE", 0);
    vcard = localExistingWorkPolicy1;
    ExistingWorkPolicy localExistingWorkPolicy2 = new ExistingWorkPolicy("KEEP", 1);
    c = localExistingWorkPolicy2;
    ExistingWorkPolicy localExistingWorkPolicy3 = new ExistingWorkPolicy("APPEND", 2);
    o = localExistingWorkPolicy3;
    ExistingWorkPolicy localExistingWorkPolicy4 = new ExistingWorkPolicy("APPEND_OR_REPLACE", 3);
    d = localExistingWorkPolicy4;
    a = new ExistingWorkPolicy[] { localExistingWorkPolicy1, localExistingWorkPolicy2, localExistingWorkPolicy3, localExistingWorkPolicy4 };
  }
}

package androidx.work;

public enum ExistingPeriodicWorkPolicy
{
  static
  {
    ExistingPeriodicWorkPolicy localExistingPeriodicWorkPolicy1 = new ExistingPeriodicWorkPolicy("REPLACE", 0);
    vcard = localExistingPeriodicWorkPolicy1;
    ExistingPeriodicWorkPolicy localExistingPeriodicWorkPolicy2 = new ExistingPeriodicWorkPolicy("KEEP", 1);
    c = localExistingPeriodicWorkPolicy2;
    d = new ExistingPeriodicWorkPolicy[] { localExistingPeriodicWorkPolicy1, localExistingPeriodicWorkPolicy2 };
  }
}

package com.google.android.datatransport;

public enum Priority
{
  static
  {
    Priority localPriority1 = new Priority("DEFAULT", 0);
    C = localPriority1;
    Priority localPriority2 = new Priority("VERY_LOW", 1);
    F = localPriority2;
    Priority localPriority3 = new Priority("HIGHEST", 2);
    G = localPriority3;
    $VALUES = new Priority[] { localPriority1, localPriority2, localPriority3 };
  }
}

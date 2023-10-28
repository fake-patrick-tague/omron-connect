package com.alivecor.mapsforge.core.model;

public enum c
{
  private String c;
  
  static
  {
    c localC1 = new c("KDM", 0);
    t1 = localC1;
    c localC2 = new c("TRIPOD", 1);
    t2 = localC2;
    c localC3 = new c("TRIANGLE", 2);
    deviceList = localC3;
    c localC4 = new c("SAKURA_ONE", 3);
    J = localC4;
    c localC5 = new c("UNSPECIFIED", 4);
    b = localC5;
    e = new c[] { localC1, localC2, localC3, localC4, localC5 };
    c = "KardiaMobile";
    c = "Tripod";
    c = "OMRON Complete?";
    c = "KardiaMobile 6L";
    c = "UnSpecified";
  }
  
  public static c a(String paramString)
  {
    if (paramString != null)
    {
      c[] arrayOfC = values();
      int j = arrayOfC.length;
      int i = 0;
      while (i < j)
      {
        c localC = arrayOfC[i];
        if (c.equalsIgnoreCase(paramString)) {
          return localC;
        }
        i += 1;
      }
    }
    return b;
  }
  
  public String a()
  {
    return c;
  }
}

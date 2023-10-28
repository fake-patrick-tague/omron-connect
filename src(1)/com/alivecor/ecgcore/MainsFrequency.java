package com.alivecor.ecgcore;

public enum MainsFrequency
{
  public int code;
  
  static
  {
    MainsFrequency localMainsFrequency1 = new MainsFrequency("MAINS_60_HZ", 0, 0);
    MAINS_60_HZ = localMainsFrequency1;
    MainsFrequency localMainsFrequency2 = new MainsFrequency("MAINS_50_HZ", 1, 1);
    MAINS_50_HZ = localMainsFrequency2;
    $VALUES = new MainsFrequency[] { localMainsFrequency1, localMainsFrequency2 };
  }
  
  private MainsFrequency(int paramInt)
  {
    code = paramInt;
  }
  
  public static MainsFrequency fromInt(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return MAINS_50_HZ;
    }
    return MAINS_60_HZ;
  }
}

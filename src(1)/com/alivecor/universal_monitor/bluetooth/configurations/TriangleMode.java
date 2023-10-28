package com.alivecor.universal_monitor.bluetooth.configurations;

public enum TriangleMode
{
  private int mode;
  private String settingString;
  
  static
  {
    TriangleMode localTriangleMode1 = new TriangleMode("SINGLE_LEAD_300HZ", 0, "M1", 1);
    SINGLE_LEAD_300HZ = localTriangleMode1;
    TriangleMode localTriangleMode2 = new TriangleMode("DUAL_LEAD_300HZ", 1, "M2", 2);
    DUAL_LEAD_300HZ = localTriangleMode2;
    TriangleMode localTriangleMode3 = new TriangleMode("SINGLE_LEAD_600HZ", 2, "M3", 3);
    SINGLE_LEAD_600HZ = localTriangleMode3;
    TriangleMode localTriangleMode4 = new TriangleMode("DUAL_LEAD_600HZ", 3, "M4", 4);
    DUAL_LEAD_600HZ = localTriangleMode4;
    $VALUES = new TriangleMode[] { localTriangleMode1, localTriangleMode2, localTriangleMode3, localTriangleMode4 };
  }
  
  private TriangleMode(String paramString, int paramInt)
  {
    settingString = paramString;
    mode = paramInt;
  }
  
  public String settingString()
  {
    return settingString;
  }
}

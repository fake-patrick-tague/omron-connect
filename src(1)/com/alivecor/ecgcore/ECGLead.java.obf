package com.alivecor.ecgcore;

public enum ECGLead
{
  public int code;
  
  static
  {
    ECGLead localECGLead1 = new ECGLead("UNSPECIFIED", 0, 0);
    UNSPECIFIED = localECGLead1;
    ECGLead localECGLead2 = new ECGLead("LEAD_I", 1, 1);
    LEAD_I = localECGLead2;
    ECGLead localECGLead3 = new ECGLead("LEAD_II", 2, 2);
    LEAD_II = localECGLead3;
    ECGLead localECGLead4 = new ECGLead("LEAD_III", 3, 3);
    LEAD_III = localECGLead4;
    ECGLead localECGLead5 = new ECGLead("LEAD_AVR", 4, 4);
    LEAD_AVR = localECGLead5;
    ECGLead localECGLead6 = new ECGLead("LEAD_AVL", 5, 5);
    LEAD_AVL = localECGLead6;
    ECGLead localECGLead7 = new ECGLead("LEAD_AVF", 6, 6);
    LEAD_AVF = localECGLead7;
    ECGLead localECGLead8 = new ECGLead("LEAD_V1", 7, 7);
    LEAD_V1 = localECGLead8;
    ECGLead localECGLead9 = new ECGLead("LEAD_V2", 8, 8);
    LEAD_V2 = localECGLead9;
    ECGLead localECGLead10 = new ECGLead("LEAD_V3", 9, 9);
    LEAD_V3 = localECGLead10;
    ECGLead localECGLead11 = new ECGLead("LEAD_V4", 10, 10);
    LEAD_V4 = localECGLead11;
    ECGLead localECGLead12 = new ECGLead("LEAD_V5", 11, 11);
    LEAD_V5 = localECGLead12;
    ECGLead localECGLead13 = new ECGLead("LEAD_V6", 12, 12);
    LEAD_V6 = localECGLead13;
    $VALUES = new ECGLead[] { localECGLead1, localECGLead2, localECGLead3, localECGLead4, localECGLead5, localECGLead6, localECGLead7, localECGLead8, localECGLead9, localECGLead10, localECGLead11, localECGLead12, localECGLead13 };
  }
  
  private ECGLead(int paramInt)
  {
    code = paramInt;
  }
  
  public static ECGLead fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 12: 
      return LEAD_V6;
    case 11: 
      return LEAD_V5;
    case 10: 
      return LEAD_V4;
    case 9: 
      return LEAD_V3;
    case 8: 
      return LEAD_V2;
    case 7: 
      return LEAD_V1;
    case 6: 
      return LEAD_AVF;
    case 5: 
      return LEAD_AVL;
    case 4: 
      return LEAD_AVR;
    case 3: 
      return LEAD_III;
    case 2: 
      return LEAD_II;
    case 1: 
      return LEAD_I;
    }
    return UNSPECIFIED;
  }
}

package com.alivecor.kardia_ai;

public enum AlgorithmDetermination
{
  public int algorithmDetermination;
  
  static
  {
    AlgorithmDetermination localAlgorithmDetermination1 = new AlgorithmDetermination("NO_ANALYSIS", 0, 0);
    NO_ANALYSIS = localAlgorithmDetermination1;
    AlgorithmDetermination localAlgorithmDetermination2 = new AlgorithmDetermination("UNREADABLE", 1, 1);
    UNREADABLE = localAlgorithmDetermination2;
    AlgorithmDetermination localAlgorithmDetermination3 = new AlgorithmDetermination("TOO_SHORT", 2, 2);
    TOO_SHORT = localAlgorithmDetermination3;
    AlgorithmDetermination localAlgorithmDetermination4 = new AlgorithmDetermination("TOO_LONG", 3, 3);
    TOO_LONG = localAlgorithmDetermination4;
    AlgorithmDetermination localAlgorithmDetermination5 = new AlgorithmDetermination("UNCLASSIFIED", 4, 4);
    UNCLASSIFIED = localAlgorithmDetermination5;
    AlgorithmDetermination localAlgorithmDetermination6 = new AlgorithmDetermination("NORMAL", 5, 5);
    NORMAL = localAlgorithmDetermination6;
    AlgorithmDetermination localAlgorithmDetermination7 = new AlgorithmDetermination("ATRIAL_FIBRILLATION", 6, 6);
    ATRIAL_FIBRILLATION = localAlgorithmDetermination7;
    AlgorithmDetermination localAlgorithmDetermination8 = new AlgorithmDetermination("BRADYCARDIA", 7, 7);
    BRADYCARDIA = localAlgorithmDetermination8;
    AlgorithmDetermination localAlgorithmDetermination9 = new AlgorithmDetermination("TACHYCARDIA", 8, 8);
    TACHYCARDIA = localAlgorithmDetermination9;
    $VALUES = new AlgorithmDetermination[] { localAlgorithmDetermination1, localAlgorithmDetermination2, localAlgorithmDetermination3, localAlgorithmDetermination4, localAlgorithmDetermination5, localAlgorithmDetermination6, localAlgorithmDetermination7, localAlgorithmDetermination8, localAlgorithmDetermination9 };
  }
  
  private AlgorithmDetermination(int paramInt)
  {
    algorithmDetermination = paramInt;
  }
  
  public static AlgorithmDetermination fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 8: 
      return TACHYCARDIA;
    case 7: 
      return BRADYCARDIA;
    case 6: 
      return ATRIAL_FIBRILLATION;
    case 5: 
      return NORMAL;
    case 4: 
      return UNCLASSIFIED;
    case 3: 
      return TOO_LONG;
    case 2: 
      return TOO_SHORT;
    case 1: 
      return UNREADABLE;
    }
    return NO_ANALYSIS;
  }
}

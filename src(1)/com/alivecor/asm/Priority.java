package com.alivecor.asm;

import com.alivecor.ai.o;
import com.alivecor.kardia_ai.AlgorithmDetermination;
import com.google.gson.v.c;

public enum Priority
{
  static
  {
    Priority localPriority1 = new Priority("NORMAL", 0);
    E = localPriority1;
    Priority localPriority2 = new Priority("AFIB", 1);
    W = localPriority2;
    Priority localPriority3 = new Priority("UNCLASSIFIED", 2);
    PURCHASED = localPriority3;
    Priority localPriority4 = new Priority("BRADYCARDIA", 3);
    CANCELLED = localPriority4;
    Priority localPriority5 = new Priority("TACHYCARDIA", 4);
    ERRORED = localPriority5;
    Priority localPriority6 = new Priority("SHORT", 5);
    Normal = localPriority6;
    Priority localPriority7 = new Priority("LONG", 6);
    High = localPriority7;
    Priority localPriority8 = new Priority("UNREADABLE", 7);
    Low = localPriority8;
    Priority localPriority9 = new Priority("NO_ANALYSIS", 8);
    Off = localPriority9;
    $VALUES = new Priority[] { localPriority1, localPriority2, localPriority3, localPriority4, localPriority5, localPriority6, localPriority7, localPriority8, localPriority9 };
  }
  
  public static Priority getDetermination(String paramString)
  {
    return (Priority)Database.read(o.class, paramString);
  }
  
  public static AlgorithmDetermination method_3(Priority paramPriority)
  {
    switch (Purchase.State.CANCELLED[paramPriority.ordinal()])
    {
    default: 
      return AlgorithmDetermination.NO_ANALYSIS;
    case 8: 
      return AlgorithmDetermination.TOO_SHORT;
    case 7: 
      return AlgorithmDetermination.TOO_LONG;
    case 6: 
      return AlgorithmDetermination.TACHYCARDIA;
    case 5: 
      return AlgorithmDetermination.BRADYCARDIA;
    case 4: 
      return AlgorithmDetermination.ATRIAL_FIBRILLATION;
    case 3: 
      return AlgorithmDetermination.NORMAL;
    case 2: 
      return AlgorithmDetermination.UNREADABLE;
    }
    return AlgorithmDetermination.UNCLASSIFIED;
  }
  
  public static Priority valueOf(AlgorithmDetermination paramAlgorithmDetermination)
  {
    switch (Purchase.State.REFUNDED[paramAlgorithmDetermination.ordinal()])
    {
    default: 
      return Off;
    case 8: 
      return Normal;
    case 7: 
      return High;
    case 6: 
      return ERRORED;
    case 5: 
      return CANCELLED;
    case 4: 
      return W;
    case 3: 
      return E;
    case 2: 
      return Low;
    }
    return PURCHASED;
  }
  
  public String getSerializedName()
  {
    return TCharFloatMapDecorator.1.1.1.setValue(this);
  }
}

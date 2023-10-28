package com.alivecor.universal_monitor;

public enum LeadState
{
  public int leadState;
  
  static
  {
    LeadState localLeadState1 = new LeadState("OFF", 0, 0);
    SUBSCRIBED = localLeadState1;
    LeadState localLeadState2 = new LeadState("INITIALIZING", 1, 1);
    INITIALIZING = localLeadState2;
    LeadState localLeadState3 = new LeadState("ON", 2, 2);
    FAR = localLeadState3;
    $VALUES = new LeadState[] { localLeadState1, localLeadState2, localLeadState3 };
  }
  
  private LeadState(int paramInt)
  {
    leadState = paramInt;
  }
  
  public static LeadState fromInt(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return FAR;
      }
      return INITIALIZING;
    }
    return SUBSCRIBED;
  }
}

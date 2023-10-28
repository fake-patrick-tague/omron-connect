package com.alivecor.upgrade;

public enum LeadConfiguration
{
  static
  {
    LeadConfiguration localLeadConfiguration1 = new LeadConfiguration("SINGLE", 0);
    SINGLE = localLeadConfiguration1;
    LeadConfiguration localLeadConfiguration2 = new LeadConfiguration("SIX", 1);
    DOUBLE = localLeadConfiguration2;
    $VALUES = new LeadConfiguration[] { localLeadConfiguration1, localLeadConfiguration2 };
  }
}

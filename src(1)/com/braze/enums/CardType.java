package com.braze.enums;

public enum CardType
{
  public static final Companion Companion = new Companion(null);
  
  static
  {
    CONTROL = new CardType("CONTROL", 5);
  }
  
  public final int getValue()
  {
    return ordinal();
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final CardType fromValue(int paramInt)
    {
      return CardType.values()[paramInt];
    }
  }
}

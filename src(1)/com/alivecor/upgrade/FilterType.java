package com.alivecor.upgrade;

public enum FilterType
{
  static
  {
    FilterType localFilterType1 = new FilterType("ORIGINAL", 0);
    ORIGINAL = localFilterType1;
    FilterType localFilterType2 = new FilterType("ENHANCED", 1);
    ENHANCED = localFilterType2;
    $VALUES = new FilterType[] { localFilterType1, localFilterType2 };
  }
}

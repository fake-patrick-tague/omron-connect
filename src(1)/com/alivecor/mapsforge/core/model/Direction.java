package com.alivecor.mapsforge.core.model;

import com.alivecor.ecg.core.model.b;

public enum Direction
{
  static
  {
    Direction localDirection1 = new Direction("SINGLE", 0);
    S = localDirection1;
    Direction localDirection2 = new Direction("TWO", 1);
    E = localDirection2;
    Direction localDirection3 = new Direction("SIX", 2);
    W = localDirection3;
    $VALUES = new Direction[] { localDirection1, localDirection2, localDirection3 };
  }
  
  public static Direction getRandom(int paramInt)
  {
    return values()[paramInt];
  }
}

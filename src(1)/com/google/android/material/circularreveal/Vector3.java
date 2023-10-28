package com.google.android.material.circularreveal;

import android.util.Property;

public class Vector3
  extends Property<c, Integer>
{
  public static final Property<c, Integer> y = new Vector3("circularRevealScrimColor");
  
  private Vector3(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public void add(c paramC, Integer paramInteger)
  {
    paramC.setCircularRevealScrimColor(paramInteger.intValue());
  }
  
  public Integer read(c paramC)
  {
    return Integer.valueOf(paramC.getCircularRevealScrimColor());
  }
}

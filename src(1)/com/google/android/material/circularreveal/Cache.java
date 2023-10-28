package com.google.android.material.circularreveal;

import android.util.Property;

public class Cache
  extends Property<c, c.e>
{
  public static final Property<c, c.e> l = new Cache("circularReveal");
  
  private Cache(String paramString)
  {
    super(c.e.class, paramString);
  }
  
  public Label getElement(c paramC)
  {
    return paramC.getRevealInfo();
  }
  
  public void write(c paramC, Label paramLabel)
  {
    paramC.setRevealInfo(paramLabel);
  }
}

package com.google.android.flexbox;

import android.os.Parcelable;

abstract interface FlexItem
  extends Parcelable
{
  public abstract int b();
  
  public abstract int c();
  
  public abstract int d();
  
  public abstract float e();
  
  public abstract int f();
  
  public abstract int getAttributeCount();
  
  public abstract int getHeight();
  
  public abstract float getRectF();
  
  public abstract int getWidth();
  
  public abstract float h();
  
  public abstract int height();
  
  public abstract int n();
  
  public abstract int readUnsignedShort();
  
  public abstract boolean visitFrame();
  
  public abstract int width();
}

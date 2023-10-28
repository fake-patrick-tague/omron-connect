package com.google.android.datatransport.asm;

import com.google.android.datatransport.Priority;

public abstract class Glide
{
  public Glide() {}
  
  public abstract Context get();
  
  public abstract Glide get(Priority paramPriority);
  
  public abstract Glide get(String paramString);
  
  public abstract Glide get(byte[] paramArrayOfByte);
}

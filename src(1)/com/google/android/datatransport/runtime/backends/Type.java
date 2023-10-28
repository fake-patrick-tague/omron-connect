package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.asm.asm.Label;

public abstract class Type
{
  public Type() {}
  
  public static Type a(Context paramContext, Label paramLabel1, Label paramLabel2, String paramString)
  {
    return new Attribute(paramContext, paramLabel1, paramLabel2, paramString);
  }
  
  public abstract Label a();
  
  public abstract String getKey();
  
  public abstract Label getName();
  
  public abstract Context getValue();
}

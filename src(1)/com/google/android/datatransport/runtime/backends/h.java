package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.asm.asm.Label;

class h
{
  private final Label b;
  private final Label c;
  private final Context l;
  
  h(Context paramContext, Label paramLabel1, Label paramLabel2)
  {
    l = paramContext;
    c = paramLabel1;
    b = paramLabel2;
  }
  
  Type a(String paramString)
  {
    return Type.a(l, c, b, paramString);
  }
}

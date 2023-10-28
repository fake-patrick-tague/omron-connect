package androidx.work.impl.foreground;

import androidx.work.Handle;

public abstract interface Item
{
  public abstract void a(String paramString, Handle paramHandle);
  
  public abstract void clear(String paramString);
}

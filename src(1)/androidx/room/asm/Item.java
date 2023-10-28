package androidx.room.asm;

import v7.td.data.Context;

public abstract class Item
{
  public final int b;
  public final int c;
  
  public Item(int paramInt1, int paramInt2)
  {
    c = paramInt1;
    b = paramInt2;
  }
  
  public abstract void initialize(Context paramContext);
}

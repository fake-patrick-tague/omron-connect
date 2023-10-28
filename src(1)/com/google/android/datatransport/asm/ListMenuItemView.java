package com.google.android.datatransport.asm;

import com.google.android.datatransport.Item;
import com.google.android.datatransport.Type;
import com.google.android.datatransport.a;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.g;

final class ListMenuItemView<T>
  implements e<T>
{
  private final Type b;
  private final String c;
  private final d<T, byte[]> d;
  private final LayoutManager j;
  private final Context l;
  
  ListMenuItemView(Context paramContext, String paramString, Type paramType, g paramG, LayoutManager paramLayoutManager)
  {
    l = paramContext;
    c = paramString;
    b = paramType;
    d = paramG;
    j = paramLayoutManager;
  }
  
  public void a(a paramA)
  {
    a(paramA, c.d);
  }
  
  public void a(a paramA, Item paramItem)
  {
    j.a(m.b().a(l).a(paramA).a(c).a(d).b(b).a(), paramItem);
  }
}

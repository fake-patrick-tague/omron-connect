package com.google.android.datatransport.asm;

import com.google.android.datatransport.Label;
import com.google.android.datatransport.Type;
import com.google.android.datatransport.aa;
import com.google.android.datatransport.b;
import com.google.android.datatransport.g;
import java.util.Set;

final class l
  implements Label
{
  private final Set<b> b;
  private final LayoutManager h;
  private final Context i;
  
  l(Set paramSet, Context paramContext, LayoutManager paramLayoutManager)
  {
    b = paramSet;
    i = paramContext;
    h = paramLayoutManager;
  }
  
  public aa a(String paramString, Class paramClass, Type paramType, g paramG)
  {
    if (b.contains(paramType)) {
      return new ListMenuItemView(i, paramString, paramType, paramG, h);
    }
    throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[] { paramType, b }));
  }
  
  public aa a(String paramString, Class paramClass, g paramG)
  {
    return a(paramString, paramClass, Type.valueOf("proto"), paramG);
  }
}

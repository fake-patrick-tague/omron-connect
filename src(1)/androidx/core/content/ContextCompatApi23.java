package androidx.core.content;

import android.content.Context;

class ContextCompatApi23
{
  static int getColor(Context paramContext, int paramInt)
  {
    return paramContext.getColor(paramInt);
  }
  
  static String getColor(Context paramContext, Class paramClass)
  {
    return paramContext.getSystemServiceName(paramClass);
  }
  
  static Object getService(Context paramContext, Class paramClass)
  {
    return paramContext.getSystemService(paramClass);
  }
}

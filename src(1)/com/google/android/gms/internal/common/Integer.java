package com.google.android.gms.internal.common;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class Integer
{
  public static String format(String paramString, Object... paramVarArgs)
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      j = paramVarArgs.length;
      if (i >= j) {
        break;
      }
      Object localObject2 = paramVarArgs[i];
      String str;
      if (localObject2 == null) {
        str = "null";
      } else {
        try
        {
          str = localObject2.toString();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localObject2.getClass().getName());
          localStringBuilder.append('@');
          localStringBuilder.append(java.lang.Integer.toHexString(System.identityHashCode(localObject2)));
          localObject2 = localStringBuilder.toString();
          Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat((String)localObject2), localException);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("<");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" threw ");
          localStringBuilder.append(localException.getClass().getName());
          localStringBuilder.append(">");
          localObject1 = localStringBuilder.toString();
        }
      }
      paramVarArgs[i] = localObject1;
      i += 1;
    }
    Object localObject1 = new StringBuilder(paramString.length() + j * 16);
    int j = 0;
    i = k;
    for (;;)
    {
      k = paramVarArgs.length;
      if (i >= k) {
        break;
      }
      int m = paramString.indexOf("%s", j);
      if (m == -1) {
        break;
      }
      ((StringBuilder)localObject1).append(paramString, j, m);
      ((StringBuilder)localObject1).append(paramVarArgs[i]);
      j = m + 2;
      i += 1;
    }
    ((StringBuilder)localObject1).append(paramString, j, paramString.length());
    if (i < k)
    {
      ((StringBuilder)localObject1).append(" [");
      j = i + 1;
      ((StringBuilder)localObject1).append(paramVarArgs[i]);
      i = j;
      while (i < paramVarArgs.length)
      {
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(paramVarArgs[i]);
        i += 1;
      }
      ((StringBuilder)localObject1).append(']');
    }
    return ((StringBuilder)localObject1).toString();
  }
}

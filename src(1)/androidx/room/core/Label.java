package androidx.room.core;

import android.os.Build.VERSION;
import androidx.room.q.f.a;
import java.util.Locale;

public class Label
{
  public final String a;
  public final int b;
  public final boolean c;
  public final int d;
  private final int e;
  public final String f;
  public final String g;
  
  public Label(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, String paramString3, int paramInt2)
  {
    f = paramString1;
    g = paramString2;
    c = paramBoolean;
    b = paramInt1;
    d = getType(paramString2);
    a = paramString3;
    e = paramInt2;
  }
  
  private static int getType(String paramString)
  {
    if (paramString == null) {
      return 5;
    }
    paramString = paramString.toUpperCase(Locale.US);
    if (paramString.contains("INT")) {
      return 3;
    }
    if ((!paramString.contains("CHAR")) && (!paramString.contains("CLOB")) && (!paramString.contains("TEXT")))
    {
      if (paramString.contains("BLOB")) {
        return 5;
      }
      if ((!paramString.contains("REAL")) && (!paramString.contains("FLOA")) && (!paramString.contains("DOUB"))) {
        return 1;
      }
      return 4;
    }
    return 2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (f.a.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Label)paramObject;
      if (Build.VERSION.SDK_INT >= 20)
      {
        if (b != b) {
          return false;
        }
      }
      else if (getColor() != paramObject.getColor()) {
        return false;
      }
      if (!f.equals(f)) {
        return false;
      }
      if (c != c) {
        return false;
      }
      String str;
      if ((e == 1) && (e == 2))
      {
        str = a;
        if ((str != null) && (!str.equals(a))) {
          return false;
        }
      }
      if ((e == 2) && (e == 1))
      {
        str = a;
        if ((str != null) && (!str.equals(a))) {
          return false;
        }
      }
      int i = e;
      if ((i != 0) && (i == e))
      {
        str = a;
        if (str != null)
        {
          if (!str.equals(a)) {
            return false;
          }
        }
        else if (a != null) {
          return false;
        }
      }
      if (d == d) {
        return true;
      }
    }
    return false;
  }
  
  public boolean getColor()
  {
    return b > 0;
  }
  
  public int hashCode()
  {
    int j = f.hashCode();
    int k = d;
    int i;
    if (c) {
      i = 1231;
    } else {
      i = 1237;
    }
    return ((j * 31 + k) * 31 + i) * 31 + b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Column{name='");
    localStringBuilder.append(f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type='");
    localStringBuilder.append(g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", affinity='");
    localStringBuilder.append(d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", notNull=");
    localStringBuilder.append(c);
    localStringBuilder.append(", primaryKeyPosition=");
    localStringBuilder.append(b);
    localStringBuilder.append(", defaultValue='");
    localStringBuilder.append(a);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

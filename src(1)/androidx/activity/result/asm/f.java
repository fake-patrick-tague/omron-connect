package androidx.activity.result.asm;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.d.a;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.a0;
import kotlin.collections.c;
import kotlin.l;
import kotlin.q;
import kotlin.z.d;

public final class f
  extends a<String[], Map<String, Boolean>>
{
  public static final h g = new h(null);
  
  public f() {}
  
  public Label a(Context paramContext, String[] paramArrayOfString)
  {
    kotlin.x.d.i.e(paramContext, "context");
    kotlin.x.d.i.e(paramArrayOfString, "input");
    int i = paramArrayOfString.length;
    int m = 1;
    int k = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new Label(a0.d());
    }
    int n = paramArrayOfString.length;
    i = 0;
    int j;
    for (;;)
    {
      j = m;
      if (i >= n) {
        break;
      }
      if (ContextCompat.checkSelfPermission(paramContext, paramArrayOfString[i]) == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0)
      {
        j = 0;
        break;
      }
      i += 1;
    }
    if (j != 0)
    {
      paramContext = new LinkedHashMap(d.a(a0.a(paramArrayOfString.length), 16));
      j = paramArrayOfString.length;
      i = k;
      while (i < j)
      {
        l localL = q.a(paramArrayOfString[i], Boolean.TRUE);
        paramContext.put(localL.c(), localL.d());
        i += 1;
      }
      return new Label(paramContext);
    }
    return null;
  }
  
  public Map a(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return a0.d();
    }
    if (paramIntent == null) {
      return a0.d();
    }
    String[] arrayOfString = paramIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
    paramIntent = paramIntent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
    if ((paramIntent != null) && (arrayOfString != null))
    {
      ArrayList localArrayList = new ArrayList(paramIntent.length);
      int i = paramIntent.length;
      paramInt = 0;
      while (paramInt < i)
      {
        boolean bool;
        if (paramIntent[paramInt] == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localArrayList.add(Boolean.valueOf(bool));
        paramInt += 1;
      }
      return a0.i(kotlin.collections.i.L(c.i(arrayOfString), localArrayList));
    }
    return a0.d();
  }
  
  public Intent c(Context paramContext, String[] paramArrayOfString)
  {
    kotlin.x.d.i.e(paramContext, "context");
    kotlin.x.d.i.e(paramArrayOfString, "input");
    return g.a(paramArrayOfString);
  }
}

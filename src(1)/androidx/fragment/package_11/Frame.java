package androidx.fragment.package_11;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

class Frame
{
  static final FragmentTransitionCompat21 d;
  static final FragmentTransitionCompat21 g = create();
  
  static
  {
    ASN1Integer localASN1Integer;
    if (Build.VERSION.SDK_INT >= 21) {
      localASN1Integer = new ASN1Integer();
    } else {
      localASN1Integer = null;
    }
    d = localASN1Integer;
  }
  
  static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap paramArrayMap, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      paramFragment1 = paramFragment2.getEnterTransitionCallback();
    } else {
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
    }
    if (paramFragment1 != null)
    {
      paramFragment1 = new ArrayList();
      paramFragment2 = new ArrayList();
      int j = 0;
      int i;
      if (paramArrayMap == null) {
        i = 0;
      } else {
        i = paramArrayMap.size();
      }
      while (j < i)
      {
        paramFragment2.add((String)paramArrayMap.size(j));
        paramFragment1.add((View)paramArrayMap.get(j));
        j += 1;
      }
      if (paramBoolean2) {
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  static void a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      ((View)paramArrayList.get(i)).setVisibility(paramInt);
      i -= 1;
    }
  }
  
  private static FragmentTransitionCompat21 create()
  {
    try
    {
      Object localObject = Class.forName("androidx.transition.b");
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[0]);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return (FragmentTransitionCompat21)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  static void remove(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2)
  {
    int i = paramArrayMap1.size() - 1;
    while (i >= 0)
    {
      if (!paramArrayMap2.containsKey((String)paramArrayMap1.get(i))) {
        paramArrayMap1.removeAt(i);
      }
      i -= 1;
    }
  }
}

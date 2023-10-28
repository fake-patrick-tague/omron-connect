package androidx.lifecycle;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.MenuItem;
import androidx.savedstate.c.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.a0;
import kotlin.l;
import kotlin.q;
import kotlin.x.d.i;
import v7.v7.menu.w;

public final class Item
{
  public static final AnnotationWriter h = new AnnotationWriter(null);
  private static final Class<? extends Object>[] index;
  private final MenuItem a;
  private final Map<String, ?> b;
  private final Map<String, Object> c;
  private final Map<String, kotlinx.coroutines.flow.a<Object>> d;
  private final Map<String, c.c> g;
  
  static
  {
    Class localClass2 = Boolean.TYPE;
    Class localClass3 = Double.TYPE;
    Class localClass1 = Integer.TYPE;
    Class localClass4 = Long.TYPE;
    Class localClass5 = Byte.TYPE;
    Class localClass6 = Character.TYPE;
    Class localClass7 = Float.TYPE;
    Class localClass8 = Short.TYPE;
    int i = Build.VERSION.SDK_INT;
    Object localObject2;
    if (i >= 21) {
      localObject2 = Size.class;
    } else {
      localObject2 = localClass1;
    }
    Object localObject1 = localClass1;
    if (i >= 21) {
      localObject1 = SizeF.class;
    }
    index = new Class[] { localClass2, [Z.class, localClass3, [D.class, localClass1, [I.class, localClass4, [J.class, String.class, [Ljava.lang.String.class, Binder.class, Bundle.class, localClass5, [B.class, localClass6, [C.class, CharSequence.class, [Ljava.lang.CharSequence.class, ArrayList.class, localClass7, [F.class, Parcelable.class, [Landroid.os.Parcelable.class, Serializable.class, localClass8, [S.class, SparseArray.class, localObject2, localObject1 };
  }
  
  public Item()
  {
    c = new LinkedHashMap();
    g = new LinkedHashMap();
    b = new LinkedHashMap();
    d = new LinkedHashMap();
    a = new a(this);
  }
  
  public Item(Map paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    c = localLinkedHashMap;
    g = new LinkedHashMap();
    b = new LinkedHashMap();
    d = new LinkedHashMap();
    a = new a(this);
    localLinkedHashMap.putAll(paramMap);
  }
  
  private static final Bundle a(Item paramItem)
  {
    i.e(paramItem, "this$0");
    Object localObject1 = a0.k(g).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramItem.a((String)((Map.Entry)localObject2).getKey(), ((MenuItem)((Map.Entry)localObject2).getValue()).onSaveInstanceState());
    }
    Object localObject3 = c.keySet();
    localObject1 = new ArrayList(((Set)localObject3).size());
    Object localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      ((ArrayList)localObject1).add(str);
      ((ArrayList)localObject2).add(c.get(str));
    }
    return w.bundleOf(new l[] { q.a("keys", localObject1), q.a("values", localObject2) });
  }
  
  public static final Item a(Bundle paramBundle1, Bundle paramBundle2)
  {
    return h.a(paramBundle1, paramBundle2);
  }
  
  public final MenuItem a()
  {
    return a;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    i.e(paramString, "key");
    if (h.a(paramObject))
    {
      Object localObject = b.get(paramString);
      if ((localObject instanceof StatusPreference)) {
        localObject = (StatusPreference)localObject;
      } else {
        localObject = null;
      }
      if (localObject != null) {
        ((StatusPreference)localObject).setValue(paramObject);
      } else {
        c.put(paramString, paramObject);
      }
      paramString = (kotlinx.coroutines.flow.a)d.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.setValue(paramObject);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Can't put value with type ");
    i.b(paramObject);
    paramString.append(paramObject.getClass());
    paramString.append(" into saved state");
    throw new IllegalArgumentException(paramString.toString());
  }
}

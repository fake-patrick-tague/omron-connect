package androidx.lifecycle;

import android.os.BaseBundle;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.x.d.i;

public final class AnnotationWriter
{
  private AnnotationWriter() {}
  
  public final Item a(Bundle paramBundle1, Bundle paramBundle2)
  {
    Object localObject1;
    Object localObject2;
    if (paramBundle1 == null)
    {
      if (paramBundle2 == null) {
        return new Item();
      }
      paramBundle1 = new HashMap();
      localObject1 = paramBundle2.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        i.d(localObject2, "key");
        paramBundle1.put(localObject2, paramBundle2.get((String)localObject2));
      }
      return new Item(paramBundle1);
    }
    paramBundle2 = paramBundle1.getParcelableArrayList("keys");
    paramBundle1 = paramBundle1.getParcelableArrayList("values");
    int j = 0;
    int i;
    if ((paramBundle2 != null) && (paramBundle1 != null) && (paramBundle2.size() == paramBundle1.size())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = new LinkedHashMap();
      int k = paramBundle2.size();
      i = j;
      while (i < k)
      {
        localObject2 = paramBundle2.get(i);
        Objects.requireNonNull(localObject2, "null cannot be cast to non-null type kotlin.String");
        ((Map)localObject1).put((String)localObject2, paramBundle1.get(i));
        i += 1;
      }
      return new Item((Map)localObject1);
    }
    throw new IllegalStateException("Invalid bundle passed as restored state".toString());
  }
  
  public final boolean a(Object paramObject)
  {
    if (paramObject == null) {
      return true;
    }
    Class[] arrayOfClass = Item.newUTF8();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      i.b(localClass);
      if (localClass.isInstance(paramObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}

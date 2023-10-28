package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Log;
import androidx.work.ObjectWithId;
import androidx.work.h;
import androidx.work.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Label
  extends ObjectWithId
{
  private static final String g = Log.getInstance("WorkContinuationImpl");
  private final List<String> a;
  private final f b;
  private androidx.work.b c;
  private boolean e;
  private final List<String> f;
  private final ExistingWorkPolicy h;
  private final String i;
  private final List<g> state;
  private final List<? extends s> values;
  
  public Label(f paramF, String paramString, ExistingWorkPolicy paramExistingWorkPolicy, List paramList1, List paramList2)
  {
    b = paramF;
    i = paramString;
    h = paramExistingWorkPolicy;
    values = paramList1;
    state = paramList2;
    a = new ArrayList(paramList1.size());
    f = new ArrayList();
    if (paramList2 != null)
    {
      paramF = paramList2.iterator();
      while (paramF.hasNext())
      {
        paramString = (Label)paramF.next();
        f.addAll(f);
      }
    }
    int j = 0;
    while (j < paramList1.size())
    {
      paramF = ((h)paramList1.get(j)).a();
      a.add(paramF);
      f.add(paramF);
      j += 1;
    }
  }
  
  public Label(f paramF, List paramList)
  {
    this(paramF, null, ExistingWorkPolicy.c, paramList, null);
  }
  
  private static boolean a(Label paramLabel, Set paramSet)
  {
    paramSet.addAll(paramLabel.get());
    Object localObject = get(paramLabel);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (((Set)localObject).contains((String)localIterator.next())) {
        return true;
      }
    }
    localObject = paramLabel.getValue();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a((Label)((Iterator)localObject).next(), paramSet)) {
          return true;
        }
      }
    }
    paramSet.removeAll(paramLabel.get());
    return false;
  }
  
  public static Set get(Label paramLabel)
  {
    HashSet localHashSet = new HashSet();
    paramLabel = paramLabel.getValue();
    if ((paramLabel != null) && (!paramLabel.isEmpty()))
    {
      paramLabel = paramLabel.iterator();
      while (paramLabel.hasNext()) {
        localHashSet.addAll(((Label)paramLabel.next()).get());
      }
    }
    return localHashSet;
  }
  
  public androidx.work.b a()
  {
    if (!e)
    {
      androidx.work.impl.utils.b localB = new androidx.work.impl.utils.b(this);
      b.i().get(localB);
      c = localB.a();
    }
    else
    {
      Log.get().add(g, String.format("Already enqueued work ids (%s)", new Object[] { TextUtils.join(", ", a) }), new Throwable[0]);
    }
    return c;
  }
  
  public f b()
  {
    return b;
  }
  
  public String c()
  {
    return i;
  }
  
  public ExistingWorkPolicy d()
  {
    return h;
  }
  
  public boolean draw()
  {
    return a(this, new HashSet());
  }
  
  public List get()
  {
    return a;
  }
  
  public List getValue()
  {
    return state;
  }
  
  public boolean next()
  {
    return e;
  }
  
  public List put()
  {
    return values;
  }
  
  public void setIcon()
  {
    e = true;
  }
}

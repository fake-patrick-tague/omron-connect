package androidx.work.impl;

import androidx.lifecycle.StatusPreference;
import androidx.lifecycle.s;
import androidx.work.Series;
import androidx.work.impl.utils.futures.Context;
import androidx.work.l.b;
import androidx.work.l.b.a;
import androidx.work.l.b.c;

public class Pair
  implements androidx.work.b
{
  private final androidx.work.impl.utils.futures.b<l.b.c> a = Context.getInstance();
  private final s<l.b> b = new StatusPreference();
  
  public Pair()
  {
    add(androidx.work.b.d);
  }
  
  public void add(Series paramSeries)
  {
    b.postValue(paramSeries);
    if ((paramSeries instanceof l.b.c))
    {
      a.get((l.b.c)paramSeries);
      return;
    }
    if ((paramSeries instanceof l.b.a))
    {
      paramSeries = (l.b.a)paramSeries;
      a.get(paramSeries.get());
    }
  }
}

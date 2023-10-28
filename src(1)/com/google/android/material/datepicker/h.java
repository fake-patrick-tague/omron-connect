package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

class h
  extends BaseAdapter
{
  static final int b = Log.getInstance().getMaximum(4);
  final DateSelector<?> a;
  final Month c;
  a f;
  private Collection<Long> k;
  final CalendarConstraints o;
  
  h(Month paramMonth, DateSelector paramDateSelector, CalendarConstraints paramCalendarConstraints)
  {
    c = paramMonth;
    a = paramDateSelector;
    o = paramCalendarConstraints;
    k = paramDateSelector.getText();
  }
  
  private void a(TextView paramTextView, long paramLong)
  {
    if (paramTextView == null) {
      return;
    }
    f localF;
    if (o.a().a(paramLong))
    {
      paramTextView.setEnabled(true);
      if (a(paramLong)) {
        localF = f.d;
      } else if (Log.getCalendar().getTimeInMillis() == paramLong) {
        localF = f.c;
      } else {
        localF = f.a;
      }
    }
    else
    {
      paramTextView.setEnabled(false);
      localF = f.b;
    }
    localF.a(paramTextView);
  }
  
  private void a(MaterialCalendarGridView paramMaterialCalendarGridView, long paramLong)
  {
    if (Month.toString(paramLong).equals(c))
    {
      int i = c.getDate(paramLong);
      a((TextView)paramMaterialCalendarGridView.getChildAt(paramMaterialCalendarGridView.a().getCount(i) - paramMaterialCalendarGridView.getFirstVisiblePosition()), paramLong);
    }
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = a.getText().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      if (Log.add(paramLong) == Log.add(l)) {
        return true;
      }
    }
    return false;
  }
  
  private void e(Context paramContext)
  {
    if (f == null) {
      f = new a(paramContext);
    }
  }
  
  int a()
  {
    return c.equals();
  }
  
  public TextView a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    e(paramViewGroup.getContext());
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(org.org.org.ui.h.v, paramViewGroup, false);
    }
    int i = paramInt - a();
    if (i >= 0)
    {
      paramView = c;
      if (i < c)
      {
        i += 1;
        localTextView.setTag(paramView);
        localTextView.setText(String.format(getResourcesgetConfigurationlocale, "%d", new Object[] { Integer.valueOf(i) }));
        long l = c.get(i);
        if (c.a == nexta) {
          localTextView.setContentDescription(Segment.getValue(l));
        } else {
          localTextView.setContentDescription(Segment.getTitle(l));
        }
        localTextView.setVisibility(0);
        localTextView.setEnabled(true);
        break label191;
      }
    }
    localTextView.setVisibility(8);
    localTextView.setEnabled(false);
    label191:
    paramView = get(paramInt);
    if (paramView == null) {
      return localTextView;
    }
    a(localTextView, paramView.longValue());
    return localTextView;
  }
  
  public void a(MaterialCalendarGridView paramMaterialCalendarGridView)
  {
    Object localObject = k.iterator();
    while (((Iterator)localObject).hasNext()) {
      a(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
    }
    localObject = a;
    if (localObject != null)
    {
      localObject = ((DateSelector)localObject).getText().iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
      }
      k = a.getText();
    }
  }
  
  boolean a(int paramInt)
  {
    return paramInt % c.b == 0;
  }
  
  boolean b(int paramInt)
  {
    return (paramInt >= a()) && (paramInt <= next());
  }
  
  boolean equals(int paramInt)
  {
    return (paramInt + 1) % c.b == 0;
  }
  
  public Long get(int paramInt)
  {
    if ((paramInt >= c.equals()) && (paramInt <= next())) {
      return Long.valueOf(c.get(toString(paramInt)));
    }
    return null;
  }
  
  public int getCount()
  {
    return c.c + a();
  }
  
  int getCount(int paramInt)
  {
    return a() + (paramInt - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt / c.b;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  int next()
  {
    return c.equals() + c.c - 1;
  }
  
  int toString(int paramInt)
  {
    return paramInt - c.equals() + 1;
  }
}

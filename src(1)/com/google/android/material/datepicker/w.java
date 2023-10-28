package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;
import org.org.org.ui.Switch;
import org.org.org.ui.h;

class w
  extends BaseAdapter
{
  private static final int c;
  private final Calendar a;
  private final int b;
  private final int d;
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 4;
    } else {
      i = 1;
    }
    c = i;
  }
  
  public w()
  {
    Calendar localCalendar = Log.getInstance();
    a = localCalendar;
    b = localCalendar.getMaximum(7);
    d = localCalendar.getFirstDayOfWeek();
  }
  
  private int a(int paramInt)
  {
    int i = paramInt + d;
    int j = b;
    paramInt = i;
    if (i > j) {
      paramInt = i - j;
    }
    return paramInt;
  }
  
  public int getCount()
  {
    return b;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(h.f, paramViewGroup, false);
    }
    a.set(7, a(paramInt));
    paramView = getResourcesgetConfigurationlocale;
    localTextView.setText(a.getDisplayName(7, c, paramView));
    localTextView.setContentDescription(String.format(paramViewGroup.getContext().getString(Switch.b), new Object[] { a.getDisplayName(7, 2, Locale.getDefault()) }));
    return localTextView;
  }
  
  public Integer getView(int paramInt)
  {
    if (paramInt >= b) {
      return null;
    }
    return Integer.valueOf(a(paramInt));
  }
}

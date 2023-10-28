package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.b0;
import org.org.org.ui.R.id;

class t
  extends RecyclerView.Adapter<i.b>
{
  private final MaterialCalendar.k b;
  private final Context c;
  private final int d;
  private final DateSelector<?> e;
  private final CalendarConstraints f;
  
  t(Context paramContext, DateSelector paramDateSelector, CalendarConstraints paramCalendarConstraints, MaterialCalendar.k paramK)
  {
    Month localMonth1 = paramCalendarConstraints.length();
    Month localMonth2 = paramCalendarConstraints.getValue();
    Month localMonth3 = paramCalendarConstraints.add();
    if (localMonth1.compareTo(localMonth3) <= 0)
    {
      if (localMonth3.compareTo(localMonth2) <= 0)
      {
        int j = h.b;
        int k = MaterialCalendar.getNavigationBarHeight(paramContext);
        int i;
        if (d.a(paramContext)) {
          i = MaterialCalendar.getNavigationBarHeight(paramContext);
        } else {
          i = 0;
        }
        c = paramContext;
        d = (j * k + i);
        f = paramCalendarConstraints;
        e = paramDateSelector;
        b = paramK;
        setHasStableIds(true);
        return;
      }
      throw new IllegalArgumentException("currentPage cannot be after lastPage");
    }
    throw new IllegalArgumentException("firstPage cannot be after currentPage");
  }
  
  public Item a(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(org.org.org.ui.h.q, paramViewGroup, false);
    if (d.a(paramViewGroup.getContext()))
    {
      localLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, d));
      return new Item(localLinearLayout, true);
    }
    return new Item(localLinearLayout, false);
  }
  
  CharSequence a(int paramInt)
  {
    return add(paramInt).toString(c);
  }
  
  Month add(int paramInt)
  {
    return f.length().toString(paramInt);
  }
  
  int b(Month paramMonth)
  {
    return f.length().toString(paramMonth);
  }
  
  public void b(Item paramItem, int paramInt)
  {
    Month localMonth = f.length().toString(paramInt);
    a.setText(localMonth.toString(itemView.getContext()));
    paramItem = (MaterialCalendarGridView)b.findViewById(R.id.top);
    if ((paramItem.a() != null) && (localMonth.equals(ac)))
    {
      paramItem.invalidate();
      paramItem.a().a(paramItem);
    }
    else
    {
      h localH = new h(localMonth, e, f);
      paramItem.setNumColumns(b);
      paramItem.setAdapter(localH);
    }
    paramItem.setOnItemClickListener(new g(this, paramItem));
  }
  
  public int getItemCount()
  {
    return f.size();
  }
  
  public long getItemId(int paramInt)
  {
    return f.length().toString(paramInt).getDate();
  }
}

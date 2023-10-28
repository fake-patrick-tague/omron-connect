package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.org.org.ui.Switch;
import org.org.org.ui.h;

class o
  extends RecyclerView.Adapter<o.b>
{
  private final MaterialCalendar<?> b;
  
  o(MaterialCalendar paramMaterialCalendar)
  {
    b = paramMaterialCalendar;
  }
  
  private View.OnClickListener close(int paramInt)
  {
    return new l(this, paramInt);
  }
  
  int a(int paramInt)
  {
    return paramInt - b.getValue().length().a;
  }
  
  public q a(ViewGroup paramViewGroup, int paramInt)
  {
    return new q((TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(h.u, paramViewGroup, false));
  }
  
  public void a(q paramQ, int paramInt)
  {
    paramInt = b(paramInt);
    Object localObject = a.getContext().getString(Switch.l);
    a.setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(paramInt) }));
    a.setContentDescription(String.format((String)localObject, new Object[] { Integer.valueOf(paramInt) }));
    a localA = b.i();
    Calendar localCalendar = Log.getCalendar();
    if (localCalendar.get(1) == paramInt) {
      localObject = j;
    } else {
      localObject = l;
    }
    Iterator localIterator = b.append().getText().iterator();
    while (localIterator.hasNext())
    {
      localCalendar.setTimeInMillis(((Long)localIterator.next()).longValue());
      if (localCalendar.get(1) == paramInt) {
        localObject = o;
      }
    }
    ((f)localObject).a(a);
    a.setOnClickListener(close(paramInt));
  }
  
  int b(int paramInt)
  {
    return b.getValue().length().a + paramInt;
  }
  
  public int getItemCount()
  {
    return b.getValue().getItemCount();
  }
}

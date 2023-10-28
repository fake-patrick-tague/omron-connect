package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class g
  implements AdapterView.OnItemClickListener
{
  g(t paramT, MaterialCalendarGridView paramMaterialCalendarGridView) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (g.a().b(paramInt)) {
      t.a(d).a(g.a().get(paramInt).longValue());
    }
  }
}

package com.google.android.material.datepicker;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.x;
import androidx.recyclerview.widget.RecyclerView.y;

class LinearLayoutManager
  extends androidx.recyclerview.widget.LinearLayoutManager
{
  LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.y paramY, int paramInt)
  {
    paramRecyclerView = new StaggeredGridLayoutManager.2(this, paramRecyclerView.getContext());
    paramRecyclerView.d(paramInt);
    a(paramRecyclerView);
  }
}

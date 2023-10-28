package com.google.android.material.datepicker;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.b0;
import org.org.org.ui.R.id;
import v7.v7.package_13.ViewCompat;

public class Item
  extends RecyclerView.b0
{
  final TextView a;
  final MaterialCalendarGridView b;
  
  Item(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    super(paramLinearLayout);
    TextView localTextView = (TextView)paramLinearLayout.findViewById(R.id.next);
    a = localTextView;
    ViewCompat.a(localTextView, true);
    b = ((MaterialCalendarGridView)paramLinearLayout.findViewById(R.id.top));
    if (!paramBoolean) {
      localTextView.setVisibility(8);
    }
  }
}

package androidx.viewpager2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.b0;
import v7.v7.package_13.ViewCompat;

public final class Object
  extends RecyclerView.b0
{
  private Object(FrameLayout paramFrameLayout)
  {
    super(paramFrameLayout);
  }
  
  static Object init(ViewGroup paramViewGroup)
  {
    paramViewGroup = new FrameLayout(paramViewGroup.getContext());
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramViewGroup.setId(ViewCompat.generateViewId());
    paramViewGroup.setSaveEnabled(false);
    return new Object(paramViewGroup);
  }
  
  FrameLayout getValue()
  {
    return (FrameLayout)itemView;
  }
}

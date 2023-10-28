package com.braze.ui.contentcards.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.b0;
import com.braze.ui.R.layout;
import kotlin.x.d.i;

public class EmptyContentCardsAdapter
  extends RecyclerView.Adapter<RecyclerView.b0>
{
  public EmptyContentCardsAdapter() {}
  
  public int getItemCount()
  {
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.b0 paramB0, int paramInt)
  {
    i.e(paramB0, "viewHolder");
  }
  
  public RecyclerView.b0 onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    i.e(paramViewGroup, "viewGroup");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_braze_content_cards_empty, paramViewGroup, false);
    i.d(paramViewGroup, "view");
    return new NetworkUnavailableViewHolder(paramViewGroup);
  }
  
  public static final class NetworkUnavailableViewHolder
    extends RecyclerView.b0
  {
    public NetworkUnavailableViewHolder(View paramView)
    {
      super();
    }
  }
}

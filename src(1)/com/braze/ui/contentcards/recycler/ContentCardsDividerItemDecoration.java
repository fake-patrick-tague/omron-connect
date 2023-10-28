package com.braze.ui.contentcards.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.y;
import com.braze.ui.R.dimen;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import java.util.Objects;
import kotlin.x.d.i;
import kotlin.z.d;

public class ContentCardsDividerItemDecoration
  extends RecyclerView.n
{
  private final Context appContext;
  private final int contentCardsItemMaxWidth;
  private final int itemDividerHeight;
  
  public ContentCardsDividerItemDecoration(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    i.d(paramContext, "context.applicationContext");
    appContext = paramContext;
    itemDividerHeight = paramContext.getResources().getDimensionPixelSize(R.dimen.com_braze_content_cards_divider_height);
    contentCardsItemMaxWidth = paramContext.getResources().getDimensionPixelSize(R.dimen.com_braze_content_cards_max_width);
  }
  
  private final int getSidePaddingValue(int paramInt)
  {
    return d.a((paramInt - contentCardsItemMaxWidth) / 2, 0);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.y paramY)
  {
    i.e(paramRect, "itemViewOutputRect");
    i.e(paramView, "view");
    i.e(paramRecyclerView, "parent");
    i.e(paramY, "state");
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramY);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    boolean bool = paramRecyclerView.getAdapter() instanceof ContentCardAdapter;
    int j = 0;
    if (bool)
    {
      paramView = paramRecyclerView.getAdapter();
      Objects.requireNonNull(paramView, "null cannot be cast to non-null type com.braze.ui.contentcards.adapters.ContentCardAdapter");
      bool = ((ContentCardAdapter)paramView).isControlCardAtPosition(i);
    }
    else
    {
      bool = false;
    }
    if (i == 0) {
      i = itemDividerHeight;
    } else {
      i = 0;
    }
    top = i;
    if (bool) {
      i = j;
    } else {
      i = itemDividerHeight;
    }
    bottom = i;
    i = getSidePaddingValue(paramRecyclerView.getWidth());
    left = i;
    right = i;
  }
}

package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.braze.models.cards.Card;
import com.braze.ui.R.layout;
import kotlin.x.d.i;

public class DefaultContentCardView
  extends BaseContentCardView<Card>
{
  public DefaultContentCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, Card paramCard)
  {
    i.e(paramContentCardViewHolder, "viewHolder");
    i.e(paramCard, "card");
  }
  
  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    i.e(paramViewGroup, "viewGroup");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_braze_default_content_card, paramViewGroup, false);
    i.d(paramViewGroup, "view");
    return new ContentCardViewHolder(paramViewGroup, false);
  }
}

package com.braze.ui.widget;

import android.content.Context;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.R.layout;
import com.braze.ui.feed.view.BaseFeedCardView;

public class DefaultCardView
  extends BaseFeedCardView<Card>
{
  private static final String d = BrazeLogger.getBrazeLogTag(DefaultCardView.class);
  
  public DefaultCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DefaultCardView(Context paramContext, Card paramCard)
  {
    super(paramContext);
    if (paramCard != null) {
      setCard(paramCard);
    }
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_braze_default_card;
  }
  
  public void onSetCard(Card paramCard)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSetCard called for blank view with: ");
    localStringBuilder.append(paramCard.toString());
    BrazeLogger.a(str, localStringBuilder.toString());
  }
}

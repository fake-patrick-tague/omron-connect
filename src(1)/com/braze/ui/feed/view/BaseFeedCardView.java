package com.braze.ui.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ViewSwitcher;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.R.id;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.BrazeFeedManager;
import com.braze.ui.feed.BrazeImageSwitcher;
import com.braze.ui.feed.listeners.IFeedClickActionListener;
import com.braze.ui.widget.BaseCardView;

public abstract class BaseFeedCardView<T extends Card>
  extends BaseCardView<T>
{
  private static final String NOTIFICATION_URI = BrazeLogger.getBrazeLogTag(BaseCardView.class);
  
  public BaseFeedCardView(Context paramContext)
  {
    super(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(getLayoutResource(), this);
    paramContext = (BrazeImageSwitcher)findViewById(R.id.com_braze_newsfeed_item_read_indicator_image_switcher);
    imageSwitcher = paramContext;
    if (paramContext != null) {
      paramContext.setFactory(new MainActivity.4(this));
    }
    if (!isUnreadIndicatorEnabled())
    {
      paramContext = imageSwitcher;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
    }
  }
  
  public Card getCard()
  {
    return card;
  }
  
  protected abstract int getLayoutResource();
  
  public View getProperViewFromInflatedStub(int paramInt)
  {
    ((ViewStub)findViewById(paramInt)).inflate();
    return findViewById(R.id.com_braze_stubbed_feed_image_view);
  }
  
  protected boolean isClickHandled(Context paramContext, Card paramCard, IAction paramIAction)
  {
    return BrazeFeedManager.getInstance().getFeedCardClickActionListener().onFeedCardClicked(paramContext, paramCard, paramIAction);
  }
  
  protected abstract void onSetCard(Card paramCard);
  
  public void setCard(Card paramCard)
  {
    card = paramCard;
    onSetCard(paramCard);
    card.setListener(new SignatureWriter(this));
    setCardViewedIndicator(imageSwitcher, getCard());
  }
}

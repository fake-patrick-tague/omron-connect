package com.braze.ui.contentcards.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.b0;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.cards.Card;
import com.braze.ui.R.drawable;
import com.braze.ui.actions.IAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager.Companion;
import com.braze.ui.widget.BaseCardView;
import kotlin.x.d.i;

public abstract class BaseContentCardView<T extends Card>
  extends BaseCardView<T>
{
  public BaseContentCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static final void bindViewHolder$lambda-0(BaseContentCardView paramBaseContentCardView, Card paramCard, UriAction paramUriAction, View paramView)
  {
    i.e(paramBaseContentCardView, "this$0");
    i.e(paramCard, "$card");
    paramBaseContentCardView.handleCardClick(applicationContext, paramCard, paramUriAction);
  }
  
  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, Card paramCard)
  {
    i.e(paramContentCardViewHolder, "viewHolder");
    i.e(paramCard, "card");
    paramContentCardViewHolder.setPinnedIconVisible(paramCard.isPinned());
    boolean bool1 = configurationProvider.isContentCardsUnreadVisualIndicatorEnabled();
    boolean bool2 = true;
    if ((bool1) && (!paramCard.isIndicatorHighlighted())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramContentCardViewHolder.setUnreadBarVisible(bool1);
    UriAction localUriAction = BaseCardView.getUriActionForCard(paramCard);
    itemView.setOnClickListener(new h(this, paramCard, localUriAction));
    if (localUriAction != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramContentCardViewHolder.setActionHintVisible(bool1);
  }
  
  public abstract ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup);
  
  protected boolean isClickHandled(Context paramContext, Card paramCard, IAction paramIAction)
  {
    i.e(paramContext, "context");
    i.e(paramCard, "card");
    IContentCardsActionListener localIContentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
    return (localIContentCardsActionListener != null) && (localIContentCardsActionListener.onContentCardClicked(paramContext, paramCard, paramIAction) == true);
  }
  
  protected final void safeSetClipToOutline(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setClipToOutline(true);
  }
  
  public final void setOptionalCardImage(ImageView paramImageView, float paramFloat, String paramString, Card paramCard)
  {
    i.e(paramCard, "card");
    if ((paramImageView != null) && (paramString != null)) {
      setImageViewToUrl(paramImageView, paramString, paramFloat, paramCard);
    }
  }
  
  protected final void setViewBackground(View paramView)
  {
    i.e(paramView, "view");
    paramView.setBackground(getResources().getDrawable(R.drawable.com_braze_content_card_background));
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setForeground(getResources().getDrawable(R.drawable.com_braze_content_card_scrim));
    }
  }
}

package com.braze.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.braze.models.cards.BannerImageCard;
import com.braze.support.BrazeLogger;
import com.braze.ui.R.drawable;
import com.braze.ui.R.id;
import com.braze.ui.R.layout;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.view.BaseFeedCardView;

public class BannerImageCardView
  extends BaseFeedCardView<BannerImageCard>
{
  private static final String NOTIFICATION_URI = BrazeLogger.getBrazeLogTag(BannerImageCardView.class);
  private float mAspectRatio = 6.0F;
  private IAction mCardAction;
  private final ImageView mImage;
  
  public BannerImageCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BannerImageCardView(Context paramContext, BannerImageCard paramBannerImageCard)
  {
    super(paramContext);
    paramContext = (ImageView)getProperViewFromInflatedStub(R.id.com_braze_banner_image_card_imageview_stub);
    mImage = paramContext;
    paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext.setAdjustViewBounds(true);
    if (paramBannerImageCard != null) {
      setCard(paramBannerImageCard);
    }
    setBackground(getResources().getDrawable(R.drawable.com_braze_card_background));
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_braze_banner_image_card;
  }
  
  public void onSetCard(BannerImageCard paramBannerImageCard)
  {
    if (paramBannerImageCard.getAspectRatio() != 0.0F) {
      mAspectRatio = paramBannerImageCard.getAspectRatio();
    }
    setImageViewToUrl(mImage, paramBannerImageCard.getImageUrl(), mAspectRatio, paramBannerImageCard);
    mCardAction = BaseCardView.getUriActionForCard(paramBannerImageCard);
    setOnClickListener(new d(this, paramBannerImageCard));
  }
}

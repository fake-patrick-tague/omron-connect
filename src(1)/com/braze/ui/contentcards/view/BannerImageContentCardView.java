package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.braze.models.cards.BannerImageCard;
import com.braze.models.cards.Card;
import com.braze.ui.R.id;
import com.braze.ui.R.layout;
import com.braze.ui.widget.BaseCardView;
import kotlin.x.d.i;

public class BannerImageContentCardView
  extends BaseContentCardView<BannerImageCard>
{
  public BannerImageContentCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, Card paramCard)
  {
    i.e(paramContentCardViewHolder, "viewHolder");
    i.e(paramCard, "card");
    if ((paramCard instanceof BannerImageCard))
    {
      super.bindViewHolder(paramContentCardViewHolder, paramCard);
      paramContentCardViewHolder = ((ViewHolder)paramContentCardViewHolder).getImageView();
      BannerImageCard localBannerImageCard = (BannerImageCard)paramCard;
      setOptionalCardImage(paramContentCardViewHolder, localBannerImageCard.getAspectRatio(), localBannerImageCard.getImageUrl(), paramCard);
    }
  }
  
  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    i.e(paramViewGroup, "viewGroup");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_braze_banner_image_content_card, paramViewGroup, false);
    i.d(paramViewGroup, "view");
    setViewBackground(paramViewGroup);
    return new ViewHolder(paramViewGroup);
  }
  
  private final class ViewHolder
    extends ContentCardViewHolder
  {
    private final ImageView imageView;
    
    public ViewHolder(View paramView)
    {
      super(isUnreadIndicatorEnabled());
      imageView = ((ImageView)paramView.findViewById(R.id.com_braze_content_cards_banner_image_card_image));
    }
    
    public final ImageView getImageView()
    {
      return imageView;
    }
  }
}

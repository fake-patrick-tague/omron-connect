package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.b0;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.models.cards.Card;
import com.braze.ui.R.id;
import com.braze.ui.R.layout;
import com.braze.ui.widget.BaseCardView;
import kotlin.text.g;
import kotlin.x.d.i;

public class CaptionedImageContentCardView
  extends BaseContentCardView<CaptionedImageCard>
{
  public CaptionedImageContentCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, Card paramCard)
  {
    i.e(paramContentCardViewHolder, "viewHolder");
    i.e(paramCard, "card");
    if ((paramCard instanceof CaptionedImageCard))
    {
      super.bindViewHolder(paramContentCardViewHolder, paramCard);
      ViewHolder localViewHolder = (ViewHolder)paramContentCardViewHolder;
      Object localObject = localViewHolder.getTitle();
      if (localObject != null) {
        setOptionalTextView((TextView)localObject, ((CaptionedImageCard)paramCard).getTitle());
      }
      localObject = localViewHolder.getDescription();
      if (localObject != null) {
        setOptionalTextView((TextView)localObject, ((CaptionedImageCard)paramCard).getDescription());
      }
      CaptionedImageCard localCaptionedImageCard = (CaptionedImageCard)paramCard;
      localObject = localCaptionedImageCard.getDomain();
      int i;
      if ((localObject != null) && (!g.o((CharSequence)localObject))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        localObject = paramCard.getUrl();
      } else {
        localObject = localCaptionedImageCard.getDomain();
      }
      if (localObject != null) {
        localViewHolder.setActionHintText((String)localObject);
      }
      setOptionalCardImage(localViewHolder.getImageView(), localCaptionedImageCard.getAspectRatio(), localCaptionedImageCard.getImageUrl(), paramCard);
      paramContentCardViewHolder = itemView;
      paramCard = new StringBuilder();
      paramCard.append(localCaptionedImageCard.getTitle());
      paramCard.append(" .  ");
      paramCard.append(localCaptionedImageCard.getDescription());
      paramContentCardViewHolder.setContentDescription(paramCard.toString());
    }
  }
  
  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    i.e(paramViewGroup, "viewGroup");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_braze_captioned_image_content_card, paramViewGroup, false);
    i.d(paramViewGroup, "view");
    setViewBackground(paramViewGroup);
    return new ViewHolder(paramViewGroup);
  }
  
  private final class ViewHolder
    extends ContentCardViewHolder
  {
    private final TextView description;
    private final ImageView imageView;
    private final TextView title;
    
    public ViewHolder(View paramView)
    {
      super(isUnreadIndicatorEnabled());
      title = ((TextView)paramView.findViewById(R.id.com_braze_content_cards_captioned_image_title));
      description = ((TextView)paramView.findViewById(R.id.com_braze_content_cards_captioned_image_description));
      imageView = ((ImageView)paramView.findViewById(R.id.com_braze_content_cards_captioned_image_card_image));
    }
    
    public final TextView getDescription()
    {
      return description;
    }
    
    public final ImageView getImageView()
    {
      return imageView;
    }
    
    public final TextView getTitle()
    {
      return title;
    }
  }
}

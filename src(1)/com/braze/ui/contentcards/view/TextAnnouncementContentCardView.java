package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.b0;
import com.braze.models.cards.Card;
import com.braze.models.cards.TextAnnouncementCard;
import com.braze.ui.R.id;
import com.braze.ui.R.layout;
import com.braze.ui.widget.BaseCardView;
import kotlin.text.g;
import kotlin.x.d.i;

public class TextAnnouncementContentCardView
  extends BaseContentCardView<TextAnnouncementCard>
{
  public TextAnnouncementContentCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, Card paramCard)
  {
    i.e(paramContentCardViewHolder, "viewHolder");
    i.e(paramCard, "card");
    if ((paramCard instanceof TextAnnouncementCard))
    {
      super.bindViewHolder(paramContentCardViewHolder, paramCard);
      ViewHolder localViewHolder = (ViewHolder)paramContentCardViewHolder;
      Object localObject = localViewHolder.getTitle();
      if (localObject != null) {
        setOptionalTextView((TextView)localObject, ((TextAnnouncementCard)paramCard).getTitle());
      }
      localObject = localViewHolder.getDescription();
      if (localObject != null) {
        setOptionalTextView((TextView)localObject, ((TextAnnouncementCard)paramCard).getDescription());
      }
      localObject = (TextAnnouncementCard)paramCard;
      String str = ((TextAnnouncementCard)localObject).getDomain();
      int i;
      if ((str != null) && (!g.o(str))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        paramCard = paramCard.getUrl();
      } else {
        paramCard = ((TextAnnouncementCard)localObject).getDomain();
      }
      if (paramCard != null) {
        localViewHolder.setActionHintText(paramCard);
      }
      paramContentCardViewHolder = itemView;
      paramCard = new StringBuilder();
      paramCard.append(((TextAnnouncementCard)localObject).getTitle());
      paramCard.append(" . ");
      paramCard.append(((TextAnnouncementCard)localObject).getDescription());
      paramContentCardViewHolder.setContentDescription(paramCard.toString());
    }
  }
  
  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    i.e(paramViewGroup, "viewGroup");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_braze_text_announcement_content_card, paramViewGroup, false);
    i.d(paramViewGroup, "view");
    setViewBackground(paramViewGroup);
    return new ViewHolder(paramViewGroup);
  }
  
  private final class ViewHolder
    extends ContentCardViewHolder
  {
    private final TextView description;
    private final TextView title;
    
    public ViewHolder(View paramView)
    {
      super(isUnreadIndicatorEnabled());
      title = ((TextView)paramView.findViewById(R.id.com_braze_content_cards_text_announcement_card_title));
      description = ((TextView)paramView.findViewById(R.id.com_braze_content_cards_text_announcement_card_description));
    }
    
    public final TextView getDescription()
    {
      return description;
    }
    
    public final TextView getTitle()
    {
      return title;
    }
  }
}

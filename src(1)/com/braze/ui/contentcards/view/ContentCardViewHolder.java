package com.braze.ui.contentcards.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.b0;
import com.braze.ui.R.drawable;
import com.braze.ui.R.id;
import kotlin.x.d.i;

public class ContentCardViewHolder
  extends RecyclerView.b0
{
  private final TextView actionHint;
  private final ImageView pinnedIcon;
  private final View unreadBar;
  
  public ContentCardViewHolder(View paramView, boolean paramBoolean)
  {
    super(paramView);
    View localView = paramView.findViewById(R.id.com_braze_content_cards_unread_bar);
    unreadBar = localView;
    pinnedIcon = ((ImageView)paramView.findViewById(R.id.com_braze_content_cards_pinned_icon));
    actionHint = ((TextView)paramView.findViewById(R.id.com_braze_content_cards_action_hint));
    if (paramBoolean)
    {
      if (localView != null) {
        localView.setVisibility(0);
      }
      if (localView == null) {
        return;
      }
      localView.setBackground(paramView.getContext().getResources().getDrawable(R.drawable.com_braze_content_cards_unread_bar_background));
      return;
    }
    if (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  public final void setActionHintText(String paramString)
  {
    i.e(paramString, "text");
    TextView localTextView = actionHint;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
  }
  
  public final void setActionHintVisible(boolean paramBoolean)
  {
    TextView localTextView = actionHint;
    if (localTextView == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public final void setPinnedIconVisible(boolean paramBoolean)
  {
    ImageView localImageView = pinnedIcon;
    if (localImageView == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public final void setUnreadBarVisible(boolean paramBoolean)
  {
    View localView = unreadBar;
    if (localView == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
}

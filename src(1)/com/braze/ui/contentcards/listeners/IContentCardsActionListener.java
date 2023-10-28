package com.braze.ui.contentcards.listeners;

import android.content.Context;
import com.braze.models.cards.Card;
import com.braze.ui.actions.IAction;

public abstract interface IContentCardsActionListener
{
  public abstract boolean onContentCardClicked(Context paramContext, Card paramCard, IAction paramIAction);
  
  public abstract void onContentCardDismissed(Context paramContext, Card paramCard);
}

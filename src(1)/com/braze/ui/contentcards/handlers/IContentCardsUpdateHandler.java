package com.braze.ui.contentcards.handlers;

import android.os.Parcelable;
import com.braze.events.ContentCardsUpdatedEvent;
import java.util.List;

public abstract interface IContentCardsUpdateHandler
  extends Parcelable
{
  public abstract List handleCardUpdate(ContentCardsUpdatedEvent paramContentCardsUpdatedEvent);
}

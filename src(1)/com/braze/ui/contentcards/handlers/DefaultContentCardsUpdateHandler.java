package com.braze.ui.contentcards.handlers;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.models.cards.Card;
import com.braze.ui.actions.brazeactions.BrazeActionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DefaultContentCardsUpdateHandler
  implements IContentCardsUpdateHandler
{
  public static final Parcelable.Creator<DefaultContentCardsUpdateHandler> CREATOR = new DefaultContentCardsUpdateHandler.Companion.CREATOR.1();
  public static final Companion Companion = new Companion(null);
  
  public DefaultContentCardsUpdateHandler() {}
  
  private static final int handleCardUpdate$lambda-0(Card paramCard1, Card paramCard2)
  {
    kotlin.x.d.i.e(paramCard1, "cardA");
    kotlin.x.d.i.e(paramCard2, "cardB");
    if ((paramCard1.isPinned()) && (!paramCard2.isPinned())) {}
    do
    {
      return -1;
      if ((!paramCard1.isPinned()) && (paramCard2.isPinned())) {
        return 1;
      }
    } while (paramCard1.getCreated() > paramCard2.getCreated());
    if (paramCard1.getCreated() < paramCard2.getCreated()) {
      return 1;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List handleCardUpdate(ContentCardsUpdatedEvent paramContentCardsUpdatedEvent)
  {
    kotlin.x.d.i.e(paramContentCardsUpdatedEvent, "event");
    c localC = c.d;
    Object localObject1 = paramContentCardsUpdatedEvent.getAllCards();
    paramContentCardsUpdatedEvent = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((BrazeActionUtils.containsInvalidBrazeAction((Card)localObject2) ^ true)) {
        paramContentCardsUpdatedEvent.add(localObject2);
      }
    }
    return kotlin.collections.i.D(paramContentCardsUpdatedEvent, localC);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kotlin.x.d.i.e(paramParcel, "dest");
  }
  
  public static final class Companion
  {
    private Companion() {}
  }
}

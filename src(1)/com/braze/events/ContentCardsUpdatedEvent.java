package com.braze.events;

import com.braze.models.cards.Card;
import com.braze.support.DateTimeUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.i;

public final class ContentCardsUpdatedEvent
{
  public static final Companion Companion = new Companion(null);
  private final List<Card> contentCards;
  private final boolean isFromOfflineStorage;
  private final long timestampSeconds;
  private final String userId;
  
  public ContentCardsUpdatedEvent(List paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    contentCards = paramList;
    userId = paramString;
    timestampSeconds = paramLong;
    isFromOfflineStorage = paramBoolean;
  }
  
  public final List getAllCards()
  {
    return i.I(contentCards);
  }
  
  public final int getCardCount()
  {
    return contentCards.size();
  }
  
  public final boolean isFromOfflineStorage()
  {
    return isFromOfflineStorage;
  }
  
  public final boolean isTimestampOlderThan(long paramLong)
  {
    return TimeUnit.SECONDS.toMillis(timestampSeconds + paramLong) < System.currentTimeMillis();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ContentCardsUpdatedEvent{userId='");
    localStringBuilder.append(userId);
    localStringBuilder.append("', timestampSeconds=");
    localStringBuilder.append(timestampSeconds);
    localStringBuilder.append(", isFromOfflineStorage=");
    localStringBuilder.append(isFromOfflineStorage);
    localStringBuilder.append(", card count=");
    localStringBuilder.append(getCardCount());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final ContentCardsUpdatedEvent getEmptyUpdate()
    {
      return new ContentCardsUpdatedEvent(i.d(), null, DateTimeUtils.nowInSeconds(), true);
    }
  }
}

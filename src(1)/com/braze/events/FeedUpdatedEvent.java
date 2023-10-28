package com.braze.events;

import com.braze.enums.CardCategory;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public final class FeedUpdatedEvent
{
  private static final String Q = BrazeLogger.getBrazeLogTag(FeedUpdatedEvent.class);
  private final List<Card> mFeedCards;
  private final boolean mFromOfflineStorage;
  private final long mTimestamp;
  private final String mUserId;
  
  public FeedUpdatedEvent(List paramList, String paramString, boolean paramBoolean, long paramLong)
  {
    mUserId = paramString;
    mFromOfflineStorage = paramBoolean;
    paramList.getClass();
    mFeedCards = paramList;
    mTimestamp = paramLong;
  }
  
  public int getCardCount(EnumSet paramEnumSet)
  {
    if (paramEnumSet == null)
    {
      BrazeLogger.add(Q, "The categories passed into getCardCount are null, FeedUpdatedEvent is going to return the count of all the cards in cache.");
      return mFeedCards.size();
    }
    if (paramEnumSet.isEmpty())
    {
      BrazeLogger.a(Q, "The parameters passed into categories are not valid, Braze is returning 0 in getCardCount().Please pass in a non-empty EnumSet of CardCategory.");
      return 0;
    }
    return getFeedCards(paramEnumSet).size();
  }
  
  public List getFeedCards(EnumSet paramEnumSet)
  {
    Object localObject1 = paramEnumSet;
    Object localObject2;
    if (paramEnumSet == null)
    {
      localObject1 = Q;
      localObject2 = paramEnumSet;
    }
    try
    {
      BrazeLogger.add((String)localObject1, "The categories passed to getFeedCards are null, FeedUpdatedEvent is going to return all the cards in cache.");
      localObject2 = paramEnumSet;
      localObject1 = CardCategory.getAllCategories();
      localObject2 = localObject1;
      boolean bool = ((EnumSet)localObject1).isEmpty();
      if (bool)
      {
        paramEnumSet = Q;
        localObject2 = localObject1;
        BrazeLogger.a(paramEnumSet, "The parameter passed into categories is not valid, Braze is returning an empty card list.Please pass in a non-empty EnumSet of CardCategory for getFeedCards().");
        localObject2 = localObject1;
        paramEnumSet = new ArrayList();
        return paramEnumSet;
      }
      localObject2 = localObject1;
      paramEnumSet = new ArrayList();
      localObject3 = mFeedCards;
      localObject2 = localObject1;
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        bool = ((Iterator)localObject3).hasNext();
        if (!bool) {
          break;
        }
        localObject2 = localObject1;
        Object localObject4 = ((Iterator)localObject3).next();
        localObject4 = (Card)localObject4;
        localObject2 = localObject1;
        bool = ((Card)localObject4).isInCategorySet((EnumSet)localObject1);
        if (bool)
        {
          localObject2 = localObject1;
          bool = ((Card)localObject4).isExpired();
          if (!bool)
          {
            localObject2 = localObject1;
            paramEnumSet.add(localObject4);
          }
        }
      }
      return paramEnumSet;
    }
    catch (Exception paramEnumSet)
    {
      localObject1 = Q;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Unable to get cards with categories[");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append("]. Ignoring.");
      BrazeLogger.warn((String)localObject1, ((StringBuilder)localObject3).toString(), paramEnumSet);
    }
    return null;
  }
  
  public int getUnreadCardCount(EnumSet paramEnumSet)
  {
    if (paramEnumSet == null)
    {
      BrazeLogger.a(Q, "The categories passed to getUnreadCardCount are null, FeedUpdatedEvent is going to return the count of all the unread cards in cache.");
      return getUnreadCardCount(CardCategory.getAllCategories());
    }
    boolean bool = paramEnumSet.isEmpty();
    int i = 0;
    if (bool)
    {
      BrazeLogger.a(Q, "The parameters passed into categories are Empty, Braze is returning 0 in getUnreadCardCount().Please pass in a non-empty EnumSet of CardCategory.");
      return 0;
    }
    Iterator localIterator = mFeedCards.iterator();
    while (localIterator.hasNext())
    {
      Card localCard = (Card)localIterator.next();
      if ((localCard.isInCategorySet(paramEnumSet)) && (!localCard.getViewed()) && (!localCard.isExpired())) {
        i += 1;
      }
    }
    return i;
  }
  
  public boolean isFromOfflineStorage()
  {
    return mFromOfflineStorage;
  }
  
  public long lastUpdatedInSecondsFromEpoch()
  {
    return mTimestamp;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FeedUpdatedEvent{");
    localStringBuilder.append("mFeedCards=");
    localStringBuilder.append(mFeedCards);
    localStringBuilder.append(", mUserId='");
    localStringBuilder.append(mUserId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFromOfflineStorage=");
    localStringBuilder.append(mFromOfflineStorage);
    localStringBuilder.append(", mTimestamp=");
    localStringBuilder.append(mTimestamp);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

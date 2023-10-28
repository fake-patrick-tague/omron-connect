package com.braze.ui.contentcards.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ClassVisitor;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.Plot;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.d;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager.Companion;
import com.braze.ui.contentcards.recycler.ItemTouchHelperAdapter;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.x.c.a;
import kotlin.x.d.j;

public class ContentCardAdapter
  extends RecyclerView.Adapter<ContentCardViewHolder>
  implements ItemTouchHelperAdapter
{
  private final List<Card> cardData;
  private final IContentCardsViewBindingHandler contentCardsViewBindingHandler;
  private final Context context;
  private final Handler handler;
  private Set<String> impressedCardIdsInternal;
  private final LinearLayoutManager layoutManager;
  
  public ContentCardAdapter(Context paramContext, LinearLayoutManager paramLinearLayoutManager, List paramList, IContentCardsViewBindingHandler paramIContentCardsViewBindingHandler)
  {
    context = paramContext;
    layoutManager = paramLinearLayoutManager;
    cardData = paramList;
    contentCardsViewBindingHandler = paramIContentCardsViewBindingHandler;
    handler = new Handler(Looper.getMainLooper());
    impressedCardIdsInternal = new LinkedHashSet();
    setHasStableIds(true);
  }
  
  private final boolean isInvalidIndex(int paramInt)
  {
    return (paramInt < 0) || (paramInt >= cardData.size());
  }
  
  private static final void markOnScreenCardsAsRead$lambda-1(int paramInt1, int paramInt2, ContentCardAdapter paramContentCardAdapter)
  {
    kotlin.x.d.i.e(paramContentCardAdapter, "this$0");
    paramContentCardAdapter.notifyItemRangeChanged(paramInt2, paramInt1 - paramInt2 + 1);
  }
  
  private static final void onViewDetachedFromWindow$lambda-0(ContentCardAdapter paramContentCardAdapter, int paramInt)
  {
    kotlin.x.d.i.e(paramContentCardAdapter, "this$0");
    paramContentCardAdapter.notifyItemChanged(paramInt);
  }
  
  public final Card getCardAtIndex(int paramInt)
  {
    if (isInvalidIndex(paramInt))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(paramInt)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot return card at index: ");
          localStringBuilder.append($index);
          localStringBuilder.append(" in cards list of size: ");
          localStringBuilder.append(ContentCardAdapter.access$getCardData$p(jdField_this).size());
          return localStringBuilder.toString();
        }
      }, 3, null);
      return null;
    }
    return (Card)cardData.get(paramInt);
  }
  
  public final List getImpressedCardIds()
  {
    return kotlin.collections.i.G(impressedCardIdsInternal);
  }
  
  public int getItemCount()
  {
    return cardData.size();
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getCardAtIndex(paramInt);
    if (localObject != null)
    {
      localObject = ((Card)localObject).getId();
      if (localObject != null) {
        return ((String)localObject).hashCode();
      }
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return contentCardsViewBindingHandler.getItemViewType(context, cardData, paramInt);
  }
  
  public final boolean isAdapterPositionOnScreen(int paramInt)
  {
    int i = Math.min(layoutManager.getValue(), layoutManager.findFirstVisibleItemPosition());
    int j = Math.max(layoutManager.getPosition(), layoutManager.findFirstCompletelyVisibleItemPosition());
    return (i <= paramInt) && (paramInt <= j);
  }
  
  public final boolean isControlCardAtPosition(int paramInt)
  {
    Card localCard = getCardAtIndex(paramInt);
    return (localCard != null) && (localCard.isControl());
  }
  
  public boolean isItemDismissable(int paramInt)
  {
    if ((!cardData.isEmpty()) && (!isInvalidIndex(paramInt))) {
      return ((Card)cardData.get(paramInt)).isDismissibleByUser();
    }
    return false;
  }
  
  public final void logImpression(Card paramCard)
  {
    if (paramCard == null) {
      return;
    }
    if (!impressedCardIdsInternal.contains(paramCard.getId()))
    {
      paramCard.logImpression();
      impressedCardIdsInternal.add(paramCard.getId());
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramCard)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Logged impression for card ");
          localStringBuilder.append(getId());
          return localStringBuilder.toString();
        }
      }, 2, null);
    }
    else
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramCard)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Already counted impression for card ");
          localStringBuilder.append(getId());
          return localStringBuilder.toString();
        }
      }, 2, null);
    }
    if (!paramCard.getViewed()) {
      paramCard.setViewed(true);
    }
  }
  
  public final void markOnScreenCardsAsRead()
  {
    if (cardData.isEmpty())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, markOnScreenCardsAsRead.1.INSTANCE, 3, null);
      return;
    }
    int j = layoutManager.getValue();
    final int k = layoutManager.getPosition();
    if ((j >= 0) && (k >= 0))
    {
      if (j <= k)
      {
        int i = j;
        for (;;)
        {
          Card localCard = getCardAtIndex(i);
          if (localCard != null) {
            localCard.setIndicatorHighlighted(true);
          }
          if (i == k) {
            break;
          }
          i += 1;
        }
      }
      handler.post(new NumberPicker.PressedStateHelper(k, j, this));
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(j)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Not marking all on-screen cards as read. Either the first or last index is negative. First visible: ");
        localStringBuilder.append($firstVisibleIndex);
        localStringBuilder.append(" . Last visible: ");
        localStringBuilder.append(k);
        return localStringBuilder.toString();
      }
    }, 3, null);
  }
  
  public void onBindViewHolder(ContentCardViewHolder paramContentCardViewHolder, int paramInt)
  {
    kotlin.x.d.i.e(paramContentCardViewHolder, "viewHolder");
    contentCardsViewBindingHandler.onBindViewHolder(context, cardData, paramContentCardViewHolder, paramInt);
  }
  
  public ContentCardViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    kotlin.x.d.i.e(paramViewGroup, "viewGroup");
    return contentCardsViewBindingHandler.onCreateViewHolder(context, cardData, paramViewGroup, paramInt);
  }
  
  public void onItemDismiss(int paramInt)
  {
    if (isInvalidIndex(paramInt))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(paramInt)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot dismiss card at index: ");
          localStringBuilder.append($position);
          localStringBuilder.append(" in cards list of size: ");
          localStringBuilder.append(ContentCardAdapter.access$getCardData$p(jdField_this).size());
          return localStringBuilder.toString();
        }
      }, 3, null);
      return;
    }
    Card localCard = (Card)cardData.remove(paramInt);
    localCard.setDismissed(true);
    notifyItemRemoved(paramInt);
    IContentCardsActionListener localIContentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
    if (localIContentCardsActionListener != null) {
      localIContentCardsActionListener.onContentCardDismissed(context, localCard);
    }
  }
  
  public void onViewAttachedToWindow(ContentCardViewHolder paramContentCardViewHolder)
  {
    kotlin.x.d.i.e(paramContentCardViewHolder, "holder");
    super.onViewAttachedToWindow(paramContentCardViewHolder);
    if (cardData.isEmpty()) {
      return;
    }
    int i = paramContentCardViewHolder.getBindingAdapterPosition();
    if ((i != -1) && (isAdapterPositionOnScreen(i)))
    {
      logImpression(getCardAtIndex(i));
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(i)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("The card at position ");
        localStringBuilder.append($adapterPosition);
        localStringBuilder.append(" isn't on screen or does not have a valid adapter position. Not logging impression.");
        return localStringBuilder.toString();
      }
    }, 2, null);
  }
  
  public void onViewDetachedFromWindow(ContentCardViewHolder paramContentCardViewHolder)
  {
    kotlin.x.d.i.e(paramContentCardViewHolder, "holder");
    super.onViewDetachedFromWindow(paramContentCardViewHolder);
    if (cardData.isEmpty()) {
      return;
    }
    int i = paramContentCardViewHolder.getBindingAdapterPosition();
    if ((i != -1) && (isAdapterPositionOnScreen(i)))
    {
      paramContentCardViewHolder = getCardAtIndex(i);
      if (paramContentCardViewHolder == null) {
        return;
      }
      if (!paramContentCardViewHolder.isIndicatorHighlighted())
      {
        paramContentCardViewHolder.setIndicatorHighlighted(true);
        handler.post(new NumberPicker.BeginSoftInputOnLongPressCommand(this, i));
      }
    }
    else
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(i)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("The card at position ");
          localStringBuilder.append($adapterPosition);
          localStringBuilder.append(" isn't on screen or does not have a valid adapter position. Not marking as read.");
          return localStringBuilder.toString();
        }
      }, 2, null);
    }
  }
  
  public final void replaceCards(List paramList)
  {
    try
    {
      kotlin.x.d.i.e(paramList, "newCardData");
      d localD = Plot.a(new CardListDiffCallback(cardData, paramList));
      kotlin.x.d.i.d(localD, "calculateDiff(diffCallback)");
      cardData.clear();
      cardData.addAll(paramList);
      localD.b(this);
      return;
    }
    catch (Throwable paramList)
    {
      throw paramList;
    }
  }
  
  public final void setImpressedCardIds(List paramList)
  {
    kotlin.x.d.i.e(paramList, "impressedCardIds");
    impressedCardIdsInternal = kotlin.collections.i.J(paramList);
  }
  
  private static final class CardListDiffCallback
    extends ClassVisitor
  {
    private final List<Card> newCards;
    private final List<Card> oldCards;
    
    public CardListDiffCallback(List paramList1, List paramList2)
    {
      oldCards = paramList1;
      newCards = paramList2;
    }
    
    private final boolean doItemsShareIds(int paramInt1, int paramInt2)
    {
      return kotlin.x.d.i.a(((Card)oldCards.get(paramInt1)).getId(), ((Card)newCards.get(paramInt2)).getId());
    }
    
    public boolean areContentsTheSame(int paramInt1, int paramInt2)
    {
      return doItemsShareIds(paramInt1, paramInt2);
    }
    
    public boolean areItemsTheSame(int paramInt1, int paramInt2)
    {
      return doItemsShareIds(paramInt1, paramInt2);
    }
    
    public int getNewListSize()
    {
      return newCards.size();
    }
    
    public int getOldListSize()
    {
      return oldCards.size();
    }
  }
}

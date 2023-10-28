package com.braze.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.braze.models.cards.BannerImageCard;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.models.cards.Card;
import com.braze.models.cards.ShortNewsCard;
import com.braze.models.cards.TextAnnouncementCard;
import com.braze.support.BrazeLogger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrazeListAdapter
  extends ArrayAdapter<Card>
{
  private static final String DEBUG_TAG = BrazeLogger.getBrazeLogTag(BrazeListAdapter.class);
  private final Set<String> mCardIdImpressions;
  private final Context mContext;
  
  public BrazeListAdapter(Context paramContext, int paramInt, List paramList)
  {
    super(paramContext, paramInt, paramList);
    mContext = paramContext;
    mCardIdImpressions = new HashSet();
  }
  
  private void logCardImpression(Card paramCard)
  {
    String str1 = paramCard.getId();
    String str2;
    StringBuilder localStringBuilder;
    if (!mCardIdImpressions.contains(str1))
    {
      mCardIdImpressions.add(str1);
      paramCard.logImpression();
      str2 = DEBUG_TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Logged impression for card ");
      localStringBuilder.append(str1);
      BrazeLogger.e(str2, localStringBuilder.toString());
    }
    else
    {
      str2 = DEBUG_TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Already counted impression for card ");
      localStringBuilder.append(str1);
      BrazeLogger.e(str2, localStringBuilder.toString());
    }
    if (!paramCard.getViewed()) {
      paramCard.setViewed(true);
    }
  }
  
  public void batchSetCardsToRead(int paramInt1, int paramInt2)
  {
    if (getCount() == 0)
    {
      BrazeLogger.d(DEBUG_TAG, "mAdapter is empty in setting some cards to viewed.");
      return;
    }
    paramInt1 = Math.max(0, paramInt1);
    paramInt2 = Math.min(getCount(), paramInt2);
    while (paramInt1 < paramInt2)
    {
      Card localCard = (Card)getItem(paramInt1);
      if (localCard == null)
      {
        BrazeLogger.d(DEBUG_TAG, "Card was null in setting some cards to viewed.");
        return;
      }
      if (!localCard.isIndicatorHighlighted()) {
        localCard.setIndicatorHighlighted(true);
      }
      paramInt1 += 1;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Card localCard = (Card)getItem(paramInt);
    if ((localCard instanceof BannerImageCard)) {
      return 1;
    }
    if ((localCard instanceof CaptionedImageCard)) {
      return 2;
    }
    if ((localCard instanceof ShortNewsCard)) {
      return 3;
    }
    if ((localCard instanceof TextAnnouncementCard)) {
      return 4;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void insert(Card paramCard)
  {
    try
    {
      super.add(paramCard);
      return;
    }
    catch (Throwable paramCard)
    {
      throw paramCard;
    }
  }
  
  public void replaceFeed(List paramList)
  {
    int j = 0;
    try
    {
      setNotifyOnChange(false);
      if (paramList == null)
      {
        clear();
        notifyDataSetChanged();
        return;
      }
      Object localObject1 = DEBUG_TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Replacing existing feed of ");
      ((StringBuilder)localObject2).append(getCount());
      ((StringBuilder)localObject2).append(" cards with new feed containing ");
      ((StringBuilder)localObject2).append(paramList.size());
      ((StringBuilder)localObject2).append(" cards.");
      BrazeLogger.d((String)localObject1, ((StringBuilder)localObject2).toString());
      int k = paramList.size();
      int i = 0;
      while (j < getCount())
      {
        localObject2 = (Card)getItem(j);
        localObject1 = null;
        if (i < k) {
          localObject1 = (Card)paramList.get(i);
        }
        if ((localObject1 != null) && (((Card)localObject1).equals(localObject2)))
        {
          j += 1;
          i += 1;
        }
        else
        {
          remove(localObject2);
        }
      }
      super.addAll(paramList.subList(i, k));
      notifyDataSetChanged();
      return;
    }
    catch (Throwable paramList)
    {
      throw paramList;
    }
  }
  
  public void resetCardImpressionTracker()
  {
    mCardIdImpressions.clear();
  }
}

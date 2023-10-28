package com.braze.ui.contentcards.handlers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.ViewGroup;
import com.braze.enums.CardType;
import com.braze.enums.CardType.Companion;
import com.braze.models.cards.Card;
import com.braze.ui.contentcards.view.BaseContentCardView;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.x.d.i;

public class DefaultContentCardsViewBindingHandler
  implements IContentCardsViewBindingHandler
{
  public static final Parcelable.Creator<DefaultContentCardsViewBindingHandler> CREATOR = new DefaultContentCardsViewBindingHandler.Companion.CREATOR.1();
  public static final Companion Companion = new Companion(null);
  private final Map<CardType, BaseContentCardView<?>> contentCardViewCache = new LinkedHashMap();
  
  public DefaultContentCardsViewBindingHandler() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public final BaseContentCardView getContentCardsViewFromCache(Context paramContext, CardType paramCardType)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public int getItemViewType(Context paramContext, List paramList, int paramInt)
  {
    i.e(paramContext, "context");
    i.e(paramList, "cards");
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return ((Card)paramList.get(paramInt)).getCardType().getValue();
    }
    return -1;
  }
  
  public void onBindViewHolder(Context paramContext, List paramList, ContentCardViewHolder paramContentCardViewHolder, int paramInt)
  {
    i.e(paramContext, "context");
    i.e(paramList, "cards");
    i.e(paramContentCardViewHolder, "viewHolder");
    if (paramInt >= 0)
    {
      if (paramInt >= paramList.size()) {
        return;
      }
      paramList = (Card)paramList.get(paramInt);
      getContentCardsViewFromCache(paramContext, paramList.getCardType()).bindViewHolder(paramContentCardViewHolder, paramList);
    }
  }
  
  public ContentCardViewHolder onCreateViewHolder(Context paramContext, List paramList, ViewGroup paramViewGroup, int paramInt)
  {
    i.e(paramContext, "context");
    i.e(paramList, "cards");
    i.e(paramViewGroup, "viewGroup");
    return getContentCardsViewFromCache(paramContext, CardType.Companion.fromValue(paramInt)).createViewHolder(paramViewGroup);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.e(paramParcel, "dest");
  }
  
  public static final class Companion
  {
    private Companion() {}
  }
}

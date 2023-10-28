package com.braze.ui.widget;

import android.content.Context;
import android.os.BaseBundle;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import com.braze.ui.R.drawable;
import com.braze.ui.R.string;
import com.braze.ui.actions.IAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.feed.BrazeImageSwitcher;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public abstract class BaseCardView<T extends Card>
  extends RelativeLayout
{
  public static final Companion Companion = new Companion(null);
  protected final Context applicationContext;
  protected T card;
  private final String classLogTag;
  protected BrazeConfigurationProvider configurationProvider;
  public BrazeImageSwitcher imageSwitcher;
  private final boolean isUnreadCardVisualIndicatorEnabled;
  
  public BaseCardView(Context paramContext)
  {
    super(paramContext);
    Context localContext = paramContext.getApplicationContext();
    i.d(localContext, "context.applicationContext");
    applicationContext = localContext;
    classLogTag = BrazeLogger.getBrazeLogTag(getClass());
    paramContext = new BrazeConfigurationProvider(paramContext);
    configurationProvider = paramContext;
    isUnreadCardVisualIndicatorEnabled = paramContext.isNewsfeedVisualIndicatorOn();
  }
  
  protected static final UriAction getUriActionForCard(Card paramCard)
  {
    return Companion.getUriActionForCard(paramCard);
  }
  
  public final String getClassLogTag()
  {
    return classLogTag;
  }
  
  protected final void handleCardClick(Context paramContext, Card paramCard, IAction paramIAction)
  {
    i.e(paramContext, "context");
    i.e(paramCard, "card");
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.Priority localPriority = BrazeLogger.Priority.$EnumSwitchMapping$0;
    BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, new j(paramCard)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Handling card click for card: ");
        localStringBuilder.append(BaseCardView.this);
        return localStringBuilder.toString();
      }
    }, 2, null);
    paramCard.setIndicatorHighlighted(true);
    if (!isClickHandled(paramContext, paramCard, paramIAction))
    {
      if (paramIAction != null)
      {
        paramCard.logClick();
        BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, new j(paramCard)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Card action is non-null. Attempting to perform action on card: ");
            localStringBuilder.append(getId());
            return localStringBuilder.toString();
          }
        }, 2, null);
        if ((paramIAction instanceof UriAction))
        {
          BrazeDeeplinkHandler.Companion.getInstance().gotoUri(paramContext, (UriAction)paramIAction);
          return;
        }
        BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, new j(paramCard)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Executing non uri action for click on card: ");
            localStringBuilder.append(getId());
            return localStringBuilder.toString();
          }
        }, 3, null);
        paramIAction.execute(paramContext);
        return;
      }
      BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, new j(paramCard)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Card action is null. Not performing any click action on card: ");
          localStringBuilder.append(getId());
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, new j(paramCard)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Card click was handled by custom listener on card: ");
        localStringBuilder.append(getId());
        return localStringBuilder.toString();
      }
    }, 3, null);
    paramCard.logClick();
  }
  
  protected abstract boolean isClickHandled(Context paramContext, Card paramCard, IAction paramIAction);
  
  public final boolean isUnreadIndicatorEnabled()
  {
    return isUnreadCardVisualIndicatorEnabled;
  }
  
  public final void setCardViewedIndicator(BrazeImageSwitcher paramBrazeImageSwitcher, Card paramCard)
  {
    i.e(paramCard, "card");
    if (paramBrazeImageSwitcher == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, setCardViewedIndicator.1.INSTANCE, 2, null);
      return;
    }
    int i = R.string.com_braze_image_is_read_tag_key;
    Object localObject2 = paramBrazeImageSwitcher.getTag(i);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (paramCard.isIndicatorHighlighted())
    {
      if (!i.a(localObject1, "icon_read"))
      {
        if (paramBrazeImageSwitcher.getReadIcon() != null) {
          paramBrazeImageSwitcher.setImageDrawable(paramBrazeImageSwitcher.getReadIcon());
        } else {
          paramBrazeImageSwitcher.setImageResource(R.drawable.com_braze_content_card_icon_read);
        }
        paramBrazeImageSwitcher.setTag(i, "icon_read");
      }
    }
    else if (!i.a(localObject1, "icon_unread"))
    {
      if (paramBrazeImageSwitcher.getUnReadIcon() != null) {
        paramBrazeImageSwitcher.setImageDrawable(paramBrazeImageSwitcher.getUnReadIcon());
      } else {
        paramBrazeImageSwitcher.setImageResource(R.drawable.com_braze_content_card_icon_unread);
      }
      paramBrazeImageSwitcher.setTag(i, "icon_unread");
    }
  }
  
  public final void setImageViewToUrl(ImageView paramImageView, String paramString, final float paramFloat, Card paramCard)
  {
    i.e(paramImageView, "imageView");
    i.e(paramString, "imageUrl");
    i.e(paramCard, "card");
    int j = R.string.com_braze_image_resize_tag_key;
    if (!i.a(paramString, paramImageView.getTag(j)))
    {
      int i;
      if (paramFloat == 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        localObject = paramImageView.getViewTreeObserver();
        if (((ViewTreeObserver)localObject).isAlive()) {
          ((ViewTreeObserver)localObject).addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public boolean onPreDraw()
            {
              getViewTreeObserver().removeOnPreDrawListener(this);
              int i = getWidth();
              setLayoutParams(new RelativeLayout.LayoutParams(i, (int)(i / paramFloat)));
              return true;
            }
          });
        }
      }
      paramImageView.setImageResource(17170445);
      Object localObject = Braze.Companion;
      Context localContext = getContext();
      i.d(localContext, "context");
      localObject = ((Braze.Companion)localObject).getInstance(localContext).getImageLoader();
      localContext = getContext();
      i.d(localContext, "context");
      ((IBrazeImageLoader)localObject).renderUrlIntoCardView(localContext, paramCard, paramString, paramImageView, BrazeViewBounds.BASE_CARD_VIEW);
      paramImageView.setTag(j, paramString);
    }
  }
  
  public final void setOptionalTextView(TextView paramTextView, String paramString)
  {
    i.e(paramTextView, "view");
    int i;
    if ((paramString != null) && (!g.o(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setText("");
    paramTextView.setVisibility(8);
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    protected final UriAction getUriActionForCard(Card paramCard)
    {
      i.e(paramCard, "card");
      Bundle localBundle = new Bundle();
      Object localObject = paramCard.getExtras().keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localBundle.putString(str, (String)paramCard.getExtras().get(str));
      }
      localObject = paramCard.getUrl();
      if (localObject == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, getUriActionForCard.1.INSTANCE, 2, null);
        return null;
      }
      return BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString((String)localObject, localBundle, paramCard.getOpenUriInWebView(), paramCard.getChannel());
    }
  }
}

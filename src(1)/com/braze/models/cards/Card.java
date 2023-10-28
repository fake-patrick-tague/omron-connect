package com.braze.models.cards;

import com.braze.enums.CardCategory;
import com.braze.enums.CardKey;
import com.braze.enums.CardKey.Provider;
import com.braze.enums.CardType;
import com.braze.enums.Channel;
import com.braze.models.IPutIntoJson;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.a0.f;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.c.l;
import kotlin.x.d.j;
import kotlin.z.d;
import org.json.JSONArray;
import org.json.JSONObject;
import protect.package_9.Paint;
import protect.package_9.p;

public class Card
  implements IPutIntoJson<JSONObject>
{
  public static final a Companion = new a(null);
  private final String _id;
  private final protect.package_9.c brazeManager;
  private final Paint cardAnalytics;
  private final ICardStorageProvider<?> cardStorage;
  private final CardType cardType;
  private EnumSet<CardCategory> categories;
  private final Channel channel;
  private final long created;
  private final long expiresAt;
  private final Map<String, String> extras;
  private boolean isClicked;
  private final boolean isContentCard;
  private boolean isDismissedInternal;
  private boolean isDismissibleByUser;
  private boolean isIndicatorHighlightedInternal;
  private boolean isPinned;
  private final boolean isRemoved;
  private boolean isTest;
  private final JSONObject jsonObject;
  private ICardListener listener;
  private final String mUrl;
  private final boolean openUriInWebView;
  private final long updated;
  private boolean wasViewedInternal;
  
  public Card(JSONObject paramJSONObject, CardKey.Provider paramProvider, protect.package_9.c paramC, ICardStorageProvider paramICardStorageProvider, Paint paramPaint)
  {
    jsonObject = paramJSONObject;
    brazeManager = paramC;
    cardStorage = paramICardStorageProvider;
    cardAnalytics = paramPaint;
    extras = JsonUtils.convertJSONObjectToMap(paramJSONObject.optJSONObject(paramProvider.getKey(CardKey.EXTRAS)));
    paramC = paramJSONObject.getString(paramProvider.getKey(CardKey.d));
    kotlin.x.d.i.d(paramC, "jsonObject.getString(car?vider.getKey(CardKey.ID))");
    _id = paramC;
    isContentCard = paramProvider.isContentCardProvider();
    cardType = CardType.DEFAULT;
    if (paramProvider.isContentCardProvider()) {
      paramC = Channel.CONTENT_CARD;
    } else {
      paramC = Channel.NEWS_FEED;
    }
    channel = paramC;
    wasViewedInternal = paramJSONObject.optBoolean(paramProvider.getKey(CardKey.VIEWED));
    isDismissedInternal = paramJSONObject.optBoolean(paramProvider.getKey(CardKey.DISMISSED), false);
    isPinned = paramJSONObject.optBoolean(paramProvider.getKey(CardKey.PINNED), false);
    created = paramJSONObject.getLong(paramProvider.getKey(CardKey.CREATED));
    expiresAt = paramJSONObject.optLong(paramProvider.getKey(CardKey.EXPIRES_AT), -1L);
    openUriInWebView = paramJSONObject.optBoolean(paramProvider.getKey(CardKey.OPEN_URI_IN_WEBVIEW), false);
    isRemoved = paramJSONObject.optBoolean(paramProvider.getKey(CardKey.REMOVED), false);
    paramC = paramJSONObject.optJSONArray(paramProvider.getKey(CardKey.CATEGORIES));
    if ((paramC != null) && (paramC.length() != 0))
    {
      paramJSONObject = EnumSet.noneOf(CardCategory.class);
      paramC = f.i(f.f(kotlin.collections.i.n((Iterable)d.g(0, paramC.length())), new b(paramC)), new c(paramC)).iterator();
      while (paramC.hasNext())
      {
        paramICardStorageProvider = CardCategory.format((String)paramC.next());
        if (paramICardStorageProvider != null)
        {
          kotlin.x.d.i.d(paramICardStorageProvider, "get(categoryString)");
          paramJSONObject.add(paramICardStorageProvider);
        }
      }
      categories = paramJSONObject;
    }
    else
    {
      categories = EnumSet.of(CardCategory.NO_CATEGORY);
    }
    updated = jsonObject.optLong(paramProvider.getKey(CardKey.UPDATED), created);
    isDismissibleByUser = jsonObject.optBoolean(paramProvider.getKey(CardKey.DISMISSIBLE), false);
    isIndicatorHighlightedInternal = jsonObject.optBoolean(paramProvider.getKey(CardKey.READ), wasViewedInternal);
    isClicked = jsonObject.optBoolean(paramProvider.getKey(CardKey.CLICKED), false);
    isTest = jsonObject.optBoolean(paramProvider.getKey(CardKey.IS_TEST), false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!kotlin.x.d.i.a(getClass(), paramObject.getClass())) {
        return false;
      }
      paramObject = (Card)paramObject;
      if ((updated == updated) && (kotlin.x.d.i.a(_id, _id))) {
        return true;
      }
    }
    return false;
  }
  
  public JSONObject forJsonPut()
  {
    return jsonObject;
  }
  
  public CardType getCardType()
  {
    return cardType;
  }
  
  public final Channel getChannel()
  {
    return channel;
  }
  
  public final long getCreated()
  {
    return created;
  }
  
  public final Map getExtras()
  {
    return extras;
  }
  
  public final String getId()
  {
    return _id;
  }
  
  public final boolean getOpenUriInWebView()
  {
    return openUriInWebView;
  }
  
  public String getUrl()
  {
    return mUrl;
  }
  
  public final boolean getViewed()
  {
    return wasViewedInternal;
  }
  
  public int hashCode()
  {
    int i = _id.hashCode();
    long l = updated;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final boolean isControl()
  {
    return getCardType() == CardType.CONTROL;
  }
  
  public final boolean isDismissibleByUser()
  {
    return isDismissibleByUser;
  }
  
  public final boolean isExpired()
  {
    long l = expiresAt;
    return (l != -1L) && (l <= DateTimeUtils.nowInSeconds());
  }
  
  public final boolean isInCategorySet(EnumSet paramEnumSet)
  {
    kotlin.x.d.i.e(paramEnumSet, "categories");
    EnumSet localEnumSet = categories;
    if (localEnumSet == null) {
      return false;
    }
    paramEnumSet = paramEnumSet.iterator();
    while (paramEnumSet.hasNext()) {
      if (localEnumSet.contains((CardCategory)paramEnumSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean isIndicatorHighlighted()
  {
    return isIndicatorHighlightedInternal;
  }
  
  public final boolean isPinned()
  {
    return isPinned;
  }
  
  public final boolean isValidCard()
  {
    if (g.o(_id))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, g.STARTED, 2, null);
      return false;
    }
    return true;
  }
  
  public final boolean logClick()
  {
    isClicked = true;
    if ((brazeManager != null) && (cardAnalytics != null) && (cardStorage != null)) {}
    try
    {
      boolean bool = isValidCard();
      if (bool)
      {
        localObject1 = cardAnalytics;
        localObject2 = _id;
        localObject1 = ((Paint)localObject1).a((String)localObject2);
        if (localObject1 != null)
        {
          localObject2 = brazeManager;
          ((protect.package_9.c)localObject2).a((p)localObject1);
        }
        localObject1 = cardStorage;
        localObject2 = _id;
        ((ICardStorageProvider)localObject1).markCardAsClicked((String)localObject2);
        localObject1 = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, new h(this), 3, null);
        return true;
      }
      Object localObject1 = BrazeLogger.INSTANCE;
      Object localObject2 = BrazeLogger.Priority.PREPARED;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, new i(this), 2, null);
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new j(this));
    }
    return false;
  }
  
  public final boolean logImpression()
  {
    if ((brazeManager != null) && (cardAnalytics != null) && (cardStorage != null)) {
      try
      {
        boolean bool = isValidCard();
        if (bool)
        {
          bool = isControl();
          if (!bool)
          {
            localObject1 = BrazeLogger.INSTANCE;
            localObject2 = BrazeLogger.Priority.$EnumSwitchMapping$0;
            BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, new k(this), 2, null);
            localObject1 = cardAnalytics;
            localObject2 = _id;
            localObject1 = ((Paint)localObject1).c((String)localObject2);
            if (localObject1 != null)
            {
              localObject2 = brazeManager;
              ((protect.package_9.c)localObject2).a((p)localObject1);
            }
          }
          else
          {
            localObject1 = BrazeLogger.INSTANCE;
            localObject2 = BrazeLogger.Priority.$EnumSwitchMapping$0;
            BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, new l(this), 2, null);
            localObject1 = cardAnalytics;
            localObject2 = _id;
            localObject1 = ((Paint)localObject1).b((String)localObject2);
            if (localObject1 != null)
            {
              localObject2 = brazeManager;
              ((protect.package_9.c)localObject2).a((p)localObject1);
            }
          }
          Object localObject1 = cardStorage;
          Object localObject2 = _id;
          ((ICardStorageProvider)localObject1).markCardAsViewed((String)localObject2);
          return true;
        }
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new m(this));
      }
    }
    return false;
  }
  
  public final void setDismissed(boolean paramBoolean)
  {
    if ((isDismissedInternal) && (paramBoolean))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, d.PLAYING, 2, null);
      return;
    }
    isDismissedInternal = paramBoolean;
    Object localObject1 = cardStorage;
    if (localObject1 != null) {
      ((ICardStorageProvider)localObject1).markCardAsDismissed(_id);
    }
    if ((paramBoolean) && (brazeManager != null) && (cardAnalytics != null)) {
      try
      {
        paramBoolean = isValidCard();
        if (paramBoolean)
        {
          localObject1 = cardAnalytics;
          Object localObject2 = _id;
          localObject1 = ((Paint)localObject1).f((String)localObject2);
          if (localObject1 != null)
          {
            localObject2 = brazeManager;
            ((protect.package_9.c)localObject2).a((p)localObject1);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, e.STARTED);
      }
    }
  }
  
  public final void setDismissibleByUser(boolean paramBoolean)
  {
    isDismissibleByUser = paramBoolean;
  }
  
  public final void setIndicatorHighlighted(boolean paramBoolean)
  {
    isIndicatorHighlightedInternal = paramBoolean;
    Object localObject = listener;
    if (localObject != null) {}
    try
    {
      ((ICardListener)localObject).onCardUpdate();
      if (paramBoolean)
      {
        localObject = cardStorage;
        if (localObject != null)
        {
          String str = _id;
          try
          {
            ((ICardStorageProvider)localObject).markCardAsVisuallyRead(str);
            return;
          }
          catch (Exception localException1)
          {
            BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.BEGIN, localException1, f.CHANGE);
            return;
          }
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public final void setListener(ICardListener paramICardListener)
  {
    listener = paramICardListener;
  }
  
  public final void setViewed(boolean paramBoolean)
  {
    wasViewedInternal = paramBoolean;
    ICardStorageProvider localICardStorageProvider = cardStorage;
    if (localICardStorageProvider != null) {
      localICardStorageProvider.markCardAsViewed(_id);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n            Card{\n            extras=");
    localStringBuilder.append(extras);
    localStringBuilder.append("\n            id='");
    localStringBuilder.append(_id);
    localStringBuilder.append("'\n            created=");
    localStringBuilder.append(created);
    localStringBuilder.append("\n            updated=");
    localStringBuilder.append(updated);
    localStringBuilder.append("\n            expiresAt=");
    localStringBuilder.append(expiresAt);
    localStringBuilder.append("\n            categories=");
    localStringBuilder.append(categories);
    localStringBuilder.append("\n            isContentCard=");
    localStringBuilder.append(isContentCard);
    localStringBuilder.append("\n            viewed=");
    localStringBuilder.append(wasViewedInternal);
    localStringBuilder.append("\n            isRead=");
    localStringBuilder.append(isIndicatorHighlightedInternal);
    localStringBuilder.append("\n            isDismissed=");
    localStringBuilder.append(isDismissedInternal);
    localStringBuilder.append("\n            isRemoved=");
    localStringBuilder.append(isRemoved);
    localStringBuilder.append("\n            isPinned=");
    localStringBuilder.append(isPinned);
    localStringBuilder.append("\n            isClicked=");
    localStringBuilder.append(isClicked);
    localStringBuilder.append("\n            openUriInWebview=");
    localStringBuilder.append(openUriInWebView);
    localStringBuilder.append("\n            isDismissibleByUser=");
    localStringBuilder.append(isDismissibleByUser);
    localStringBuilder.append("\n            isTest=");
    localStringBuilder.append(isTest);
    localStringBuilder.append("\n            json=");
    localStringBuilder.append(JsonUtils.getPrettyPrintedString(jsonObject));
    localStringBuilder.append("\n            }\n\n        ");
    return g.f(localStringBuilder.toString());
  }
  
  public static final class a
  {
    private a() {}
  }
  
  public static final class b
    extends j
    implements l<Integer, Boolean>
  {
    public b(JSONArray paramJSONArray)
    {
      super();
    }
    
    public final Boolean get(int paramInt)
    {
      return Boolean.valueOf(baseArgs.opt(paramInt) instanceof String);
    }
  }
  
  public static final class c
    extends j
    implements l<Integer, String>
  {
    public c(JSONArray paramJSONArray)
    {
      super();
    }
    
    public final Object get(int paramInt)
    {
      Object localObject = protocols.get(paramInt);
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.String");
      return (String)localObject;
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d PLAYING = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot dismiss a card more than once. Doing nothing.";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    public static final e STARTED = new e();
    
    e()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to log card as dismissed.";
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    public static final f CHANGE = new f();
    
    f()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to mark card indicator as highlighted.";
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    public static final g STARTED = new g();
    
    g()
    {
      super();
    }
    
    public final String getText()
    {
      return "Card ID cannot be null";
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    h(Card paramCard)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Logged click for card with id: ");
      localStringBuilder.append(val$c.getId());
      return localStringBuilder.toString();
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    i(Card paramCard)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to log card clicked for id: ");
      localStringBuilder.append(val$c.getId());
      return localStringBuilder.toString();
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    j(Card paramCard)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to log card as clicked for id: ");
      localStringBuilder.append(val$c.getId());
      return localStringBuilder.toString();
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    k(Card paramCard)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Logging impression event for card with id: ");
      localStringBuilder.append(val$c.getId());
      return localStringBuilder.toString();
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    l(Card paramCard)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Logging control impression event for card with id: ");
      localStringBuilder.append(val$c.getId());
      return localStringBuilder.toString();
    }
  }
  
  static final class m
    extends j
    implements a<String>
  {
    m(Card paramCard)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to log card impression for card id: ");
      localStringBuilder.append(val$c.getId());
      return localStringBuilder.toString();
    }
  }
}

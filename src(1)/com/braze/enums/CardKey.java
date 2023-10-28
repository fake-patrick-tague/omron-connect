package com.braze.enums;

import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.JsonUtils;
import java.util.Map;
import kotlin.collections.a0;
import kotlin.l;
import kotlin.q;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONObject;

public enum CardKey
{
  public static final a Companion = new a(null);
  private static final Map<String, CardType> cardTypeMap = a0.e(new l[] { q.a("banner_image", CardType.BANNER), q.a("captioned_image", CardType.CAPTIONED_IMAGE), q.a("text_announcement", CardType.TEXT_ANNOUNCEMENT), q.a("short_news", CardType.SHORT_NEWS), q.a("control", CardType.CONTROL) });
  private final String contentCardsKey;
  private final String feedKey;
  
  static
  {
    VIEWED = new CardKey("VIEWED", 1, "viewed", "v");
    CREATED = new CardKey("CREATED", 2, "created", "ca");
    EXPIRES_AT = new CardKey("EXPIRES_AT", 3, "expires_at", "ea");
    EXTRAS = new CardKey("EXTRAS", 4, "extras", "e");
    OPEN_URI_IN_WEBVIEW = new CardKey("OPEN_URI_IN_WEBVIEW", 5, "use_webview", "uw");
    TYPE = new CardKey("TYPE", 6, "type", "tp");
    CATEGORIES = new CardKey("CATEGORIES", 7, "categories", "");
    UPDATED = new CardKey("UPDATED", 8, "updated", "");
    DISMISSED = new CardKey("DISMISSED", 9, "", "d");
    REMOVED = new CardKey("REMOVED", 10, "", "r");
    PINNED = new CardKey("PINNED", 11, "", "p");
    DISMISSIBLE = new CardKey("DISMISSIBLE", 12, "", "db");
    IS_TEST = new CardKey("IS_TEST", 13, "", "t");
    READ = new CardKey("READ", 14, "", "read");
    CLICKED = new CardKey("CLICKED", 15, "", "cl");
    BANNER_IMAGE_IMAGE = new CardKey("BANNER_IMAGE_IMAGE", 16, "image", "i");
    BANNER_IMAGE_URL = new CardKey("BANNER_IMAGE_URL", 17, "url", "u");
    BANNER_IMAGE_DOMAIN = new CardKey("BANNER_IMAGE_DOMAIN", 18, "domain", "");
    BANNER_IMAGE_ASPECT_RATIO = new CardKey("BANNER_IMAGE_ASPECT_RATIO", 19, "aspect_ratio", "ar");
    CAPTIONED_IMAGE_IMAGE = new CardKey("CAPTIONED_IMAGE_IMAGE", 20, "image", "i");
    CAPTIONED_IMAGE_TITLE = new CardKey("CAPTIONED_IMAGE_TITLE", 21, "title", "tt");
    CAPTIONED_IMAGE_DESCRIPTION = new CardKey("CAPTIONED_IMAGE_DESCRIPTION", 22, "description", "ds");
    CAPTIONED_IMAGE_URL = new CardKey("CAPTIONED_IMAGE_URL", 23, "url", "u");
    CAPTIONED_IMAGE_DOMAIN = new CardKey("CAPTIONED_IMAGE_DOMAIN", 24, "domain", "dm");
    CAPTIONED_IMAGE_ASPECT_RATIO = new CardKey("CAPTIONED_IMAGE_ASPECT_RATIO", 25, "aspect_ratio", "ar");
    TEXT_ANNOUNCEMENT_TITLE = new CardKey("TEXT_ANNOUNCEMENT_TITLE", 26, "title", "tt");
    TEXT_ANNOUNCEMENT_DESCRIPTION = new CardKey("TEXT_ANNOUNCEMENT_DESCRIPTION", 27, "description", "ds");
    TEXT_ANNOUNCEMENT_URL = new CardKey("TEXT_ANNOUNCEMENT_URL", 28, "url", "u");
    TEXT_ANNOUNCEMENT_DOMAIN = new CardKey("TEXT_ANNOUNCEMENT_DOMAIN", 29, "domain", "dm");
    SHORT_NEWS_IMAGE = new CardKey("SHORT_NEWS_IMAGE", 30, "image", "i");
    SHORT_NEWS_TITLE = new CardKey("SHORT_NEWS_TITLE", 31, "title", "tt");
    SHORT_NEWS_DESCRIPTION = new CardKey("SHORT_NEWS_DESCRIPTION", 32, "description", "ds");
    SHORT_NEWS_URL = new CardKey("SHORT_NEWS_URL", 33, "url", "u");
    SHORT_NEWS_DOMAIN = new CardKey("SHORT_NEWS_DOMAIN", 34, "domain", "dm");
  }
  
  private CardKey(String paramString1, String paramString2)
  {
    feedKey = paramString1;
    contentCardsKey = paramString2;
  }
  
  public final String getContentCardsKey()
  {
    return contentCardsKey;
  }
  
  public final String getFeedKey()
  {
    return feedKey;
  }
  
  public static final class Provider
  {
    public static final Provider CONTENT_CARDS = new Provider(true);
    public static final a Companion = new a(null);
    public static final Provider NEWS_FEED = new Provider(false);
    private final boolean isContentCardProvider;
    
    public Provider(boolean paramBoolean)
    {
      isContentCardProvider = paramBoolean;
    }
    
    public final CardType getCardTypeFromJson(JSONObject paramJSONObject)
    {
      i.e(paramJSONObject, "jsonObject");
      String str3 = JsonUtils.getOptionalString(paramJSONObject, getKey(CardKey.TYPE));
      String str1 = str3;
      int j = 0;
      int i;
      if ((str3 != null) && (str3.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      String str2 = str1;
      if (i == 0)
      {
        str2 = str1;
        if (isContentCardProvider)
        {
          str2 = str1;
          if (i.a(str3, "short_news"))
          {
            str2 = JsonUtils.getOptionalString(paramJSONObject, getKey(CardKey.SHORT_NEWS_IMAGE));
            if (str2 != null)
            {
              i = j;
              if (str2.length() != 0) {}
            }
            else
            {
              i = 1;
            }
            str2 = str1;
            if (i != 0)
            {
              BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new b(paramJSONObject), 2, null);
              str2 = "text_announcement";
            }
          }
        }
      }
      if (CardKey.access$getCardTypeMap$cp().containsKey(str2)) {
        return (CardType)CardKey.access$getCardTypeMap$cp().get(str2);
      }
      return CardType.DEFAULT;
    }
    
    public final String getKey(CardKey paramCardKey)
    {
      i.e(paramCardKey, "key");
      if (isContentCardProvider) {
        return paramCardKey.getContentCardsKey();
      }
      return paramCardKey.getFeedKey();
    }
    
    public final boolean isContentCardProvider()
    {
      return isContentCardProvider;
    }
    
    public static final class a
    {
      private a() {}
    }
    
    static final class b
      extends j
      implements a<String>
    {
      b(JSONObject paramJSONObject)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Short News card doesn't contain image url, parsing type as Text Announcement. JSON: ");
        localStringBuilder.append(data);
        return localStringBuilder.toString();
      }
    }
  }
  
  public static final class a
  {
    private a() {}
  }
}

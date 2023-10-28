package com.braze.models.cards;

import com.braze.enums.CardKey;
import com.braze.enums.CardKey.Provider;
import com.braze.enums.CardType;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.JsonUtils;
import kotlin.text.g;
import kotlin.x.d.i;
import org.json.JSONObject;
import protect.package_9.Paint;
import protect.package_9.c;

public final class ShortNewsCard
  extends Card
{
  private final CardType cardType;
  private final String description;
  private final String domain;
  private final String imageUrl;
  private final String title;
  private final String url;
  
  public ShortNewsCard(JSONObject paramJSONObject, CardKey.Provider paramProvider, c paramC, ICardStorageProvider paramICardStorageProvider, Paint paramPaint)
  {
    super(paramJSONObject, paramProvider, paramC, paramICardStorageProvider, paramPaint);
    paramC = paramJSONObject.getString(paramProvider.getKey(CardKey.SHORT_NEWS_DESCRIPTION));
    i.d(paramC, "jsonObject.getString(car?.SHORT_NEWS_DESCRIPTION))");
    description = paramC;
    paramC = paramJSONObject.getString(paramProvider.getKey(CardKey.SHORT_NEWS_IMAGE));
    i.d(paramC, "jsonObject.getString(car?ardKey.SHORT_NEWS_IMAGE))");
    imageUrl = paramC;
    title = JsonUtils.getOptionalString(paramJSONObject, paramProvider.getKey(CardKey.SHORT_NEWS_TITLE));
    url = JsonUtils.getOptionalString(paramJSONObject, paramProvider.getKey(CardKey.SHORT_NEWS_URL));
    domain = JsonUtils.getOptionalString(paramJSONObject, paramProvider.getKey(CardKey.SHORT_NEWS_DOMAIN));
    cardType = CardType.SHORT_NEWS;
  }
  
  public CardType getCardType()
  {
    return cardType;
  }
  
  public final String getDescription()
  {
    return description;
  }
  
  public final String getDomain()
  {
    return domain;
  }
  
  public final String getImageUrl()
  {
    return imageUrl;
  }
  
  public final String getTitle()
  {
    return title;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n            ShortNewsCard{description='");
    localStringBuilder.append(description);
    localStringBuilder.append("'\n            imageUrl='");
    localStringBuilder.append(imageUrl);
    localStringBuilder.append("'\n            title='");
    localStringBuilder.append(title);
    localStringBuilder.append("'\n            url='");
    localStringBuilder.append(getUrl());
    localStringBuilder.append("'\n            domain='");
    localStringBuilder.append(domain);
    localStringBuilder.append("\n            ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("}\n\n        ");
    return g.f(localStringBuilder.toString());
  }
}

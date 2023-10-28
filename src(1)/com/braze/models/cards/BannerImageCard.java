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

public final class BannerImageCard
  extends Card
{
  private final float aspectRatio;
  private final CardType cardType;
  private final String domain;
  private final String imageUrl;
  private final String url;
  
  public BannerImageCard(JSONObject paramJSONObject, CardKey.Provider paramProvider, c paramC, ICardStorageProvider paramICardStorageProvider, Paint paramPaint)
  {
    super(paramJSONObject, paramProvider, paramC, paramICardStorageProvider, paramPaint);
    paramC = paramJSONObject.getString(paramProvider.getKey(CardKey.BANNER_IMAGE_IMAGE));
    i.d(paramC, "jsonObject.getString(car?dKey.BANNER_IMAGE_IMAGE))");
    imageUrl = paramC;
    url = JsonUtils.getOptionalString(paramJSONObject, paramProvider.getKey(CardKey.BANNER_IMAGE_URL));
    domain = JsonUtils.getOptionalString(paramJSONObject, paramProvider.getKey(CardKey.BANNER_IMAGE_DOMAIN));
    aspectRatio = ((float)paramJSONObject.optDouble(paramProvider.getKey(CardKey.BANNER_IMAGE_ASPECT_RATIO), 0.0D));
    cardType = CardType.BANNER;
  }
  
  public final float getAspectRatio()
  {
    return aspectRatio;
  }
  
  public CardType getCardType()
  {
    return cardType;
  }
  
  public final String getImageUrl()
  {
    return imageUrl;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n            BannerImageCard{imageUrl='");
    localStringBuilder.append(imageUrl);
    localStringBuilder.append("'\n            url='");
    localStringBuilder.append(getUrl());
    localStringBuilder.append("'\n            domain='");
    localStringBuilder.append(domain);
    localStringBuilder.append("'\n            aspectRatio=");
    localStringBuilder.append(aspectRatio);
    localStringBuilder.append("\n            ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("}\n            \n        ");
    return g.f(localStringBuilder.toString());
  }
}

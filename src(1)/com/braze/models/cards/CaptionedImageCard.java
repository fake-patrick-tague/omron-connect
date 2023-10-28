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

public final class CaptionedImageCard
  extends Card
{
  private final float aspectRatio;
  private final CardType cardType;
  private final String description;
  private final String domain;
  private final String imageUrl;
  private final String title;
  private final String url;
  
  public CaptionedImageCard(JSONObject paramJSONObject, CardKey.Provider paramProvider, c paramC, ICardStorageProvider paramICardStorageProvider, Paint paramPaint)
  {
    super(paramJSONObject, paramProvider, paramC, paramICardStorageProvider, paramPaint);
    paramC = paramJSONObject.getString(paramProvider.getKey(CardKey.CAPTIONED_IMAGE_IMAGE));
    i.d(paramC, "jsonObject.getString(car?y.CAPTIONED_IMAGE_IMAGE))");
    imageUrl = paramC;
    paramC = paramJSONObject.getString(paramProvider.getKey(CardKey.CAPTIONED_IMAGE_TITLE));
    i.d(paramC, "jsonObject.getString(car?y.CAPTIONED_IMAGE_TITLE))");
    title = paramC;
    paramC = paramJSONObject.getString(paramProvider.getKey(CardKey.CAPTIONED_IMAGE_DESCRIPTION));
    i.d(paramC, "jsonObject.getString(car?IONED_IMAGE_DESCRIPTION))");
    description = paramC;
    url = JsonUtils.getOptionalString(paramJSONObject, paramProvider.getKey(CardKey.CAPTIONED_IMAGE_URL));
    domain = JsonUtils.getOptionalString(paramJSONObject, paramProvider.getKey(CardKey.CAPTIONED_IMAGE_DOMAIN));
    aspectRatio = ((float)paramJSONObject.optDouble(paramProvider.getKey(CardKey.CAPTIONED_IMAGE_ASPECT_RATIO), 0.0D));
    cardType = CardType.CAPTIONED_IMAGE;
  }
  
  public final float getAspectRatio()
  {
    return aspectRatio;
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
    localStringBuilder.append("\n            CaptionedImageCard{imageUrl='");
    localStringBuilder.append(imageUrl);
    localStringBuilder.append("'\n            title='");
    localStringBuilder.append(title);
    localStringBuilder.append("'\n            description='");
    localStringBuilder.append(description);
    localStringBuilder.append("'\n            url='");
    localStringBuilder.append(getUrl());
    localStringBuilder.append("'\n            domain='");
    localStringBuilder.append(domain);
    localStringBuilder.append("'\n            aspectRatio=");
    localStringBuilder.append(aspectRatio);
    localStringBuilder.append("\n            ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("}\n\n        ");
    return g.f(localStringBuilder.toString());
  }
}

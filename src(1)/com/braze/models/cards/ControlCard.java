package com.braze.models.cards;

import com.braze.enums.CardKey.Provider;
import com.braze.enums.CardType;
import com.braze.storage.ICardStorageProvider;
import org.json.JSONObject;
import protect.package_9.Paint;
import protect.package_9.c;

public final class ControlCard
  extends Card
{
  private final CardType cardType = CardType.CONTROL;
  
  public ControlCard(JSONObject paramJSONObject, CardKey.Provider paramProvider, c paramC, ICardStorageProvider paramICardStorageProvider, Paint paramPaint)
  {
    super(paramJSONObject, paramProvider, paramC, paramICardStorageProvider, paramPaint);
  }
  
  public CardType getCardType()
  {
    return cardType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ControlCard{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

package com.braze.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;

public abstract interface IBrazeImageLoader
{
  public abstract Bitmap getInAppMessageBitmapFromUrl(Context paramContext, IInAppMessage paramIInAppMessage, String paramString, BrazeViewBounds paramBrazeViewBounds);
  
  public abstract Bitmap getPushBitmapFromUrl(Context paramContext, Bundle paramBundle, String paramString, BrazeViewBounds paramBrazeViewBounds);
  
  public abstract void renderUrlIntoCardView(Context paramContext, Card paramCard, String paramString, ImageView paramImageView, BrazeViewBounds paramBrazeViewBounds);
  
  public abstract void renderUrlIntoInAppMessageView(Context paramContext, IInAppMessage paramIInAppMessage, String paramString, ImageView paramImageView, BrazeViewBounds paramBrazeViewBounds);
  
  public abstract void setOffline(boolean paramBoolean);
}

package com.braze.models.inappmessage;

import android.graphics.Bitmap;

public abstract interface IInAppMessageWithImage
{
  public abstract Bitmap getBitmap();
  
  public abstract String getLocalImageUrl();
  
  public abstract String getRemoteImageUrl();
  
  public abstract void setBitmap(Bitmap paramBitmap);
  
  public abstract void setImageDownloadSuccessful(boolean paramBoolean);
  
  public abstract void setLocalImageUrl(String paramString);
}

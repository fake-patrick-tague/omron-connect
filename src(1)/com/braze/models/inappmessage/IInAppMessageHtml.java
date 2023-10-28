package com.braze.models.inappmessage;

public abstract interface IInAppMessageHtml
  extends IInAppMessage
{
  public abstract String getLocalAssetsDirectoryUrl();
  
  public abstract boolean logButtonClick(String paramString);
  
  public abstract void setLocalAssetsDirectoryUrl(String paramString);
}

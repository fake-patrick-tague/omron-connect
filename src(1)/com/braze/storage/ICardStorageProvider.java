package com.braze.storage;

public abstract interface ICardStorageProvider<T>
{
  public abstract void markCardAsClicked(String paramString);
  
  public abstract void markCardAsDismissed(String paramString);
  
  public abstract void markCardAsViewed(String paramString);
  
  public abstract void markCardAsVisuallyRead(String paramString);
}

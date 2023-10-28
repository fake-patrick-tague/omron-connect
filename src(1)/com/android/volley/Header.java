package com.android.volley;

import android.text.TextUtils;

public final class Header
{
  private final String mName;
  private final String mValue;
  
  public Header(String paramString1, String paramString2)
  {
    mName = paramString1;
    mValue = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (Header.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Header)paramObject;
      if ((TextUtils.equals(mName, mName)) && (TextUtils.equals(mValue, mValue))) {
        return true;
      }
    }
    return false;
  }
  
  public final String getName()
  {
    return mName;
  }
  
  public final String getValue()
  {
    return mValue;
  }
  
  public int hashCode()
  {
    return mName.hashCode() * 31 + mValue.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Header[name=");
    localStringBuilder.append(mName);
    localStringBuilder.append(",value=");
    localStringBuilder.append(mValue);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

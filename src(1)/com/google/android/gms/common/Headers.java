package com.google.android.gms.common;

import android.util.Log;

class Headers
{
  private static final Headers NONE = new Headers(true, 3, 1, null, null);
  final int mContext;
  final String mId;
  final Throwable mName;
  final boolean this$0;
  
  private Headers(boolean paramBoolean, int paramInt1, int paramInt2, String paramString, Throwable paramThrowable)
  {
    this$0 = paramBoolean;
    mContext = paramInt1;
    mId = paramString;
    mName = paramThrowable;
  }
  
  static Headers add(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable)
  {
    return new Headers(false, paramInt1, paramInt2, paramString, paramThrowable);
  }
  
  static Headers create(String paramString, Throwable paramThrowable)
  {
    return new Headers(false, 1, 5, paramString, paramThrowable);
  }
  
  static Headers get()
  {
    return NONE;
  }
  
  static Headers get(int paramInt)
  {
    return new Headers(true, paramInt, 1, null, null);
  }
  
  static Headers get(String paramString)
  {
    return new Headers(false, 1, 5, paramString, null);
  }
  
  final void clear()
  {
    if ((!this$0) && (Log.isLoggable("GoogleCertificatesRslt", 3)))
    {
      if (mName != null)
      {
        Log.d("GoogleCertificatesRslt", getValue(), mName);
        return;
      }
      Log.d("GoogleCertificatesRslt", getValue());
    }
  }
  
  String getValue()
  {
    return mId;
  }
}

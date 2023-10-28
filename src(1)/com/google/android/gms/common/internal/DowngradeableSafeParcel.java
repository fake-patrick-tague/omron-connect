package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  private static final Object stroke_width = new Object();
  private boolean isIgnorable = false;
  
  public DowngradeableSafeParcel() {}
  
  protected static boolean canUnparcelSafely(String paramString)
  {
    paramString = stroke_width;
    try
    {
      return true;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected static Integer getUnparcelClientVersion()
  {
    Object localObject = stroke_width;
    try
    {
      return null;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected abstract boolean prepareForClientVersion(int paramInt);
  
  public void setShouldDowngrade(boolean paramBoolean)
  {
    isIgnorable = paramBoolean;
  }
  
  protected boolean shouldDowngrade()
  {
    return isIgnorable;
  }
}

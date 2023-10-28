package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@Deprecated
@KeepForSdk
public class WakeLockTracker
{
  private static WakeLockTracker SFTP = new WakeLockTracker();
  
  public WakeLockTracker() {}
  
  public static WakeLockTracker getInstance()
  {
    return SFTP;
  }
  
  public void registerAcquireEvent(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {}
  
  public void registerDeadlineEvent(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, List paramList, boolean paramBoolean, long paramLong) {}
  
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List paramList) {}
  
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List paramList, long paramLong) {}
  
  public void registerReleaseEvent(Context paramContext, Intent paramIntent) {}
}

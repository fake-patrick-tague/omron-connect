package com.braze;

import android.content.Context;
import android.content.Intent;
import com.braze.events.InAppMessageEvent;
import kotlin.x.d.i;

public final class BrazeInternal
{
  public static final BrazeInternal INSTANCE = new BrazeInternal();
  
  private BrazeInternal() {}
  
  public static final void addSerializedContentCardToStorage(Context paramContext, String paramString1, String paramString2)
  {
    i.e(paramContext, "context");
    i.e(paramString1, "serializedCardJson");
    INSTANCE.getInstance(paramContext).addSerializedCardJsonToStorage$android_sdk_base_release(paramString1, paramString2);
  }
  
  public static final void applyPendingRuntimeConfiguration(Context paramContext)
  {
    i.e(paramContext, "context");
    INSTANCE.getInstance(paramContext).applyPendingRuntimeConfiguration$android_sdk_base_release();
  }
  
  private final Braze getInstance(Context paramContext)
  {
    return Braze.Companion.getInstance(paramContext);
  }
  
  public static final void handleInAppMessageTestPush(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "intent");
    INSTANCE.getInstance(paramContext).handleInAppMessageTestPush$android_sdk_base_release(paramIntent);
  }
  
  public static final void refreshFeatureFlags(Context paramContext)
  {
    i.e(paramContext, "context");
    INSTANCE.getInstance(paramContext).refreshFeatureFlags();
  }
  
  public static final void requestGeofenceRefresh(Context paramContext, boolean paramBoolean)
  {
    i.e(paramContext, "context");
    INSTANCE.getInstance(paramContext).requestGeofenceRefresh$android_sdk_base_release(paramBoolean);
  }
  
  public static final void retryInAppMessage(Context paramContext, InAppMessageEvent paramInAppMessageEvent)
  {
    i.e(paramContext, "context");
    i.e(paramInAppMessageEvent, "inAppMessageEvent");
    INSTANCE.getInstance(paramContext).retryInAppMessage$android_sdk_base_release(paramInAppMessageEvent);
  }
}

package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.internal.zzfq;

final class zzcx
  extends zzdt
{
  zzcx(zzee paramZzee, String paramString1, String paramString2, Context paramContext, Bundle paramBundle)
  {
    super(paramZzee, true);
  }
  
  public final void receiveLoop()
  {
    Object localObject1 = this$0;
    Object localObject2 = queue;
    Object localObject3 = current;
    try
    {
      boolean bool = zzee.append((zzee)localObject1, (String)localObject2, (String)localObject3);
      if (bool)
      {
        localObject3 = current;
        localObject1 = queue;
        localObject2 = this$0;
        localObject2 = zzee.toString((zzee)localObject2);
      }
      else
      {
        localObject2 = null;
        localObject1 = null;
        localObject3 = null;
      }
      Object localObject4 = low;
      Preconditions.checkNotNull(localObject4);
      localObject4 = this$0;
      Context localContext = low;
      zzee.append((zzee)localObject4, ((zzee)localObject4).read(localContext, true));
      localObject4 = this$0;
      localObject4 = zzee.append((zzee)localObject4);
      if (localObject4 == null)
      {
        localObject1 = this$0;
        Log.w(zzee.toString((zzee)localObject1), "Failed to connect to measurement client.");
        return;
      }
      localObject4 = low;
      int i = DynamiteModule.getLocalVersion((Context)localObject4, "com.google.android.gms.measurement.dynamite");
      localObject4 = low;
      int j = DynamiteModule.getRemoteVersion((Context)localObject4, "com.google.android.gms.measurement.dynamite");
      int k = Math.max(i, j);
      if (j < i) {
        bool = true;
      } else {
        bool = false;
      }
      long l = k;
      localObject4 = high;
      localContext = low;
      localObject1 = new zzcl(73000L, l, bool, (String)localObject2, (String)localObject1, (String)localObject3, (Bundle)localObject4, zzfq.build(localContext));
      localObject2 = this$0;
      localObject2 = Preconditions.checkNotNull(zzee.append((zzee)localObject2));
      localObject2 = (zzcc)localObject2;
      localObject3 = low;
      localObject3 = ObjectWrapper.wrap(localObject3);
      l = low;
      ((zzcc)localObject2).initialize((IObjectWrapper)localObject3, (zzcl)localObject1, l);
      return;
    }
    catch (Exception localException)
    {
      zzee.onError(this$0, localException, true, false);
    }
  }
}

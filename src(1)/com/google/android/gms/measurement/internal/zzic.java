package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

final class zzic
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        this$0.this$0.zzay().next().append("onActivityCreated");
        localObject = paramActivity.getIntent();
        if (localObject != null) {
          continue;
        }
        localObject = this$0.this$0;
      }
      catch (Throwable localThrowable) {}catch (RuntimeException localRuntimeException)
      {
        Object localObject;
        Uri localUri;
        boolean bool1;
        boolean bool2;
        int i;
        String str;
        zzfv localZzfv;
        this$0.this$0.zzay().iterator().append("Throwable caught in onActivityCreated", localRuntimeException);
        localZzfy = this$0.this$0;
        continue;
      }
      ((zzfy)localObject).d().onActivityCreated(paramActivity, paramBundle);
      return;
      localUri = ((Intent)localObject).getData();
      if (localUri != null)
      {
        bool1 = localUri.isHierarchical();
        if (bool1)
        {
          this$0.this$0.get();
          localObject = ((Intent)localObject).getStringExtra("android.intent.extra.REFERRER_NAME");
          bool2 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(localObject);
          bool1 = true;
          if (!bool2)
          {
            bool2 = "https://www.google.com".equals(localObject);
            if (!bool2)
            {
              bool2 = "android-app://com.google.appcrawler".equals(localObject);
              if (!bool2)
              {
                i = 0;
                continue;
              }
            }
          }
          i = 1;
          if (1 != i) {
            localObject = "auto";
          } else {
            localObject = "gs";
          }
          str = localUri.getQueryParameter("referrer");
          if (paramBundle != null) {
            bool1 = false;
          }
          localZzfv = this$0.this$0.zzaz();
          localZzfv.append(new zzia(this, bool1, localUri, (String)localObject, str));
          localObject = this$0.this$0;
          continue;
        }
      }
      localObject = this$0.this$0;
    }
    zzfy localZzfy;
    this$0.this$0.d().onActivityCreated(paramActivity, paramBundle);
    throw localZzfy;
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this$0.this$0.d().send(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    this$0.this$0.d().d(paramActivity);
    paramActivity = this$0.this$0.getRepository();
    long l = this$0.zzav().elapsedRealtime();
    this$0.zzaz().append(new zzkb(paramActivity, l));
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    zzki localZzki = this$0.this$0.getRepository();
    long l = this$0.zzav().elapsedRealtime();
    this$0.zzaz().append(new zzka(localZzki, l));
    this$0.this$0.d().visitMaxs(paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this$0.this$0.d().save(paramActivity, paramBundle);
  }
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}

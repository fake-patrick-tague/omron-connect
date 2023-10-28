package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;

final class zzia
  implements Runnable
{
  zzia(zzic paramZzic, boolean paramBoolean, Uri paramUri, String paramString1, String paramString2) {}
  
  public final void run()
  {
    zzic localZzic = val$mPath;
    boolean bool1 = this$0;
    Uri localUri = val$interrupt;
    String str1 = url;
    String str2 = title;
    this$0.append();
    try
    {
      Object localObject1 = this$0.this$0.get();
      boolean bool2 = TextUtils.isEmpty(str2);
      if (bool2) {}
      for (;;)
      {
        localObject1 = null;
        break label206;
        bool2 = str2.contains("gclid");
        if (bool2) {
          break;
        }
        bool2 = str2.contains("utm_campaign");
        if (bool2) {
          break;
        }
        bool2 = str2.contains("utm_source");
        if (bool2) {
          break;
        }
        bool2 = str2.contains("utm_medium");
        if (bool2) {
          break;
        }
        bool2 = str2.contains("utm_id");
        if (bool2) {
          break;
        }
        bool2 = str2.contains("dclid");
        if (bool2) {
          break;
        }
        bool2 = str2.contains("srsltid");
        if (bool2) {
          break;
        }
        this$0.zzay().e().append("Activity created with data 'referrer' without required params");
      }
      Object localObject3 = ((zzlh)localObject1).parse(Uri.parse("https://google.com/search?".concat(str2)));
      Object localObject2 = localObject3;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((BaseBundle)localObject3).putString("_cis", "referrer");
        localObject1 = localObject2;
      }
      label206:
      if (bool1)
      {
        localObject2 = this$0.this$0.get().parse(localUri);
        if (localObject2 != null)
        {
          ((BaseBundle)localObject2).putString("_cis", "intent");
          bool1 = ((BaseBundle)localObject2).containsKey("gclid");
          if ((!bool1) && (localObject1 != null))
          {
            bool1 = ((BaseBundle)localObject1).containsKey("gclid");
            if (bool1) {
              ((BaseBundle)localObject2).putString("_cer", String.format("gclid=%s", new Object[] { ((BaseBundle)localObject1).getString("gclid") }));
            }
          }
          this$0.put(str1, "_cmp", (Bundle)localObject2);
          this$0.this$0.load(str1, (Bundle)localObject2);
        }
      }
      bool1 = TextUtils.isEmpty(str2);
      if (bool1) {
        return;
      }
      this$0.this$0.zzay().e().append("Activity created with referrer", str2);
      localObject2 = this$0.this$0.append();
      localObject3 = zzeb.o;
      bool1 = ((zzag)localObject2).get(null, (zzea)localObject3);
      if (bool1)
      {
        if (localObject1 != null)
        {
          this$0.put(str1, "_cmp", (Bundle)localObject1);
          this$0.this$0.load(str1, (Bundle)localObject1);
        }
        else
        {
          this$0.this$0.zzay().e().append("Referrer does not contain valid parameters", str2);
        }
        this$0.update("auto", "_ldl", null, true);
        return;
      }
      bool1 = str2.contains("gclid");
      if (bool1)
      {
        bool1 = str2.contains("utm_campaign");
        if (!bool1)
        {
          bool1 = str2.contains("utm_source");
          if (!bool1)
          {
            bool1 = str2.contains("utm_medium");
            if (!bool1)
            {
              bool1 = str2.contains("utm_term");
              if (!bool1)
              {
                bool1 = str2.contains("utm_content");
                if (!bool1) {
                  break label554;
                }
              }
            }
          }
        }
        bool1 = TextUtils.isEmpty(str2);
        if (bool1) {
          return;
        }
        this$0.update("auto", "_ldl", str2, true);
        return;
      }
      label554:
      this$0.this$0.zzay().e().append("Activity created with data 'referrer' without required params");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this$0.this$0.zzay().iterator().append("Throwable caught in handleReferrerForOnActivityCreated", localRuntimeException);
    }
  }
}

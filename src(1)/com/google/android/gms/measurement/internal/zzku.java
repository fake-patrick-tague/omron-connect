package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class zzku
  implements zzlg
{
  zzku(zzkz paramZzkz) {}
  
  public final void visitLocalVariable(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = labels;
      if (zzkz.order(paramString1) != null) {
        zzkz.order(paramString1).zzay().iterator().append("AppId not known when logging event", "_err");
      }
    }
    else
    {
      labels.zzaz().append(new zzkt(this, paramString1, "_err", paramBundle));
    }
  }
}

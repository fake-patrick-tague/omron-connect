package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class zzhr
  implements zzlg
{
  zzhr(zzid paramZzid) {}
  
  public final void visitLocalVariable(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      labels.add("auto", "_err", paramBundle, paramString1);
      return;
    }
    labels.get("auto", "_err", paramBundle);
  }
}

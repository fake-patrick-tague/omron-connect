package com.google.android.gms.cloudmessaging;

import android.os.BaseBundle;
import android.os.Bundle;

final class Category
  extends zzp<Void>
{
  Category(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 2, paramBundle);
  }
  
  final boolean getId()
  {
    return true;
  }
  
  final void load(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ack", false))
    {
      put(null);
      return;
    }
    init(new JSONObject(4, "Invalid response to one way request", null));
  }
}

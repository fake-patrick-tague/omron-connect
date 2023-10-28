package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class Route
  extends zzp<Bundle>
{
  Route(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 1, paramBundle);
  }
  
  final boolean getId()
  {
    return false;
  }
  
  final void load(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle.getBundle("data");
    paramBundle = localBundle;
    if (localBundle == null) {
      paramBundle = Bundle.EMPTY;
    }
    put(paramBundle);
  }
}

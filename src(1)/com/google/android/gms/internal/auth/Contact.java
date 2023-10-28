package com.google.android.gms.internal.auth;

import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;

final class Contact
  implements Result
{
  private final Status mStatus;
  
  public Contact(Status paramStatus)
  {
    mStatus = paramStatus;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
}

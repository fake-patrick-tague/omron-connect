package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

final class User
{
  private final int id;
  private final ConnectionResult name;
  
  User(ConnectionResult paramConnectionResult, int paramInt)
  {
    Preconditions.checkNotNull(paramConnectionResult);
    name = paramConnectionResult;
    id = paramInt;
  }
  
  final int getId()
  {
    return id;
  }
  
  final ConnectionResult getName()
  {
    return name;
  }
}

package com.google.android.gms.dynamic;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface OnDelegateCreatedListener<T extends LifecycleDelegate>
{
  public abstract void onDelegateCreated(LifecycleDelegate paramLifecycleDelegate);
}

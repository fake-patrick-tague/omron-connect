package com.google.android.gms.common.internal.service;

import android.os.RemoteException;

final class PropPatchMethod
  extends DavMethodBase
{
  private final com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<com.google.android.gms.common.api.Status> log;
  
  public PropPatchMethod(com.google.android.gms.common.package_12.internal.BaseImplementation.ResultHolder paramResultHolder)
  {
    log = paramResultHolder;
  }
  
  public final void processMultiStatusBody(int paramInt)
    throws RemoteException
  {
    log.setResult(new com.google.android.gms.common.package_12.Status(paramInt));
  }
}

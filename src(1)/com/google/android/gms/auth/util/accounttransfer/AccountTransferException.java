package com.google.android.gms.auth.util.accounttransfer;

import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.common.package_12.Status;

public class AccountTransferException
  extends ApiException
{
  public AccountTransferException(Status paramStatus)
  {
    super(paramStatus);
  }
}

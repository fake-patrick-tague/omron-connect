package com.google.android.gms.auth.util.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.Transaction;
import com.google.android.gms.internal.auth.zzaf;

final class Bookmark
  extends AccountTransferClient.zzc
{
  Bookmark(AccountTransferClient paramAccountTransferClient, zzaf paramZzaf)
  {
    super(null);
  }
  
  protected final void readThis(Transaction paramTransaction)
    throws RemoteException
  {
    paramTransaction.commit(zzax, zzao);
  }
}

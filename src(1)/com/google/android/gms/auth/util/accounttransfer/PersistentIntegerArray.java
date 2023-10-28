package com.google.android.gms.auth.util.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.Transaction;
import com.google.android.gms.internal.auth.zzah;

final class PersistentIntegerArray
  extends AccountTransferClient.zzc
{
  PersistentIntegerArray(AccountTransferClient paramAccountTransferClient, zzah paramZzah)
  {
    super(null);
  }
  
  protected final void readThis(Transaction paramTransaction)
    throws RemoteException
  {
    paramTransaction.commit(zzax, zzat);
  }
}

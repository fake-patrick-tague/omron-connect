package com.google.android.gms.auth.util.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.Transaction;
import com.google.android.gms.internal.auth.zzab;

final class FileHeaderVariablePart1
  extends AccountTransferClient.zzc
{
  FileHeaderVariablePart1(AccountTransferClient paramAccountTransferClient, zzab paramZzab)
  {
    super(null);
  }
  
  protected final void readThis(Transaction paramTransaction)
    throws RemoteException
  {
    paramTransaction.commit(zzax, zzau);
  }
}

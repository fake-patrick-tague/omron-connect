package com.google.android.gms.auth.util.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.Transaction;
import com.google.android.gms.internal.auth.zzad;

final class BTreeNode
  extends com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb<byte[]>
{
  BTreeNode(AccountTransferClient paramAccountTransferClient, zzad paramZzad)
  {
    super(null);
  }
  
  protected final void readThis(Transaction paramTransaction)
    throws RemoteException
  {
    paramTransaction.commit(new Field(this, this), zzap);
  }
}

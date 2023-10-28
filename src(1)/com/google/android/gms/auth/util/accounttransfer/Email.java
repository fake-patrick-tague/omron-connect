package com.google.android.gms.auth.util.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.internal.auth.Artist;
import com.google.android.gms.internal.auth.Transaction;

final class Email
  extends com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb<DeviceMetaData>
{
  Email(AccountTransferClient paramAccountTransferClient, Artist paramArtist)
  {
    super(null);
  }
  
  protected final void readThis(Transaction paramTransaction)
    throws RemoteException
  {
    paramTransaction.commit(new Converter(this, this), zzar);
  }
}

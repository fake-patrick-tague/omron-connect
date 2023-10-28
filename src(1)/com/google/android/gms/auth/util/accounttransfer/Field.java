package com.google.android.gms.auth.util.accounttransfer;

final class Field
  extends com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zza<byte[]>
{
  Field(BTreeNode paramBTreeNode, AccountTransferClient.zzb paramZzb)
  {
    super(paramZzb);
  }
  
  public final void generateKey(byte[] paramArrayOfByte)
  {
    zzaq.setResult(paramArrayOfByte);
  }
}

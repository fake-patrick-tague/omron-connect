package com.google.android.gms.auth.util.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.zzn;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApi.Settings.Builder;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.ApiExceptionMapper;
import com.google.android.gms.internal.auth.Artist;
import com.google.android.gms.internal.auth.GeocoderBackend.Stub;
import com.google.android.gms.internal.auth.Transaction;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzaf;
import com.google.android.gms.internal.auth.zzah;
import com.google.android.gms.internal.auth.zzs;
import com.google.android.gms.internal.auth.zzu;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class AccountTransferClient
  extends com.google.android.gms.common.api.GoogleApi<zzn>
{
  private static final com.google.android.gms.common.api.Api.ClientKey<zzu> zzaj;
  private static final Api.AbstractClientBuilder<zzu, zzn> zzak;
  private static final Api<zzn> zzal;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    zzaj = localClientKey;
    ASN1OctetString localASN1OctetString = new ASN1OctetString();
    zzak = localASN1OctetString;
    zzal = new Attribute("AccountTransfer.ACCOUNT_TRANSFER_API", localASN1OctetString, localClientKey);
  }
  
  AccountTransferClient(Activity paramActivity)
  {
    super(paramActivity, zzal, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
  }
  
  AccountTransferClient(Context paramContext)
  {
    super(paramContext, zzal, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
  }
  
  private static void rebase(TaskCompletionSource paramTaskCompletionSource, Status paramStatus)
  {
    paramTaskCompletionSource.setException(new AccountTransferException(paramStatus));
  }
  
  public Task getDeviceMetaData(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return doRead(new Email(this, new Artist(paramString)));
  }
  
  public Task notifyCompletion(String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramString);
    return doWrite(new FileHeaderVariablePart1(this, new zzab(paramString, paramInt)));
  }
  
  public Task retrieveData(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return doRead(new BTreeNode(this, new zzad(paramString)));
  }
  
  public Task sendData(String paramString, byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramArrayOfByte);
    return doWrite(new Bookmark(this, new zzaf(paramString, paramArrayOfByte)));
  }
  
  public Task showUserChallenge(String paramString, PendingIntent paramPendingIntent)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramPendingIntent);
    return doWrite(new PersistentIntegerArray(this, new zzah(paramString, paramPendingIntent)));
  }
  
  class zza<T>
    extends zzs
  {
    public zza() {}
    
    public final void onFailure(Status paramStatus)
    {
      onStatusChanged(paramStatus);
    }
  }
  
  abstract class zzb<T>
    extends TaskApiCall<zzu, T>
  {
    private TaskCompletionSource<T> zzaw;
    
    private zzb() {}
    
    protected final void onStatusChanged(Status paramStatus)
    {
      AccountTransferClient.addFavorite(zzaw, paramStatus);
    }
    
    protected abstract void readThis(Transaction paramTransaction)
      throws RemoteException;
    
    protected final void setResult(Object paramObject)
    {
      zzaw.setResult(paramObject);
    }
  }
  
  abstract class zzc
    extends com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb<Void>
  {
    GeocoderBackend.Stub zzax = new Chapter(this);
    
    private zzc()
    {
      super();
    }
  }
}

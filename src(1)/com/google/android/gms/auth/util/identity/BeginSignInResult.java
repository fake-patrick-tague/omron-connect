package com.google.android.gms.auth.util.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="BeginSignInResultCreator")
public final class BeginSignInResult
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.BeginSignInResult> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getPendingIntent", id=1)
  private final PendingIntent pendingIntent;
  
  public BeginSignInResult(PendingIntent paramPendingIntent)
  {
    pendingIntent = ((PendingIntent)Preconditions.checkNotNull(paramPendingIntent));
  }
  
  public PendingIntent getPendingIntent()
  {
    return pendingIntent;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getPendingIntent(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

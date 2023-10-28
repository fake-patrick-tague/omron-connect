package com.google.android.gms.auth.util.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="SavePasswordResultCreator")
public class SavePasswordResult
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.SavePasswordResult> CREATOR = new PaymentIntent.1();
  @SafeParcelable.Field(getter="getPendingIntent", id=1)
  private final PendingIntent result;
  
  public SavePasswordResult(PendingIntent paramPendingIntent)
  {
    result = ((PendingIntent)Preconditions.checkNotNull(paramPendingIntent));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SavePasswordResult)) {
      return false;
    }
    paramObject = (SavePasswordResult)paramObject;
    return Objects.equal(result, result);
  }
  
  public PendingIntent getPendingIntent()
  {
    return result;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { result });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getPendingIntent(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

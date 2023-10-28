package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="SessionStopResultCreator")
@SafeParcelable.Reserved({4, 1000})
public class SessionStopResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<SessionStopResult> CREATOR = new AccountMirakel.2();
  @SafeParcelable.Field(getter="getSessions", id=3)
  private final List<Session> zzqr;
  @SafeParcelable.Field(getter="getStatus", id=2)
  private final Status zzsv;
  
  public SessionStopResult(Status paramStatus, List paramList)
  {
    zzsv = paramStatus;
    zzqr = Collections.unmodifiableList(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SessionStopResult)) {
      return false;
    }
    paramObject = (SessionStopResult)paramObject;
    return (zzsv.equals(zzsv)) && (Objects.equal(zzqr, zzqr));
  }
  
  public List getSessions()
  {
    return zzqr;
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzqr });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("status", zzsv).name("sessions", zzqr).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, getSessions(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

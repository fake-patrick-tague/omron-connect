package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="GoogleCertificatesLookupResponseCreator")
public final class Task
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzq> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="getFirstPartyStatusValue", id=4)
  private final int id;
  @SafeParcelable.Field(getter="getResult", id=1)
  private final boolean mSupportsStatus;
  @SafeParcelable.Field(getter="getErrorMessage", id=2)
  private final String mTransportOutgoingFiletransferService;
  @SafeParcelable.Field(getter="getStatusValue", id=3)
  private final int state;
  
  Task(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    mSupportsStatus = paramBoolean;
    mTransportOutgoingFiletransferService = paramString;
    state = (OwnCloudVersion.compare(paramInt1) - 1);
    id = (Searcher.search(paramInt2) - 1);
  }
  
  public final int call()
  {
    return Searcher.search(id);
  }
  
  public final int compareTo()
  {
    return OwnCloudVersion.compare(state);
  }
  
  public final String getContent()
  {
    return mTransportOutgoingFiletransferService;
  }
  
  public final boolean isCancelled()
  {
    return mSupportsStatus;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, mSupportsStatus);
    SafeParcelWriter.writeString(paramParcel, 2, mTransportOutgoingFiletransferService, false);
    SafeParcelWriter.writeInt(paramParcel, 3, state);
    SafeParcelWriter.writeInt(paramParcel, 4, id);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

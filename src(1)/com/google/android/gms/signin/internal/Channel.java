package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;
import java.util.List;

@SafeParcelable.Class(creator="RecordConsentByConsentResultResponseCreator")
public final class Channel
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<zag> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getGrantedScopes", id=1)
  private final List<String> mArgString;
  @SafeParcelable.Field(getter="getToken", id=2)
  private final String mHelp;
  
  public Channel(List paramList, String paramString)
  {
    mArgString = paramList;
    mHelp = paramString;
  }
  
  public final Status getStatus()
  {
    if (mHelp != null) {
      return Status.RESULT_SUCCESS;
    }
    return Status.RESULT_CANCELED;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringList(paramParcel, 1, mArgString, false);
    SafeParcelWriter.writeString(paramParcel, 2, mHelp, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

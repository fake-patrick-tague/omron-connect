package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
@SafeParcelable.Class(creator="TelemetryDataCreator")
public class TelemetryData
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<TelemetryData> CREATOR = new zaab();
  @SafeParcelable.Field(getter="getMethodInvocations", id=2)
  private List<MethodInvocation> mPositions;
  @SafeParcelable.Field(getter="getTelemetryConfigVersion", id=1)
  private final int type;
  
  public TelemetryData(int paramInt, List paramList)
  {
    type = paramInt;
    mPositions = paramList;
  }
  
  public final List getPositions()
  {
    return mPositions;
  }
  
  public final int getType()
  {
    return type;
  }
  
  public final void startTransition(MethodInvocation paramMethodInvocation)
  {
    if (mPositions == null) {
      mPositions = new ArrayList();
    }
    mPositions.add(paramMethodInvocation);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, type);
    SafeParcelWriter.writeTypedList(paramParcel, 2, mPositions, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

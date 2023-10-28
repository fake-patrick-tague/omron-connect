package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;

@SafeParcelable.Class(creator="AuthAccountResultCreator")
public final class Action
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<zaa> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(getter="getRawAuthResolutionIntent", id=3)
  private Intent intent;
  @SafeParcelable.VersionField(id=1)
  final int size;
  @SafeParcelable.Field(getter="getConnectionResultCode", id=2)
  private int value;
  
  public Action()
  {
    this(2, 0, null);
  }
  
  Action(int paramInt1, int paramInt2, Intent paramIntent)
  {
    size = paramInt1;
    value = paramInt2;
    intent = paramIntent;
  }
  
  public final Status getStatus()
  {
    if (value == 0) {
      return Status.RESULT_SUCCESS;
    }
    return Status.RESULT_CANCELED;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, size);
    SafeParcelWriter.writeInt(paramParcel, 2, value);
    SafeParcelWriter.writeParcelable(paramParcel, 3, intent, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

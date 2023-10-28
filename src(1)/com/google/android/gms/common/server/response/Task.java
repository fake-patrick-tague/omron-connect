package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@ShowFirstParty
@SafeParcelable.Class(creator="FieldMapPairCreator")
public final class Task
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zam> CREATOR = new PaymentIntent.Output.1();
  @SafeParcelable.Field(id=2)
  final String id;
  @SafeParcelable.VersionField(id=1)
  final int state;
  @SafeParcelable.Field(id=3)
  final FastJsonResponse.Field<?, ?> url;
  
  Task(int paramInt, String paramString, FastJsonResponse.Field paramField)
  {
    state = paramInt;
    id = paramString;
    url = paramField;
  }
  
  Task(String paramString, FastJsonResponse.Field paramField)
  {
    state = 1;
    id = paramString;
    url = paramField;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, state);
    SafeParcelWriter.writeString(paramParcel, 2, id, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, url, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

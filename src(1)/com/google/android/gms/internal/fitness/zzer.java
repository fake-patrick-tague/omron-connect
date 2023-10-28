package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="FitnessDataSourcesRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzer
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzer> CREATOR = new zzeq();
  @SafeParcelable.Field(getter="getDataTypes", id=1)
  private final List<DataType> zzlf;
  
  public zzer(List paramList)
  {
    zzlf = paramList;
  }
  
  public final List getDataTypes()
  {
    return Collections.unmodifiableList(zzlf);
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("dataTypes", zzlf).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, Collections.unmodifiableList(zzlf), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

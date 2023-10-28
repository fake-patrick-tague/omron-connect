package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;

@SafeParcelable.Class(creator="EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzau
  extends AbstractSafeParcelable
  implements Iterable<String>
{
  public static final Parcelable.Creator<zzau> CREATOR = new zzav();
  @SafeParcelable.Field(getter="z", id=2)
  private final Bundle this$0;
  
  zzau(Bundle paramBundle)
  {
    this$0 = paramBundle;
  }
  
  public final Bundle get()
  {
    return new Bundle(this$0);
  }
  
  final Object get(String paramString)
  {
    return this$0.get(paramString);
  }
  
  final Double getDouble(String paramString)
  {
    return Double.valueOf(this$0.getDouble("value"));
  }
  
  public final int getSectionCount()
  {
    return this$0.size();
  }
  
  final String getString(String paramString)
  {
    return this$0.getString(paramString);
  }
  
  final Long getValue(String paramString)
  {
    return Long.valueOf(this$0.getLong("value"));
  }
  
  public final Iterator iterator()
  {
    return new zzat(this);
  }
  
  public final String toString()
  {
    return this$0.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, get(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="SessionDataSetCreator")
@SafeParcelable.Reserved({1000})
public final class zzae
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzae> CREATOR = new zzag();
  @SafeParcelable.Field(getter="getSession", id=1)
  private final Session zzky;
  @SafeParcelable.Field(getter="getDataSet", id=2)
  private final DataSet zzls;
  
  public zzae(Session paramSession, DataSet paramDataSet)
  {
    zzky = paramSession;
    zzls = paramDataSet;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzae)) {
      return false;
    }
    paramObject = (zzae)paramObject;
    return (Objects.equal(zzky, zzky)) && (Objects.equal(zzls, zzls));
  }
  
  public final DataSet getDataSet()
  {
    return zzls;
  }
  
  public final Session getSession()
  {
    return zzky;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzky, zzls });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("session", zzky).name("dataSet", zzls).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzky, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, zzls, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

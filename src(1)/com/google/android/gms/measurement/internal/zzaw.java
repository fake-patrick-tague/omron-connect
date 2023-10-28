package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaw
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaw> CREATOR = new zzax();
  @SafeParcelable.Field(id=4)
  public final String name;
  @SafeParcelable.Field(id=5)
  public final long size;
  @SafeParcelable.Field(id=3)
  public final zzau this$0;
  @SafeParcelable.Field(id=2)
  public final String type;
  
  zzaw(zzaw paramZzaw, long paramLong)
  {
    Preconditions.checkNotNull(paramZzaw);
    type = type;
    this$0 = this$0;
    name = name;
    size = paramLong;
  }
  
  public zzaw(String paramString1, zzau paramZzau, String paramString2, long paramLong)
  {
    type = paramString1;
    this$0 = paramZzau;
    name = paramString2;
    size = paramLong;
  }
  
  public final String toString()
  {
    String str1 = name;
    String str2 = type;
    String str3 = String.valueOf(this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("origin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",name=");
    localStringBuilder.append(str2);
    localStringBuilder.append(",params=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzax.writeValue(this, paramParcel, paramInt);
  }
}

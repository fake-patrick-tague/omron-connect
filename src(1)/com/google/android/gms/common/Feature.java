package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@KeepForSdk
@SafeParcelable.Class(creator="FeatureCreator")
public class Feature
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Feature> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.Field(defaultValue="-1", getter="getVersion", id=3)
  private final long author;
  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;
  @Deprecated
  @SafeParcelable.Field(getter="getOldVersion", id=2)
  private final int version;
  
  public Feature(String paramString, int paramInt, long paramLong)
  {
    name = paramString;
    version = paramInt;
    author = paramLong;
  }
  
  public Feature(String paramString, long paramLong)
  {
    name = paramString;
    author = paramLong;
    version = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Feature))
    {
      paramObject = (Feature)paramObject;
      if (((getName() != null) && (getName().equals(paramObject.getName()))) || ((getName() == null) && (paramObject.getName() == null) && (getVersion() == paramObject.getVersion()))) {
        return true;
      }
    }
    return false;
  }
  
  public String getName()
  {
    return name;
  }
  
  public long getVersion()
  {
    long l2 = author;
    long l1 = l2;
    if (l2 == -1L) {
      l1 = version;
    }
    return l1;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { getName(), Long.valueOf(getVersion()) });
  }
  
  public final String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    localToStringHelper.name("name", getName());
    localToStringHelper.name("version", Long.valueOf(getVersion()));
    return localToStringHelper.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, version);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

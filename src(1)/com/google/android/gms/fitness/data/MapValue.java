package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@ShowFirstParty
@SafeParcelable.Class(creator="MapValueCreator")
@SafeParcelable.Reserved({1000})
public class MapValue
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<MapValue> CREATOR = new AccountMirakel.2();
  @SafeParcelable.Field(getter="getFormat", id=1)
  private final int format;
  @SafeParcelable.Field(getter="getValue", id=2)
  private final float value;
  
  public MapValue(int paramInt, float paramFloat)
  {
    format = paramInt;
    value = paramFloat;
  }
  
  public static MapValue put(float paramFloat)
  {
    return new MapValue(2, paramFloat);
  }
  
  public final float asFloat()
  {
    boolean bool;
    if (format == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in float format");
    return value;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof MapValue)) {
      return false;
    }
    paramObject = (MapValue)paramObject;
    int i = format;
    if (i == format)
    {
      if (i != 2) {
        return value == value;
      }
      if (asFloat() == paramObject.asFloat()) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)value;
  }
  
  public String toString()
  {
    if (format != 2) {
      return "unknown";
    }
    return Float.toString(asFloat());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, format);
    SafeParcelWriter.writeFloat(paramParcel, 2, value);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

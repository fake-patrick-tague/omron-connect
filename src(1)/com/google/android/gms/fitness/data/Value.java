package com.google.android.gms.fitness.data;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.HexDumpUtils;
import com.google.android.gms.internal.fitness.zzko;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import v7.util.ArrayMap;

@SafeParcelable.Class(creator="ValueCreator")
@SafeParcelable.Reserved({1000})
public final class Value
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<Value> CREATOR = new zzal();
  @SafeParcelable.Field(getter="getFormat", id=1)
  private final int format;
  @SafeParcelable.Field(getter="getValue", id=3)
  private float value;
  @SafeParcelable.Field(getter="isSet", id=2)
  private boolean zzos;
  @SafeParcelable.Field(getter="getStringValue", id=4)
  private String zzot;
  @SafeParcelable.Field(getter="getMapValue", id=5, type="android.os.Bundle")
  private Map<String, MapValue> zzou;
  @SafeParcelable.Field(getter="getIntArrayValue", id=6)
  private int[] zzov;
  @SafeParcelable.Field(getter="getFloatArrayValue", id=7)
  private float[] zzow;
  @SafeParcelable.Field(getter="getBlob", id=8)
  private byte[] zzox;
  
  public Value(int paramInt)
  {
    this(paramInt, false, 0.0F, null, null, null, null, null);
  }
  
  Value(int paramInt, boolean paramBoolean, float paramFloat, String paramString, Bundle paramBundle, int[] paramArrayOfInt, float[] paramArrayOfFloat, byte[] paramArrayOfByte)
  {
    format = paramInt;
    zzos = paramBoolean;
    value = paramFloat;
    zzot = paramString;
    if (paramBundle == null)
    {
      paramString = null;
    }
    else
    {
      paramBundle.setClassLoader((ClassLoader)Preconditions.checkNotNull(MapValue.class.getClassLoader()));
      ArrayMap localArrayMap = new ArrayMap(paramBundle.size());
      Iterator localIterator = paramBundle.keySet().iterator();
      for (;;)
      {
        paramString = localArrayMap;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localArrayMap.put(paramString, (MapValue)Preconditions.checkNotNull((MapValue)paramBundle.getParcelable(paramString)));
      }
    }
    zzou = paramString;
    zzov = paramArrayOfInt;
    zzow = paramArrayOfFloat;
    zzox = paramArrayOfByte;
  }
  
  public final void add(Map paramMap)
  {
    boolean bool;
    if (format == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set a float map value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
    zzos = true;
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localHashMap.put((String)localEntry.getKey(), MapValue.put(((Float)localEntry.getValue()).floatValue()));
    }
    zzou = localHashMap;
  }
  
  public final String asActivity()
  {
    return zzko.getName(asInt());
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
  
  public final int asInt()
  {
    int i = format;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in int format");
    return Float.floatToRawIntBits(value);
  }
  
  public final String asString()
  {
    boolean bool;
    if (format == 3) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in string format");
    String str = zzot;
    if (str == null) {
      return "";
    }
    return str;
  }
  
  public final void clearKey(String paramString)
  {
    boolean bool;
    if (format == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
    Map localMap = zzou;
    if (localMap != null) {
      localMap.remove(paramString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Value)) {
      return false;
    }
    paramObject = (Value)paramObject;
    int i = format;
    if ((i == format) && (zzos == zzos))
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 6)
              {
                if (i != 7) {
                  return value == value;
                }
                return Arrays.equals(zzox, zzox);
              }
              return Arrays.equals(zzow, zzow);
            }
            return Arrays.equals(zzov, zzov);
          }
          return Objects.equal(zzou, zzou);
        }
        return Objects.equal(zzot, zzot);
      }
      if (asInt() == paramObject.asInt()) {
        return true;
      }
    }
    return false;
  }
  
  public final int getFormat()
  {
    return format;
  }
  
  public final Float getKeyValue(String paramString)
  {
    boolean bool;
    if (format == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Value is not in float map format");
    Map localMap = zzou;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      return Float.valueOf(((MapValue)zzou.get(paramString)).asFloat());
    }
    return null;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Float.valueOf(value), zzot, zzou, zzov, zzow, zzox });
  }
  
  public final boolean isSet()
  {
    return zzos;
  }
  
  public final void setActivity(String paramString)
  {
    setInt(zzko.findPosition(paramString));
  }
  
  public final void setFloat(float paramFloat)
  {
    boolean bool;
    if (format == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
    zzos = true;
    value = paramFloat;
  }
  
  public final void setInt(int paramInt)
  {
    boolean bool;
    if (format == 1) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
    zzos = true;
    value = Float.intBitsToFloat(paramInt);
  }
  
  public final void setKeyValue(String paramString, float paramFloat)
  {
    boolean bool;
    if (format == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
    zzos = true;
    if (zzou == null) {
      zzou = new HashMap();
    }
    zzou.put(paramString, MapValue.put(paramFloat));
  }
  
  public final void setString(String paramString)
  {
    boolean bool;
    if (format == 3) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
    zzos = true;
    zzot = paramString;
  }
  
  public final String toString()
  {
    if (!zzos) {
      return "unset";
    }
    Object localObject;
    switch (format)
    {
    default: 
      return "unknown";
    case 7: 
      localObject = zzox;
      if (localObject == null) {
        return "";
      }
      localObject = HexDumpUtils.dump((byte[])localObject, 0, localObject.length, false);
      if (localObject == null) {
        return "";
      }
      return localObject;
    case 6: 
      return Arrays.toString(zzow);
    case 5: 
      return Arrays.toString(zzov);
    case 4: 
      if (zzou == null) {
        return "";
      }
      return new TreeMap(zzou).toString();
    case 3: 
      localObject = zzot;
      if (localObject == null) {
        return "";
      }
      return localObject;
    case 2: 
      return Float.toString(value);
    }
    return Integer.toString(asInt());
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getFormat());
    SafeParcelWriter.writeBoolean(paramParcel, 2, isSet());
    SafeParcelWriter.writeFloat(paramParcel, 3, value);
    SafeParcelWriter.writeString(paramParcel, 4, zzot, false);
    Object localObject;
    if (zzou == null)
    {
      localObject = null;
    }
    else
    {
      Bundle localBundle = new Bundle(zzou.size());
      Iterator localIterator = zzou.entrySet().iterator();
      for (;;)
      {
        localObject = localBundle;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        localBundle.putParcelable((String)((Map.Entry)localObject).getKey(), (Parcelable)((Map.Entry)localObject).getValue());
      }
    }
    SafeParcelWriter.writeBundle(paramParcel, 5, (Bundle)localObject, false);
    SafeParcelWriter.writeIntArray(paramParcel, 6, zzov, false);
    SafeParcelWriter.writeFloatArray(paramParcel, 7, zzow, false);
    SafeParcelWriter.writeByteArray(paramParcel, 8, zzox, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

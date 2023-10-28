package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzkq.zzb.zzc;
import java.util.Locale;

@SafeParcelable.Class(creator="DataSourceCreator")
@SafeParcelable.Reserved({2, 7, 8, 1000})
public class DataSource
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  @ShowFirstParty
  public static final Parcelable.Creator<DataSource> CREATOR = new AddressAndLabel.1();
  @RecentlyNonNull
  public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
  public static final int TYPE_DERIVED = 1;
  public static final int TYPE_RAW = 0;
  private static final String zzlt;
  private static final String zzlu;
  @SafeParcelable.Field(getter="getType", id=3)
  private final int type;
  @SafeParcelable.Field(getter="getDataType", id=1)
  private final DataType zzkp;
  @SafeParcelable.Field(getter="getDevice", id=4)
  private final Device zzlv;
  @SafeParcelable.Field(getter="getApplication", id=5)
  private final Entry zzlw;
  @SafeParcelable.Field(getter="getStreamName", id=6)
  private final String zzlx;
  private final String zzly;
  
  static
  {
    String str = zzkq.zzb.zzc.zzake.name();
    Locale localLocale = Locale.ROOT;
    zzlt = str.toLowerCase(localLocale);
    zzlu = zzkq.zzb.zzc.zzakf.name().toLowerCase(localLocale);
  }
  
  private DataSource(Builder paramBuilder)
  {
    this(Builder.getAttributeValue(paramBuilder), Builder.getElementType(paramBuilder), Builder.getDevice(paramBuilder), Builder.current(paramBuilder), Builder.getSoundPath(paramBuilder));
  }
  
  public DataSource(DataType paramDataType, int paramInt, Device paramDevice, Entry paramEntry, String paramString)
  {
    zzkp = paramDataType;
    type = paramInt;
    zzlv = paramDevice;
    zzlw = paramEntry;
    zzlx = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(get(paramInt));
    localStringBuilder.append(":");
    localStringBuilder.append(paramDataType.getName());
    if (paramEntry != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(paramEntry.getPackageName());
    }
    if (paramDevice != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(paramDevice.getStreamIdentifier());
    }
    if (paramString != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(paramString);
    }
    zzly = localStringBuilder.toString();
  }
  
  public static DataSource extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataSource)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "vnd.google.fitness.data_source", CREATOR);
  }
  
  private static String get(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return zzlu;
      }
      return zzlu;
    }
    return zzlt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataSource)) {
      return false;
    }
    paramObject = (DataSource)paramObject;
    return zzly.equals(zzly);
  }
  
  public final Entry get()
  {
    return zzlw;
  }
  
  public String getAppPackageName()
  {
    Entry localEntry = zzlw;
    if (localEntry == null) {
      return null;
    }
    return localEntry.getPackageName();
  }
  
  public DataType getDataType()
  {
    return zzkp;
  }
  
  public Device getDevice()
  {
    return zzlv;
  }
  
  public String getStreamIdentifier()
  {
    return zzly;
  }
  
  public String getStreamName()
  {
    return zzlx;
  }
  
  public int getType()
  {
    return type;
  }
  
  public int hashCode()
  {
    return zzly.hashCode();
  }
  
  public final String toDebugString()
  {
    int i = type;
    String str1;
    if (i != 0)
    {
      if (i != 1) {
        str1 = "?";
      } else {
        str1 = "d";
      }
    }
    else {
      str1 = "r";
    }
    String str3 = zzkp.get();
    Object localObject1 = zzlw;
    String str2 = "";
    if (localObject1 == null)
    {
      localObject1 = "";
    }
    else if (((Entry)localObject1).equals(Entry.zzlb))
    {
      localObject1 = ":gms";
    }
    else
    {
      localObject1 = String.valueOf(zzlw.getPackageName());
      if (((String)localObject1).length() != 0) {
        localObject1 = ":".concat((String)localObject1);
      } else {
        localObject1 = new String(":");
      }
    }
    Object localObject2 = zzlv;
    if (localObject2 != null)
    {
      localObject2 = ((Device)localObject2).getModel();
      localObject3 = zzlv.getUid();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject2).length() + 2 + String.valueOf(localObject3).length());
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject3);
      localObject2 = localStringBuilder.toString();
    }
    else
    {
      localObject2 = "";
    }
    Object localObject3 = zzlx;
    if (localObject3 != null)
    {
      str2 = String.valueOf(localObject3);
      if (str2.length() != 0) {
        str2 = ":".concat(str2);
      } else {
        str2 = new String(":");
      }
    }
    localObject3 = new StringBuilder(str1.length() + 1 + String.valueOf(str3).length() + String.valueOf(localObject1).length() + String.valueOf(localObject2).length() + String.valueOf(str2).length());
    ((StringBuilder)localObject3).append(str1);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(str3);
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(str2);
    return ((StringBuilder)localObject3).toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DataSource{");
    localStringBuilder.append(get(type));
    if (zzlw != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(zzlw);
    }
    if (zzlv != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(zzlv);
    }
    if (zzlx != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(zzlx);
    }
    localStringBuilder.append(":");
    localStringBuilder.append(zzkp);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataType(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getType());
    SafeParcelWriter.writeParcelable(paramParcel, 4, getDevice(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, zzlw, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 6, getStreamName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static final class Builder
  {
    private int type = -1;
    private DataType zzkp;
    private Device zzlv;
    private Entry zzlw;
    private String zzlx = "";
    
    public Builder() {}
    
    public final DataSource build()
    {
      DataType localDataType = zzkp;
      boolean bool2 = true;
      boolean bool1;
      if (localDataType != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must set data type");
      if (type >= 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must set data source type");
      return new DataSource(this, null);
    }
    
    public final Builder setAppPackageName(Context paramContext)
    {
      return setAppPackageName(paramContext.getPackageName());
    }
    
    public final Builder setAppPackageName(String paramString)
    {
      zzlw = Entry.getEntry(paramString);
      return this;
    }
    
    public final Builder setDataType(DataType paramDataType)
    {
      zzkp = paramDataType;
      return this;
    }
    
    public final Builder setDevice(Device paramDevice)
    {
      zzlv = paramDevice;
      return this;
    }
    
    public final Builder setStreamName(String paramString)
    {
      boolean bool;
      if (paramString != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid stream name");
      zzlx = paramString;
      return this;
    }
    
    public final Builder setType(int paramInt)
    {
      type = paramInt;
      return this;
    }
  }
}

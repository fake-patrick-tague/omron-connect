package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

@SafeParcelable.Class(creator="ConverterWrapperCreator")
public final class Language
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zaa> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getStringToIntConverter", id=2)
  private final StringToIntConverter mIndex;
  @SafeParcelable.VersionField(id=1)
  final int mType;
  
  Language(int paramInt, StringToIntConverter paramStringToIntConverter)
  {
    mType = paramInt;
    mIndex = paramStringToIntConverter;
  }
  
  private Language(StringToIntConverter paramStringToIntConverter)
  {
    mType = 1;
    mIndex = paramStringToIntConverter;
  }
  
  public static Language fromString(FastJsonResponse.FieldConverter paramFieldConverter)
  {
    if ((paramFieldConverter instanceof StringToIntConverter)) {
      return new Language((StringToIntConverter)paramFieldConverter);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public final FastJsonResponse.FieldConverter getId()
  {
    StringToIntConverter localStringToIntConverter = mIndex;
    if (localStringToIntConverter != null) {
      return localStringToIntConverter;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mType);
    SafeParcelWriter.writeParcelable(paramParcel, 2, mIndex, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

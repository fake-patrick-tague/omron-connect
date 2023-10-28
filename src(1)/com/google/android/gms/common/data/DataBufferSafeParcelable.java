package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
public class DataBufferSafeParcelable<T extends SafeParcelable>
  extends AbstractDataBuffer<T>
{
  private static final String[] TYPE_NAMES = { "data" };
  private final Parcelable.Creator<T> dateType;
  
  public DataBufferSafeParcelable(DataHolder paramDataHolder, Parcelable.Creator paramCreator)
  {
    super(paramDataHolder);
    dateType = paramCreator;
  }
  
  public static void addValue(DataHolder.Builder paramBuilder, SafeParcelable paramSafeParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramSafeParcelable.writeToParcel(localParcel, 0);
    paramSafeParcelable = new ContentValues();
    paramSafeParcelable.put("data", localParcel.marshall());
    paramBuilder.withRow(paramSafeParcelable);
    localParcel.recycle();
  }
  
  public static DataHolder.Builder buildDataHolder()
  {
    return DataHolder.builder(TYPE_NAMES);
  }
  
  public SafeParcelable get(int paramInt)
  {
    Object localObject1 = (DataHolder)Preconditions.checkNotNull(mDataHolder);
    Object localObject2 = ((DataHolder)localObject1).getByteArray("data", paramInt, ((DataHolder)localObject1).getWindowIndex(paramInt));
    localObject1 = Parcel.obtain();
    ((Parcel)localObject1).unmarshall((byte[])localObject2, 0, localObject2.length);
    ((Parcel)localObject1).setDataPosition(0);
    localObject2 = (SafeParcelable)dateType.createFromParcel((Parcel)localObject1);
    ((Parcel)localObject1).recycle();
    return localObject2;
  }
}

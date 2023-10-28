package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@KeepForSdk
@VisibleForTesting
public final class SafeParcelableSerializer
{
  private SafeParcelableSerializer() {}
  
  public static SafeParcelable deserializeFromBytes(byte[] paramArrayOfByte, Parcelable.Creator paramCreator)
  {
    Preconditions.checkNotNull(paramCreator);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public static SafeParcelable deserializeFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator paramCreator)
  {
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    return deserializeFromBytes(paramIntent, paramCreator);
  }
  
  public static SafeParcelable deserializeFromString(String paramString, Parcelable.Creator paramCreator)
  {
    return deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
  }
  
  public static ArrayList deserializeIterableFromBundle(Bundle paramBundle, String paramString, Parcelable.Creator paramCreator)
  {
    paramBundle = (ArrayList)paramBundle.getSerializable(paramString);
    if (paramBundle == null) {
      return null;
    }
    paramString = new ArrayList(paramBundle.size());
    int j = paramBundle.size();
    int i = 0;
    while (i < j)
    {
      paramString.add(deserializeFromBytes((byte[])paramBundle.get(i), paramCreator));
      i += 1;
    }
    return paramString;
  }
  
  public static ArrayList deserializeIterableFromBundleSafe(Bundle paramBundle, String paramString, Parcelable.Creator paramCreator)
  {
    return deserializeIterableFromBytes(paramBundle.getByteArray(paramString), paramCreator);
  }
  
  public static ArrayList deserializeIterableFromBytes(byte[] paramArrayOfByte, Parcelable.Creator paramCreator)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = paramArrayOfByte.length;
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, i);
    localParcel.setDataPosition(0);
    try
    {
      paramArrayOfByte = new ArrayList();
      localParcel.readTypedList(paramArrayOfByte, paramCreator);
      localParcel.recycle();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      localParcel.recycle();
      throw paramArrayOfByte;
    }
  }
  
  public static ArrayList deserializeIterableFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator paramCreator)
  {
    paramIntent = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    paramString = new ArrayList(paramIntent.size());
    int j = paramIntent.size();
    int i = 0;
    while (i < j)
    {
      paramString.add(deserializeFromBytes((byte[])paramIntent.get(i), paramCreator));
      i += 1;
    }
    return paramString;
  }
  
  public static ArrayList deserializeIterableFromIntentExtraSafe(Intent paramIntent, String paramString, Parcelable.Creator paramCreator)
  {
    return deserializeIterableFromBytes(paramIntent.getByteArrayExtra(paramString), paramCreator);
  }
  
  private static byte[] marshall(Iterable paramIterable)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeTypedList(zzag.get(paramIterable));
      paramIterable = localParcel.marshall();
      localParcel.recycle();
      return paramIterable;
    }
    catch (Throwable paramIterable)
    {
      localParcel.recycle();
      throw paramIterable;
    }
  }
  
  public static void serializeIterableToBundle(Iterable paramIterable, Bundle paramBundle, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(serializeToBytes((SafeParcelable)paramIterable.next()));
    }
    paramBundle.putSerializable(paramString, localArrayList);
  }
  
  public static void serializeIterableToBundleSafe(Iterable paramIterable, Bundle paramBundle, String paramString)
  {
    paramBundle.putByteArray(paramString, marshall(paramIterable));
  }
  
  public static void serializeIterableToIntentExtra(Iterable paramIterable, Intent paramIntent, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(serializeToBytes((SafeParcelable)paramIterable.next()));
    }
    paramIntent.putExtra(paramString, localArrayList);
  }
  
  public static void serializeIterableToIntentExtraSafe(Iterable paramIterable, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, marshall(paramIterable));
  }
  
  public static byte[] serializeToBytes(SafeParcelable paramSafeParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramSafeParcelable.writeToParcel(localParcel, 0);
    paramSafeParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramSafeParcelable;
  }
  
  public static void serializeToIntentExtra(SafeParcelable paramSafeParcelable, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, serializeToBytes(paramSafeParcelable));
  }
  
  public static String serializeToString(SafeParcelable paramSafeParcelable)
  {
    return Base64Utils.encodeUrlSafe(serializeToBytes(paramSafeParcelable));
  }
}

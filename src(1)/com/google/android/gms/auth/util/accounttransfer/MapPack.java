package com.google.android.gms.auth.util.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Set;
import v7.util.TLongArrayList;

@SafeParcelable.Class(creator="AuthenticatorTransferInfoCreator")
public class MapPack
  extends zzaz
{
  public static final Parcelable.Creator<zzt> CREATOR = new DownloadProgressInfo.1();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;
  @SafeParcelable.VersionField(id=1)
  private final int mInputType;
  @SafeParcelable.Indicator
  private final Set<Integer> zzba;
  @SafeParcelable.Field(getter="getAccountType", id=2)
  private String zzbn;
  @SafeParcelable.Field(getter="getStatus", id=3)
  private int zzbo;
  @SafeParcelable.Field(getter="getTransferBytes", id=4)
  private byte[] zzbp;
  @SafeParcelable.Field(getter="getPendingIntent", id=5)
  private PendingIntent zzbq;
  @SafeParcelable.Field(getter="getDeviceMetaData", id=6)
  private DeviceMetaData zzbr;
  
  static
  {
    HashMap localHashMap = new HashMap();
    zzaz = localHashMap;
    localHashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
    localHashMap.put("status", FastJsonResponse.Field.forInteger("status", 3));
    localHashMap.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
  }
  
  public MapPack()
  {
    zzba = new TLongArrayList(3);
    mInputType = 1;
  }
  
  MapPack(Set paramSet, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, PendingIntent paramPendingIntent, DeviceMetaData paramDeviceMetaData)
  {
    zzba = paramSet;
    mInputType = paramInt1;
    zzbn = paramString;
    zzbo = paramInt2;
    zzbp = paramArrayOfByte;
    zzbq = paramPendingIntent;
    zzbr = paramDeviceMetaData;
  }
  
  protected Object getFieldValue(FastJsonResponse.Field paramField)
  {
    int i = paramField.getSafeParcelableFieldId();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return zzbp;
          }
          i = paramField.getSafeParcelableFieldId();
          paramField = new StringBuilder(37);
          paramField.append("Unknown SafeParcelable id=");
          paramField.append(i);
          throw new IllegalStateException(paramField.toString());
        }
        return Integer.valueOf(zzbo);
      }
      return zzbn;
    }
    return Integer.valueOf(mInputType);
  }
  
  protected boolean isFieldSet(FastJsonResponse.Field paramField)
  {
    return zzba.contains(Integer.valueOf(paramField.getSafeParcelableFieldId()));
  }
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field paramField, String paramString, byte[] paramArrayOfByte)
  {
    int i = paramField.getSafeParcelableFieldId();
    if (i == 4)
    {
      zzbp = paramArrayOfByte;
      zzba.add(Integer.valueOf(i));
      return;
    }
    paramField = new StringBuilder(59);
    paramField.append("Field with id=");
    paramField.append(i);
    paramField.append(" is not known to be an byte array.");
    throw new IllegalArgumentException(paramField.toString());
  }
  
  protected void setIntegerInternal(FastJsonResponse.Field paramField, String paramString, int paramInt)
  {
    int i = paramField.getSafeParcelableFieldId();
    if (i == 3)
    {
      zzbo = paramInt;
      zzba.add(Integer.valueOf(i));
      return;
    }
    paramField = new StringBuilder(52);
    paramField.append("Field with id=");
    paramField.append(i);
    paramField.append(" is not known to be an int.");
    throw new IllegalArgumentException(paramField.toString());
  }
  
  protected void setStringInternal(FastJsonResponse.Field paramField, String paramString1, String paramString2)
  {
    int i = paramField.getSafeParcelableFieldId();
    if (i == 2)
    {
      zzbn = paramString2;
      zzba.add(Integer.valueOf(i));
      return;
    }
    throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[] { Integer.valueOf(i) }));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    Set localSet = zzba;
    if (localSet.contains(Integer.valueOf(1))) {
      SafeParcelWriter.writeInt(paramParcel, 1, mInputType);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      SafeParcelWriter.writeString(paramParcel, 2, zzbn, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      SafeParcelWriter.writeInt(paramParcel, 3, zzbo);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      SafeParcelWriter.writeByteArray(paramParcel, 4, zzbp, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      SafeParcelWriter.writeParcelable(paramParcel, 5, zzbq, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      SafeParcelWriter.writeParcelable(paramParcel, 6, zzbr, paramInt, true);
    }
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

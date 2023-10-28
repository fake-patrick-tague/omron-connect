package com.google.android.gms.auth.util.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.auth.api.accounttransfer.zzr;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator="AccountTransferMsgCreator")
public final class VideoItem
  extends zzaz
{
  public static final Parcelable.Creator<zzl> CREATOR = new DiscreteSeekBar.CustomState.1();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;
  @SafeParcelable.VersionField(id=1)
  private final int mInputType;
  @SafeParcelable.Indicator
  private final Set<Integer> zzba;
  @SafeParcelable.Field(getter="getAuthenticatorDatas", id=2)
  private ArrayList<zzr> zzbb;
  @SafeParcelable.Field(getter="getRequestType", id=3)
  private int zzbc;
  @SafeParcelable.Field(getter="getProgress", id=4)
  private MapFile zzbd;
  
  static
  {
    HashMap localHashMap = new HashMap();
    zzaz = localHashMap;
    localHashMap.put("authenticatorData", FastJsonResponse.Field.forConcreteTypeArray("authenticatorData", 2, zzr.class));
    localHashMap.put("progress", FastJsonResponse.Field.forConcreteType("progress", 4, zzo.class));
  }
  
  public VideoItem()
  {
    zzba = new HashSet(1);
    mInputType = 1;
  }
  
  VideoItem(Set paramSet, int paramInt1, ArrayList paramArrayList, int paramInt2, MapFile paramMapFile)
  {
    zzba = paramSet;
    mInputType = paramInt1;
    zzbb = paramArrayList;
    zzbc = paramInt2;
    zzbd = paramMapFile;
  }
  
  public final void addConcreteTypeArrayInternal(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    int i = paramField.getSafeParcelableFieldId();
    if (i == 2)
    {
      zzbb = paramArrayList;
      zzba.add(Integer.valueOf(i));
      return;
    }
    throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", new Object[] { Integer.valueOf(i), paramArrayList.getClass().getCanonicalName() }));
  }
  
  public final void addConcreteTypeInternal(FastJsonResponse.Field paramField, String paramString, FastJsonResponse paramFastJsonResponse)
  {
    int i = paramField.getSafeParcelableFieldId();
    if (i == 4)
    {
      zzbd = ((MapFile)paramFastJsonResponse);
      zzba.add(Integer.valueOf(i));
      return;
    }
    throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[] { Integer.valueOf(i), paramFastJsonResponse.getClass().getCanonicalName() }));
  }
  
  protected final Object getFieldValue(FastJsonResponse.Field paramField)
  {
    int i = paramField.getSafeParcelableFieldId();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 4) {
          return zzbd;
        }
        i = paramField.getSafeParcelableFieldId();
        paramField = new StringBuilder(37);
        paramField.append("Unknown SafeParcelable id=");
        paramField.append(i);
        throw new IllegalStateException(paramField.toString());
      }
      return zzbb;
    }
    return Integer.valueOf(mInputType);
  }
  
  protected final boolean isFieldSet(FastJsonResponse.Field paramField)
  {
    return zzba.contains(Integer.valueOf(paramField.getSafeParcelableFieldId()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    Set localSet = zzba;
    if (localSet.contains(Integer.valueOf(1))) {
      SafeParcelWriter.writeInt(paramParcel, 1, mInputType);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      SafeParcelWriter.writeTypedList(paramParcel, 2, zzbb, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      SafeParcelWriter.writeInt(paramParcel, 3, zzbc);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      SafeParcelWriter.writeParcelable(paramParcel, 4, zzbd, paramInt, true);
    }
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

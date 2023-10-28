package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@KeepForSdk
@SafeParcelable.Class(creator="StringToIntConverterCreator")
public final class StringToIntConverter
  extends AbstractSafeParcelable
  implements FastJsonResponse.FieldConverter<String, Integer>
{
  public static final Parcelable.Creator<StringToIntConverter> CREATOR = new VerticalProgressBar.SavedState.1();
  private final HashMap<String, Integer> attrs;
  private final SparseArray<String> children;
  @SafeParcelable.VersionField(id=1)
  final int name;
  
  public StringToIntConverter()
  {
    name = 1;
    attrs = new HashMap();
    children = new SparseArray();
  }
  
  StringToIntConverter(int paramInt, ArrayList paramArrayList)
  {
    name = paramInt;
    attrs = new HashMap();
    children = new SparseArray();
    int i = paramArrayList.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Album localAlbum = (Album)paramArrayList.get(paramInt);
      put(mName, mIcon);
      paramInt += 1;
    }
  }
  
  public final int classMetadataIdForName()
  {
    return 0;
  }
  
  public final int getFieldCount()
  {
    return 7;
  }
  
  public StringToIntConverter put(String paramString, int paramInt)
  {
    attrs.put(paramString, Integer.valueOf(paramInt));
    children.put(paramInt, paramString);
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, name);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = attrs.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Album(str, ((Integer)attrs.get(str)).intValue()));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

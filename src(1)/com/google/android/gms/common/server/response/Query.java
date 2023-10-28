package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@SafeParcelable.Class(creator="FieldMappingDictionaryEntryCreator")
public final class Query
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zal> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(id=3)
  final ArrayList<zam> content;
  @SafeParcelable.VersionField(id=1)
  final int count;
  @SafeParcelable.Field(id=2)
  final String name;
  
  Query(int paramInt, String paramString, ArrayList paramArrayList)
  {
    count = paramInt;
    name = paramString;
    content = paramArrayList;
  }
  
  Query(String paramString, Map paramMap)
  {
    count = 1;
    name = paramString;
    if (paramMap == null)
    {
      paramString = null;
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localArrayList.add(new Task(paramString, (FastJsonResponse.Field)paramMap.get(paramString)));
      }
    }
    content = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, count);
    SafeParcelWriter.writeString(paramParcel, 2, name, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, content, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

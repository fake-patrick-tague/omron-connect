package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@SafeParcelable.Class(creator="FieldMappingDictionaryCreator")
public final class Message
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zan> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="getRootClassName", id=3)
  private final String size;
  @SafeParcelable.VersionField(id=1)
  final int type;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> values;
  
  Message(int paramInt, ArrayList paramArrayList, String paramString)
  {
    type = paramInt;
    HashMap localHashMap1 = new HashMap();
    int j = paramArrayList.size();
    paramInt = 0;
    while (paramInt < j)
    {
      Query localQuery = (Query)paramArrayList.get(paramInt);
      String str = name;
      HashMap localHashMap2 = new HashMap();
      int k = ((ArrayList)Preconditions.checkNotNull(content)).size();
      int i = 0;
      while (i < k)
      {
        Task localTask = (Task)content.get(i);
        localHashMap2.put(id, url);
        i += 1;
      }
      localHashMap1.put(str, localHashMap2);
      paramInt += 1;
    }
    values = localHashMap1;
    size = ((String)Preconditions.checkNotNull(paramString));
    clear();
  }
  
  public Message(Class paramClass)
  {
    type = 1;
    values = new HashMap();
    size = ((String)Preconditions.checkNotNull(paramClass.getCanonicalName()));
  }
  
  public final void add()
  {
    Iterator localIterator1 = values.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Map localMap = (Map)values.get(str1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap.put(str2, ((FastJsonResponse.Field)localMap.get(str2)).equals());
      }
      values.put(str1, localHashMap);
    }
  }
  
  public final void add(Class paramClass, Map paramMap)
  {
    values.put((String)Preconditions.checkNotNull(paramClass.getCanonicalName()), paramMap);
  }
  
  public final void clear()
  {
    Iterator localIterator1 = values.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)values.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((FastJsonResponse.Field)((Map)localObject).get((String)localIterator2.next())).write(this);
      }
    }
  }
  
  public final boolean contains(Class paramClass)
  {
    return values.containsKey(Preconditions.checkNotNull(paramClass.getCanonicalName()));
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = values.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(":\n");
      localObject = (Map)values.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ");
        localStringBuilder.append(str);
        localStringBuilder.append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public final Map toString(String paramString)
  {
    return (Map)values.get(paramString);
  }
  
  public final String toXML()
  {
    return size;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, type);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = values.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Query(str, (Map)values.get(str)));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.writeString(paramParcel, 3, size, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}

package com.google.android.gms.common.server.response;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdk
@SafeParcelable.Class(creator="SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse
  extends FastSafeParcelableJsonResponse
{
  @KeepForSdk
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getFieldMappingDictionary", id=3)
  private final Message added;
  @SafeParcelable.Field(getter="getParcel", id=2)
  private final Parcel data;
  private final int deleted;
  @SafeParcelable.VersionField(getter="getVersionCode", id=1)
  private final int id;
  private int m;
  private int n;
  private final String updated;
  
  SafeParcelResponse(int paramInt, Parcel paramParcel, Message paramMessage)
  {
    id = paramInt;
    data = ((Parcel)Preconditions.checkNotNull(paramParcel));
    deleted = 2;
    added = paramMessage;
    if (paramMessage == null) {
      paramParcel = null;
    } else {
      paramParcel = paramMessage.toXML();
    }
    updated = paramParcel;
    m = 2;
  }
  
  private SafeParcelResponse(SafeParcelable paramSafeParcelable, Message paramMessage, String paramString)
  {
    id = 1;
    Parcel localParcel = Parcel.obtain();
    data = localParcel;
    paramSafeParcelable.writeToParcel(localParcel, 0);
    deleted = 1;
    added = ((Message)Preconditions.checkNotNull(paramMessage));
    updated = ((String)Preconditions.checkNotNull(paramString));
    m = 2;
  }
  
  public SafeParcelResponse(Message paramMessage, String paramString)
  {
    id = 1;
    data = Parcel.obtain();
    deleted = 0;
    added = ((Message)Preconditions.checkNotNull(paramMessage));
    updated = ((String)Preconditions.checkNotNull(paramString));
    m = 0;
  }
  
  private final void append(FastJsonResponse.Field paramField)
  {
    if (n != -1)
    {
      paramField = data;
      if (paramField != null)
      {
        int i = m;
        if (i != 0)
        {
          if (i == 1) {
            return;
          }
          throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
        }
        n = SafeParcelWriter.beginObjectHeader(paramField);
        m = 1;
        return;
      }
      throw new IllegalStateException("Internal Parcel object is null.");
    }
    throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
  }
  
  private static void apply(Message paramMessage, FastJsonResponse paramFastJsonResponse)
  {
    Object localObject1 = paramFastJsonResponse.getClass();
    if (!paramMessage.contains((Class)localObject1))
    {
      Map localMap = paramFastJsonResponse.getFieldMappings();
      paramMessage.add((Class)localObject1, localMap);
      localObject1 = localMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramFastJsonResponse = (FastJsonResponse.Field)localMap.get((String)((Iterator)localObject1).next());
        Object localObject2 = type;
        if (localObject2 != null) {
          try
          {
            localObject2 = ((Class)localObject2).newInstance();
            localObject2 = (FastJsonResponse)localObject2;
            apply(paramMessage, (FastJsonResponse)localObject2);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            paramMessage = String.valueOf(((Class)Preconditions.checkNotNull(type)).getCanonicalName());
            if (paramMessage.length() != 0) {
              paramMessage = "Could not access object of type ".concat(paramMessage);
            } else {
              paramMessage = new String("Could not access object of type ");
            }
            throw new IllegalStateException(paramMessage, localIllegalAccessException);
          }
          catch (InstantiationException localInstantiationException)
          {
            paramMessage = String.valueOf(((Class)Preconditions.checkNotNull(type)).getCanonicalName());
            if (paramMessage.length() != 0) {
              paramMessage = "Could not instantiate an object of type ".concat(paramMessage);
            } else {
              paramMessage = new String("Could not instantiate an object of type ");
            }
            throw new IllegalStateException(paramMessage, localInstantiationException);
          }
        }
      }
    }
  }
  
  public static SafeParcelResponse from(FastJsonResponse paramFastJsonResponse)
  {
    String str = (String)Preconditions.checkNotNull(paramFastJsonResponse.getClass().getCanonicalName());
    Message localMessage = new Message(paramFastJsonResponse.getClass());
    apply(localMessage, paramFastJsonResponse);
    localMessage.add();
    localMessage.clear();
    return new SafeParcelResponse((SafeParcelable)paramFastJsonResponse, localMessage, str);
  }
  
  private static final void parse(StringBuilder paramStringBuilder, FastJsonResponse.Field paramField, Object paramObject)
  {
    if (this$0)
    {
      paramObject = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int j = paramObject.size();
      int i = 0;
      while (i < j)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        set(paramStringBuilder, size, paramObject.get(i));
        i += 1;
      }
      paramStringBuilder.append("]");
      return;
    }
    set(paramStringBuilder, size, paramObject);
  }
  
  private static final void set(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      paramStringBuilder = new StringBuilder(26);
      paramStringBuilder.append("Unknown type = ");
      paramStringBuilder.append(paramInt);
      throw new IllegalArgumentException(paramStringBuilder.toString());
    case 11: 
      throw new IllegalArgumentException("Method does not accept concrete type.");
    case 10: 
      MapUtils.writeStringMapToJson(paramStringBuilder, (HashMap)Preconditions.checkNotNull(paramObject));
      return;
    case 9: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(Base64Utils.encodeUrlSafe((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(Base64Utils.encode((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 7: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(JsonUtils.escapeString(Preconditions.checkNotNull(paramObject).toString()));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private final void write(StringBuilder paramStringBuilder, Map paramMap, Parcel paramParcel)
  {
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    Object localObject1;
    while (paramMap.hasNext())
    {
      localObject1 = (Map.Entry)paramMap.next();
      localSparseArray.put(((FastJsonResponse.Field)((Map.Entry)localObject1).getValue()).getSafeParcelableFieldId(), localObject1);
    }
    paramStringBuilder.append('{');
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      paramMap = (Map.Entry)localSparseArray.get(SafeParcelReader.getFieldId(k));
      if (paramMap != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        localObject1 = (String)paramMap.getKey();
        paramMap = (FastJsonResponse.Field)paramMap.getValue();
        paramStringBuilder.append("\"");
        paramStringBuilder.append((String)localObject1);
        paramStringBuilder.append("\":");
        Object localObject2;
        if (paramMap.isBufferFull())
        {
          i = length;
          switch (i)
          {
          default: 
            paramStringBuilder = new StringBuilder(36);
            paramStringBuilder.append("Unknown field out type = ");
            paramStringBuilder.append(i);
            throw new IllegalArgumentException(paramStringBuilder.toString());
          case 11: 
            throw new IllegalArgumentException("Method does not accept concrete type.");
          case 10: 
            localObject1 = SafeParcelReader.createBundle(paramParcel, k);
            localObject2 = new HashMap();
            Iterator localIterator = ((BaseBundle)localObject1).keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ((HashMap)localObject2).put(str, (String)Preconditions.checkNotNull(((BaseBundle)localObject1).getString(str)));
            }
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, localObject2));
            break;
          case 8: 
          case 9: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, SafeParcelReader.createByteArray(paramParcel, k)));
            break;
          case 7: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, SafeParcelReader.createString(paramParcel, k)));
            break;
          case 6: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, Boolean.valueOf(SafeParcelReader.readBoolean(paramParcel, k))));
            break;
          case 5: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, SafeParcelReader.createBigDecimal(paramParcel, k)));
            break;
          case 4: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, Double.valueOf(SafeParcelReader.readDouble(paramParcel, k))));
            break;
          case 3: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, Float.valueOf(SafeParcelReader.readFloat(paramParcel, k))));
            break;
          case 2: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, Long.valueOf(SafeParcelReader.readLong(paramParcel, k))));
            break;
          case 1: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, SafeParcelReader.createBigInteger(paramParcel, k)));
            break;
          case 0: 
            parse(paramStringBuilder, paramMap, FastJsonResponse.get(paramMap, Integer.valueOf(SafeParcelReader.readInt(paramParcel, k))));
          }
        }
        for (;;)
        {
          i = 1;
          break;
          if (id)
          {
            paramStringBuilder.append("[");
            switch (length)
            {
            default: 
              throw new IllegalStateException("Unknown field type out.");
            case 11: 
              localObject1 = SafeParcelReader.createParcelArray(paramParcel, k);
              k = localObject1.length;
              i = 0;
            }
            while (i < k)
            {
              if (i > 0) {
                paramStringBuilder.append(",");
              }
              localObject1[i].setDataPosition(0);
              write(paramStringBuilder, paramMap.add(), localObject1[i]);
              i += 1;
              continue;
              throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
              ArrayUtils.writeStringArray(paramStringBuilder, SafeParcelReader.createStringArray(paramParcel, k));
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBooleanArray(paramParcel, k));
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigDecimalArray(paramParcel, k));
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createDoubleArray(paramParcel, k));
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createFloatArray(paramParcel, k));
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createLongArray(paramParcel, k));
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigIntegerArray(paramParcel, k));
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createIntArray(paramParcel, k));
            }
            paramStringBuilder.append("]");
          }
          else
          {
            switch (length)
            {
            default: 
              throw new IllegalStateException("Unknown field type out");
            case 11: 
              localObject1 = SafeParcelReader.createParcel(paramParcel, k);
              ((Parcel)localObject1).setDataPosition(0);
              write(paramStringBuilder, paramMap.add(), (Parcel)localObject1);
              break;
            case 10: 
              paramMap = SafeParcelReader.createBundle(paramParcel, k);
              localObject1 = paramMap.keySet();
              paramStringBuilder.append("{");
              localObject1 = ((Set)localObject1).iterator();
              for (i = 1; ((Iterator)localObject1).hasNext(); i = 0)
              {
                localObject2 = (String)((Iterator)localObject1).next();
                if (i == 0) {
                  paramStringBuilder.append(",");
                }
                paramStringBuilder.append("\"");
                paramStringBuilder.append((String)localObject2);
                paramStringBuilder.append("\":\"");
                paramStringBuilder.append(JsonUtils.escapeString(paramMap.getString((String)localObject2)));
                paramStringBuilder.append("\"");
              }
              paramStringBuilder.append("}");
              break;
            case 9: 
              paramMap = SafeParcelReader.createByteArray(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(Base64Utils.encodeUrlSafe(paramMap));
              paramStringBuilder.append("\"");
              break;
            case 8: 
              paramMap = SafeParcelReader.createByteArray(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(Base64Utils.encode(paramMap));
              paramStringBuilder.append("\"");
              break;
            case 7: 
              paramMap = SafeParcelReader.createString(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(JsonUtils.escapeString(paramMap));
              paramStringBuilder.append("\"");
              break;
            case 6: 
              paramStringBuilder.append(SafeParcelReader.readBoolean(paramParcel, k));
              break;
            case 5: 
              paramStringBuilder.append(SafeParcelReader.createBigDecimal(paramParcel, k));
              break;
            case 4: 
              paramStringBuilder.append(SafeParcelReader.readDouble(paramParcel, k));
              break;
            case 3: 
              paramStringBuilder.append(SafeParcelReader.readFloat(paramParcel, k));
              break;
            case 2: 
              paramStringBuilder.append(SafeParcelReader.readLong(paramParcel, k));
              break;
            case 1: 
              paramStringBuilder.append(SafeParcelReader.createBigInteger(paramParcel, k));
              break;
            case 0: 
              paramStringBuilder.append(SafeParcelReader.readInt(paramParcel, k));
            }
          }
        }
      }
    }
    if (paramParcel.dataPosition() == j)
    {
      paramStringBuilder.append('}');
      return;
    }
    paramStringBuilder = new StringBuilder(37);
    paramStringBuilder.append("Overread allowed size end=");
    paramStringBuilder.append(j);
    throw new SafeParcelReader.ParseException(paramStringBuilder.toString(), paramParcel);
  }
  
  protected final void add(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new float[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Float)paramArrayList.get(i)).floatValue();
      i += 1;
    }
    SafeParcelWriter.writeFloatArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void addAll(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new double[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Double)paramArrayList.get(i)).doubleValue();
      i += 1;
    }
    SafeParcelWriter.writeDoubleArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public final void addConcreteTypeArrayInternal(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    paramString = new ArrayList();
    ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramString.add(((SafeParcelResponse)paramArrayList.get(i)).doFinal());
      i += 1;
    }
    SafeParcelWriter.writeParcelList(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public final void addConcreteTypeInternal(FastJsonResponse.Field paramField, String paramString, FastJsonResponse paramFastJsonResponse)
  {
    append(paramField);
    paramString = ((SafeParcelResponse)paramFastJsonResponse).doFinal();
    SafeParcelWriter.writeParcel(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public final Parcel doFinal()
  {
    int i = m;
    if (i != 0)
    {
      if (i == 1)
      {
        SafeParcelWriter.finishObjectHeader(data, n);
        m = 2;
      }
    }
    else
    {
      i = SafeParcelWriter.beginObjectHeader(data);
      n = i;
      SafeParcelWriter.finishObjectHeader(data, i);
      m = 2;
    }
    return data;
  }
  
  public final Map getFieldMappings()
  {
    Message localMessage = added;
    if (localMessage == null) {
      return null;
    }
    return localMessage.toString((String)Preconditions.checkNotNull(updated));
  }
  
  public final Object getValueObject(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public final boolean isPrimitiveFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected final void parse(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new BigDecimal[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigDecimal)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeBigDecimalArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void put(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new long[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Long)paramArrayList.get(i)).longValue();
      i += 1;
    }
    SafeParcelWriter.writeLongArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void putAll(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new int[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Integer)paramArrayList.get(i)).intValue();
      i += 1;
    }
    SafeParcelWriter.writeIntArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void read(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new BigInteger[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigInteger)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeBigIntegerArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void setBooleanInternal(FastJsonResponse.Field paramField, String paramString, boolean paramBoolean)
  {
    append(paramField);
    SafeParcelWriter.writeBoolean(data, paramField.getSafeParcelableFieldId(), paramBoolean);
  }
  
  protected final void setData(FastJsonResponse.Field paramField, String paramString, BigDecimal paramBigDecimal)
  {
    append(paramField);
    SafeParcelWriter.writeBigDecimal(data, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
  }
  
  protected final void setDecodedBytesInternal(FastJsonResponse.Field paramField, String paramString, byte[] paramArrayOfByte)
  {
    append(paramField);
    SafeParcelWriter.writeByteArray(data, paramField.getSafeParcelableFieldId(), paramArrayOfByte, true);
  }
  
  protected final void setIntegerInternal(FastJsonResponse.Field paramField, String paramString, int paramInt)
  {
    append(paramField);
    SafeParcelWriter.writeInt(data, paramField.getSafeParcelableFieldId(), paramInt);
  }
  
  protected final void setLongInternal(FastJsonResponse.Field paramField, String paramString, long paramLong)
  {
    append(paramField);
    SafeParcelWriter.writeLong(data, paramField.getSafeParcelableFieldId(), paramLong);
  }
  
  protected final void setStringInternal(FastJsonResponse.Field paramField, String paramString1, String paramString2)
  {
    append(paramField);
    SafeParcelWriter.writeString(data, paramField.getSafeParcelableFieldId(), paramString2, true);
  }
  
  protected final void setStringMapInternal(FastJsonResponse.Field paramField, String paramString, Map paramMap)
  {
    append(paramField);
    paramString = new Bundle();
    Iterator localIterator = ((Map)Preconditions.checkNotNull(paramMap)).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.putString(str, (String)paramMap.get(str));
    }
    SafeParcelWriter.writeBundle(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void setStringsInternal(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((String)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeStringArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void toArray(FastJsonResponse.Field paramField, String paramString, ArrayList paramArrayList)
  {
    append(paramField);
    int j = ((ArrayList)Preconditions.checkNotNull(paramArrayList)).size();
    paramString = new boolean[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Boolean)paramArrayList.get(i)).booleanValue();
      i += 1;
    }
    SafeParcelWriter.writeBooleanArray(data, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public final String toString()
  {
    Preconditions.checkNotNull(added, "Cannot convert to JSON on client side.");
    Parcel localParcel = doFinal();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    write(localStringBuilder, (Map)Preconditions.checkNotNull(added.toString((String)Preconditions.checkNotNull(updated))), localParcel);
    return localStringBuilder.toString();
  }
  
  protected final void write(FastJsonResponse.Field paramField, String paramString, double paramDouble)
  {
    append(paramField);
    SafeParcelWriter.writeDouble(data, paramField.getSafeParcelableFieldId(), paramDouble);
  }
  
  protected final void write(FastJsonResponse.Field paramField, String paramString, BigInteger paramBigInteger)
  {
    append(paramField);
    SafeParcelWriter.writeBigInteger(data, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, id);
    SafeParcelWriter.writeParcel(paramParcel, 2, doFinal(), false);
    int j = deleted;
    Message localMessage;
    if (j != 0)
    {
      if (j != 1) {
        localMessage = added;
      } else {
        localMessage = added;
      }
    }
    else {
      localMessage = null;
    }
    SafeParcelWriter.writeParcelable(paramParcel, 3, localMessage, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  protected final void writeValue(FastJsonResponse.Field paramField, String paramString, float paramFloat)
  {
    append(paramField);
    SafeParcelWriter.writeFloat(data, paramField.getSafeParcelableFieldId(), paramFloat);
  }
}

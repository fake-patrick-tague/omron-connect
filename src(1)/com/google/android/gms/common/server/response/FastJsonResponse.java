package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.converter.Language;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@KeepForSdk
@ShowFirstParty
public abstract class FastJsonResponse
{
  public FastJsonResponse() {}
  
  private static final void configureRequest(String paramString)
  {
    if (Log.isLoggable("FastJsonResponse", 6))
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 58);
      localStringBuilder.append("Output field (");
      localStringBuilder.append(paramString);
      localStringBuilder.append(") has a null value, but expected a primitive");
      Log.e("FastJsonResponse", localStringBuilder.toString());
    }
  }
  
  protected static final Object get(Field paramField, Object paramObject)
  {
    Object localObject = paramObject;
    if (Field.toString(paramField) != null) {
      localObject = paramField.get(paramObject);
    }
    return localObject;
  }
  
  private static final void set(StringBuilder paramStringBuilder, Field paramField, Object paramObject)
  {
    int i = size;
    if (i != 11)
    {
      if (i == 7)
      {
        paramStringBuilder.append("\"");
        paramStringBuilder.append(JsonUtils.escapeString((String)paramObject));
        paramStringBuilder.append("\"");
        return;
      }
      paramStringBuilder.append(paramObject);
      return;
    }
    paramField = type;
    Preconditions.checkNotNull(paramField);
    paramStringBuilder.append(((FastJsonResponse)paramField.cast(paramObject)).toString());
  }
  
  private final void write(Field paramField, Object paramObject)
  {
    String str = data;
    paramObject = paramField.next(paramObject);
    int i = length;
    switch (i)
    {
    default: 
      break;
    case 3: 
      paramField = new StringBuilder(44);
      paramField.append("Unsupported type for conversion: ");
      paramField.append(i);
      throw new IllegalStateException(paramField.toString());
    case 8: 
    case 9: 
      if (paramObject != null)
      {
        setDecodedBytesInternal(paramField, str, (byte[])paramObject);
        return;
      }
      configureRequest(str);
      return;
    case 7: 
      setStringInternal(paramField, str, (String)paramObject);
      return;
    case 6: 
      if (paramObject != null)
      {
        setBooleanInternal(paramField, str, ((Boolean)paramObject).booleanValue());
        return;
      }
      configureRequest(str);
      return;
    case 5: 
      setData(paramField, str, (BigDecimal)paramObject);
      return;
    case 4: 
      if (paramObject != null)
      {
        write(paramField, str, ((Double)paramObject).doubleValue());
        return;
      }
      configureRequest(str);
      return;
    case 2: 
      if (paramObject != null)
      {
        setLongInternal(paramField, str, ((Long)paramObject).longValue());
        return;
      }
      configureRequest(str);
      return;
    case 1: 
      write(paramField, str, (BigInteger)paramObject);
      return;
    }
    if (paramObject != null)
    {
      setIntegerInternal(paramField, str, ((Integer)paramObject).intValue());
      return;
    }
    configureRequest(str);
  }
  
  protected void add(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("Float list not supported");
  }
  
  protected void addAll(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("Double list not supported");
  }
  
  public void addConcreteTypeArrayInternal(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("Concrete type array not supported");
  }
  
  public void addConcreteTypeInternal(Field paramField, String paramString, FastJsonResponse paramFastJsonResponse)
  {
    throw new UnsupportedOperationException("Concrete type not supported");
  }
  
  public final void append(Field paramField, float paramFloat)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, Float.valueOf(paramFloat));
      return;
    }
    writeValue(paramField, data, paramFloat);
  }
  
  public final void append(Field paramField, int paramInt)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, Integer.valueOf(paramInt));
      return;
    }
    setIntegerInternal(paramField, data, paramInt);
  }
  
  public final void append(Field paramField, BigInteger paramBigInteger)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramBigInteger);
      return;
    }
    write(paramField, data, paramBigInteger);
  }
  
  public final void append(Field paramField, byte[] paramArrayOfByte)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayOfByte);
      return;
    }
    setDecodedBytesInternal(paramField, data, paramArrayOfByte);
  }
  
  public final void copyTo(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    addAll(paramField, data, paramArrayList);
  }
  
  public final void endElement(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    parse(paramField, data, paramArrayList);
  }
  
  public abstract Map getFieldMappings();
  
  protected Object getFieldValue(Field paramField)
  {
    Object localObject = data;
    if (type != null)
    {
      boolean bool;
      if (getValueObject((String)localObject) == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Concrete field shouldn't be value object: %s", new Object[] { data });
      try
      {
        char c = Character.toUpperCase(((String)localObject).charAt(0));
        localObject = ((String)localObject).substring(1);
        int i = String.valueOf(localObject).length();
        paramField = new StringBuilder(i + 4);
        paramField.append("get");
        paramField.append(c);
        paramField.append((String)localObject);
        localObject = getClass();
        paramField = paramField.toString();
        paramField = ((Class)localObject).getMethod(paramField, new Class[0]);
        paramField = paramField.invoke(this, new Object[0]);
        return paramField;
      }
      catch (Exception paramField)
      {
        throw new RuntimeException(paramField);
      }
    }
    return getValueObject((String)localObject);
  }
  
  protected abstract Object getValueObject(String paramString);
  
  public final void handleData(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    putAll(paramField, data, paramArrayList);
  }
  
  protected boolean isFieldSet(Field paramField)
  {
    if (length == 11)
    {
      if (id) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
      }
      throw new UnsupportedOperationException("Concrete types not supported");
    }
    return isPrimitiveFieldSet(data);
  }
  
  protected abstract boolean isPrimitiveFieldSet(String paramString);
  
  public final void operate(Field paramField, String paramString)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramString);
      return;
    }
    setStringInternal(paramField, data, paramString);
  }
  
  public final void operate(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    add(paramField, data, paramArrayList);
  }
  
  protected void parse(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("BigDecimal list not supported");
  }
  
  public final void performDownload(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    read(paramField, data, paramArrayList);
  }
  
  public final void processBytes(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    setStringsInternal(paramField, data, paramArrayList);
  }
  
  public final void put(Field paramField, double paramDouble)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, Double.valueOf(paramDouble));
      return;
    }
    write(paramField, data, paramDouble);
  }
  
  protected void put(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("Long list not supported");
  }
  
  public final void put(Field paramField, BigDecimal paramBigDecimal)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramBigDecimal);
      return;
    }
    setData(paramField, data, paramBigDecimal);
  }
  
  protected void putAll(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("Integer list not supported");
  }
  
  protected void read(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("BigInteger list not supported");
  }
  
  public final void reference(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    put(paramField, data, paramArrayList);
  }
  
  protected void setBooleanInternal(Field paramField, String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Boolean not supported");
  }
  
  protected void setData(Field paramField, String paramString, BigDecimal paramBigDecimal)
  {
    throw new UnsupportedOperationException("BigDecimal not supported");
  }
  
  protected void setDecodedBytesInternal(Field paramField, String paramString, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("byte[] not supported");
  }
  
  protected void setIntegerInternal(Field paramField, String paramString, int paramInt)
  {
    throw new UnsupportedOperationException("Integer not supported");
  }
  
  protected void setLongInternal(Field paramField, String paramString, long paramLong)
  {
    throw new UnsupportedOperationException("Long not supported");
  }
  
  protected void setStringInternal(Field paramField, String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException("String not supported");
  }
  
  protected void setStringMapInternal(Field paramField, String paramString, Map paramMap)
  {
    throw new UnsupportedOperationException("String map not supported");
  }
  
  protected void setStringsInternal(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("String list not supported");
  }
  
  public final void skip(Field paramField, long paramLong)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, Long.valueOf(paramLong));
      return;
    }
    setLongInternal(paramField, data, paramLong);
  }
  
  protected void toArray(Field paramField, String paramString, ArrayList paramArrayList)
  {
    throw new UnsupportedOperationException("Boolean list not supported");
  }
  
  public String toString()
  {
    Map localMap = getFieldMappings();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Field localField = (Field)localMap.get(localObject1);
      if (isFieldSet(localField))
      {
        Object localObject2 = get(localField, getFieldValue(localField));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        } else {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("\"");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\":");
        if (localObject2 == null)
        {
          localStringBuilder.append("null");
        }
        else
        {
          int j;
          int i;
          switch (length)
          {
          default: 
            if (this$0)
            {
              localObject1 = (ArrayList)localObject2;
              localStringBuilder.append("[");
              j = ((ArrayList)localObject1).size();
              i = 0;
            }
            break;
          case 10: 
            MapUtils.writeStringMapToJson(localStringBuilder, (HashMap)localObject2);
            break;
          case 9: 
            localStringBuilder.append("\"");
            localStringBuilder.append(Base64Utils.encodeUrlSafe((byte[])localObject2));
            localStringBuilder.append("\"");
            break;
          case 8: 
            localStringBuilder.append("\"");
            localStringBuilder.append(Base64Utils.encode((byte[])localObject2));
            localStringBuilder.append("\"");
            continue;
            while (i < j)
            {
              if (i > 0) {
                localStringBuilder.append(",");
              }
              localObject2 = ((ArrayList)localObject1).get(i);
              if (localObject2 != null) {
                set(localStringBuilder, localField, localObject2);
              }
              i += 1;
            }
            localStringBuilder.append("]");
            continue;
            set(localStringBuilder, localField, localObject2);
          }
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    } else {
      localStringBuilder.append("{}");
    }
    return localStringBuilder.toString();
  }
  
  public final void update(Field paramField, ArrayList paramArrayList)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramArrayList);
      return;
    }
    toArray(paramField, data, paramArrayList);
  }
  
  public final void update(Field paramField, Map paramMap)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, paramMap);
      return;
    }
    setStringMapInternal(paramField, data, paramMap);
  }
  
  public final void warn(Field paramField, boolean paramBoolean)
  {
    if (Field.toString(paramField) != null)
    {
      write(paramField, Boolean.valueOf(paramBoolean));
      return;
    }
    setBooleanInternal(paramField, data, paramBoolean);
  }
  
  protected void write(Field paramField, String paramString, double paramDouble)
  {
    throw new UnsupportedOperationException("Double not supported");
  }
  
  protected void write(Field paramField, String paramString, BigInteger paramBigInteger)
  {
    throw new UnsupportedOperationException("BigInteger not supported");
  }
  
  protected void writeValue(Field paramField, String paramString, float paramFloat)
  {
    throw new UnsupportedOperationException("Float not supported");
  }
  
  @KeepForSdk
  @ShowFirstParty
  @SafeParcelable.Class(creator="FieldCreator")
  @VisibleForTesting
  public static class Field<I, O>
    extends AbstractSafeParcelable
  {
    public static final VerticalProgressBar.SavedState.1 CREATOR = new VerticalProgressBar.SavedState.1();
    private Message bytes;
    @SafeParcelable.VersionField(getter="getVersionCode", id=1)
    private final int count;
    @SafeParcelable.Field(getter="getOutputFieldName", id=6)
    protected final String data;
    @SafeParcelable.Field(getter="isTypeOutArray", id=5)
    protected final boolean id;
    @SafeParcelable.Field(getter="getTypeOut", id=4)
    protected final int length;
    @SafeParcelable.Field(getter="getSafeParcelableFieldId", id=7)
    protected final int n;
    @SafeParcelable.Field(getter="getWrappedConverter", id=9, type="com.google.android.gms.common.server.converter.ConverterWrapper")
    private FastJsonResponse.FieldConverter<I, O> path;
    @SafeParcelable.Field(getter="getTypeIn", id=2)
    protected final int size;
    @SafeParcelable.Field(getter="isTypeInArray", id=3)
    protected final boolean this$0;
    protected final Class<? extends FastJsonResponse> type;
    @SafeParcelable.Field(getter="getConcreteTypeName", id=8)
    protected final String value;
    
    Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, Language paramLanguage)
    {
      count = paramInt1;
      size = paramInt2;
      this$0 = paramBoolean1;
      length = paramInt3;
      id = paramBoolean2;
      data = paramString1;
      n = paramInt4;
      if (paramString2 == null)
      {
        type = null;
        value = null;
      }
      else
      {
        type = SafeParcelResponse.class;
        value = paramString2;
      }
      if (paramLanguage == null)
      {
        path = null;
        return;
      }
      path = paramLanguage.getId();
    }
    
    protected Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class paramClass, FastJsonResponse.FieldConverter paramFieldConverter)
    {
      count = 1;
      size = paramInt1;
      this$0 = paramBoolean1;
      length = paramInt2;
      id = paramBoolean2;
      data = paramString;
      n = paramInt3;
      type = paramClass;
      if (paramClass == null) {
        value = null;
      } else {
        value = paramClass.getCanonicalName();
      }
      path = paramFieldConverter;
    }
    
    public static Field forBase64(String paramString, int paramInt)
    {
      return new Field(8, false, 8, false, paramString, paramInt, null, null);
    }
    
    public static Field forBoolean(String paramString, int paramInt)
    {
      return new Field(6, false, 6, false, paramString, paramInt, null, null);
    }
    
    public static Field forConcreteType(String paramString, int paramInt, Class paramClass)
    {
      return new Field(11, false, 11, false, paramString, paramInt, paramClass, null);
    }
    
    public static Field forConcreteTypeArray(String paramString, int paramInt, Class paramClass)
    {
      return new Field(11, true, 11, true, paramString, paramInt, paramClass, null);
    }
    
    public static Field forDouble(String paramString, int paramInt)
    {
      return new Field(4, false, 4, false, paramString, paramInt, null, null);
    }
    
    public static Field forFloat(String paramString, int paramInt)
    {
      return new Field(3, false, 3, false, paramString, paramInt, null, null);
    }
    
    public static Field forInteger(String paramString, int paramInt)
    {
      return new Field(0, false, 0, false, paramString, paramInt, null, null);
    }
    
    public static Field forLong(String paramString, int paramInt)
    {
      return new Field(2, false, 2, false, paramString, paramInt, null, null);
    }
    
    public static Field forString(String paramString, int paramInt)
    {
      return new Field(7, false, 7, false, paramString, paramInt, null, null);
    }
    
    public static Field forStringMap(String paramString, int paramInt)
    {
      return new Field(10, false, 10, false, paramString, paramInt, null, null);
    }
    
    public static Field forStrings(String paramString, int paramInt)
    {
      return new Field(7, true, 7, true, paramString, paramInt, null, null);
    }
    
    public static Field withConverter(String paramString, int paramInt, FastJsonResponse.FieldConverter paramFieldConverter, boolean paramBoolean)
    {
      paramFieldConverter.getFieldCount();
      paramFieldConverter.classMetadataIdForName();
      return new Field(7, paramBoolean, 0, false, paramString, paramInt, null, paramFieldConverter);
    }
    
    public final Map add()
    {
      Preconditions.checkNotNull(value);
      Preconditions.checkNotNull(bytes);
      return (Map)Preconditions.checkNotNull(bytes.toString(value));
    }
    
    public final FastJsonResponse append()
      throws InstantiationException, IllegalAccessException
    {
      Preconditions.checkNotNull(type);
      Class localClass = type;
      if (localClass == SafeParcelResponse.class)
      {
        Preconditions.checkNotNull(value);
        Preconditions.checkNotNull(bytes, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
        return new SafeParcelResponse(bytes, value);
      }
      return (FastJsonResponse)localClass.newInstance();
    }
    
    public final Field equals()
    {
      return new Field(count, size, this$0, length, id, data, n, value, getName());
    }
    
    public final Object get(Object paramObject)
    {
      Preconditions.checkNotNull(path);
      return path.get(paramObject);
    }
    
    final Language getName()
    {
      FastJsonResponse.FieldConverter localFieldConverter = path;
      if (localFieldConverter == null) {
        return null;
      }
      return Language.fromString(localFieldConverter);
    }
    
    public int getSafeParcelableFieldId()
    {
      return n;
    }
    
    final String getValue()
    {
      String str = value;
      if (str == null) {
        return null;
      }
      return str;
    }
    
    public final boolean isBufferFull()
    {
      return path != null;
    }
    
    public final Object next(Object paramObject)
    {
      Preconditions.checkNotNull(path);
      return Preconditions.checkNotNull(path.getValue(paramObject));
    }
    
    public final String toString()
    {
      Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).name("versionCode", Integer.valueOf(count)).name("typeIn", Integer.valueOf(size)).name("typeInArray", Boolean.valueOf(this$0)).name("typeOut", Integer.valueOf(length)).name("typeOutArray", Boolean.valueOf(id)).name("outputFieldName", data).name("safeParcelFieldId", Integer.valueOf(n)).name("concreteTypeName", getValue());
      Object localObject = type;
      if (localObject != null) {
        localToStringHelper.name("concreteType.class", ((Class)localObject).getCanonicalName());
      }
      localObject = path;
      if (localObject != null) {
        localToStringHelper.name("converterName", localObject.getClass().getCanonicalName());
      }
      return localToStringHelper.toString();
    }
    
    public final void write(Message paramMessage)
    {
      bytes = paramMessage;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, count);
      SafeParcelWriter.writeInt(paramParcel, 2, size);
      SafeParcelWriter.writeBoolean(paramParcel, 3, this$0);
      SafeParcelWriter.writeInt(paramParcel, 4, length);
      SafeParcelWriter.writeBoolean(paramParcel, 5, id);
      SafeParcelWriter.writeString(paramParcel, 6, data, false);
      SafeParcelWriter.writeInt(paramParcel, 7, getSafeParcelableFieldId());
      SafeParcelWriter.writeString(paramParcel, 8, getValue(), false);
      SafeParcelWriter.writeParcelable(paramParcel, 9, getName(), paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
    }
  }
  
  @ShowFirstParty
  public static abstract interface FieldConverter<I, O>
  {
    public abstract int classMetadataIdForName();
    
    public abstract Object get(Object paramObject);
    
    public abstract int getFieldCount();
    
    public abstract Object getValue(Object paramObject);
  }
}

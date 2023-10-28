package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteClosable;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdk
@KeepName
@SafeParcelable.Class(creator="DataHolderCreator", validate=true)
public final class DataHolder
  extends AbstractSafeParcelable
  implements Closeable
{
  @KeepForSdk
  public static final Parcelable.Creator<DataHolder> CREATOR = new VerticalProgressBar.SavedState.1();
  private static final Builder FIELD = new Coordinates(new String[0], null);
  private boolean cache = true;
  boolean closed = false;
  Bundle data;
  @SafeParcelable.Field(getter="getColumns", id=1)
  private final String[] fields;
  int len;
  @SafeParcelable.Field(getter="getMetadata", id=4)
  private final Bundle mMetadata;
  @SafeParcelable.Field(getter="getStatusCode", id=3)
  private final int statusCode;
  @SafeParcelable.Field(getter="getWindows", id=2)
  private final CursorWindow[] this$0;
  @SafeParcelable.VersionField(id=1000)
  final int type;
  int[] value;
  
  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    type = paramInt1;
    fields = paramArrayOfString;
    this$0 = paramArrayOfCursorWindow;
    statusCode = paramInt2;
    mMetadata = paramBundle;
  }
  
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle) {}
  
  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle)
  {
    this(Builder.get(paramBuilder), doInBackground(paramBuilder, -1), paramInt, null);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    type = 1;
    fields = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    this$0 = ((CursorWindow[])Preconditions.checkNotNull(paramArrayOfCursorWindow));
    statusCode = paramInt;
    mMetadata = paramBundle;
    process();
  }
  
  public static Builder builder(String[] paramArrayOfString)
  {
    return new Builder(paramArrayOfString, null, null);
  }
  
  private static CursorWindow[] doInBackground(Builder paramBuilder, int paramInt)
  {
    paramInt = Builder.get(paramBuilder).length;
    int k = 0;
    if (paramInt == 0) {
      return new CursorWindow[0];
    }
    ArrayList localArrayList2 = Builder.d(paramBuilder);
    int m = localArrayList2.size();
    Object localObject1 = new CursorWindow(false);
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(localObject1);
    ((CursorWindow)localObject1).setNumColumns(Builder.get(paramBuilder).length);
    paramInt = 0;
    int i = 0;
    while (paramInt < m) {
      try
      {
        boolean bool = ((CursorWindow)localObject1).allocRow();
        Object localObject2;
        if (!bool)
        {
          localObject1 = new StringBuilder(72);
          ((StringBuilder)localObject1).append("Allocating additional cursor window for large data set (row ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append(")");
          Log.d("DataHolder", ((StringBuilder)localObject1).toString());
          localObject2 = new CursorWindow(false);
          ((CursorWindow)localObject2).setStartPosition(paramInt);
          ((CursorWindow)localObject2).setNumColumns(Builder.get(paramBuilder).length);
          localArrayList1.add(localObject2);
          bool = ((CursorWindow)localObject2).allocRow();
          localObject1 = localObject2;
          if (!bool)
          {
            Log.e("DataHolder", "Unable to allocate row to hold data.");
            localArrayList1.remove(localObject2);
            paramBuilder = (CursorWindow[])localArrayList1.toArray(new CursorWindow[localArrayList1.size()]);
            return paramBuilder;
          }
        }
        Map localMap = (Map)localArrayList2.get(paramInt);
        int j = 0;
        bool = true;
        Object localObject3;
        for (;;)
        {
          int n = Builder.get(paramBuilder).length;
          if (j >= n) {
            break label622;
          }
          if (!bool) {
            break label633;
          }
          localObject2 = Builder.get(paramBuilder)[j];
          localObject3 = localMap.get(localObject2);
          if (localObject3 == null)
          {
            bool = ((CursorWindow)localObject1).putNull(paramInt, j);
          }
          else if ((localObject3 instanceof String))
          {
            bool = ((CursorWindow)localObject1).putString((String)localObject3, paramInt, j);
          }
          else if ((localObject3 instanceof Long))
          {
            bool = ((CursorWindow)localObject1).putLong(((Long)localObject3).longValue(), paramInt, j);
          }
          else
          {
            long l;
            if ((localObject3 instanceof Integer))
            {
              n = ((Integer)localObject3).intValue();
              l = n;
              bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
            }
            else if ((localObject3 instanceof Boolean))
            {
              bool = ((Boolean)localObject3).booleanValue();
              if (true != bool) {
                l = 0L;
              } else {
                l = 1L;
              }
              bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
            }
            else if ((localObject3 instanceof byte[]))
            {
              bool = ((CursorWindow)localObject1).putBlob((byte[])localObject3, paramInt, j);
            }
            else if ((localObject3 instanceof Double))
            {
              bool = ((CursorWindow)localObject1).putDouble(((Double)localObject3).doubleValue(), paramInt, j);
            }
            else
            {
              if (!(localObject3 instanceof Float)) {
                break;
              }
              float f = ((Float)localObject3).floatValue();
              double d = f;
              bool = ((CursorWindow)localObject1).putDouble(d, paramInt, j);
            }
          }
          j += 1;
        }
        paramBuilder = localObject3.toString();
        paramInt = String.valueOf(localObject2).length();
        i = paramBuilder.length();
        localObject1 = new StringBuilder(paramInt + 32 + i);
        ((StringBuilder)localObject1).append("Unsupported object for column ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(paramBuilder);
        throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        label622:
        if (bool)
        {
          i = 0;
        }
        else
        {
          label633:
          if (i != 0) {
            break label739;
          }
          localObject2 = new StringBuilder(74);
          ((StringBuilder)localObject2).append("Couldn't populate window data for row ");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" - allocating new window.");
          Log.d("DataHolder", ((StringBuilder)localObject2).toString());
          ((CursorWindow)localObject1).freeLastRow();
          localObject1 = new CursorWindow(false);
          ((CursorWindow)localObject1).setStartPosition(paramInt);
          ((CursorWindow)localObject1).setNumColumns(Builder.get(paramBuilder).length);
          localArrayList1.add(localObject1);
          paramInt -= 1;
          i = 1;
        }
        paramInt += 1;
        continue;
        label739:
        throw new DaoSession("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
      }
      catch (RuntimeException paramBuilder)
      {
        i = localArrayList1.size();
        paramInt = k;
        while (paramInt < i)
        {
          ((CursorWindow)localArrayList1.get(paramInt)).close();
          paramInt += 1;
        }
        throw paramBuilder;
      }
    }
    return (CursorWindow[])localArrayList1.toArray(new CursorWindow[localArrayList1.size()]);
  }
  
  public static DataHolder empty(int paramInt)
  {
    return new DataHolder(FIELD, paramInt, null);
  }
  
  private final void get(String paramString, int paramInt)
  {
    Bundle localBundle = data;
    if ((localBundle != null) && (localBundle.containsKey(paramString)))
    {
      if (!isClosed())
      {
        if ((paramInt >= 0) && (paramInt < len)) {
          return;
        }
        throw new CursorIndexOutOfBoundsException(paramInt, len);
      }
      throw new IllegalArgumentException("Buffer is closed.");
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "No such column: ".concat(paramString);
    } else {
      paramString = new String("No such column: ");
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public void close()
  {
    try
    {
      if (!closed)
      {
        closed = true;
        int i = 0;
        for (;;)
        {
          CursorWindow[] arrayOfCursorWindow = this$0;
          if (i >= arrayOfCursorWindow.length) {
            break;
          }
          arrayOfCursorWindow[i].close();
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected final void finalize()
    throws Throwable
  {
    try
    {
      boolean bool = cache;
      if (bool)
      {
        int i = this$0.length;
        if (i > 0)
        {
          bool = isClosed();
          if (!bool)
          {
            close();
            String str = toString();
            i = String.valueOf(str).length();
            StringBuilder localStringBuilder = new StringBuilder(i + 178);
            localStringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
            localStringBuilder.append(str);
            localStringBuilder.append(")");
            Log.e("DataBuffer", localStringBuilder.toString());
          }
        }
      }
      super.finalize();
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
      throw localThrowable;
    }
  }
  
  public final float get(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return this$0[paramInt2].getFloat(paramInt1, data.getInt(paramString));
  }
  
  public boolean getBoolean(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return Long.valueOf(this$0[paramInt2].getLong(paramInt1, data.getInt(paramString))).longValue() == 1L;
  }
  
  public byte[] getByteArray(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return this$0[paramInt2].getBlob(paramInt1, data.getInt(paramString));
  }
  
  public int getCount()
  {
    return len;
  }
  
  public int getInteger(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return this$0[paramInt2].getInt(paramInt1, data.getInt(paramString));
  }
  
  public long getLong(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return this$0[paramInt2].getLong(paramInt1, data.getInt(paramString));
  }
  
  public Bundle getMetadata()
  {
    return mMetadata;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public String getString(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return this$0[paramInt2].getString(paramInt1, data.getInt(paramString));
  }
  
  public int getWindowIndex(int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < len)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    int k;
    int j;
    for (;;)
    {
      int[] arrayOfInt = value;
      k = arrayOfInt.length;
      j = i;
      if (i >= k) {
        break;
      }
      if (paramInt < arrayOfInt[i])
      {
        j = i - 1;
        break;
      }
      i += 1;
    }
    if (j == k) {
      return j - 1;
    }
    return j;
  }
  
  public boolean hasColumn(String paramString)
  {
    return data.containsKey(paramString);
  }
  
  public boolean hasNull(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return this$0[paramInt2].isNull(paramInt1, data.getInt(paramString));
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = closed;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void process()
  {
    data = new Bundle();
    int k = 0;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = fields;
      if (i >= localObject.length) {
        break;
      }
      data.putInt(localObject[i], i);
      i += 1;
    }
    value = new int[this$0.length];
    int j = 0;
    i = k;
    for (;;)
    {
      localObject = this$0;
      if (i >= localObject.length) {
        break;
      }
      value[i] = j;
      k = localObject[i].getStartPosition();
      j += this$0[i].getNumRows() - (j - k);
      i += 1;
    }
    len = j;
  }
  
  public final double put(String paramString, int paramInt1, int paramInt2)
  {
    get(paramString, paramInt1);
    return this$0[paramInt2].getDouble(paramInt1, data.getInt(paramString));
  }
  
  public final void put(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    get(paramString, paramInt1);
    this$0[paramInt2].copyStringToBuffer(paramInt1, data.getInt(paramString), paramCharArrayBuffer);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, fields, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this$0, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, type);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0) {
      close();
    }
  }
  
  @KeepForSdk
  public static class Builder
  {
    private final HashMap<Object, Integer> b;
    private final ArrayList<HashMap<String, Object>> m;
    private final String[] values;
    
    public DataHolder build(int paramInt)
    {
      return new DataHolder(this, paramInt, null, null);
    }
    
    public DataHolder build(int paramInt, Bundle paramBundle)
    {
      return new DataHolder(this, paramInt, paramBundle, -1, null);
    }
    
    public Builder setList(HashMap paramHashMap)
    {
      Asserts.checkNotNull(paramHashMap);
      m.add(paramHashMap);
      return this;
    }
    
    public Builder withRow(ContentValues paramContentValues)
    {
      Asserts.checkNotNull(paramContentValues);
      HashMap localHashMap = new HashMap(paramContentValues.size());
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localHashMap.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return setList(localHashMap);
    }
  }
}

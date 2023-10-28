package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class DataBufferRef
{
  private int data;
  @KeepForSdk
  protected final DataHolder mDataHolder;
  @KeepForSdk
  protected int mDataRow;
  
  public DataBufferRef(DataHolder paramDataHolder, int paramInt)
  {
    mDataHolder = ((DataHolder)Preconditions.checkNotNull(paramDataHolder));
    setData(paramInt);
  }
  
  protected void copyToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    mDataHolder.put(paramString, mDataRow, data, paramCharArrayBuffer);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DataBufferRef))
    {
      paramObject = (DataBufferRef)paramObject;
      if ((Objects.equal(Integer.valueOf(mDataRow), Integer.valueOf(mDataRow))) && (Objects.equal(Integer.valueOf(data), Integer.valueOf(data))) && (mDataHolder == mDataHolder)) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return mDataHolder.getBoolean(paramString, mDataRow, data);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return mDataHolder.getByteArray(paramString, mDataRow, data);
  }
  
  protected int getDataRow()
  {
    return mDataRow;
  }
  
  protected double getDouble(String paramString)
  {
    return mDataHolder.put(paramString, mDataRow, data);
  }
  
  protected float getFloat(String paramString)
  {
    return mDataHolder.get(paramString, mDataRow, data);
  }
  
  protected int getInteger(String paramString)
  {
    return mDataHolder.getInteger(paramString, mDataRow, data);
  }
  
  protected long getLong(String paramString)
  {
    return mDataHolder.getLong(paramString, mDataRow, data);
  }
  
  protected String getString(String paramString)
  {
    return mDataHolder.getString(paramString, mDataRow, data);
  }
  
  public boolean hasColumn(String paramString)
  {
    return mDataHolder.hasColumn(paramString);
  }
  
  protected boolean hasNull(String paramString)
  {
    return mDataHolder.hasNull(paramString, mDataRow, data);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(mDataRow), Integer.valueOf(data), mDataHolder });
  }
  
  public boolean isDataValid()
  {
    return !mDataHolder.isClosed();
  }
  
  protected Uri parseUri(String paramString)
  {
    paramString = mDataHolder.getString(paramString, mDataRow, data);
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  protected final void setData(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < mDataHolder.getCount()) {
        bool1 = true;
      }
    }
    Preconditions.checkState(bool1);
    mDataRow = paramInt;
    data = mDataHolder.getWindowIndex(paramInt);
  }
}

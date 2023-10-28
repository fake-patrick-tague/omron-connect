package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T>
  extends AbstractDataBuffer<T>
{
  private ArrayList<Integer> mData;
  private boolean mSelected = false;
  
  protected EntityBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private final void processData()
  {
    Object localObject1 = this;
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        boolean bool = mSelected;
        EntityBuffer localEntityBuffer = this;
        if (!bool)
        {
          localObject1 = localEntityBuffer;
          int j = ((DataHolder)Preconditions.checkNotNull(mDataHolder)).getCount();
          localObject1 = localEntityBuffer;
          localObject2 = new ArrayList();
          localObject1 = localEntityBuffer;
          mData = ((ArrayList)localObject2);
          if (j > 0)
          {
            localObject1 = localEntityBuffer;
            ((ArrayList)localObject2).add(Integer.valueOf(0));
            localObject1 = localEntityBuffer;
            String str2 = localEntityBuffer.getPrimaryDataMarkerColumn();
            localObject1 = localEntityBuffer;
            i = mDataHolder.getWindowIndex(0);
            localObject1 = localEntityBuffer;
            localObject2 = mDataHolder.getString(str2, 0, i);
            i = 1;
            if (i < j)
            {
              localObject1 = localEntityBuffer;
              int k = mDataHolder.getWindowIndex(i);
              localObject1 = localEntityBuffer;
              String str1 = mDataHolder.getString(str2, i, k);
              if (str1 != null)
              {
                localObject1 = localEntityBuffer;
                localObject3 = localObject2;
                if (str1.equals(localObject2)) {
                  break label346;
                }
                localObject1 = localEntityBuffer;
                mData.add(Integer.valueOf(i));
                localObject3 = str1;
                break label346;
              }
              localObject1 = localEntityBuffer;
              localObject2 = new StringBuilder(String.valueOf(str2).length() + 78);
              localObject1 = localEntityBuffer;
              ((StringBuilder)localObject2).append("Missing value for markerColumn: ");
              localObject1 = localEntityBuffer;
              ((StringBuilder)localObject2).append(str2);
              localObject1 = localEntityBuffer;
              ((StringBuilder)localObject2).append(", at row: ");
              localObject1 = localEntityBuffer;
              ((StringBuilder)localObject2).append(i);
              localObject1 = localEntityBuffer;
              ((StringBuilder)localObject2).append(", for window: ");
              localObject1 = localEntityBuffer;
              ((StringBuilder)localObject2).append(k);
              localObject1 = localEntityBuffer;
              throw new NullPointerException(((StringBuilder)localObject2).toString());
            }
          }
          localObject1 = localEntityBuffer;
          mSelected = true;
        }
        else
        {
          localObject1 = localEntityBuffer;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      label346:
      i += 1;
      Object localObject2 = localObject3;
    }
  }
  
  public final Object get(int paramInt)
  {
    processData();
    int m = getIndex(paramInt);
    int k = 0;
    int i = k;
    if (paramInt >= 0) {
      if (paramInt == mData.size())
      {
        i = k;
      }
      else
      {
        int j;
        if (paramInt == mData.size() - 1)
        {
          i = ((DataHolder)Preconditions.checkNotNull(mDataHolder)).getCount();
          j = ((Integer)mData.get(paramInt)).intValue();
        }
        else
        {
          i = ((Integer)mData.get(paramInt + 1)).intValue();
          j = ((Integer)mData.get(paramInt)).intValue();
        }
        i -= j;
        if (i == 1)
        {
          paramInt = getIndex(paramInt);
          i = ((DataHolder)Preconditions.checkNotNull(mDataHolder)).getWindowIndex(paramInt);
          String str = getChildDataMarkerColumn();
          if ((str != null) && (mDataHolder.getString(str, paramInt, i) == null)) {
            i = k;
          } else {
            i = 1;
          }
        }
      }
    }
    return getEntry(m, i);
  }
  
  protected String getChildDataMarkerColumn()
  {
    return null;
  }
  
  public int getCount()
  {
    processData();
    return mData.size();
  }
  
  protected abstract Object getEntry(int paramInt1, int paramInt2);
  
  final int getIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < mData.size())) {
      return ((Integer)mData.get(paramInt)).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder(53);
    localStringBuilder.append("Position ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is out of bounds for this buffer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected abstract String getPrimaryDataMarkerColumn();
}

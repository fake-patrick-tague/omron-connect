package androidx.recyclerview.widget;

import c.e.d;
import c.e.g;
import c.h.p.e;
import v7.util.SimpleArrayMap;
import v7.util.SparseArray;
import v7.v7.util.Pools.Pool;
import v7.v7.util.Pools.SimplePool;

class ViewInfoStore
{
  final g<RecyclerView.b0, z.a> mLayoutHolderMap = new SimpleArrayMap();
  final d<RecyclerView.b0> mOldChangedHolders = new SparseArray();
  
  ViewInfoStore() {}
  
  private RecyclerView.l.c popFromLayoutStep(RecyclerView.b0 paramB0, int paramInt)
  {
    int i = mLayoutHolderMap.indexOfKey(paramB0);
    if (i < 0) {
      return null;
    }
    InfoRecord localInfoRecord = (InfoRecord)mLayoutHolderMap.get(i);
    if (localInfoRecord != null)
    {
      int j = flags;
      if ((j & paramInt) != 0)
      {
        j = paramInt & j;
        flags = j;
        if (paramInt == 4)
        {
          paramB0 = preInfo;
        }
        else
        {
          if (paramInt != 8) {
            break label110;
          }
          paramB0 = postInfo;
        }
        if ((j & 0xC) != 0) {
          return paramB0;
        }
        mLayoutHolderMap.removeAt(i);
        InfoRecord.recycle(localInfoRecord);
        return paramB0;
        label110:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
      }
    }
    return null;
    return paramB0;
  }
  
  void addToAppearedInPreLayoutHolders(RecyclerView.b0 paramB0, RecyclerView.l.c paramC)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramB0);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramB0, localInfoRecord2);
    }
    flags |= 0x2;
    preInfo = paramC;
  }
  
  void addToDisappearedInLayout(RecyclerView.b0 paramB0)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramB0);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramB0, localInfoRecord2);
    }
    flags |= 0x1;
  }
  
  void addToOldChangeHolders(long paramLong, RecyclerView.b0 paramB0)
  {
    mOldChangedHolders.put(paramLong, paramB0);
  }
  
  void addToPostLayout(RecyclerView.b0 paramB0, RecyclerView.l.c paramC)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramB0);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramB0, localInfoRecord2);
    }
    postInfo = paramC;
    flags |= 0x8;
  }
  
  void addToPreLayout(RecyclerView.b0 paramB0, RecyclerView.l.c paramC)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramB0);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramB0, localInfoRecord2);
    }
    preInfo = paramC;
    flags |= 0x4;
  }
  
  void clear()
  {
    mLayoutHolderMap.clear();
    mOldChangedHolders.clear();
  }
  
  RecyclerView.b0 getFromOldChangeHolders(long paramLong)
  {
    return (RecyclerView.b0)mOldChangedHolders.get(paramLong);
  }
  
  boolean isDisappearing(RecyclerView.b0 paramB0)
  {
    paramB0 = (InfoRecord)mLayoutHolderMap.get(paramB0);
    return (paramB0 != null) && ((flags & 0x1) != 0);
  }
  
  boolean isInPreLayout(RecyclerView.b0 paramB0)
  {
    paramB0 = (InfoRecord)mLayoutHolderMap.get(paramB0);
    return (paramB0 != null) && ((flags & 0x4) != 0);
  }
  
  void onDetach() {}
  
  public void onViewDetached(RecyclerView.b0 paramB0)
  {
    removeFromDisappearedInLayout(paramB0);
  }
  
  RecyclerView.l.c popFromPostLayout(RecyclerView.b0 paramB0)
  {
    return popFromLayoutStep(paramB0, 8);
  }
  
  RecyclerView.l.c popFromPreLayout(RecyclerView.b0 paramB0)
  {
    return popFromLayoutStep(paramB0, 4);
  }
  
  void process(ProcessCallback paramProcessCallback)
  {
    int i = mLayoutHolderMap.size() - 1;
    while (i >= 0)
    {
      RecyclerView.b0 localB0 = (RecyclerView.b0)mLayoutHolderMap.size(i);
      InfoRecord localInfoRecord = (InfoRecord)mLayoutHolderMap.removeAt(i);
      int j = flags;
      if ((j & 0x3) == 3)
      {
        paramProcessCallback.unused(localB0);
      }
      else if ((j & 0x1) != 0)
      {
        RecyclerView.l.c localC = preInfo;
        if (localC == null) {
          paramProcessCallback.unused(localB0);
        } else {
          paramProcessCallback.processDisappeared(localB0, localC, postInfo);
        }
      }
      else if ((j & 0xE) == 14)
      {
        paramProcessCallback.processAppeared(localB0, preInfo, postInfo);
      }
      else if ((j & 0xC) == 12)
      {
        paramProcessCallback.processPersistent(localB0, preInfo, postInfo);
      }
      else if ((j & 0x4) != 0)
      {
        paramProcessCallback.processDisappeared(localB0, preInfo, null);
      }
      else if ((j & 0x8) != 0)
      {
        paramProcessCallback.processAppeared(localB0, preInfo, postInfo);
      }
      InfoRecord.recycle(localInfoRecord);
      i -= 1;
    }
  }
  
  void removeFromDisappearedInLayout(RecyclerView.b0 paramB0)
  {
    paramB0 = (InfoRecord)mLayoutHolderMap.get(paramB0);
    if (paramB0 == null) {
      return;
    }
    flags &= 0xFFFFFFFE;
  }
  
  void removeViewHolder(RecyclerView.b0 paramB0)
  {
    int i = mOldChangedHolders.size() - 1;
    while (i >= 0)
    {
      if (paramB0 == mOldChangedHolders.valueAt(i))
      {
        mOldChangedHolders.removeAt(i);
        break;
      }
      i -= 1;
    }
    paramB0 = (InfoRecord)mLayoutHolderMap.remove(paramB0);
    if (paramB0 != null) {
      InfoRecord.recycle(paramB0);
    }
  }
  
  class InfoRecord
  {
    static e<z.a> sPool = new Pools.SimplePool(20);
    int flags;
    RecyclerView.l.c postInfo;
    RecyclerView.l.c preInfo;
    
    private InfoRecord() {}
    
    static void drainCache()
    {
      while (sPool.acquire() != null) {}
    }
    
    static InfoRecord obtain()
    {
      InfoRecord localInfoRecord2 = (InfoRecord)sPool.acquire();
      InfoRecord localInfoRecord1 = localInfoRecord2;
      if (localInfoRecord2 == null) {
        localInfoRecord1 = new InfoRecord();
      }
      return localInfoRecord1;
    }
    
    static void recycle(InfoRecord paramInfoRecord)
    {
      flags = 0;
      preInfo = null;
      postInfo = null;
      sPool.release(paramInfoRecord);
    }
  }
  
  abstract interface ProcessCallback
  {
    public abstract void processAppeared(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2);
    
    public abstract void processDisappeared(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2);
    
    public abstract void processPersistent(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2);
    
    public abstract void unused(RecyclerView.b0 paramB0);
  }
}

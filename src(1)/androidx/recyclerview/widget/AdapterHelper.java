package androidx.recyclerview.widget;

import c.h.p.e;
import java.util.ArrayList;
import java.util.List;
import v7.v7.util.Pools.Pool;
import v7.v7.util.Pools.SimplePool;

final class AdapterHelper
  implements OpReorderer.Callback
{
  final Callback mCallback;
  final boolean mDisableRecycler;
  private int mExistingUpdateTypes = 0;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<a.b> mPendingUpdates = new ArrayList();
  final ArrayList<a.b> mPostponedList = new ArrayList();
  private e<a.b> mUpdateOpPool = new Pools.SimplePool(30);
  
  AdapterHelper(Callback paramCallback)
  {
    this(paramCallback, false);
  }
  
  AdapterHelper(Callback paramCallback, boolean paramBoolean)
  {
    mCallback = paramCallback;
    mDisableRecycler = paramBoolean;
    mOpReorderer = new OpReorderer(this);
  }
  
  private void applyAdd(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyMove(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyRemove(UpdateOp paramUpdateOp)
  {
    int i1 = positionStart;
    int m = itemCount + i1;
    int j = -1;
    int i = i1;
    int n = 0;
    while (i < m)
    {
      int k;
      if ((mCallback.findViewHolder(i) == null) && (!canFindInPreLayout(i)))
      {
        if (j == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(2, i1, n, null));
          k = 1;
        }
        else
        {
          k = 0;
        }
        j = 0;
      }
      else
      {
        if (j == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(2, i1, n, null));
          j = 1;
        }
        else
        {
          j = 0;
        }
        int i2 = 1;
        k = j;
        j = i2;
      }
      if (k != 0)
      {
        k = i - n;
        m -= n;
        i = 1;
      }
      else
      {
        n += 1;
        k = i;
        i = n;
      }
      k += 1;
      n = i;
      i = k;
    }
    UpdateOp localUpdateOp = paramUpdateOp;
    if (n != itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      localUpdateOp = obtainUpdateOp(2, i1, n, null);
    }
    if (j == 0)
    {
      dispatchAndUpdateViewHolders(localUpdateOp);
      return;
    }
    postponeAndUpdateViewHolders(localUpdateOp);
  }
  
  private void applyUpdate(UpdateOp paramUpdateOp)
  {
    int i1 = positionStart;
    int i3 = itemCount;
    int i = 0;
    int i2 = -1;
    int j = i1;
    int k = i1;
    while (k < i3 + i1)
    {
      int n;
      int m;
      if ((mCallback.findViewHolder(k) == null) && (!canFindInPreLayout(k)))
      {
        n = i;
        m = j;
        if (i2 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(4, j, i, payload));
          m = k;
          n = 0;
        }
        j = 0;
        i = n;
        n = j;
        j = m;
      }
      else
      {
        m = i;
        n = j;
        if (i2 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(4, j, i, payload));
          n = k;
          m = 0;
        }
        i = 1;
        j = n;
        n = i;
        i = m;
      }
      i += 1;
      k += 1;
      i2 = n;
    }
    Object localObject = paramUpdateOp;
    if (i != itemCount)
    {
      localObject = payload;
      recycleUpdateOp(paramUpdateOp);
      localObject = obtainUpdateOp(4, j, i, localObject);
    }
    if (i2 == 0)
    {
      dispatchAndUpdateViewHolders((UpdateOp)localObject);
      return;
    }
    postponeAndUpdateViewHolders((UpdateOp)localObject);
  }
  
  private boolean canFindInPreLayout(int paramInt)
  {
    int m = mPostponedList.size();
    int j = 0;
    while (j < m)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPostponedList.get(j);
      int i = cmd;
      if (i == 8)
      {
        if (findPositionOffset(itemCount, j + 1) == paramInt) {
          return true;
        }
      }
      else if (i == 1)
      {
        int k = positionStart;
        int n = itemCount;
        i = k;
        while (i < n + k)
        {
          if (findPositionOffset(i, j + 1) == paramInt) {
            return true;
          }
          i += 1;
        }
      }
      j += 1;
    }
    return false;
  }
  
  private void dispatchAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    int i = cmd;
    if ((i != 1) && (i != 8))
    {
      int j = updatePositionWithPostponed(positionStart, i);
      i = positionStart;
      int k = cmd;
      int m;
      if (k != 2)
      {
        if (k == 4)
        {
          m = 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("op should be remove or update.");
          ((StringBuilder)localObject).append(paramUpdateOp);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        m = 0;
      }
      int n = 1;
      k = 1;
      while (n < itemCount)
      {
        int i2 = updatePositionWithPostponed(positionStart + m * n, cmd);
        int i3 = cmd;
        int i1;
        if (i3 != 2)
        {
          if (i3 != 4) {}
          while (i2 != j + 1)
          {
            i1 = 0;
            break;
          }
        }
        for (;;)
        {
          i1 = 1;
          break label177;
          if (i2 != j) {
            break;
          }
        }
        label177:
        if (i1 != 0)
        {
          k += 1;
          i1 = j;
        }
        else
        {
          localObject = obtainUpdateOp(i3, j, k, payload);
          dispatchFirstPassAndUpdateViewHolders((UpdateOp)localObject, i);
          recycleUpdateOp((UpdateOp)localObject);
          j = i;
          if (cmd == 4) {
            j = i + k;
          }
          k = 1;
          i1 = i2;
          i = j;
        }
        n += 1;
        j = i1;
      }
      Object localObject = payload;
      recycleUpdateOp(paramUpdateOp);
      if (k > 0)
      {
        paramUpdateOp = obtainUpdateOp(cmd, j, k, localObject);
        dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, i);
        recycleUpdateOp(paramUpdateOp);
      }
    }
    else
    {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
  }
  
  private void postponeAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    mPostponedList.add(paramUpdateOp);
    int i = cmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            mCallback.offsetPositionsForMove(positionStart, itemCount);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown update op type for ");
          localStringBuilder.append(paramUpdateOp);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        mCallback.markViewHoldersUpdated(positionStart, itemCount, payload);
        return;
      }
      mCallback.offsetPositionsForRemovingLaidOutOrNewView(positionStart, itemCount);
      return;
    }
    mCallback.offsetPositionsForAdd(positionStart, itemCount);
  }
  
  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int j = mPostponedList.size() - 1;
    UpdateOp localUpdateOp;
    for (int i = paramInt1; j >= 0; i = paramInt1)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(j);
      int k = cmd;
      int m;
      if (k == 8)
      {
        k = positionStart;
        m = itemCount;
        int n;
        int i1;
        if (k < m)
        {
          n = k;
          paramInt1 = m;
          i1 = paramInt1;
        }
        else
        {
          i1 = k;
          paramInt1 = m;
          n = paramInt1;
        }
        if ((i >= n) && (i <= i1))
        {
          if (n == k)
          {
            if (paramInt2 == 1) {
              itemCount = (m + 1);
            } else if (paramInt2 == 2) {
              itemCount = (m - 1);
            }
            paramInt1 = i + 1;
          }
          else
          {
            if (paramInt2 == 1) {
              positionStart = (k + 1);
            } else if (paramInt2 == 2) {
              positionStart = (k - 1);
            }
            paramInt1 = i - 1;
          }
        }
        else
        {
          paramInt1 = i;
          if (i < k) {
            if (paramInt2 == 1)
            {
              positionStart = (k + 1);
              itemCount = (m + 1);
              paramInt1 = i;
            }
            else
            {
              paramInt1 = i;
              if (paramInt2 == 2)
              {
                positionStart = (k - 1);
                itemCount = (m - 1);
                paramInt1 = i;
              }
            }
          }
        }
      }
      else
      {
        m = positionStart;
        if (m <= i)
        {
          if (k == 1)
          {
            paramInt1 = i - itemCount;
          }
          else
          {
            paramInt1 = i;
            if (k == 2) {
              paramInt1 = i + itemCount;
            }
          }
        }
        else if (paramInt2 == 1)
        {
          positionStart = (m + 1);
          paramInt1 = i;
        }
        else
        {
          paramInt1 = i;
          if (paramInt2 == 2)
          {
            positionStart = (m - 1);
            paramInt1 = i;
          }
        }
      }
      j -= 1;
    }
    paramInt1 = mPostponedList.size() - 1;
    while (paramInt1 >= 0)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(paramInt1);
      if (cmd == 8)
      {
        paramInt2 = itemCount;
        if ((paramInt2 == positionStart) || (paramInt2 < 0))
        {
          mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
      else if (itemCount <= 0)
      {
        mPostponedList.remove(paramInt1);
        recycleUpdateOp(localUpdateOp);
      }
      paramInt1 -= 1;
    }
    return i;
  }
  
  public int applyPendingUpdatesToPosition(int paramInt)
  {
    int m = mPendingUpdates.size();
    int k = 0;
    for (int i = paramInt; k < m; i = paramInt)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPendingUpdates.get(k);
      paramInt = cmd;
      if (paramInt != 1)
      {
        int j;
        if (paramInt != 2)
        {
          if (paramInt != 8)
          {
            paramInt = i;
          }
          else
          {
            paramInt = positionStart;
            if (paramInt == i)
            {
              paramInt = itemCount;
            }
            else
            {
              j = i;
              if (paramInt < i) {
                j = i - 1;
              }
              paramInt = j;
              if (itemCount <= j) {
                paramInt = j + 1;
              }
            }
          }
        }
        else
        {
          j = positionStart;
          paramInt = i;
          if (j <= i)
          {
            paramInt = itemCount;
            if (j + paramInt > i) {
              return -1;
            }
            paramInt = i - paramInt;
          }
        }
      }
      else
      {
        paramInt = i;
        if (positionStart <= i) {
          paramInt = i + itemCount;
        }
      }
      k += 1;
    }
    return i;
  }
  
  void consumePostponedUpdates()
  {
    int j = mPostponedList.size();
    int i = 0;
    while (i < j)
    {
      mCallback.onDispatchSecondPass((UpdateOp)mPostponedList.get(i));
      i += 1;
    }
    recycleUpdateOpsAndClearList(mPostponedList);
    mExistingUpdateTypes = 0;
  }
  
  void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int j = mPendingUpdates.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (UpdateOp)mPendingUpdates.get(i);
      int k = cmd;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8)
            {
              mCallback.onDispatchSecondPass((UpdateOp)localObject);
              mCallback.offsetPositionsForMove(positionStart, itemCount);
            }
          }
          else
          {
            mCallback.onDispatchSecondPass((UpdateOp)localObject);
            mCallback.markViewHoldersUpdated(positionStart, itemCount, payload);
          }
        }
        else
        {
          mCallback.onDispatchSecondPass((UpdateOp)localObject);
          mCallback.offsetPositionsForRemovingInvisible(positionStart, itemCount);
        }
      }
      else
      {
        mCallback.onDispatchSecondPass((UpdateOp)localObject);
        mCallback.offsetPositionsForAdd(positionStart, itemCount);
      }
      localObject = mOnItemProcessedCallback;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      i += 1;
    }
    recycleUpdateOpsAndClearList(mPendingUpdates);
    mExistingUpdateTypes = 0;
  }
  
  void dispatchFirstPassAndUpdateViewHolders(UpdateOp paramUpdateOp, int paramInt)
  {
    mCallback.onDispatchFirstPass(paramUpdateOp);
    int i = cmd;
    if (i != 2)
    {
      if (i == 4)
      {
        mCallback.markViewHoldersUpdated(paramInt, itemCount, payload);
        return;
      }
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }
    mCallback.offsetPositionsForRemovingInvisible(paramInt, itemCount);
  }
  
  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }
  
  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int k = mPostponedList.size();
    int j = paramInt2;
    for (paramInt2 = paramInt1; j < k; paramInt2 = paramInt1)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPostponedList.get(j);
      int m = cmd;
      int i;
      if (m == 8)
      {
        paramInt1 = positionStart;
        if (paramInt1 == paramInt2)
        {
          paramInt1 = itemCount;
        }
        else
        {
          i = paramInt2;
          if (paramInt1 < paramInt2) {
            i = paramInt2 - 1;
          }
          paramInt1 = i;
          if (itemCount <= i) {
            paramInt1 = i + 1;
          }
        }
      }
      else
      {
        i = positionStart;
        paramInt1 = paramInt2;
        if (i <= paramInt2) {
          if (m == 2)
          {
            paramInt1 = itemCount;
            if (paramInt2 < i + paramInt1) {
              return -1;
            }
            paramInt1 = paramInt2 - paramInt1;
          }
          else
          {
            paramInt1 = paramInt2;
            if (m == 1) {
              paramInt1 = paramInt2 + itemCount;
            }
          }
        }
      }
      j += 1;
    }
    return paramInt2;
  }
  
  boolean hasAnyUpdateTypes(int paramInt)
  {
    return (paramInt & mExistingUpdateTypes) != 0;
  }
  
  boolean hasPendingUpdates()
  {
    return mPendingUpdates.size() > 0;
  }
  
  boolean hasUpdates()
  {
    return (!mPostponedList.isEmpty()) && (!mPendingUpdates.isEmpty());
  }
  
  public UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    UpdateOp localUpdateOp = (UpdateOp)mUpdateOpPool.acquire();
    if (localUpdateOp == null) {
      return new UpdateOp(paramInt1, paramInt2, paramInt3, paramObject);
    }
    cmd = paramInt1;
    positionStart = paramInt2;
    itemCount = paramInt3;
    payload = paramObject;
    return localUpdateOp;
  }
  
  boolean onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt2 < 1) {
      return false;
    }
    mPendingUpdates.add(obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    mExistingUpdateTypes |= 0x4;
    return mPendingUpdates.size() == 1;
  }
  
  boolean onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 1) {
      return false;
    }
    mPendingUpdates.add(obtainUpdateOp(1, paramInt1, paramInt2, null));
    mExistingUpdateTypes |= 0x1;
    return mPendingUpdates.size() == 1;
  }
  
  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == paramInt2) {
      return false;
    }
    if (paramInt3 == 1)
    {
      mPendingUpdates.add(obtainUpdateOp(8, paramInt1, paramInt2, null));
      mExistingUpdateTypes |= 0x8;
      if (mPendingUpdates.size() == 1) {
        return true;
      }
    }
    else
    {
      throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }
    return false;
  }
  
  boolean onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 1) {
      return false;
    }
    mPendingUpdates.add(obtainUpdateOp(2, paramInt1, paramInt2, null));
    mExistingUpdateTypes |= 0x2;
    return mPendingUpdates.size() == 1;
  }
  
  void preProcess()
  {
    mOpReorderer.reorderOps(mPendingUpdates);
    int j = mPendingUpdates.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (UpdateOp)mPendingUpdates.get(i);
      int k = cmd;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8) {
              applyAdd((UpdateOp)localObject);
            }
          }
          else {
            applyUpdate((UpdateOp)localObject);
          }
        }
        else {
          applyRemove((UpdateOp)localObject);
        }
      }
      else {
        applyMove((UpdateOp)localObject);
      }
      localObject = mOnItemProcessedCallback;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      i += 1;
    }
    mPendingUpdates.clear();
  }
  
  public void recycleUpdateOp(UpdateOp paramUpdateOp)
  {
    if (!mDisableRecycler)
    {
      payload = null;
      mUpdateOpPool.release(paramUpdateOp);
    }
  }
  
  void recycleUpdateOpsAndClearList(List paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      recycleUpdateOp((UpdateOp)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  void reset()
  {
    recycleUpdateOpsAndClearList(mPendingUpdates);
    recycleUpdateOpsAndClearList(mPostponedList);
    mExistingUpdateTypes = 0;
  }
  
  abstract interface Callback
  {
    public abstract RecyclerView.b0 findViewHolder(int paramInt);
    
    public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);
    
    public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);
    
    public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
  }
  
  final class UpdateOp
  {
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;
    
    UpdateOp(int paramInt1, int paramInt2, Object paramObject)
    {
      cmd = this$1;
      positionStart = paramInt1;
      itemCount = paramInt2;
      payload = paramObject;
    }
    
    String cmdToString()
    {
      int i = cmd;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 8) {
              return "??";
            }
            return "mv";
          }
          return "up";
        }
        return "rm";
      }
      return "add";
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof UpdateOp)) {
        return false;
      }
      paramObject = (UpdateOp)paramObject;
      int i = cmd;
      if (i != cmd) {
        return false;
      }
      if ((i == 8) && (Math.abs(itemCount - positionStart) == 1) && (itemCount == positionStart) && (positionStart == itemCount)) {
        return true;
      }
      if (itemCount != itemCount) {
        return false;
      }
      if (positionStart != positionStart) {
        return false;
      }
      Object localObject = payload;
      if (localObject != null)
      {
        if (!localObject.equals(payload)) {
          return false;
        }
      }
      else if (payload != null) {
        return false;
      }
      return true;
    }
    
    public int hashCode()
    {
      return (cmd * 31 + positionStart) * 31 + itemCount;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append("[");
      localStringBuilder.append(cmdToString());
      localStringBuilder.append(",s:");
      localStringBuilder.append(positionStart);
      localStringBuilder.append("c:");
      localStringBuilder.append(itemCount);
      localStringBuilder.append(",p:");
      localStringBuilder.append(payload);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}

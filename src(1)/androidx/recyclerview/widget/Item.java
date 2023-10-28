package androidx.recyclerview.widget;

import java.util.Arrays;

class Item
  implements RecyclerView.o.c
{
  int a;
  int b;
  int[] c;
  int d;
  
  Item() {}
  
  void a(int paramInt1, int paramInt2)
  {
    b = paramInt1;
    d = paramInt2;
  }
  
  boolean a(int paramInt)
  {
    if (c != null)
    {
      int j = a;
      int i = 0;
      while (i < j * 2)
      {
        if (c[i] == paramInt) {
          return true;
        }
        i += 2;
      }
    }
    return false;
  }
  
  void run(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    a = 0;
    Object localObject = c;
    if (localObject != null) {
      Arrays.fill((int[])localObject, -1);
    }
    localObject = mLayout;
    if ((mAdapter != null) && (localObject != null) && (((RecyclerView.o)localObject).g()))
    {
      if (paramBoolean)
      {
        if (!mAdapterHelper.hasPendingUpdates()) {
          ((RecyclerView.o)localObject).onLayoutChildren(mAdapter.getItemCount(), this);
        }
      }
      else if (!paramRecyclerView.hasPendingAdapterUpdates()) {
        ((RecyclerView.o)localObject).fill(b, d, mState, this);
      }
      int i = a;
      if (i > b)
      {
        b = i;
        mState = paramBoolean;
        mRecycler.next();
      }
    }
  }
  
  void set()
  {
    int[] arrayOfInt = c;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
    a = 0;
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 0)
      {
        int i = a * 2;
        int[] arrayOfInt1 = c;
        if (arrayOfInt1 == null)
        {
          arrayOfInt1 = new int[4];
          c = arrayOfInt1;
          Arrays.fill(arrayOfInt1, -1);
        }
        else if (i >= arrayOfInt1.length)
        {
          int[] arrayOfInt2 = new int[i * 2];
          c = arrayOfInt2;
          System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
        }
        arrayOfInt1 = c;
        arrayOfInt1[i] = paramInt1;
        arrayOfInt1[(i + 1)] = paramInt2;
        a += 1;
        return;
      }
      throw new IllegalArgumentException("Pixel distance must be non-negative");
    }
    throw new IllegalArgumentException("Layout positions must be non-negative");
  }
}

package androidx.emoji2.text;

import android.util.SparseArray;

class f
{
  private i a;
  private final SparseArray<m.a> v;
  
  private f()
  {
    this(1);
  }
  
  f(int paramInt)
  {
    v = new SparseArray(paramInt);
  }
  
  f a(int paramInt)
  {
    SparseArray localSparseArray = v;
    if (localSparseArray == null) {
      return null;
    }
    return (f)localSparseArray.get(paramInt);
  }
  
  final i a()
  {
    return a;
  }
  
  void a(i paramI, int paramInt1, int paramInt2)
  {
    f localF2 = a(paramI.e(paramInt1));
    f localF1 = localF2;
    if (localF2 == null)
    {
      localF1 = new f();
      v.put(paramI.e(paramInt1), localF1);
    }
    if (paramInt2 > paramInt1)
    {
      localF1.a(paramI, paramInt1 + 1, paramInt2);
      return;
    }
    a = paramI;
  }
}

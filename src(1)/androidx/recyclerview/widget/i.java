package androidx.recyclerview.widget;

import android.view.View;

class i
{
  MethodWriter a;
  final ByteVector d;
  
  i(ByteVector paramByteVector)
  {
    d = paramByteVector;
    a = new MethodWriter();
  }
  
  View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = d.b();
    int k = d.a();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    Object localObject2;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject2)
    {
      View localView = d.getChildAt(paramInt1);
      int m = d.getDecoratedStart(localView);
      int n = d.getDecoratedEnd(localView);
      a.a(j, k, m, n);
      if (paramInt3 != 0)
      {
        a.e();
        a.a(paramInt3);
        if (a.a()) {
          return localView;
        }
      }
      localObject2 = localObject1;
      if (paramInt4 != 0)
      {
        a.e();
        a.a(paramInt4);
        localObject2 = localObject1;
        if (a.a()) {
          localObject2 = localView;
        }
      }
      paramInt1 += i;
    }
    return localObject1;
  }
  
  boolean a(View paramView, int paramInt)
  {
    a.a(d.b(), d.a(), d.getDecoratedStart(paramView), d.getDecoratedEnd(paramView));
    if (paramInt != 0)
    {
      a.e();
      a.a(paramInt);
      return a.a();
    }
    return false;
  }
}

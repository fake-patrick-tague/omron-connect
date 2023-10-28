package androidx.recyclerview.widget;

class MethodWriter
{
  int b;
  int f;
  int g;
  int i = 0;
  int q;
  
  MethodWriter() {}
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 == paramInt2) {
      return 2;
    }
    return 4;
  }
  
  void a(int paramInt)
  {
    i = (paramInt | i);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b = paramInt1;
    f = paramInt2;
    g = paramInt3;
    q = paramInt4;
  }
  
  boolean a()
  {
    int j = i;
    if (((j & 0x7) != 0) && ((j & a(g, b) << 0) == 0)) {
      return false;
    }
    j = i;
    if (((j & 0x70) != 0) && ((j & a(g, f) << 4) == 0)) {
      return false;
    }
    j = i;
    if (((j & 0x700) != 0) && ((j & a(q, b) << 8) == 0)) {
      return false;
    }
    j = i;
    return ((j & 0x7000) == 0) || ((j & a(q, f) << 12) != 0);
  }
  
  void e()
  {
    i = 0;
  }
}

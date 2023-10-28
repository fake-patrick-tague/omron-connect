package androidx.recyclerview.widget;

class Label
{
  private final int[] a;
  private final int k;
  
  Label(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    a = arrayOfInt;
    k = (arrayOfInt.length / 2);
  }
  
  int a(int paramInt)
  {
    return a[(paramInt + k)];
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a[(paramInt1 + k)] = paramInt2;
  }
  
  int[] a()
  {
    return a;
  }
}

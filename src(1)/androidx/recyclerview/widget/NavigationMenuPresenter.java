package androidx.recyclerview.widget;

class NavigationMenuPresenter
{
  int b;
  int c;
  int i;
  int j;
  
  public NavigationMenuPresenter() {}
  
  public NavigationMenuPresenter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c = paramInt1;
    i = paramInt2;
    j = paramInt3;
    b = paramInt4;
  }
  
  int b()
  {
    return i - c;
  }
  
  int e()
  {
    return b - j;
  }
}

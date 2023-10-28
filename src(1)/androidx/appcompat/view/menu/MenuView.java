package androidx.appcompat.view.menu;

public abstract interface MenuView
{
  public abstract void initialize(f paramF);
  
  public abstract interface ItemView
  {
    public abstract MenuItemImpl getItemData();
    
    public abstract void initialize(MenuItemImpl paramMenuItemImpl, int paramInt);
    
    public abstract boolean prefersCondensedTitle();
  }
}

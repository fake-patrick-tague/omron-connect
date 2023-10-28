package com.braze.ui.contentcards.recycler;

public abstract interface ItemTouchHelperAdapter
{
  public abstract boolean isItemDismissable(int paramInt);
  
  public abstract void onItemDismiss(int paramInt);
}

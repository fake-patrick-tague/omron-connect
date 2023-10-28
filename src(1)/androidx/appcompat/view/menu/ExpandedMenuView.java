package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.appcompat.widget.TintTypedArray;

public final class ExpandedMenuView
  extends ListView
  implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener
{
  private static final int[] TINT_ATTRS = { 16842964, 16843049 };
  private int mAnimations;
  private f mMenu;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    if (paramContext.hasValue(0)) {
      setBackgroundDrawable(paramContext.getDrawable(0));
    }
    if (paramContext.hasValue(1)) {
      setDivider(paramContext.getDrawable(1));
    }
    paramContext.recycle();
  }
  
  public int getWindowAnimations()
  {
    return mAnimations;
  }
  
  public void initialize(f paramF)
  {
    mMenu = paramF;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return mMenu.a(paramMenuItemImpl, 0);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    invokeItem((MenuItemImpl)getAdapter().getItem(paramInt));
  }
}

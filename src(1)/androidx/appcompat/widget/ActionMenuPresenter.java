package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView.b;
import androidx.appcompat.view.menu.Label;
import androidx.appcompat.view.menu.ListPopupWindow;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l.a;
import androidx.appcompat.view.menu.p;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.ArrayList;
import v7.internal.R.attr;
import v7.internal.R.layout;
import v7.internal.view.ActionBarPolicy;
import v7.v7.package_13.ActionProvider;
import v7.v7.package_13.ActionProvider.SubUiVisibilityListener;

class ActionMenuPresenter
  extends b
  implements ActionProvider.SubUiVisibilityListener
{
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  a mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  d mOverflowButton;
  e mOverflowPopup;
  private Drawable mPendingOverflowIcon;
  private boolean mPendingOverflowIconSet;
  private b mPopupCallback;
  final f mPopupPresenterCallback = new f();
  c mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.home, R.layout.folder);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    if (localViewGroup == null) {
      return null;
    }
    int j = localViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(i);
      if (((localView instanceof MenuView.ItemView)) && (((MenuView.ItemView)localView).getItemData() == paramMenuItem)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void a(f paramF, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.a(paramF, paramBoolean);
  }
  
  public boolean a(p paramP)
  {
    boolean bool1 = paramP.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject = paramP; ((p)localObject).s() != mMenu; localObject = (p)((p)localObject).s()) {}
    localObject = findViewForItem(((p)localObject).getItem());
    if (localObject == null) {
      return false;
    }
    mOpenSubMenuId = paramP.getItem().getItemId();
    int j = paramP.size();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      MenuItem localMenuItem = paramP.getItem(i);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    localObject = new a(mContext, paramP, (View)localObject);
    mActionButtonPopup = ((a)localObject);
    ((Label)localObject).b(bool1);
    mActionButtonPopup.show();
    super.a(paramP);
    return true;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    paramMenuItemImpl = (ActionMenuView)mMenuView;
    paramItemView = (ActionMenuItemView)paramItemView;
    paramItemView.setItemInvoker(paramMenuItemImpl);
    if (mPopupCallback == null) {
      mPopupCallback = new b();
    }
    paramItemView.setPopupCallback(mPopupCallback);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == mOverflowButton) {
      return false;
    }
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView2 = paramMenuItemImpl.getActionView();
    View localView1 = localView2;
    if ((localView2 == null) || (paramMenuItemImpl.hasCollapsibleActionView())) {
      localView1 = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
    }
    int i;
    if (paramMenuItemImpl.isActionViewExpanded()) {
      i = 8;
    } else {
      i = 0;
    }
    localView1.setVisibility(i);
    paramMenuItemImpl = (ActionMenuView)paramViewGroup;
    paramView = localView1.getLayoutParams();
    if (!paramMenuItemImpl.checkLayoutParams(paramView)) {
      localView1.setLayoutParams(paramMenuItemImpl.a(paramView));
    }
    return localView1;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    MenuView localMenuView = mMenuView;
    paramViewGroup = super.getMenuView(paramViewGroup);
    if (localMenuView != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public Drawable getOverflowIcon()
  {
    d localD = mOverflowButton;
    if (localD != null) {
      return localD.getDrawable();
    }
    if (mPendingOverflowIconSet) {
      return mPendingOverflowIcon;
    }
    return null;
  }
  
  public boolean hideOverflowMenu()
  {
    Object localObject = mPostedOpenRunnable;
    if (localObject != null)
    {
      MenuView localMenuView = mMenuView;
      if (localMenuView != null)
      {
        ((View)localMenuView).removeCallbacks((Runnable)localObject);
        mPostedOpenRunnable = null;
        return true;
      }
    }
    localObject = mOverflowPopup;
    if (localObject != null)
    {
      ((Label)localObject).dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hideSubMenus()
  {
    a localA = mActionButtonPopup;
    if (localA != null)
    {
      localA.dismiss();
      return true;
    }
    return false;
  }
  
  public void initForMenu(Context paramContext, f paramF)
  {
    super.initForMenu(paramContext, paramF);
    paramF = paramContext.getResources();
    paramContext = ActionBarPolicy.get(paramContext);
    if (!mReserveOverflowSet) {
      mReserveOverflow = paramContext.showsOverflowMenuButton();
    }
    if (!mWidthLimitSet) {
      mWidthLimit = paramContext.getEmbeddedMenuWidthLimit();
    }
    if (!mMaxItemsSet) {
      mMaxItems = paramContext.init();
    }
    int i = mWidthLimit;
    if (mReserveOverflow)
    {
      if (mOverflowButton == null)
      {
        paramContext = new d(mSystemContext);
        mOverflowButton = paramContext;
        if (mPendingOverflowIconSet)
        {
          paramContext.setImageDrawable(mPendingOverflowIcon);
          mPendingOverflowIcon = null;
          mPendingOverflowIconSet = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        mOverflowButton.measure(j, j);
      }
      i -= mOverflowButton.getMeasuredWidth();
    }
    else
    {
      mOverflowButton = null;
    }
    mActionItemWidthLimit = i;
    mMinCellSize = ((int)(getDisplayMetricsdensity * 56.0F));
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return (mPostedOpenRunnable != null) || (isOverflowMenuShowing());
  }
  
  public boolean isOverflowMenuShowing()
  {
    e localE = mOverflowPopup;
    return (localE != null) && (localE.equals());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!mMaxItemsSet) {
      mMaxItems = ActionBarPolicy.get(mContext).init();
    }
    paramConfiguration = mMenu;
    if (paramConfiguration != null) {
      paramConfiguration.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      return;
    }
    int i = openSubMenuId;
    if (i > 0)
    {
      paramParcelable = mMenu.findItem(i);
      if (paramParcelable != null) {
        a((p)paramParcelable.getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    openSubMenuId = mOpenSubMenuId;
    return localSavedState;
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(mMenu);
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    d localD = mOverflowButton;
    if (localD != null)
    {
      localD.setImageDrawable(paramDrawable);
      return;
    }
    mPendingOverflowIconSet = true;
    mPendingOverflowIcon = paramDrawable;
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    mReserveOverflow = paramBoolean;
    mReserveOverflowSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    if ((mReserveOverflow) && (!isOverflowMenuShowing()))
    {
      Object localObject = mMenu;
      if ((localObject != null) && (mMenuView != null) && (mPostedOpenRunnable == null) && (!((f)localObject).getNonActionItems().isEmpty()))
      {
        localObject = new c(new e(mContext, mMenu, mOverflowButton, true));
        mPostedOpenRunnable = ((c)localObject);
        ((View)mMenuView).post((Runnable)localObject);
        return true;
      }
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    super.updateMenuView(paramBoolean);
    ((View)mMenuView).requestLayout();
    Object localObject1 = mMenu;
    int j = 0;
    int k;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).getActionItems();
      k = ((ArrayList)localObject1).size();
      i = 0;
      while (i < k)
      {
        localObject2 = ((MenuItemImpl)((ArrayList)localObject1).get(i)).getSupportActionProvider();
        if (localObject2 != null) {
          ((ActionProvider)localObject2).setSubUiVisibilityListener(this);
        }
        i += 1;
      }
    }
    localObject1 = mMenu;
    if (localObject1 != null) {
      localObject1 = ((f)localObject1).getNonActionItems();
    } else {
      localObject1 = null;
    }
    int i = j;
    boolean bool;
    if (mReserveOverflow)
    {
      i = j;
      if (localObject1 != null)
      {
        k = ((ArrayList)localObject1).size();
        if (k == 1)
        {
          bool = ((MenuItemImpl)((ArrayList)localObject1).get(0)).isActionViewExpanded() ^ true;
        }
        else
        {
          bool = j;
          if (k > 0) {
            bool = true;
          }
        }
      }
    }
    if (bool)
    {
      if (mOverflowButton == null) {
        mOverflowButton = new d(mSystemContext);
      }
      localObject1 = (ViewGroup)mOverflowButton.getParent();
      if (localObject1 != mMenuView)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(mOverflowButton);
        }
        localObject1 = (ActionMenuView)mMenuView;
        ((ViewGroup)localObject1).addView(mOverflowButton, ((ActionMenuView)localObject1).generateOverflowButtonLayoutParams());
      }
    }
    else
    {
      localObject1 = mOverflowButton;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getParent();
        localObject2 = mMenuView;
        if (localObject1 == localObject2) {
          ((ViewGroup)localObject2).removeView(mOverflowButton);
        }
      }
    }
    ((ActionMenuView)mMenuView).setOverflowReserved(mReserveOverflow);
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      openSubMenuId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(openSubMenuId);
    }
    
    class a
      implements Parcelable.Creator<ActionMenuPresenter.SavedState>
    {
      a() {}
      
      public ActionMenuPresenter.SavedState[] a(int paramInt)
      {
        return new ActionMenuPresenter.SavedState[paramInt];
      }
      
      public ActionMenuPresenter.SavedState readDate(Parcel paramParcel)
      {
        return new ActionMenuPresenter.SavedState(paramParcel);
      }
    }
  }
  
  private class a
    extends Label
  {
    public a(Context paramContext, p paramP, View paramView)
    {
      super(paramP, paramView, false, R.attr.actionOverflowMenuStyle);
      if (!((MenuItemImpl)paramP.getItem()).isActionButton())
      {
        paramP = mOverflowButton;
        paramContext = paramP;
        if (paramP == null) {
          paramContext = (View)ActionMenuPresenter.getMenuView(ActionMenuPresenter.this);
        }
        a(paramContext);
      }
      a(mPopupPresenterCallback);
    }
    
    protected void onCloseMenu()
    {
      ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
      mActionButtonPopup = null;
      mOpenSubMenuId = 0;
      super.onCloseMenu();
    }
  }
  
  private class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public ListPopupWindow getPopup()
    {
      ActionMenuPresenter.a localA = mActionButtonPopup;
      if (localA != null) {
        return localA.b();
      }
      return null;
    }
  }
  
  private class c
    implements Runnable
  {
    private ActionMenuPresenter.e mPopup;
    
    public c(ActionMenuPresenter.e paramE)
    {
      mPopup = paramE;
    }
    
    public void run()
    {
      if (ActionMenuPresenter.access$setMOverflowPopup(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.access$getMMenu(ActionMenuPresenter.this).changeMenuMode();
      }
      View localView = (View)ActionMenuPresenter.access$getMMenuView(ActionMenuPresenter.this);
      if ((localView != null) && (localView.getWindowToken() != null) && (mPopup.draw())) {
        mOverflowPopup = mPopup;
      }
      mPostedOpenRunnable = null;
    }
  }
  
  private class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    public d(Context paramContext)
    {
      super(null, R.attr.save);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      TextUtils.setText(this, getContentDescription());
      setOnTouchListener(new a(this, ActionMenuPresenter.this));
    }
    
    public boolean needsDividerAfter()
    {
      return false;
    }
    
    public boolean needsDividerBefore()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      showOverflowMenu();
      return true;
    }
    
    protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        DrawableCompat.setHotspotBounds(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
    
    class a
      extends ListPopupWindow.ForwardingListener
    {
      a(View paramView, ActionMenuPresenter paramActionMenuPresenter)
      {
        super();
      }
      
      public ListPopupWindow getPopup()
      {
        ActionMenuPresenter.e localE = mOverflowPopup;
        if (localE == null) {
          return null;
        }
        return localE.b();
      }
      
      public boolean onForwardingStarted()
      {
        showOverflowMenu();
        return true;
      }
      
      public boolean onForwardingStopped()
      {
        ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
        if (mPostedOpenRunnable != null) {
          return false;
        }
        localActionMenuPresenter.hideOverflowMenu();
        return true;
      }
    }
  }
  
  private class e
    extends Label
  {
    public e(Context paramContext, f paramF, View paramView, boolean paramBoolean)
    {
      super(paramF, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
      b(8388613);
      a(mPopupPresenterCallback);
    }
    
    protected void onCloseMenu()
    {
      if (ActionMenuPresenter.onCloseMenu(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.a(ActionMenuPresenter.this).close();
      }
      mOverflowPopup = null;
      super.onCloseMenu();
    }
  }
  
  private class f
    implements l.a
  {
    f() {}
    
    public void onCloseMenu(f paramF, boolean paramBoolean)
    {
      if ((paramF instanceof p)) {
        paramF.getRootMenu().close(false);
      }
      l.a localA = getCallback();
      if (localA != null) {
        localA.onCloseMenu(paramF, paramBoolean);
      }
    }
    
    public boolean onOpenSubMenu(f paramF)
    {
      if (paramF == ActionMenuPresenter.access$getMActionButtonPopup(ActionMenuPresenter.this)) {
        return false;
      }
      mOpenSubMenuId = ((p)paramF).getItem().getItemId();
      l.a localA = getCallback();
      if (localA != null) {
        return localA.onOpenSubMenu(paramF);
      }
      return false;
    }
  }
}

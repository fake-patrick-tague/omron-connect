package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import v7.internal.i;

public final class MenuItemImpl
  implements v7.v7.internal.app.MenuItem
{
  private PorterDuff.Mode a = null;
  private boolean b = false;
  private CharSequence currentName;
  private int h = 4096;
  private int i = 4096;
  private boolean k = false;
  private ColorStateList l = null;
  private boolean m = false;
  private v7.v7.package_13.ActionProvider mActionProvider;
  private android.view.View mActionView;
  private final int mCategoryOrder;
  private MenuItem.OnMenuItemClickListener mClickListener;
  private CharSequence mContentDesc;
  private int mFlags = 16;
  private final int mGroup;
  private Drawable mIconDrawable;
  private int mIconResId = 0;
  private final int mId;
  private Intent mIntent;
  private boolean mIsActionViewExpanded = false;
  private Runnable mItemCallback;
  f mMenu;
  private ContextMenu.ContextMenuInfo mMenuInfo;
  private MenuItem.OnActionExpandListener mOnActionExpandListener;
  private final int mOrdering;
  private char mShortcutAlphabeticChar;
  private char mShortcutNumericChar;
  private int mShowAsAction = 0;
  private p mSubMenu;
  private CharSequence mTitle;
  private CharSequence mTitleCondensed;
  
  MenuItemImpl(f paramF, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    mMenu = paramF;
    mId = paramInt2;
    mGroup = paramInt1;
    mCategoryOrder = paramInt3;
    mOrdering = paramInt4;
    mTitle = paramCharSequence;
    mShowAsAction = paramInt5;
  }
  
  private Drawable getIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (k) {
        if (!m)
        {
          localDrawable = paramDrawable;
          if (!b) {}
        }
        else
        {
          localDrawable = DrawableCompat.getDrawable(paramDrawable).mutate();
          if (m) {
            DrawableCompat.append(localDrawable, l);
          }
          if (b) {
            DrawableCompat.setTintMode(localDrawable, a);
          }
          k = false;
        }
      }
    }
    return localDrawable;
  }
  
  private static void set(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  String a()
  {
    char c = getShortcut();
    if (c == 0) {
      return "";
    }
    Resources localResources = mMenu.getContext().getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(mMenu.getContext()).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(i.x));
    }
    int j;
    if (mMenu.isQwertyMode()) {
      j = i;
    } else {
      j = h;
    }
    set(localStringBuilder, j, 65536, localResources.getString(i.l));
    set(localStringBuilder, j, 4096, localResources.getString(i.m));
    set(localStringBuilder, j, 2, localResources.getString(i.c));
    set(localStringBuilder, j, 1, localResources.getString(i.t));
    set(localStringBuilder, j, 4, localResources.getString(i.g));
    set(localStringBuilder, j, 8, localResources.getString(i.n));
    if (c != '\b')
    {
      if (c != '\n')
      {
        if (c != ' ') {
          localStringBuilder.append(c);
        } else {
          localStringBuilder.append(localResources.getString(i.d));
        }
      }
      else {
        localStringBuilder.append(localResources.getString(i.f));
      }
    }
    else {
      localStringBuilder.append(localResources.getString(i.i));
    }
    return localStringBuilder.toString();
  }
  
  public v7.v7.internal.app.MenuItem a(int paramInt)
  {
    Context localContext = mMenu.getContext();
    a(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
    return this;
  }
  
  public v7.v7.internal.app.MenuItem a(android.view.View paramView)
  {
    mActionView = paramView;
    mActionProvider = null;
    if ((paramView != null) && (paramView.getId() == -1))
    {
      int j = mId;
      if (j > 0) {
        paramView.setId(j);
      }
    }
    mMenu.onItemActionRequestChanged(this);
    return this;
  }
  
  public void actionFormatChanged()
  {
    mMenu.onItemActionRequestChanged(this);
  }
  
  public boolean collapseActionView()
  {
    if ((mShowAsAction & 0x8) == 0) {
      return false;
    }
    if (mActionView == null) {
      return true;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = mOnActionExpandListener;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionCollapse(this))) {
      return false;
    }
    return mMenu.collapseItemActionView(this);
  }
  
  public boolean expandActionView()
  {
    if (!hasCollapsibleActionView()) {
      return false;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = mOnActionExpandListener;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionExpand(this))) {
      return false;
    }
    return mMenu.expandItemActionView(this);
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public android.view.View getActionView()
  {
    Object localObject = mActionView;
    if (localObject != null) {
      return localObject;
    }
    localObject = mActionProvider;
    if (localObject != null)
    {
      localObject = ((v7.v7.package_13.ActionProvider)localObject).onCreateActionView(this);
      mActionView = ((android.view.View)localObject);
      return localObject;
    }
    return null;
  }
  
  public int getAlphabeticModifiers()
  {
    return i;
  }
  
  public char getAlphabeticShortcut()
  {
    return mShortcutAlphabeticChar;
  }
  
  public CharSequence getContentDescription()
  {
    return mContentDesc;
  }
  
  public int getGroupId()
  {
    return mGroup;
  }
  
  public Drawable getIcon()
  {
    Drawable localDrawable = mIconDrawable;
    if (localDrawable != null) {
      return getIcon(localDrawable);
    }
    if (mIconResId != 0)
    {
      localDrawable = v7.internal.transition.util.View.getDrawable(mMenu.getContext(), mIconResId);
      mIconResId = 0;
      mIconDrawable = localDrawable;
      return getIcon(localDrawable);
    }
    return null;
  }
  
  public ColorStateList getIconTintList()
  {
    return l;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return a;
  }
  
  public Intent getIntent()
  {
    return mIntent;
  }
  
  public int getItemId()
  {
    return mId;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return mMenuInfo;
  }
  
  public int getNumericModifiers()
  {
    return h;
  }
  
  public char getNumericShortcut()
  {
    return mShortcutNumericChar;
  }
  
  public int getOrder()
  {
    return mCategoryOrder;
  }
  
  public int getOrdering()
  {
    return mOrdering;
  }
  
  char getShortcut()
  {
    if (mMenu.isQwertyMode()) {
      return mShortcutAlphabeticChar;
    }
    return mShortcutNumericChar;
  }
  
  public SubMenu getSubMenu()
  {
    return mSubMenu;
  }
  
  public v7.v7.package_13.ActionProvider getSupportActionProvider()
  {
    return mActionProvider;
  }
  
  public CharSequence getTitle()
  {
    return mTitle;
  }
  
  public CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = mTitleCondensed;
    if (localCharSequence == null) {
      localCharSequence = mTitle;
    }
    if ((Build.VERSION.SDK_INT < 18) && (localCharSequence != null) && (!(localCharSequence instanceof String))) {
      return localCharSequence.toString();
    }
    return localCharSequence;
  }
  
  CharSequence getTitleForItemView(MenuView.ItemView paramItemView)
  {
    if ((paramItemView != null) && (paramItemView.prefersCondensedTitle())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public CharSequence getTooltipText()
  {
    return currentName;
  }
  
  public boolean hasCollapsibleActionView()
  {
    if ((mShowAsAction & 0x8) != 0)
    {
      if (mActionView == null)
      {
        v7.v7.package_13.ActionProvider localActionProvider = mActionProvider;
        if (localActionProvider != null) {
          mActionView = localActionProvider.onCreateActionView(this);
        }
      }
      if (mActionView != null) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasSubMenu()
  {
    return mSubMenu != null;
  }
  
  public boolean invoke()
  {
    Object localObject = mClickListener;
    if ((localObject != null) && (((MenuItem.OnMenuItemClickListener)localObject).onMenuItemClick(this))) {
      return true;
    }
    localObject = mMenu;
    if (((f)localObject).dispatchMenuItemSelected((f)localObject, this)) {
      return true;
    }
    localObject = mItemCallback;
    if (localObject != null)
    {
      ((Runnable)localObject).run();
      return true;
    }
    if (mIntent != null)
    {
      localObject = mMenu;
      try
      {
        localObject = ((f)localObject).getContext();
        Intent localIntent = mIntent;
        ((Context)localObject).startActivity(localIntent);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
      }
    }
    v7.v7.package_13.ActionProvider localActionProvider = mActionProvider;
    return (localActionProvider != null) && (localActionProvider.onPerformDefaultAction());
  }
  
  public boolean isActionButton()
  {
    return (mFlags & 0x20) == 32;
  }
  
  public boolean isActionViewExpanded()
  {
    return mIsActionViewExpanded;
  }
  
  public boolean isCheckable()
  {
    return (mFlags & 0x1) == 1;
  }
  
  public boolean isChecked()
  {
    return (mFlags & 0x2) == 2;
  }
  
  public boolean isEnabled()
  {
    return (mFlags & 0x10) != 0;
  }
  
  public boolean isExclusiveCheckable()
  {
    return (mFlags & 0x4) != 0;
  }
  
  public boolean isVisible()
  {
    v7.v7.package_13.ActionProvider localActionProvider = mActionProvider;
    if ((localActionProvider != null) && (localActionProvider.overridesItemVisibility())) {
      return ((mFlags & 0x8) == 0) && (mActionProvider.isVisible());
    }
    return (mFlags & 0x8) == 0;
  }
  
  public boolean requestsActionButton()
  {
    return (mShowAsAction & 0x1) == 1;
  }
  
  public boolean requiresActionButton()
  {
    return (mShowAsAction & 0x2) == 2;
  }
  
  public android.view.MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public void setActionViewExpanded(boolean paramBoolean)
  {
    mIsActionViewExpanded = paramBoolean;
    mMenu.onItemsChanged(false);
  }
  
  public android.view.MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (mShortcutAlphabeticChar == paramChar) {
      return this;
    }
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((mShortcutAlphabeticChar == paramChar) && (i == paramInt)) {
      return this;
    }
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    i = KeyEvent.normalizeMetaState(paramInt);
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setCheckable(boolean paramBoolean)
  {
    int j = mFlags;
    int n = paramBoolean | j & 0xFFFFFFFE;
    mFlags = n;
    if (j != n) {
      mMenu.onItemsChanged(false);
    }
    return this;
  }
  
  public android.view.MenuItem setChecked(boolean paramBoolean)
  {
    if ((mFlags & 0x4) != 0)
    {
      mMenu.setExclusiveItemChecked(this);
      return this;
    }
    setCheckedInt(paramBoolean);
    return this;
  }
  
  public v7.v7.internal.app.MenuItem setChecked(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  void setCheckedInt(boolean paramBoolean)
  {
    int n = mFlags;
    int j;
    if (paramBoolean) {
      j = 2;
    } else {
      j = 0;
    }
    j |= n & 0xFFFFFFFD;
    mFlags = j;
    if (n != j) {
      mMenu.onItemsChanged(false);
    }
  }
  
  public v7.v7.internal.app.MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    mContentDesc = paramCharSequence;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      mFlags |= 0x10;
    } else {
      mFlags &= 0xFFFFFFEF;
    }
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    int n = mFlags;
    int j;
    if (paramBoolean) {
      j = 4;
    } else {
      j = 0;
    }
    mFlags = (j | n & 0xFFFFFFFB);
  }
  
  public android.view.MenuItem setIcon(int paramInt)
  {
    mIconDrawable = null;
    mIconResId = paramInt;
    k = true;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setIcon(Drawable paramDrawable)
  {
    mIconResId = 0;
    mIconDrawable = paramDrawable;
    k = true;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    l = paramColorStateList;
    m = true;
    k = true;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    a = paramMode;
    b = true;
    k = true;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setIntent(Intent paramIntent)
  {
    mIntent = paramIntent;
    return this;
  }
  
  public void setIsActionButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mFlags |= 0x20;
      return;
    }
    mFlags &= 0xFFFFFFDF;
  }
  
  void setMenuInfo(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    mMenuInfo = paramContextMenuInfo;
  }
  
  public android.view.MenuItem setNumericShortcut(char paramChar)
  {
    if (mShortcutNumericChar == paramChar) {
      return this;
    }
    mShortcutNumericChar = paramChar;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((mShortcutNumericChar == paramChar) && (h == paramInt)) {
      return this;
    }
    mShortcutNumericChar = paramChar;
    h = KeyEvent.normalizeMetaState(paramInt);
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    mOnActionExpandListener = paramOnActionExpandListener;
    return this;
  }
  
  public android.view.MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    mClickListener = paramOnMenuItemClickListener;
    return this;
  }
  
  public android.view.MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    mShortcutNumericChar = paramChar1;
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    mShortcutNumericChar = paramChar1;
    h = KeyEvent.normalizeMetaState(paramInt1);
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    i = KeyEvent.normalizeMetaState(paramInt2);
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    int j = paramInt & 0x3;
    if ((j != 0) && (j != 1) && (j != 2)) {
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    mShowAsAction = paramInt;
    mMenu.onItemActionRequestChanged(this);
  }
  
  public void setSubMenu(p paramP)
  {
    mSubMenu = paramP;
    paramP.setHeaderTitle(getTitle());
  }
  
  public v7.v7.internal.app.MenuItem setSupportActionProvider(v7.v7.package_13.ActionProvider paramActionProvider)
  {
    v7.v7.package_13.ActionProvider localActionProvider = mActionProvider;
    if (localActionProvider != null) {
      localActionProvider.reset();
    }
    mActionView = null;
    mActionProvider = paramActionProvider;
    mMenu.onItemsChanged(true);
    paramActionProvider = mActionProvider;
    if (paramActionProvider != null) {
      paramActionProvider.setVisibilityListener(new MenuItemImpl.1(this));
    }
    return this;
  }
  
  public android.view.MenuItem setTitle(int paramInt)
  {
    return setTitle(mMenu.getContext().getString(paramInt));
  }
  
  public android.view.MenuItem setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    mMenu.onItemsChanged(false);
    p localP = mSubMenu;
    if (localP != null) {
      localP.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public android.view.MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    mTitleCondensed = paramCharSequence;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public v7.v7.internal.app.MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    currentName = paramCharSequence;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public android.view.MenuItem setVisible(boolean paramBoolean)
  {
    if (setVisibleInt(paramBoolean)) {
      mMenu.onItemVisibleChanged(this);
    }
    return this;
  }
  
  boolean setVisibleInt(boolean paramBoolean)
  {
    int n = mFlags;
    int j;
    if (paramBoolean) {
      j = 0;
    } else {
      j = 8;
    }
    j |= n & 0xFFFFFFF7;
    mFlags = j;
    return n != j;
  }
  
  public boolean shouldShowIcon()
  {
    return mMenu.getOptionalIconsVisible();
  }
  
  boolean shouldShowShortcut()
  {
    return (mMenu.isShortcutsVisible()) && (getShortcut() != 0);
  }
  
  public boolean showsTextAsAction()
  {
    return (mShowAsAction & 0x4) == 4;
  }
  
  public String toString()
  {
    CharSequence localCharSequence = mTitle;
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
}

package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class ActionMenuItem
  implements v7.v7.internal.app.MenuItem
{
  private boolean b = false;
  private boolean c = false;
  private CharSequence currentName;
  private int i = 4096;
  private Drawable j;
  private int k = 4096;
  private PorterDuff.Mode l = null;
  private ColorStateList m = null;
  private MenuItem.OnMenuItemClickListener mClickListener;
  private CharSequence mContentDesc;
  private Context mContext;
  private int mFlags = 16;
  private final int mGroup;
  private final int mId;
  private Intent mIntent;
  private final int mOrdering;
  private char mShortcutAlphabeticChar;
  private char mShortcutNumericChar;
  private CharSequence mTitle;
  private CharSequence mTitleCondensed;
  
  public ActionMenuItem(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence)
  {
    mContext = paramContext;
    mId = paramInt2;
    mGroup = paramInt1;
    mOrdering = paramInt4;
    mTitle = paramCharSequence;
  }
  
  private void setIcon()
  {
    Drawable localDrawable = j;
    if ((localDrawable != null) && ((c) || (b)))
    {
      localDrawable = DrawableCompat.getDrawable(localDrawable);
      j = localDrawable;
      localDrawable = localDrawable.mutate();
      j = localDrawable;
      if (c) {
        DrawableCompat.append(localDrawable, m);
      }
      if (b) {
        DrawableCompat.setTintMode(j, l);
      }
    }
  }
  
  public v7.v7.internal.app.MenuItem a(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public v7.v7.internal.app.MenuItem a(View paramView)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public boolean expandActionView()
  {
    return false;
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public View getActionView()
  {
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
    return j;
  }
  
  public ColorStateList getIconTintList()
  {
    return m;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return l;
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
    return null;
  }
  
  public int getNumericModifiers()
  {
    return k;
  }
  
  public char getNumericShortcut()
  {
    return mShortcutNumericChar;
  }
  
  public int getOrder()
  {
    return mOrdering;
  }
  
  public SubMenu getSubMenu()
  {
    return null;
  }
  
  public v7.v7.package_13.ActionProvider getSupportActionProvider()
  {
    return null;
  }
  
  public CharSequence getTitle()
  {
    return mTitle;
  }
  
  public CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = mTitleCondensed;
    if (localCharSequence != null) {
      return localCharSequence;
    }
    return mTitle;
  }
  
  public CharSequence getTooltipText()
  {
    return currentName;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    return (mFlags & 0x1) != 0;
  }
  
  public boolean isChecked()
  {
    return (mFlags & 0x2) != 0;
  }
  
  public boolean isEnabled()
  {
    return (mFlags & 0x10) != 0;
  }
  
  public boolean isVisible()
  {
    return (mFlags & 0x8) == 0;
  }
  
  public android.view.MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public android.view.MenuItem setAlphabeticShortcut(char paramChar)
  {
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    return this;
  }
  
  public android.view.MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    i = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public android.view.MenuItem setCheckable(boolean paramBoolean)
  {
    mFlags = (paramBoolean | mFlags & 0xFFFFFFFE);
    return this;
  }
  
  public android.view.MenuItem setChecked(boolean paramBoolean)
  {
    int i1 = mFlags;
    int n;
    if (paramBoolean) {
      n = 2;
    } else {
      n = 0;
    }
    mFlags = (n | i1 & 0xFFFFFFFD);
    return this;
  }
  
  public v7.v7.internal.app.MenuItem setChecked(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public v7.v7.internal.app.MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    mContentDesc = paramCharSequence;
    return this;
  }
  
  public android.view.MenuItem setEnabled(boolean paramBoolean)
  {
    int i1 = mFlags;
    int n;
    if (paramBoolean) {
      n = 16;
    } else {
      n = 0;
    }
    mFlags = (n | i1 & 0xFFFFFFEF);
    return this;
  }
  
  public android.view.MenuItem setIcon(int paramInt)
  {
    j = ContextCompat.getDrawable(mContext, paramInt);
    setIcon();
    return this;
  }
  
  public android.view.MenuItem setIcon(Drawable paramDrawable)
  {
    j = paramDrawable;
    setIcon();
    return this;
  }
  
  public android.view.MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    m = paramColorStateList;
    c = true;
    setIcon();
    return this;
  }
  
  public android.view.MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    l = paramMode;
    b = true;
    setIcon();
    return this;
  }
  
  public android.view.MenuItem setIntent(Intent paramIntent)
  {
    mIntent = paramIntent;
    return this;
  }
  
  public android.view.MenuItem setNumericShortcut(char paramChar)
  {
    mShortcutNumericChar = paramChar;
    return this;
  }
  
  public android.view.MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    mShortcutNumericChar = paramChar;
    k = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public android.view.MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
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
    return this;
  }
  
  public android.view.MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    mShortcutNumericChar = paramChar1;
    k = KeyEvent.normalizeMetaState(paramInt1);
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    i = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public v7.v7.internal.app.MenuItem setSupportActionProvider(v7.v7.package_13.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public android.view.MenuItem setTitle(int paramInt)
  {
    mTitle = mContext.getResources().getString(paramInt);
    return this;
  }
  
  public android.view.MenuItem setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    return this;
  }
  
  public android.view.MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    mTitleCondensed = paramCharSequence;
    return this;
  }
  
  public v7.v7.internal.app.MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    currentName = paramCharSequence;
    return this;
  }
  
  public android.view.MenuItem setVisible(boolean paramBoolean)
  {
    int i1 = mFlags;
    int n = 8;
    if (paramBoolean) {
      n = 0;
    }
    mFlags = (i1 & 0x8 | n);
    return this;
  }
}

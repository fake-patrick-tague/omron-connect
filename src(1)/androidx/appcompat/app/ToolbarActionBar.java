package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l.a;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.g;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import java.util.ArrayList;
import v7.v7.package_13.ViewCompat;
import v7.v7.util.Log;

class ToolbarActionBar
  extends ActionBar
{
  private ArrayList<ActionBar.a> A = new ArrayList();
  private boolean b;
  final DecorToolbar mDecorToolbar;
  private boolean mMenuCallbackSet;
  private final Toolbar.g mMenuClicker;
  private final Runnable mMenuInvalidator = new DayFragment.1(this);
  boolean mOptionsMenuInvalidated;
  final WindowCallback mWindow;
  final Window.Callback mWindowCallback;
  
  ToolbarActionBar(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    SearchFragment.4 local4 = new SearchFragment.4(this);
    mMenuClicker = local4;
    Log.valueOf(paramToolbar);
    ToolbarWidgetWrapper localToolbarWidgetWrapper = new ToolbarWidgetWrapper(paramToolbar, false);
    mDecorToolbar = localToolbarWidgetWrapper;
    mWindowCallback = ((Window.Callback)Log.valueOf(paramCallback));
    localToolbarWidgetWrapper.setWindowCallback(paramCallback);
    paramToolbar.setOnMenuItemClickListener(local4);
    localToolbarWidgetWrapper.setWindowTitle(paramCharSequence);
    mWindow = new ActionBarActivityDelegate.1(this);
  }
  
  private Menu getMenu()
  {
    if (!mMenuCallbackSet)
    {
      mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(), new ActionMenuView.MenuBuilderCallback(this));
      mMenuCallbackSet = true;
    }
    return mDecorToolbar.getMenu();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == b) {
      return;
    }
    b = paramBoolean;
    int j = A.size();
    int i = 0;
    while (i < j)
    {
      ((ActionBar.a)A.get(i)).visitMethodInsn(paramBoolean);
      i += 1;
    }
  }
  
  public boolean collapseActionView()
  {
    if (mDecorToolbar.hasExpandedActionView())
    {
      mDecorToolbar.collapseActionView();
      return true;
    }
    return false;
  }
  
  public View getCustomView()
  {
    return mDecorToolbar.getCustomView();
  }
  
  public int getDisplayOptions()
  {
    return mDecorToolbar.getDisplayOptions();
  }
  
  public int getHeight()
  {
    return mDecorToolbar.getHeight();
  }
  
  public Context getThemedContext()
  {
    return mDecorToolbar.getContext();
  }
  
  public void hide()
  {
    mDecorToolbar.setVisibility(8);
  }
  
  public boolean invalidateOptionsMenu()
  {
    mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
    ViewCompat.postOnAnimation(mDecorToolbar.getViewGroup(), mMenuInvalidator);
    return true;
  }
  
  public boolean isShowing()
  {
    return mDecorToolbar.hideOverflowMenu();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  void onDestroy()
  {
    mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = getMenu();
    if (localMenu != null)
    {
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      }
      int i = KeyCharacterMap.load(i).getKeyboardType();
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      localMenu.setQwertyMode(bool);
      return localMenu.performShortcut(paramInt, paramKeyEvent, 0);
    }
    return false;
  }
  
  public boolean onKeyShortcut(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      openOptionsMenu();
    }
    return true;
  }
  
  public boolean openOptionsMenu()
  {
    return mDecorToolbar.showOverflowMenu();
  }
  
  void populateOptionsMenu()
  {
    Menu localMenu = getMenu();
    f localF;
    if ((localMenu instanceof f)) {
      localF = (f)localMenu;
    } else {
      localF = null;
    }
    if (localF != null) {
      localF.stopDispatchingItemsChanged();
    }
    try
    {
      localMenu.clear();
      boolean bool = mWindowCallback.onCreatePanelMenu(0, localMenu);
      if (bool)
      {
        bool = mWindowCallback.onPreparePanel(0, null, localMenu);
        if (bool) {}
      }
      else
      {
        localMenu.clear();
      }
      if (localF != null)
      {
        localF.startDispatchingItemsChanged();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (localF != null) {
        localF.startDispatchingItemsChanged();
      }
      throw localThrowable;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    mDecorToolbar.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    mDecorToolbar.setCustomView(paramView);
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {}
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    setDisplayOptions(i, 4);
  }
  
  public void setDisplayOptions(int paramInt)
  {
    setDisplayOptions(paramInt, -1);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = mDecorToolbar.getDisplayOptions();
    mDecorToolbar.setDisplayOptions(paramInt1 & paramInt2 | paramInt2 & i);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 16;
    } else {
      i = 0;
    }
    setDisplayOptions(i, 16);
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 0;
    }
    setDisplayOptions(i, 2);
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    setDisplayOptions(i, 8);
  }
  
  public void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(mDecorToolbar.getViewGroup(), paramFloat);
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    mDecorToolbar.setNavigationIcon(paramInt);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setLogo(Drawable paramDrawable)
  {
    mDecorToolbar.setLogo(paramDrawable);
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean) {}
  
  public void setTitle(int paramInt)
  {
    DecorToolbar localDecorToolbar = mDecorToolbar;
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = localDecorToolbar.getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    localDecorToolbar.setTitle(localCharSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setTitle(paramCharSequence);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public void show()
  {
    mDecorToolbar.setVisibility(0);
  }
  
  final class ActionMenuPresenterCallback
    implements l.a
  {
    private boolean mClosingActionMenu;
    
    ActionMenuPresenterCallback() {}
    
    public void onCloseMenu(f paramF, boolean paramBoolean)
    {
      if (mClosingActionMenu) {
        return;
      }
      mClosingActionMenu = true;
      mDecorToolbar.dismissPopupMenus();
      mWindowCallback.onPanelClosed(108, paramF);
      mClosingActionMenu = false;
    }
    
    public boolean onOpenSubMenu(f paramF)
    {
      mWindowCallback.onMenuOpened(108, paramF);
      return true;
    }
  }
}

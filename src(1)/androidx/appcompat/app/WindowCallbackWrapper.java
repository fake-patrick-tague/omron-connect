package androidx.appcompat.app;

import android.os.Build.VERSION;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.f;
import java.util.List;
import v7.internal.view.SupportActionModeWrapper.CallbackWrapper;

class WindowCallbackWrapper
  extends v7.internal.view.WindowCallbackWrapper
{
  private boolean isOpen;
  private boolean mEatKeyUpEvent;
  private boolean mUpdated;
  private WindowCallback mWrapped;
  
  WindowCallbackWrapper(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (mEatKeyUpEvent) {
      return getDelegate().dispatchKeyEvent(paramKeyEvent);
    }
    return (this$0.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchKeyEvent(Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    try
    {
      mEatKeyUpEvent = true;
      boolean bool = paramCallback.dispatchKeyEvent(paramKeyEvent);
      mEatKeyUpEvent = false;
      return bool;
    }
    catch (Throwable paramCallback)
    {
      mEatKeyUpEvent = false;
      throw paramCallback;
    }
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (this$0.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
  }
  
  public void onContentChanged()
  {
    if (mUpdated) {
      getDelegate().onContentChanged();
    }
  }
  
  public void onContentChanged(Window.Callback paramCallback)
  {
    try
    {
      mUpdated = true;
      paramCallback.onContentChanged();
      mUpdated = false;
      return;
    }
    catch (Throwable paramCallback)
    {
      mUpdated = false;
      throw paramCallback;
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) && (!(paramMenu instanceof f))) {
      return false;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    Object localObject = mWrapped;
    if (localObject != null)
    {
      localObject = ((WindowCallback)localObject).onCreatePanelView(paramInt);
      if (localObject != null) {
        return localObject;
      }
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    super.onMenuOpened(paramInt, paramMenu);
    this$0.onMenuOpened(paramInt);
    return true;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    if (isOpen)
    {
      getDelegate().onPanelClosed(paramInt, paramMenu);
      return;
    }
    super.onPanelClosed(paramInt, paramMenu);
    this$0.onPanelClosed(paramInt);
  }
  
  public void onPanelClosed(Window.Callback paramCallback, int paramInt, Menu paramMenu)
  {
    try
    {
      isOpen = true;
      paramCallback.onPanelClosed(paramInt, paramMenu);
      isOpen = false;
      return;
    }
    catch (Throwable paramCallback)
    {
      isOpen = false;
      throw paramCallback;
    }
  }
  
  void onPanelClosed(WindowCallback paramWindowCallback)
  {
    mWrapped = paramWindowCallback;
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    f localF;
    if ((paramMenu instanceof f)) {
      localF = (f)paramMenu;
    } else {
      localF = null;
    }
    if ((paramInt == 0) && (localF == null)) {
      return false;
    }
    boolean bool1 = true;
    if (localF != null) {
      localF.setOverrideVisibleItems(true);
    }
    WindowCallback localWindowCallback = mWrapped;
    if ((localWindowCallback == null) || (!localWindowCallback.onPreparePanel(paramInt))) {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
    }
    if (localF != null) {
      localF.setOverrideVisibleItems(false);
    }
    return bool2;
  }
  
  public void onProvideKeyboardShortcuts(List paramList, Menu paramMenu, int paramInt)
  {
    Object localObject = this$0.getPanelState(0, true);
    if (localObject != null)
    {
      localObject = menu;
      if (localObject != null)
      {
        super.onProvideKeyboardShortcuts(paramList, (Menu)localObject, paramInt);
        return;
      }
    }
    super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return null;
    }
    if (this$0.isHandleNativeActionModesEnabled()) {
      return startAsSupportActionMode(paramCallback);
    }
    return super.onWindowStartingActionMode(paramCallback);
  }
  
  public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    if ((this$0.isHandleNativeActionModesEnabled()) && (paramInt == 0)) {
      return startAsSupportActionMode(paramCallback);
    }
    return super.onWindowStartingActionMode(paramCallback, paramInt);
  }
  
  final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback paramCallback)
  {
    paramCallback = new SupportActionModeWrapper.CallbackWrapper(this$0.mContext, paramCallback);
    v7.internal.view.ActionMode localActionMode = this$0.startSupportActionMode(paramCallback);
    if (localActionMode != null) {
      return paramCallback.getActionModeWrapper(localActionMode);
    }
    return null;
  }
}

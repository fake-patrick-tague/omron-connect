package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import v7.internal.R.styleable;
import v7.internal.view.ActionMode;
import v7.internal.view.ActionMode.Callback;

public abstract class ActionBar
{
  public ActionBar() {}
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean collapseActionView();
  
  public abstract View getCustomView();
  
  public abstract int getDisplayOptions();
  
  public abstract int getHeight();
  
  public abstract Context getThemedContext();
  
  public abstract void hide();
  
  public boolean invalidateOptionsMenu()
  {
    return false;
  }
  
  public boolean isShowing()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  void onDestroy() {}
  
  public abstract boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent);
  
  public boolean onKeyShortcut(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean openOptionsMenu()
  {
    return false;
  }
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setCustomView(View paramView, LayoutParams paramLayoutParams);
  
  public abstract void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean);
  
  public abstract void setDisplayHomeAsUpEnabled(boolean paramBoolean);
  
  public abstract void setDisplayOptions(int paramInt);
  
  public abstract void setDisplayShowCustomEnabled(boolean paramBoolean);
  
  public abstract void setDisplayShowHomeEnabled(boolean paramBoolean);
  
  public abstract void setDisplayShowTitleEnabled(boolean paramBoolean);
  
  public abstract void setElevation(float paramFloat);
  
  public abstract void setHomeAsUpIndicator(int paramInt);
  
  public abstract void setHomeButtonEnabled(boolean paramBoolean);
  
  public abstract void setLogo(Drawable paramDrawable);
  
  public abstract void setShowHideAnimationEnabled(boolean paramBoolean);
  
  public abstract void setTitle(int paramInt);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
  
  public abstract void show();
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      gravity = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
      gravity = paramContext.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      gravity = gravity;
    }
  }
  
  public static abstract interface a
  {
    public abstract void visitMethodInsn(boolean paramBoolean);
  }
  
  @Deprecated
  public static abstract class b
  {
    public b() {}
    
    public abstract void clear();
    
    public abstract View getCustomView();
    
    public abstract Drawable getIcon();
    
    public abstract CharSequence getName();
    
    public abstract CharSequence getText();
  }
}

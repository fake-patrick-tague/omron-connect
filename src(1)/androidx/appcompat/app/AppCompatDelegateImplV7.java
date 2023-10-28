package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.BaseBundle;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Adapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.l.a;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.Attribute;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.content.ContextCompat;
import androidx.core.package_10.ActivityCompat;
import androidx.core.package_10.NavUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import java.lang.reflect.Constructor;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import v7.internal.R.attr;
import v7.internal.R.layout;
import v7.internal.R.style;
import v7.internal.R.styleable;
import v7.internal.view.ActionMode;
import v7.internal.view.ActionMode.Callback;
import v7.internal.view.SupportMenuInflater;
import v7.util.SimpleArrayMap;
import v7.v7.menu.Label;
import v7.v7.package_13.LayoutInflaterCompatHC;
import v7.v7.package_13.ViewPropertyAnimatorCompat;

class AppCompatDelegateImplV7
  extends f
  implements MenuBuilder.Callback, LayoutInflater.Factory2
{
  private static final int[] a;
  private static final boolean b;
  private static final boolean l;
  private static boolean o;
  private static final c.e.g<String, Integer> t = new SimpleArrayMap();
  private static final boolean y;
  private int active;
  private int count = -100;
  private boolean d;
  private OnBackInvokedDispatcher data;
  private InactivityTimer f;
  ActionBar mActionBar;
  private ActionMenuPresenterCallback mActionMenuPresenterCallback;
  ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  final AppCompatCallback mAppCompatCallback;
  private AppCompatViewInflater mAppCompatViewInflater;
  private boolean mClosingActionMenu;
  final android.content.Context mContext;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  ViewPropertyAnimatorCompat mFadeAnim = null;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private boolean mHandleNativeActionModes = true;
  boolean mHasActionBar;
  int mInvalidatePanelMenuFeatures;
  boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new MonthByWeekFragment.2(this);
  boolean mIsDestroyed;
  boolean mIsFloating;
  private boolean mLongPressBackDown;
  MenuInflater mMenuInflater;
  private WindowCallbackWrapper mOriginalWindowCallback;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private PanelFeatureState[] mPanels;
  private PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private android.view.View mStatusGuard;
  ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private TextView mTitleView;
  Window mWindow;
  boolean mWindowNoTitle;
  private int preferences;
  private boolean r;
  private OnBackInvokedCallback result;
  private boolean s;
  final Object this$0;
  private CharSequence title;
  private Configuration v;
  private l w;
  private InactivityTimer x;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1;
    if (i < 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    y = bool1;
    a = new int[] { 16842836 };
    b = "robolectric".equals(Build.FINGERPRINT) ^ true;
    if (i >= 17) {
      bool2 = true;
    }
    l = bool2;
    if ((bool1) && (!o))
    {
      Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
      o = true;
    }
  }
  
  AppCompatDelegateImplV7(Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    this(paramActivity, null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImplV7(Dialog paramDialog, AppCompatCallback paramAppCompatCallback)
  {
    this(paramDialog.getContext(), paramDialog.getWindow(), paramAppCompatCallback, paramDialog);
  }
  
  private AppCompatDelegateImplV7(android.content.Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback, Object paramObject)
  {
    mContext = paramContext;
    mAppCompatCallback = paramAppCompatCallback;
    this$0 = paramObject;
    if ((count == -100) && ((paramObject instanceof Dialog)))
    {
      paramContext = inflate();
      if (paramContext != null) {
        count = paramContext.getDelegate().size();
      }
    }
    if (count == -100)
    {
      paramContext = t;
      paramAppCompatCallback = (Integer)paramContext.get(paramObject.getClass().getName());
      if (paramAppCompatCallback != null)
      {
        count = paramAppCompatCallback.intValue();
        paramContext.remove(paramObject.getClass().getName());
      }
    }
    if (paramWindow != null) {
      a(paramWindow);
    }
    androidx.appcompat.widget.ViewCompat.set();
  }
  
  private Configuration a(android.content.Context paramContext, int paramInt, Label paramLabel, Configuration paramConfiguration, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramBoolean) {
          paramInt = 0;
        } else {
          paramInt = getApplicationContextgetResourcesgetConfigurationuiMode & 0x30;
        }
      }
      else {
        paramInt = 32;
      }
    }
    else {
      paramInt = 16;
    }
    paramContext = new Configuration();
    fontScale = 0.0F;
    if (paramConfiguration != null) {
      paramContext.setTo(paramConfiguration);
    }
    uiMode = (paramInt | uiMode & 0xFFFFFFCF);
    if (paramLabel != null) {
      init(paramContext, paramLabel);
    }
    return paramContext;
  }
  
  private void a(android.view.View paramView)
  {
    int i;
    if ((v7.v7.package_13.ViewCompat.setElevation(paramView) & 0x2000) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = ContextCompat.getColor(mContext, v7.internal.l.m);
    } else {
      i = ContextCompat.getColor(mContext, v7.internal.l.d);
    }
    paramView.setBackgroundColor(i);
  }
  
  private void a(Window paramWindow)
  {
    if (mWindow == null)
    {
      Object localObject = paramWindow.getCallback();
      if (!(localObject instanceof WindowCallbackWrapper))
      {
        localObject = new WindowCallbackWrapper(this, (Window.Callback)localObject);
        mOriginalWindowCallback = ((WindowCallbackWrapper)localObject);
        paramWindow.setCallback((Window.Callback)localObject);
        localObject = TintTypedArray.obtainStyledAttributes(mContext, null, a);
        Drawable localDrawable = ((TintTypedArray)localObject).getDrawableIfKnown(0);
        if (localDrawable != null) {
          paramWindow.setBackgroundDrawable(localDrawable);
        }
        ((TintTypedArray)localObject).recycle();
        mWindow = paramWindow;
        if ((Build.VERSION.SDK_INT >= 33) && (data == null)) {
          onCreate(null);
        }
      }
      else
      {
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
      }
    }
    else
    {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
  }
  
  private boolean a(int paramInt, Label paramLabel, boolean paramBoolean)
  {
    Configuration localConfiguration = a(mContext, paramInt, paramLabel, null, false);
    int k = init(mContext);
    Object localObject2 = v;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = mContext.getResources().getConfiguration();
    }
    int i = uiMode;
    int m = uiMode & 0x30;
    localObject2 = a((Configuration)localObject1);
    if (paramLabel == null) {
      localObject1 = null;
    } else {
      localObject1 = a(localConfiguration);
    }
    boolean bool2 = false;
    int j;
    if ((i & 0x30) != m) {
      j = 512;
    } else {
      j = 0;
    }
    i = j;
    if (localObject1 != null)
    {
      i = j;
      if (!((Label)localObject2).equals(localObject1))
      {
        j |= 0x4;
        i = j;
        if (Build.VERSION.SDK_INT >= 17) {
          i = j | 0x2000;
        }
      }
    }
    boolean bool1 = true;
    if (((k & i) != 0) && (paramBoolean) && (s) && ((b) || (d)))
    {
      localObject2 = this$0;
      if (((localObject2 instanceof Activity)) && (!((Activity)localObject2).isChild()))
      {
        ActivityCompat.requestPermissions((Activity)this$0);
        paramBoolean = true;
        break label244;
      }
    }
    paramBoolean = false;
    label244:
    if ((!paramBoolean) && (i != 0))
    {
      paramBoolean = bool2;
      if ((i & k) == i) {
        paramBoolean = true;
      }
      init(m, (Label)localObject1, paramBoolean, null);
      paramBoolean = bool1;
    }
    if (paramBoolean)
    {
      localObject2 = this$0;
      if ((localObject2 instanceof AppCompatActivity))
      {
        if ((i & 0x200) != 0) {
          ((AppCompatActivity)localObject2).onNightModeChanged(paramInt);
        }
        if ((i & 0x4) != 0) {
          ((AppCompatActivity)this$0).onLocalesChanged(paramLabel);
        }
      }
    }
    if ((paramBoolean) && (localObject1 != null)) {
      a(a(mContext.getResources().getConfiguration()));
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mIsDestroyed) {
      return false;
    }
    int i = f();
    int j = a(mContext, i);
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT < 33) {
      localObject1 = b(mContext);
    }
    Object localObject2 = localObject1;
    if (!paramBoolean2)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        localObject2 = a(mContext.getResources().getConfiguration());
      }
    }
    paramBoolean1 = a(j, (Label)localObject2, paramBoolean1);
    if (i == 0)
    {
      c(mContext).onResume();
    }
    else
    {
      localObject1 = x;
      if (localObject1 != null) {
        ((InactivityTimer)localObject1).cancel();
      }
    }
    if (i == 3)
    {
      f(mContext).onResume();
      return paramBoolean1;
    }
    localObject1 = f;
    if (localObject1 != null) {
      ((InactivityTimer)localObject1).cancel();
    }
    return paramBoolean1;
  }
  
  private void applyFixedSizeWindow()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)mSubDecor.findViewById(16908290);
    Object localObject = mWindow.getDecorView();
    localContentFrameLayout.setDecorPadding(((android.view.View)localObject).getPaddingLeft(), ((android.view.View)localObject).getPaddingTop(), ((android.view.View)localObject).getPaddingRight(), ((android.view.View)localObject).getPaddingBottom());
    localObject = mContext.obtainStyledAttributes(R.styleable.Theme);
    ((TypedArray)localObject).getValue(R.styleable.Theme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.Theme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    int i = R.styleable.Theme_windowFixedWidthMajor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedWidthMajor());
    }
    i = R.styleable.AppCompatTheme_windowFixedHeightMajor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedWidthMinor());
    }
    i = R.styleable.AppCompatTheme_windowFixedHeightMinor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedHeightMajor());
    }
    i = R.styleable.Theme_windowFixedHeightMajor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void b(Configuration paramConfiguration)
  {
    Activity localActivity = (Activity)this$0;
    if ((localActivity instanceof androidx.lifecycle.d))
    {
      if (((androidx.lifecycle.d)localActivity).getLifecycle().c().a(Lifecycle.State.d)) {
        localActivity.onConfigurationChanged(paramConfiguration);
      }
    }
    else if ((d) && (!mIsDestroyed)) {
      localActivity.onConfigurationChanged(paramConfiguration);
    }
  }
  
  private InactivityTimer c(android.content.Context paramContext)
  {
    if (x == null) {
      x = new d(this, TwilightManager.getLastKnownLocation(paramContext));
    }
    return x;
  }
  
  private ViewGroup createSubDecor()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  private boolean d(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }
  
  private void ensureSubDecor()
  {
    if (!mSubDecorInstalled)
    {
      mSubDecor = createSubDecor();
      Object localObject1 = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = mDecorContentParent;
        if (localObject2 != null)
        {
          ((DecorContentParent)localObject2).setWindowTitle((CharSequence)localObject1);
        }
        else if (peekSupportActionBar() != null)
        {
          peekSupportActionBar().setWindowTitle((CharSequence)localObject1);
        }
        else
        {
          localObject2 = mTitleView;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
        }
      }
      applyFixedSizeWindow();
      onSubDecorInstalled(mSubDecor);
      mSubDecorInstalled = true;
      localObject1 = getPanelState(0, false);
      if ((!mIsDestroyed) && ((localObject1 == null) || (menu == null))) {
        invalidatePanelMenu(108);
      }
    }
  }
  
  private int f()
  {
    int i = count;
    if (i != -100) {
      return i;
    }
    return f.l();
  }
  
  private InactivityTimer f(android.content.Context paramContext)
  {
    if (f == null) {
      f = new h(this, paramContext);
    }
    return f;
  }
  
  private void i()
  {
    InactivityTimer localInactivityTimer = x;
    if (localInactivityTimer != null) {
      localInactivityTimer.cancel();
    }
    localInactivityTimer = f;
    if (localInactivityTimer != null) {
      localInactivityTimer.cancel();
    }
  }
  
  private AppCompatActivity inflate()
  {
    for (android.content.Context localContext = mContext; localContext != null; localContext = ((ContextWrapper)localContext).getBaseContext())
    {
      if ((localContext instanceof AppCompatActivity)) {
        return (AppCompatActivity)localContext;
      }
      if (!(localContext instanceof ContextWrapper)) {
        break;
      }
    }
    return null;
  }
  
  private int init(android.content.Context paramContext)
  {
    if ((!r) && ((this$0 instanceof Activity)))
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return 0;
      }
      int i = Build.VERSION.SDK_INT;
      if (i >= 29) {
        i = 269221888;
      } else if (i >= 24) {
        i = 786432;
      } else {
        i = 0;
      }
      Object localObject = this$0;
      try
      {
        paramContext = localPackageManager.getActivityInfo(new ComponentName(paramContext, localObject.getClass()), i);
        if (paramContext != null) {
          active = configChanges;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", paramContext);
        active = 0;
      }
    }
    r = true;
    return active;
  }
  
  private static Configuration init(Configuration paramConfiguration1, Configuration paramConfiguration2)
  {
    Configuration localConfiguration = new Configuration();
    fontScale = 0.0F;
    if (paramConfiguration2 != null)
    {
      if (paramConfiguration1.diff(paramConfiguration2) == 0) {
        return localConfiguration;
      }
      float f1 = fontScale;
      float f2 = fontScale;
      if (f1 != f2) {
        fontScale = f2;
      }
      int i = mcc;
      int j = mcc;
      if (i != j) {
        mcc = j;
      }
      i = mnc;
      j = mnc;
      if (i != j) {
        mnc = j;
      }
      i = Build.VERSION.SDK_INT;
      if (i >= 24) {
        Context.setLocale(paramConfiguration1, paramConfiguration2, localConfiguration);
      } else if (!v7.v7.util.Context.equals(locale, locale)) {
        locale = locale;
      }
      j = touchscreen;
      int k = touchscreen;
      if (j != k) {
        touchscreen = k;
      }
      j = keyboard;
      k = keyboard;
      if (j != k) {
        keyboard = k;
      }
      j = keyboardHidden;
      k = keyboardHidden;
      if (j != k) {
        keyboardHidden = k;
      }
      j = navigation;
      k = navigation;
      if (j != k) {
        navigation = k;
      }
      j = navigationHidden;
      k = navigationHidden;
      if (j != k) {
        navigationHidden = k;
      }
      j = orientation;
      k = orientation;
      if (j != k) {
        orientation = k;
      }
      j = screenLayout;
      k = screenLayout;
      if ((j & 0xF) != (k & 0xF)) {
        screenLayout |= k & 0xF;
      }
      j = screenLayout;
      k = screenLayout;
      if ((j & 0xC0) != (k & 0xC0)) {
        screenLayout |= k & 0xC0;
      }
      j = screenLayout;
      k = screenLayout;
      if ((j & 0x30) != (k & 0x30)) {
        screenLayout |= k & 0x30;
      }
      j = screenLayout;
      k = screenLayout;
      if ((j & 0x300) != (k & 0x300)) {
        screenLayout |= k & 0x300;
      }
      if (i >= 26) {
        SupraCommand.register(paramConfiguration1, paramConfiguration2, localConfiguration);
      }
      j = uiMode;
      k = uiMode;
      if ((j & 0xF) != (k & 0xF)) {
        uiMode |= k & 0xF;
      }
      j = uiMode;
      k = uiMode;
      if ((j & 0x30) != (k & 0x30)) {
        uiMode |= k & 0x30;
      }
      j = screenWidthDp;
      k = screenWidthDp;
      if (j != k) {
        screenWidthDp = k;
      }
      j = screenHeightDp;
      k = screenHeightDp;
      if (j != k) {
        screenHeightDp = k;
      }
      j = smallestScreenWidthDp;
      k = smallestScreenWidthDp;
      if (j != k) {
        smallestScreenWidthDp = k;
      }
      if (i >= 17) {
        Messages.onCreate(paramConfiguration1, paramConfiguration2, localConfiguration);
      }
    }
    return localConfiguration;
  }
  
  private void init(int paramInt, Label paramLabel, boolean paramBoolean, Configuration paramConfiguration)
  {
    Resources localResources = mContext.getResources();
    Configuration localConfiguration = new Configuration(localResources.getConfiguration());
    if (paramConfiguration != null) {
      localConfiguration.updateFrom(paramConfiguration);
    }
    uiMode = (paramInt | getConfigurationuiMode & 0xFFFFFFCF);
    if (paramLabel != null) {
      init(localConfiguration, paramLabel);
    }
    localResources.updateConfiguration(localConfiguration, null);
    paramInt = Build.VERSION.SDK_INT;
    if (paramInt < 26) {
      Frame.initialize(localResources);
    }
    int i = preferences;
    if (i != 0)
    {
      mContext.setTheme(i);
      if (paramInt >= 23) {
        mContext.getTheme().applyStyle(preferences, true);
      }
    }
    if ((paramBoolean) && ((this$0 instanceof Activity))) {
      b(localConfiguration);
    }
  }
  
  private void initWindowDecorActionBar()
  {
    ensureSubDecor();
    if (mHasActionBar)
    {
      if (mActionBar != null) {
        return;
      }
      Object localObject = this$0;
      if ((localObject instanceof Activity)) {
        mActionBar = new WindowDecorActionBar((Activity)this$0, mOverlayActionBar);
      } else if ((localObject instanceof Dialog)) {
        mActionBar = new WindowDecorActionBar((Dialog)this$0);
      }
      localObject = mActionBar;
      if (localObject != null) {
        ((ActionBar)localObject).setDefaultDisplayHomeAsUpEnabled(mEnableDefaultActionBarUp);
      }
    }
  }
  
  private boolean initializePanelContent(PanelFeatureState paramPanelFeatureState)
  {
    android.view.View localView = createdPanelView;
    if (localView != null)
    {
      shownPanelView = localView;
      return true;
    }
    if (menu == null) {
      return false;
    }
    if (mPanelMenuPresenterCallback == null) {
      mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
    }
    localView = (android.view.View)paramPanelFeatureState.getListMenuView(mPanelMenuPresenterCallback);
    shownPanelView = localView;
    return localView != null;
  }
  
  private boolean initializePanelDecor(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
    decorView = new ListMenuDecorView(listPresenterContext);
    gravity = 81;
    return true;
  }
  
  private boolean initializePanelMenu(PanelFeatureState paramPanelFeatureState)
  {
    android.content.Context localContext = mContext;
    int i = featureId;
    if (i != 0)
    {
      localObject1 = localContext;
      if (i != 108) {}
    }
    else
    {
      localObject1 = localContext;
      if (mDecorContentParent != null)
      {
        TypedValue localTypedValue = new TypedValue();
        Resources.Theme localTheme = localContext.getTheme();
        localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
        localObject1 = null;
        if (resourceId != 0)
        {
          localObject2 = localContext.getResources().newTheme();
          localObject1 = localObject2;
          ((Resources.Theme)localObject2).setTo(localTheme);
          ((Resources.Theme)localObject2).applyStyle(resourceId, true);
          ((Resources.Theme)localObject2).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        else
        {
          localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        Object localObject2 = localObject1;
        if (resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = localContext.getResources().newTheme();
            localObject2 = localObject1;
            ((Resources.Theme)localObject1).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(resourceId, true);
        }
        localObject1 = localContext;
        if (localObject2 != null)
        {
          localObject1 = new v7.internal.view.ContextThemeWrapper(localContext, 0);
          ((android.content.Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
        }
      }
    }
    Object localObject1 = new androidx.appcompat.view.menu.f((android.content.Context)localObject1);
    ((androidx.appcompat.view.menu.f)localObject1).setCallback(this);
    paramPanelFeatureState.setMenu((androidx.appcompat.view.menu.f)localObject1);
    return true;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    mInvalidatePanelMenuFeatures = (1 << paramInt | mInvalidatePanelMenuFeatures);
    if (!mInvalidatePanelMenuPosted)
    {
      v7.v7.package_13.ViewCompat.postOnAnimation(mWindow.getDecorView(), mInvalidatePanelMenuRunnable);
      mInvalidatePanelMenuPosted = true;
    }
  }
  
  private boolean onKeyDownPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
      if (!isOpen) {
        return preparePanel(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private boolean onKeyUpPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (mActionMode != null) {
      return false;
    }
    boolean bool2 = true;
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if (paramInt == 0)
    {
      DecorContentParent localDecorContentParent = mDecorContentParent;
      if ((localDecorContentParent != null) && (localDecorContentParent.canShowOverflowMenu()) && (!ViewConfiguration.get(mContext).hasPermanentMenuKey()))
      {
        if (!mDecorContentParent.isOverflowMenuShowing())
        {
          if ((mIsDestroyed) || (!preparePanel(localPanelFeatureState, paramKeyEvent))) {
            break label186;
          }
          bool1 = mDecorContentParent.showOverflowMenu();
          break label198;
        }
        bool1 = mDecorContentParent.hideOverflowMenu();
        break label198;
      }
    }
    boolean bool1 = isOpen;
    if ((!bool1) && (!isHandled))
    {
      if (isPrepared)
      {
        if (refreshMenuContent)
        {
          isPrepared = false;
          bool1 = preparePanel(localPanelFeatureState, paramKeyEvent);
        }
        else
        {
          bool1 = true;
        }
        if (bool1)
        {
          openPanel(localPanelFeatureState, paramKeyEvent);
          bool1 = bool2;
          break label198;
        }
      }
      label186:
      bool1 = false;
    }
    else
    {
      closePanel(localPanelFeatureState, true);
    }
    label198:
    if (bool1)
    {
      paramKeyEvent = (AudioManager)mContext.getApplicationContext().getSystemService("audio");
      if (paramKeyEvent != null)
      {
        paramKeyEvent.playSoundEffect(0);
        return bool1;
      }
      Log.w("AppCompatDelegate", "Couldn't get audio manager");
    }
    return bool1;
  }
  
  private void openPanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (!isOpen)
    {
      if (mIsDestroyed) {
        return;
      }
      if (featureId == 0)
      {
        if ((mContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
      }
      Object localObject = getWindowCallback();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(featureId, menu)))
      {
        closePanel(paramPanelFeatureState, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)mContext.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {
        return;
      }
      paramKeyEvent = decorView;
      if ((paramKeyEvent != null) && (!refreshDecorView))
      {
        paramKeyEvent = createdPanelView;
        if (paramKeyEvent != null)
        {
          paramKeyEvent = paramKeyEvent.getLayoutParams();
          if ((paramKeyEvent != null) && (width == -1))
          {
            i = -1;
            break label334;
          }
        }
      }
      else
      {
        if (paramKeyEvent == null)
        {
          if (!initializePanelDecor(paramPanelFeatureState)) {
            return;
          }
          if (decorView != null) {}
        }
        else if ((refreshDecorView) && (paramKeyEvent.getChildCount() > 0))
        {
          decorView.removeAllViews();
        }
        if ((!initializePanelContent(paramPanelFeatureState)) || (!paramPanelFeatureState.hasPanelItems())) {
          break label411;
        }
        localObject = shownPanelView.getLayoutParams();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == null) {
          paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
        }
        i = background;
        decorView.setBackgroundResource(i);
        localObject = shownPanelView.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(shownPanelView);
        }
        decorView.addView(shownPanelView, paramKeyEvent);
        if (!shownPanelView.hasFocus()) {
          shownPanelView.requestFocus();
        }
      }
      int i = -2;
      label334:
      isHandled = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, x, y, 1002, 8519680, -3);
      gravity = gravity;
      windowAnimations = windowAnimations;
      localWindowManager.addView(decorView, paramKeyEvent);
      isOpen = true;
      if (featureId == 0)
      {
        get();
        return;
        label411:
        refreshDecorView = true;
      }
    }
  }
  
  private boolean performPanelShortcut(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!isPrepared)
    {
      bool1 = bool2;
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      androidx.appcompat.view.menu.f localF = menu;
      bool1 = bool2;
      if (localF != null) {
        bool1 = localF.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    if ((bool1) && ((paramInt2 & 0x1) == 0) && (mDecorContentParent == null)) {
      closePanel(paramPanelFeatureState, true);
    }
    return bool1;
  }
  
  private boolean preparePanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (mIsDestroyed) {
      return false;
    }
    if (isPrepared) {
      return true;
    }
    Object localObject1 = mPreparedPanel;
    if ((localObject1 != null) && (localObject1 != paramPanelFeatureState)) {
      closePanel((PanelFeatureState)localObject1, false);
    }
    localObject1 = getWindowCallback();
    if (localObject1 != null) {
      createdPanelView = ((Window.Callback)localObject1).onCreatePanelView(featureId);
    }
    int i = featureId;
    if ((i != 0) && (i != 108)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2;
    if (i != 0)
    {
      localObject2 = mDecorContentParent;
      if (localObject2 != null) {
        ((DecorContentParent)localObject2).setMenuPrepared();
      }
    }
    if ((createdPanelView == null) && ((i == 0) || (!(peekSupportActionBar() instanceof ToolbarActionBar))))
    {
      localObject2 = menu;
      if ((localObject2 == null) || (refreshMenuContent))
      {
        if (localObject2 == null)
        {
          if (!initializePanelMenu(paramPanelFeatureState)) {
            break label441;
          }
          if (menu == null) {
            return false;
          }
        }
        if ((i != 0) && (mDecorContentParent != null))
        {
          if (mActionMenuPresenterCallback == null) {
            mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
          }
          mDecorContentParent.setMenu(menu, mActionMenuPresenterCallback);
        }
        menu.stopDispatchingItemsChanged();
        if (!((Window.Callback)localObject1).onCreatePanelMenu(featureId, menu))
        {
          paramPanelFeatureState.setMenu(null);
          if (i != 0)
          {
            paramPanelFeatureState = mDecorContentParent;
            if (paramPanelFeatureState != null)
            {
              paramPanelFeatureState.setMenu(null, mActionMenuPresenterCallback);
              return false;
            }
          }
        }
        else
        {
          refreshMenuContent = false;
        }
      }
      else
      {
        menu.stopDispatchingItemsChanged();
        localObject2 = frozenActionViewState;
        if (localObject2 != null)
        {
          menu.d((Bundle)localObject2);
          frozenActionViewState = null;
        }
        if (!((Window.Callback)localObject1).onPreparePanel(0, createdPanelView, menu))
        {
          if (i != 0)
          {
            paramKeyEvent = mDecorContentParent;
            if (paramKeyEvent != null) {
              paramKeyEvent.setMenu(null, mActionMenuPresenterCallback);
            }
          }
          menu.startDispatchingItemsChanged();
          return false;
        }
        if (paramKeyEvent != null) {
          i = paramKeyEvent.getDeviceId();
        } else {
          i = -1;
        }
        boolean bool;
        if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
          bool = true;
        } else {
          bool = false;
        }
        qwertyMode = bool;
        menu.setQwertyMode(bool);
        menu.startDispatchingItemsChanged();
      }
    }
    else
    {
      isPrepared = true;
      isHandled = false;
      mPreparedPanel = paramPanelFeatureState;
      return true;
    }
    label441:
    return false;
  }
  
  private void reopenMenu(boolean paramBoolean)
  {
    Object localObject = mDecorContentParent;
    if ((localObject != null) && (((DecorContentParent)localObject).canShowOverflowMenu()) && ((!ViewConfiguration.get(mContext).hasPermanentMenuKey()) || (mDecorContentParent.isOverflowMenuShowPending())))
    {
      localObject = getWindowCallback();
      if ((mDecorContentParent.isOverflowMenuShowing()) && (paramBoolean))
      {
        mDecorContentParent.hideOverflowMenu();
        if (!mIsDestroyed) {
          ((Window.Callback)localObject).onPanelClosed(108, getPanelState0menu);
        }
      }
      else if ((localObject != null) && (!mIsDestroyed))
      {
        if ((mInvalidatePanelMenuPosted) && ((mInvalidatePanelMenuFeatures & 0x1) != 0))
        {
          mWindow.getDecorView().removeCallbacks(mInvalidatePanelMenuRunnable);
          mInvalidatePanelMenuRunnable.run();
        }
        PanelFeatureState localPanelFeatureState = getPanelState(0, true);
        androidx.appcompat.view.menu.f localF = menu;
        if ((localF != null) && (!refreshMenuContent) && (((Window.Callback)localObject).onPreparePanel(0, createdPanelView, localF)))
        {
          ((Window.Callback)localObject).onMenuOpened(108, menu);
          mDecorContentParent.showOverflowMenu();
        }
      }
    }
    else
    {
      localObject = getPanelState(0, true);
      refreshDecorView = true;
      closePanel((PanelFeatureState)localObject, false);
      openPanel((PanelFeatureState)localObject, null);
    }
  }
  
  private int sanitizeWindowFeatureId(int paramInt)
  {
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      return 108;
    }
    if (paramInt == 9)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
      return 109;
    }
    return paramInt;
  }
  
  private void setContentView()
  {
    if (mWindow == null)
    {
      Object localObject = this$0;
      if ((localObject instanceof Activity)) {
        a(((Activity)localObject).getWindow());
      }
    }
    if (mWindow != null) {
      return;
    }
    throw new IllegalStateException("We have not been given a Window");
  }
  
  private boolean shouldInheritContext(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    android.view.View localView = mWindow.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof android.view.View))) {
        break;
      }
      if (v7.v7.package_13.ViewCompat.d((android.view.View)paramViewParent)) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
    return false;
  }
  
  private void throwFeatureRequestIfSubDecorInstalled()
  {
    if (!mSubDecorInstalled) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  int a(android.content.Context paramContext, int paramInt)
  {
    if (paramInt != -100)
    {
      int i = paramInt;
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if ((paramInt != 1) && (paramInt != 2))
          {
            if (paramInt == 3) {
              return f(paramContext).a();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
          }
        }
        else
        {
          if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)paramContext.getApplicationContext().getSystemService("uimode")).getNightMode() == 0)) {
            return -1;
          }
          i = c(paramContext).a();
        }
      }
      else {
        return i;
      }
    }
    else
    {
      return -1;
    }
    return paramInt;
  }
  
  public android.content.Context a(android.content.Context paramContext)
  {
    i = 1;
    s = true;
    j = a(paramContext, f());
    if (f.d(paramContext)) {
      f.add(paramContext);
    }
    Label localLabel = b(paramContext);
    if ((l) && ((paramContext instanceof android.view.ContextThemeWrapper)))
    {
      localObject1 = a(paramContext, j, localLabel, null, false);
      localObject2 = (android.view.ContextThemeWrapper)paramContext;
    }
    try
    {
      k.a((android.view.ContextThemeWrapper)localObject2, (Configuration)localObject1);
      return paramContext;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      for (;;) {}
    }
    if ((paramContext instanceof v7.internal.view.ContextThemeWrapper))
    {
      localObject1 = a(paramContext, j, localLabel, null, false);
      localObject2 = (v7.internal.view.ContextThemeWrapper)paramContext;
    }
    try
    {
      ((v7.internal.view.ContextThemeWrapper)localObject2).getTheme((Configuration)localObject1);
      return paramContext;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      Configuration localConfiguration1;
      Configuration localConfiguration2;
      for (;;) {}
    }
    if (!b) {
      return super.a(paramContext);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = new Configuration();
      uiMode = -1;
      fontScale = 0.0F;
      localConfiguration1 = Messages.f(paramContext, (Configuration)localObject1).getResources().getConfiguration();
      localConfiguration2 = paramContext.getResources().getConfiguration();
      uiMode = uiMode;
      localObject1 = localObject2;
      if (!localConfiguration1.equals(localConfiguration2)) {
        localObject1 = init(localConfiguration1, localConfiguration2);
      }
    }
    localObject2 = a(paramContext, j, localLabel, (Configuration)localObject1, true);
    localObject1 = new v7.internal.view.ContextThemeWrapper(paramContext, R.style.p);
    ((v7.internal.view.ContextThemeWrapper)localObject1).getTheme((Configuration)localObject2);
    j = 0;
    try
    {
      paramContext = paramContext.getTheme();
      if (paramContext == null) {
        i = 0;
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i != 0) {
      androidx.core.content.asm.k.onItemClick(((v7.internal.view.ContextThemeWrapper)localObject1).getTheme());
    }
    return super.a((android.content.Context)localObject1);
  }
  
  Label a(Configuration paramConfiguration)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 24) {
      return Context.a(paramConfiguration);
    }
    if (i >= 21) {
      return Label.a(Format.getTitle(locale));
    }
    return Label.a(new Locale[] { locale });
  }
  
  public void a(Bundle paramBundle) {}
  
  void a(Label paramLabel)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      Context.visitLabel(paramLabel);
      return;
    }
    Locale.setDefault(paramLabel.toString(0));
  }
  
  final int access$300(v7.v7.package_13.f paramF, Rect paramRect)
  {
    int i1 = 0;
    int i;
    if (paramF != null) {
      i = paramF.getSystemWindowInsetTop();
    } else if (paramRect != null) {
      i = top;
    } else {
      i = 0;
    }
    Object localObject = mActionModeView;
    int n;
    int m;
    if ((localObject != null) && ((((android.view.View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject = (ViewGroup.MarginLayoutParams)mActionModeView.getLayoutParams();
      boolean bool = mActionModeView.isShown();
      int k = 1;
      n = 1;
      int j;
      if (bool)
      {
        if (mTempRect1 == null)
        {
          mTempRect1 = new Rect();
          mTempRect2 = new Rect();
        }
        Rect localRect1 = mTempRect1;
        Rect localRect2 = mTempRect2;
        if (paramF == null) {
          localRect1.set(paramRect);
        } else {
          localRect1.set(paramF.getHeight(), paramF.getSystemWindowInsetTop(), paramF.getWidth(), paramF.size());
        }
        ViewUtils.computeFitSystemWindows(mSubDecor, localRect1, localRect2);
        int i2 = top;
        j = left;
        int i3 = right;
        paramF = v7.v7.package_13.ViewCompat.b(mSubDecor);
        if (paramF == null) {
          k = 0;
        } else {
          k = paramF.getHeight();
        }
        if (paramF == null) {
          m = 0;
        } else {
          m = paramF.getWidth();
        }
        if ((topMargin == i2) && (leftMargin == j) && (rightMargin == i3))
        {
          j = 0;
        }
        else
        {
          topMargin = i2;
          leftMargin = j;
          rightMargin = i3;
          j = 1;
        }
        if ((i2 > 0) && (mStatusGuard == null))
        {
          paramF = new android.view.View(mContext);
          mStatusGuard = paramF;
          paramF.setVisibility(8);
          paramF = new FrameLayout.LayoutParams(-1, topMargin, 51);
          leftMargin = k;
          rightMargin = m;
          mSubDecor.addView(mStatusGuard, -1, paramF);
        }
        else
        {
          paramF = mStatusGuard;
          if (paramF != null)
          {
            paramF = (ViewGroup.MarginLayoutParams)paramF.getLayoutParams();
            i2 = height;
            i3 = topMargin;
            if ((i2 != i3) || (leftMargin != k) || (rightMargin != m))
            {
              height = i3;
              leftMargin = k;
              rightMargin = m;
              mStatusGuard.setLayoutParams(paramF);
            }
          }
        }
        paramF = mStatusGuard;
        if (paramF != null) {
          m = n;
        } else {
          m = 0;
        }
        if ((m != 0) && (paramF.getVisibility() != 0)) {
          a(mStatusGuard);
        }
        k = i;
        if (!mOverlayActionMode)
        {
          k = i;
          if (m != 0) {
            k = 0;
          }
        }
        i = k;
        k = j;
        j = m;
      }
      else if (topMargin != 0)
      {
        topMargin = 0;
        j = 0;
      }
      else
      {
        j = 0;
        k = 0;
      }
      m = i;
      n = j;
      if (k != 0)
      {
        mActionModeView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        m = i;
        n = j;
      }
    }
    else
    {
      n = 0;
      m = i;
    }
    paramF = mStatusGuard;
    if (paramF != null)
    {
      if (n != 0) {
        i = i1;
      } else {
        i = 8;
      }
      paramF.setVisibility(i);
    }
    return m;
  }
  
  public void addContentView(android.view.View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    mOriginalWindowCallback.onContentChanged(mWindow.getCallback());
  }
  
  Label b(android.content.Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 33) {
      return null;
    }
    Label localLabel2 = f.c();
    if (localLabel2 == null) {
      return null;
    }
    Label localLabel1 = a(paramContext.getApplicationContext().getResources().getConfiguration());
    if (i >= 24) {
      paramContext = g.b(localLabel2, localLabel1);
    } else if (localLabel2.a()) {
      paramContext = Label.b();
    } else {
      paramContext = Label.a(localLabel2.toString(0).toString());
    }
    if (paramContext.a()) {
      return localLabel1;
    }
    return paramContext;
  }
  
  void callOnPanelClosed(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localObject1 = mPanels;
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < localObject1.length) {
            localPanelFeatureState = localObject1[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = menu;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!isOpen)) {
      return;
    }
    if (!mIsDestroyed) {
      mOriginalWindowCallback.onPanelClosed(mWindow.getCallback(), paramInt, (Menu)localObject2);
    }
  }
  
  void checkCloseActionMenu(androidx.appcompat.view.menu.f paramF)
  {
    if (mClosingActionMenu) {
      return;
    }
    mClosingActionMenu = true;
    mDecorContentParent.dismissPopups();
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramF);
    }
    mClosingActionMenu = false;
  }
  
  void closePanel(int paramInt)
  {
    closePanel(getPanelState(paramInt, true), true);
  }
  
  void closePanel(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (featureId == 0))
    {
      localObject = mDecorContentParent;
      if ((localObject != null) && (((DecorContentParent)localObject).isOverflowMenuShowing()))
      {
        checkCloseActionMenu(menu);
        return;
      }
    }
    Object localObject = (WindowManager)mContext.getSystemService("window");
    if ((localObject != null) && (isOpen))
    {
      ViewGroup localViewGroup = decorView;
      if (localViewGroup != null)
      {
        ((ViewManager)localObject).removeView(localViewGroup);
        if (paramBoolean) {
          callOnPanelClosed(featureId, paramPanelFeatureState, null);
        }
      }
    }
    isPrepared = false;
    isHandled = false;
    isOpen = false;
    shownPanelView = null;
    refreshDecorView = true;
    if (mPreparedPanel == paramPanelFeatureState) {
      mPreparedPanel = null;
    }
    if (featureId == 0) {
      get();
    }
  }
  
  public android.view.View createView(android.view.View paramView, String paramString, android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = mAppCompatViewInflater;
    boolean bool2 = false;
    if (localObject == null)
    {
      localObject = mContext.obtainStyledAttributes(R.styleable.Theme).getString(R.styleable.loading);
      if (localObject == null) {
        mAppCompatViewInflater = new AppCompatViewInflater();
      } else {
        try
        {
          mAppCompatViewInflater = ((AppCompatViewInflater)mContext.getClassLoader().loadClass((String)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to instantiate custom view inflater ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(". Falling back to default.");
          Log.i("AppCompatDelegate", localStringBuilder.toString(), localThrowable);
          mAppCompatViewInflater = new AppCompatViewInflater();
        }
      }
    }
    boolean bool4 = y;
    boolean bool3 = true;
    boolean bool1 = bool2;
    if (bool4)
    {
      if (w == null) {
        w = new l();
      }
      if (w.a(paramAttributeSet))
      {
        bool1 = true;
      }
      else if ((paramAttributeSet instanceof XmlPullParser))
      {
        bool1 = bool2;
        if (((XmlPullParser)paramAttributeSet).getDepth() > 1) {
          bool1 = bool3;
        }
      }
      else
      {
        bool1 = shouldInheritContext((ViewParent)paramView);
      }
    }
    return mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool1, bool4, true, Attribute.get());
  }
  
  public boolean d()
  {
    return d(true);
  }
  
  void dismissPopups()
  {
    Object localObject = mDecorContentParent;
    if (localObject != null) {
      ((DecorContentParent)localObject).dismissPopups();
    }
    if (mActionModePopup != null)
    {
      mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
      if (mActionModePopup.isShowing()) {
        localObject = mActionModePopup;
      }
    }
    try
    {
      ((PopupWindow)localObject).dismiss();
      mActionModePopup = null;
      endOnGoingFadeAnimation();
      localObject = getPanelState(0, false);
      if (localObject != null)
      {
        localObject = menu;
        if (localObject != null)
        {
          ((androidx.appcompat.view.menu.f)localObject).close();
          return;
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Object localObject = this$0;
    boolean bool = localObject instanceof v7.v7.package_13.k;
    int i = 1;
    if ((bool) || ((localObject instanceof AppCompatDialog)))
    {
      localObject = mWindow.getDecorView();
      if ((localObject != null) && (v7.v7.package_13.g.a((android.view.View)localObject, paramKeyEvent))) {
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (mOriginalWindowCallback.dispatchKeyEvent(mWindow.getCallback(), paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 0) {
      i = 0;
    }
    if (i != 0) {
      return onKeyDown(j, paramKeyEvent);
    }
    return onKeyUp(j, paramKeyEvent);
  }
  
  void doInvalidatePanelMenu(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if (menu != null)
    {
      Bundle localBundle = new Bundle();
      menu.c(localBundle);
      if (localBundle.size() > 0) {
        frozenActionViewState = localBundle;
      }
      menu.stopDispatchingItemsChanged();
      menu.clear();
    }
    refreshMenuContent = true;
    refreshDecorView = true;
    if (((paramInt == 108) || (paramInt == 0)) && (mDecorContentParent != null))
    {
      localPanelFeatureState = getPanelState(0, false);
      if (localPanelFeatureState != null)
      {
        isPrepared = false;
        preparePanel(localPanelFeatureState, null);
      }
    }
  }
  
  public void e()
  {
    a(true, false);
  }
  
  void endOnGoingFadeAnimation()
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = mFadeAnim;
    if (localViewPropertyAnimatorCompat != null) {
      localViewPropertyAnimatorCompat.cancel();
    }
  }
  
  PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = mPanels;
    int j = 0;
    int i;
    if (arrayOfPanelFeatureState != null) {
      i = arrayOfPanelFeatureState.length;
    } else {
      i = 0;
    }
    while (j < i)
    {
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (menu == paramMenu)) {
        return localPanelFeatureState;
      }
      j += 1;
    }
    return null;
  }
  
  public android.view.View findViewById(int paramInt)
  {
    ensureSubDecor();
    return mWindow.findViewById(paramInt);
  }
  
  void get()
  {
    if (Build.VERSION.SDK_INT >= 33)
    {
      boolean bool = onKeyUpPanel();
      if ((bool) && (result == null))
      {
        result = ImageManager.get(data, this);
        return;
      }
      if (!bool)
      {
        OnBackInvokedCallback localOnBackInvokedCallback = result;
        if (localOnBackInvokedCallback != null) {
          ImageManager.put(data, localOnBackInvokedCallback);
        }
      }
    }
  }
  
  final android.content.Context getActionBarThemedContext()
  {
    Object localObject1 = getSupportActionBar();
    if (localObject1 != null) {
      localObject1 = ((ActionBar)localObject1).getThemedContext();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mContext;
    }
    return localObject2;
  }
  
  public android.content.Context getContext()
  {
    return mContext;
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new AppCompatDelegateImplBase.ActionBarDrawableToggleImpl(this);
  }
  
  public MenuInflater getMenuInflater()
  {
    if (mMenuInflater == null)
    {
      initWindowDecorActionBar();
      Object localObject = mActionBar;
      if (localObject != null) {
        localObject = ((ActionBar)localObject).getThemedContext();
      } else {
        localObject = mContext;
      }
      mMenuInflater = new SupportMenuInflater((android.content.Context)localObject);
    }
    return mMenuInflater;
  }
  
  protected PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = mPanels;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      mPanels = ((PanelFeatureState[])localObject1);
    }
    Object localObject3 = localObject1[paramInt];
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    return localObject2;
  }
  
  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return mActionBar;
  }
  
  final CharSequence getTitle()
  {
    Object localObject = this$0;
    if ((localObject instanceof Activity)) {
      return ((Activity)localObject).getTitle();
    }
    return title;
  }
  
  final Window.Callback getWindowCallback()
  {
    return mWindow.getCallback();
  }
  
  void init(Configuration paramConfiguration, Label paramLabel)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 24)
    {
      Context.setLocale(paramConfiguration, paramLabel);
      return;
    }
    if (i >= 17)
    {
      Messages.setLocale(paramConfiguration, paramLabel.toString(0));
      Messages.create(paramConfiguration, paramLabel.toString(0));
      return;
    }
    locale = paramLabel.toString(0);
  }
  
  public void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      LayoutInflaterCompatHC.setFactory(localLayoutInflater, this);
      return;
    }
    if (!(localLayoutInflater.getFactory2() instanceof AppCompatDelegateImplV7)) {
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
    }
  }
  
  public void invalidateOptionsMenu()
  {
    if (peekSupportActionBar() != null)
    {
      if (getSupportActionBar().invalidateOptionsMenu()) {
        return;
      }
      invalidatePanelMenu(0);
    }
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return mHandleNativeActionModes;
  }
  
  final boolean onBackPressed()
  {
    if (mSubDecorInstalled)
    {
      ViewGroup localViewGroup = mSubDecor;
      if ((localViewGroup != null) && (v7.v7.package_13.ViewCompat.set(localViewGroup))) {
        return true;
      }
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((mHasActionBar) && (mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    androidx.appcompat.widget.ViewCompat.get().getDrawable(mContext);
    v = new Configuration(mContext.getResources().getConfiguration());
    a(false, false);
  }
  
  public void onCreate()
  {
    if ((this$0 instanceof Activity)) {
      f.close(this);
    }
    if (mInvalidatePanelMenuPosted) {
      mWindow.getDecorView().removeCallbacks(mInvalidatePanelMenuRunnable);
    }
    mIsDestroyed = true;
    if (count != -100)
    {
      localObject = this$0;
      if (((localObject instanceof Activity)) && (((Activity)localObject).isChangingConfigurations()))
      {
        t.put(this$0.getClass().getName(), Integer.valueOf(count));
        break label116;
      }
    }
    t.remove(this$0.getClass().getName());
    label116:
    Object localObject = mActionBar;
    if (localObject != null) {
      ((ActionBar)localObject).onDestroy();
    }
    i();
  }
  
  public void onCreate(int paramInt)
  {
    preferences = paramInt;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    s = true;
    d(false);
    setContentView();
    Object localObject = this$0;
    if ((localObject instanceof Activity))
    {
      paramBundle = null;
      localObject = (Activity)localObject;
    }
    try
    {
      localObject = NavUtils.getParentActivityName((Activity)localObject);
      paramBundle = (Bundle)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    if (paramBundle != null)
    {
      paramBundle = peekSupportActionBar();
      if (paramBundle == null) {
        mEnableDefaultActionBarUp = true;
      } else {
        paramBundle.setDefaultDisplayHomeAsUpEnabled(true);
      }
    }
    f.add(this);
    v = new Configuration(mContext.getResources().getConfiguration());
    d = true;
  }
  
  public void onCreate(OnBackInvokedDispatcher paramOnBackInvokedDispatcher)
  {
    super.onCreate(paramOnBackInvokedDispatcher);
    Object localObject = data;
    if (localObject != null)
    {
      OnBackInvokedCallback localOnBackInvokedCallback = result;
      if (localOnBackInvokedCallback != null)
      {
        ImageManager.put(localObject, localOnBackInvokedCallback);
        result = null;
      }
    }
    if (paramOnBackInvokedDispatcher == null)
    {
      localObject = this$0;
      if (((localObject instanceof Activity)) && (((Activity)localObject).getWindow() != null))
      {
        data = ImageManager.subscribe((Activity)this$0);
        break label81;
      }
    }
    data = paramOnBackInvokedDispatcher;
    label81:
    get();
  }
  
  public final android.view.View onCreateView(android.view.View paramView, String paramString, android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public android.view.View onCreateView(String paramString, android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      onKeyDownPanel(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) == 0) {
      bool = false;
    }
    mLongPressBackDown = bool;
    return false;
  }
  
  boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {
      return true;
    }
    localObject = mPreparedPanel;
    if ((localObject != null) && (performPanelShortcut((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)))
    {
      paramKeyEvent = mPreparedPanel;
      if (paramKeyEvent != null)
      {
        isHandled = true;
        return true;
      }
    }
    else
    {
      if (mPreparedPanel == null)
      {
        localObject = getPanelState(0, true);
        preparePanel((PanelFeatureState)localObject, paramKeyEvent);
        boolean bool = performPanelShortcut((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
        isPrepared = false;
        if (!bool) {
          break label117;
        }
        return true;
      }
      return false;
    }
    return true;
    label117:
    return false;
  }
  
  boolean onKeyUp()
  {
    boolean bool = mLongPressBackDown;
    mLongPressBackDown = false;
    Object localObject = getPanelState(0, false);
    if ((localObject != null) && (isOpen))
    {
      if (!bool)
      {
        closePanel((PanelFeatureState)localObject, true);
        return true;
      }
    }
    else
    {
      localObject = mActionMode;
      if (localObject != null)
      {
        ((ActionMode)localObject).finish();
        return true;
      }
      localObject = getSupportActionBar();
      if (localObject != null)
      {
        if (!((ActionBar)localObject).collapseActionView()) {
          break label77;
        }
        return true;
      }
      return false;
    }
    return true;
    label77:
    return false;
  }
  
  boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      onKeyUpPanel(0, paramKeyEvent);
      return true;
    }
    return onKeyUp();
  }
  
  boolean onKeyUpPanel()
  {
    if (data == null) {
      return false;
    }
    PanelFeatureState localPanelFeatureState = getPanelState(0, false);
    if ((localPanelFeatureState != null) && (isOpen)) {
      return true;
    }
    return mActionMode != null;
  }
  
  public boolean onMenuItemSelected(androidx.appcompat.view.menu.f paramF, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!mIsDestroyed))
    {
      paramF = findMenuPanel(paramF.getRootMenu());
      if (paramF != null) {
        return localCallback.onMenuItemSelected(featureId, paramMenuItem);
      }
    }
    return false;
  }
  
  public void onMenuModeChange(androidx.appcompat.view.menu.f paramF)
  {
    reopenMenu(true);
  }
  
  void onMenuOpened(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.a(true);
      }
    }
  }
  
  void onPanelClosed(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).a(false);
      }
    }
    else if (paramInt == 0)
    {
      localObject = getPanelState(paramInt, true);
      if (isOpen) {
        closePanel((PanelFeatureState)localObject, false);
      }
    }
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    ensureSubDecor();
  }
  
  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  void onSubDecorInstalled(ViewGroup paramViewGroup) {}
  
  public final void onTitleChanged(CharSequence paramCharSequence)
  {
    title = paramCharSequence;
    Object localObject = mDecorContentParent;
    if (localObject != null)
    {
      ((DecorContentParent)localObject).setWindowTitle(paramCharSequence);
      return;
    }
    if (peekSupportActionBar() != null)
    {
      peekSupportActionBar().setWindowTitle(paramCharSequence);
      return;
    }
    localObject = mTitleView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
  }
  
  final ActionBar peekSupportActionBar()
  {
    return mActionBar;
  }
  
  public boolean requestWindowFeature(int paramInt)
  {
    paramInt = sanitizeWindowFeatureId(paramInt);
    if ((mWindowNoTitle) && (paramInt == 108)) {
      return false;
    }
    if ((mHasActionBar) && (paramInt == 1)) {
      mHasActionBar = false;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 10)
          {
            if (paramInt != 108)
            {
              if (paramInt != 109) {
                return mWindow.requestFeature(paramInt);
              }
              throwFeatureRequestIfSubDecorInstalled();
              mOverlayActionBar = true;
              return true;
            }
            throwFeatureRequestIfSubDecorInstalled();
            mHasActionBar = true;
            return true;
          }
          throwFeatureRequestIfSubDecorInstalled();
          mOverlayActionMode = true;
          return true;
        }
        throwFeatureRequestIfSubDecorInstalled();
        mFeatureProgress = true;
        return true;
      }
      throwFeatureRequestIfSubDecorInstalled();
      mFeatureIndeterminateProgress = true;
      return true;
    }
    throwFeatureRequestIfSubDecorInstalled();
    mWindowNoTitle = true;
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(mContext).inflate(paramInt, localViewGroup);
    mOriginalWindowCallback.onContentChanged(mWindow.getCallback());
  }
  
  public void setContentView(android.view.View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    mOriginalWindowCallback.onContentChanged(mWindow.getCallback());
  }
  
  public void setContentView(android.view.View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    mOriginalWindowCallback.onContentChanged(mWindow.getCallback());
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this$0 instanceof Activity)) {
      return;
    }
    Object localObject = getSupportActionBar();
    if (!(localObject instanceof WindowDecorActionBar))
    {
      mMenuInflater = null;
      if (localObject != null) {
        ((ActionBar)localObject).onDestroy();
      }
      mActionBar = null;
      if (paramToolbar != null)
      {
        localObject = new ToolbarActionBar(paramToolbar, getTitle(), mOriginalWindowCallback);
        mActionBar = ((ActionBar)localObject);
        mOriginalWindowCallback.onPanelClosed(mWindow);
        paramToolbar.setBackInvokedCallbackEnabled(true);
      }
      else
      {
        mOriginalWindowCallback.onPanelClosed(null);
      }
      invalidateOptionsMenu();
      return;
    }
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public int size()
  {
    return count;
  }
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback != null)
    {
      Object localObject = mActionMode;
      if (localObject != null) {
        ((ActionMode)localObject).finish();
      }
      paramCallback = new ActionModeCallbackWrapperV7(paramCallback);
      localObject = getSupportActionBar();
      if (localObject != null)
      {
        localObject = ((ActionBar)localObject).startActionMode(paramCallback);
        mActionMode = ((ActionMode)localObject);
        if (localObject != null)
        {
          AppCompatCallback localAppCompatCallback = mAppCompatCallback;
          if (localAppCompatCallback != null) {
            localAppCompatCallback.onSupportActionModeStarted((ActionMode)localObject);
          }
        }
      }
      if (mActionMode == null) {
        mActionMode = startSupportActionModeFromWindow(paramCallback);
      }
      get();
      return mActionMode;
    }
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a15 = a14\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  final class ActionMenuPresenterCallback
    implements l.a
  {
    ActionMenuPresenterCallback() {}
    
    public void onCloseMenu(androidx.appcompat.view.menu.f paramF, boolean paramBoolean)
    {
      checkCloseActionMenu(paramF);
    }
    
    public boolean onOpenSubMenu(androidx.appcompat.view.menu.f paramF)
    {
      Window.Callback localCallback = getWindowCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramF);
      }
      return true;
    }
  }
  
  class ActionModeCallbackWrapperV7
    implements ActionMode.Callback
  {
    private ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapperV7(ActionMode.Callback paramCallback)
    {
      mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      mWrapped.onDestroyActionMode(paramActionMode);
      paramActionMode = AppCompatDelegateImplV7.this;
      if (mActionModePopup != null) {
        mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
      }
      paramActionMode = AppCompatDelegateImplV7.this;
      if (mActionModeView != null)
      {
        paramActionMode.endOnGoingFadeAnimation();
        paramActionMode = AppCompatDelegateImplV7.this;
        mFadeAnim = v7.v7.package_13.ViewCompat.animate(mActionModeView).alpha(0.0F);
        mFadeAnim.setListener(new j.k.a(this));
      }
      paramActionMode = AppCompatDelegateImplV7.this;
      AppCompatCallback localAppCompatCallback = mAppCompatCallback;
      if (localAppCompatCallback != null) {
        localAppCompatCallback.onSupportActionModeFinished(mActionMode);
      }
      paramActionMode = AppCompatDelegateImplV7.this;
      mActionMode = null;
      v7.v7.package_13.ViewCompat.requestApplyInsets(mSubDecor);
      get();
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      v7.v7.package_13.ViewCompat.requestApplyInsets(mSubDecor);
      return mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
  
  class ListMenuDecorView
    extends ContentFrameLayout
  {
    public ListMenuDecorView(android.content.Context paramContext)
    {
      super();
    }
    
    private boolean isOutOfBounds(int paramInt1, int paramInt2)
    {
      return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > getWidth() + 5) || (paramInt2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplV7.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (isOutOfBounds((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        closePanel(0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(v7.internal.transition.util.View.getDrawable(getContext(), paramInt));
    }
  }
  
  public final class PanelFeatureState
  {
    int background;
    android.view.View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    e listMenuPresenter;
    android.content.Context listPresenterContext;
    androidx.appcompat.view.menu.f menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    android.view.View shownPanelView;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState()
    {
      featureId = this$1;
      refreshDecorView = false;
    }
    
    MenuView getListMenuView(l.a paramA)
    {
      if (menu == null) {
        return null;
      }
      if (listMenuPresenter == null)
      {
        e localE = new e(listPresenterContext, R.layout.abc_list_menu_item_layout);
        listMenuPresenter = localE;
        localE.setCallback(paramA);
        menu.addMenuPresenter(listMenuPresenter);
      }
      return listMenuPresenter.getMenuView(decorView);
    }
    
    public boolean hasPanelItems()
    {
      if (shownPanelView == null) {
        return false;
      }
      if (createdPanelView != null) {
        return true;
      }
      return listMenuPresenter.a().getCount() > 0;
    }
    
    void setMenu(androidx.appcompat.view.menu.f paramF)
    {
      Object localObject = menu;
      if (paramF == localObject) {
        return;
      }
      if (localObject != null) {
        ((androidx.appcompat.view.menu.f)localObject).b(listMenuPresenter);
      }
      menu = paramF;
      if (paramF != null)
      {
        localObject = listMenuPresenter;
        if (localObject != null) {
          paramF.addMenuPresenter((androidx.appcompat.view.menu.l)localObject);
        }
      }
    }
    
    void setStyle(android.content.Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      int i = resourceId;
      if (i != 0) {
        localTheme.applyStyle(i, true);
      }
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      i = resourceId;
      if (i != 0) {
        localTheme.applyStyle(i, true);
      } else {
        localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      }
      paramContext = new v7.internal.view.ContextThemeWrapper(paramContext, 0);
      paramContext.getTheme().setTo(localTheme);
      listPresenterContext = paramContext;
      paramContext = paramContext.obtainStyledAttributes(R.styleable.Theme);
      background = paramContext.getResourceId(R.styleable.Theme_panelBackground, 0);
      windowAnimations = paramContext.getResourceId(R.styleable.Theme_android_windowAnimationStyle, 0);
      paramContext.recycle();
    }
  }
  
  final class PanelMenuPresenterCallback
    implements l.a
  {
    PanelMenuPresenterCallback() {}
    
    public void onCloseMenu(androidx.appcompat.view.menu.f paramF, boolean paramBoolean)
    {
      androidx.appcompat.view.menu.f localF = paramF.getRootMenu();
      int i;
      if (localF != paramF) {
        i = 1;
      } else {
        i = 0;
      }
      AppCompatDelegateImplV7 localAppCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
      if (i != 0) {
        paramF = localF;
      }
      paramF = localAppCompatDelegateImplV7.findMenuPanel(paramF);
      if (paramF != null)
      {
        if (i != 0)
        {
          callOnPanelClosed(featureId, paramF, localF);
          closePanel(paramF, true);
          return;
        }
        closePanel(paramF, paramBoolean);
      }
    }
    
    public boolean onOpenSubMenu(androidx.appcompat.view.menu.f paramF)
    {
      if (paramF == paramF.getRootMenu())
      {
        Object localObject = AppCompatDelegateImplV7.this;
        if (mHasActionBar)
        {
          localObject = ((AppCompatDelegateImplV7)localObject).getWindowCallback();
          if ((localObject != null) && (!mIsDestroyed)) {
            ((Window.Callback)localObject).onMenuOpened(108, paramF);
          }
        }
      }
      return true;
    }
  }
}

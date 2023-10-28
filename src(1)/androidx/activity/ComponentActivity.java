package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.asm.ByteVector;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.Alarm;
import androidx.activity.result.AnnotationVisitor;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.app.s;
import androidx.core.content.ContextCompat;
import androidx.core.content.History;
import androidx.core.package_10.ActivityCompat;
import androidx.core.package_10.BaseListFragment;
import androidx.core.package_10.ChatMessage;
import androidx.core.package_10.Fragment;
import androidx.core.package_10.Handle;
import androidx.lifecycle.BaseFragment;
import androidx.lifecycle.ExtensionData;
import androidx.lifecycle.HttpManager;
import androidx.lifecycle.LayoutManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.MethodWriter;
import androidx.lifecycle.Plot;
import androidx.lifecycle.XYSeries;
import androidx.lifecycle.f0.a;
import androidx.lifecycle.f0.b;
import androidx.lifecycle.xy.PositionMetric;
import androidx.savedstate.Feedback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import v7.v7.package_13.i;
import v7.v7.util.DownloadManager;

public class ComponentActivity
  extends BaseListFragment
  implements androidx.lifecycle.d, androidx.lifecycle.h, XYSeries, androidx.savedstate.Label, Point, Alarm, History, androidx.core.content.Point, androidx.core.package_10.Translation, ChatMessage, v7.v7.package_13.Translation
{
  private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
  private final ActivityResultRegistry mActivityResultRegistry;
  private int mContentLayoutId;
  final ByteVector mContextAwareHelper = new ByteVector();
  private f0.b mDefaultFactory;
  private boolean mDispatchingOnMultiWindowModeChanged;
  private boolean mDispatchingOnPictureInPictureModeChanged;
  private final androidx.lifecycle.f mLifecycleRegistry = new androidx.lifecycle.f(this);
  private final i mMenuHostHelper = new i(new b(this));
  private final AtomicInteger mNextLocalRequestCode;
  private final OnBackPressedDispatcher mOnBackPressedDispatcher;
  private final CopyOnWriteArrayList<c.h.p.a<Configuration>> mOnConfigurationChangedListeners;
  private final CopyOnWriteArrayList<c.h.p.a<androidx.core.app.h>> mOnMultiWindowModeChangedListeners;
  private final CopyOnWriteArrayList<c.h.p.a<Intent>> mOnNewIntentListeners;
  private final CopyOnWriteArrayList<c.h.p.a<s>> mOnPictureInPictureModeChangedListeners;
  private final CopyOnWriteArrayList<c.h.p.a<Integer>> mOnTrimMemoryListeners;
  final androidx.savedstate.f mSavedStateRegistryController;
  private androidx.lifecycle.ClassWriter mViewModelStore;
  
  public ComponentActivity()
  {
    androidx.savedstate.f localF = androidx.savedstate.f.a(this);
    mSavedStateRegistryController = localF;
    mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
    mNextLocalRequestCode = new AtomicInteger();
    mActivityResultRegistry = new b();
    mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
    mOnTrimMemoryListeners = new CopyOnWriteArrayList();
    mOnNewIntentListeners = new CopyOnWriteArrayList();
    mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
    mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
    mDispatchingOnMultiWindowModeChanged = false;
    mDispatchingOnPictureInPictureModeChanged = false;
    if (getLifecycle() != null)
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 19) {
        getLifecycle().a(new LayoutManager()
        {
          public void b(androidx.lifecycle.d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
          {
            if (paramAnonymousEvent == Lifecycle.Event.ON_STOP)
            {
              paramAnonymousD = getWindow();
              if (paramAnonymousD != null) {
                paramAnonymousD = paramAnonymousD.peekDecorView();
              } else {
                paramAnonymousD = null;
              }
              if (paramAnonymousD != null) {
                ComponentActivity.c.c(paramAnonymousD);
              }
            }
          }
        });
      }
      getLifecycle().a(new LayoutManager()
      {
        public void b(androidx.lifecycle.d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
        {
          if (paramAnonymousEvent == Lifecycle.Event.ON_DESTROY)
          {
            mContextAwareHelper.a();
            if (!isChangingConfigurations()) {
              getViewModelStore().a();
            }
          }
        }
      });
      getLifecycle().a(new LayoutManager()
      {
        public void b(androidx.lifecycle.d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
        {
          ensureViewModelStore();
          getLifecycle().clear(this);
        }
      });
      localF.a();
      MethodWriter.b(this);
      if ((19 <= i) && (i <= 23)) {
        getLifecycle().a(new ImmLeaksCleaner(this));
      }
      getSavedStateRegistry().a("android:support:activity-result", new g(this));
      addOnContextAvailableListener(new d(this));
      return;
    }
    throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
  }
  
  public ComponentActivity(int paramInt)
  {
    this();
    mContentLayoutId = paramInt;
  }
  
  private void initViewTreeOwners()
  {
    ExtensionData.b(getWindow().getDecorView(), this);
    HttpManager.init(getWindow().getDecorView(), this);
    Feedback.set(getWindow().getDecorView(), this);
    k.a(getWindow().getDecorView(), this);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    super.addContentView(paramView, paramLayoutParams);
  }
  
  public void addMenuProvider(v7.v7.package_13.h paramH)
  {
    mMenuHostHelper.l(paramH);
  }
  
  public void addMenuProvider(v7.v7.package_13.h paramH, androidx.lifecycle.d paramD)
  {
    mMenuHostHelper.a(paramH, paramD);
  }
  
  public void addMenuProvider(v7.v7.package_13.h paramH, androidx.lifecycle.d paramD, Lifecycle.State paramState)
  {
    mMenuHostHelper.a(paramH, paramD, paramState);
  }
  
  public final void addOnConfigurationChangedListener(DownloadManager paramDownloadManager)
  {
    mOnConfigurationChangedListeners.add(paramDownloadManager);
  }
  
  public final void addOnContextAvailableListener(androidx.activity.asm.c paramC)
  {
    mContextAwareHelper.a(paramC);
  }
  
  public final void addOnMultiWindowModeChangedListener(DownloadManager paramDownloadManager)
  {
    mOnMultiWindowModeChangedListeners.add(paramDownloadManager);
  }
  
  public final void addOnNewIntentListener(DownloadManager paramDownloadManager)
  {
    mOnNewIntentListeners.add(paramDownloadManager);
  }
  
  public final void addOnPictureInPictureModeChangedListener(DownloadManager paramDownloadManager)
  {
    mOnPictureInPictureModeChangedListeners.add(paramDownloadManager);
  }
  
  public final void addOnTrimMemoryListener(DownloadManager paramDownloadManager)
  {
    mOnTrimMemoryListeners.add(paramDownloadManager);
  }
  
  void ensureViewModelStore()
  {
    if (mViewModelStore == null)
    {
      e localE = (e)getLastNonConfigurationInstance();
      if (localE != null) {
        mViewModelStore = loginTask;
      }
      if (mViewModelStore == null) {
        mViewModelStore = new androidx.lifecycle.ClassWriter();
      }
    }
  }
  
  public final ActivityResultRegistry getActivityResultRegistry()
  {
    return mActivityResultRegistry;
  }
  
  public androidx.lifecycle.xy.a getDefaultViewModelCreationExtras()
  {
    PositionMetric localPositionMetric = new PositionMetric();
    if (getApplication() != null) {
      localPositionMetric.a(f0.a.c, getApplication());
    }
    localPositionMetric.a(MethodWriter.l, this);
    localPositionMetric.a(MethodWriter.o, this);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {
      localPositionMetric.a(MethodWriter.d, getIntent().getExtras());
    }
    return localPositionMetric;
  }
  
  public f0.b getDefaultViewModelProviderFactory()
  {
    if (mDefaultFactory == null)
    {
      Application localApplication = getApplication();
      Bundle localBundle;
      if (getIntent() != null) {
        localBundle = getIntent().getExtras();
      } else {
        localBundle = null;
      }
      mDefaultFactory = new Plot(localApplication, this, localBundle);
    }
    return mDefaultFactory;
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    e localE = (e)getLastNonConfigurationInstance();
    if (localE != null) {
      return custom;
    }
    return null;
  }
  
  public Lifecycle getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return mOnBackPressedDispatcher;
  }
  
  public final androidx.savedstate.ClassWriter getSavedStateRegistry()
  {
    return mSavedStateRegistryController.n();
  }
  
  public androidx.lifecycle.ClassWriter getViewModelStore()
  {
    if (getApplication() != null)
    {
      ensureViewModelStore();
      return mViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public void invalidateMenu()
  {
    invalidateOptionsMenu();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!mActivityResultRegistry.set(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    mOnBackPressedDispatcher.update();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = mOnConfigurationChangedListeners.iterator();
    while (localIterator.hasNext()) {
      ((DownloadManager)localIterator.next()).a(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    mSavedStateRegistryController.a(paramBundle);
    mContextAwareHelper.a(this);
    super.onCreate(paramBundle);
    BaseFragment.showDialog(this);
    if (v7.v7.menu.Context.get()) {
      mOnBackPressedDispatcher.b(d.openDocument(this));
    }
    int i = mContentLayoutId;
    if (i != 0) {
      setContentView(i);
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      super.onCreatePanelMenu(paramInt, paramMenu);
      mMenuHostHelper.a(paramMenu, getMenuInflater());
    }
    return true;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    if (paramInt == 0) {
      return mMenuHostHelper.a(paramMenuItem);
    }
    return false;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (mDispatchingOnMultiWindowModeChanged) {
      return;
    }
    Iterator localIterator = mOnMultiWindowModeChangedListeners.iterator();
    while (localIterator.hasNext()) {
      ((DownloadManager)localIterator.next()).a(new Fragment(paramBoolean));
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    mDispatchingOnMultiWindowModeChanged = true;
    try
    {
      super.onMultiWindowModeChanged(paramBoolean, paramConfiguration);
      mDispatchingOnMultiWindowModeChanged = false;
      Iterator localIterator = mOnMultiWindowModeChangedListeners.iterator();
      while (localIterator.hasNext()) {
        ((DownloadManager)localIterator.next()).a(new Fragment(paramBoolean, paramConfiguration));
      }
      return;
    }
    catch (Throwable paramConfiguration)
    {
      mDispatchingOnMultiWindowModeChanged = false;
      throw paramConfiguration;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Iterator localIterator = mOnNewIntentListeners.iterator();
    while (localIterator.hasNext()) {
      ((DownloadManager)localIterator.next()).a(paramIntent);
    }
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    mMenuHostHelper.b(paramMenu);
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    if (mDispatchingOnPictureInPictureModeChanged) {
      return;
    }
    Iterator localIterator = mOnPictureInPictureModeChangedListeners.iterator();
    while (localIterator.hasNext()) {
      ((DownloadManager)localIterator.next()).a(new androidx.core.package_10.c(paramBoolean));
    }
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    mDispatchingOnPictureInPictureModeChanged = true;
    try
    {
      super.onPictureInPictureModeChanged(paramBoolean, paramConfiguration);
      mDispatchingOnPictureInPictureModeChanged = false;
      Iterator localIterator = mOnPictureInPictureModeChangedListeners.iterator();
      while (localIterator.hasNext()) {
        ((DownloadManager)localIterator.next()).a(new androidx.core.package_10.c(paramBoolean, paramConfiguration));
      }
      return;
    }
    catch (Throwable paramConfiguration)
    {
      mDispatchingOnPictureInPictureModeChanged = false;
      throw paramConfiguration;
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      super.onPreparePanel(paramInt, paramView, paramMenu);
      mMenuHostHelper.a(paramMenu);
    }
    return true;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((!mActivityResultRegistry.set(paramInt, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", paramArrayOfString).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", paramArrayOfInt))) && (Build.VERSION.SDK_INT >= 23)) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject3 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = mViewModelStore;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      e localE = (e)getLastNonConfigurationInstance();
      localObject1 = localObject2;
      if (localE != null) {
        localObject1 = loginTask;
      }
    }
    if ((localObject1 == null) && (localObject3 == null)) {
      return null;
    }
    localObject2 = new e();
    custom = localObject3;
    loginTask = ((androidx.lifecycle.ClassWriter)localObject1);
    return localObject2;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    Lifecycle localLifecycle = getLifecycle();
    if ((localLifecycle instanceof androidx.lifecycle.f)) {
      ((androidx.lifecycle.f)localLifecycle).c(Lifecycle.State.d);
    }
    super.onSaveInstanceState(paramBundle);
    mSavedStateRegistryController.b(paramBundle);
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    Iterator localIterator = mOnTrimMemoryListeners.iterator();
    while (localIterator.hasNext()) {
      ((DownloadManager)localIterator.next()).a(Integer.valueOf(paramInt));
    }
  }
  
  public android.content.Context peekAvailableContext()
  {
    return mContextAwareHelper.b();
  }
  
  public final androidx.activity.result.Label registerForActivityResult(androidx.activity.result.asm.ClassWriter paramClassWriter, ActivityResultRegistry paramActivityResultRegistry, AnnotationVisitor paramAnnotationVisitor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity_rq#");
    localStringBuilder.append(mNextLocalRequestCode.getAndIncrement());
    return paramActivityResultRegistry.a(localStringBuilder.toString(), this, paramClassWriter, paramAnnotationVisitor);
  }
  
  public final androidx.activity.result.Label registerForActivityResult(androidx.activity.result.asm.ClassWriter paramClassWriter, AnnotationVisitor paramAnnotationVisitor)
  {
    return registerForActivityResult(paramClassWriter, mActivityResultRegistry, paramAnnotationVisitor);
  }
  
  public void removeMenuProvider(v7.v7.package_13.h paramH)
  {
    mMenuHostHelper.a(paramH);
  }
  
  public final void removeOnConfigurationChangedListener(DownloadManager paramDownloadManager)
  {
    mOnConfigurationChangedListeners.remove(paramDownloadManager);
  }
  
  public final void removeOnContextAvailableListener(androidx.activity.asm.c paramC)
  {
    mContextAwareHelper.trimToSize(paramC);
  }
  
  public final void removeOnMultiWindowModeChangedListener(DownloadManager paramDownloadManager)
  {
    mOnMultiWindowModeChangedListeners.remove(paramDownloadManager);
  }
  
  public final void removeOnNewIntentListener(DownloadManager paramDownloadManager)
  {
    mOnNewIntentListeners.remove(paramDownloadManager);
  }
  
  public final void removeOnPictureInPictureModeChangedListener(DownloadManager paramDownloadManager)
  {
    mOnPictureInPictureModeChangedListeners.remove(paramDownloadManager);
  }
  
  public final void removeOnTrimMemoryListener(DownloadManager paramDownloadManager)
  {
    mOnTrimMemoryListeners.remove(paramDownloadManager);
  }
  
  public void reportFullyDrawn()
  {
    try
    {
      boolean bool = v7.graphics.g.c();
      if (bool) {
        v7.graphics.g.a("reportFullyDrawn() for ComponentActivity");
      }
      int i = Build.VERSION.SDK_INT;
      if (i > 19)
      {
        super.reportFullyDrawn();
      }
      else if (i == 19)
      {
        i = ContextCompat.checkSelfPermission(this, "android.permission.UPDATE_DEVICE_STATS");
        if (i == 0) {
          super.reportFullyDrawn();
        }
      }
      v7.graphics.g.onSaveInstanceState();
      return;
    }
    catch (Throwable localThrowable)
    {
      v7.graphics.g.onSaveInstanceState();
      throw localThrowable;
    }
  }
  
  public void setContentView(int paramInt)
  {
    initViewTreeOwners();
    super.setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    initViewTreeOwners();
    super.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
    throws IntentSender.SendIntentException
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      ComponentActivity localComponentActivity = ComponentActivity.this;
      try
      {
        localComponentActivity.onBackPressed();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (TextUtils.equals(localIllegalStateException.getMessage(), "Can not perform this action after onSaveInstanceState")) {
          return;
        }
        throw localIllegalStateException;
      }
    }
  }
  
  class b
    extends ActivityResultRegistry
  {
    b() {}
    
    public void a(final int paramInt, final androidx.activity.result.asm.ClassWriter paramClassWriter, Object paramObject, Handle paramHandle)
    {
      ComponentActivity localComponentActivity = ComponentActivity.this;
      final androidx.activity.result.asm.Label localLabel = paramClassWriter.a(localComponentActivity, paramObject);
      if (localLabel != null)
      {
        new Handler(Looper.getMainLooper()).post(new a(paramInt, localLabel));
        return;
      }
      paramObject = paramClassWriter.b(localComponentActivity, paramObject);
      if ((paramObject.getExtras() != null) && (paramObject.getExtras().getClassLoader() == null)) {
        paramObject.setExtrasClassLoader(localComponentActivity.getClassLoader());
      }
      if (paramObject.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE"))
      {
        paramClassWriter = paramObject.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        paramObject.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
      }
      else
      {
        if (paramHandle != null) {
          break label232;
        }
        paramClassWriter = null;
      }
      if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(paramObject.getAction()))
      {
        paramObject = paramObject.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        paramClassWriter = paramObject;
        if (paramObject == null) {
          paramClassWriter = new String[0];
        }
        ActivityCompat.execute(localComponentActivity, paramClassWriter, paramInt);
        return;
      }
      if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(paramObject.getAction()))
      {
        paramObject = (IntentSenderRequest)paramObject.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try
        {
          ActivityCompat.startActivity(localComponentActivity, paramObject.getIcon(), paramInt, paramObject.getIntent(), paramObject.getString(), paramObject.b(), 0, paramClassWriter);
          return;
        }
        catch (IntentSender.SendIntentException paramClassWriter)
        {
          new Handler(Looper.getMainLooper()).post(new b(paramInt, paramClassWriter));
          return;
        }
      }
      ActivityCompat.startActivityForResult(localComponentActivity, paramObject, paramInt, paramClassWriter);
      return;
      label232:
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    
    class a
      implements Runnable
    {
      a(int paramInt, androidx.activity.result.asm.Label paramLabel) {}
      
      public void run()
      {
        a(paramInt, localLabel.b());
      }
    }
    
    class b
      implements Runnable
    {
      b(int paramInt, IntentSender.SendIntentException paramSendIntentException) {}
      
      public void run()
      {
        set(paramInt, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", paramClassWriter));
      }
    }
  }
  
  static class c
  {
    static void c(View paramView)
    {
      paramView.cancelPendingInputEvents();
    }
  }
  
  static class d
  {
    static OnBackInvokedDispatcher openDocument(Activity paramActivity)
    {
      return paramActivity.getOnBackInvokedDispatcher();
    }
  }
  
  static final class e
  {
    Object custom;
    androidx.lifecycle.ClassWriter loginTask;
    
    e() {}
  }
}

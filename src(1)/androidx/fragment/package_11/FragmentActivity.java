package androidx.fragment.package_11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.k;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.p;
import androidx.core.app.q;
import androidx.core.content.d;
import androidx.core.package_10.ActivityCompat;
import androidx.core.package_10.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.core.package_10.BaseListFragment;
import androidx.core.package_10.HttpHost;
import androidx.core.package_10.SharedElementCallback;
import androidx.fragment.app.m;
import androidx.fragment.app.r;
import androidx.fragment.app.w;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.f;
import androidx.lifecycle.j0;
import c.h.q.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import v7.v13.app.LoaderManager;
import v7.v7.package_13.h;
import v7.v7.util.DownloadManager;

public class FragmentActivity
  extends ComponentActivity
  implements ActivityCompat.OnRequestPermissionsResultCallback, HttpHost
{
  static final String LIFECYCLE_TAG = "android:support:lifecycle";
  boolean mCreated;
  final f mFragmentLifecycleRegistry = new f(this);
  final FragmentController mFragments = FragmentController.createController(new HostCallbacks());
  boolean mResumed;
  boolean mStopped = true;
  
  public FragmentActivity()
  {
    init();
  }
  
  public FragmentActivity(int paramInt)
  {
    super(paramInt);
    init();
  }
  
  private void init()
  {
    getSavedStateRegistry().a("android:support:lifecycle", new CordovaInterfaceImpl(this));
    addOnConfigurationChangedListener(new j(this));
    addOnNewIntentListener(new FixedTableModel.a(this));
    addOnContextAvailableListener(new e(this));
  }
  
  private static boolean markState(FragmentManager paramFragmentManager, Lifecycle.State paramState)
  {
    paramFragmentManager = paramFragmentManager.getFragment().iterator();
    boolean bool1 = false;
    while (paramFragmentManager.hasNext())
    {
      Fragment localFragment = (Fragment)paramFragmentManager.next();
      if (localFragment != null)
      {
        boolean bool2 = bool1;
        if (localFragment.getHost() != null) {
          bool2 = bool1 | markState(localFragment.getChildFragmentManager(), paramState);
        }
        MethodWriter localMethodWriter = mViewLifecycleOwner;
        bool1 = bool2;
        if (localMethodWriter != null)
        {
          bool1 = bool2;
          if (localMethodWriter.getLifecycle().c().a(Lifecycle.State.g))
          {
            mViewLifecycleOwner.f(paramState);
            bool1 = true;
          }
        }
        if (mLifecycleRegistry.c().a(Lifecycle.State.g))
        {
          mLifecycleRegistry.c(paramState);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return mFragments.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (!shouldDumpInternalState(paramArrayOfString)) {
      return;
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    localObject = ((StringBuilder)localObject).toString();
    paramPrintWriter.print((String)localObject);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(mCreated);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(mStopped);
    if (getApplication() != null) {
      LoaderManager.i(this).dump((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    mFragments.getSupportFragmentManager().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return mFragments.getSupportFragmentManager();
  }
  
  public LoaderManager getSupportLoaderManager()
  {
    return LoaderManager.i(this);
  }
  
  void markFragmentsCreated()
  {
    while (markState(getSupportFragmentManager(), Lifecycle.State.d)) {}
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    mFragments.noteStateNotSaved();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mFragmentLifecycleRegistry.append(Lifecycle.Event.ON_CREATE);
    mFragments.restoreAllState();
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = dispatchFragmentsOnCreateView(paramView, paramString, paramContext, paramAttributeSet);
    if (localView == null) {
      return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = dispatchFragmentsOnCreateView(null, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView1;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    mFragments.dispatchDestroy();
    mFragmentLifecycleRegistry.append(Lifecycle.Event.ON_DESTROY);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    if (paramInt == 6) {
      return mFragments.dispatchContextItemSelected(paramMenuItem);
    }
    return false;
  }
  
  protected void onPause()
  {
    super.onPause();
    mResumed = false;
    mFragments.dispatchPause();
    mFragmentLifecycleRegistry.append(Lifecycle.Event.ON_PAUSE);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    onResumeFragments();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    mFragments.noteStateNotSaved();
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    mFragments.noteStateNotSaved();
    super.onResume();
    mResumed = true;
    mFragments.execPendingActions();
  }
  
  protected void onResumeFragments()
  {
    mFragmentLifecycleRegistry.append(Lifecycle.Event.ON_RESUME);
    mFragments.dispatchResume();
  }
  
  protected void onStart()
  {
    mFragments.noteStateNotSaved();
    super.onStart();
    mStopped = false;
    if (!mCreated)
    {
      mCreated = true;
      mFragments.dispatchActivityCreated();
    }
    mFragments.execPendingActions();
    mFragmentLifecycleRegistry.append(Lifecycle.Event.ON_START);
    mFragments.dispatchStart();
  }
  
  public void onStateNotSaved()
  {
    mFragments.noteStateNotSaved();
  }
  
  protected void onStop()
  {
    super.onStop();
    mStopped = true;
    markFragmentsCreated();
    mFragments.dispatchStop();
    mFragmentLifecycleRegistry.append(Lifecycle.Event.ON_STOP);
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setEnterSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.setExitSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
      return;
    }
    paramFragment.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (paramInt1 == -1)
    {
      ActivityCompat.startActivity(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramFragment.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void supportFinishAfterTransition()
  {
    ActivityCompat.finishAfterTransition(this);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    invalidateOptionsMenu();
  }
  
  public void supportPostponeEnterTransition()
  {
    ActivityCompat.postponeEnterTransition(this);
  }
  
  public void supportStartPostponedEnterTransition()
  {
    ActivityCompat.startPostponedEnterTransition(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt) {}
  
  class HostCallbacks
    extends r<m>
    implements androidx.core.content.c, d, p, q, j0, k, androidx.activity.result.c, androidx.savedstate.e, w, o
  {
    public HostCallbacks()
    {
      super();
    }
    
    public void addMenuProvider(h paramH)
    {
      FragmentActivity.this.addMenuProvider(paramH);
    }
    
    public void addOnConfigurationChangedListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.addOnConfigurationChangedListener(paramDownloadManager);
    }
    
    public void addOnMultiWindowModeChangedListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.addOnMultiWindowModeChangedListener(paramDownloadManager);
    }
    
    public void addOnPictureInPictureModeChangedListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.addOnPictureInPictureModeChangedListener(paramDownloadManager);
    }
    
    public void addOnTrimMemoryListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.addOnTrimMemoryListener(paramDownloadManager);
    }
    
    public View findViewById(int paramInt)
    {
      return FragmentActivity.this.findViewById(paramInt);
    }
    
    public ActivityResultRegistry getActivityResultRegistry()
    {
      return FragmentActivity.this.getActivityResultRegistry();
    }
    
    public Lifecycle getLifecycle()
    {
      return mFragmentLifecycleRegistry;
    }
    
    public OnBackPressedDispatcher getOnBackPressedDispatcher()
    {
      return FragmentActivity.this.getOnBackPressedDispatcher();
    }
    
    public androidx.savedstate.ClassWriter getSavedStateRegistry()
    {
      return FragmentActivity.this.getSavedStateRegistry();
    }
    
    public androidx.lifecycle.ClassWriter getViewModelStore()
    {
      return FragmentActivity.this.getViewModelStore();
    }
    
    public FragmentActivity onAttachFragment()
    {
      return FragmentActivity.this;
    }
    
    public void onAttachFragment(FragmentManager paramFragmentManager, Fragment paramFragment)
    {
      onAttachFragment(paramFragment);
    }
    
    public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    
    public LayoutInflater onGetLayoutInflater()
    {
      return getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public boolean onHasView()
    {
      Window localWindow = getWindow();
      return (localWindow != null) && (localWindow.peekDecorView() != null);
    }
    
    public boolean onShouldShowRequestPermissionRationale(String paramString)
    {
      return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, paramString);
    }
    
    public void onStartActivityFromFragment()
    {
      invalidateOptionsMenu();
    }
    
    public void onSupportInvalidateOptionsMenu()
    {
      onStartActivityFromFragment();
    }
    
    public void removeMenuProvider(h paramH)
    {
      FragmentActivity.this.removeMenuProvider(paramH);
    }
    
    public void removeOnConfigurationChangedListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.removeOnConfigurationChangedListener(paramDownloadManager);
    }
    
    public void removeOnMultiWindowModeChangedListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.removeOnMultiWindowModeChangedListener(paramDownloadManager);
    }
    
    public void removeOnPictureInPictureModeChangedListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.removeOnPictureInPictureModeChangedListener(paramDownloadManager);
    }
    
    public void removeOnTrimMemoryListener(DownloadManager paramDownloadManager)
    {
      FragmentActivity.this.removeOnTrimMemoryListener(paramDownloadManager);
    }
  }
}

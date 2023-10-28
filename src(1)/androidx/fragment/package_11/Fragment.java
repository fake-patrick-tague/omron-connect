package androidx.fragment.package_11;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.AnnotationVisitor;
import androidx.core.package_10.SharedElementCallback;
import androidx.fragment.app.r;
import androidx.fragment.package_11.strictmode.FragmentStrictMode;
import androidx.lifecycle.ExtensionData;
import androidx.lifecycle.HttpManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Plot;
import androidx.lifecycle.StatusPreference;
import androidx.lifecycle.XYSeries;
import androidx.lifecycle.d;
import androidx.lifecycle.f0.a;
import androidx.lifecycle.f0.b;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.s;
import androidx.lifecycle.xy.PositionMetric;
import androidx.lifecycle.xy.a;
import androidx.savedstate.Feedback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import v7.support.v7.widget.Paint;
import v7.v13.app.LoaderManager;
import v7.v7.package_13.LayoutInflaterCompatHC;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, d, h, XYSeries, androidx.savedstate.Label
{
  static final int ACTIVITY_CREATED = 4;
  static final int ATTACHED = 0;
  static final int AWAITING_ENTER_EFFECTS = 6;
  static final int AWAITING_EXIT_EFFECTS = 3;
  static final int CREATED = 1;
  static final int INITIALIZING = -1;
  static final int RESUMED = 7;
  static final int STARTED = 5;
  static final Object USE_DEFAULT_TRANSITION = new Object();
  static final int VIEW_CREATED = 2;
  boolean mAdded;
  j mAnimationInfo;
  Bundle mArguments;
  int mBackStackNesting;
  boolean mBeingSaved;
  private boolean mCalled;
  FragmentManager mChildFragmentManager = new OrgNode();
  ViewGroup mContainer;
  int mContainerId;
  private int mContentLayoutId;
  f0.b mDefaultFactory;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManager mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mHiddenChanged;
  r<?> mHost;
  boolean mInLayout;
  boolean mIsCreated;
  private Boolean mIsPrimaryNavigationFragment = null;
  LayoutInflater mLayoutInflater;
  androidx.lifecycle.f mLifecycleRegistry;
  Lifecycle.State mMaxState = Lifecycle.State.y;
  boolean mMenuVisible = true;
  private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
  private final ArrayList<androidx.fragment.app.Fragment.m> mOnPreAttachedListeners = new ArrayList();
  Fragment mParentFragment;
  boolean mPerformedCreateView;
  Runnable mPostponedDurationRunnable = new b();
  public String mPreviousWho;
  boolean mRemoving;
  boolean mRestored;
  boolean mRetainInstance;
  boolean mRetainInstanceChangedWhileDetached;
  Bundle mSavedFragmentState;
  private final m mSavedStateAttachListener = new c();
  androidx.savedstate.f mSavedStateRegistryController;
  Boolean mSavedUserVisibleHint;
  Bundle mSavedViewRegistryState;
  SparseArray<Parcelable> mSavedViewState;
  int mState = -1;
  String mTag;
  Fragment mTarget;
  int mTargetRequestCode;
  String mTargetWho = null;
  boolean mUserVisibleHint = true;
  View mView;
  MethodWriter mViewLifecycleOwner;
  s<m> mViewLifecycleOwnerLiveData = new StatusPreference();
  String mWho = UUID.randomUUID().toString();
  
  public Fragment()
  {
    initLifecycle();
  }
  
  public Fragment(int paramInt)
  {
    this();
    mContentLayoutId = paramInt;
  }
  
  private j ensureAnimationInfo()
  {
    if (mAnimationInfo == null) {
      mAnimationInfo = new j();
    }
    return mAnimationInfo;
  }
  
  private int getMinimumMaxLifecycleState()
  {
    Lifecycle.State localState = mMaxState;
    if ((localState != Lifecycle.State.i) && (mParentFragment != null)) {
      return Math.min(localState.ordinal(), mParentFragment.getMinimumMaxLifecycleState());
    }
    return localState.ordinal();
  }
  
  private Fragment getTargetFragment(boolean paramBoolean)
  {
    if (paramBoolean) {
      FragmentStrictMode.close(this);
    }
    Object localObject = mTarget;
    if (localObject != null) {
      return localObject;
    }
    localObject = mFragmentManager;
    if (localObject != null)
    {
      String str = mTargetWho;
      if (str != null) {
        return ((FragmentManager)localObject).get(str);
      }
    }
    return null;
  }
  
  private void initLifecycle()
  {
    mLifecycleRegistry = new androidx.lifecycle.f(this);
    mSavedStateRegistryController = androidx.savedstate.f.a(this);
    mDefaultFactory = null;
    if (!mOnPreAttachedListeners.contains(mSavedStateAttachListener)) {
      registerOnPreAttachListener(mSavedStateAttachListener);
    }
  }
  
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }
  
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      paramContext = Loader.forName(paramContext.getClassLoader(), paramString);
      paramContext = paramContext.getConstructor(new Class[0]);
      paramContext = paramContext.newInstance(new Object[0]);
      paramContext = (Fragment)paramContext;
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
        return paramContext;
      }
    }
    catch (InvocationTargetException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": calling Fragment constructor caused an exception");
      throw new l(paramBundle.toString(), paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": could not find Fragment constructor");
      throw new l(paramBundle.toString(), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new l(paramBundle.toString(), paramContext);
    }
    catch (InstantiationException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new l(paramBundle.toString(), paramContext);
    }
    return paramContext;
  }
  
  private androidx.activity.result.Label prepareCallInternal(androidx.activity.result.asm.ClassWriter paramClassWriter, Paint paramPaint, AnnotationVisitor paramAnnotationVisitor)
  {
    if (mState <= 1)
    {
      AtomicReference localAtomicReference = new AtomicReference();
      registerOnPreAttachListener(new Fragment.i(this, paramPaint, localAtomicReference, paramClassWriter, paramAnnotationVisitor));
      return new Fragment.a(this, localAtomicReference, paramClassWriter);
    }
    paramClassWriter = new StringBuilder();
    paramClassWriter.append("Fragment ");
    paramClassWriter.append(this);
    paramClassWriter.append(" is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    throw new IllegalStateException(paramClassWriter.toString());
  }
  
  private void registerOnPreAttachListener(m paramM)
  {
    if (mState >= 0)
    {
      paramM.b();
      return;
    }
    mOnPreAttachedListeners.add(paramM);
  }
  
  private void restoreViewState()
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveto RESTORE_VIEW_STATE: ");
      localStringBuilder.append(this);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    if (mView != null) {
      restoreViewState(mSavedFragmentState);
    }
    mSavedFragmentState = null;
  }
  
  void callStartTransitionListener(boolean paramBoolean)
  {
    Object localObject = mAnimationInfo;
    if (localObject != null) {
      success = false;
    }
    if (mView != null)
    {
      localObject = mContainer;
      if (localObject != null)
      {
        FragmentManager localFragmentManager = mFragmentManager;
        if (localFragmentManager != null)
        {
          localObject = SpecialEffectsController.a((ViewGroup)localObject, localFragmentManager);
          ((SpecialEffectsController)localObject).run();
          if (paramBoolean)
          {
            mHost.getHandler().post(new Fragment.e(this, (SpecialEffectsController)localObject));
            return;
          }
          ((SpecialEffectsController)localObject).a();
        }
      }
    }
  }
  
  AppCompatDelegate createFragmentContainer()
  {
    return new Fragment.f(this);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(mState);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(mRetainInstance);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(mUserVisibleHint);
    if (mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(mFragmentManager);
    }
    if (mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(mHost);
    }
    if (mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(mParentFragment);
    }
    if (mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(mArguments);
    }
    if (mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(mSavedFragmentState);
    }
    if (mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(mSavedViewState);
    }
    if (mSavedViewRegistryState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewRegistryState=");
      paramPrintWriter.println(mSavedViewRegistryState);
    }
    Object localObject = getTargetFragment(false);
    if (localObject != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(localObject);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(mTargetRequestCode);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mPopDirection=");
    paramPrintWriter.println(getPopDirection());
    if (getEnterAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getEnterAnim=");
      paramPrintWriter.println(getEnterAnim());
    }
    if (getExitAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getExitAnim=");
      paramPrintWriter.println(getExitAnim());
    }
    if (getPopEnterAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getPopEnterAnim=");
      paramPrintWriter.println(getPopEnterAnim());
    }
    if (getPopExitAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("getPopExitAnim=");
      paramPrintWriter.println(getPopExitAnim());
    }
    if (mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(mContainer);
    }
    if (mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
    }
    if (getContext() != null) {
      LoaderManager.i(this).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    paramPrintWriter.print(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Child ");
    ((StringBuilder)localObject).append(mChildFragmentManager);
    ((StringBuilder)localObject).append(":");
    paramPrintWriter.println(((StringBuilder)localObject).toString());
    localObject = mChildFragmentManager;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("  ");
    ((FragmentManager)localObject).dump(localStringBuilder.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  Fragment findFragmentByWho(String paramString)
  {
    if (paramString.equals(mWho)) {
      return this;
    }
    return mChildFragmentManager.create(paramString);
  }
  
  String generateActivityResultKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fragment_");
    localStringBuilder.append(mWho);
    localStringBuilder.append("_rq#");
    localStringBuilder.append(mNextLocalRequestCode.getAndIncrement());
    return localStringBuilder.toString();
  }
  
  public final FragmentActivity getActivity()
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback == null) {
      return null;
    }
    return (FragmentActivity)localFragmentHostCallback.getActivity();
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = mAllowEnterTransitionOverlap;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return true;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = mAllowReturnTransitionOverlap;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return true;
  }
  
  View getAnimatingAway()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return null;
    }
    return dialogView;
  }
  
  public final Bundle getArguments()
  {
    return mArguments;
  }
  
  public final FragmentManager getChildFragmentManager()
  {
    if (mHost != null) {
      return mChildFragmentManager;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" has not been attached yet.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Context getContext()
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback == null) {
      return null;
    }
    return localFragmentHostCallback.getContext();
  }
  
  public a getDefaultViewModelCreationExtras()
  {
    for (Object localObject1 = requireContext().getApplicationContext(); (localObject1 instanceof ContextWrapper); localObject1 = ((ContextWrapper)localObject1).getBaseContext()) {
      if ((localObject1 instanceof Application))
      {
        localObject1 = (Application)localObject1;
        break label43;
      }
    }
    localObject1 = null;
    label43:
    if ((localObject1 == null) && (FragmentManager.get(3)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Could not find Application instance from Context ");
      ((StringBuilder)localObject2).append(requireContext().getApplicationContext());
      ((StringBuilder)localObject2).append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
      Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new PositionMetric();
    if (localObject1 != null) {
      ((PositionMetric)localObject2).a(f0.a.c, localObject1);
    }
    ((PositionMetric)localObject2).a(androidx.lifecycle.MethodWriter.l, this);
    ((PositionMetric)localObject2).a(androidx.lifecycle.MethodWriter.o, this);
    if (getArguments() != null) {
      ((PositionMetric)localObject2).a(androidx.lifecycle.MethodWriter.d, getArguments());
    }
    return localObject2;
  }
  
  public f0.b getDefaultViewModelProviderFactory()
  {
    if (mFragmentManager != null)
    {
      if (mDefaultFactory == null)
      {
        Object localObject3 = null;
        Object localObject1;
        for (Object localObject2 = requireContext().getApplicationContext();; localObject2 = ((ContextWrapper)localObject2).getBaseContext())
        {
          localObject1 = localObject3;
          if (!(localObject2 instanceof ContextWrapper)) {
            break;
          }
          if ((localObject2 instanceof Application))
          {
            localObject1 = (Application)localObject2;
            break;
          }
        }
        if ((localObject1 == null) && (FragmentManager.get(3)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Could not find Application instance from Context ");
          ((StringBuilder)localObject2).append(requireContext().getApplicationContext());
          ((StringBuilder)localObject2).append(", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
          Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
        }
        mDefaultFactory = new Plot((Application)localObject1, this, getArguments());
      }
      return mDefaultFactory;
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  int getEnterAnim()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return 0;
    }
    return mAnimations;
  }
  
  public Object getEnterTransition()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return null;
    }
    return mEnterTransition;
  }
  
  SharedElementCallback getEnterTransitionCallback()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return null;
    }
    return mEnterTransitionCallback;
  }
  
  int getExitAnim()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return 0;
    }
    return mLastAnimatedPosition;
  }
  
  public Object getExitTransition()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return null;
    }
    return mExitTransition;
  }
  
  SharedElementCallback getExitTransitionCallback()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return null;
    }
    return mExitTransitionCallback;
  }
  
  View getFocusedView()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return null;
    }
    return moveTo;
  }
  
  public final FragmentManager getFragmentManager()
  {
    return mFragmentManager;
  }
  
  public final Object getHost()
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback == null) {
      return null;
    }
    return localFragmentHostCallback.onGetHost();
  }
  
  public final int getId()
  {
    return mFragmentId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    LayoutInflater localLayoutInflater2 = mLayoutInflater;
    LayoutInflater localLayoutInflater1 = localLayoutInflater2;
    if (localLayoutInflater2 == null) {
      localLayoutInflater1 = performGetLayoutInflater(null);
    }
    return localLayoutInflater1;
  }
  
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    paramBundle = mHost;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.onGetLayoutInflater();
      LayoutInflaterCompatHC.setFactory(paramBundle, mChildFragmentManager.findFragmentByTag());
      return paramBundle;
    }
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public Lifecycle getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  public LoaderManager getLoaderManager()
  {
    return LoaderManager.i(this);
  }
  
  int getNextTransition()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return 0;
    }
    return postDetail;
  }
  
  public final Fragment getParentFragment()
  {
    return mParentFragment;
  }
  
  public final FragmentManager getParentFragmentManager()
  {
    Object localObject = mFragmentManager;
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not associated with a fragment manager.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  boolean getPopDirection()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return false;
    }
    return fsync;
  }
  
  int getPopEnterAnim()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return 0;
    }
    return images;
  }
  
  int getPopExitAnim()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return 0;
    }
    return animations;
  }
  
  float getPostOnViewCreatedAlpha()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return 1.0F;
    }
    return pitch;
  }
  
  public Object getReenterTransition()
  {
    Object localObject = mAnimationInfo;
    if (localObject == null) {
      return null;
    }
    localObject = mReenterTransition;
    if (localObject == USE_DEFAULT_TRANSITION) {
      return getExitTransition();
    }
    return localObject;
  }
  
  public final Resources getResources()
  {
    return requireContext().getResources();
  }
  
  public final boolean getRetainInstance()
  {
    FragmentStrictMode.b(this);
    return mRetainInstance;
  }
  
  public Object getReturnTransition()
  {
    Object localObject = mAnimationInfo;
    if (localObject == null) {
      return null;
    }
    localObject = mReturnTransition;
    if (localObject == USE_DEFAULT_TRANSITION) {
      return getEnterTransition();
    }
    return localObject;
  }
  
  public final androidx.savedstate.ClassWriter getSavedStateRegistry()
  {
    return mSavedStateRegistryController.n();
  }
  
  public Object getSharedElementEnterTransition()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return null;
    }
    return mSharedElementEnterTransition;
  }
  
  public Object getSharedElementReturnTransition()
  {
    Object localObject = mAnimationInfo;
    if (localObject == null) {
      return null;
    }
    localObject = mSharedElementReturnTransition;
    if (localObject == USE_DEFAULT_TRANSITION) {
      return getSharedElementEnterTransition();
    }
    return localObject;
  }
  
  ArrayList getSharedElementSourceNames()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = o;
      if (localObject != null) {
        return localObject;
      }
    }
    return new ArrayList();
  }
  
  ArrayList getSharedElementTargetNames()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = j;
      if (localObject != null) {
        return localObject;
      }
    }
    return new ArrayList();
  }
  
  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  public final String getTag()
  {
    return mTag;
  }
  
  public final Fragment getTargetFragment()
  {
    return getTargetFragment(true);
  }
  
  public final int getTargetRequestCode()
  {
    FragmentStrictMode.setEnabled(this);
    return mTargetRequestCode;
  }
  
  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  public boolean getUserVisibleHint()
  {
    return mUserVisibleHint;
  }
  
  public View getView()
  {
    return mView;
  }
  
  public d getViewLifecycleOwner()
  {
    MethodWriter localMethodWriter = mViewLifecycleOwner;
    if (localMethodWriter != null) {
      return localMethodWriter;
    }
    throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
  }
  
  public LiveData getViewLifecycleOwnerLiveData()
  {
    return mViewLifecycleOwnerLiveData;
  }
  
  public androidx.lifecycle.ClassWriter getViewModelStore()
  {
    if (mFragmentManager != null)
    {
      if (getMinimumMaxLifecycleState() != Lifecycle.State.i.ordinal()) {
        return mFragmentManager.init(this);
      }
      throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  public final boolean hasOptionsMenu()
  {
    return mHasMenu;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  void initState()
  {
    initLifecycle();
    mPreviousWho = mWho;
    mWho = UUID.randomUUID().toString();
    mAdded = false;
    mRemoving = false;
    mFromLayout = false;
    mInLayout = false;
    mRestored = false;
    mBackStackNesting = 0;
    mFragmentManager = null;
    mChildFragmentManager = new OrgNode();
    mHost = null;
    mFragmentId = 0;
    mContainerId = 0;
    mTag = null;
    mHidden = false;
    mDetached = false;
  }
  
  public final boolean isAdded()
  {
    return (mHost != null) && (mAdded);
  }
  
  public final boolean isDetached()
  {
    return mDetached;
  }
  
  public final boolean isHidden()
  {
    if (!mHidden)
    {
      FragmentManager localFragmentManager = mFragmentManager;
      if ((localFragmentManager == null) || (!localFragmentManager.getBoolean(mParentFragment))) {
        return false;
      }
    }
    return true;
  }
  
  final boolean isInBackStack()
  {
    return mBackStackNesting > 0;
  }
  
  public final boolean isInLayout()
  {
    return mInLayout;
  }
  
  public final boolean isMenuVisible()
  {
    if (mMenuVisible)
    {
      FragmentManager localFragmentManager = mFragmentManager;
      if ((localFragmentManager == null) || (localFragmentManager.isPrimitive(mParentFragment))) {
        return true;
      }
    }
    return false;
  }
  
  boolean isPostponed()
  {
    j localJ = mAnimationInfo;
    if (localJ == null) {
      return false;
    }
    return success;
  }
  
  public final boolean isRemoving()
  {
    return mRemoving;
  }
  
  public final boolean isResumed()
  {
    return mState >= 7;
  }
  
  public final boolean isStateSaved()
  {
    FragmentManager localFragmentManager = mFragmentManager;
    if (localFragmentManager == null) {
      return false;
    }
    return localFragmentManager.b();
  }
  
  public final boolean isVisible()
  {
    if ((isAdded()) && (!isHidden()))
    {
      View localView = mView;
      if ((localView != null) && (localView.getWindowToken() != null) && (mView.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  void noteStateNotSaved()
  {
    mChildFragmentManager.onStart();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(this);
      localStringBuilder.append(" received the following in onActivityResult(): requestCode: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" resultCode: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" data: ");
      localStringBuilder.append(paramIntent);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    mCalled = true;
  }
  
  public void onAttach(Context paramContext)
  {
    mCalled = true;
    paramContext = mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = paramContext.getActivity();
    }
    if (paramContext != null)
    {
      mCalled = false;
      onAttach(paramContext);
    }
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    mCalled = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    mCalled = true;
    restoreChildFragmentState(paramBundle);
    if (!mChildFragmentManager.getFragment(1)) {
      mChildFragmentManager.restoreState();
    }
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    requireActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = mContentLayoutId;
    if (i != 0) {
      return paramLayoutInflater.inflate(i, paramViewGroup, false);
    }
    return null;
  }
  
  public void onDestroy()
  {
    mCalled = true;
  }
  
  public void onDestroyOptionsMenu() {}
  
  public void onDestroyView()
  {
    mCalled = true;
  }
  
  public void onDetach()
  {
    mCalled = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    return getLayoutInflater(paramBundle);
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    mCalled = true;
    paramContext = mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = paramContext.getActivity();
    }
    if (paramContext != null)
    {
      mCalled = false;
      onInflate(paramContext, paramAttributeSet, paramBundle);
    }
  }
  
  public void onLowMemory()
  {
    mCalled = true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  public void onPause()
  {
    mCalled = true;
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onPrimaryNavigationFragmentChanged(boolean paramBoolean) {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onResume()
  {
    mCalled = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    mCalled = true;
  }
  
  public void onStop()
  {
    mCalled = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    mCalled = true;
  }
  
  void performActivityCreated(Bundle paramBundle)
  {
    mChildFragmentManager.onStart();
    mState = 3;
    mCalled = false;
    onActivityCreated(paramBundle);
    if (mCalled)
    {
      restoreViewState();
      mChildFragmentManager.onActivityCreated();
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onActivityCreated()");
    throw new SuperNotCalledException(paramBundle.toString());
  }
  
  void performAttach()
  {
    Object localObject = mOnPreAttachedListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((m)((Iterator)localObject).next()).b();
    }
    mOnPreAttachedListeners.clear();
    mChildFragmentManager.onCreate(mHost, createFragmentContainer(), this);
    mState = 0;
    mCalled = false;
    onAttach(mHost.getContext());
    if (mCalled)
    {
      mFragmentManager.c(this);
      mChildFragmentManager.run();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onAttach()");
    throw new SuperNotCalledException(((StringBuilder)localObject).toString());
  }
  
  void performConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    mChildFragmentManager.dump(paramConfiguration);
  }
  
  boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    if (!mHidden)
    {
      if (onContextItemSelected(paramMenuItem)) {
        return true;
      }
      return mChildFragmentManager.update(paramMenuItem);
    }
    return false;
  }
  
  void performCreate(Bundle paramBundle)
  {
    mChildFragmentManager.onStart();
    mState = 1;
    mCalled = false;
    if (Build.VERSION.SDK_INT >= 19) {
      mLifecycleRegistry.a(new Fragment.6(this));
    }
    mSavedStateRegistryController.a(paramBundle);
    onCreate(paramBundle);
    mIsCreated = true;
    if (mCalled)
    {
      mLifecycleRegistry.append(Lifecycle.Event.ON_CREATE);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onCreate()");
    throw new SuperNotCalledException(paramBundle.toString());
  }
  
  boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool = mHidden;
    int j = 0;
    if (!bool)
    {
      int i = j;
      if (mHasMenu)
      {
        i = j;
        if (mMenuVisible)
        {
          i = 1;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      return i | mChildFragmentManager.a(paramMenu, paramMenuInflater);
    }
    return false;
  }
  
  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mChildFragmentManager.onStart();
    mPerformedCreateView = true;
    mViewLifecycleOwner = new MethodWriter(this, getViewModelStore());
    paramLayoutInflater = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    mView = paramLayoutInflater;
    if (paramLayoutInflater != null)
    {
      mViewLifecycleOwner.a();
      ExtensionData.b(mView, mViewLifecycleOwner);
      HttpManager.init(mView, mViewLifecycleOwner);
      Feedback.set(mView, mViewLifecycleOwner);
      mViewLifecycleOwnerLiveData.setValue(mViewLifecycleOwner);
      return;
    }
    if (!mViewLifecycleOwner.f())
    {
      mViewLifecycleOwner = null;
      return;
    }
    throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
  }
  
  void performDestroy()
  {
    mChildFragmentManager.onCreateView();
    mLifecycleRegistry.append(Lifecycle.Event.ON_DESTROY);
    mState = 0;
    mCalled = false;
    mIsCreated = false;
    onDestroy();
    if (mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDestroy()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performDestroyView()
  {
    mChildFragmentManager.dispatchDestroyView();
    if ((mView != null) && (mViewLifecycleOwner.getLifecycle().c().a(Lifecycle.State.d))) {
      mViewLifecycleOwner.toString(Lifecycle.Event.ON_DESTROY);
    }
    mState = 1;
    mCalled = false;
    onDestroyView();
    if (mCalled)
    {
      LoaderManager.i(this).destroyLoader();
      mPerformedCreateView = false;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDestroyView()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performDetach()
  {
    mState = -1;
    mCalled = false;
    onDetach();
    mLayoutInflater = null;
    if (mCalled)
    {
      if (!mChildFragmentManager.isDestroyed())
      {
        mChildFragmentManager.onCreateView();
        mChildFragmentManager = new OrgNode();
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(this);
      localStringBuilder.append(" did not call through to super.onDetach()");
      throw new SuperNotCalledException(localStringBuilder.toString());
    }
  }
  
  LayoutInflater performGetLayoutInflater(Bundle paramBundle)
  {
    paramBundle = onGetLayoutInflater(paramBundle);
    mLayoutInflater = paramBundle;
    return paramBundle;
  }
  
  void performLowMemory()
  {
    onLowMemory();
    mChildFragmentManager.resolve();
  }
  
  void performMultiWindowModeChanged(boolean paramBoolean)
  {
    onMultiWindowModeChanged(paramBoolean);
    mChildFragmentManager.resolve(paramBoolean);
  }
  
  boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (!mHidden)
    {
      if ((mHasMenu) && (mMenuVisible) && (onOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      return mChildFragmentManager.invoke(paramMenuItem);
    }
    return false;
  }
  
  void performOptionsMenuClosed(Menu paramMenu)
  {
    if (!mHidden)
    {
      if ((mHasMenu) && (mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      mChildFragmentManager.invoke(paramMenu);
    }
  }
  
  void performPause()
  {
    mChildFragmentManager.dispatchPause();
    if (mView != null) {
      mViewLifecycleOwner.toString(Lifecycle.Event.ON_PAUSE);
    }
    mLifecycleRegistry.append(Lifecycle.Event.ON_PAUSE);
    mState = 6;
    mCalled = false;
    onPause();
    if (mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onPause()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    onPictureInPictureModeChanged(paramBoolean);
    mChildFragmentManager.invoke(paramBoolean);
  }
  
  boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = mHidden;
    int j = 0;
    if (!bool)
    {
      int i = j;
      if (mHasMenu)
      {
        i = j;
        if (mMenuVisible)
        {
          i = 1;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      return i | mChildFragmentManager.a(paramMenu);
    }
    return false;
  }
  
  void performPrimaryNavigationFragmentChanged()
  {
    boolean bool = mFragmentManager.a(this);
    Boolean localBoolean = mIsPrimaryNavigationFragment;
    if ((localBoolean == null) || (localBoolean.booleanValue() != bool))
    {
      mIsPrimaryNavigationFragment = Boolean.valueOf(bool);
      onPrimaryNavigationFragmentChanged(bool);
      mChildFragmentManager.destroyItem();
    }
  }
  
  void performResume()
  {
    mChildFragmentManager.onStart();
    mChildFragmentManager.add(true);
    mState = 7;
    mCalled = false;
    onResume();
    if (mCalled)
    {
      localObject = mLifecycleRegistry;
      Lifecycle.Event localEvent = Lifecycle.Event.ON_RESUME;
      ((androidx.lifecycle.f)localObject).append(localEvent);
      if (mView != null) {
        mViewLifecycleOwner.toString(localEvent);
      }
      mChildFragmentManager.init();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onResume()");
    throw new SuperNotCalledException(((StringBuilder)localObject).toString());
  }
  
  void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    mSavedStateRegistryController.b(paramBundle);
    Bundle localBundle = mChildFragmentManager.doInBackground();
    if (localBundle != null) {
      paramBundle.putParcelable("android:support:fragments", localBundle);
    }
  }
  
  void performStart()
  {
    mChildFragmentManager.onStart();
    mChildFragmentManager.add(true);
    mState = 5;
    mCalled = false;
    onStart();
    if (mCalled)
    {
      localObject = mLifecycleRegistry;
      Lifecycle.Event localEvent = Lifecycle.Event.ON_START;
      ((androidx.lifecycle.f)localObject).append(localEvent);
      if (mView != null) {
        mViewLifecycleOwner.toString(localEvent);
      }
      mChildFragmentManager.read();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onStart()");
    throw new SuperNotCalledException(((StringBuilder)localObject).toString());
  }
  
  void performStop()
  {
    mChildFragmentManager.write();
    if (mView != null) {
      mViewLifecycleOwner.toString(Lifecycle.Event.ON_STOP);
    }
    mLifecycleRegistry.append(Lifecycle.Event.ON_STOP);
    mState = 4;
    mCalled = false;
    onStop();
    if (mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onStop()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performViewCreated()
  {
    onViewCreated(mView, mSavedFragmentState);
    mChildFragmentManager.showProgressDialog();
  }
  
  public void postponeEnterTransition()
  {
    ensureAnimationInfosuccess = true;
  }
  
  public final void postponeEnterTransition(long paramLong, TimeUnit paramTimeUnit)
  {
    ensureAnimationInfosuccess = true;
    Object localObject = mFragmentManager;
    if (localObject != null) {
      localObject = ((FragmentManager)localObject).getContext().getHandler();
    } else {
      localObject = new Handler(Looper.getMainLooper());
    }
    ((Handler)localObject).removeCallbacks(mPostponedDurationRunnable);
    ((Handler)localObject).postDelayed(mPostponedDurationRunnable, paramTimeUnit.toMillis(paramLong));
  }
  
  public final androidx.activity.result.Label registerForActivityResult(androidx.activity.result.asm.ClassWriter paramClassWriter, ActivityResultRegistry paramActivityResultRegistry, AnnotationVisitor paramAnnotationVisitor)
  {
    return prepareCallInternal(paramClassWriter, new Fragment.h(this, paramActivityResultRegistry), paramAnnotationVisitor);
  }
  
  public final androidx.activity.result.Label registerForActivityResult(androidx.activity.result.asm.ClassWriter paramClassWriter, AnnotationVisitor paramAnnotationVisitor)
  {
    return prepareCallInternal(paramClassWriter, new Fragment.g(this), paramAnnotationVisitor);
  }
  
  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    if (mHost != null)
    {
      getParentFragmentManager().requestPermissions(this, paramArrayOfString, paramInt);
      return;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Fragment ");
    paramArrayOfString.append(this);
    paramArrayOfString.append(" not attached to Activity");
    throw new IllegalStateException(paramArrayOfString.toString());
  }
  
  public final FragmentActivity requireActivity()
  {
    Object localObject = getActivity();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to an activity.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final Bundle requireArguments()
  {
    Object localObject = getArguments();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have any arguments.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final Context requireContext()
  {
    Object localObject = getContext();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to a context.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final FragmentManager requireFragmentManager()
  {
    return getParentFragmentManager();
  }
  
  public final Object requireHost()
  {
    Object localObject = getHost();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to a host.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final Fragment requireParentFragment()
  {
    Object localObject = getParentFragment();
    if (localObject == null)
    {
      if (getContext() == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Fragment ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" is not attached to any Fragment or host");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" is not a child Fragment, it is directly attached to ");
      ((StringBuilder)localObject).append(getContext());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  public final View requireView()
  {
    Object localObject = getView();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not return a View from onCreateView() or this was called before onCreateView().");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  void restoreChildFragmentState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        mChildFragmentManager.run(paramBundle);
        mChildFragmentManager.restoreState();
      }
    }
  }
  
  final void restoreViewState(Bundle paramBundle)
  {
    SparseArray localSparseArray = mSavedViewState;
    if (localSparseArray != null)
    {
      mView.restoreHierarchyState(localSparseArray);
      mSavedViewState = null;
    }
    if (mView != null)
    {
      mViewLifecycleOwner.f(mSavedViewRegistryState);
      mSavedViewRegistryState = null;
    }
    mCalled = false;
    onViewStateRestored(paramBundle);
    if (mCalled)
    {
      if (mView != null) {
        mViewLifecycleOwner.toString(Lifecycle.Event.ON_CREATE);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Fragment ");
      paramBundle.append(this);
      paramBundle.append(" did not call through to super.onViewStateRestored()");
      throw new SuperNotCalledException(paramBundle.toString());
    }
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfomAllowEnterTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfomAllowReturnTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  void setAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((mAnimationInfo == null) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)) {
      return;
    }
    ensureAnimationInfomAnimations = paramInt1;
    ensureAnimationInfomLastAnimatedPosition = paramInt2;
    ensureAnimationInfoimages = paramInt3;
    ensureAnimationInfoanimations = paramInt4;
  }
  
  public void setArguments(Bundle paramBundle)
  {
    if ((mFragmentManager != null) && (isStateSaved())) {
      throw new IllegalStateException("Fragment already added and state has been saved");
    }
    mArguments = paramBundle;
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfomEnterTransitionCallback = paramSharedElementCallback;
  }
  
  public void setEnterTransition(Object paramObject)
  {
    ensureAnimationInfomEnterTransition = paramObject;
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfomExitTransitionCallback = paramSharedElementCallback;
  }
  
  public void setExitTransition(Object paramObject)
  {
    ensureAnimationInfomExitTransition = paramObject;
  }
  
  void setFocusedView(View paramView)
  {
    ensureAnimationInfomoveTo = paramView;
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (mHasMenu != paramBoolean)
    {
      mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  public void setInitialSavedState(SavedState paramSavedState)
  {
    if (mFragmentManager == null)
    {
      if (paramSavedState != null)
      {
        paramSavedState = mState;
        if (paramSavedState != null) {}
      }
      else
      {
        paramSavedState = null;
      }
      mSavedFragmentState = paramSavedState;
      return;
    }
    throw new IllegalStateException("Fragment already added");
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    if (mMenuVisible != paramBoolean)
    {
      mMenuVisible = paramBoolean;
      if ((mHasMenu) && (isAdded()) && (!isHidden())) {
        mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  void setNextTransition(int paramInt)
  {
    if ((mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfo();
    mAnimationInfo.postDetail = paramInt;
  }
  
  void setPopDirection(boolean paramBoolean)
  {
    if (mAnimationInfo == null) {
      return;
    }
    ensureAnimationInfofsync = paramBoolean;
  }
  
  void setPostOnViewCreatedAlpha(float paramFloat)
  {
    ensureAnimationInfopitch = paramFloat;
  }
  
  public void setReenterTransition(Object paramObject)
  {
    ensureAnimationInfomReenterTransition = paramObject;
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    FragmentStrictMode.e(this);
    mRetainInstance = paramBoolean;
    FragmentManager localFragmentManager = mFragmentManager;
    if (localFragmentManager != null)
    {
      if (paramBoolean)
      {
        localFragmentManager.addOnBackStackChangedListener(this);
        return;
      }
      localFragmentManager.attachController(this);
      return;
    }
    mRetainInstanceChangedWhileDetached = true;
  }
  
  public void setReturnTransition(Object paramObject)
  {
    ensureAnimationInfomReturnTransition = paramObject;
  }
  
  public void setSharedElementEnterTransition(Object paramObject)
  {
    ensureAnimationInfomSharedElementEnterTransition = paramObject;
  }
  
  void setSharedElementNames(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ensureAnimationInfo();
    j localJ = mAnimationInfo;
    o = paramArrayList1;
    j = paramArrayList2;
  }
  
  public void setSharedElementReturnTransition(Object paramObject)
  {
    ensureAnimationInfomSharedElementReturnTransition = paramObject;
  }
  
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    if (paramFragment != null) {
      FragmentStrictMode.a(this, paramFragment, paramInt);
    }
    FragmentManager localFragmentManager = mFragmentManager;
    if (paramFragment != null) {
      localObject = mFragmentManager;
    } else {
      localObject = null;
    }
    if ((localFragmentManager != null) && (localObject != null) && (localFragmentManager != localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(paramFragment);
      ((StringBuilder)localObject).append(" must share the same FragmentManager to be set as a target fragment");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = paramFragment;
    while (localObject != null) {
      if (!((Fragment)localObject).equals(this))
      {
        localObject = ((Fragment)localObject).getTargetFragment(false);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Setting ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" as the target of ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" would create a target cycle");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    if (paramFragment == null)
    {
      mTargetWho = null;
      mTarget = null;
    }
    else if ((mFragmentManager != null) && (mFragmentManager != null))
    {
      mTargetWho = mWho;
      mTarget = null;
    }
    else
    {
      mTargetWho = null;
      mTarget = paramFragment;
    }
    mTargetRequestCode = paramInt;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    FragmentStrictMode.a(this, paramBoolean);
    if ((!mUserVisibleHint) && (paramBoolean) && (mState < 5) && (mFragmentManager != null) && (isAdded()) && (mIsCreated))
    {
      FragmentManager localFragmentManager = mFragmentManager;
      localFragmentManager.remove(localFragmentManager.getInstance(this));
    }
    mUserVisibleHint = paramBoolean;
    boolean bool;
    if ((mState < 5) && (!paramBoolean)) {
      bool = true;
    } else {
      bool = false;
    }
    mDeferStart = bool;
    if (mSavedFragmentState != null) {
      mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null) {
      return localFragmentHostCallback.onShouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null)
    {
      localFragmentHostCallback.onStartActivityFromFragment(this, paramIntent, -1, paramBundle);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Fragment ");
    paramIntent.append(this);
    paramIntent.append(" not attached to Activity");
    throw new IllegalStateException(paramIntent.toString());
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (mHost != null)
    {
      getParentFragmentManager().startActivityForResult(this, paramIntent, paramInt, paramBundle);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Fragment ");
    paramIntent.append(this);
    paramIntent.append(" not attached to Activity");
    throw new IllegalStateException(paramIntent.toString());
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (mHost != null)
    {
      if (FragmentManager.get(2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Fragment ");
        localStringBuilder.append(this);
        localStringBuilder.append(" received the following in startIntentSenderForResult() requestCode: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" IntentSender: ");
        localStringBuilder.append(paramIntentSender);
        localStringBuilder.append(" fillInIntent: ");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" options: ");
        localStringBuilder.append(paramBundle);
        Log.v("FragmentManager", localStringBuilder.toString());
      }
      getParentFragmentManager().add(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramIntentSender = new StringBuilder();
    paramIntentSender.append("Fragment ");
    paramIntentSender.append(this);
    paramIntentSender.append(" not attached to Activity");
    throw new IllegalStateException(paramIntentSender.toString());
  }
  
  public void startPostponedEnterTransition()
  {
    if (mAnimationInfo != null)
    {
      if (!ensureAnimationInfosuccess) {
        return;
      }
      if (mHost == null)
      {
        ensureAnimationInfosuccess = false;
        return;
      }
      if (Looper.myLooper() != mHost.getHandler().getLooper())
      {
        mHost.getHandler().postAtFrontOfQueue(new Fragment.d(this));
        return;
      }
      callStartTransitionListener(true);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("}");
    localStringBuilder.append(" (");
    localStringBuilder.append(mWho);
    if (mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(mFragmentId));
    }
    if (mTag != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(mTag);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
  
  public class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<androidx.fragment.app.Fragment.SavedState> CREATOR = new a();
    
    SavedState() {}
    
    SavedState(ClassLoader paramClassLoader)
    {
      this$1 = readBundle();
      if ((paramClassLoader != null) && (Fragment.this != null)) {
        setClassLoader(paramClassLoader);
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(Fragment.this);
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<androidx.fragment.app.Fragment.SavedState>
    {
      a() {}
      
      public Fragment.SavedState[] a(int paramInt)
      {
        return new Fragment.SavedState[paramInt];
      }
      
      public Fragment.SavedState getInstance(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new Fragment.SavedState(paramParcel, paramClassLoader);
      }
      
      public Fragment.SavedState readDate(Parcel paramParcel)
      {
        return new Fragment.SavedState(paramParcel, null);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      startPostponedEnterTransition();
    }
  }
  
  class c
    extends Fragment.m
  {
    c()
    {
      super();
    }
    
    void b()
    {
      mSavedStateRegistryController.a();
      androidx.lifecycle.MethodWriter.b(Fragment.this);
    }
  }
  
  class j
  {
    int animations;
    View dialogView;
    boolean fsync;
    int images;
    ArrayList<String> j;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    int mAnimations;
    Object mEnterTransition = null;
    SharedElementCallback mEnterTransitionCallback;
    Object mExitTransition;
    SharedElementCallback mExitTransitionCallback;
    int mLastAnimatedPosition;
    Object mReenterTransition;
    Object mReturnTransition;
    Object mSharedElementEnterTransition;
    Object mSharedElementReturnTransition;
    View moveTo;
    ArrayList<String> o;
    float pitch;
    int postDetail;
    boolean success;
    
    j()
    {
      this$1 = Fragment.USE_DEFAULT_TRANSITION;
      mReturnTransition = this$1;
      mExitTransition = null;
      mReenterTransition = this$1;
      mSharedElementEnterTransition = null;
      mSharedElementReturnTransition = this$1;
      pitch = 1.0F;
      moveTo = null;
    }
  }
  
  class k
  {
    static void setContentView(View paramView)
    {
      paramView.cancelPendingInputEvents();
    }
  }
  
  public class l
    extends RuntimeException
  {
    public l(Exception paramException)
    {
      super(paramException);
    }
  }
  
  abstract class m
  {
    private m() {}
    
    abstract void b();
  }
}

package androidx.fragment.package_11;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.BaseBundle;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.package_11.strictmode.FragmentStrictMode;
import androidx.lifecycle.StatusPreference;
import androidx.lifecycle.h;
import java.util.Iterator;
import java.util.List;
import v7.v7.package_13.ViewCompat;

class Log
{
  private final f a;
  private final Fragment mView;
  private final System this$0;
  private boolean x = false;
  private int y = -1;
  
  Log(f paramF, System paramSystem, Fragment paramFragment)
  {
    a = paramF;
    this$0 = paramSystem;
    mView = paramFragment;
  }
  
  Log(f paramF, System paramSystem, Fragment paramFragment, FragmentState paramFragmentState)
  {
    a = paramF;
    this$0 = paramSystem;
    mView = paramFragment;
    mSavedViewState = null;
    mSavedViewRegistryState = null;
    mBackStackNesting = 0;
    mInLayout = false;
    mAdded = false;
    paramF = mTarget;
    if (paramF != null) {
      paramF = mWho;
    } else {
      paramF = null;
    }
    mTargetWho = paramF;
    mTarget = null;
    paramF = mSavedFragmentState;
    if (paramF != null)
    {
      mSavedFragmentState = paramF;
      return;
    }
    mSavedFragmentState = new Bundle();
  }
  
  Log(f paramF, System paramSystem, ClassLoader paramClassLoader, Loader paramLoader, FragmentState paramFragmentState)
  {
    a = paramF;
    this$0 = paramSystem;
    paramF = paramFragmentState.instantiate(paramLoader, paramClassLoader);
    mView = paramF;
    if (FragmentManager.get(2))
    {
      paramSystem = new StringBuilder();
      paramSystem.append("Instantiated fragment ");
      paramSystem.append(paramF);
      android.util.Log.v("FragmentManager", paramSystem.toString());
    }
  }
  
  private Bundle saveFragmentBasicState()
  {
    Object localObject2 = new Bundle();
    mView.performSaveInstanceState((Bundle)localObject2);
    a.b(mView, (Bundle)localObject2, false);
    Object localObject1 = localObject2;
    if (((BaseBundle)localObject2).isEmpty()) {
      localObject1 = null;
    }
    if (mView.mView != null) {
      onSaveInstanceState();
    }
    localObject2 = localObject1;
    if (mView.mSavedViewState != null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putSparseParcelableArray("android:view_state", mView.mSavedViewState);
    }
    localObject1 = localObject2;
    if (mView.mSavedViewRegistryState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putBundle("android:view_registry_state", mView.mSavedViewRegistryState);
    }
    localObject2 = localObject1;
    if (!mView.mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((BaseBundle)localObject2).putBoolean("android:user_visible_hint", mView.mUserVisibleHint);
    }
    return localObject2;
  }
  
  private boolean startNestedScroll(View paramView)
  {
    if (paramView == mView.mView) {
      return true;
    }
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if (paramView == mView.mView) {
        return true;
      }
    }
    return false;
  }
  
  int a()
  {
    Object localObject = mView;
    if (mFragmentManager == null) {
      return mState;
    }
    int i = y;
    int k = YPositionMetric.a.a[mMaxState.ordinal()];
    int j = i;
    if (k != 1) {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            j = Math.min(i, -1);
          } else {
            j = Math.min(i, 0);
          }
        }
        else {
          j = Math.min(i, 1);
        }
      }
      else {
        j = Math.min(i, 5);
      }
    }
    localObject = mView;
    i = j;
    if (mFromLayout) {
      if (mInLayout)
      {
        k = Math.max(y, 2);
        j = k;
        localObject = mView.mView;
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((View)localObject).getParent() == null) {
            i = Math.min(k, 2);
          }
        }
      }
      else if (y < 4)
      {
        i = Math.min(j, mState);
      }
      else
      {
        i = Math.min(j, 1);
      }
    }
    j = i;
    if (!mView.mAdded) {
      j = Math.min(i, 1);
    }
    localObject = null;
    Fragment localFragment = mView;
    ViewGroup localViewGroup = mContainer;
    if (localViewGroup != null) {
      localObject = SpecialEffectsController.a(localViewGroup, localFragment.getParentFragmentManager()).a(this);
    }
    if (localObject == SpecialEffectsController.Operation.LifecycleImpact.b)
    {
      i = Math.min(j, 6);
    }
    else if (localObject == SpecialEffectsController.Operation.LifecycleImpact.d)
    {
      i = Math.max(j, 3);
    }
    else
    {
      localObject = mView;
      i = j;
      if (mRemoving) {
        if (((Fragment)localObject).isInBackStack()) {
          i = Math.min(j, 1);
        } else {
          i = Math.min(j, -1);
        }
      }
    }
    localObject = mView;
    j = i;
    if (mDeferStart)
    {
      j = i;
      if (mState < 5) {
        j = Math.min(i, 4);
      }
    }
    if (FragmentManager.get(2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("computeExpectedState() of ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" for ");
      ((StringBuilder)localObject).append(mView);
      android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
    }
    return j;
  }
  
  void add()
  {
    if (FragmentManager.get(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("movefrom ATTACHED: ");
      ((StringBuilder)localObject).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    mView.performDetach();
    Object localObject = a;
    Fragment localFragment = mView;
    int j = 0;
    ((f)localObject).f(localFragment, false);
    localObject = mView;
    mState = -1;
    mHost = null;
    mParentFragment = null;
    mFragmentManager = null;
    int i = j;
    if (mRemoving)
    {
      i = j;
      if (!((Fragment)localObject).isInBackStack()) {
        i = 1;
      }
    }
    if ((i != 0) || (this$0.getValue().remove(mView)))
    {
      if (FragmentManager.get(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initState called for fragment: ");
        ((StringBuilder)localObject).append(mView);
        android.util.Log.d("FragmentManager", ((StringBuilder)localObject).toString());
      }
      mView.initState();
    }
  }
  
  void clear()
  {
    if (FragmentManager.get(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto ACTIVITY_CREATED: ");
      ((StringBuilder)localObject).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = mView;
    ((Fragment)localObject).performActivityCreated(mSavedFragmentState);
    localObject = a;
    Fragment localFragment = mView;
    ((f)localObject).d(localFragment, mSavedFragmentState, false);
  }
  
  void close()
  {
    if (FragmentManager.get(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto CREATED: ");
      ((StringBuilder)localObject).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = mView;
    if (!mIsCreated)
    {
      a.a((Fragment)localObject, mSavedFragmentState, false);
      localObject = mView;
      ((Fragment)localObject).performCreate(mSavedFragmentState);
      localObject = a;
      Fragment localFragment = mView;
      ((f)localObject).c(localFragment, mSavedFragmentState, false);
      return;
    }
    ((Fragment)localObject).restoreChildFragmentState(mSavedFragmentState);
    mView.mState = 1;
  }
  
  void d()
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveto STARTED: ");
      localStringBuilder.append(mView);
      android.util.Log.d("FragmentManager", localStringBuilder.toString());
    }
    mView.performStart();
    a.c(mView, false);
  }
  
  void dump()
  {
    if (FragmentManager.get(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("movefrom CREATED: ");
      ((StringBuilder)localObject1).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = mView;
    boolean bool2 = mRemoving;
    boolean bool1 = true;
    int i;
    if ((bool2) && (!((Fragment)localObject1).isInBackStack())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = mView;
      if (!mBeingSaved) {
        this$0.get(mWho, null);
      }
    }
    int j;
    if ((i == 0) && (!this$0.getValue().remove(mView))) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0)
    {
      localObject1 = mView.mHost;
      if ((localObject1 instanceof h)) {
        bool1 = this$0.getValue().equals();
      } else if ((((FragmentHostCallback)localObject1).getContext() instanceof Activity)) {
        bool1 = true ^ ((Activity)((FragmentHostCallback)localObject1).getContext()).isChangingConfigurations();
      }
      if (((i != 0) && (!mView.mBeingSaved)) || (bool1)) {
        this$0.getValue().dump(mView);
      }
      mView.performDestroy();
      a.write(mView, false);
      localObject1 = this$0.size().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Log)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((Log)localObject2).getValue();
          if (mView.mWho.equals(mTargetWho))
          {
            mTarget = mView;
            mTargetWho = null;
          }
        }
      }
      localObject1 = mView;
      Object localObject2 = mTargetWho;
      if (localObject2 != null) {
        mTarget = this$0.get((String)localObject2);
      }
      this$0.get(this);
      return;
    }
    localObject1 = mView.mTargetWho;
    if (localObject1 != null)
    {
      localObject1 = this$0.get((String)localObject1);
      if ((localObject1 != null) && (mRetainInstance)) {
        mView.mTarget = ((Fragment)localObject1);
      }
    }
    mView.mState = 0;
  }
  
  void e()
  {
    int i = this$0.get(mView);
    Fragment localFragment = mView;
    mContainer.addView(mView, i);
  }
  
  void f()
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movefrom RESUMED: ");
      localStringBuilder.append(mView);
      android.util.Log.d("FragmentManager", localStringBuilder.toString());
    }
    mView.performPause();
    a.b(mView, false);
  }
  
  Fragment getValue()
  {
    return mView;
  }
  
  void init()
  {
    if (FragmentManager.get(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("moveto ATTACHED: ");
      ((StringBuilder)localObject1).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = mView;
    Fragment localFragment = mTarget;
    Object localObject1 = null;
    if (localFragment != null)
    {
      localObject1 = this$0.getInstance(mWho);
      if (localObject1 != null)
      {
        localObject2 = mView;
        mTargetWho = mTarget.mWho;
        mTarget = null;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Fragment ");
        ((StringBuilder)localObject1).append(mView);
        ((StringBuilder)localObject1).append(" declared target fragment ");
        ((StringBuilder)localObject1).append(mView.mTarget);
        ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      localObject2 = mTargetWho;
      if (localObject2 != null)
      {
        localObject2 = this$0.getInstance((String)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Fragment ");
          ((StringBuilder)localObject1).append(mView);
          ((StringBuilder)localObject1).append(" declared target fragment ");
          ((StringBuilder)localObject1).append(mView.mTargetWho);
          ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
    }
    if (localObject1 != null) {
      ((Log)localObject1).run();
    }
    localObject1 = mView;
    mHost = mFragmentManager.getContext();
    localObject1 = mView;
    mParentFragment = mFragmentManager.iterator();
    a.a(mView, false);
    mView.performAttach();
    a.run(mView, false);
  }
  
  Fragment.SavedState initialize()
  {
    if (mView.mState > -1)
    {
      Bundle localBundle = saveFragmentBasicState();
      if (localBundle != null) {
        return new Fragment.SavedState(localBundle);
      }
    }
    return null;
  }
  
  void moveToState()
  {
    Object localObject = mView;
    if ((mFromLayout) && (mInLayout) && (!mPerformedCreateView))
    {
      if (FragmentManager.get(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("moveto CREATE_VIEW: ");
        ((StringBuilder)localObject).append(mView);
        android.util.Log.d("FragmentManager", ((StringBuilder)localObject).toString());
      }
      localObject = mView;
      ((Fragment)localObject).performCreateView(((Fragment)localObject).performGetLayoutInflater(mSavedFragmentState), null, mView.mSavedFragmentState);
      localObject = mView.mView;
      if (localObject != null)
      {
        ((View)localObject).setSaveFromParentEnabled(false);
        localObject = mView;
        mView.setTag(v7.app.Fragment.DEBUG, localObject);
        localObject = mView;
        if (mHidden) {
          mView.setVisibility(8);
        }
        mView.performViewCreated();
        localObject = a;
        Fragment localFragment = mView;
        ((f)localObject).a(localFragment, mView, mSavedFragmentState, false);
        mView.mState = 2;
      }
    }
  }
  
  void moveToState(ClassLoader paramClassLoader)
  {
    Object localObject = mView.mSavedFragmentState;
    if (localObject == null) {
      return;
    }
    ((Bundle)localObject).setClassLoader(paramClassLoader);
    paramClassLoader = mView;
    mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
    paramClassLoader = mView;
    mSavedViewRegistryState = mSavedFragmentState.getBundle("android:view_registry_state");
    paramClassLoader = mView;
    mTargetWho = mSavedFragmentState.getString("android:target_state");
    paramClassLoader = mView;
    if (mTargetWho != null) {
      mTargetRequestCode = mSavedFragmentState.getInt("android:target_req_state", 0);
    }
    paramClassLoader = mView;
    localObject = mSavedUserVisibleHint;
    if (localObject != null)
    {
      mUserVisibleHint = ((Boolean)localObject).booleanValue();
      mView.mSavedUserVisibleHint = null;
    }
    else
    {
      mUserVisibleHint = mSavedFragmentState.getBoolean("android:user_visible_hint", true);
    }
    paramClassLoader = mView;
    if (!mUserVisibleHint) {
      mDeferStart = true;
    }
  }
  
  void onCreate()
  {
    if (FragmentManager.get(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("movefrom CREATE_VIEW: ");
      ((StringBuilder)localObject1).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = mView;
    Object localObject1 = mContainer;
    if (localObject1 != null)
    {
      localObject2 = mView;
      if (localObject2 != null) {
        ((ViewGroup)localObject1).removeView((View)localObject2);
      }
    }
    mView.performDestroyView();
    a.draw(mView, false);
    localObject1 = mView;
    mContainer = null;
    mView = null;
    mViewLifecycleOwner = null;
    mViewLifecycleOwnerLiveData.setValue(null);
    mView.mInLayout = false;
  }
  
  void onCreateView()
  {
    if (mView.mFromLayout) {
      return;
    }
    if (FragmentManager.get(3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("moveto CREATE_VIEW: ");
      ((StringBuilder)localObject1).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = mView;
    LayoutInflater localLayoutInflater = ((Fragment)localObject1).performGetLayoutInflater(mSavedFragmentState);
    localObject1 = null;
    Fragment localFragment = mView;
    Object localObject2 = mContainer;
    int i;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
    }
    else
    {
      i = mContainerId;
      if (i != 0) {
        if (i != -1)
        {
          localObject2 = (ViewGroup)mFragmentManager.build().findViewById(mView.mContainerId);
          if (localObject2 == null)
          {
            localObject1 = mView;
            if (mRestored)
            {
              localObject1 = localObject2;
              break label334;
            }
          }
        }
      }
    }
    try
    {
      localObject1 = ((Fragment)localObject1).getResources();
      i = mView.mContainerId;
      localObject1 = ((Resources)localObject1).getResourceName(i);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      float f;
      for (;;) {}
    }
    localObject1 = "unknown";
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("No view found for id 0x");
    ((StringBuilder)localObject2).append(Integer.toHexString(mView.mContainerId));
    ((StringBuilder)localObject2).append(" (");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(") for fragment ");
    ((StringBuilder)localObject2).append(mView);
    throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (!(localObject2 instanceof FragmentContainerView))
    {
      FragmentStrictMode.add(mView, (ViewGroup)localObject2);
      localObject1 = localObject2;
      break label334;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Cannot create fragment ");
      ((StringBuilder)localObject1).append(mView);
      ((StringBuilder)localObject1).append(" for a container view with no id");
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    label334:
    localObject2 = mView;
    mContainer = ((ViewGroup)localObject1);
    ((Fragment)localObject2).performCreateView(localLayoutInflater, (ViewGroup)localObject1, mSavedFragmentState);
    localObject2 = mView.mView;
    if (localObject2 != null)
    {
      ((View)localObject2).setSaveFromParentEnabled(false);
      localObject2 = mView;
      mView.setTag(v7.app.Fragment.DEBUG, localObject2);
      if (localObject1 != null) {
        e();
      }
      localObject1 = mView;
      if (mHidden) {
        mView.setVisibility(8);
      }
      if (ViewCompat.d(mView.mView))
      {
        ViewCompat.requestApplyInsets(mView.mView);
      }
      else
      {
        localObject1 = mView.mView;
        ((View)localObject1).addOnAttachStateChangeListener(new __View_OnAttachStateChangeListener(this, (View)localObject1));
      }
      mView.performViewCreated();
      localObject1 = a;
      localObject2 = mView;
      ((f)localObject1).a((Fragment)localObject2, mView, mSavedFragmentState, false);
      i = mView.mView.getVisibility();
      f = mView.mView.getAlpha();
      mView.setPostOnViewCreatedAlpha(f);
      localObject1 = mView;
      if ((mContainer != null) && (i == 0))
      {
        localObject1 = mView.findFocus();
        if (localObject1 != null)
        {
          mView.setFocusedView((View)localObject1);
          if (FragmentManager.get(2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("requestFocus: Saved focused view ");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append(" for Fragment ");
            ((StringBuilder)localObject2).append(mView);
            android.util.Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
          }
        }
        mView.mView.setAlpha(0.0F);
      }
    }
    mView.mState = 2;
  }
  
  void onPostExecute()
  {
    if (FragmentManager.get(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("moveto RESUMED: ");
      ((StringBuilder)localObject).append(mView);
      android.util.Log.d("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = mView.getFocusedView();
    if ((localObject != null) && (startNestedScroll((View)localObject)))
    {
      boolean bool = ((View)localObject).requestFocus();
      if (FragmentManager.get(2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestFocus: Restoring focused view ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" ");
        if (bool) {
          localObject = "succeeded";
        } else {
          localObject = "failed";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" on Fragment ");
        localStringBuilder.append(mView);
        localStringBuilder.append(" resulting in focused view ");
        localStringBuilder.append(mView.mView.findFocus());
        android.util.Log.v("FragmentManager", localStringBuilder.toString());
      }
    }
    mView.setFocusedView(null);
    mView.performResume();
    a.add(mView, false);
    localObject = mView;
    mSavedFragmentState = null;
    mSavedViewState = null;
    mSavedViewRegistryState = null;
  }
  
  void onSaveInstanceState()
  {
    if (mView.mView == null) {
      return;
    }
    if (FragmentManager.get(2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Saving view state for fragment ");
      ((StringBuilder)localObject).append(mView);
      ((StringBuilder)localObject).append(" with view ");
      ((StringBuilder)localObject).append(mView.mView);
      android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = new SparseArray();
    mView.mView.saveHierarchyState((SparseArray)localObject);
    if (((SparseArray)localObject).size() > 0) {
      mView.mSavedViewState = ((SparseArray)localObject);
    }
    localObject = new Bundle();
    mView.mViewLifecycleOwner.a((Bundle)localObject);
    if (!((BaseBundle)localObject).isEmpty()) {
      mView.mSavedViewRegistryState = ((Bundle)localObject);
    }
  }
  
  void print()
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movefrom STARTED: ");
      localStringBuilder.append(mView);
      android.util.Log.d("FragmentManager", localStringBuilder.toString());
    }
    mView.performStop();
    a.d(mView, false);
  }
  
  void run()
  {
    Object localObject1;
    if (x)
    {
      if (FragmentManager.get(2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Ignoring re-entrant call to moveToExpectedState() for ");
        ((StringBuilder)localObject1).append(getValue());
        android.util.Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
      }
    }
    else {
      try
      {
        x = true;
        int k;
        Object localObject2;
        for (int i = 0;; i = 1)
        {
          int j = a();
          localObject1 = mView;
          k = mState;
          if (j == k) {
            break;
          }
          if (j > k) {
            switch (k + 1)
            {
            default: 
              break;
            case 7: 
              onPostExecute();
              break;
            case 6: 
              mState = 6;
              break;
            case 5: 
              d();
              break;
            case 4: 
              localObject2 = mView;
              if (localObject2 != null)
              {
                localObject2 = mContainer;
                if (localObject2 != null) {
                  SpecialEffectsController.a((ViewGroup)localObject2, ((Fragment)localObject1).getParentFragmentManager()).a(SpecialEffectsController.Operation.State.b(mView.mView.getVisibility()), this);
                }
              }
              mView.mState = 4;
              break;
            case 3: 
              clear();
              break;
            case 2: 
              moveToState();
              onCreateView();
              break;
            case 1: 
              close();
              break;
            case 0: 
              init();
              break;
            }
          } else {
            switch (k - 1)
            {
            default: 
              break;
            case 6: 
              f();
              break;
            case 5: 
              mState = 5;
              break;
            case 4: 
              print();
              break;
            case 3: 
              bool = FragmentManager.get(3);
              if (bool)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("movefrom ACTIVITY_CREATED: ");
                ((StringBuilder)localObject1).append(mView);
                android.util.Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
              }
              localObject1 = mView;
              bool = mBeingSaved;
              if (bool)
              {
                saveAllState();
              }
              else
              {
                localObject2 = mView;
                if (localObject2 != null)
                {
                  localObject1 = mSavedViewState;
                  if (localObject1 == null) {
                    onSaveInstanceState();
                  }
                }
              }
              localObject1 = mView;
              localObject2 = mView;
              if (localObject2 != null)
              {
                localObject2 = mContainer;
                if (localObject2 != null) {
                  SpecialEffectsController.a((ViewGroup)localObject2, ((Fragment)localObject1).getParentFragmentManager()).c(this);
                }
              }
              mView.mState = 3;
              break;
            case 2: 
              mInLayout = false;
              mState = 2;
              break;
            case 1: 
              onCreate();
              mView.mState = 1;
              break;
            case 0: 
              bool = mBeingSaved;
              if (bool)
              {
                localObject1 = this$0.put(mWho);
                if (localObject1 == null) {
                  saveAllState();
                }
              }
              dump();
              break;
            case -1: 
              add();
            }
          }
        }
        if ((i == 0) && (k == -1))
        {
          bool = mRemoving;
          if (bool)
          {
            bool = ((Fragment)localObject1).isInBackStack();
            if (!bool)
            {
              bool = mView.mBeingSaved;
              if (!bool)
              {
                bool = FragmentManager.get(3);
                if (bool)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("Cleaning up state of never attached fragment: ");
                  ((StringBuilder)localObject1).append(mView);
                  android.util.Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
                }
                this$0.getValue().dump(mView);
                this$0.get(this);
                bool = FragmentManager.get(3);
                if (bool)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("initState called for fragment: ");
                  ((StringBuilder)localObject1).append(mView);
                  android.util.Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
                }
                mView.initState();
              }
            }
          }
        }
        localObject1 = mView;
        boolean bool = mHiddenChanged;
        if (bool)
        {
          localObject2 = mView;
          if (localObject2 != null)
          {
            localObject2 = mContainer;
            if (localObject2 != null)
            {
              localObject1 = SpecialEffectsController.a((ViewGroup)localObject2, ((Fragment)localObject1).getParentFragmentManager());
              bool = mView.mHidden;
              if (bool) {
                ((SpecialEffectsController)localObject1).b(this);
              } else {
                ((SpecialEffectsController)localObject1).d(this);
              }
            }
          }
          localObject1 = mView;
          localObject2 = mFragmentManager;
          if (localObject2 != null) {
            ((FragmentManager)localObject2).show((Fragment)localObject1);
          }
          localObject1 = mView;
          mHiddenChanged = false;
          ((Fragment)localObject1).onHiddenChanged(mHidden);
          mView.mChildFragmentManager.dump();
        }
        x = false;
        return;
      }
      catch (Throwable localThrowable)
      {
        x = false;
        throw localThrowable;
      }
    }
  }
  
  void saveAllState()
  {
    FragmentState localFragmentState = new FragmentState(mView);
    Object localObject = mView;
    if ((mState > -1) && (mSavedFragmentState == null))
    {
      localObject = saveFragmentBasicState();
      mSavedFragmentState = ((Bundle)localObject);
      if (mView.mTargetWho != null)
      {
        if (localObject == null) {
          mSavedFragmentState = new Bundle();
        }
        mSavedFragmentState.putString("android:target_state", mView.mTargetWho);
        int i = mView.mTargetRequestCode;
        if (i != 0) {
          mSavedFragmentState.putInt("android:target_req_state", i);
        }
      }
    }
    else
    {
      mSavedFragmentState = mSavedFragmentState;
    }
    this$0.get(mView.mWho, localFragmentState);
  }
  
  void setText(int paramInt)
  {
    y = paramInt;
  }
}

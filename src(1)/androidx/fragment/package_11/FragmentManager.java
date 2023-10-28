package androidx.fragment.package_11;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.PullToRefreshAttacher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.Alarm;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.IntentSenderRequest.b;
import androidx.activity.result.asm.g;
import androidx.activity.result.b;
import androidx.core.app.s;
import androidx.core.content.History;
import androidx.core.package_10.ChatMessage;
import androidx.fragment.app.j;
import androidx.fragment.app.r;
import androidx.fragment.app.w;
import androidx.fragment.package_11.strictmode.FragmentStrictMode;
import androidx.fragment.package_11.strictmode.FragmentStrictMode.b;
import androidx.lifecycle.Lifecycle.State;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager
{
  private static boolean permanent;
  private final CopyOnWriteArrayList<w> B = new CopyOnWriteArrayList();
  ArrayDeque<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo> SDK_INT = new ArrayDeque();
  private final Map<String, ?> _connectingChannels = Collections.synchronizedMap(new HashMap());
  private Label a;
  private b<String[]> b;
  private b<IntentSenderRequest> c;
  private final Map<String, Bundle> cache = Collections.synchronizedMap(new HashMap());
  private boolean canRemoveOrSet;
  private final Map<String, androidx.fragment.app.BackStackState> context = Collections.synchronizedMap(new HashMap());
  private final f d = new f(this);
  private ArrayList<androidx.fragment.app.Fragment> data;
  private ArrayList<androidx.fragment.app.Fragment> h;
  private FragmentStrictMode.b j;
  private b<Intent> k;
  Fragment left;
  private final AtomicInteger mActivity = new AtomicInteger();
  private final PullToRefreshAttacher mAdapter = new b(false);
  private AppCompatDelegate mContainer;
  private Fragment mContext;
  ArrayList<j> mData;
  private boolean mDestroyed;
  private Runnable mExecCommit = new f();
  private final v7.v7.package_13.h mHandler = new c();
  private r<?> mHost;
  private OnBackPressedDispatcher mListener;
  private boolean mNeedMenuInvalidate;
  private final c.h.p.a<s> mParent = new x(this);
  private final c.h.p.a<Integer> mPassword = new Attribute(this);
  private final ArrayList<androidx.fragment.app.FragmentManager.m> mPendingActions = new ArrayList();
  private final c.h.p.a<androidx.core.app.h> mUser = new ac(this);
  private final c.h.p.a<Configuration> mUsername = new ByteVector(this);
  private ArrayList<androidx.fragment.app.FragmentManager.l> mYVals;
  private final FragmentManagerImpl mmDevice = new FragmentManagerImpl(this);
  private Name name = null;
  private boolean p;
  private Name packageName = new e();
  private Loader position = null;
  private ArrayList<Boolean> r;
  private boolean s;
  private final System this$0 = new System();
  int type = -1;
  private ArrayList<j> v;
  private Loader view = new d();
  private boolean x;
  
  public FragmentManager() {}
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (paramArrayList1.isEmpty()) {
      return;
    }
    if (paramArrayList1.size() == paramArrayList2.size())
    {
      int i2 = paramArrayList1.size();
      int i = 0;
      int m;
      for (int n = 0; i < i2; n = m)
      {
        int i1 = i;
        m = n;
        if (!geth)
        {
          if (n != i) {
            run(paramArrayList1, paramArrayList2, n, i);
          }
          n = i + 1;
          m = n;
          if (((Boolean)paramArrayList2.get(i)).booleanValue()) {
            for (;;)
            {
              m = n;
              if (n >= i2) {
                break;
              }
              m = n;
              if (!((Boolean)paramArrayList2.get(n)).booleanValue()) {
                break;
              }
              m = n;
              if (geth) {
                break;
              }
              n += 1;
            }
          }
          run(paramArrayList1, paramArrayList2, i, m);
          i1 = m - 1;
        }
        i = i1 + 1;
      }
      if (n != i2) {
        run(paramArrayList1, paramArrayList2, n, i2);
      }
    }
    else
    {
      throw new IllegalStateException("Internal error with the back stack records");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!p)
    {
      if (mHost == null)
      {
        if (mDestroyed) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      if (Looper.myLooper() == mHost.getHandler().getLooper())
      {
        if (!paramBoolean) {
          close();
        }
        if (v == null)
        {
          v = new ArrayList();
          r = new ArrayList();
        }
      }
      else
      {
        throw new IllegalStateException("Must be called from main thread of fragment host");
      }
    }
    else
    {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2)
  {
    add(false);
    a(true);
    Fragment localFragment = left;
    if ((localFragment != null) && (paramInt1 < 0) && (paramString == null) && (localFragment.getChildFragmentManager().d())) {
      return true;
    }
    boolean bool = add(v, r, paramString, paramInt1, paramInt2);
    if (bool)
    {
      p = true;
      try
      {
        a(v, r);
        next();
      }
      catch (Throwable paramString)
      {
        next();
        throw paramString;
      }
    }
    clear();
    remove();
    this$0.write();
    return bool;
  }
  
  private int add(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = mData;
    int i;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return -1;
      }
      if ((paramString == null) && (paramInt < 0))
      {
        if (paramBoolean) {
          return 0;
        }
        return mData.size() - 1;
      }
      i = mData.size() - 1;
      while (i >= 0)
      {
        localObject = (BackStackRecord)mData.get(i);
        if (((paramString != null) && (paramString.equals(((BackStackRecord)localObject).getComponent()))) || ((paramInt >= 0) && (paramInt == mIndex))) {
          break;
        }
        i -= 1;
      }
      if (i < 0) {
        return i;
      }
      if (paramBoolean) {
        while (i > 0)
        {
          localObject = (BackStackRecord)mData.get(i - 1);
          if (((paramString == null) || (!paramString.equals(((BackStackRecord)localObject).getComponent()))) && ((paramInt < 0) || (paramInt != mIndex))) {
            break;
          }
          i -= 1;
        }
      }
      if (i == mData.size() - 1) {
        return -1;
      }
      return i + 1;
    }
    return -1;
    return i;
  }
  
  static Fragment add(View paramView)
  {
    paramView = paramView.getTag(v7.app.Fragment.DEBUG);
    if ((paramView instanceof Fragment)) {
      return (Fragment)paramView;
    }
    return null;
  }
  
  private void add(int paramInt)
  {
    try
    {
      p = true;
      this$0.reset(paramInt);
      a(paramInt, false);
      Iterator localIterator = get().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        ((SpecialEffectsController)localIterator.next()).add();
      }
      p = false;
      add(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      p = false;
      throw localThrowable;
    }
  }
  
  private boolean add(Fragment paramFragment)
  {
    return ((mHasMenu) && (mMenuVisible)) || (mChildFragmentManager.add());
  }
  
  private Label b(Fragment paramFragment)
  {
    return a.a(paramFragment);
  }
  
  private static Fragment call(View paramView)
  {
    while (paramView != null)
    {
      Fragment localFragment = add(paramView);
      if (localFragment != null) {
        return localFragment;
      }
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        paramView = (View)paramView;
      } else {
        paramView = null;
      }
    }
    return null;
  }
  
  private void call()
  {
    Iterator localIterator = get().iterator();
    while (localIterator.hasNext()) {
      ((SpecialEffectsController)localIterator.next()).add();
    }
  }
  
  private void clear()
  {
    Object localObject = mPendingActions;
    try
    {
      boolean bool2 = mPendingActions.isEmpty();
      boolean bool1 = true;
      if (!bool2)
      {
        mAdapter.setEnabled(true);
        return;
      }
      localObject = mAdapter;
      if ((getBackStackEntryCount() <= 0) || (!a(mContext))) {
        bool1 = false;
      }
      ((PullToRefreshAttacher)localObject).setEnabled(bool1);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void close()
  {
    if (!b()) {
      return;
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  /* Error */
  private boolean commit(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	androidx/fragment/package_11/FragmentManager:mPendingActions	Ljava/util/ArrayList;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 125	androidx/fragment/package_11/FragmentManager:mPendingActions	Ljava/util/ArrayList;
    //   13: invokevirtual 220	java/util/ArrayList:isEmpty	()Z
    //   16: istore 5
    //   18: iconst_0
    //   19: istore_3
    //   20: iload 5
    //   22: ifeq +8 -> 30
    //   25: aload 7
    //   27: monitorexit
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 125	androidx/fragment/package_11/FragmentManager:mPendingActions	Ljava/util/ArrayList;
    //   34: invokevirtual 224	java/util/ArrayList:size	()I
    //   37: istore 4
    //   39: iconst_0
    //   40: istore 5
    //   42: iload_3
    //   43: iload 4
    //   45: if_icmpge +37 -> 82
    //   48: aload_0
    //   49: getfield 125	androidx/fragment/package_11/FragmentManager:mPendingActions	Ljava/util/ArrayList;
    //   52: iload_3
    //   53: invokevirtual 228	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   56: checkcast 26	androidx/fragment/package_11/FragmentManager$m
    //   59: aload_1
    //   60: aload_2
    //   61: invokeinterface 454 3 0
    //   66: istore 6
    //   68: iload 5
    //   70: iload 6
    //   72: ior
    //   73: istore 5
    //   75: iload_3
    //   76: iconst_1
    //   77: iadd
    //   78: istore_3
    //   79: goto -37 -> 42
    //   82: aload_0
    //   83: getfield 125	androidx/fragment/package_11/FragmentManager:mPendingActions	Ljava/util/ArrayList;
    //   86: invokevirtual 455	java/util/ArrayList:clear	()V
    //   89: aload_0
    //   90: getfield 255	androidx/fragment/package_11/FragmentManager:mHost	Landroidx/fragment/package_11/FragmentHostCallback;
    //   93: invokevirtual 273	androidx/fragment/package_11/FragmentHostCallback:getHandler	()Landroid/os/Handler;
    //   96: aload_0
    //   97: getfield 215	androidx/fragment/package_11/FragmentManager:mExecCommit	Ljava/lang/Runnable;
    //   100: invokevirtual 459	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   103: aload 7
    //   105: monitorexit
    //   106: iload 5
    //   108: ireturn
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 125	androidx/fragment/package_11/FragmentManager:mPendingActions	Ljava/util/ArrayList;
    //   114: invokevirtual 455	java/util/ArrayList:clear	()V
    //   117: aload_0
    //   118: getfield 255	androidx/fragment/package_11/FragmentManager:mHost	Landroidx/fragment/package_11/FragmentHostCallback;
    //   121: invokevirtual 273	androidx/fragment/package_11/FragmentHostCallback:getHandler	()Landroid/os/Handler;
    //   124: aload_0
    //   125: getfield 215	androidx/fragment/package_11/FragmentManager:mExecCommit	Ljava/lang/Runnable;
    //   128: invokevirtual 459	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: aload 7
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	FragmentManager
    //   0	139	1	paramArrayList1	ArrayList
    //   0	139	2	paramArrayList2	ArrayList
    //   19	60	3	i	int
    //   37	9	4	m	int
    //   16	91	5	bool1	boolean
    //   66	7	6	bool2	boolean
    //   4	131	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   30	39	109	java/lang/Throwable
    //   48	68	109	java/lang/Throwable
    //   9	18	133	java/lang/Throwable
    //   25	28	133	java/lang/Throwable
    //   82	106	133	java/lang/Throwable
    //   110	133	133	java/lang/Throwable
    //   134	137	133	java/lang/Throwable
  }
  
  private void copy()
  {
    if (mYVals != null)
    {
      int i = 0;
      while (i < mYVals.size())
      {
        ((l)mYVals.get(i)).checkCancelled();
        i += 1;
      }
    }
  }
  
  private Set dump(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    HashSet localHashSet = new HashSet();
    while (paramInt1 < paramInt2)
    {
      Iterator localIterator = getm.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = nextfragment;
        if (localObject != null)
        {
          localObject = mContainer;
          if (localObject != null) {
            localHashSet.add(SpecialEffectsController.a((ViewGroup)localObject, this));
          }
        }
      }
      paramInt1 += 1;
    }
    return localHashSet;
  }
  
  private void execute()
  {
    Object localObject = mHost;
    FragmentManager localFragmentManager = this;
    boolean bool2 = localObject instanceof androidx.lifecycle.h;
    boolean bool1 = true;
    if (bool2) {
      bool1 = this$0.getValue().equals();
    } else if ((((FragmentHostCallback)localObject).getContext() instanceof Activity)) {
      bool1 = true ^ ((Activity)mHost.getContext()).isChangingConfigurations();
    }
    localFragmentManager = this;
    if (bool1)
    {
      localObject = context.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = nexttags.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this$0.getValue().add(str);
        }
      }
    }
  }
  
  static FragmentManager get(View paramView)
  {
    Object localObject1 = call(paramView);
    Object localObject2;
    if (localObject1 != null)
    {
      if (((Fragment)localObject1).isAdded()) {
        return ((Fragment)localObject1).getChildFragmentManager();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("The Fragment ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(" that owns View ");
      ((StringBuilder)localObject2).append(paramView);
      ((StringBuilder)localObject2).append(" has already been destroyed. Nested fragments should always use the child FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    localObject1 = paramView.getContext();
    Object localObject3 = null;
    for (;;)
    {
      localObject2 = localObject3;
      if (!(localObject1 instanceof ContextWrapper)) {
        break;
      }
      if ((localObject1 instanceof FragmentActivity))
      {
        localObject2 = (FragmentActivity)localObject1;
        break;
      }
      localObject1 = ((ContextWrapper)localObject1).getBaseContext();
    }
    if (localObject2 != null) {
      return ((FragmentActivity)localObject2).getSupportFragmentManager();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("View ");
    ((StringBuilder)localObject1).append(paramView);
    ((StringBuilder)localObject1).append(" is not within a subclass of FragmentActivity.");
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  private Set get()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this$0.size().iterator();
    while (localIterator.hasNext())
    {
      ViewGroup localViewGroup = nextgetValuemContainer;
      if (localViewGroup != null) {
        localHashSet.add(SpecialEffectsController.add(localViewGroup, getName()));
      }
    }
    return localHashSet;
  }
  
  public static boolean get(int paramInt)
  {
    return (permanent) || (android.util.Log.isLoggable("FragmentManager", paramInt));
  }
  
  private void moveToState(Fragment paramFragment)
  {
    ViewGroup localViewGroup = onCreateView(paramFragment);
    if ((localViewGroup != null) && (paramFragment.getEnterAnim() + paramFragment.getExitAnim() + paramFragment.getPopEnterAnim() + paramFragment.getPopExitAnim() > 0))
    {
      int i = v7.app.Fragment.mContainerId;
      if (localViewGroup.getTag(i) == null) {
        localViewGroup.setTag(i, paramFragment);
      }
      ((Fragment)localViewGroup.getTag(i)).setPopDirection(paramFragment.getPopDirection());
    }
  }
  
  private void next()
  {
    p = false;
    r.clear();
    v.clear();
  }
  
  private ViewGroup onCreateView(Fragment paramFragment)
  {
    ViewGroup localViewGroup = mContainer;
    if (localViewGroup != null) {
      return localViewGroup;
    }
    if (mContainerId <= 0) {
      return null;
    }
    if (mContainer.onHasView())
    {
      paramFragment = mContainer.findViewById(mContainerId);
      if ((paramFragment instanceof ViewGroup)) {
        return (ViewGroup)paramFragment;
      }
    }
    return null;
  }
  
  private void remove()
  {
    if (canRemoveOrSet)
    {
      canRemoveOrSet = false;
      replace();
    }
  }
  
  private void remove(Fragment paramFragment)
  {
    if ((paramFragment != null) && (paramFragment.equals(get(mWho)))) {
      paramFragment.performPrimaryNavigationFragmentChanged();
    }
  }
  
  private void replace()
  {
    Iterator localIterator = this$0.size().iterator();
    while (localIterator.hasNext()) {
      remove((Log)localIterator.next());
    }
  }
  
  static int reverseTransit(int paramInt)
  {
    if (paramInt != 4097)
    {
      if (paramInt != 8194)
      {
        if (paramInt != 8197)
        {
          if (paramInt != 4099)
          {
            if (paramInt != 4100) {
              return 0;
            }
            return 8197;
          }
          return 4099;
        }
      }
      else {
        return 4097;
      }
    }
    else {
      return 8194;
    }
    return 4100;
  }
  
  private void run(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    boolean bool = geth;
    Object localObject1 = data;
    if (localObject1 == null) {
      data = new ArrayList();
    } else {
      ((ArrayList)localObject1).clear();
    }
    data.addAll(this$0.get());
    localObject1 = findFragmentById();
    int m = paramInt1;
    int i = 0;
    Object localObject2;
    while (m < paramInt2)
    {
      localObject2 = (BackStackRecord)paramArrayList1.get(m);
      if (!((Boolean)paramArrayList2.get(m)).booleanValue()) {
        localObject1 = ((BackStackRecord)localObject2).a(data, (Fragment)localObject1);
      } else {
        localObject1 = ((BackStackRecord)localObject2).update(data, (Fragment)localObject1);
      }
      if ((i == 0) && (!p)) {
        i = 0;
      } else {
        i = 1;
      }
      m += 1;
    }
    data.clear();
    if ((!bool) && (type >= 1))
    {
      m = paramInt1;
      while (m < paramInt2)
      {
        localObject1 = getm.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = nextfragment;
          if ((localObject2 != null) && (mFragmentManager != null))
          {
            localObject2 = getInstance((Fragment)localObject2);
            this$0.add((Log)localObject2);
          }
        }
        m += 1;
      }
    }
    write(paramArrayList1, paramArrayList2, paramInt1, paramInt2);
    bool = ((Boolean)paramArrayList2.get(paramInt2 - 1)).booleanValue();
    m = paramInt1;
    while (m < paramInt2)
    {
      localObject1 = (BackStackRecord)paramArrayList1.get(m);
      if (bool)
      {
        int n = m.size() - 1;
        while (n >= 0)
        {
          localObject2 = m.get(n)).fragment;
          if (localObject2 != null) {
            getInstance((Fragment)localObject2).run();
          }
          n -= 1;
        }
      }
      localObject1 = m.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = nextfragment;
        if (localObject2 != null) {
          getInstance((Fragment)localObject2).run();
        }
      }
      m += 1;
    }
    a(type, true);
    localObject1 = dump(paramArrayList1, paramInt1, paramInt2).iterator();
    for (;;)
    {
      m = paramInt1;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (SpecialEffectsController)((Iterator)localObject1).next();
      ((SpecialEffectsController)localObject2).setValue(bool);
      ((SpecialEffectsController)localObject2).run();
      ((SpecialEffectsController)localObject2).a();
    }
    while (m < paramInt2)
    {
      localObject1 = (BackStackRecord)paramArrayList1.get(m);
      if ((((Boolean)paramArrayList2.get(m)).booleanValue()) && (mIndex >= 0)) {
        mIndex = -1;
      }
      ((BackStackRecord)localObject1).flush();
      m += 1;
    }
    if (i != 0) {
      copy();
    }
  }
  
  private void showDialog()
  {
    Iterator localIterator = get().iterator();
    while (localIterator.hasNext()) {
      ((SpecialEffectsController)localIterator.next()).b();
    }
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    android.util.Log.e("FragmentManager", paramRuntimeException.getMessage());
    android.util.Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    FragmentHostCallback localFragmentHostCallback = mHost;
    if (localFragmentHostCallback != null) {
      try
      {
        localFragmentHostCallback.onDump("  ", null, localPrintWriter, new String[0]);
      }
      catch (Exception localException1)
      {
        android.util.Log.e("FragmentManager", "Failed dumping state", localException1);
      }
    } else {
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        android.util.Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
    throw paramRuntimeException;
  }
  
  private static void write(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList1.get(paramInt1);
      if (((Boolean)paramArrayList2.get(paramInt1)).booleanValue())
      {
        localBackStackRecord.bumpBackStackNesting(-1);
        localBackStackRecord.a();
      }
      else
      {
        localBackStackRecord.bumpBackStackNesting(1);
        localBackStackRecord.run();
      }
      paramInt1 += 1;
    }
  }
  
  public Fragment a(Bundle paramBundle, String paramString)
  {
    paramBundle = paramBundle.getString(paramString);
    if (paramBundle == null) {
      return null;
    }
    Fragment localFragment = get(paramBundle);
    if (localFragment == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment no longer exists for key ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": unique id ");
      localStringBuilder.append(paramBundle);
      throwException(new IllegalStateException(localStringBuilder.toString()));
    }
    return localFragment;
  }
  
  f a()
  {
    return d;
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if ((mHost == null) && (paramInt != -1)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == type)) {
      return;
    }
    type = paramInt;
    this$0.a();
    replace();
    if (mNeedMenuInvalidate)
    {
      FragmentHostCallback localFragmentHostCallback = mHost;
      if ((localFragmentHostCallback != null) && (type == 7))
      {
        localFragmentHostCallback.onSupportInvalidateOptionsMenu();
        mNeedMenuInvalidate = false;
      }
    }
  }
  
  boolean a(Menu paramMenu)
  {
    int i = type;
    boolean bool = false;
    if (i < 1) {
      return false;
    }
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (isPrimitive(localFragment)) && (localFragment.performPrepareOptionsMenu(paramMenu))) {
        bool = true;
      }
    }
    return bool;
  }
  
  boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int m = type;
    int i = 0;
    if (m < 1) {
      return false;
    }
    Object localObject1 = null;
    Iterator localIterator = this$0.get().iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (isPrimitive(localFragment)) && (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)))
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        bool = true;
        localObject1 = localObject2;
      }
    }
    if (h != null) {
      while (i < h.size())
      {
        paramMenu = (Fragment)h.get(i);
        if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    h = localObject1;
    return bool;
  }
  
  boolean a(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return true;
    }
    FragmentManager localFragmentManager = mFragmentManager;
    return (paramFragment.equals(localFragmentManager.findFragmentById())) && (a(mContext));
  }
  
  void add(BackStackRecord paramBackStackRecord)
  {
    if (mData == null) {
      mData = new ArrayList();
    }
    mData.add(paramBackStackRecord);
  }
  
  void add(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (c != null)
    {
      Intent localIntent = paramIntent;
      if (paramBundle != null)
      {
        localIntent = paramIntent;
        if (paramIntent == null)
        {
          localIntent = new Intent();
          localIntent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
        }
        if (get(2))
        {
          paramIntent = new StringBuilder();
          paramIntent.append("ActivityOptions ");
          paramIntent.append(paramBundle);
          paramIntent.append(" were added to fillInIntent ");
          paramIntent.append(localIntent);
          paramIntent.append(" for fragment ");
          paramIntent.append(paramFragment);
          android.util.Log.v("FragmentManager", paramIntent.toString());
        }
        localIntent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", paramBundle);
      }
      paramIntentSender = new IntentSenderRequest.b(paramIntentSender).a(localIntent).a(paramInt3, paramInt2).e();
      paramIntent = new LaunchedFragmentInfo(mWho, paramInt1);
      SDK_INT.addLast(paramIntent);
      if (get(2))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Fragment ");
        paramIntent.append(paramFragment);
        paramIntent.append("is launching an IntentSender for result ");
        android.util.Log.v("FragmentManager", paramIntent.toString());
      }
      c.a(paramIntentSender);
      return;
    }
    mHost.a(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  void add(Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment = onCreateView(paramFragment);
    if ((paramFragment != null) && ((paramFragment instanceof FragmentContainerView))) {
      ((FragmentContainerView)paramFragment).setDrawDisappearingViewsLast(paramBoolean ^ true);
    }
  }
  
  void add(m paramM, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (mHost == null) {
        return;
      }
      if (mDestroyed) {
        return;
      }
    }
    a(paramBoolean);
    if (paramM.add(v, r))
    {
      p = true;
      try
      {
        a(v, r);
        next();
      }
      catch (Throwable paramM)
      {
        next();
        throw paramM;
      }
    }
    clear();
    remove();
    this$0.write();
  }
  
  public final void add(String paramString)
  {
    cache.remove(paramString);
    if (get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Clearing fragment result with key ");
      localStringBuilder.append(paramString);
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  boolean add()
  {
    Iterator localIterator = this$0.getAll().iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      boolean bool2 = bool1;
      if (localFragment != null) {
        bool2 = add(localFragment);
      }
      bool1 = bool2;
      if (bool2) {
        return true;
      }
    }
    return false;
  }
  
  public boolean add(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      return a(null, paramInt1, paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad id: ");
    localStringBuilder.append(paramInt1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean add(ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt2 & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramInt2 = add(paramString, paramInt1, bool);
    if (paramInt2 < 0) {
      return false;
    }
    paramInt1 = mData.size() - 1;
    while (paramInt1 >= paramInt2)
    {
      paramArrayList1.add((BackStackRecord)mData.remove(paramInt1));
      paramArrayList2.add(Boolean.TRUE);
      paramInt1 -= 1;
    }
    return true;
  }
  
  boolean add(boolean paramBoolean)
  {
    a(paramBoolean);
    paramBoolean = false;
    while (commit(v, r))
    {
      p = true;
      try
      {
        a(v, r);
        next();
        paramBoolean = true;
      }
      catch (Throwable localThrowable)
      {
        next();
        throw localThrowable;
      }
    }
    clear();
    remove();
    this$0.write();
    return paramBoolean;
  }
  
  Log addFragment(Fragment paramFragment)
  {
    Object localObject = mPreviousWho;
    if (localObject != null) {
      FragmentStrictMode.add(paramFragment, (String)localObject);
    }
    if (get(2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add: ");
      ((StringBuilder)localObject).append(paramFragment);
      android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
    }
    localObject = getInstance(paramFragment);
    mFragmentManager = this;
    this$0.add((Log)localObject);
    if (!mDetached)
    {
      this$0.add(paramFragment);
      mRemoving = false;
      if (mView == null) {
        mHiddenChanged = false;
      }
      if (add(paramFragment)) {
        mNeedMenuInvalidate = true;
      }
    }
    return localObject;
  }
  
  void addOnBackStackChangedListener(Fragment paramFragment)
  {
    a.add(paramFragment);
  }
  
  void attachController(Fragment paramFragment)
  {
    a.release(paramFragment);
  }
  
  void attachFragment(Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (get(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach: ");
      localStringBuilder.append(paramFragment);
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (mDetached)
    {
      mDetached = false;
      if (!mAdded)
      {
        this$0.add(paramFragment);
        if (get(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("add from attach: ");
          localStringBuilder.append(paramFragment);
          android.util.Log.v("FragmentManager", localStringBuilder.toString());
        }
        if (add(paramFragment)) {
          mNeedMenuInvalidate = true;
        }
      }
    }
  }
  
  public void b(k paramK, boolean paramBoolean)
  {
    d.a(paramK, paramBoolean);
  }
  
  public boolean b()
  {
    return (x) || (s);
  }
  
  public Item beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  AppCompatDelegate build()
  {
    return mContainer;
  }
  
  void c(Fragment paramFragment)
  {
    Iterator localIterator = B.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).onAttachFragment(this, paramFragment);
    }
  }
  
  public void c(k paramK)
  {
    d.a(paramK);
  }
  
  void commit(m paramM, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (mHost == null)
      {
        if (mDestroyed) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      close();
    }
    ArrayList localArrayList = mPendingActions;
    try
    {
      if (mHost == null)
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
      mPendingActions.add(paramM);
      execPendingActions();
      return;
    }
    catch (Throwable paramM)
    {
      throw paramM;
    }
  }
  
  Fragment create(String paramString)
  {
    return this$0.create(paramString);
  }
  
  public boolean d()
  {
    return a(null, -1, 0);
  }
  
  void destroyItem()
  {
    clear();
    remove(left);
  }
  
  void detachFragment(Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (get(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach: ");
      localStringBuilder.append(paramFragment);
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!mDetached)
    {
      mDetached = true;
      if (mAdded)
      {
        if (get(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove from detach: ");
          localStringBuilder.append(paramFragment);
          android.util.Log.v("FragmentManager", localStringBuilder.toString());
        }
        this$0.remove(paramFragment);
        if (add(paramFragment)) {
          mNeedMenuInvalidate = true;
        }
        moveToState(paramFragment);
      }
    }
  }
  
  void dispatchDestroyView()
  {
    add(1);
  }
  
  void dispatchPause()
  {
    add(5);
  }
  
  Bundle doInBackground()
  {
    Bundle localBundle = new Bundle();
    showDialog();
    call();
    add(true);
    x = true;
    a.e(true);
    Object localObject4 = this$0.dump();
    Object localObject3 = this$0.getSettings();
    if (((ArrayList)localObject3).isEmpty())
    {
      if (get(2))
      {
        android.util.Log.v("FragmentManager", "saveAllState: no fragments!");
        return localBundle;
      }
    }
    else
    {
      ArrayList localArrayList1 = this$0.read();
      Object localObject2 = null;
      ArrayList localArrayList2 = mData;
      Object localObject1 = localObject2;
      if (localArrayList2 != null)
      {
        int m = localArrayList2.size();
        localObject1 = localObject2;
        if (m > 0)
        {
          localObject2 = new BackStackRecordState[m];
          int i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= m) {
              break;
            }
            localObject2[i] = new BackStackRecordState((BackStackRecord)mData.get(i));
            if (get(2))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("saveAllState: adding back stack #");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(": ");
              ((StringBuilder)localObject1).append(mData.get(i));
              android.util.Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
            }
            i += 1;
          }
        }
      }
      localObject2 = new FragmentManagerState();
      c = ((ArrayList)localObject4);
      id = localArrayList1;
      data = ((BackStackRecordState[])localObject1);
      value = mActivity.get();
      localObject1 = left;
      if (localObject1 != null) {
        text = mWho;
      }
      images.addAll(context.keySet());
      groups.addAll(context.values());
      tasks = new ArrayList(SDK_INT);
      localBundle.putParcelable("state", (Parcelable)localObject2);
      localObject1 = cache.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("result_");
        ((StringBuilder)localObject4).append((String)localObject2);
        localBundle.putBundle(((StringBuilder)localObject4).toString(), (Bundle)cache.get(localObject2));
      }
      localObject1 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FragmentState)((Iterator)localObject1).next();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putParcelable("state", (Parcelable)localObject2);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("fragment_");
        ((StringBuilder)localObject4).append(c);
        localBundle.putBundle(((StringBuilder)localObject4).toString(), (Bundle)localObject3);
      }
    }
    return localBundle;
  }
  
  void dump()
  {
    Iterator localIterator = this$0.getAll().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null)
      {
        localFragment.onHiddenChanged(localFragment.isHidden());
        mChildFragmentManager.dump();
      }
    }
  }
  
  void dump(Configuration paramConfiguration)
  {
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  void dump(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((!paramFragment.equals(get(mWho))) || ((mHost != null) && (mFragmentManager != this))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(paramFragment);
      ((StringBuilder)localObject).append(" is not an active fragment of FragmentManager ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = left;
    left = paramFragment;
    remove((Fragment)localObject);
    remove(left);
  }
  
  void dump(Fragment paramFragment, Lifecycle.State paramState)
  {
    if ((paramFragment.equals(get(mWho))) && ((mHost == null) || (mFragmentManager == this)))
    {
      mMaxState = paramState;
      return;
    }
    paramState = new StringBuilder();
    paramState.append("Fragment ");
    paramState.append(paramFragment);
    paramState.append(" is not an active fragment of FragmentManager ");
    paramState.append(this);
    throw new IllegalArgumentException(paramState.toString());
  }
  
  void dump(FragmentContainerView paramFragmentContainerView)
  {
    Iterator localIterator = this$0.size().iterator();
    while (localIterator.hasNext())
    {
      Log localLog = (Log)localIterator.next();
      Fragment localFragment = localLog.getValue();
      if (mContainerId == paramFragmentContainerView.getId())
      {
        View localView = mView;
        if ((localView != null) && (localView.getParent() == null))
        {
          mContainer = paramFragmentContainerView;
          localLog.e();
        }
      }
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("    ");
    localObject = ((StringBuilder)localObject).toString();
    this$0.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramFileDescriptor = h;
    int m = 0;
    int n;
    int i;
    if (paramFileDescriptor != null)
    {
      n = paramFileDescriptor.size();
      if (n > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < n)
        {
          paramFileDescriptor = (Fragment)h.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    paramFileDescriptor = mData;
    if (paramFileDescriptor != null)
    {
      n = paramFileDescriptor.size();
      if (n > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < n)
        {
          paramFileDescriptor = (BackStackRecord)mData.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.dump$ec96877((String)localObject, paramPrintWriter);
          i += 1;
        }
      }
    }
    paramPrintWriter.print(paramString);
    paramFileDescriptor = new StringBuilder();
    paramFileDescriptor.append("Back Stack Index: ");
    paramFileDescriptor.append(mActivity.get());
    paramPrintWriter.println(paramFileDescriptor.toString());
    paramFileDescriptor = mPendingActions;
    try
    {
      n = mPendingActions.size();
      if (n > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Actions:");
        i = m;
        while (i < n)
        {
          paramArrayOfString = (m)mPendingActions.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramArrayOfString);
          i += 1;
        }
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("FragmentManager misc state:");
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mHost=");
      paramPrintWriter.println(mHost);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mContainer=");
      paramPrintWriter.println(mContainer);
      if (mContext != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mParent=");
        paramPrintWriter.println(mContext);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mCurState=");
      paramPrintWriter.print(type);
      paramPrintWriter.print(" mStateSaved=");
      paramPrintWriter.print(x);
      paramPrintWriter.print(" mStopped=");
      paramPrintWriter.print(s);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(mDestroyed);
      if (mNeedMenuInvalidate)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNeedMenuInvalidate=");
        paramPrintWriter.println(mNeedMenuInvalidate);
        return;
      }
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public FragmentStrictMode.b e()
  {
    return j;
  }
  
  void execPendingActions()
  {
    ArrayList localArrayList = mPendingActions;
    for (;;)
    {
      try
      {
        int m = mPendingActions.size();
        i = 1;
        if (m == 1)
        {
          if (i != 0)
          {
            mHost.getHandler().removeCallbacks(mExecCommit);
            mHost.getHandler().post(mExecCommit);
            clear();
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      int i = 0;
    }
  }
  
  public void f(d paramD)
  {
    B.add(paramD);
  }
  
  public Fragment findFragmentById()
  {
    return left;
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    return this$0.get(paramInt);
  }
  
  LayoutInflater.Factory2 findFragmentByTag()
  {
    return mmDevice;
  }
  
  public Fragment.SavedState get(Fragment paramFragment)
  {
    Log localLog = this$0.getInstance(mWho);
    if ((localLog == null) || (!localLog.getValue().equals(paramFragment)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not currently in the FragmentManager");
      throwException(new IllegalStateException(localStringBuilder.toString()));
    }
    return localLog.initialize();
  }
  
  Fragment get(String paramString)
  {
    return this$0.get(paramString);
  }
  
  public int getBackStackEntryCount()
  {
    ArrayList localArrayList = mData;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  boolean getBoolean(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return false;
    }
    return paramFragment.isHidden();
  }
  
  public FragmentHostCallback getContext()
  {
    return mHost;
  }
  
  public Fragment getFragment(String paramString)
  {
    return this$0.toString(paramString);
  }
  
  public List getFragment()
  {
    return this$0.get();
  }
  
  boolean getFragment(int paramInt)
  {
    return type >= paramInt;
  }
  
  Log getInstance(Fragment paramFragment)
  {
    Log localLog = this$0.getInstance(mWho);
    if (localLog != null) {
      return localLog;
    }
    paramFragment = new Log(d, this$0, paramFragment);
    paramFragment.moveToState(mHost.getContext().getClassLoader());
    paramFragment.setText(type);
    return paramFragment;
  }
  
  Name getName()
  {
    Object localObject = name;
    if (localObject != null) {
      return localObject;
    }
    localObject = mContext;
    if (localObject != null) {
      return mFragmentManager.getName();
    }
    return packageName;
  }
  
  public Loader getView()
  {
    Object localObject = position;
    if (localObject != null) {
      return localObject;
    }
    localObject = mContext;
    if (localObject != null) {
      return mFragmentManager.getView();
    }
    return view;
  }
  
  void hideFragment(Fragment paramFragment)
  {
    if (get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide: ");
      localStringBuilder.append(paramFragment);
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!mHidden)
    {
      mHidden = true;
      mHiddenChanged = (true ^ mHiddenChanged);
      moveToState(paramFragment);
    }
  }
  
  androidx.lifecycle.ClassWriter init(Fragment paramFragment)
  {
    return a.init(paramFragment);
  }
  
  void init()
  {
    x = false;
    s = false;
    a.e(false);
    add(7);
  }
  
  void invoke(Menu paramMenu)
  {
    if (type < 1) {
      return;
    }
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  void invoke(boolean paramBoolean)
  {
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
    }
  }
  
  boolean invoke(MenuItem paramMenuItem)
  {
    if (type < 1) {
      return false;
    }
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isDestroyed()
  {
    return mDestroyed;
  }
  
  boolean isPrimitive(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return true;
    }
    return paramFragment.isMenuVisible();
  }
  
  Fragment iterator()
  {
    return mContext;
  }
  
  void onActivityCreated()
  {
    x = false;
    s = false;
    a.e(false);
    add(4);
  }
  
  void onCreate()
  {
    add(true);
    if (mAdapter.isEnabled())
    {
      d();
      return;
    }
    mListener.update();
  }
  
  void onCreate(FragmentHostCallback paramFragmentHostCallback, AppCompatDelegate paramAppCompatDelegate, Fragment paramFragment)
  {
    if (mHost == null)
    {
      mHost = paramFragmentHostCallback;
      mContainer = paramAppCompatDelegate;
      mContext = paramFragment;
      if (paramFragment != null) {
        f(new FragmentManager.g(this, paramFragment));
      } else if ((paramFragmentHostCallback instanceof d)) {
        f((d)paramFragmentHostCallback);
      }
      if (mContext != null) {
        clear();
      }
      Object localObject;
      if ((paramFragmentHostCallback instanceof androidx.activity.Point))
      {
        paramAppCompatDelegate = (androidx.activity.Point)paramFragmentHostCallback;
        localObject = ((androidx.activity.Point)paramAppCompatDelegate).getOnBackPressedDispatcher();
        mListener = ((OnBackPressedDispatcher)localObject);
        if (paramFragment != null) {
          paramAppCompatDelegate = paramFragment;
        }
        ((OnBackPressedDispatcher)localObject).f(paramAppCompatDelegate, mAdapter);
      }
      if (paramFragment != null) {
        a = mFragmentManager.b(paramFragment);
      } else if ((paramFragmentHostCallback instanceof androidx.lifecycle.h)) {
        a = Label.a(((androidx.lifecycle.h)paramFragmentHostCallback).getViewModelStore());
      } else {
        a = new Label(false);
      }
      a.e(b());
      this$0.goTo(a);
      paramFragmentHostCallback = mHost;
      if (((paramFragmentHostCallback instanceof androidx.savedstate.Label)) && (paramFragment == null))
      {
        paramFragmentHostCallback = ((androidx.savedstate.Label)paramFragmentHostCallback).getSavedStateRegistry();
        paramFragmentHostCallback.a("android:support:fragments", new FileChooserActivity(this));
        paramFragmentHostCallback = paramFragmentHostCallback.a("android:support:fragments");
        if (paramFragmentHostCallback != null) {
          run(paramFragmentHostCallback);
        }
      }
      paramFragmentHostCallback = mHost;
      if ((paramFragmentHostCallback instanceof Alarm))
      {
        paramAppCompatDelegate = ((Alarm)paramFragmentHostCallback).getActivityResultRegistry();
        if (paramFragment != null)
        {
          paramFragmentHostCallback = new StringBuilder();
          paramFragmentHostCallback.append(mWho);
          paramFragmentHostCallback.append(":");
          paramFragmentHostCallback = paramFragmentHostCallback.toString();
        }
        else
        {
          paramFragmentHostCallback = "";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FragmentManager:");
        ((StringBuilder)localObject).append(paramFragmentHostCallback);
        paramFragmentHostCallback = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFragmentHostCallback);
        ((StringBuilder)localObject).append("StartActivityForResult");
        k = paramAppCompatDelegate.a(((StringBuilder)localObject).toString(), new g(), new FragmentManager.h(this));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFragmentHostCallback);
        ((StringBuilder)localObject).append("StartIntentSenderForResult");
        c = paramAppCompatDelegate.a(((StringBuilder)localObject).toString(), new j(), new FragmentManager.i(this));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFragmentHostCallback);
        ((StringBuilder)localObject).append("RequestPermissions");
        b = paramAppCompatDelegate.a(((StringBuilder)localObject).toString(), new androidx.activity.result.asm.f(), new FragmentManager.a(this));
      }
      paramFragmentHostCallback = mHost;
      if ((paramFragmentHostCallback instanceof History)) {
        ((History)paramFragmentHostCallback).addOnConfigurationChangedListener(mUsername);
      }
      paramFragmentHostCallback = mHost;
      if ((paramFragmentHostCallback instanceof androidx.core.content.Point)) {
        ((androidx.core.content.Point)paramFragmentHostCallback).addOnTrimMemoryListener(mPassword);
      }
      paramFragmentHostCallback = mHost;
      if ((paramFragmentHostCallback instanceof androidx.core.package_10.Translation)) {
        ((androidx.core.package_10.Translation)paramFragmentHostCallback).addOnMultiWindowModeChangedListener(mUser);
      }
      paramFragmentHostCallback = mHost;
      if ((paramFragmentHostCallback instanceof ChatMessage)) {
        ((ChatMessage)paramFragmentHostCallback).addOnPictureInPictureModeChangedListener(mParent);
      }
      paramFragmentHostCallback = mHost;
      if (((paramFragmentHostCallback instanceof v7.v7.package_13.Translation)) && (paramFragment == null)) {
        ((v7.v7.package_13.Translation)paramFragmentHostCallback).addMenuProvider(mHandler);
      }
    }
    else
    {
      throw new IllegalStateException("Already attached");
    }
  }
  
  void onCreateView()
  {
    mDestroyed = true;
    add(true);
    call();
    execute();
    add(-1);
    Object localObject = mHost;
    if ((localObject instanceof androidx.core.content.Point)) {
      ((androidx.core.content.Point)localObject).removeOnTrimMemoryListener(mPassword);
    }
    localObject = mHost;
    if ((localObject instanceof History)) {
      ((History)localObject).removeOnConfigurationChangedListener(mUsername);
    }
    localObject = mHost;
    if ((localObject instanceof androidx.core.package_10.Translation)) {
      ((androidx.core.package_10.Translation)localObject).removeOnMultiWindowModeChangedListener(mUser);
    }
    localObject = mHost;
    if ((localObject instanceof ChatMessage)) {
      ((ChatMessage)localObject).removeOnPictureInPictureModeChangedListener(mParent);
    }
    localObject = mHost;
    if ((localObject instanceof v7.v7.package_13.Translation)) {
      ((v7.v7.package_13.Translation)localObject).removeMenuProvider(mHandler);
    }
    mHost = null;
    mContainer = null;
    mContext = null;
    if (mListener != null)
    {
      mAdapter.remove();
      mListener = null;
    }
    localObject = k;
    if (localObject != null)
    {
      ((androidx.activity.result.Label)localObject).a();
      c.a();
      b.a();
    }
  }
  
  void onStart()
  {
    if (mHost == null) {
      return;
    }
    x = false;
    s = false;
    a.e(false);
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (mFragmentManager != this)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not currently in the FragmentManager");
      throwException(new IllegalStateException(localStringBuilder.toString()));
    }
    paramBundle.putString(paramString, mWho);
  }
  
  void read()
  {
    x = false;
    s = false;
    a.e(false);
    add(5);
  }
  
  void remove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 >= 0)
    {
      commit(new n(null, paramInt1, paramInt2), paramBoolean);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad id: ");
    localStringBuilder.append(paramInt1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void remove(Log paramLog)
  {
    Fragment localFragment = paramLog.getValue();
    if (mDeferStart)
    {
      if (p)
      {
        canRemoveOrSet = true;
        return;
      }
      mDeferStart = false;
      paramLog.run();
    }
  }
  
  public void removeFragment()
  {
    commit(new n(null, -1, 0), false);
  }
  
  void removeFragment(Fragment paramFragment)
  {
    if (get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove: ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" nesting=");
      localStringBuilder.append(mBackStackNesting);
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    boolean bool = paramFragment.isInBackStack();
    if ((!mDetached) || ((bool ^ true)))
    {
      this$0.remove(paramFragment);
      if (add(paramFragment)) {
        mNeedMenuInvalidate = true;
      }
      mRemoving = true;
      moveToState(paramFragment);
    }
  }
  
  void requestPermissions(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    if (b != null)
    {
      paramFragment = new LaunchedFragmentInfo(mWho, paramInt);
      SDK_INT.addLast(paramFragment);
      b.a(paramArrayOfString);
      return;
    }
    mHost.onRequestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
  }
  
  void resolve()
  {
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
    }
  }
  
  void resolve(boolean paramBoolean)
  {
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
    }
  }
  
  void restoreState()
  {
    x = false;
    s = false;
    a.e(false);
    add(1);
  }
  
  void run()
  {
    x = false;
    s = false;
    a.e(false);
    add(0);
  }
  
  void run(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return;
    }
    paramParcelable = (Bundle)paramParcelable;
    Object localObject1 = paramParcelable.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (((String)localObject3).startsWith("result_"))
      {
        localObject2 = paramParcelable.getBundle((String)localObject3);
        if (localObject2 != null)
        {
          ((Bundle)localObject2).setClassLoader(mHost.getContext().getClassLoader());
          localObject3 = ((String)localObject3).substring(7);
          cache.put(localObject3, localObject2);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramParcelable.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (((String)localObject3).startsWith("fragment_"))
      {
        localObject3 = paramParcelable.getBundle((String)localObject3);
        if (localObject3 != null)
        {
          ((Bundle)localObject3).setClassLoader(mHost.getContext().getClassLoader());
          ((ArrayList)localObject1).add((FragmentState)((Bundle)localObject3).getParcelable("state"));
        }
      }
    }
    this$0.a((ArrayList)localObject1);
    localObject1 = (FragmentManagerState)paramParcelable.getParcelable("state");
    if (localObject1 == null) {
      return;
    }
    this$0.reset();
    localObject2 = c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramParcelable = (String)((Iterator)localObject2).next();
      paramParcelable = this$0.get(paramParcelable, null);
      if (paramParcelable != null)
      {
        localObject3 = a.getColor(c);
        StringBuilder localStringBuilder;
        if (localObject3 != null)
        {
          if (get(2))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreSaveState: re-attaching retained ");
            localStringBuilder.append(localObject3);
            android.util.Log.v("FragmentManager", localStringBuilder.toString());
          }
          paramParcelable = new Log(d, this$0, (Fragment)localObject3, paramParcelable);
        }
        else
        {
          paramParcelable = new Log(d, this$0, mHost.getContext().getClassLoader(), getView(), paramParcelable);
        }
        localObject3 = paramParcelable.getValue();
        mFragmentManager = this;
        if (get(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("restoreSaveState: active (");
          localStringBuilder.append(mWho);
          localStringBuilder.append("): ");
          localStringBuilder.append(localObject3);
          android.util.Log.v("FragmentManager", localStringBuilder.toString());
        }
        paramParcelable.moveToState(mHost.getContext().getClassLoader());
        this$0.add(paramParcelable);
        paramParcelable.setText(type);
      }
    }
    paramParcelable = a.a().iterator();
    while (paramParcelable.hasNext())
    {
      localObject2 = (Fragment)paramParcelable.next();
      if (!this$0.remove(mWho))
      {
        if (get(2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Discarding retained Fragment ");
          ((StringBuilder)localObject3).append(localObject2);
          ((StringBuilder)localObject3).append(" that was not found in the set of active Fragments ");
          ((StringBuilder)localObject3).append(c);
          android.util.Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
        }
        a.release((Fragment)localObject2);
        mFragmentManager = this;
        localObject3 = new Log(d, this$0, (Fragment)localObject2);
        ((Log)localObject3).setText(1);
        ((Log)localObject3).run();
        mRemoving = true;
        ((Log)localObject3).run();
      }
    }
    this$0.load(id);
    paramParcelable = data;
    int m = 0;
    int i;
    if (paramParcelable != null)
    {
      mData = new ArrayList(data.length);
      i = 0;
      for (;;)
      {
        paramParcelable = data;
        if (i >= paramParcelable.length) {
          break;
        }
        paramParcelable = paramParcelable[i].a(this);
        if (get(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("restoreAllState: back stack #");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" (index ");
          ((StringBuilder)localObject2).append(mIndex);
          ((StringBuilder)localObject2).append("): ");
          ((StringBuilder)localObject2).append(paramParcelable);
          android.util.Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
          localObject2 = new PrintWriter(new LogWriter("FragmentManager"));
          paramParcelable.dump("  ", (PrintWriter)localObject2, false);
          ((PrintWriter)localObject2).close();
        }
        mData.add(paramParcelable);
        i += 1;
      }
    }
    mData = null;
    mActivity.set(value);
    paramParcelable = text;
    if (paramParcelable != null)
    {
      paramParcelable = get(paramParcelable);
      left = paramParcelable;
      remove(paramParcelable);
    }
    paramParcelable = images;
    if (paramParcelable != null)
    {
      i = m;
      while (i < paramParcelable.size())
      {
        context.put((String)paramParcelable.get(i), (BackStackState)groups.get(i));
        i += 1;
      }
    }
    SDK_INT = new ArrayDeque(tasks);
  }
  
  int sendRequest()
  {
    return mActivity.getAndIncrement();
  }
  
  void show(Fragment paramFragment)
  {
    if ((mAdded) && (add(paramFragment))) {
      mNeedMenuInvalidate = true;
    }
  }
  
  void showFragment(Fragment paramFragment)
  {
    if (get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show: ");
      localStringBuilder.append(paramFragment);
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (mHidden)
    {
      mHidden = false;
      mHiddenChanged ^= true;
    }
  }
  
  void showProgressDialog()
  {
    add(2);
  }
  
  void startActivityForResult(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (k != null)
    {
      paramFragment = new LaunchedFragmentInfo(mWho, paramInt);
      SDK_INT.addLast(paramFragment);
      if ((paramIntent != null) && (paramBundle != null)) {
        paramIntent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", paramBundle);
      }
      k.a(paramIntent);
      return;
    }
    mHost.onStartActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(java.lang.System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    Object localObject = mContext;
    if (localObject != null)
    {
      localStringBuilder.append(localObject.getClass().getSimpleName());
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(java.lang.System.identityHashCode(mContext)));
      localStringBuilder.append("}");
    }
    else
    {
      localObject = mHost;
      if (localObject != null)
      {
        localStringBuilder.append(localObject.getClass().getSimpleName());
        localStringBuilder.append("{");
        localStringBuilder.append(Integer.toHexString(java.lang.System.identityHashCode(mHost)));
        localStringBuilder.append("}");
      }
      else
      {
        localStringBuilder.append("null");
      }
    }
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  boolean update(MenuItem paramMenuItem)
  {
    if (type < 1) {
      return false;
    }
    Iterator localIterator = this$0.get().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void write()
  {
    s = true;
    a.e(true);
    add(4);
  }
  
  class LaunchedFragmentInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo> CREATOR = new a();
    int b;
    
    LaunchedFragmentInfo()
    {
      b = readInt();
    }
    
    LaunchedFragmentInfo(int paramInt)
    {
      b = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(FragmentManager.this);
      paramParcel.writeInt(b);
    }
    
    class a
      implements Parcelable.Creator<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo>
    {
      a() {}
      
      public FragmentManager.LaunchedFragmentInfo[] a(int paramInt)
      {
        return new FragmentManager.LaunchedFragmentInfo[paramInt];
      }
      
      public FragmentManager.LaunchedFragmentInfo readDate(Parcel paramParcel)
      {
        return new FragmentManager.LaunchedFragmentInfo(paramParcel);
      }
    }
  }
  
  class b
    extends PullToRefreshAttacher
  {
    b(boolean paramBoolean)
    {
      super();
    }
    
    public void handleOnBackPressed()
    {
      onCreate();
    }
  }
  
  class c
    implements v7.v7.package_13.h
  {
    c() {}
    
    public void a(Menu paramMenu)
    {
      invoke(paramMenu);
    }
    
    public void a(Menu paramMenu, MenuInflater paramMenuInflater)
    {
      a(paramMenu, paramMenuInflater);
    }
    
    public boolean a(MenuItem paramMenuItem)
    {
      return invoke(paramMenuItem);
    }
    
    public void b(Menu paramMenu)
    {
      a(paramMenu);
    }
  }
  
  class d
    extends Loader
  {
    d() {}
    
    public Fragment instantiate(ClassLoader paramClassLoader, String paramString)
    {
      return getContext().instantiate(getContext().getContext(), paramString, null);
    }
  }
  
  class e
    implements Name
  {
    e() {}
    
    public SpecialEffectsController a(ViewGroup paramViewGroup)
    {
      return new k(paramViewGroup);
    }
  }
  
  class f
    implements Runnable
  {
    f() {}
    
    public void run()
    {
      add(true);
    }
  }
  
  class j
    extends androidx.activity.result.d.a<IntentSenderRequest, ActivityResult>
  {
    j() {}
    
    public ActivityResult a(int paramInt, Intent paramIntent)
    {
      return new ActivityResult(paramInt, paramIntent);
    }
    
    public Intent onCreateView(Context paramContext, IntentSenderRequest paramIntentSenderRequest)
    {
      Intent localIntent1 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
      Intent localIntent2 = paramIntentSenderRequest.getIntent();
      paramContext = paramIntentSenderRequest;
      if (localIntent2 != null)
      {
        Bundle localBundle = localIntent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        paramContext = paramIntentSenderRequest;
        if (localBundle != null)
        {
          localIntent1.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", localBundle);
          localIntent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
          paramContext = paramIntentSenderRequest;
          if (localIntent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
            paramContext = new IntentSenderRequest.b(paramIntentSenderRequest.getIcon()).a(null).a(paramIntentSenderRequest.b(), paramIntentSenderRequest.getString()).e();
          }
        }
      }
      localIntent1.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", paramContext);
      if (FragmentManager.get(2))
      {
        paramContext = new StringBuilder();
        paramContext.append("CreateIntent created the following intent: ");
        paramContext.append(localIntent1);
        android.util.Log.v("FragmentManager", paramContext.toString());
      }
      return localIntent1;
    }
  }
  
  public abstract class k
  {
    public k() {}
    
    public void a(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void a(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public abstract void a(FragmentManager paramFragmentManager, Fragment paramFragment, View paramView, Bundle paramBundle);
    
    public void add(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void add(FragmentManager paramFragmentManager, Fragment paramFragment, Context paramContext) {}
    
    public void add(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public void append(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void b(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void b(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onCloseMenu(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void replace(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void show(FragmentManager paramFragmentManager, Fragment paramFragment, Context paramContext) {}
    
    public void show(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public void write(FragmentManager paramFragmentManager, Fragment paramFragment) {}
  }
  
  public abstract interface l
  {
    public abstract void checkCancelled();
  }
  
  abstract interface m
  {
    public abstract boolean add(ArrayList paramArrayList1, ArrayList paramArrayList2);
  }
  
  class n
    implements FragmentManager.m
  {
    final String a;
    final int b;
    final int d;
    
    n(String paramString, int paramInt1, int paramInt2)
    {
      a = paramString;
      b = paramInt1;
      d = paramInt2;
    }
    
    public boolean add(ArrayList paramArrayList1, ArrayList paramArrayList2)
    {
      Fragment localFragment = left;
      if ((localFragment != null) && (b < 0) && (a == null) && (localFragment.getChildFragmentManager().d())) {
        return false;
      }
      return add(paramArrayList1, paramArrayList2, a, b, d);
    }
  }
}

package androidx.fragment.package_11;

import android.util.Log;
import androidx.lifecycle.Lifecycle.State;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends Item
  implements FragmentManager.m
{
  boolean h = false;
  boolean mCommitted;
  int mIndex = -1;
  final FragmentManager this$0;
  
  BackStackRecord(FragmentManager paramFragmentManager)
  {
    super(localLoader, localClassLoader);
    this$0 = paramFragmentManager;
  }
  
  Fragment a(ArrayList paramArrayList, Fragment paramFragment)
  {
    int j = 0;
    for (Fragment localFragment1 = paramFragment; j < this.m.size(); localFragment1 = paramFragment)
    {
      Object localObject = (a0.a)this.m.get(j);
      int i = c;
      if (i != 1) {
        if (i != 2)
        {
          if ((i != 3) && (i != 6))
          {
            if (i != 7)
            {
              if (i != 8)
              {
                i = j;
                paramFragment = localFragment1;
                break label460;
              }
              this.m.add(j, new a0.a(9, localFragment1, true));
              p = true;
              i = j + 1;
              paramFragment = fragment;
              break label460;
            }
          }
          else
          {
            paramArrayList.remove(fragment);
            localObject = fragment;
            i = j;
            paramFragment = localFragment1;
            if (localObject != localFragment1) {
              break label460;
            }
            this.m.add(j, new a0.a(9, (Fragment)localObject));
            i = j + 1;
            paramFragment = null;
            break label460;
          }
        }
        else
        {
          Fragment localFragment2 = fragment;
          int i1 = mContainerId;
          int k = paramArrayList.size() - 1;
          int m = 0;
          paramFragment = localFragment1;
          i = j;
          while (k >= 0)
          {
            Fragment localFragment3 = (Fragment)paramArrayList.get(k);
            j = i;
            int n = m;
            localFragment1 = paramFragment;
            if (mContainerId == i1) {
              if (localFragment3 == localFragment2)
              {
                n = 1;
                j = i;
                localFragment1 = paramFragment;
              }
              else
              {
                j = i;
                localFragment1 = paramFragment;
                if (localFragment3 == paramFragment)
                {
                  this.m.add(i, new a0.a(9, localFragment3, true));
                  j = i + 1;
                  localFragment1 = null;
                }
                paramFragment = new a0.a(3, localFragment3, true);
                i = i;
                d = d;
                a = a;
                b = b;
                this.m.add(j, paramFragment);
                paramArrayList.remove(localFragment3);
                j += 1;
                n = m;
              }
            }
            k -= 1;
            i = j;
            m = n;
            paramFragment = localFragment1;
          }
          if (m != 0)
          {
            this.m.remove(i);
            i -= 1;
            break label460;
          }
          c = 1;
          p = true;
          paramArrayList.add(localFragment2);
          break label460;
        }
      }
      paramArrayList.add(fragment);
      paramFragment = localFragment1;
      i = j;
      label460:
      j = i + 1;
    }
    return localFragment1;
  }
  
  void a()
  {
    int i = m.size() - 1;
    while (i >= 0)
    {
      a0.a localA = (a0.a)m.get(i);
      Object localObject = fragment;
      if (localObject != null)
      {
        mBeingSaved = h;
        ((Fragment)localObject).setPopDirection(true);
        ((Fragment)localObject).setNextTransition(FragmentManager.reverseTransit(this.i));
        ((Fragment)localObject).setSharedElementNames(c, j);
      }
      switch (c)
      {
      default: 
        break;
      case 2: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown cmd: ");
        ((StringBuilder)localObject).append(c);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      case 10: 
        this$0.dump((Fragment)localObject, h);
        break;
      case 9: 
        this$0.dump((Fragment)localObject);
        break;
      case 8: 
        this$0.dump(null);
        break;
      case 7: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.add((Fragment)localObject, true);
        this$0.detachFragment((Fragment)localObject);
        break;
      case 6: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.attachFragment((Fragment)localObject);
        break;
      case 5: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.add((Fragment)localObject, true);
        this$0.hideFragment((Fragment)localObject);
        break;
      case 4: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.showFragment((Fragment)localObject);
        break;
      case 3: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.addFragment((Fragment)localObject);
        break;
      }
      ((Fragment)localObject).setAnimations(i, a, d, b);
      this$0.add((Fragment)localObject, true);
      this$0.removeFragment((Fragment)localObject);
      i -= 1;
    }
  }
  
  public Item add(Fragment paramFragment)
  {
    Object localObject = mFragmentManager;
    if ((localObject != null) && (localObject != this$0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return super.add(paramFragment);
  }
  
  public Item add(Fragment paramFragment, Lifecycle.State paramState)
  {
    if (mFragmentManager == this$0)
    {
      if ((paramState == Lifecycle.State.i) && (mState > -1))
      {
        paramFragment = new StringBuilder();
        paramFragment.append("Cannot set maximum Lifecycle to ");
        paramFragment.append(paramState);
        paramFragment.append(" after the Fragment has been created");
        throw new IllegalArgumentException(paramFragment.toString());
      }
      if (paramState != Lifecycle.State.c) {
        return super.add(paramFragment, paramState);
      }
      paramFragment = new StringBuilder();
      paramFragment.append("Cannot set maximum Lifecycle to ");
      paramFragment.append(paramState);
      paramFragment.append(". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
      throw new IllegalArgumentException(paramFragment.toString());
    }
    paramFragment = new StringBuilder();
    paramFragment.append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
    paramFragment.append(this$0);
    throw new IllegalArgumentException(paramFragment.toString());
  }
  
  public void add()
  {
    set();
    this$0.add(this, false);
  }
  
  void add(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    super.add(paramInt1, paramFragment, paramString, paramInt2);
    mFragmentManager = this$0;
  }
  
  public boolean add(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Run: ");
      localStringBuilder.append(this);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    paramArrayList1.add(this);
    paramArrayList2.add(Boolean.FALSE);
    if (p) {
      this$0.add(this);
    }
    return true;
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    if (!p) {
      return;
    }
    Object localObject1;
    if (FragmentManager.get(2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Bump nesting in ");
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(" by ");
      ((StringBuilder)localObject1).append(paramInt);
      Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    int j = m.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (a0.a)m.get(i);
      Object localObject2 = fragment;
      if (localObject2 != null)
      {
        mBackStackNesting += paramInt;
        if (FragmentManager.get(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Bump nesting of ");
          ((StringBuilder)localObject2).append(fragment);
          ((StringBuilder)localObject2).append(" to ");
          ((StringBuilder)localObject2).append(fragment.mBackStackNesting);
          Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
  }
  
  public int commit()
  {
    return commit(false);
  }
  
  int commit(boolean paramBoolean)
  {
    if (!mCommitted)
    {
      if (FragmentManager.get(2))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Commit: ");
        ((StringBuilder)localObject).append(this);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
        localObject = new PrintWriter(new LogWriter("FragmentManager"));
        dump$ec96877("  ", (PrintWriter)localObject);
        ((PrintWriter)localObject).close();
      }
      mCommitted = true;
      if (p) {
        mIndex = this$0.sendRequest();
      } else {
        mIndex = -1;
      }
      this$0.commit(this, paramBoolean);
      return mIndex;
    }
    throw new IllegalStateException("commit already called");
  }
  
  public int commitAllowingStateLoss()
  {
    return commit(true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(x);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(mCommitted);
      if (this.i != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.i));
      }
      if ((k != 0) || (a != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(k));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(a));
      }
      if ((d != 0) || (b != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(d));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(b));
      }
      if ((mBreadCrumbTitleRes != 0) || (mBreadCrumbTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(mBreadCrumbTitleText);
      }
      if ((mBreadCrumbShortTitleRes != 0) || (mBreadCrumbShortTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(mBreadCrumbShortTitleText);
      }
    }
    if (!m.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      int j = m.size();
      int i = 0;
      while (i < j)
      {
        a0.a localA = (a0.a)m.get(i);
        Object localObject;
        switch (c)
        {
        default: 
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cmd=");
          ((StringBuilder)localObject).append(c);
          localObject = ((StringBuilder)localObject).toString();
          break;
        case 10: 
          localObject = "OP_SET_MAX_LIFECYCLE";
          break;
        case 9: 
          localObject = "UNSET_PRIMARY_NAV";
          break;
        case 8: 
          localObject = "SET_PRIMARY_NAV";
          break;
        case 7: 
          localObject = "ATTACH";
          break;
        case 6: 
          localObject = "DETACH";
          break;
        case 5: 
          localObject = "SHOW";
          break;
        case 4: 
          localObject = "HIDE";
          break;
        case 3: 
          localObject = "REMOVE";
          break;
        case 2: 
          localObject = "REPLACE";
          break;
        case 1: 
          localObject = "ADD";
          break;
        case 0: 
          localObject = "NULL";
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.print((String)localObject);
        paramPrintWriter.print(" ");
        paramPrintWriter.println(fragment);
        if (paramBoolean)
        {
          if ((i != 0) || (a != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(i));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(a));
          }
          if ((d != 0) || (b != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(d));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(b));
          }
        }
        i += 1;
      }
    }
  }
  
  public void dump$ec96877(String paramString, PrintWriter paramPrintWriter)
  {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void flush()
  {
    if (buffer != null)
    {
      int i = 0;
      while (i < buffer.size())
      {
        ((Runnable)buffer.get(i)).run();
        i += 1;
      }
      buffer = null;
    }
  }
  
  public String getComponent()
  {
    return x;
  }
  
  public boolean remove()
  {
    return m.isEmpty();
  }
  
  void run()
  {
    int j = m.size();
    int i = 0;
    while (i < j)
    {
      a0.a localA = (a0.a)m.get(i);
      Object localObject = fragment;
      if (localObject != null)
      {
        mBeingSaved = h;
        ((Fragment)localObject).setPopDirection(false);
        ((Fragment)localObject).setNextTransition(this.i);
        ((Fragment)localObject).setSharedElementNames(this.j, c);
      }
      switch (c)
      {
      default: 
        break;
      case 2: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown cmd: ");
        ((StringBuilder)localObject).append(c);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      case 10: 
        this$0.dump((Fragment)localObject, type);
        break;
      case 9: 
        this$0.dump(null);
        break;
      case 8: 
        this$0.dump((Fragment)localObject);
        break;
      case 7: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.add((Fragment)localObject, false);
        this$0.attachFragment((Fragment)localObject);
        break;
      case 6: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.detachFragment((Fragment)localObject);
        break;
      case 5: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.add((Fragment)localObject, false);
        this$0.showFragment((Fragment)localObject);
        break;
      case 4: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.hideFragment((Fragment)localObject);
        break;
      case 3: 
        ((Fragment)localObject).setAnimations(i, a, d, b);
        this$0.removeFragment((Fragment)localObject);
        break;
      }
      ((Fragment)localObject).setAnimations(i, a, d, b);
      this$0.add((Fragment)localObject, false);
      this$0.addFragment((Fragment)localObject);
      i += 1;
    }
  }
  
  public void show()
  {
    set();
    this$0.add(this, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(mIndex);
    }
    if (x != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(x);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  Fragment update(ArrayList paramArrayList, Fragment paramFragment)
  {
    int i = m.size() - 1;
    while (i >= 0)
    {
      a0.a localA = (a0.a)m.get(i);
      int j = c;
      if (j != 1)
      {
        if (j != 3) {}
        switch (j)
        {
        default: 
          break;
        case 10: 
          type = h;
          break;
        case 9: 
          paramFragment = fragment;
          break;
        case 8: 
          paramFragment = null;
          break;
        case 6: 
          paramArrayList.add(fragment);
          break;
        }
      }
      else
      {
        paramArrayList.remove(fragment);
      }
      i -= 1;
    }
    return paramFragment;
  }
}

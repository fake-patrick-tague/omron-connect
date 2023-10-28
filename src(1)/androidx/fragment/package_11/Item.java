package androidx.fragment.package_11;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.package_11.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle.State;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class Item
{
  int a;
  int b;
  ArrayList<Runnable> buffer;
  ArrayList<String> c;
  int d;
  boolean g = true;
  boolean h = false;
  int i;
  private final ClassLoader image;
  private final Loader index;
  ArrayList<String> j;
  int k;
  ArrayList<androidx.fragment.app.a0.a> m = new ArrayList();
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  boolean p;
  String x;
  
  Item(Loader paramLoader, ClassLoader paramClassLoader)
  {
    index = paramLoader;
    image = paramClassLoader;
  }
  
  public Item a(int paramInt)
  {
    i = paramInt;
    return this;
  }
  
  public Item a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    k = paramInt1;
    a = paramInt2;
    d = paramInt3;
    b = paramInt4;
    return this;
  }
  
  public Item a(int paramInt, Fragment paramFragment)
  {
    add(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public Item a(int paramInt, Fragment paramFragment, String paramString)
  {
    add(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  Item a(ViewGroup paramViewGroup, Fragment paramFragment, String paramString)
  {
    mContainer = paramViewGroup;
    return a(paramViewGroup.getId(), paramFragment, paramString);
  }
  
  public Item a(String paramString)
  {
    if (g)
    {
      p = true;
      x = paramString;
      return this;
    }
    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
  }
  
  public Item a(boolean paramBoolean)
  {
    h = paramBoolean;
    return this;
  }
  
  void a(a0.a paramA)
  {
    m.add(paramA);
    i = k;
    a = a;
    d = d;
    b = b;
  }
  
  public Item add(int paramInt, Fragment paramFragment)
  {
    return get(paramInt, paramFragment, null);
  }
  
  public Item add(Fragment paramFragment)
  {
    a(new a0.a(3, paramFragment));
    return this;
  }
  
  public Item add(Fragment paramFragment, Lifecycle.State paramState)
  {
    a(new a0.a(10, paramFragment, paramState));
    return this;
  }
  
  public Item add(Fragment paramFragment, String paramString)
  {
    add(0, paramFragment, paramString, 1);
    return this;
  }
  
  public abstract void add();
  
  void add(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Object localObject = mPreviousWho;
    if (localObject != null) {
      FragmentStrictMode.add(paramFragment, (String)localObject);
    }
    localObject = paramFragment.getClass();
    int n = ((Class)localObject).getModifiers();
    if ((!((Class)localObject).isAnonymousClass()) && (Modifier.isPublic(n)) && ((!((Class)localObject).isMemberClass()) || (Modifier.isStatic(n))))
    {
      if (paramString != null)
      {
        localObject = mTag;
        if ((localObject != null) && (!paramString.equals(localObject)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Can't change tag of fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(": was ");
          ((StringBuilder)localObject).append(mTag);
          ((StringBuilder)localObject).append(" now ");
          ((StringBuilder)localObject).append(paramString);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        mTag = paramString;
      }
      if (paramInt1 != 0) {
        if (paramInt1 != -1)
        {
          n = mFragmentId;
          if ((n != 0) && (n != paramInt1))
          {
            paramString = new StringBuilder();
            paramString.append("Can't change container ID of fragment ");
            paramString.append(paramFragment);
            paramString.append(": was ");
            paramString.append(mFragmentId);
            paramString.append(" now ");
            paramString.append(paramInt1);
            throw new IllegalStateException(paramString.toString());
          }
          mFragmentId = paramInt1;
          mContainerId = paramInt1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Can't add fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(" with tag ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" to container view with no id");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      a(new a0.a(paramInt2, paramFragment));
      return;
    }
    paramFragment = new StringBuilder();
    paramFragment.append("Fragment ");
    paramFragment.append(((Class)localObject).getCanonicalName());
    paramFragment.append(" must be a public static class to be  properly recreated from instance state.");
    throw new IllegalStateException(paramFragment.toString());
  }
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public Item get(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt != 0)
    {
      add(paramInt, paramFragment, paramString, 2);
      return this;
    }
    throw new IllegalArgumentException("Must use non-zero containerViewId");
  }
  
  public abstract boolean remove();
  
  public Item set()
  {
    if (!p)
    {
      g = false;
      return this;
    }
    throw new IllegalStateException("This transaction is already being added to the back stack");
  }
  
  public abstract void show();
}

package androidx.viewpager2.adapter;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.package_11.FragmentManager;
import androidx.fragment.package_11.FragmentManager.k;
import androidx.fragment.package_11.Item;
import androidx.lifecycle.LayoutManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import java.util.Iterator;
import java.util.Set;
import v7.util.SparseArray;
import v7.util.TLongArrayList;
import v7.v7.package_13.ViewCompat;
import v7.v7.util.Log;

public abstract class FragmentStateAdapter
  extends RecyclerView.Adapter<a>
  implements b
{
  final c.e.d<androidx.fragment.app.Fragment> a = new SparseArray();
  boolean h = false;
  final FragmentManager j;
  final Lifecycle k;
  private final c.e.d<androidx.fragment.app.Fragment.SavedState> l = new SparseArray();
  private boolean m = false;
  private FragmentMaxLifecycleEnforcer q;
  private final c.e.d<Integer> v = new SparseArray();
  
  public FragmentStateAdapter(androidx.fragment.package_11.Fragment paramFragment)
  {
    this(paramFragment.getChildFragmentManager(), paramFragment.getLifecycle());
  }
  
  public FragmentStateAdapter(FragmentManager paramFragmentManager, Lifecycle paramLifecycle)
  {
    j = paramFragmentManager;
    k = paramLifecycle;
    super.setHasStableIds(true);
  }
  
  private void a(long paramLong)
  {
    androidx.fragment.package_11.Fragment localFragment = (androidx.fragment.package_11.Fragment)a.get(paramLong);
    if (localFragment == null) {
      return;
    }
    if (localFragment.getView() != null)
    {
      ViewParent localViewParent = localFragment.getView().getParent();
      if (localViewParent != null) {
        ((FrameLayout)localViewParent).removeAllViews();
      }
    }
    if (!get(paramLong)) {
      l.remove(paramLong);
    }
    if (!localFragment.isAdded())
    {
      a.remove(paramLong);
      return;
    }
    if (b())
    {
      m = true;
      return;
    }
    if ((localFragment.isAdded()) && (get(paramLong))) {
      l.put(paramLong, j.get(localFragment));
    }
    j.beginTransaction().add(localFragment).add();
    a.remove(paramLong);
  }
  
  private void a(final androidx.fragment.package_11.Fragment paramFragment, final FrameLayout paramFrameLayout)
  {
    j.b(new b(paramFragment, paramFrameLayout), false);
  }
  
  private void c(int paramInt)
  {
    long l1 = getItemId(paramInt);
    if (!a.put(l1))
    {
      androidx.fragment.package_11.Fragment localFragment = getItem(paramInt);
      localFragment.setInitialSavedState((androidx.fragment.package_11.Fragment.SavedState)l.get(l1));
      a.put(l1, localFragment);
    }
  }
  
  private static long getId(String paramString1, String paramString2)
  {
    return Long.parseLong(paramString1.substring(paramString2.length()));
  }
  
  private boolean getItem(long paramLong)
  {
    if (v.put(paramLong)) {
      return true;
    }
    java.lang.Object localObject = (androidx.fragment.package_11.Fragment)a.get(paramLong);
    if (localObject == null) {
      return false;
    }
    localObject = ((androidx.fragment.package_11.Fragment)localObject).getView();
    if (localObject == null) {
      return false;
    }
    return ((View)localObject).getParent() != null;
  }
  
  private static boolean isPrimitive(String paramString1, String paramString2)
  {
    return (paramString1.startsWith(paramString2)) && (paramString1.length() > paramString2.length());
  }
  
  private void startTimeout()
  {
    final Handler localHandler = new Handler(Looper.getMainLooper());
    final c localC = new c();
    k.a(new LayoutManager()
    {
      public void b(androidx.lifecycle.d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
      {
        if (paramAnonymousEvent == Lifecycle.Event.ON_DESTROY)
        {
          localHandler.removeCallbacks(localC);
          paramAnonymousD.getLifecycle().clear(this);
        }
      }
    });
    localHandler.postDelayed(localC, 10000L);
  }
  
  private Long toString(int paramInt)
  {
    java.lang.Object localObject1 = null;
    int i = 0;
    while (i < v.size())
    {
      java.lang.Object localObject2 = localObject1;
      if (((Integer)v.valueAt(i)).intValue() == paramInt) {
        if (localObject1 == null) {
          localObject2 = Long.valueOf(v.get(i));
        } else {
          throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private static String toString(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  void a()
  {
    if (m)
    {
      if (b()) {
        return;
      }
      java.lang.Object localObject = new TLongArrayList();
      int n = 0;
      int i = 0;
      long l1;
      while (i < a.size())
      {
        l1 = a.get(i);
        if (!get(l1))
        {
          ((Set)localObject).add(Long.valueOf(l1));
          v.remove(l1);
        }
        i += 1;
      }
      if (!h)
      {
        m = false;
        i = n;
        while (i < a.size())
        {
          l1 = a.get(i);
          if (!getItem(l1)) {
            ((Set)localObject).add(Long.valueOf(l1));
          }
          i += 1;
        }
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((Long)((Iterator)localObject).next()).longValue());
      }
    }
  }
  
  public final void a(Parcelable paramParcelable)
  {
    if ((l.get()) && (a.get()))
    {
      paramParcelable = (Bundle)paramParcelable;
      if (paramParcelable.getClassLoader() == null) {
        paramParcelable.setClassLoader(getClass().getClassLoader());
      }
      Iterator localIterator = paramParcelable.keySet().iterator();
      while (localIterator.hasNext())
      {
        java.lang.Object localObject = (String)localIterator.next();
        long l1;
        if (isPrimitive((String)localObject, "f#"))
        {
          l1 = getId((String)localObject, "f#");
          localObject = j.a(paramParcelable, (String)localObject);
          a.put(l1, localObject);
        }
        else if (isPrimitive((String)localObject, "s#"))
        {
          l1 = getId((String)localObject, "s#");
          localObject = (androidx.fragment.package_11.Fragment.SavedState)paramParcelable.getParcelable((String)localObject);
          if (get(l1)) {
            l.put(l1, localObject);
          }
        }
        else
        {
          paramParcelable = new StringBuilder();
          paramParcelable.append("Unexpected key in savedState: ");
          paramParcelable.append((String)localObject);
          throw new IllegalArgumentException(paramParcelable.toString());
        }
      }
      if (!a.get())
      {
        m = true;
        h = true;
        a();
        startTimeout();
      }
    }
    else
    {
      throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }
  }
  
  void a(View paramView, FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout.getChildCount() <= 1)
    {
      if (paramView.getParent() == paramFrameLayout) {
        return;
      }
      if (paramFrameLayout.getChildCount() > 0) {
        paramFrameLayout.removeAllViews();
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      paramFrameLayout.addView(paramView);
      return;
    }
    throw new IllegalStateException("Design assumption violated.");
  }
  
  void a(final Object paramObject)
  {
    androidx.fragment.package_11.Fragment localFragment = (androidx.fragment.package_11.Fragment)a.get(paramObject.getItemId());
    if (localFragment != null)
    {
      java.lang.Object localObject1 = paramObject.getValue();
      java.lang.Object localObject2 = localFragment.getView();
      if ((!localFragment.isAdded()) && (localObject2 != null)) {
        throw new IllegalStateException("Design assumption violated.");
      }
      if ((localFragment.isAdded()) && (localObject2 == null))
      {
        a(localFragment, (FrameLayout)localObject1);
        return;
      }
      if ((localFragment.isAdded()) && (((View)localObject2).getParent() != null))
      {
        if (((View)localObject2).getParent() != localObject1) {
          a((View)localObject2, (FrameLayout)localObject1);
        }
      }
      else
      {
        if (localFragment.isAdded())
        {
          a((View)localObject2, (FrameLayout)localObject1);
          return;
        }
        if (!b())
        {
          a(localFragment, (FrameLayout)localObject1);
          localObject1 = j.beginTransaction();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("f");
          ((StringBuilder)localObject2).append(paramObject.getItemId());
          ((Item)localObject1).add(localFragment, ((StringBuilder)localObject2).toString()).add(localFragment, Lifecycle.State.g).add();
          q.a(false);
          return;
        }
        if (j.isDestroyed()) {
          return;
        }
        k.a(new LayoutManager()
        {
          public void b(androidx.lifecycle.d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
          {
            if (b()) {
              return;
            }
            paramAnonymousD.getLifecycle().clear(this);
            if (ViewCompat.d(paramObject.getValue())) {
              a(paramObject);
            }
          }
        });
      }
    }
    else
    {
      throw new IllegalStateException("Design assumption violated.");
    }
  }
  
  public final void a(final Object paramObject, int paramInt)
  {
    long l1 = paramObject.getItemId();
    int i = paramObject.getValue().getId();
    java.lang.Object localObject = toString(i);
    if ((localObject != null) && (((Long)localObject).longValue() != l1))
    {
      a(((Long)localObject).longValue());
      v.remove(((Long)localObject).longValue());
    }
    v.put(l1, Integer.valueOf(i));
    c(paramInt);
    localObject = paramObject.getValue();
    if (ViewCompat.d((View)localObject)) {
      if (((View)localObject).getParent() == null) {
        ((View)localObject).addOnLayoutChangeListener(new a((FrameLayout)localObject, paramObject));
      } else {
        throw new IllegalStateException("Design assumption violated.");
      }
    }
    a();
  }
  
  public final void add(Object paramObject)
  {
    a(paramObject);
    a();
  }
  
  boolean b()
  {
    return j.b();
  }
  
  public final Object create(ViewGroup paramViewGroup, int paramInt)
  {
    return Object.init(paramViewGroup);
  }
  
  public final boolean delete4(Object paramObject)
  {
    return true;
  }
  
  public boolean get(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong < getItemCount());
  }
  
  public abstract androidx.fragment.package_11.Fragment getItem(int paramInt);
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    boolean bool;
    if (q == null) {
      bool = true;
    } else {
      bool = false;
    }
    Log.setText(bool);
    FragmentMaxLifecycleEnforcer localFragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
    q = localFragmentMaxLifecycleEnforcer;
    localFragmentMaxLifecycleEnforcer.b(paramRecyclerView);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    q.run(paramRecyclerView);
    q = null;
  }
  
  public final void remove(Object paramObject)
  {
    paramObject = toString(paramObject.getValue().getId());
    if (paramObject != null)
    {
      a(paramObject.longValue());
      v.remove(paramObject.longValue());
    }
  }
  
  public final Parcelable saveState()
  {
    Bundle localBundle = new Bundle(a.size() + l.size());
    int i1 = 0;
    int i = 0;
    int n;
    long l1;
    for (;;)
    {
      n = i1;
      if (i >= a.size()) {
        break;
      }
      l1 = a.get(i);
      androidx.fragment.package_11.Fragment localFragment = (androidx.fragment.package_11.Fragment)a.get(l1);
      if ((localFragment != null) && (localFragment.isAdded()))
      {
        String str = toString("f#", l1);
        j.putFragment(localBundle, str, localFragment);
      }
      i += 1;
    }
    while (n < l.size())
    {
      l1 = l.get(n);
      if (get(l1)) {
        localBundle.putParcelable(toString("s#", l1), (Parcelable)l.get(l1));
      }
      n += 1;
    }
    return localBundle;
  }
  
  class FragmentMaxLifecycleEnforcer
  {
    private ViewPager2 b;
    private long c = -1L;
    private LayoutManager h;
    private RecyclerView.i i;
    private ViewPager2.i j;
    
    FragmentMaxLifecycleEnforcer() {}
    
    private ViewPager2 a(RecyclerView paramRecyclerView)
    {
      paramRecyclerView = paramRecyclerView.getParent();
      if ((paramRecyclerView instanceof ViewPager2)) {
        return (ViewPager2)paramRecyclerView;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ViewPager2 instance. Got: ");
      localStringBuilder.append(paramRecyclerView);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    void a(boolean paramBoolean)
    {
      if (b()) {
        return;
      }
      if (b.getScrollState() != 0) {
        return;
      }
      if (!a.get())
      {
        if (getItemCount() == 0) {
          return;
        }
        int k = b.getCurrentItem();
        if (k >= getItemCount()) {
          return;
        }
        long l = getItemId(k);
        if ((l == c) && (!paramBoolean)) {
          return;
        }
        java.lang.Object localObject = (androidx.fragment.package_11.Fragment)a.get(l);
        if (localObject != null)
        {
          if (!((androidx.fragment.package_11.Fragment)localObject).isAdded()) {
            return;
          }
          c = l;
          Item localItem = j.beginTransaction();
          localObject = null;
          k = 0;
          while (k < a.size())
          {
            l = a.get(k);
            androidx.fragment.package_11.Fragment localFragment = (androidx.fragment.package_11.Fragment)a.valueAt(k);
            if (localFragment.isAdded())
            {
              if (l != c) {
                localItem.add(localFragment, Lifecycle.State.g);
              } else {
                localObject = localFragment;
              }
              if (l == c) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              }
              localFragment.setMenuVisibility(paramBoolean);
            }
            k += 1;
          }
          if (localObject != null) {
            localItem.add((androidx.fragment.package_11.Fragment)localObject, Lifecycle.State.y);
          }
          if (!localItem.remove()) {
            localItem.add();
          }
        }
      }
    }
    
    void b(RecyclerView paramRecyclerView)
    {
      b = a(paramRecyclerView);
      paramRecyclerView = new a();
      j = paramRecyclerView;
      b.b(paramRecyclerView);
      paramRecyclerView = new b();
      i = paramRecyclerView;
      registerAdapterDataObserver(paramRecyclerView);
      paramRecyclerView = new LayoutManager()
      {
        public void b(androidx.lifecycle.d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
        {
          a(false);
        }
      };
      h = paramRecyclerView;
      k.a(paramRecyclerView);
    }
    
    void run(RecyclerView paramRecyclerView)
    {
      a(paramRecyclerView).a(j);
      unregisterAdapterDataObserver(i);
      k.clear(h);
      b = null;
    }
    
    class a
      extends ViewPager2.i
    {
      a() {}
      
      public void a(int paramInt)
      {
        a(false);
      }
      
      public void b(int paramInt)
      {
        a(false);
      }
    }
    
    class b
      extends FragmentStateAdapter.d
    {
      b()
      {
        super();
      }
      
      public void onChanged()
      {
        a(true);
      }
    }
  }
  
  class a
    implements View.OnLayoutChangeListener
  {
    a(FrameLayout paramFrameLayout, Object paramObject) {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (val$layout.getParent() != null)
      {
        val$layout.removeOnLayoutChangeListener(this);
        a(paramObject);
      }
    }
  }
  
  class b
    extends FragmentManager.k
  {
    b(androidx.fragment.package_11.Fragment paramFragment, FrameLayout paramFrameLayout) {}
    
    public void a(FragmentManager paramFragmentManager, androidx.fragment.package_11.Fragment paramFragment, View paramView, Bundle paramBundle)
    {
      if (paramFragment == paramFragment)
      {
        paramFragmentManager.c(this);
        a(paramView, paramFrameLayout);
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      FragmentStateAdapter localFragmentStateAdapter = FragmentStateAdapter.this;
      h = false;
      localFragmentStateAdapter.a();
    }
  }
  
  private static abstract class d
    extends RecyclerView.i
  {
    private d() {}
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      onChanged();
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, java.lang.Object paramObject)
    {
      onChanged();
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      onChanged();
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      onChanged();
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      onChanged();
    }
  }
}

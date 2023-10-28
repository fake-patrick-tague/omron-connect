package androidx.fragment.package_11;

import android.view.View;
import android.view.ViewGroup;
import c.h.m.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import v7.v7.menu.h;
import v7.v7.package_13.ViewCompat;

abstract class SpecialEffectsController
{
  private final ViewGroup a;
  final ArrayList<androidx.fragment.app.SpecialEffectsController.Operation> c = new ArrayList();
  boolean d = false;
  boolean e = false;
  final ArrayList<androidx.fragment.app.SpecialEffectsController.Operation> m = new ArrayList();
  
  SpecialEffectsController(ViewGroup paramViewGroup)
  {
    a = paramViewGroup;
  }
  
  private Operation a(Fragment paramFragment)
  {
    Iterator localIterator = m.iterator();
    while (localIterator.hasNext())
    {
      Operation localOperation = (Operation)localIterator.next();
      if ((localOperation.next().equals(paramFragment)) && (!localOperation.getValue())) {
        return localOperation;
      }
    }
    return null;
  }
  
  static SpecialEffectsController a(ViewGroup paramViewGroup, FragmentManager paramFragmentManager)
  {
    return add(paramViewGroup, paramFragmentManager.getName());
  }
  
  private void a(SpecialEffectsController.Operation.State paramState, SpecialEffectsController.Operation.LifecycleImpact paramLifecycleImpact, Log paramLog)
  {
    ArrayList localArrayList = m;
    try
    {
      h localH = new h();
      Operation localOperation = a(paramLog.getValue());
      if (localOperation != null)
      {
        localOperation.a(paramState, paramLifecycleImpact);
        return;
      }
      paramState = new d(paramState, paramLifecycleImpact, paramLog, localH);
      m.add(paramState);
      paramState.a(new SpecialEffectsController.a(this, paramState));
      paramState.a(new SpecialEffectsController.b(this, paramState));
      return;
    }
    catch (Throwable paramState)
    {
      throw paramState;
    }
  }
  
  private Operation add(Fragment paramFragment)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Operation localOperation = (Operation)localIterator.next();
      if ((localOperation.next().equals(paramFragment)) && (!localOperation.getValue())) {
        return localOperation;
      }
    }
    return null;
  }
  
  static SpecialEffectsController add(ViewGroup paramViewGroup, Name paramName)
  {
    int i = v7.app.Fragment.view_offset_helper;
    Object localObject = paramViewGroup.getTag(i);
    if ((localObject instanceof SpecialEffectsController)) {
      return (SpecialEffectsController)localObject;
    }
    paramName = paramName.a(paramViewGroup);
    paramViewGroup.setTag(i, paramName);
    return paramName;
  }
  
  private void c()
  {
    Iterator localIterator = m.iterator();
    while (localIterator.hasNext())
    {
      Operation localOperation = (Operation)localIterator.next();
      if (localOperation.equals() == SpecialEffectsController.Operation.LifecycleImpact.b) {
        localOperation.a(SpecialEffectsController.Operation.State.b(localOperation.next().requireView().getVisibility()), SpecialEffectsController.Operation.LifecycleImpact.C);
      }
    }
  }
  
  SpecialEffectsController.Operation.LifecycleImpact a(Log paramLog)
  {
    Object localObject = a(paramLog.getValue());
    if (localObject != null) {
      localObject = ((Operation)localObject).equals();
    } else {
      localObject = null;
    }
    paramLog = add(paramLog.getValue());
    if ((paramLog != null) && ((localObject == null) || (localObject == SpecialEffectsController.Operation.LifecycleImpact.C))) {
      return paramLog.equals();
    }
    return localObject;
  }
  
  void a()
  {
    if (e) {
      return;
    }
    if (!ViewCompat.d(a))
    {
      add();
      d = false;
      return;
    }
    ArrayList localArrayList = m;
    try
    {
      if (!m.isEmpty())
      {
        Object localObject1 = new ArrayList(c);
        c.clear();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Operation)((Iterator)localObject1).next();
          if (FragmentManager.get(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("SpecialEffectsController: Cancelling operation ");
            localStringBuilder.append(localObject2);
            android.util.Log.v("FragmentManager", localStringBuilder.toString());
          }
          ((Operation)localObject2).b();
          if (!((Operation)localObject2).c()) {
            c.add(localObject2);
          }
        }
        c();
        localObject1 = new ArrayList(m);
        m.clear();
        c.addAll((Collection)localObject1);
        if (FragmentManager.get(2)) {
          android.util.Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
        }
        Object localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Operation)((Iterator)localObject2).next()).add();
        }
        a((List)localObject1, d);
        d = false;
        if (FragmentManager.get(2)) {
          android.util.Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void a(SpecialEffectsController.Operation.State paramState, Log paramLog)
  {
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing add operation for fragment ");
      localStringBuilder.append(paramLog.getValue());
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(paramState, SpecialEffectsController.Operation.LifecycleImpact.b, paramLog);
  }
  
  abstract void a(List paramList, boolean paramBoolean);
  
  void add()
  {
    if (FragmentManager.get(2)) {
      android.util.Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
    }
    boolean bool = ViewCompat.d(a);
    ArrayList localArrayList = m;
    try
    {
      c();
      Object localObject = m.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Operation)((Iterator)localObject).next()).add();
      }
      Iterator localIterator = new ArrayList(c).iterator();
      Operation localOperation;
      StringBuilder localStringBuilder;
      while (localIterator.hasNext())
      {
        localOperation = (Operation)localIterator.next();
        if (FragmentManager.get(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SpecialEffectsController: ");
          if (bool)
          {
            localObject = "";
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Container ");
            ((StringBuilder)localObject).append(a);
            ((StringBuilder)localObject).append(" is not attached to window. ");
            localObject = ((StringBuilder)localObject).toString();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("Cancelling running operation ");
          localStringBuilder.append(localOperation);
          android.util.Log.v("FragmentManager", localStringBuilder.toString());
        }
        localOperation.b();
      }
      localIterator = new ArrayList(m).iterator();
      while (localIterator.hasNext())
      {
        localOperation = (Operation)localIterator.next();
        if (FragmentManager.get(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SpecialEffectsController: ");
          if (bool)
          {
            localObject = "";
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Container ");
            ((StringBuilder)localObject).append(a);
            ((StringBuilder)localObject).append(" is not attached to window. ");
            localObject = ((StringBuilder)localObject).toString();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("Cancelling pending operation ");
          localStringBuilder.append(localOperation);
          android.util.Log.v("FragmentManager", localStringBuilder.toString());
        }
        localOperation.b();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void b()
  {
    if (e)
    {
      if (FragmentManager.get(2)) {
        android.util.Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
      }
      e = false;
      a();
    }
  }
  
  void b(Log paramLog)
  {
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
      localStringBuilder.append(paramLog.getValue());
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(SpecialEffectsController.Operation.State.a, SpecialEffectsController.Operation.LifecycleImpact.C, paramLog);
  }
  
  void c(Log paramLog)
  {
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
      localStringBuilder.append(paramLog.getValue());
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(SpecialEffectsController.Operation.State.i, SpecialEffectsController.Operation.LifecycleImpact.d, paramLog);
  }
  
  void d(Log paramLog)
  {
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SpecialEffectsController: Enqueuing show operation for fragment ");
      localStringBuilder.append(paramLog.getValue());
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
    a(SpecialEffectsController.Operation.State.b, SpecialEffectsController.Operation.LifecycleImpact.C, paramLog);
  }
  
  public ViewGroup getValue()
  {
    return a;
  }
  
  void run()
  {
    ArrayList localArrayList = m;
    for (;;)
    {
      int i;
      try
      {
        c();
        e = false;
        i = m.size() - 1;
        if (i >= 0)
        {
          Operation localOperation = (Operation)m.get(i);
          SpecialEffectsController.Operation.State localState1 = SpecialEffectsController.Operation.State.a(nextmView);
          SpecialEffectsController.Operation.State localState2 = localOperation.get();
          SpecialEffectsController.Operation.State localState3 = SpecialEffectsController.Operation.State.b;
          if ((localState2 != localState3) || (localState1 == localState3)) {
            break label101;
          }
          e = localOperation.next().isPostponed();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      label101:
      i -= 1;
    }
  }
  
  void setValue(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  class Operation
  {
    private boolean b = false;
    private final List<Runnable> c = new ArrayList();
    private LifecycleImpact d;
    private final Fragment g;
    private boolean i = false;
    private final HashSet<e> l = new HashSet();
    
    Operation(LifecycleImpact paramLifecycleImpact, Fragment paramFragment, h paramH)
    {
      d = paramLifecycleImpact;
      g = paramFragment;
      paramH.a(new SpecialEffectsController.Operation.a(this));
    }
    
    public void a()
    {
      if (i) {
        return;
      }
      if (FragmentManager.get(2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SpecialEffectsController: ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" has called complete.");
        android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
      }
      i = true;
      Object localObject = c.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
    
    final void a(State paramState, LifecycleImpact paramLifecycleImpact)
    {
      int j = SpecialEffectsController.c.b[paramLifecycleImpact.ordinal()];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return;
          }
          if (SpecialEffectsController.this != State.i)
          {
            if (FragmentManager.get(2))
            {
              paramLifecycleImpact = new StringBuilder();
              paramLifecycleImpact.append("SpecialEffectsController: For fragment ");
              paramLifecycleImpact.append(g);
              paramLifecycleImpact.append(" mFinalState = ");
              paramLifecycleImpact.append(SpecialEffectsController.this);
              paramLifecycleImpact.append(" -> ");
              paramLifecycleImpact.append(paramState);
              paramLifecycleImpact.append(". ");
              android.util.Log.v("FragmentManager", paramLifecycleImpact.toString());
            }
            a = paramState;
          }
        }
        else
        {
          if (FragmentManager.get(2))
          {
            paramState = new StringBuilder();
            paramState.append("SpecialEffectsController: For fragment ");
            paramState.append(g);
            paramState.append(" mFinalState = ");
            paramState.append(SpecialEffectsController.this);
            paramState.append(" -> REMOVED. mLifecycleImpact  = ");
            paramState.append(d);
            paramState.append(" to REMOVING.");
            android.util.Log.v("FragmentManager", paramState.toString());
          }
          a = State.i;
          d = LifecycleImpact.d;
        }
      }
      else if (SpecialEffectsController.this == State.i)
      {
        if (FragmentManager.get(2))
        {
          paramState = new StringBuilder();
          paramState.append("SpecialEffectsController: For fragment ");
          paramState.append(g);
          paramState.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
          paramState.append(d);
          paramState.append(" to ADDING.");
          android.util.Log.v("FragmentManager", paramState.toString());
        }
        a = State.b;
        d = LifecycleImpact.b;
      }
    }
    
    final void a(Runnable paramRunnable)
    {
      c.add(paramRunnable);
    }
    
    public final void a(h paramH)
    {
      add();
      l.add(paramH);
    }
    
    void add() {}
    
    final void b()
    {
      if (getValue()) {
        return;
      }
      b = true;
      if (l.isEmpty())
      {
        a();
        return;
      }
      Iterator localIterator = new ArrayList(l).iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a();
      }
    }
    
    public final void b(h paramH)
    {
      if ((l.remove(paramH)) && (l.isEmpty())) {
        a();
      }
    }
    
    final boolean c()
    {
      return i;
    }
    
    LifecycleImpact equals()
    {
      return d;
    }
    
    public State get()
    {
      return SpecialEffectsController.this;
    }
    
    final boolean getValue()
    {
      return b;
    }
    
    public final Fragment next()
    {
      return g;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Operation ");
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append("} ");
      localStringBuilder.append("{");
      localStringBuilder.append("mFinalState = ");
      localStringBuilder.append(SpecialEffectsController.this);
      localStringBuilder.append("} ");
      localStringBuilder.append("{");
      localStringBuilder.append("mLifecycleImpact = ");
      localStringBuilder.append(d);
      localStringBuilder.append("} ");
      localStringBuilder.append("{");
      localStringBuilder.append("mFragment = ");
      localStringBuilder.append(g);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    enum LifecycleImpact
    {
      static
      {
        LifecycleImpact localLifecycleImpact1 = new LifecycleImpact("NONE", 0);
        C = localLifecycleImpact1;
        LifecycleImpact localLifecycleImpact2 = new LifecycleImpact("ADDING", 1);
        b = localLifecycleImpact2;
        LifecycleImpact localLifecycleImpact3 = new LifecycleImpact("REMOVING", 2);
        d = localLifecycleImpact3;
        a = new LifecycleImpact[] { localLifecycleImpact1, localLifecycleImpact2, localLifecycleImpact3 };
      }
    }
    
    enum State
    {
      static
      {
        State localState1 = new State("REMOVED", 0);
        i = localState1;
        State localState2 = new State("VISIBLE", 1);
        b = localState2;
        State localState3 = new State("GONE", 2);
        a = localState3;
        State localState4 = new State("INVISIBLE", 3);
        c = localState4;
        d = new State[] { localState1, localState2, localState3, localState4 };
      }
      
      static State a(View paramView)
      {
        if ((paramView.getAlpha() == 0.0F) && (paramView.getVisibility() == 0)) {
          return c;
        }
        return b(paramView.getVisibility());
      }
      
      static State b(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 4)
          {
            if (paramInt == 8) {
              return a;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown visibility ");
            localStringBuilder.append(paramInt);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          return c;
        }
        return b;
      }
      
      void set(View paramView)
      {
        int j = SpecialEffectsController.c.d[ordinal()];
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4) {
                return;
              }
              if (FragmentManager.get(2))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("SpecialEffectsController: Setting view ");
                ((StringBuilder)localObject).append(paramView);
                ((StringBuilder)localObject).append(" to INVISIBLE");
                android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
              }
              paramView.setVisibility(4);
              return;
            }
            if (FragmentManager.get(2))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("SpecialEffectsController: Setting view ");
              ((StringBuilder)localObject).append(paramView);
              ((StringBuilder)localObject).append(" to GONE");
              android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
            }
            paramView.setVisibility(8);
            return;
          }
          if (FragmentManager.get(2))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("SpecialEffectsController: Setting view ");
            ((StringBuilder)localObject).append(paramView);
            ((StringBuilder)localObject).append(" to VISIBLE");
            android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
          }
          paramView.setVisibility(0);
          return;
        }
        Object localObject = (ViewGroup)paramView.getParent();
        if (localObject != null)
        {
          if (FragmentManager.get(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("SpecialEffectsController: Removing view ");
            localStringBuilder.append(paramView);
            localStringBuilder.append(" from container ");
            localStringBuilder.append(localObject);
            android.util.Log.v("FragmentManager", localStringBuilder.toString());
          }
          ((ViewGroup)localObject).removeView(paramView);
        }
      }
    }
  }
  
  class d
    extends SpecialEffectsController.Operation
  {
    private final Log a;
    
    d(SpecialEffectsController.Operation.LifecycleImpact paramLifecycleImpact, Log paramLog, h paramH)
    {
      super(paramLifecycleImpact, paramLog.getValue(), paramH);
      a = paramLog;
    }
    
    public void a()
    {
      super.a();
      a.run();
    }
    
    void add()
    {
      Fragment localFragment;
      View localView;
      StringBuilder localStringBuilder;
      if (equals() == SpecialEffectsController.Operation.LifecycleImpact.b)
      {
        localFragment = a.getValue();
        localView = mView.findFocus();
        if (localView != null)
        {
          localFragment.setFocusedView(localView);
          if (FragmentManager.get(2))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("requestFocus: Saved focused view ");
            localStringBuilder.append(localView);
            localStringBuilder.append(" for Fragment ");
            localStringBuilder.append(localFragment);
            android.util.Log.v("FragmentManager", localStringBuilder.toString());
          }
        }
        localView = next().requireView();
        if (localView.getParent() == null)
        {
          a.e();
          localView.setAlpha(0.0F);
        }
        if ((localView.getAlpha() == 0.0F) && (localView.getVisibility() == 0)) {
          localView.setVisibility(4);
        }
        localView.setAlpha(localFragment.getPostOnViewCreatedAlpha());
        return;
      }
      if (equals() == SpecialEffectsController.Operation.LifecycleImpact.d)
      {
        localFragment = a.getValue();
        localView = localFragment.requireView();
        if (FragmentManager.get(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Clearing focus ");
          localStringBuilder.append(localView.findFocus());
          localStringBuilder.append(" on view ");
          localStringBuilder.append(localView);
          localStringBuilder.append(" for Fragment ");
          localStringBuilder.append(localFragment);
          android.util.Log.v("FragmentManager", localStringBuilder.toString());
        }
        localView.clearFocus();
      }
    }
  }
}

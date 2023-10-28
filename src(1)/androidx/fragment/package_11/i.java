package androidx.fragment.package_11;

class i
  extends h
{
  private final Object e;
  private final boolean p;
  private final Object s;
  
  i(SpecialEffectsController.Operation paramOperation, v7.v7.menu.h paramH, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramOperation, paramH);
    if (paramOperation.get() == SpecialEffectsController.Operation.State.b)
    {
      if (paramBoolean1) {
        paramH = paramOperation.next().getReenterTransition();
      } else {
        paramH = paramOperation.next().getEnterTransition();
      }
      e = paramH;
      boolean bool;
      if (paramBoolean1) {
        bool = paramOperation.next().getAllowReturnTransitionOverlap();
      } else {
        bool = paramOperation.next().getAllowEnterTransitionOverlap();
      }
      p = bool;
    }
    else
    {
      if (paramBoolean1) {
        paramH = paramOperation.next().getReturnTransition();
      } else {
        paramH = paramOperation.next().getExitTransition();
      }
      e = paramH;
      p = true;
    }
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        s = paramOperation.next().getSharedElementReturnTransition();
        return;
      }
      s = paramOperation.next().getSharedElementEnterTransition();
      return;
    }
    s = null;
  }
  
  private FragmentTransitionCompat21 a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Object localObject = Frame.d;
    if ((localObject != null) && (((FragmentTransitionCompat21)localObject).toString(paramObject))) {
      return localObject;
    }
    localObject = Frame.g;
    if ((localObject != null) && (((FragmentTransitionCompat21)localObject).toString(paramObject))) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Transition ");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append(" for fragment ");
    ((StringBuilder)localObject).append(a().next());
    ((StringBuilder)localObject).append(" is not a valid framework Transition or AndroidX Transition");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  FragmentTransitionCompat21 b()
  {
    Object localObject = a(e);
    FragmentTransitionCompat21 localFragmentTransitionCompat21 = a(s);
    if ((localObject != null) && (localFragmentTransitionCompat21 != null) && (localObject != localFragmentTransitionCompat21))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
      ((StringBuilder)localObject).append(a().next());
      ((StringBuilder)localObject).append(" returned Transition ");
      ((StringBuilder)localObject).append(e);
      ((StringBuilder)localObject).append(" which uses a different Transition  type than its shared element transition ");
      ((StringBuilder)localObject).append(s);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (localObject != null) {
      return localObject;
    }
    return localFragmentTransitionCompat21;
  }
  
  public Object d()
  {
    return s;
  }
  
  Object getItem()
  {
    return e;
  }
  
  public boolean j()
  {
    return s != null;
  }
  
  boolean k()
  {
    return p;
  }
}

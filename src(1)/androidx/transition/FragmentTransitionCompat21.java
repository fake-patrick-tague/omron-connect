package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionCompat21
  extends androidx.fragment.package_11.FragmentTransitionCompat21
{
  public FragmentTransitionCompat21() {}
  
  private static boolean hasSimpleTarget(Transition paramTransition)
  {
    return (!androidx.fragment.package_11.FragmentTransitionCompat21.isNullOrEmpty(paramTransition.apply())) || (!androidx.fragment.package_11.FragmentTransitionCompat21.isNullOrEmpty(paramTransition.select())) || (!androidx.fragment.package_11.FragmentTransitionCompat21.isNullOrEmpty(paramTransition.getId()));
  }
  
  public void addTargets(Object paramObject, ArrayList paramArrayList)
  {
    paramObject = (Transition)paramObject;
    if (paramObject == null) {
      return;
    }
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.size();
      while (i < j)
      {
        addTargets(paramObject.get(i), paramArrayList);
        i += 1;
      }
    }
    if ((!hasSimpleTarget(paramObject)) && (androidx.fragment.package_11.FragmentTransitionCompat21.isNullOrEmpty(paramObject.get())))
    {
      int k = paramArrayList.size();
      i = j;
      while (i < k)
      {
        paramObject.get((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    i.a(paramViewGroup, (Transition)paramObject);
  }
  
  public void build(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3)
  {
    ((Transition)paramObject1).next(new FragmentTransitionCompat21.4(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public void draw(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).update(new Scale(this, paramRect));
    }
  }
  
  public void draw(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      Rect localRect = new Rect();
      draw(paramView, localRect);
      paramObject.update(new BoxModel(this, localRect));
    }
  }
  
  public Object get(Object paramObject)
  {
    if (paramObject != null) {
      return ((Transition)paramObject).set();
    }
    return null;
  }
  
  public Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().init(paramObject1).init(paramObject2).close(1);
    } else if (paramObject1 == null) {
      if (paramObject2 != null) {
        paramObject1 = paramObject2;
      } else {
        paramObject1 = null;
      }
    }
    if (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.init(paramObject1);
      }
      paramObject2.init(paramObject3);
      return paramObject2;
    }
    return paramObject1;
  }
  
  public Object read(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.init((Transition)paramObject);
    return localTransitionSet;
  }
  
  public Object read(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.init((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.init((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.init((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public void recycle(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).get(paramView);
    }
  }
  
  public void recycle(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    ((Transition)paramObject).next(new MethodWriter(this, paramView, paramArrayList));
  }
  
  public void removeTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramObject = (Transition)paramObject;
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.size();
      while (i < j)
      {
        removeTargets(paramObject.get(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!hasSimpleTarget(paramObject))
    {
      List localList = paramObject.get();
      if ((localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {
          i = 0;
        } else {
          i = paramArrayList2.size();
        }
        while (j < i)
        {
          paramObject.get((View)paramArrayList2.get(j));
          j += 1;
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.setTarget((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public void setSharedElementTargets(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = paramObject.get();
    localList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      androidx.fragment.package_11.FragmentTransitionCompat21.bfsAddViewChildren(localList, (View)paramArrayList.get(i));
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public void setSharedElementTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.get().clear();
      paramObject.get().addAll(paramArrayList2);
      removeTargets(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public boolean toString(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
}

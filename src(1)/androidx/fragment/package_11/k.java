package androidx.fragment.package_11;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;
import v7.v7.package_13.DeferredRequestCreator;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.aa;

class k
  extends SpecialEffectsController
{
  k(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private Map a(List paramList1, List paramList2, boolean paramBoolean, SpecialEffectsController.Operation paramOperation1, SpecialEffectsController.Operation paramOperation2)
  {
    SpecialEffectsController.Operation localOperation2 = paramOperation1;
    SpecialEffectsController.Operation localOperation1 = paramOperation2;
    HashMap localHashMap = new HashMap();
    Object localObject3 = paramList1.iterator();
    Object localObject2 = null;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (i)((Iterator)localObject3).next();
      if (!((h)localObject4).f())
      {
        localObject1 = ((i)localObject4).b();
        if (localObject2 == null)
        {
          localObject2 = localObject1;
        }
        else if ((localObject1 != null) && (localObject2 != localObject1))
        {
          paramList1 = new StringBuilder();
          paramList1.append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
          paramList1.append(((h)localObject4).a().next());
          paramList1.append(" returned Transition ");
          paramList1.append(((i)localObject4).getItem());
          paramList1.append(" which uses a different Transition  type than other Fragments.");
          throw new IllegalArgumentException(paramList1.toString());
        }
      }
    }
    if (localObject2 == null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (i)paramList1.next();
        localHashMap.put(paramList2.a(), Boolean.FALSE);
        paramList2.e();
      }
      return localHashMap;
    }
    Object localObject4 = new View(getValue().getContext());
    Rect localRect = new Rect();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayMap localArrayMap = new ArrayMap();
    Object localObject7 = paramList1.iterator();
    Object localObject5 = null;
    Object localObject1 = null;
    int i = 0;
    localObject3 = localObject2;
    Object localObject6;
    int j;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    for (;;)
    {
      boolean bool = paramBoolean;
      if (!((Iterator)localObject7).hasNext()) {
        break;
      }
      localObject2 = (i)((Iterator)localObject7).next();
      if ((((i)localObject2).j()) && (localOperation2 != null) && (localOperation1 != null))
      {
        localObject6 = ((FragmentTransitionCompat21)localObject3).read(((FragmentTransitionCompat21)localObject3).get(((i)localObject2).d()));
        localObject8 = paramOperation2.next().getSharedElementSourceNames();
        localObject2 = paramOperation1.next().getSharedElementSourceNames();
        localObject5 = paramOperation1.next().getSharedElementTargetNames();
        j = 0;
        while (j < ((ArrayList)localObject5).size())
        {
          k = ((ArrayList)localObject8).indexOf(((ArrayList)localObject5).get(j));
          if (k != -1) {
            ((ArrayList)localObject8).set(k, (String)((ArrayList)localObject2).get(j));
          }
          j += 1;
        }
        localObject9 = paramOperation2.next().getSharedElementTargetNames();
        if (!bool)
        {
          localObject5 = paramOperation1.next().getExitTransitionCallback();
          localObject2 = paramOperation2.next().getEnterTransitionCallback();
        }
        else
        {
          localObject5 = paramOperation1.next().getEnterTransitionCallback();
          localObject2 = paramOperation2.next().getExitTransitionCallback();
        }
        int k = ((ArrayList)localObject8).size();
        j = 0;
        while (j < k)
        {
          localArrayMap.put((String)((ArrayList)localObject8).get(j), (String)((ArrayList)localObject9).get(j));
          j += 1;
        }
        if (FragmentManager.get(2))
        {
          android.util.Log.v("FragmentManager", ">>> entering view names <<<");
          localObject10 = ((ArrayList)localObject9).iterator();
          StringBuilder localStringBuilder;
          while (((Iterator)localObject10).hasNext())
          {
            localObject11 = (String)((Iterator)localObject10).next();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Name: ");
            localStringBuilder.append((String)localObject11);
            android.util.Log.v("FragmentManager", localStringBuilder.toString());
          }
          android.util.Log.v("FragmentManager", ">>> exiting view names <<<");
          localObject10 = ((ArrayList)localObject8).iterator();
          while (((Iterator)localObject10).hasNext())
          {
            localObject11 = (String)((Iterator)localObject10).next();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Name: ");
            localStringBuilder.append((String)localObject11);
            android.util.Log.v("FragmentManager", localStringBuilder.toString());
          }
        }
        localObject10 = new ArrayMap();
        a((Map)localObject10, nextmView);
        ((ArrayMap)localObject10).remove((Collection)localObject8);
        if (localObject5 != null)
        {
          if (FragmentManager.get(2))
          {
            paramList1 = new StringBuilder();
            paramList1.append("Executing exit callback for operation ");
            paramList1.append(localOperation2);
            android.util.Log.v("FragmentManager", paramList1.toString());
          }
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
        localArrayMap.remove(((ArrayMap)localObject10).keySet());
        localObject5 = new ArrayMap();
        a((Map)localObject5, nextmView);
        ((ArrayMap)localObject5).remove((Collection)localObject9);
        ((ArrayMap)localObject5).remove(localArrayMap.values());
        if (localObject2 != null)
        {
          if (FragmentManager.get(2))
          {
            paramList1 = new StringBuilder();
            paramList1.append("Executing enter callback for operation ");
            paramList1.append(localOperation1);
            android.util.Log.v("FragmentManager", paramList1.toString());
          }
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
        Frame.remove(localArrayMap, (ArrayMap)localObject5);
        a((ArrayMap)localObject10, localArrayMap.keySet());
        a((ArrayMap)localObject5, localArrayMap.values());
        if (localArrayMap.isEmpty())
        {
          localArrayList1.clear();
          localArrayList2.clear();
          localObject2 = null;
        }
        else
        {
          Frame.a(paramOperation2.next(), paramOperation1.next(), bool, (ArrayMap)localObject10, true);
          DeferredRequestCreator.get(getValue(), new Slider(this, paramOperation2, paramOperation1, paramBoolean, (ArrayMap)localObject5));
          localArrayList1.addAll(((ArrayMap)localObject10).values());
          if (!((ArrayList)localObject8).isEmpty())
          {
            localObject1 = (View)((SimpleArrayMap)localObject10).get((String)((ArrayList)localObject8).get(0));
            ((FragmentTransitionCompat21)localObject3).draw(localObject6, (View)localObject1);
          }
          localArrayList2.addAll(((ArrayMap)localObject5).values());
          if (!((ArrayList)localObject9).isEmpty())
          {
            localObject2 = (View)((SimpleArrayMap)localObject5).get((String)((ArrayList)localObject9).get(0));
            if (localObject2 != null)
            {
              DeferredRequestCreator.get(getValue(), new b(this, (FragmentTransitionCompat21)localObject3, (View)localObject2, localRect));
              i = 1;
            }
          }
          ((FragmentTransitionCompat21)localObject3).setSharedElementTargets(localObject6, (View)localObject4, localArrayList1);
          localObject2 = localObject6;
          ((FragmentTransitionCompat21)localObject3).build(localObject6, null, null, null, null, localObject6, localArrayList2);
          localObject5 = Boolean.TRUE;
          localOperation2 = paramOperation1;
          localHashMap.put(paramOperation1, localObject5);
          localOperation1 = paramOperation2;
          localHashMap.put(paramOperation2, localObject5);
        }
      }
      else
      {
        localObject2 = localObject5;
      }
      localObject5 = localObject2;
    }
    paramOperation1 = (SpecialEffectsController.Operation)localObject1;
    localObject7 = new ArrayList();
    Object localObject8 = paramList1.iterator();
    localObject1 = null;
    paramOperation2 = null;
    if (((Iterator)localObject8).hasNext())
    {
      localObject9 = (i)((Iterator)localObject8).next();
      if (((h)localObject9).f())
      {
        localHashMap.put(((h)localObject9).a(), Boolean.FALSE);
        ((h)localObject9).e();
      }
      for (;;)
      {
        break;
        localObject6 = ((FragmentTransitionCompat21)localObject3).get(((i)localObject9).getItem());
        localObject2 = ((h)localObject9).a();
        if ((localObject5 != null) && ((localObject2 == localOperation2) || (localObject2 == localOperation1))) {
          j = 1;
        } else {
          j = 0;
        }
        if (localObject6 == null)
        {
          if (j == 0)
          {
            localHashMap.put(localObject2, Boolean.FALSE);
            ((h)localObject9).e();
          }
        }
        else
        {
          localObject10 = new ArrayList();
          a((ArrayList)localObject10, nextmView);
          if (j != 0) {
            if (localObject2 == localOperation2) {
              ((ArrayList)localObject10).removeAll(localArrayList1);
            } else {
              ((ArrayList)localObject10).removeAll(localArrayList2);
            }
          }
          if (((ArrayList)localObject10).isEmpty())
          {
            ((FragmentTransitionCompat21)localObject3).recycle(localObject6, (View)localObject4);
          }
          else
          {
            ((FragmentTransitionCompat21)localObject3).addTargets(localObject6, (ArrayList)localObject10);
            ((FragmentTransitionCompat21)localObject3).build(localObject6, localObject6, (ArrayList)localObject10, null, null, null, null);
            if (((SpecialEffectsController.Operation)localObject2).get() == SpecialEffectsController.Operation.State.a)
            {
              paramList2.remove(localObject2);
              localObject11 = new ArrayList((Collection)localObject10);
              ((ArrayList)localObject11).remove(nextmView);
              ((FragmentTransitionCompat21)localObject3).recycle(localObject6, nextmView, (ArrayList)localObject11);
              DeferredRequestCreator.get(getValue(), new EventInfoFragment.1(this, (ArrayList)localObject10));
            }
          }
          if (((SpecialEffectsController.Operation)localObject2).get() == SpecialEffectsController.Operation.State.b)
          {
            ((ArrayList)localObject7).addAll((Collection)localObject10);
            if (i != 0) {
              ((FragmentTransitionCompat21)localObject3).draw(localObject6, localRect);
            }
          }
          else
          {
            ((FragmentTransitionCompat21)localObject3).draw(localObject6, paramOperation1);
          }
          localHashMap.put(localObject2, Boolean.TRUE);
          if (((i)localObject9).k()) {
            paramOperation2 = ((FragmentTransitionCompat21)localObject3).read(paramOperation2, localObject6, null);
          } else {
            localObject1 = ((FragmentTransitionCompat21)localObject3).read(localObject1, localObject6, null);
          }
        }
      }
    }
    paramList2 = "FragmentManager";
    paramOperation1 = ((FragmentTransitionCompat21)localObject3).mergeTransitions(paramOperation2, localObject1, localObject5);
    if (paramOperation1 == null) {
      return localHashMap;
    }
    paramOperation2 = paramList1.iterator();
    paramList1 = paramList2;
    label1863:
    while (paramOperation2.hasNext())
    {
      paramList2 = (i)paramOperation2.next();
      if (!paramList2.f())
      {
        localObject2 = paramList2.getItem();
        localObject1 = paramList2.a();
        if ((localObject5 != null) && ((localObject1 == localOperation2) || (localObject1 == localOperation1))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((localObject2 == null) && (i == 0)) {
          break label1863;
        }
        if (!ViewCompat.set(getValue()))
        {
          if (FragmentManager.get(2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("SpecialEffectsController: Container ");
            ((StringBuilder)localObject2).append(getValue());
            ((StringBuilder)localObject2).append(" has not been laid out. Completing operation ");
            ((StringBuilder)localObject2).append(localObject1);
            android.util.Log.v(paramList1, ((StringBuilder)localObject2).toString());
          }
          paramList2.e();
        }
        else
        {
          ((FragmentTransitionCompat21)localObject3).a(paramList2.a().next(), paramOperation1, paramList2.c(), new Plot.a(this, paramList2, (SpecialEffectsController.Operation)localObject1));
        }
      }
    }
    if (!ViewCompat.set(getValue())) {
      return localHashMap;
    }
    Frame.a((ArrayList)localObject7, 4);
    paramList2 = ((FragmentTransitionCompat21)localObject3).a(localArrayList2);
    if (FragmentManager.get(2))
    {
      android.util.Log.v(paramList1, ">>>>> Beginning transition <<<<<");
      android.util.Log.v(paramList1, ">>>>> SharedElementFirstOutViews <<<<<");
      paramOperation2 = localArrayList1.iterator();
      while (paramOperation2.hasNext())
      {
        localObject1 = (View)paramOperation2.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("View: ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" Name: ");
        ((StringBuilder)localObject2).append(ViewCompat.get((View)localObject1));
        android.util.Log.v(paramList1, ((StringBuilder)localObject2).toString());
      }
      android.util.Log.v(paramList1, ">>>>> SharedElementLastInViews <<<<<");
      paramOperation2 = localArrayList2.iterator();
      while (paramOperation2.hasNext())
      {
        localObject1 = (View)paramOperation2.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("View: ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" Name: ");
        ((StringBuilder)localObject2).append(ViewCompat.get((View)localObject1));
        android.util.Log.v(paramList1, ((StringBuilder)localObject2).toString());
      }
    }
    ((FragmentTransitionCompat21)localObject3).beginDelayedTransition(getValue(), paramOperation1);
    ((FragmentTransitionCompat21)localObject3).a(getValue(), localArrayList1, localArrayList2, paramList2, localArrayMap);
    Frame.a((ArrayList)localObject7, 0);
    ((FragmentTransitionCompat21)localObject3).setSharedElementTargets(localObject5, localArrayList1, localArrayList2);
    return localHashMap;
  }
  
  private void a(List paramList1, List paramList2, boolean paramBoolean, Map paramMap)
  {
    ViewGroup localViewGroup = getValue();
    Context localContext = localViewGroup.getContext();
    Object localObject1 = new ArrayList();
    paramList1 = paramList1.iterator();
    int i = 0;
    int j;
    Object localObject2;
    for (;;)
    {
      boolean bool = paramList1.hasNext();
      j = 2;
      if (!bool) {
        break;
      }
      localObject2 = (XYPlot)paramList1.next();
      if (((h)localObject2).f()) {
        ((h)localObject2).e();
      }
      Object localObject3;
      for (;;)
      {
        break;
        localObject3 = ((XYPlot)localObject2).a(localContext);
        if (localObject3 == null)
        {
          ((h)localObject2).e();
        }
        else
        {
          localObject3 = a;
          if (localObject3 != null) {
            break label120;
          }
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      label120:
      SpecialEffectsController.Operation localOperation = ((h)localObject2).a();
      Object localObject4 = localOperation.next();
      if (Boolean.TRUE.equals(paramMap.get(localOperation)))
      {
        if (FragmentManager.get(2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Ignoring Animator set on ");
          ((StringBuilder)localObject3).append(localObject4);
          ((StringBuilder)localObject3).append(" as this Fragment was involved in a Transition.");
          android.util.Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
        }
        ((h)localObject2).e();
      }
      else
      {
        if (localOperation.get() == SpecialEffectsController.Operation.State.a) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          paramList2.remove(localOperation);
        }
        localObject4 = mView;
        localViewGroup.startViewTransition((View)localObject4);
        ((Animator)localObject3).addListener(new TwoCardOverlayAnimation.3(this, localViewGroup, (View)localObject4, bool, localOperation, (XYPlot)localObject2));
        ((Animator)localObject3).setTarget(localObject4);
        ((Animator)localObject3).start();
        if (FragmentManager.get(2))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("Animator from operation ");
          ((StringBuilder)localObject4).append(localOperation);
          ((StringBuilder)localObject4).append(" has started.");
          android.util.Log.v("FragmentManager", ((StringBuilder)localObject4).toString());
        }
        ((h)localObject2).c().a(new l(this, (Animator)localObject3, localOperation));
        i = 1;
      }
    }
    paramList1 = ((ArrayList)localObject1).iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (XYPlot)paramList1.next();
      paramMap = paramList2.a();
      localObject1 = paramMap.next();
      if (paramBoolean)
      {
        if (FragmentManager.get(j))
        {
          paramMap = new StringBuilder();
          paramMap.append("Ignoring Animation set on ");
          paramMap.append(localObject1);
          paramMap.append(" as Animations cannot run alongside Transitions.");
          android.util.Log.v("FragmentManager", paramMap.toString());
        }
        paramList2.e();
      }
      else if (i != 0)
      {
        if (FragmentManager.get(j))
        {
          paramMap = new StringBuilder();
          paramMap.append("Ignoring Animation set on ");
          paramMap.append(localObject1);
          paramMap.append(" as Animations cannot run alongside Animators.");
          android.util.Log.v("FragmentManager", paramMap.toString());
        }
        paramList2.e();
      }
      else
      {
        localObject1 = mView;
        localObject2 = (Animation)v7.v7.util.Log.valueOf(valueOfad);
        if (paramMap.get() != SpecialEffectsController.Operation.State.i)
        {
          ((View)localObject1).startAnimation((Animation)localObject2);
          paramList2.e();
        }
        else
        {
          localViewGroup.startViewTransition((View)localObject1);
          localObject2 = new NumberPicker((Animation)localObject2, localViewGroup, (View)localObject1);
          ((Animation)localObject2).setAnimationListener(new MainActivity.3(this, paramMap, localViewGroup, (View)localObject1, paramList2));
          ((View)localObject1).startAnimation((Animation)localObject2);
          int k = 2;
          j = k;
          if (FragmentManager.get(2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Animation from operation ");
            ((StringBuilder)localObject2).append(paramMap);
            ((StringBuilder)localObject2).append(" has started.");
            android.util.Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
            j = k;
          }
        }
        paramList2.c().a(new ClassWriter(this, (View)localObject1, localViewGroup, paramList2, paramMap));
      }
    }
  }
  
  void a(ArrayList paramArrayList, View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      if (aa.a(localViewGroup))
      {
        if (!paramArrayList.contains(paramView)) {
          paramArrayList.add(localViewGroup);
        }
      }
      else
      {
        int j = localViewGroup.getChildCount();
        int i = 0;
        while (i < j)
        {
          paramView = localViewGroup.getChildAt(i);
          if (paramView.getVisibility() == 0) {
            a(paramArrayList, paramView);
          }
          i += 1;
        }
      }
    }
    else if (!paramArrayList.contains(paramView))
    {
      paramArrayList.add(paramView);
    }
  }
  
  void a(List paramList, boolean paramBoolean)
  {
    Object localObject4 = paramList.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    while (((Iterator)localObject4).hasNext())
    {
      localObject3 = (SpecialEffectsController.Operation)((Iterator)localObject4).next();
      localObject5 = SpecialEffectsController.Operation.State.a(nextmView);
      int i = Handle.d[localObject3.get().ordinal()];
      if ((i != 1) && (i != 2) && (i != 3))
      {
        if ((i == 4) && (localObject5 != SpecialEffectsController.Operation.State.b)) {
          localObject1 = localObject3;
        }
      }
      else if ((localObject5 == SpecialEffectsController.Operation.State.b) && (localObject2 == null)) {
        localObject2 = localObject3;
      }
    }
    if (FragmentManager.get(2))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Executing operations from ");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append(" to ");
      ((StringBuilder)localObject3).append(localObject1);
      android.util.Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
    }
    localObject4 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject3 = new ArrayList(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SpecialEffectsController.Operation localOperation = (SpecialEffectsController.Operation)paramList.next();
      v7.v7.menu.h localH = new v7.v7.menu.h();
      localOperation.a(localH);
      ((List)localObject4).add(new XYPlot(localOperation, localH, paramBoolean));
      localH = new v7.v7.menu.h();
      localOperation.a(localH);
      boolean bool = false;
      if (paramBoolean ? localOperation == localObject2 : localOperation == localObject1) {
        bool = true;
      }
      ((List)localObject5).add(new i(localOperation, localH, paramBoolean, bool));
      localOperation.a(new Widget(this, (List)localObject3, localOperation));
    }
    paramList = a((List)localObject5, (List)localObject3, paramBoolean, localObject2, localObject1);
    a((List)localObject4, (List)localObject3, paramList.containsValue(Boolean.TRUE), paramList);
    paramList = ((List)localObject3).iterator();
    while (paramList.hasNext()) {
      f((SpecialEffectsController.Operation)paramList.next());
    }
    ((List)localObject3).clear();
    if (FragmentManager.get(2))
    {
      paramList = new StringBuilder();
      paramList.append("Completed executing operations from ");
      paramList.append(localObject2);
      paramList.append(" to ");
      paramList.append(localObject1);
      android.util.Log.v("FragmentManager", paramList.toString());
    }
  }
  
  void a(Map paramMap, View paramView)
  {
    Object localObject = ViewCompat.get(paramView);
    if (localObject != null) {
      paramMap.put(localObject, paramView);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramView.getChildAt(i);
        if (((View)localObject).getVisibility() == 0) {
          a(paramMap, (View)localObject);
        }
        i += 1;
      }
    }
  }
  
  void a(ArrayMap paramArrayMap, Collection paramCollection)
  {
    paramArrayMap = paramArrayMap.entrySet().iterator();
    while (paramArrayMap.hasNext()) {
      if (!paramCollection.contains(ViewCompat.get((View)((Map.Entry)paramArrayMap.next()).getValue()))) {
        paramArrayMap.remove();
      }
    }
  }
  
  void f(SpecialEffectsController.Operation paramOperation)
  {
    View localView = nextmView;
    paramOperation.get().set(localView);
  }
}

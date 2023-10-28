package androidx.fragment.package_11;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import v7.v7.menu.h;
import v7.v7.package_13.DeferredRequestCreator;
import v7.v7.package_13.ViewCompat;

public abstract class FragmentTransitionCompat21
{
  public FragmentTransitionCompat21() {}
  
  protected static void bfsAddViewChildren(List paramList, View paramView)
  {
    int k = paramList.size();
    if (containedBeforeIndex(paramList, paramView, k)) {
      return;
    }
    if (ViewCompat.get(paramView) != null) {
      paramList.add(paramView);
    }
    int i = k;
    while (i < paramList.size())
    {
      paramView = (View)paramList.get(i);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int m = paramView.getChildCount();
        int j = 0;
        while (j < m)
        {
          View localView = paramView.getChildAt(j);
          if ((!containedBeforeIndex(paramList, localView, k)) && (ViewCompat.get(localView) != null)) {
            paramList.add(localView);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  private static boolean containedBeforeIndex(List paramList, View paramView, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramList.get(i) == paramView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected static boolean isNullOrEmpty(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(ViewCompat.get(localView));
      ViewCompat.get(localView, null);
      i += 1;
    }
    return localArrayList;
  }
  
  void a(View paramView, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Map paramMap)
  {
    int k = paramArrayList2.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = ViewCompat.get((View)localObject);
      localArrayList.add(str);
      if (str != null)
      {
        ViewCompat.get((View)localObject, null);
        localObject = (String)paramMap.get(str);
        int j = 0;
        while (j < k)
        {
          if (((String)localObject).equals(paramArrayList3.get(j)))
          {
            ViewCompat.get((View)paramArrayList2.get(j), str);
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    DeferredRequestCreator.get(paramView, new d0.a(this, k, paramArrayList2, paramArrayList3, paramArrayList1, localArrayList));
  }
  
  public void a(Fragment paramFragment, Object paramObject, h paramH, Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public abstract void addTargets(Object paramObject, ArrayList paramArrayList);
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract void build(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3);
  
  protected void draw(View paramView, Rect paramRect)
  {
    if (!ViewCompat.d(paramView)) {
      return;
    }
    RectF localRectF = new RectF();
    localRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    paramView.getMatrix().mapRect(localRectF);
    localRectF.offset(paramView.getLeft(), paramView.getTop());
    for (Object localObject = paramView.getParent(); (localObject instanceof View); localObject = ((View)localObject).getParent())
    {
      localObject = (View)localObject;
      localRectF.offset(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
      ((View)localObject).getMatrix().mapRect(localRectF);
      localRectF.offset(((View)localObject).getLeft(), ((View)localObject).getTop());
    }
    localObject = new int[2];
    paramView.getRootView().getLocationOnScreen((int[])localObject);
    localRectF.offset(localObject[0], localObject[1]);
    paramRect.set(Math.round(left), Math.round(top), Math.round(right), Math.round(bottom));
  }
  
  public abstract void draw(Object paramObject, Rect paramRect);
  
  public abstract void draw(Object paramObject, View paramView);
  
  public abstract Object get(Object paramObject);
  
  public abstract Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object read(Object paramObject);
  
  public abstract Object read(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void recycle(Object paramObject, View paramView);
  
  public abstract void recycle(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void setSharedElementTargets(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void setSharedElementTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract boolean toString(Object paramObject);
}

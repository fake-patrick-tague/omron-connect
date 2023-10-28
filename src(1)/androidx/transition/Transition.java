package androidx.transition;

import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import c.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;
import v7.v7.package_13.ViewCompat;

public abstract class Transition
  implements Cloneable
{
  private static final PathMotion V = new a();
  private static final int[] W = { 2, 1, 3, 4 };
  private static ThreadLocal<a<android.animation.Animator, d>> reference = new ThreadLocal();
  private ArrayList<Class<?>> A = null;
  ArrayList<View> a = new ArrayList();
  private ArrayList<View> b = null;
  private ArrayList<m> c;
  private ArrayList<f> data = null;
  private TimeInterpolator e = null;
  ArrayList<Integer> f = new ArrayList();
  private e freq;
  private x g = new x();
  private int[] h = W;
  private x i = new x();
  private boolean index = false;
  private ArrayList<m> j;
  private ArrayList<String> k = null;
  private ArrayList<Class<?>> l = null;
  HttpCacheEntry left;
  private ArrayList<Integer> m = null;
  private PathMotion mTarget = V;
  private long n = -1L;
  private ArrayList<String> o = null;
  private ArrayList<Integer> p = null;
  private ArrayList<View> q = null;
  private ViewGroup r = null;
  private a<String, String> right;
  private ArrayList<Class<?>> s = null;
  private boolean size = false;
  TransitionSet t = null;
  ArrayList<android.animation.Animator> this$0 = new ArrayList();
  private int type = 0;
  private ArrayList<android.animation.Animator> v = new ArrayList();
  boolean w = false;
  long x = -1L;
  private String zone = getClass().getName();
  
  public Transition() {}
  
  private static void a(x paramX, View paramView, Label paramLabel)
  {
    b.put(paramView, paramLabel);
    int i1 = paramView.getId();
    if (i1 >= 0) {
      if (d.indexOfKey(i1) >= 0) {
        d.put(i1, null);
      } else {
        d.put(i1, paramView);
      }
    }
    paramLabel = ViewCompat.get(paramView);
    if (paramLabel != null) {
      if (c.containsKey(paramLabel)) {
        c.put(paramLabel, null);
      } else {
        c.put(paramLabel, paramView);
      }
    }
    if ((paramView.getParent() instanceof ListView))
    {
      paramLabel = (ListView)paramView.getParent();
      if (paramLabel.getAdapter().hasStableIds())
      {
        long l1 = paramLabel.getItemIdAtPosition(paramLabel.getPositionForView(paramView));
        if (a.indexOfKey(l1) >= 0)
        {
          paramView = (View)a.get(l1);
          if (paramView != null)
          {
            ViewCompat.setElevation(paramView, false);
            a.put(l1, null);
          }
        }
        else
        {
          ViewCompat.setElevation(paramView, true);
          a.put(l1, paramView);
        }
      }
    }
  }
  
  private void a(x paramX1, x paramX2)
  {
    ArrayMap localArrayMap1 = new ArrayMap(b);
    ArrayMap localArrayMap2 = new ArrayMap(b);
    int i1 = 0;
    for (;;)
    {
      int[] arrayOfInt = h;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      int i2 = arrayOfInt[i1];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4) {
              a(localArrayMap1, localArrayMap2, a, a);
            }
          }
          else {
            a(localArrayMap1, localArrayMap2, d, d);
          }
        }
        else {
          a(localArrayMap1, localArrayMap2, c, c);
        }
      }
      else {
        a(localArrayMap1, localArrayMap2);
      }
      i1 += 1;
    }
    draw(localArrayMap1, localArrayMap2);
  }
  
  private void a(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2)
  {
    int i1 = paramArrayMap1.size() - 1;
    while (i1 >= 0)
    {
      Object localObject = (View)paramArrayMap1.size(i1);
      if ((localObject != null) && (a((View)localObject)))
      {
        localObject = (Label)paramArrayMap2.remove(localObject);
        if ((localObject != null) && (a(a)))
        {
          Label localLabel = (Label)paramArrayMap1.removeAt(i1);
          j.add(localLabel);
          c.add(localObject);
        }
      }
      i1 -= 1;
    }
  }
  
  private void a(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, android.util.SparseArray paramSparseArray1, android.util.SparseArray paramSparseArray2)
  {
    int i2 = paramSparseArray1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i1);
      if ((localView1 != null) && (a(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i1));
        if ((localView2 != null) && (a(localView2)))
        {
          Label localLabel1 = (Label)paramArrayMap1.get(localView1);
          Label localLabel2 = (Label)paramArrayMap2.get(localView2);
          if ((localLabel1 != null) && (localLabel2 != null))
          {
            j.add(localLabel1);
            c.add(localLabel2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void a(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, ArrayMap paramArrayMap3, ArrayMap paramArrayMap4)
  {
    int i2 = paramArrayMap3.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView1 = (View)paramArrayMap3.get(i1);
      if ((localView1 != null) && (a(localView1)))
      {
        View localView2 = (View)paramArrayMap4.get(paramArrayMap3.size(i1));
        if ((localView2 != null) && (a(localView2)))
        {
          Label localLabel1 = (Label)paramArrayMap1.get(localView1);
          Label localLabel2 = (Label)paramArrayMap2.get(localView2);
          if ((localLabel1 != null) && (localLabel2 != null))
          {
            j.add(localLabel1);
            c.add(localLabel2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void a(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, v7.util.SparseArray paramSparseArray1, v7.util.SparseArray paramSparseArray2)
  {
    int i2 = paramSparseArray1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i1);
      if ((localView1 != null) && (a(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.get(i1));
        if ((localView2 != null) && (a(localView2)))
        {
          Label localLabel1 = (Label)paramArrayMap1.get(localView1);
          Label localLabel2 = (Label)paramArrayMap2.get(localView2);
          if ((localLabel1 != null) && (localLabel2 != null))
          {
            j.add(localLabel1);
            c.add(localLabel2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void draw(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2)
  {
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= paramArrayMap1.size()) {
        break;
      }
      Label localLabel = (Label)paramArrayMap1.get(i1);
      if (a(a))
      {
        j.add(localLabel);
        c.add(null);
      }
      i1 += 1;
    }
    while (i2 < paramArrayMap2.size())
    {
      paramArrayMap1 = (Label)paramArrayMap2.get(i2);
      if (a(a))
      {
        c.add(paramArrayMap1);
        j.add(null);
      }
      i2 += 1;
    }
  }
  
  private static ArrayMap getValue()
  {
    ArrayMap localArrayMap2 = (ArrayMap)reference.get();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      reference.set(localArrayMap1);
    }
    return localArrayMap1;
  }
  
  private void update(android.animation.Animator paramAnimator, final ArrayMap paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new b(paramArrayMap));
      build(paramAnimator);
    }
  }
  
  private void update(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i3 = paramView.getId();
    Object localObject = m;
    if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i3)))) {
      return;
    }
    localObject = b;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
      return;
    }
    localObject = A;
    int i2 = 0;
    int i1;
    if (localObject != null)
    {
      int i4 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i4)
      {
        if (((Class)A.get(i1)).isInstance(paramView)) {
          return;
        }
        i1 += 1;
      }
    }
    if ((paramView.getParent() instanceof ViewGroup))
    {
      localObject = new Label(paramView);
      if (paramBoolean) {
        draw((Label)localObject);
      } else {
        write((Label)localObject);
      }
      b.add(this);
      update((Label)localObject);
      if (paramBoolean) {
        a(i, paramView, (Label)localObject);
      } else {
        a(g, paramView, (Label)localObject);
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      localObject = p;
      if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i3)))) {
        return;
      }
      localObject = q;
      if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
        return;
      }
      localObject = s;
      if (localObject != null)
      {
        i3 = ((ArrayList)localObject).size();
        i1 = 0;
        while (i1 < i3)
        {
          if (((Class)s.get(i1)).isInstance(paramView)) {
            return;
          }
          i1 += 1;
        }
      }
      paramView = (ViewGroup)paramView;
      i1 = i2;
      while (i1 < paramView.getChildCount())
      {
        update(paramView.getChildAt(i1), paramBoolean);
        i1 += 1;
      }
    }
  }
  
  private static boolean update(Label paramLabel1, Label paramLabel2, String paramString)
  {
    paramLabel1 = m.get(paramString);
    paramLabel2 = m.get(paramString);
    if ((paramLabel1 == null) && (paramLabel2 == null)) {
      return false;
    }
    if (paramLabel1 != null)
    {
      if (paramLabel2 == null) {
        return true;
      }
      return true ^ paramLabel1.equals(paramLabel2);
    }
    return true;
  }
  
  public android.animation.Animator a(ViewGroup paramViewGroup, Label paramLabel1, Label paramLabel2)
  {
    return null;
  }
  
  Label a(View paramView, boolean paramBoolean)
  {
    Object localObject = t;
    if (localObject != null) {
      return ((Transition)localObject).a(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = j;
    } else {
      localObject = c;
    }
    if (localObject == null) {
      return null;
    }
    int i4 = ((ArrayList)localObject).size();
    int i3 = -1;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      Label localLabel = (Label)((ArrayList)localObject).get(i1);
      if (localLabel == null) {
        return null;
      }
      if (a == paramView)
      {
        i2 = i1;
        break;
      }
      i1 += 1;
    }
    if (i2 >= 0)
    {
      if (paramBoolean) {
        paramView = c;
      } else {
        paramView = j;
      }
      return (Label)paramView.get(i2);
    }
    return null;
  }
  
  protected void a()
  {
    int i1 = type - 1;
    type = i1;
    if (i1 == 0)
    {
      Object localObject = data;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (ArrayList)data.clone();
        int i2 = ((ArrayList)localObject).size();
        i1 = 0;
        while (i1 < i2)
        {
          ((f)((ArrayList)localObject).get(i1)).c(this);
          i1 += 1;
        }
      }
      i1 = 0;
      while (i1 < i.a.size())
      {
        localObject = (View)i.a.valueAt(i1);
        if (localObject != null) {
          ViewCompat.setElevation((View)localObject, false);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < g.a.size())
      {
        localObject = (View)g.a.valueAt(i1);
        if (localObject != null) {
          ViewCompat.setElevation((View)localObject, false);
        }
        i1 += 1;
      }
      size = true;
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    j = new ArrayList();
    c = new ArrayList();
    a(i, g);
    ArrayMap localArrayMap = getValue();
    int i1 = localArrayMap.size();
    Node localNode = Item.next(paramViewGroup);
    i1 -= 1;
    while (i1 >= 0)
    {
      android.animation.Animator localAnimator = (android.animation.Animator)localArrayMap.size(i1);
      if (localAnimator != null)
      {
        d localD = (d)localArrayMap.get(localAnimator);
        if ((localD != null) && (h != null) && (localNode.equals(s)))
        {
          Label localLabel4 = c;
          View localView = h;
          Label localLabel5 = equals(localView, true);
          Label localLabel3 = a(localView, true);
          Label localLabel1 = localLabel3;
          Label localLabel2 = localLabel1;
          if (localLabel5 == null)
          {
            localLabel2 = localLabel1;
            if (localLabel3 == null) {
              localLabel2 = (Label)g.b.get(localView);
            }
          }
          int i2;
          if (((localLabel5 != null) || (localLabel2 != null)) && (u.add(localLabel4, localLabel2))) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i2 != 0) {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              localArrayMap.remove(localAnimator);
            } else {
              localAnimator.cancel();
            }
          }
        }
      }
      i1 -= 1;
    }
    a(paramViewGroup, i, g, j, c);
    draw();
  }
  
  protected void a(ViewGroup paramViewGroup, x paramX1, x paramX2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayMap localArrayMap = getValue();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int i3 = paramArrayList1.size();
    int i1 = 0;
    int i2;
    while (i1 < i3)
    {
      Object localObject2 = (Label)paramArrayList1.get(i1);
      paramX1 = (Label)paramArrayList2.get(i1);
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!b.contains(this)) {
          localObject1 = null;
        }
      }
      localObject2 = paramX1;
      if (paramX1 != null)
      {
        localObject2 = paramX1;
        if (!b.contains(this)) {
          localObject2 = null;
        }
      }
      if ((localObject1 != null) || (localObject2 != null))
      {
        do
        {
          do
          {
            if ((localObject1 != null) && (localObject2 != null) && (!add((Label)localObject1, (Label)localObject2))) {
              i2 = 0;
            } else {
              i2 = 1;
            }
          } while (i2 == 0);
          paramX1 = a(paramViewGroup, (Label)localObject1, (Label)localObject2);
        } while (paramX1 == null);
        if (localObject2 != null)
        {
          localObject2 = a;
          Object localObject3 = valueOf();
          if ((localObject3 != null) && (localObject3.length > 0))
          {
            localObject1 = new Label((View)localObject2);
            Label localLabel = (Label)b.get(localObject2);
            if (localLabel != null)
            {
              i2 = 0;
              while (i2 < localObject3.length)
              {
                m.put(localObject3[i2], m.get(localObject3[i2]));
                i2 += 1;
              }
            }
            int i4 = localArrayMap.size();
            i2 = 0;
            while (i2 < i4)
            {
              localObject3 = (d)localArrayMap.get((android.animation.Animator)localArrayMap.size(i2));
              if ((c != null) && (h == localObject2) && (d.equals(readUTF8())) && (c.equals(localObject1)))
              {
                paramX1 = null;
                break;
              }
              i2 += 1;
            }
          }
          else
          {
            localObject1 = null;
          }
        }
        else
        {
          localObject2 = a;
          localObject1 = null;
        }
        if (paramX1 != null) {
          if (left == null)
          {
            localArrayMap.put(paramX1, new d((View)localObject2, readUTF8(), this, Item.next(paramViewGroup), (Label)localObject1));
            v.add(paramX1);
          }
          else
          {
            throw new NullPointerException("Null throw statement replaced by Soot");
          }
        }
      }
      i1 += 1;
    }
    if (localSparseIntArray.size() != 0)
    {
      i1 = 0;
      while (i1 < localSparseIntArray.size())
      {
        i2 = localSparseIntArray.keyAt(i1);
        paramViewGroup = (android.animation.Animator)v.get(i2);
        paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i1) - Long.MAX_VALUE + paramViewGroup.getStartDelay());
        i1 += 1;
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i.b.clear();
      i.d.clear();
      i.a.clear();
      return;
    }
    g.b.clear();
    g.d.clear();
    g.a.clear();
  }
  
  boolean a(View paramView)
  {
    int i2 = paramView.getId();
    ArrayList localArrayList = m;
    if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(i2)))) {
      return false;
    }
    localArrayList = b;
    if ((localArrayList != null) && (localArrayList.contains(paramView))) {
      return false;
    }
    localArrayList = A;
    int i1;
    if (localArrayList != null)
    {
      int i3 = localArrayList.size();
      i1 = 0;
      while (i1 < i3)
      {
        if (((Class)A.get(i1)).isInstance(paramView)) {
          return false;
        }
        i1 += 1;
      }
    }
    if ((o != null) && (ViewCompat.get(paramView) != null) && (o.contains(ViewCompat.get(paramView)))) {
      return false;
    }
    if ((f.size() == 0) && (a.size() == 0))
    {
      localArrayList = l;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        localArrayList = k;
        if (localArrayList == null) {
          break label296;
        }
        if (localArrayList.isEmpty()) {
          return true;
        }
      }
    }
    if (!f.contains(Integer.valueOf(i2)))
    {
      if (a.contains(paramView)) {
        return true;
      }
      localArrayList = k;
      if ((localArrayList != null) && (localArrayList.contains(ViewCompat.get(paramView)))) {
        return true;
      }
      if (l != null)
      {
        i1 = 0;
        while (i1 < l.size())
        {
          if (((Class)l.get(i1)).isInstance(paramView)) {
            return true;
          }
          i1 += 1;
        }
      }
      return false;
    }
    label296:
    return true;
    return false;
  }
  
  public boolean add(Label paramLabel1, Label paramLabel2)
  {
    if ((paramLabel1 != null) && (paramLabel2 != null))
    {
      Object localObject = valueOf();
      if (localObject != null)
      {
        int i2 = localObject.length;
        int i1 = 0;
        for (;;)
        {
          if (i1 >= i2) {
            break label100;
          }
          if (update(paramLabel1, paramLabel2, localObject[i1])) {
            break;
          }
          i1 += 1;
        }
      }
      localObject = m.keySet().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!update(paramLabel1, paramLabel2, (String)((Iterator)localObject).next()));
      return true;
    }
    label100:
    return false;
  }
  
  public List apply()
  {
    return f;
  }
  
  protected void build(android.animation.Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      a();
      return;
    }
    if (getX() >= 0L) {
      paramAnimator.setDuration(getX());
    }
    if (length() >= 0L) {
      paramAnimator.setStartDelay(length() + paramAnimator.getStartDelay());
    }
    if (getPublicKey() != null) {
      paramAnimator.setInterpolator(getPublicKey());
    }
    paramAnimator.addListener(new c());
    paramAnimator.start();
  }
  
  protected void cancel()
  {
    int i1 = this$0.size() - 1;
    while (i1 >= 0)
    {
      ((android.animation.Animator)this$0.get(i1)).cancel();
      i1 -= 1;
    }
    ArrayList localArrayList = data;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = (ArrayList)data.clone();
      int i2 = localArrayList.size();
      i1 = 0;
      while (i1 < i2)
      {
        ((f)localArrayList.get(i1)).d(this);
        i1 += 1;
      }
    }
  }
  
  protected void draw()
  {
    init();
    ArrayMap localArrayMap = getValue();
    Iterator localIterator = v.iterator();
    while (localIterator.hasNext())
    {
      android.animation.Animator localAnimator = (android.animation.Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        init();
        update(localAnimator, localArrayMap);
      }
    }
    v.clear();
    a();
  }
  
  void draw(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a(paramBoolean);
    int i1 = f.size();
    int i3 = 0;
    Object localObject1;
    if ((i1 > 0) || (a.size() > 0))
    {
      localObject1 = k;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = l;
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          break label80;
        }
      }
    }
    update(paramViewGroup, paramBoolean);
    break label304;
    label80:
    i1 = 0;
    Object localObject2;
    while (i1 < f.size())
    {
      localObject1 = paramViewGroup.findViewById(((Integer)f.get(i1)).intValue());
      if (localObject1 != null)
      {
        localObject2 = new Label((View)localObject1);
        if (paramBoolean) {
          draw((Label)localObject2);
        } else {
          write((Label)localObject2);
        }
        b.add(this);
        update((Label)localObject2);
        if (paramBoolean) {
          a(i, (View)localObject1, (Label)localObject2);
        } else {
          a(g, (View)localObject1, (Label)localObject2);
        }
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < a.size())
    {
      paramViewGroup = (View)a.get(i1);
      localObject1 = new Label(paramViewGroup);
      if (paramBoolean) {
        draw((Label)localObject1);
      } else {
        write((Label)localObject1);
      }
      b.add(this);
      update((Label)localObject1);
      if (paramBoolean) {
        a(i, paramViewGroup, (Label)localObject1);
      } else {
        a(g, paramViewGroup, (Label)localObject1);
      }
      i1 += 1;
    }
    label304:
    if (!paramBoolean)
    {
      paramViewGroup = right;
      if (paramViewGroup != null)
      {
        int i4 = paramViewGroup.size();
        paramViewGroup = new ArrayList(i4);
        i1 = 0;
        int i2;
        for (;;)
        {
          i2 = i3;
          if (i1 >= i4) {
            break;
          }
          localObject1 = (String)right.size(i1);
          paramViewGroup.add(i.c.remove(localObject1));
          i1 += 1;
        }
        while (i2 < i4)
        {
          localObject1 = (View)paramViewGroup.get(i2);
          if (localObject1 != null)
          {
            localObject2 = (String)right.get(i2);
            i.c.put(localObject2, localObject1);
          }
          i2 += 1;
        }
      }
    }
  }
  
  public abstract void draw(Label paramLabel);
  
  public Label equals(View paramView, boolean paramBoolean)
  {
    Object localObject = t;
    if (localObject != null) {
      return ((Transition)localObject).equals(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = i;
    } else {
      localObject = g;
    }
    return (Label)b.get(paramView);
  }
  
  public e finish()
  {
    return freq;
  }
  
  public Transition get(View paramView)
  {
    a.add(paramView);
    return this;
  }
  
  public List get()
  {
    return a;
  }
  
  public List getId()
  {
    return l;
  }
  
  public TimeInterpolator getPublicKey()
  {
    return e;
  }
  
  public PathMotion getTarget()
  {
    return mTarget;
  }
  
  public long getX()
  {
    return x;
  }
  
  public Transition init(long paramLong)
  {
    n = paramLong;
    return this;
  }
  
  public Transition init(TimeInterpolator paramTimeInterpolator)
  {
    e = paramTimeInterpolator;
    return this;
  }
  
  protected void init()
  {
    if (type == 0)
    {
      ArrayList localArrayList = data;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = (ArrayList)data.clone();
        int i2 = localArrayList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((f)localArrayList.get(i1)).onPreDraw(this);
          i1 += 1;
        }
      }
      size = false;
    }
    type += 1;
  }
  
  public void init(View paramView)
  {
    if (!size)
    {
      ArrayMap localArrayMap = getValue();
      int i1 = localArrayMap.size();
      paramView = Item.next(paramView);
      i1 -= 1;
      while (i1 >= 0)
      {
        d localD = (d)localArrayMap.get(i1);
        if ((h != null) && (paramView.equals(s))) {
          Animator.update((android.animation.Animator)localArrayMap.size(i1));
        }
        i1 -= 1;
      }
      paramView = data;
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = (ArrayList)data.clone();
        int i2 = paramView.size();
        i1 = 0;
        while (i1 < i2)
        {
          ((f)paramView.get(i1)).e(this);
          i1 += 1;
        }
      }
      index = true;
    }
  }
  
  public void init(PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      mTarget = V;
      return;
    }
    mTarget = paramPathMotion;
  }
  
  public long length()
  {
    return n;
  }
  
  public Transition next(f paramF)
  {
    if (data == null) {
      data = new ArrayList();
    }
    data.add(paramF);
    return this;
  }
  
  public String readUTF8()
  {
    return zone;
  }
  
  public Transition recycle(f paramF)
  {
    ArrayList localArrayList = data;
    if (localArrayList == null) {
      return this;
    }
    localArrayList.remove(paramF);
    if (data.size() == 0) {
      data = null;
    }
    return this;
  }
  
  public List select()
  {
    return k;
  }
  
  public Transition set()
  {
    try
    {
      Object localObject1 = super.clone();
      localObject1 = (Transition)localObject1;
      Object localObject2 = new ArrayList();
      v = ((ArrayList)localObject2);
      localObject2 = new x();
      i = ((x)localObject2);
      localObject2 = new x();
      g = ((x)localObject2);
      j = null;
      c = null;
      return localObject1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Transition set(long paramLong)
  {
    x = paramLong;
    return this;
  }
  
  public Transition setTarget(View paramView)
  {
    a.remove(paramView);
    return this;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  String toString(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (x != -1L)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("dur(");
      paramString.append(x);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (n != -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("dly(");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(") ");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (e != null)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("interp(");
      paramString.append(e);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    if ((f.size() > 0) || (a.size() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("tgts(");
      paramString = ((StringBuilder)localObject).toString();
      int i1 = f.size();
      int i2 = 0;
      localObject = paramString;
      if (i1 > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = paramString;
          if (i1 >= f.size()) {
            break;
          }
          localObject = paramString;
          if (i1 > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", ");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(f.get(i1));
          paramString = paramString.toString();
          i1 += 1;
        }
      }
      paramString = (String)localObject;
      if (a.size() > 0)
      {
        i1 = i2;
        for (;;)
        {
          paramString = (String)localObject;
          if (i1 >= a.size()) {
            break;
          }
          paramString = (String)localObject;
          if (i1 > 0)
          {
            paramString = new StringBuilder();
            paramString.append((String)localObject);
            paramString.append(", ");
            paramString = paramString.toString();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(a.get(i1));
          localObject = ((StringBuilder)localObject).toString();
          i1 += 1;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(")");
      return ((StringBuilder)localObject).toString();
    }
    return paramString;
  }
  
  public HttpCacheEntry update()
  {
    return left;
  }
  
  public void update(View paramView)
  {
    if (index)
    {
      if (!size)
      {
        ArrayMap localArrayMap = getValue();
        int i1 = localArrayMap.size();
        paramView = Item.next(paramView);
        i1 -= 1;
        while (i1 >= 0)
        {
          d localD = (d)localArrayMap.get(i1);
          if ((h != null) && (paramView.equals(s))) {
            Animator.start((android.animation.Animator)localArrayMap.size(i1));
          }
          i1 -= 1;
        }
        paramView = data;
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = (ArrayList)data.clone();
          int i2 = paramView.size();
          i1 = 0;
          while (i1 < i2)
          {
            ((f)paramView.get(i1)).b(this);
            i1 += 1;
          }
        }
      }
      index = false;
    }
  }
  
  public void update(HttpCacheEntry paramHttpCacheEntry) {}
  
  void update(Label paramLabel)
  {
    if (left != null)
    {
      if (m.isEmpty()) {
        return;
      }
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public void update(e paramE)
  {
    freq = paramE;
  }
  
  public String[] valueOf()
  {
    return null;
  }
  
  public abstract void write(Label paramLabel);
  
  static final class a
    extends PathMotion
  {
    a() {}
    
    public Path getMarkPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramFloat1, paramFloat2);
      localPath.lineTo(paramFloat3, paramFloat4);
      return localPath;
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b(ArrayMap paramArrayMap) {}
    
    public void onAnimationEnd(android.animation.Animator paramAnimator)
    {
      paramArrayMap.remove(paramAnimator);
      this$0.remove(paramAnimator);
    }
    
    public void onAnimationStart(android.animation.Animator paramAnimator)
    {
      this$0.add(paramAnimator);
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c() {}
    
    public void onAnimationEnd(android.animation.Animator paramAnimator)
    {
      a();
      paramAnimator.removeListener(this);
    }
  }
  
  private static class d
  {
    Label c;
    String d;
    View h;
    Node s;
    Transition u;
    
    d(View paramView, String paramString, Transition paramTransition, Node paramNode, Label paramLabel)
    {
      h = paramView;
      d = paramString;
      c = paramLabel;
      s = paramNode;
      u = paramTransition;
    }
  }
  
  public static abstract class e
  {
    public e() {}
  }
  
  public static abstract interface f
  {
    public abstract void b(Transition paramTransition);
    
    public abstract void c(Transition paramTransition);
    
    public abstract void d(Transition paramTransition);
    
    public abstract void e(Transition paramTransition);
    
    public abstract void onPreDraw(Transition paramTransition);
  }
}

package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet
  extends Transition
{
  private boolean a = true;
  boolean k = false;
  private int m = 0;
  int n;
  private ArrayList<Transition> size = new ArrayList();
  
  public TransitionSet() {}
  
  private void set(Transition paramTransition)
  {
    size.add(paramTransition);
    t = this;
  }
  
  private void setDuration()
  {
    b localB = new b(this);
    Iterator localIterator = size.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).next(localB);
    }
    n = size.size();
  }
  
  protected void a(ViewGroup paramViewGroup, x paramX1, x paramX2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    long l1 = length();
    int j = size.size();
    int i = 0;
    while (i < j)
    {
      Transition localTransition = (Transition)size.get(i);
      if ((l1 > 0L) && ((a) || (i == 0)))
      {
        long l2 = localTransition.length();
        if (l2 > 0L) {
          localTransition.init(l2 + l1);
        } else {
          localTransition.init(l1);
        }
      }
      localTransition.a(paramViewGroup, paramX1, paramX2, paramArrayList1, paramArrayList2);
      i += 1;
    }
  }
  
  public TransitionSet add(long paramLong)
  {
    super.set(paramLong);
    if (x >= 0L)
    {
      ArrayList localArrayList = size;
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((Transition)size.get(i)).set(paramLong);
          i += 1;
        }
      }
    }
    return this;
  }
  
  public TransitionSet build(long paramLong)
  {
    return (TransitionSet)super.init(paramLong);
  }
  
  public TransitionSet close(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        a = false;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid parameter for TransitionSet ordering: ");
      localStringBuilder.append(paramInt);
      throw new AndroidRuntimeException(localStringBuilder.toString());
    }
    a = true;
    return this;
  }
  
  protected void draw()
  {
    if (size.isEmpty())
    {
      init();
      a();
      return;
    }
    setDuration();
    Object localObject;
    if (!a)
    {
      int i = 1;
      while (i < size.size())
      {
        ((Transition)size.get(i - 1)).next(new a((Transition)size.get(i)));
        i += 1;
      }
      localObject = (Transition)size.get(0);
      if (localObject != null) {
        ((Transition)localObject).draw();
      }
    }
    else
    {
      localObject = size.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).draw();
      }
    }
  }
  
  public void draw(Label paramLabel)
  {
    if (a(a))
    {
      Iterator localIterator = size.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.a(a))
        {
          localTransition.draw(paramLabel);
          b.add(localTransition);
        }
      }
    }
  }
  
  public TransitionSet free(Transition.f paramF)
  {
    return (TransitionSet)super.recycle(paramF);
  }
  
  public Transition get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size.size())) {
      return (Transition)size.get(paramInt);
    }
    return null;
  }
  
  public TransitionSet getElement(Transition.f paramF)
  {
    return (TransitionSet)super.next(paramF);
  }
  
  public TransitionSet init(Transition paramTransition)
  {
    set(paramTransition);
    long l = x;
    if (l >= 0L) {
      paramTransition.set(l);
    }
    if ((m & 0x1) != 0) {
      paramTransition.init(getPublicKey());
    }
    if ((m & 0x2) != 0) {
      paramTransition.update(update());
    }
    if ((m & 0x4) != 0) {
      paramTransition.init(getTarget());
    }
    if ((m & 0x8) != 0) {
      paramTransition.update(finish());
    }
    return this;
  }
  
  public void init(View paramView)
  {
    super.init(paramView);
    int j = size.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)size.get(i)).init(paramView);
      i += 1;
    }
  }
  
  public void init(PathMotion paramPathMotion)
  {
    super.init(paramPathMotion);
    m |= 0x4;
    if (size != null)
    {
      int i = 0;
      while (i < size.size())
      {
        ((Transition)size.get(i)).init(paramPathMotion);
        i += 1;
      }
    }
  }
  
  public TransitionSet initialize(TimeInterpolator paramTimeInterpolator)
  {
    m |= 0x1;
    ArrayList localArrayList = size;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)size.get(i)).init(paramTimeInterpolator);
        i += 1;
      }
    }
    return (TransitionSet)super.init(paramTimeInterpolator);
  }
  
  public TransitionSet next(View paramView)
  {
    int i = 0;
    while (i < size.size())
    {
      ((Transition)size.get(i)).get(paramView);
      i += 1;
    }
    return (TransitionSet)super.get(paramView);
  }
  
  public Transition set()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.set();
    size = new ArrayList();
    int j = size.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.set(((Transition)size.get(i)).set());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public int size()
  {
    return size.size();
  }
  
  public TransitionSet startTransition(View paramView)
  {
    int i = 0;
    while (i < size.size())
    {
      ((Transition)size.get(i)).setTarget(paramView);
      i += 1;
    }
    return (TransitionSet)super.setTarget(paramView);
  }
  
  String toString(String paramString)
  {
    Object localObject = super.toString(paramString);
    int i = 0;
    while (i < size.size())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("\n");
      localObject = (Transition)size.get(i);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("  ");
      localStringBuilder1.append(((Transition)localObject).toString(localStringBuilder2.toString()));
      localObject = localStringBuilder1.toString();
      i += 1;
    }
    return localObject;
  }
  
  public void update(View paramView)
  {
    super.update(paramView);
    int j = size.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)size.get(i)).update(paramView);
      i += 1;
    }
  }
  
  public void update(HttpCacheEntry paramHttpCacheEntry)
  {
    super.update(paramHttpCacheEntry);
    m |= 0x2;
    int j = size.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)size.get(i)).update(paramHttpCacheEntry);
      i += 1;
    }
  }
  
  void update(Label paramLabel)
  {
    super.update(paramLabel);
    int j = size.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)size.get(i)).update(paramLabel);
      i += 1;
    }
  }
  
  public void update(Transition.e paramE)
  {
    super.update(paramE);
    m |= 0x8;
    int j = size.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)size.get(i)).update(paramE);
      i += 1;
    }
  }
  
  public void write(Label paramLabel)
  {
    if (a(a))
    {
      Iterator localIterator = size.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.a(a))
        {
          localTransition.write(paramLabel);
          b.add(localTransition);
        }
      }
    }
  }
  
  class a
    extends ActionMenuItemView
  {
    a(Transition paramTransition) {}
    
    public void c(Transition paramTransition)
    {
      b.draw();
      paramTransition.recycle(this);
    }
  }
  
  static class b
    extends ActionMenuItemView
  {
    TransitionSet a;
    
    b(TransitionSet paramTransitionSet)
    {
      a = paramTransitionSet;
    }
    
    public void c(Transition paramTransition)
    {
      TransitionSet localTransitionSet = a;
      int i = n - 1;
      n = i;
      if (i == 0)
      {
        k = false;
        localTransitionSet.a();
      }
      paramTransition.recycle(this);
    }
    
    public void onPreDraw(Transition paramTransition)
    {
      paramTransition = a;
      if (!k)
      {
        paramTransition.init();
        a.k = true;
      }
    }
  }
}

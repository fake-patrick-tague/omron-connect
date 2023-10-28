package androidx.fragment.package_11;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.t.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class f
{
  private final FragmentManager b;
  private final CopyOnWriteArrayList<t.a> c = new CopyOnWriteArrayList();
  
  f(FragmentManager paramFragmentManager)
  {
    b = paramFragmentManager;
  }
  
  void a(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().a(paramFragment, paramBundle, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.add(b, paramFragment, paramBundle);
      }
    }
  }
  
  void a(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().a(paramFragment, paramView, paramBundle, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.a(b, paramFragment, paramView, paramBundle);
      }
    }
  }
  
  void a(Fragment paramFragment, boolean paramBoolean)
  {
    Context localContext = b.getContext().getContext();
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().a(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.add(b, paramFragment, localContext);
      }
    }
  }
  
  public void a(FragmentManager.k paramK)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = c;
    int i = 0;
    for (;;)
    {
      try
      {
        int j = c.size();
        if (i < j)
        {
          if (c.get(i)).a != paramK) {
            break label64;
          }
          c.remove(i);
        }
        return;
      }
      catch (Throwable paramK)
      {
        throw paramK;
      }
      label64:
      i += 1;
    }
  }
  
  public void a(FragmentManager.k paramK, boolean paramBoolean)
  {
    c.add(new p(paramK, paramBoolean));
  }
  
  void add(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().add(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.replace(b, paramFragment);
      }
    }
  }
  
  void b(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().b(paramFragment, paramBundle, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.show(b, paramFragment, paramBundle);
      }
    }
  }
  
  void b(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().b(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.write(b, paramFragment);
      }
    }
  }
  
  void c(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().c(paramFragment, paramBundle, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.b(b, paramFragment, paramBundle);
      }
    }
  }
  
  void c(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().c(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.onCloseMenu(b, paramFragment);
      }
    }
  }
  
  void d(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().d(paramFragment, paramBundle, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.a(b, paramFragment, paramBundle);
      }
    }
  }
  
  void d(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().d(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.a(b, paramFragment);
      }
    }
  }
  
  void draw(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().draw(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.append(b, paramFragment);
      }
    }
  }
  
  void f(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().f(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.b(b, paramFragment);
      }
    }
  }
  
  void run(Fragment paramFragment, boolean paramBoolean)
  {
    Context localContext = b.getContext().getContext();
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().run(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.show(b, paramFragment, localContext);
      }
    }
  }
  
  void write(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = b.iterator();
    if (localObject != null) {
      ((Fragment)localObject).getParentFragmentManager().a().write(paramFragment, true);
    }
    localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localP = (p)((Iterator)localObject).next();
      if ((!paramBoolean) || (b)) {
        a.add(b, paramFragment);
      }
    }
  }
}

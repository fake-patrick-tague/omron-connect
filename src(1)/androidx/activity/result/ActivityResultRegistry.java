package androidx.activity.result;

import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.asm.ClassWriter;
import androidx.core.package_10.Handle;
import androidx.lifecycle.LayoutManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.d;
import androidx.lifecycle.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry
{
  final Bundle a = new Bundle();
  final Map<String, Integer> b = new HashMap();
  private final Map<Integer, String> c = new HashMap();
  private final Map<String, d> d = new HashMap();
  final Map<String, Object> m = new HashMap();
  ArrayList<String> p = new ArrayList();
  private Random r = new Random();
  final transient Map<String, c<?>> w = new HashMap();
  
  public ActivityResultRegistry() {}
  
  private int a()
  {
    for (int i = r.nextInt(2147418112);; i = r.nextInt(2147418112))
    {
      i += 65536;
      if (!c.containsKey(Integer.valueOf(i))) {
        break;
      }
    }
    return i;
  }
  
  private void a(int paramInt, String paramString)
  {
    c.put(Integer.valueOf(paramInt), paramString);
    b.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent, c paramC)
  {
    if ((paramC != null) && (l != null) && (p.contains(paramString)))
    {
      l.onActivityResult(b.b(paramInt, paramIntent));
      p.remove(paramString);
      return;
    }
    m.remove(paramString);
    a.putParcelable(paramString, new ActivityResult(paramInt, paramIntent));
  }
  
  private void visitTypeInsn(String paramString)
  {
    if ((Integer)b.get(paramString) != null) {
      return;
    }
    a(a(), paramString);
  }
  
  public final Label a(final String paramString, final ClassWriter paramClassWriter, AnnotationVisitor paramAnnotationVisitor)
  {
    visitTypeInsn(paramString);
    w.put(paramString, new c(paramAnnotationVisitor, paramClassWriter));
    if (m.containsKey(paramString))
    {
      localObject = m.get(paramString);
      m.remove(paramString);
      paramAnnotationVisitor.onActivityResult(localObject);
    }
    Object localObject = (ActivityResult)a.getParcelable(paramString);
    if (localObject != null)
    {
      a.remove(paramString);
      paramAnnotationVisitor.onActivityResult(paramClassWriter.b(((ActivityResult)localObject).getValue(), ((ActivityResult)localObject).get()));
    }
    return new b(paramString, paramClassWriter);
  }
  
  public final Label a(final String paramString, d paramD, final ClassWriter paramClassWriter, final AnnotationVisitor paramAnnotationVisitor)
  {
    Lifecycle localLifecycle = paramD.getLifecycle();
    if (!localLifecycle.c().a(Lifecycle.State.g))
    {
      visitTypeInsn(paramString);
      d localD = (d)d.get(paramString);
      paramD = localD;
      if (localD == null) {
        paramD = new d(localLifecycle);
      }
      paramD.a(new LayoutManager()
      {
        public void b(d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
        {
          if (Lifecycle.Event.ON_START.equals(paramAnonymousEvent))
          {
            w.put(paramString, new ActivityResultRegistry.c(paramAnnotationVisitor, paramClassWriter));
            if (m.containsKey(paramString))
            {
              paramAnonymousD = m.get(paramString);
              m.remove(paramString);
              paramAnnotationVisitor.onActivityResult(paramAnonymousD);
            }
            paramAnonymousD = (ActivityResult)a.getParcelable(paramString);
            if (paramAnonymousD != null)
            {
              a.remove(paramString);
              paramAnnotationVisitor.onActivityResult(paramClassWriter.b(paramAnonymousD.getValue(), paramAnonymousD.get()));
            }
          }
          else
          {
            if (Lifecycle.Event.ON_STOP.equals(paramAnonymousEvent))
            {
              w.remove(paramString);
              return;
            }
            if (Lifecycle.Event.ON_DESTROY.equals(paramAnonymousEvent)) {
              a(paramString);
            }
          }
        }
      });
      d.put(paramString, paramD);
      return new a(paramString, paramClassWriter);
    }
    paramString = new StringBuilder();
    paramString.append("LifecycleOwner ");
    paramString.append(paramD);
    paramString.append(" is attempting to register while current state is ");
    paramString.append(localLifecycle.c());
    paramString.append(". LifecycleOwners must call register before they are STARTED.");
    throw new IllegalStateException(paramString.toString());
  }
  
  public abstract void a(int paramInt, ClassWriter paramClassWriter, Object paramObject, Handle paramHandle);
  
  public final void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ArrayList localArrayList1 = paramBundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
    if (localArrayList2 != null)
    {
      if (localArrayList1 == null) {
        return;
      }
      p = paramBundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
      r = ((Random)paramBundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT"));
      a.putAll(paramBundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
      int i = 0;
      while (i < localArrayList2.size())
      {
        paramBundle = (String)localArrayList2.get(i);
        if (b.containsKey(paramBundle))
        {
          Integer localInteger = (Integer)b.remove(paramBundle);
          if (!a.containsKey(paramBundle)) {
            c.remove(localInteger);
          }
        }
        a(((Integer)localArrayList1.get(i)).intValue(), (String)localArrayList2.get(i));
        i += 1;
      }
    }
  }
  
  final void a(String paramString)
  {
    if (!p.contains(paramString))
    {
      localObject = (Integer)b.remove(paramString);
      if (localObject != null) {
        c.remove(localObject);
      }
    }
    w.remove(paramString);
    if (m.containsKey(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Dropping pending result for request ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(m.get(paramString));
      Log.w("ActivityResultRegistry", ((StringBuilder)localObject).toString());
      m.remove(paramString);
    }
    if (a.containsKey(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Dropping pending result for request ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(a.getParcelable(paramString));
      Log.w("ActivityResultRegistry", ((StringBuilder)localObject).toString());
      a.remove(paramString);
    }
    Object localObject = (d)d.get(paramString);
    if (localObject != null)
    {
      ((d)localObject).a();
      d.remove(paramString);
    }
  }
  
  public final boolean a(int paramInt, Object paramObject)
  {
    String str = (String)c.get(Integer.valueOf(paramInt));
    if (str == null) {
      return false;
    }
    Object localObject = (c)w.get(str);
    if (localObject != null)
    {
      localObject = l;
      if (localObject != null)
      {
        if (!p.remove(str)) {
          break label100;
        }
        ((AnnotationVisitor)localObject).onActivityResult(paramObject);
        break label100;
      }
    }
    a.remove(str);
    m.put(str, paramObject);
    label100:
    return true;
  }
  
  public final void set(Bundle paramBundle)
  {
    paramBundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(b.values()));
    paramBundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(b.keySet()));
    paramBundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(p));
    paramBundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle)a.clone());
    paramBundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", r);
  }
  
  public final boolean set(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = (String)c.get(Integer.valueOf(paramInt1));
    if (str == null) {
      return false;
    }
    a(str, paramInt2, paramIntent, (c)w.get(str));
    return true;
  }
  
  class a
    extends b<I>
  {
    a(String paramString, ClassWriter paramClassWriter) {}
    
    public void a()
    {
      a(paramString);
    }
    
    public void a(Object paramObject, Handle paramHandle)
    {
      Object localObject = (Integer)b.get(paramString);
      if (localObject != null)
      {
        p.add(paramString);
        ActivityResultRegistry localActivityResultRegistry = ActivityResultRegistry.this;
        try
        {
          int i = ((Integer)localObject).intValue();
          localObject = paramClassWriter;
          localActivityResultRegistry.a(i, (ClassWriter)localObject, paramObject, paramHandle);
          return;
        }
        catch (Exception paramObject)
        {
          p.remove(paramString);
          throw paramObject;
        }
      }
      paramHandle = new StringBuilder();
      paramHandle.append("Attempting to launch an unregistered ActivityResultLauncher with contract ");
      paramHandle.append(paramClassWriter);
      paramHandle.append(" and input ");
      paramHandle.append(paramObject);
      paramHandle.append(". You must ensure the ActivityResultLauncher is registered before calling launch().");
      throw new IllegalStateException(paramHandle.toString());
    }
  }
  
  class b
    extends b<I>
  {
    b(String paramString, ClassWriter paramClassWriter) {}
    
    public void a()
    {
      a(paramString);
    }
    
    public void a(Object paramObject, Handle paramHandle)
    {
      Object localObject = (Integer)b.get(paramString);
      if (localObject != null)
      {
        p.add(paramString);
        ActivityResultRegistry localActivityResultRegistry = ActivityResultRegistry.this;
        try
        {
          int i = ((Integer)localObject).intValue();
          localObject = paramClassWriter;
          localActivityResultRegistry.a(i, (ClassWriter)localObject, paramObject, paramHandle);
          return;
        }
        catch (Exception paramObject)
        {
          p.remove(paramString);
          throw paramObject;
        }
      }
      paramHandle = new StringBuilder();
      paramHandle.append("Attempting to launch an unregistered ActivityResultLauncher with contract ");
      paramHandle.append(paramClassWriter);
      paramHandle.append(" and input ");
      paramHandle.append(paramObject);
      paramHandle.append(". You must ensure the ActivityResultLauncher is registered before calling launch().");
      throw new IllegalStateException(paramHandle.toString());
    }
  }
  
  private static class c<O>
  {
    final androidx.activity.result.d.a<?, O> b;
    final a<O> l;
    
    c(AnnotationVisitor paramAnnotationVisitor, ClassWriter paramClassWriter)
    {
      l = paramAnnotationVisitor;
      b = paramClassWriter;
    }
  }
  
  private static class d
  {
    private final ArrayList<k> q;
    final Lifecycle r;
    
    d(Lifecycle paramLifecycle)
    {
      r = paramLifecycle;
      q = new ArrayList();
    }
    
    void a()
    {
      Iterator localIterator = q.iterator();
      while (localIterator.hasNext())
      {
        LayoutManager localLayoutManager = (LayoutManager)localIterator.next();
        r.clear(localLayoutManager);
      }
      q.clear();
    }
    
    void a(LayoutManager paramLayoutManager)
    {
      r.a(paramLayoutManager);
      q.add(paramLayoutManager);
    }
  }
}

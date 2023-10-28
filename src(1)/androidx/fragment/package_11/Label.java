package androidx.fragment.package_11;

import android.util.Log;
import androidx.fragment.app.v;
import androidx.lifecycle.ClassReader;
import androidx.lifecycle.ClassWriter;
import androidx.lifecycle.f0.b;
import androidx.lifecycle.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class Label
  extends androidx.lifecycle.Label
{
  private static final f0.b h = new Type();
  private final HashMap<String, androidx.fragment.app.Fragment> a = new HashMap();
  private final boolean b;
  private final HashMap<String, v> c = new HashMap();
  private final HashMap<String, i0> data = new HashMap();
  private boolean f = false;
  private boolean i = false;
  private boolean p = false;
  
  Label(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  static Label a(ClassWriter paramClassWriter)
  {
    return (Label)new ClassReader(paramClassWriter, h).a(v.class);
  }
  
  private void a(String paramString)
  {
    Object localObject = (Label)c.get(paramString);
    if (localObject != null)
    {
      ((Label)localObject).onCleared();
      c.remove(paramString);
    }
    localObject = (ClassWriter)data.get(paramString);
    if (localObject != null)
    {
      ((ClassWriter)localObject).a();
      data.remove(paramString);
    }
  }
  
  Label a(Fragment paramFragment)
  {
    Label localLabel2 = (Label)c.get(mWho);
    Label localLabel1 = localLabel2;
    if (localLabel2 == null)
    {
      localLabel1 = new Label(b);
      c.put(mWho, localLabel1);
    }
    return localLabel1;
  }
  
  Collection a()
  {
    return new ArrayList(a.values());
  }
  
  void add(Fragment paramFragment)
  {
    if (f)
    {
      if (FragmentManager.get(2)) {
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
      }
    }
    else
    {
      if (a.containsKey(mWho)) {
        return;
      }
      a.put(mWho, paramFragment);
      if (FragmentManager.get(2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Updating retained Fragments: Added ");
        localStringBuilder.append(paramFragment);
        Log.v("FragmentManager", localStringBuilder.toString());
      }
    }
  }
  
  void add(String paramString)
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Clearing non-config state for saved state of Fragment ");
      localStringBuilder.append(paramString);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    a(paramString);
  }
  
  void dump(Fragment paramFragment)
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Clearing non-config state for ");
      localStringBuilder.append(paramFragment);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    a(mWho);
  }
  
  void e(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  boolean equals()
  {
    return p;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (v.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Label)paramObject;
      if ((a.equals(a)) && (c.equals(c)) && (data.equals(data))) {
        return true;
      }
    }
    return false;
  }
  
  Fragment getColor(String paramString)
  {
    return (Fragment)a.get(paramString);
  }
  
  public int hashCode()
  {
    return (a.hashCode() * 31 + c.hashCode()) * 31 + data.hashCode();
  }
  
  ClassWriter init(Fragment paramFragment)
  {
    ClassWriter localClassWriter2 = (ClassWriter)data.get(mWho);
    ClassWriter localClassWriter1 = localClassWriter2;
    if (localClassWriter2 == null)
    {
      localClassWriter1 = new ClassWriter();
      data.put(mWho, localClassWriter1);
    }
    return localClassWriter1;
  }
  
  protected void onCleared()
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCleared called for ");
      localStringBuilder.append(this);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    p = true;
  }
  
  void release(Fragment paramFragment)
  {
    if (f)
    {
      if (FragmentManager.get(2)) {
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
      }
    }
    else
    {
      int j;
      if (a.remove(mWho) != null) {
        j = 1;
      } else {
        j = 0;
      }
      if ((j != 0) && (FragmentManager.get(2)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Updating retained Fragments: Removed ");
        localStringBuilder.append(paramFragment);
        Log.v("FragmentManager", localStringBuilder.toString());
      }
    }
  }
  
  boolean remove(Fragment paramFragment)
  {
    if (!a.containsKey(mWho)) {
      return true;
    }
    if (b) {
      return p;
    }
    return i ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FragmentManagerViewModel{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("} Fragments (");
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") Child Non Config (");
    localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") ViewModelStores (");
    localIterator = data.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

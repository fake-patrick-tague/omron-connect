package androidx.fragment.package_11;

import android.view.ViewGroup;
import androidx.fragment.app.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class System
{
  private Label a;
  private final ArrayList<androidx.fragment.app.Fragment> buffer = new ArrayList();
  private final HashMap<String, y> c = new HashMap();
  private final HashMap<String, androidx.fragment.app.FragmentState> m = new HashMap();
  
  System() {}
  
  void a()
  {
    Iterator localIterator = buffer.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Fragment)localIterator.next();
      localObject = (Log)c.get(mWho);
      if (localObject != null) {
        ((Log)localObject).run();
      }
    }
    localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Log)localIterator.next();
      if (localObject != null)
      {
        ((Log)localObject).run();
        Fragment localFragment = ((Log)localObject).getValue();
        int i;
        if ((mRemoving) && (!localFragment.isInBackStack())) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if ((mBeingSaved) && (!m.containsKey(mWho))) {
            ((Log)localObject).saveAllState();
          }
          get((Log)localObject);
        }
      }
    }
  }
  
  void a(ArrayList paramArrayList)
  {
    m.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      FragmentState localFragmentState = (FragmentState)paramArrayList.next();
      m.put(c, localFragmentState);
    }
  }
  
  void add(Fragment paramFragment)
  {
    if (!buffer.contains(paramFragment))
    {
      localObject = buffer;
      try
      {
        buffer.add(paramFragment);
        mAdded = true;
        return;
      }
      catch (Throwable paramFragment)
      {
        throw paramFragment;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment already added: ");
    ((StringBuilder)localObject).append(paramFragment);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  void add(Log paramLog)
  {
    Fragment localFragment = paramLog.getValue();
    if (remove(mWho)) {
      return;
    }
    c.put(mWho, paramLog);
    if (mRetainInstanceChangedWhileDetached)
    {
      if (mRetainInstance) {
        a.add(localFragment);
      } else {
        a.release(localFragment);
      }
      mRetainInstanceChangedWhileDetached = false;
    }
    if (FragmentManager.get(2))
    {
      paramLog = new StringBuilder();
      paramLog.append("Added fragment to active set ");
      paramLog.append(localFragment);
      android.util.Log.v("FragmentManager", paramLog.toString());
    }
  }
  
  Fragment create(String paramString)
  {
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Log)localIterator.next();
      if (localObject != null)
      {
        localObject = ((Log)localObject).getValue().findFragmentByWho(paramString);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  ArrayList dump()
  {
    ArrayList localArrayList = new ArrayList(c.size());
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Log)localIterator.next();
      if (localObject != null)
      {
        Fragment localFragment = ((Log)localObject).getValue();
        ((Log)localObject).saveAllState();
        localArrayList.add(mWho);
        if (FragmentManager.get(2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Saved state of ");
          ((StringBuilder)localObject).append(localFragment);
          ((StringBuilder)localObject).append(": ");
          ((StringBuilder)localObject).append(mSavedFragmentState);
          android.util.Log.v("FragmentManager", ((StringBuilder)localObject).toString());
        }
      }
    }
    return localArrayList;
  }
  
  void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("    ");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (!c.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Fragments:");
      Iterator localIterator = c.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Log)localIterator.next();
        paramPrintWriter.print(paramString);
        if (localObject2 != null)
        {
          localObject2 = ((Log)localObject2).getValue();
          paramPrintWriter.println(localObject2);
          ((Fragment)localObject2).dump((String)localObject1, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        else
        {
          paramPrintWriter.println("null");
        }
      }
    }
    int j = buffer.size();
    if (j > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      int i = 0;
      while (i < j)
      {
        paramFileDescriptor = (Fragment)buffer.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
  }
  
  int get(Fragment paramFragment)
  {
    ViewGroup localViewGroup = mContainer;
    if (localViewGroup == null) {
      return -1;
    }
    int j = buffer.indexOf(paramFragment);
    int i = j;
    int k = j - 1;
    for (;;)
    {
      j = i;
      if (k < 0) {
        break;
      }
      paramFragment = (Fragment)buffer.get(k);
      if (mContainer == localViewGroup)
      {
        paramFragment = mView;
        if (paramFragment != null) {
          return localViewGroup.indexOfChild(paramFragment) + 1;
        }
      }
      k -= 1;
    }
    do
    {
      do
      {
        i = j + 1;
        if (i >= buffer.size()) {
          break;
        }
        paramFragment = (Fragment)buffer.get(i);
        j = i;
      } while (mContainer != localViewGroup);
      paramFragment = mView;
      j = i;
    } while (paramFragment == null);
    return localViewGroup.indexOfChild(paramFragment);
    return -1;
  }
  
  Fragment get(int paramInt)
  {
    int i = buffer.size() - 1;
    while (i >= 0)
    {
      localObject1 = (Fragment)buffer.get(i);
      if ((localObject1 != null) && (mFragmentId == paramInt)) {
        return localObject1;
      }
      i -= 1;
    }
    Object localObject1 = c.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Log)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((Log)localObject2).getValue();
        if (mFragmentId == paramInt) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  Fragment get(String paramString)
  {
    paramString = (Log)c.get(paramString);
    if (paramString != null) {
      return paramString.getValue();
    }
    return null;
  }
  
  FragmentState get(String paramString, FragmentState paramFragmentState)
  {
    if (paramFragmentState != null) {
      return (FragmentState)m.put(paramString, paramFragmentState);
    }
    return (FragmentState)m.remove(paramString);
  }
  
  List get()
  {
    if (buffer.isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList1 = buffer;
    try
    {
      ArrayList localArrayList2 = new ArrayList(buffer);
      return localArrayList2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void get(Log paramLog)
  {
    paramLog = paramLog.getValue();
    if (mRetainInstance) {
      a.release(paramLog);
    }
    if ((Log)c.put(mWho, null) == null) {
      return;
    }
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Removed fragment from active set ");
      localStringBuilder.append(paramLog);
      android.util.Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  List getAll()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      Log localLog = (Log)localIterator.next();
      if (localLog != null) {
        localArrayList.add(localLog.getValue());
      } else {
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  Log getInstance(String paramString)
  {
    return (Log)c.get(paramString);
  }
  
  ArrayList getSettings()
  {
    return new ArrayList(m.values());
  }
  
  Label getValue()
  {
    return a;
  }
  
  void goTo(Label paramLabel)
  {
    a = paramLabel;
  }
  
  void load(List paramList)
  {
    buffer.clear();
    if (paramList != null)
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (String)((Iterator)localObject).next();
        Fragment localFragment = get(paramList);
        if (localFragment != null)
        {
          if (FragmentManager.get(2))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreSaveState: added (");
            localStringBuilder.append(paramList);
            localStringBuilder.append("): ");
            localStringBuilder.append(localFragment);
            android.util.Log.v("FragmentManager", localStringBuilder.toString());
          }
          add(localFragment);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("No instantiated fragment for (");
          ((StringBuilder)localObject).append(paramList);
          ((StringBuilder)localObject).append(")");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  FragmentState put(String paramString)
  {
    return (FragmentState)m.get(paramString);
  }
  
  ArrayList read()
  {
    ArrayList localArrayList1 = buffer;
    try
    {
      if (buffer.isEmpty()) {
        return null;
      }
      ArrayList localArrayList2 = new ArrayList(buffer.size());
      Iterator localIterator = buffer.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        localArrayList2.add(mWho);
        if (FragmentManager.get(2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("saveAllState: adding fragment (");
          localStringBuilder.append(mWho);
          localStringBuilder.append("): ");
          localStringBuilder.append(localFragment);
          android.util.Log.v("FragmentManager", localStringBuilder.toString());
        }
      }
      return localArrayList2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void remove(Fragment paramFragment)
  {
    ArrayList localArrayList = buffer;
    try
    {
      buffer.remove(paramFragment);
      mAdded = false;
      return;
    }
    catch (Throwable paramFragment)
    {
      throw paramFragment;
    }
  }
  
  boolean remove(String paramString)
  {
    return c.get(paramString) != null;
  }
  
  void reset()
  {
    c.clear();
  }
  
  void reset(int paramInt)
  {
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      Log localLog = (Log)localIterator.next();
      if (localLog != null) {
        localLog.setText(paramInt);
      }
    }
  }
  
  List size()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      Log localLog = (Log)localIterator.next();
      if (localLog != null) {
        localArrayList.add(localLog);
      }
    }
    return localArrayList;
  }
  
  Fragment toString(String paramString)
  {
    Object localObject1;
    if (paramString != null)
    {
      int i = buffer.size() - 1;
      while (i >= 0)
      {
        localObject1 = (Fragment)buffer.get(i);
        if ((localObject1 != null) && (paramString.equals(mTag))) {
          return localObject1;
        }
        i -= 1;
      }
    }
    if (paramString != null)
    {
      localObject1 = c.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Log)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((Log)localObject2).getValue();
          if (paramString.equals(mTag)) {
            return localObject2;
          }
        }
      }
    }
    return null;
  }
  
  void write()
  {
    c.values().removeAll(Collections.singleton(null));
  }
}

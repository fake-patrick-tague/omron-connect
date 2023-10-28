package androidx.work.impl.asm;

import androidx.work.WorkInfo;
import androidx.work.WorkInfo.State;
import androidx.work.d;
import java.util.List;
import java.util.UUID;

public class Label
{
  public List<d> a;
  public int b;
  public androidx.work.Label c;
  public List<String> f;
  public String h;
  public WorkInfo.State j;
  
  public Label() {}
  
  public WorkInfo a()
  {
    Object localObject = a;
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      localObject = (androidx.work.Label)a.get(0);
    } else {
      localObject = androidx.work.Label.c;
    }
    return new WorkInfo(UUID.fromString(h), j, c, f, (androidx.work.Label)localObject, b);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Label)) {
      return false;
    }
    paramObject = (Label)paramObject;
    if (b != b) {
      return false;
    }
    Object localObject = h;
    if (localObject != null)
    {
      if (!((String)localObject).equals(h)) {
        return false;
      }
    }
    else if (h != null) {
      return false;
    }
    if (j != j) {
      return false;
    }
    localObject = c;
    if (localObject != null)
    {
      if (!((androidx.work.Label)localObject).equals(c)) {
        return false;
      }
    }
    else if (c != null) {
      return false;
    }
    localObject = f;
    if (localObject != null)
    {
      if (!((List)localObject).equals(f)) {
        return false;
      }
    }
    else if (f != null) {
      return false;
    }
    localObject = a;
    paramObject = a;
    if (localObject != null) {
      return ((List)localObject).equals(paramObject);
    }
    return paramObject == null;
  }
  
  public int hashCode()
  {
    Object localObject = h;
    int i1 = 0;
    int i;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = j;
    int k;
    if (localObject != null) {
      k = ((Enum)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = c;
    int m;
    if (localObject != null) {
      m = ((androidx.work.Label)localObject).hashCode();
    } else {
      m = 0;
    }
    int i2 = b;
    localObject = f;
    int n;
    if (localObject != null) {
      n = ((List)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = a;
    if (localObject != null) {
      i1 = ((List)localObject).hashCode();
    }
    return ((((i * 31 + k) * 31 + m) * 31 + i2) * 31 + n) * 31 + i1;
  }
}

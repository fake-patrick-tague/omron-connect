package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo
{
  private Label a;
  private State b;
  private Label c;
  private UUID g;
  private int j;
  private Set<String> s;
  
  public WorkInfo(UUID paramUUID, State paramState, Label paramLabel1, List paramList, Label paramLabel2, int paramInt)
  {
    g = paramUUID;
    b = paramState;
    c = paramLabel1;
    s = new HashSet(paramList);
    a = paramLabel2;
    j = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (WorkInfo.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (WorkInfo)paramObject;
      if (j != j) {
        return false;
      }
      if (!g.equals(g)) {
        return false;
      }
      if (b != b) {
        return false;
      }
      if (!c.equals(c)) {
        return false;
      }
      if (!s.equals(s)) {
        return false;
      }
      return a.equals(a);
    }
    return false;
  }
  
  public State getItemData()
  {
    return b;
  }
  
  public int hashCode()
  {
    return ((((g.hashCode() * 31 + b.hashCode()) * 31 + c.hashCode()) * 31 + s.hashCode()) * 31 + a.hashCode()) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WorkInfo{mId='");
    localStringBuilder.append(g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mState=");
    localStringBuilder.append(b);
    localStringBuilder.append(", mOutputData=");
    localStringBuilder.append(c);
    localStringBuilder.append(", mTags=");
    localStringBuilder.append(s);
    localStringBuilder.append(", mProgress=");
    localStringBuilder.append(a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static enum State
  {
    static
    {
      State localState1 = new State("ENQUEUED", 0);
      a = localState1;
      State localState2 = new State("RUNNING", 1);
      b = localState2;
      State localState3 = new State("SUCCEEDED", 2);
      i = localState3;
      State localState4 = new State("FAILED", 3);
      d = localState4;
      State localState5 = new State("BLOCKED", 4);
      p = localState5;
      State localState6 = new State("CANCELLED", 5);
      c = localState6;
      e = new State[] { localState1, localState2, localState3, localState4, localState5, localState6 };
    }
    
    public boolean next()
    {
      return (this == i) || (this == d) || (this == c);
    }
  }
}

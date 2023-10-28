package androidx.room.core;

import androidx.room.q.f.b;
import java.util.Collections;
import java.util.List;

public class Segment
{
  public final String a;
  public final String b;
  public final String d;
  public final List<String> f;
  public final List<String> source;
  
  public Segment(String paramString1, String paramString2, String paramString3, List paramList1, List paramList2)
  {
    d = paramString1;
    a = paramString2;
    b = paramString3;
    f = Collections.unmodifiableList(paramList1);
    source = Collections.unmodifiableList(paramList2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (f.b.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Segment)paramObject;
      if (!d.equals(d)) {
        return false;
      }
      if (!a.equals(a)) {
        return false;
      }
      if (!b.equals(b)) {
        return false;
      }
      if (!f.equals(f)) {
        return false;
      }
      return source.equals(source);
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((d.hashCode() * 31 + a.hashCode()) * 31 + b.hashCode()) * 31 + f.hashCode()) * 31 + source.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ForeignKey{referenceTable='");
    localStringBuilder.append(d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", onDelete='");
    localStringBuilder.append(a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", onUpdate='");
    localStringBuilder.append(b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columnNames=");
    localStringBuilder.append(f);
    localStringBuilder.append(", referenceColumnNames=");
    localStringBuilder.append(source);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

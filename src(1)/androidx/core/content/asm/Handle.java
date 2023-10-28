package androidx.core.content.asm;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import androidx.core.content.g.j.e;
import v7.v7.util.Context;

final class Handle
{
  final Resources.Theme a;
  final Resources f;
  
  Handle(Resources paramResources, Resources.Theme paramTheme)
  {
    f = paramResources;
    a = paramTheme;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (j.e.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Handle)paramObject;
      if ((f.equals(f)) && (Context.equals(a, a))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return Context.getType(new Object[] { f, a });
  }
}

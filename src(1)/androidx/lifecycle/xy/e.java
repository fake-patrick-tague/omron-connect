package androidx.lifecycle.xy;

import androidx.lifecycle.Label;
import androidx.lifecycle.f0.b;
import kotlin.x.c.l;
import kotlin.x.d.i;

public final class e
  implements f0.b
{
  private final androidx.lifecycle.n0.f<?>[] c;
  
  public e(f... paramVarArgs)
  {
    c = paramVarArgs;
  }
  
  public Label a(Class paramClass, a paramA)
  {
    i.e(paramClass, "modelClass");
    i.e(paramA, "extras");
    f[] arrayOfF = c;
    int j = arrayOfF.length;
    int i = 0;
    Object localObject = null;
    while (i < j)
    {
      f localF = arrayOfF[i];
      if (i.a(localF.a(), paramClass))
      {
        localObject = localF.m().invoke(paramA);
        if ((localObject instanceof Label)) {
          localObject = (Label)localObject;
        } else {
          localObject = null;
        }
      }
      i += 1;
    }
    if (localObject != null) {
      return localObject;
    }
    paramA = new StringBuilder();
    paramA.append("No initializer set for given class ");
    paramA.append(paramClass.getName());
    throw new IllegalArgumentException(paramA.toString());
  }
}

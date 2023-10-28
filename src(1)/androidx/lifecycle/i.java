package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.c;

public final class i
{
  private static final List<Class<?>> a = kotlin.collections.i.f(new Class[] { Application.class, x.class });
  private static final List<Class<?>> b = kotlin.collections.i.b(x.class);
  
  public static final Constructor a(Class paramClass, List paramList)
  {
    kotlin.x.d.i.e(paramClass, "modelClass");
    kotlin.x.d.i.e(paramList, "signature");
    Object localObject1 = paramClass.getConstructors();
    kotlin.x.d.i.d(localObject1, "modelClass.constructors");
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Constructor localConstructor = localObject1[i];
      Object localObject2 = localConstructor.getParameterTypes();
      kotlin.x.d.i.d(localObject2, "constructor.parameterTypes");
      localObject2 = c.t((Object[])localObject2);
      if (kotlin.x.d.i.a(paramList, localObject2)) {
        return localConstructor;
      }
      if ((paramList.size() == ((List)localObject2).size()) && (((List)localObject2).containsAll(paramList)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Class ");
        ((StringBuilder)localObject1).append(paramClass.getSimpleName());
        ((StringBuilder)localObject1).append(" must have parameters in the proper order: ");
        ((StringBuilder)localObject1).append(paramList);
        throw new UnsupportedOperationException(((StringBuilder)localObject1).toString());
      }
      i += 1;
    }
    return null;
  }
  
  public static final Label invoke(Class paramClass, Constructor paramConstructor, Object... paramVarArgs)
  {
    kotlin.x.d.i.e(paramClass, "modelClass");
    kotlin.x.d.i.e(paramConstructor, "constructor");
    kotlin.x.d.i.e(paramVarArgs, "params");
    int i = paramVarArgs.length;
    try
    {
      paramConstructor = paramConstructor.newInstance(Arrays.copyOf(paramVarArgs, i));
      return (Label)paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("An exception happened in constructor of ");
      paramVarArgs.append(paramClass);
      throw new RuntimeException(paramVarArgs.toString(), paramConstructor.getCause());
    }
    catch (InstantiationException paramConstructor)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("A ");
      paramVarArgs.append(paramClass);
      paramVarArgs.append(" cannot be instantiated.");
      throw new RuntimeException(paramVarArgs.toString(), paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("Failed to access ");
      paramVarArgs.append(paramClass);
      throw new RuntimeException(paramVarArgs.toString(), paramConstructor);
    }
  }
}

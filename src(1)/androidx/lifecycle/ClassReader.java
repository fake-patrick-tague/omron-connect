package androidx.lifecycle;

import androidx.lifecycle.xy.PositionMetric;
import androidx.lifecycle.xy.a;
import java.util.Objects;
import kotlin.x.d.i;

public class ClassReader
{
  private final ClassWriter a;
  private final a b;
  private final f0.b c;
  
  public ClassReader(ClassWriter paramClassWriter, f0.b paramB)
  {
    this(paramClassWriter, paramB, null, 4, null);
  }
  
  public ClassReader(ClassWriter paramClassWriter, f0.b paramB, a paramA)
  {
    a = paramClassWriter;
    c = paramB;
    b = paramA;
  }
  
  public ClassReader(h paramH)
  {
    this(localClassWriter, f0.a.l.a(paramH), x.a(paramH));
  }
  
  public ClassReader(h paramH, f0.b paramB)
  {
    this(localClassWriter, paramB, x.a(paramH));
  }
  
  public Label a(Class paramClass)
  {
    i.e(paramClass, "modelClass");
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
      localStringBuilder.append(str);
      return a(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  public Label a(String paramString, Class paramClass)
  {
    i.e(paramString, "key");
    i.e(paramClass, "modelClass");
    Object localObject = a.a(paramString);
    if (paramClass.isInstance(localObject))
    {
      paramString = c;
      if ((paramString instanceof f0.d)) {
        paramString = (f0.d)paramString;
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        i.d(localObject, "viewModel");
        paramString.b((Label)localObject);
      }
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
      return localObject;
    }
    localObject = new PositionMetric(b);
    ((PositionMetric)localObject).a(f0.c.d, paramString);
    f0.b localB = c;
    try
    {
      localObject = localB.a(paramClass, (a)localObject);
      paramClass = (Class)localObject;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      for (;;) {}
    }
    paramClass = c.a(paramClass);
    a.a(paramString, paramClass);
    return paramClass;
  }
}

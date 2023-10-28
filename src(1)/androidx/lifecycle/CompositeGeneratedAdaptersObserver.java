package androidx.lifecycle;

class CompositeGeneratedAdaptersObserver
  implements LayoutManager
{
  private final Attribute[] a;
  
  CompositeGeneratedAdaptersObserver(Attribute[] paramArrayOfAttribute)
  {
    a = paramArrayOfAttribute;
  }
  
  public void b(d paramD, Lifecycle.Event paramEvent)
  {
    AnnotationVisitor localAnnotationVisitor = new AnnotationVisitor();
    Attribute[] arrayOfAttribute = a;
    int k = arrayOfAttribute.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      arrayOfAttribute[i].a(paramD, paramEvent, false, localAnnotationVisitor);
      i += 1;
    }
    arrayOfAttribute = a;
    k = arrayOfAttribute.length;
    i = j;
    while (i < k)
    {
      arrayOfAttribute[i].a(paramD, paramEvent, true, localAnnotationVisitor);
      i += 1;
    }
  }
}

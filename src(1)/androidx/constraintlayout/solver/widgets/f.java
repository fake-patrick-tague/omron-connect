package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Edge;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.Attribute;
import androidx.constraintlayout.solver.widgets.analyzer.SignatureReader;
import androidx.constraintlayout.solver.widgets.analyzer.g;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class f
  extends ByteVector
{
  public int B = 0;
  protected androidx.constraintlayout.solver.ClassWriter a = new androidx.constraintlayout.solver.ClassWriter();
  i[] b = new i[4];
  public Edge c;
  int count;
  public androidx.constraintlayout.solver.widgets.analyzer.ByteVector d = new androidx.constraintlayout.solver.widgets.analyzer.ByteVector(this);
  private boolean e = false;
  public boolean end = false;
  public boolean f = false;
  private boolean g = false;
  public androidx.constraintlayout.solver.widgets.analyzer.ClassWriter h = new androidx.constraintlayout.solver.widgets.analyzer.ClassWriter();
  int height;
  private int i = 257;
  protected androidx.constraintlayout.solver.widgets.analyzer.Item j = null;
  private boolean k = false;
  public int l = 0;
  i[] m = new i[4];
  public int n = 0;
  public boolean p = false;
  Attribute q = new Attribute(this);
  private WeakReference<ConstraintAnchor> r = null;
  private WeakReference<ConstraintAnchor> s = null;
  private WeakReference<ConstraintAnchor> t = null;
  int u = 0;
  private WeakReference<ConstraintAnchor> v = null;
  public int w = 0;
  public boolean x = false;
  int y;
  int z;
  
  public f() {}
  
  private void a(ConstraintAnchor paramConstraintAnchor, SolverVariable paramSolverVariable)
  {
    paramConstraintAnchor = a.a(paramConstraintAnchor);
    a.d(paramSolverVariable, paramConstraintAnchor, 0, 5);
  }
  
  public static boolean a(ConstraintWidget paramConstraintWidget, androidx.constraintlayout.solver.widgets.analyzer.Item paramItem, androidx.constraintlayout.solver.widgets.analyzer.ClassWriter paramClassWriter, int paramInt)
  {
    if (paramItem == null) {
      return false;
    }
    i = paramConstraintWidget.iterator();
    b = paramConstraintWidget.size();
    f = paramConstraintWidget.getValue();
    j = paramConstraintWidget.length();
    k = false;
    c = paramInt;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = i;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.b;
    if (localDimensionBehaviour1 == localDimensionBehaviour2) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i1;
    if (b == localDimensionBehaviour2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i4;
    if ((paramInt != 0) && (right > 0.0F)) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int i3;
    if ((i1 != 0) && (right > 0.0F)) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i2 = paramInt;
    if (paramInt != 0)
    {
      i2 = paramInt;
      if (paramConstraintWidget.equals(0))
      {
        i2 = paramInt;
        if (i == 0)
        {
          i2 = paramInt;
          if (i4 == 0)
          {
            i = ConstraintWidget.DimensionBehaviour.c;
            if ((i1 != 0) && (n == 0)) {
              i = ConstraintWidget.DimensionBehaviour.a;
            }
            i2 = 0;
          }
        }
      }
    }
    paramInt = i1;
    if (i1 != 0)
    {
      paramInt = i1;
      if (paramConstraintWidget.equals(1))
      {
        paramInt = i1;
        if (n == 0)
        {
          paramInt = i1;
          if (i3 == 0)
          {
            b = ConstraintWidget.DimensionBehaviour.c;
            if ((i2 != 0) && (i == 0)) {
              b = ConstraintWidget.DimensionBehaviour.a;
            }
            paramInt = 0;
          }
        }
      }
    }
    if (paramConstraintWidget.h())
    {
      i = ConstraintWidget.DimensionBehaviour.a;
      i2 = 0;
    }
    if (paramConstraintWidget.j())
    {
      b = ConstraintWidget.DimensionBehaviour.a;
      paramInt = 0;
    }
    if (i4 != 0) {
      if (o[0] == 4)
      {
        i = ConstraintWidget.DimensionBehaviour.a;
      }
      else if (paramInt == 0)
      {
        localDimensionBehaviour1 = b;
        localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.a;
        if (localDimensionBehaviour1 == localDimensionBehaviour2)
        {
          paramInt = j;
        }
        else
        {
          i = ConstraintWidget.DimensionBehaviour.c;
          paramItem.a(paramConstraintWidget, paramClassWriter);
          paramInt = s;
        }
        i = localDimensionBehaviour2;
        i1 = top;
        if ((i1 != 0) && (i1 != -1)) {
          f = ((int)(paramConstraintWidget.p() / paramInt));
        } else {
          f = ((int)(paramConstraintWidget.p() * paramInt));
        }
      }
    }
    if (i3 != 0) {
      if (o[1] == 4)
      {
        b = ConstraintWidget.DimensionBehaviour.a;
      }
      else if (i2 == 0)
      {
        localDimensionBehaviour1 = i;
        localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.a;
        if (localDimensionBehaviour1 == localDimensionBehaviour2)
        {
          paramInt = f;
        }
        else
        {
          b = ConstraintWidget.DimensionBehaviour.c;
          paramItem.a(paramConstraintWidget, paramClassWriter);
          paramInt = z;
        }
        b = localDimensionBehaviour2;
        i1 = top;
        if ((i1 != 0) && (i1 != -1)) {
          j = ((int)(paramInt * paramConstraintWidget.p()));
        } else {
          j = ((int)(paramInt / paramConstraintWidget.p()));
        }
      }
    }
    paramItem.a(paramConstraintWidget, paramClassWriter);
    paramConstraintWidget.get(z);
    paramConstraintWidget.append(s);
    paramConstraintWidget.append(e);
    paramConstraintWidget.putShort(q);
    c = androidx.constraintlayout.solver.widgets.analyzer.ClassWriter.a;
    return k;
  }
  
  private void b(ConstraintAnchor paramConstraintAnchor, SolverVariable paramSolverVariable)
  {
    paramConstraintAnchor = a.a(paramConstraintAnchor);
    a.d(paramConstraintAnchor, paramSolverVariable, 0, 5);
  }
  
  private void b(ConstraintWidget paramConstraintWidget)
  {
    int i1 = l;
    i[] arrayOfI = b;
    if (i1 + 1 >= arrayOfI.length) {
      b = ((i[])Arrays.copyOf(arrayOfI, arrayOfI.length * 2));
    }
    b[l] = new i(paramConstraintWidget, 0, c());
    l += 1;
  }
  
  private void clear(ConstraintWidget paramConstraintWidget)
  {
    int i1 = n;
    i[] arrayOfI = m;
    if (i1 + 1 >= arrayOfI.length) {
      m = ((i[])Arrays.copyOf(arrayOfI, arrayOfI.length * 2));
    }
    m[n] = new i(paramConstraintWidget, 1, c());
    n += 1;
  }
  
  private void g()
  {
    l = 0;
    n = 0;
  }
  
  public void a()
  {
    type = 0;
    next = 0;
    e = false;
    g = false;
    int i9 = a.size();
    int i2 = Math.max(0, getValue());
    int i5 = i2;
    int i4 = Math.max(0, length());
    int i3 = i4;
    Object localObject2 = u;
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[0];
    if (c == null)
    {
      Object localObject7;
      int i6;
      if (Frame.b(i, 1))
      {
        g.a(this, r());
        i1 = 0;
        while (i1 < i9)
        {
          localObject3 = (ConstraintWidget)a.get(i1);
          if ((((ConstraintWidget)localObject3).l()) && (!(localObject3 instanceof h)) && (!(localObject3 instanceof m)) && (!(localObject3 instanceof d)) && (!((ConstraintWidget)localObject3).getRangeOrigin()))
          {
            localObject4 = ((ConstraintWidget)localObject3).valueOf(0);
            localObject6 = ((ConstraintWidget)localObject3).valueOf(1);
            localObject7 = ConstraintWidget.DimensionBehaviour.b;
            if ((localObject4 == localObject7) && (i != 1) && (localObject6 == localObject7) && (n != 1)) {
              i6 = 1;
            } else {
              i6 = 0;
            }
            if (i6 == 0)
            {
              localObject4 = new androidx.constraintlayout.solver.widgets.analyzer.ClassWriter();
              a((ConstraintWidget)localObject3, j, (androidx.constraintlayout.solver.widgets.analyzer.ClassWriter)localObject4, androidx.constraintlayout.solver.widgets.analyzer.ClassWriter.a);
            }
          }
          i1 += 1;
        }
      }
      if (i9 > 2)
      {
        localObject3 = ConstraintWidget.DimensionBehaviour.c;
        if (((localObject2 == localObject3) || (localObject1 == localObject3)) && (Frame.b(i, 1024)) && (SignatureReader.a(this, r())))
        {
          i1 = i5;
          if (localObject2 == localObject3) {
            if ((i2 < getValue()) && (i2 > 0))
            {
              get(i2);
              e = true;
              i1 = i5;
            }
            else
            {
              i1 = getValue();
            }
          }
          i2 = i3;
          if (localObject1 == localObject3) {
            if ((i4 < length()) && (i4 > 0))
            {
              append(i4);
              g = true;
              i2 = i3;
            }
            else
            {
              i2 = length();
            }
          }
          i3 = 1;
          i4 = i2;
          i5 = i1;
          i1 = i3;
          break label411;
        }
      }
      int i1 = 0;
      i5 = i2;
      label411:
      if ((!b(64)) && (!b(128))) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      Object localObject3 = a;
      B = false;
      w = false;
      if ((i != 0) && (i2 != 0)) {
        w = true;
      }
      localObject3 = a;
      Object localObject4 = iterator();
      Object localObject6 = ConstraintWidget.DimensionBehaviour.c;
      if ((localObject4 != localObject6) && (size() != localObject6)) {
        i6 = 0;
      } else {
        i6 = 1;
      }
      g();
      i2 = 0;
      while (i2 < i9)
      {
        localObject4 = (ConstraintWidget)a.get(i2);
        if ((localObject4 instanceof ByteVector)) {
          ((ByteVector)localObject4).a();
        }
        i2 += 1;
      }
      boolean bool4 = b(64);
      boolean bool1 = true;
      i3 = 0;
      while (bool1)
      {
        int i8 = i3 + 1;
        localObject4 = a;
        boolean bool2 = bool1;
        boolean bool3;
        try
        {
          ((androidx.constraintlayout.solver.ClassWriter)localObject4).a();
          bool2 = bool1;
          g();
          localObject4 = a;
          bool2 = bool1;
          b((androidx.constraintlayout.solver.ClassWriter)localObject4);
          i2 = 0;
          while (i2 < i9)
          {
            localObject4 = a;
            bool2 = bool1;
            localObject4 = ((ArrayList)localObject4).get(i2);
            localObject4 = (ConstraintWidget)localObject4;
            localObject6 = a;
            bool2 = bool1;
            ((ConstraintWidget)localObject4).b((androidx.constraintlayout.solver.ClassWriter)localObject6);
            i2 += 1;
          }
          localObject4 = a;
          bool2 = bool1;
          bool3 = a((androidx.constraintlayout.solver.ClassWriter)localObject4);
          bool1 = bool3;
          localObject4 = v;
          if (localObject4 != null)
          {
            bool2 = bool1;
            localObject4 = ((WeakReference)localObject4).get();
            if (localObject4 != null)
            {
              localObject4 = v;
              bool2 = bool1;
              localObject4 = ((WeakReference)localObject4).get();
              localObject4 = (ConstraintAnchor)localObject4;
              localObject6 = a;
              localObject7 = c;
              bool2 = bool1;
              b((ConstraintAnchor)localObject4, ((androidx.constraintlayout.solver.ClassWriter)localObject6).a(localObject7));
              v = null;
            }
          }
          localObject4 = r;
          if (localObject4 != null)
          {
            bool2 = bool1;
            localObject4 = ((WeakReference)localObject4).get();
            if (localObject4 != null)
            {
              localObject4 = r;
              bool2 = bool1;
              localObject4 = ((WeakReference)localObject4).get();
              localObject4 = (ConstraintAnchor)localObject4;
              localObject6 = a;
              localObject7 = b;
              bool2 = bool1;
              a((ConstraintAnchor)localObject4, ((androidx.constraintlayout.solver.ClassWriter)localObject6).a(localObject7));
              r = null;
            }
          }
          localObject4 = t;
          if (localObject4 != null)
          {
            bool2 = bool1;
            localObject4 = ((WeakReference)localObject4).get();
            if (localObject4 != null)
            {
              localObject4 = t;
              bool2 = bool1;
              localObject4 = ((WeakReference)localObject4).get();
              localObject4 = (ConstraintAnchor)localObject4;
              localObject6 = a;
              localObject7 = a;
              bool2 = bool1;
              b((ConstraintAnchor)localObject4, ((androidx.constraintlayout.solver.ClassWriter)localObject6).a(localObject7));
              t = null;
            }
          }
          localObject4 = s;
          if (localObject4 != null)
          {
            bool2 = bool1;
            localObject4 = ((WeakReference)localObject4).get();
            if (localObject4 != null)
            {
              localObject4 = s;
              bool2 = bool1;
              localObject4 = ((WeakReference)localObject4).get();
              localObject4 = (ConstraintAnchor)localObject4;
              localObject6 = a;
              localObject7 = l;
              bool2 = bool1;
              a((ConstraintAnchor)localObject4, ((androidx.constraintlayout.solver.ClassWriter)localObject6).a(localObject7));
              s = null;
            }
          }
          bool2 = bool1;
          if (bool3)
          {
            localObject4 = a;
            bool2 = bool1;
            ((androidx.constraintlayout.solver.ClassWriter)localObject4).f();
            bool2 = bool1;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject6 = System.out;
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("EXCEPTION : ");
          ((StringBuilder)localObject7).append(localException);
          ((PrintStream)localObject6).println(((StringBuilder)localObject7).toString());
        }
        if (bool2)
        {
          a(a, Frame.d);
        }
        else
        {
          b(a, bool4);
          i2 = 0;
          while (i2 < i9)
          {
            ((ConstraintWidget)a.get(i2)).b(a, bool4);
            i2 += 1;
          }
        }
        Object localObject5;
        if ((i6 != 0) && (i8 < 8) && (Frame.d[2] != 0))
        {
          i3 = 0;
          int i7 = 0;
          i2 = 0;
          while (i3 < i9)
          {
            localObject5 = (ConstraintWidget)a.get(i3);
            i7 = Math.max(i7, type + ((ConstraintWidget)localObject5).getValue());
            i2 = Math.max(i2, next + ((ConstraintWidget)localObject5).length());
            i3 += 1;
          }
          i7 = Math.max(head, i7);
          i3 = Math.max(pos, i2);
          localObject5 = ConstraintWidget.DimensionBehaviour.c;
          if ((localObject2 == localObject5) && (getValue() < i7))
          {
            get(i7);
            u[0] = localObject5;
            bool2 = true;
            i2 = 1;
          }
          else
          {
            bool2 = false;
            i2 = i1;
          }
          i1 = i2;
          bool1 = bool2;
          if (localObject1 == localObject5)
          {
            i1 = i2;
            bool1 = bool2;
            if (length() < i3)
            {
              append(i3);
              u[1] = localObject5;
              bool1 = true;
              i1 = 1;
            }
          }
        }
        else
        {
          bool1 = false;
        }
        i2 = Math.max(head, getValue());
        if (i2 > getValue())
        {
          get(i2);
          u[0] = ConstraintWidget.DimensionBehaviour.a;
          bool1 = true;
          i1 = 1;
        }
        i2 = Math.max(pos, length());
        if (i2 > length())
        {
          append(i2);
          u[1] = ConstraintWidget.DimensionBehaviour.a;
          bool1 = true;
          i1 = 1;
        }
        i2 = i1;
        bool2 = bool1;
        if (i1 == 0)
        {
          localObject5 = u[0];
          localObject6 = ConstraintWidget.DimensionBehaviour.c;
          i3 = i1;
          bool3 = bool1;
          if (localObject5 == localObject6)
          {
            i3 = i1;
            bool3 = bool1;
            if (i5 > 0)
            {
              i3 = i1;
              bool3 = bool1;
              if (getValue() > i5)
              {
                e = true;
                u[0] = ConstraintWidget.DimensionBehaviour.a;
                get(i5);
                bool3 = true;
                i3 = 1;
              }
            }
          }
          i2 = i3;
          bool2 = bool3;
          if (u[1] == localObject6)
          {
            i2 = i3;
            bool2 = bool3;
            if (i4 > 0)
            {
              i2 = i3;
              bool2 = bool3;
              if (length() > i4)
              {
                g = true;
                u[1] = ConstraintWidget.DimensionBehaviour.a;
                append(i4);
                i2 = 1;
                bool2 = true;
              }
            }
          }
        }
        i3 = i8;
        i1 = i2;
        bool1 = bool2;
      }
      a = ((ArrayList)localObject3);
      if (i1 != 0)
      {
        localObject3 = u;
        localObject3[0] = localObject2;
        localObject3[1] = localObject1;
      }
      b(a.newUTF8());
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void a(int paramInt)
  {
    i = paramInt;
    androidx.constraintlayout.solver.ClassWriter.j = b(512);
  }
  
  public void a(androidx.constraintlayout.solver.ClassWriter paramClassWriter, boolean[] paramArrayOfBoolean)
  {
    int i1 = 0;
    paramArrayOfBoolean[2] = false;
    boolean bool = b(64);
    b(paramClassWriter, bool);
    int i2 = a.size();
    while (i1 < i2)
    {
      ((ConstraintWidget)a.get(i1)).b(paramClassWriter, bool);
      i1 += 1;
    }
  }
  
  void a(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = v;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.get() > ((ConstraintAnchor)v.get()).get())) {
      v = new WeakReference(paramConstraintAnchor);
    }
  }
  
  public void a(androidx.constraintlayout.solver.widgets.analyzer.Item paramItem)
  {
    j = paramItem;
    d.b(paramItem);
  }
  
  public boolean a(androidx.constraintlayout.solver.ClassWriter paramClassWriter)
  {
    boolean bool = b(64);
    a(paramClassWriter, bool);
    int i3 = a.size();
    int i1 = 0;
    int i2 = 0;
    Object localObject1;
    while (i1 < i3)
    {
      localObject1 = (ConstraintWidget)a.get(i1);
      ((ConstraintWidget)localObject1).remove(0, false);
      ((ConstraintWidget)localObject1).remove(1, false);
      if ((localObject1 instanceof m)) {
        i2 = 1;
      }
      i1 += 1;
    }
    if (i2 != 0)
    {
      i1 = 0;
      while (i1 < i3)
      {
        localObject1 = (ConstraintWidget)a.get(i1);
        if ((localObject1 instanceof m)) {
          ((m)localObject1).c();
        }
        i1 += 1;
      }
    }
    i1 = 0;
    while (i1 < i3)
    {
      localObject1 = (ConstraintWidget)a.get(i1);
      if (((ConstraintWidget)localObject1).isPrimitive()) {
        ((ConstraintWidget)localObject1).a(paramClassWriter, bool);
      }
      i1 += 1;
    }
    ConstraintWidget localConstraintWidget;
    if (androidx.constraintlayout.solver.ClassWriter.j)
    {
      localObject1 = new HashSet();
      i1 = 0;
      while (i1 < i3)
      {
        localConstraintWidget = (ConstraintWidget)a.get(i1);
        if (!localConstraintWidget.isPrimitive()) {
          ((HashSet)localObject1).add(localConstraintWidget);
        }
        i1 += 1;
      }
      if (iterator() == ConstraintWidget.DimensionBehaviour.c) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      a(this, paramClassWriter, (HashSet)localObject1, i1, false);
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localConstraintWidget = (ConstraintWidget)((Iterator)localObject1).next();
        Frame.a(this, paramClassWriter, localConstraintWidget);
        localConstraintWidget.a(paramClassWriter, bool);
      }
    }
    i1 = 0;
    while (i1 < i3)
    {
      localObject1 = (ConstraintWidget)a.get(i1);
      if ((localObject1 instanceof f))
      {
        Object localObject2 = u;
        localConstraintWidget = localObject2[0];
        localObject2 = localObject2[1];
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.c;
        if (localConstraintWidget == localDimensionBehaviour) {
          ((ConstraintWidget)localObject1).add(ConstraintWidget.DimensionBehaviour.a);
        }
        if (localObject2 == localDimensionBehaviour) {
          ((ConstraintWidget)localObject1).a(ConstraintWidget.DimensionBehaviour.a);
        }
        ((ConstraintWidget)localObject1).a(paramClassWriter, bool);
        if (localConstraintWidget == localDimensionBehaviour) {
          ((ConstraintWidget)localObject1).add(localConstraintWidget);
        }
        if (localObject2 == localDimensionBehaviour) {
          ((ConstraintWidget)localObject1).a((ConstraintWidget.DimensionBehaviour)localObject2);
        }
      }
      else
      {
        Frame.a(this, paramClassWriter, (ConstraintWidget)localObject1);
        if (!((ConstraintWidget)localObject1).isPrimitive()) {
          ((ConstraintWidget)localObject1).a(paramClassWriter, bool);
        }
      }
      i1 += 1;
    }
    if (l > 0) {
      Item.a(this, paramClassWriter, null, 0);
    }
    if (n > 0) {
      Item.a(this, paramClassWriter, null, 1);
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return d.b(paramBoolean);
  }
  
  public long add(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    z = paramInt8;
    y = paramInt9;
    return q.a(this, paramInt1, paramInt8, paramInt9, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public void add()
  {
    a.a();
    z = 0;
    height = 0;
    y = 0;
    count = 0;
    end = false;
    super.add();
  }
  
  public void add(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.add(paramBoolean1, paramBoolean2);
    int i2 = a.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((ConstraintWidget)a.get(i1)).add(paramBoolean1, paramBoolean2);
      i1 += 1;
    }
  }
  
  void b(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = r;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.get() > ((ConstraintAnchor)r.get()).get())) {
      r = new WeakReference(paramConstraintAnchor);
    }
  }
  
  void b(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0)
    {
      b(paramConstraintWidget);
      return;
    }
    if (paramInt == 1) {
      clear(paramConstraintWidget);
    }
  }
  
  public boolean b()
  {
    return g;
  }
  
  public boolean b(int paramInt)
  {
    return (i & paramInt) == paramInt;
  }
  
  public boolean b(boolean paramBoolean)
  {
    return d.a(paramBoolean);
  }
  
  public boolean b(boolean paramBoolean, int paramInt)
  {
    return d.a(paramBoolean, paramInt);
  }
  
  public void c(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = s;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.get() > ((ConstraintAnchor)s.get()).get())) {
      s = new WeakReference(paramConstraintAnchor);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public boolean c()
  {
    return k;
  }
  
  public void clear()
  {
    q.write(this);
  }
  
  public void close()
  {
    d.putByte();
  }
  
  public void d(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = t;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.get() > ((ConstraintAnchor)t.get()).get())) {
      t = new WeakReference(paramConstraintAnchor);
    }
  }
  
  public boolean e()
  {
    return e;
  }
  
  public int intValue()
  {
    return i;
  }
  
  public androidx.constraintlayout.solver.ClassWriter n()
  {
    return a;
  }
  
  public androidx.constraintlayout.solver.widgets.analyzer.Item r()
  {
    return j;
  }
  
  public void visitEnum()
  {
    d.putShort();
  }
}

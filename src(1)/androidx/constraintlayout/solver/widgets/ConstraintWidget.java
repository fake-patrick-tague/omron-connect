package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ClassWriter;
import androidx.constraintlayout.solver.Item;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget
{
  public static float ZERO;
  public androidx.constraintlayout.solver.widgets.analyzer.h A;
  float B = 1.0F;
  public int E;
  private boolean F = false;
  private boolean H = false;
  private boolean K = true;
  private int M = 0;
  private boolean N = true;
  public float[] P;
  public androidx.constraintlayout.solver.widgets.analyzer.h Q;
  protected ConstraintWidget[] S;
  ConstraintWidget _parent;
  ConstraintWidget _view;
  public ConstraintAnchor a = new ConstraintAnchor(this, ConstraintAnchor.Type.g);
  public ConstraintAnchor b = new ConstraintAnchor(this, ConstraintAnchor.Type.b);
  int beginning;
  protected ConstraintWidget[] bottom;
  private int buffer;
  public ConstraintAnchor c = new ConstraintAnchor(this, ConstraintAnchor.Type.a);
  boolean cache;
  int count;
  private int curPos = 0;
  public androidx.constraintlayout.solver.widgets.analyzer.f d = null;
  int data;
  public m e = null;
  public WidgetRun[] ecSpec = new WidgetRun[2];
  private String encoding;
  public int end = -1;
  boolean expected;
  public int f;
  boolean finished = false;
  boolean first;
  private boolean flags = false;
  boolean forward;
  ConstraintAnchor g = new ConstraintAnchor(this, ConstraintAnchor.Type.q);
  public ConstraintAnchor[] h;
  protected int head;
  float height;
  public int i = 0;
  private boolean id = false;
  private String in;
  int index;
  protected ArrayList<ConstraintAnchor> j;
  public boolean k = false;
  int key;
  public ConstraintAnchor l = new ConstraintAnchor(this, ConstraintAnchor.Type.c);
  float left;
  private boolean length = false;
  private boolean[] lock;
  public int m = 0;
  protected int modCount;
  public int n = 0;
  protected int next;
  public int[] o = new int[2];
  private int offset;
  ConstraintAnchor p = new ConstraintAnchor(this, ConstraintAnchor.Type.C);
  private Object parent;
  protected int pos;
  public ConstraintAnchor q;
  public int r = 0;
  public float right;
  public int s = 0;
  int size;
  private boolean sorter;
  boolean start;
  public int state = -1;
  public ConstraintAnchor t = new ConstraintAnchor(this, ConstraintAnchor.Type.e);
  protected int tail;
  int terminated;
  public boolean[] this$0 = { 1, 1 };
  protected int top;
  protected int type;
  public DimensionBehaviour[] u;
  public float v = 1.0F;
  private int[] value = { Integer.MAX_VALUE, Integer.MAX_VALUE };
  public int w = 0;
  private float width = 0.0F;
  public ConstraintWidget x;
  int y = -1;
  public float z = 1.0F;
  
  public ConstraintWidget()
  {
    Object localObject = new ConstraintAnchor(this, ConstraintAnchor.Type.i);
    q = ((ConstraintAnchor)localObject);
    h = new ConstraintAnchor[] { a, l, c, b, t, localObject };
    j = new ArrayList();
    lock = new boolean[2];
    localObject = DimensionBehaviour.a;
    u = new DimensionBehaviour[] { localObject, localObject };
    x = null;
    data = 0;
    size = 0;
    right = 0.0F;
    top = -1;
    type = 0;
    next = 0;
    beginning = 0;
    terminated = 0;
    tail = 0;
    modCount = 0;
    key = 0;
    float f1 = ZERO;
    height = f1;
    left = f1;
    offset = 0;
    buffer = 0;
    encoding = null;
    in = null;
    start = false;
    count = 0;
    index = 0;
    P = new float[] { -1.0F, -1.0F };
    S = new ConstraintWidget[] { null, null };
    bottom = new ConstraintWidget[] { null, null };
    _parent = null;
    _view = null;
    E = -1;
    f = -1;
    a();
  }
  
  private void a()
  {
    j.add(a);
    j.add(c);
    j.add(l);
    j.add(b);
    j.add(g);
    j.add(p);
    j.add(q);
    j.add(t);
  }
  
  private void a(ClassWriter paramClassWriter, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, DimensionBehaviour paramDimensionBehaviour, boolean paramBoolean5, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float paramFloat2, boolean paramBoolean11)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  private boolean b(int paramInt)
  {
    paramInt *= 2;
    ConstraintAnchor[] arrayOfConstraintAnchor = h;
    if ((c != null) && (c.c != arrayOfConstraintAnchor[paramInt]))
    {
      paramInt += 1;
      if ((c != null) && (c.c == arrayOfConstraintAnchor[paramInt])) {
        return true;
      }
    }
    return false;
  }
  
  public ConstraintAnchor a(ConstraintAnchor.Type paramType)
  {
    switch (a.b[paramType.ordinal()])
    {
    default: 
      throw new AssertionError(paramType.name());
    case 9: 
      return null;
    case 8: 
      return p;
    case 7: 
      return g;
    case 6: 
      return q;
    case 5: 
      return t;
    case 4: 
      return b;
    case 3: 
      return l;
    case 2: 
      return c;
    }
    return a;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a.a(paramInt1);
    l.a(paramInt2);
    type = paramInt1;
    data = (paramInt2 - paramInt1);
    id = true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    n = paramInt1;
    s = paramInt2;
    paramInt2 = paramInt3;
    if (paramInt3 == Integer.MAX_VALUE) {
      paramInt2 = 0;
    }
    m = paramInt2;
    z = paramFloat;
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F) && (paramInt1 == 0)) {
      n = 2;
    }
  }
  
  public void a(ClassWriter paramClassWriter, boolean paramBoolean)
  {
    Object localObject1 = paramClassWriter.a(a);
    SolverVariable localSolverVariable = paramClassWriter.a(l);
    Object localObject6 = paramClassWriter.a(c);
    Object localObject5 = paramClassWriter.a(b);
    Object localObject4 = paramClassWriter.a(t);
    Object localObject2 = x;
    boolean bool2;
    boolean bool4;
    if (localObject2 != null)
    {
      if ((localObject2 != null) && (u[0] == DimensionBehaviour.c)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((localObject2 != null) && (u[1] == DimensionBehaviour.c)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool4 = bool1;
    }
    else
    {
      bool4 = false;
      bool2 = false;
    }
    if ((buffer == 8) && (!i()))
    {
      localObject2 = lock;
      if ((localObject2[0] == 0) && (localObject2[1] == 0)) {
        return;
      }
    }
    boolean bool1 = id;
    if ((bool1) || (flags))
    {
      if (bool1)
      {
        paramClassWriter.a((SolverVariable)localObject1, type);
        paramClassWriter.a(localSolverVariable, type + data);
        if (bool4)
        {
          localObject2 = x;
          if (localObject2 != null) {
            if (N)
            {
              localObject2 = (f)localObject2;
              ((f)localObject2).a(a);
              ((f)localObject2).c(l);
            }
            else
            {
              paramClassWriter.d(paramClassWriter.a(l), localSolverVariable, 0, 5);
            }
          }
        }
      }
      if (flags)
      {
        paramClassWriter.a((SolverVariable)localObject6, next);
        paramClassWriter.a((SolverVariable)localObject5, next + size);
        if (t.size()) {
          paramClassWriter.a((SolverVariable)localObject4, next + key);
        }
        if (bool2)
        {
          localObject2 = x;
          if (localObject2 != null) {
            if (N)
            {
              localObject2 = (f)localObject2;
              ((f)localObject2).a(c);
              ((f)localObject2).b(b);
            }
            else
            {
              paramClassWriter.d(paramClassWriter.a(b), (SolverVariable)localObject5, 0, 5);
            }
          }
        }
      }
      if ((id) && (flags))
      {
        id = false;
        flags = false;
        return;
      }
    }
    localObject2 = ClassWriter.c;
    if (localObject2 == null)
    {
      Object localObject3;
      Object localObject7;
      Object localObject8;
      if (paramBoolean)
      {
        localObject3 = d;
        if (localObject3 != null)
        {
          localObject7 = e;
          if (localObject7 != null)
          {
            localObject8 = d;
            if ((i) && (a.i) && (d.i) && (a.i))
            {
              if (localObject2 == null)
              {
                paramClassWriter.a((SolverVariable)localObject1, a);
                paramClassWriter.a(localSolverVariable, d.a.a);
                paramClassWriter.a((SolverVariable)localObject6, e.d.a);
                paramClassWriter.a((SolverVariable)localObject5, e.a.a);
                paramClassWriter.a((SolverVariable)localObject4, e.a.a);
                if (x != null)
                {
                  if ((bool4) && (this$0[0] != 0) && (!equals())) {
                    paramClassWriter.d(paramClassWriter.a(x.l), localSolverVariable, 0, 8);
                  }
                  if ((bool2) && (this$0[1] != 0) && (!f())) {
                    paramClassWriter.d(paramClassWriter.a(x.b), (SolverVariable)localObject5, 0, 8);
                  }
                }
                id = false;
                flags = false;
                return;
              }
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
        }
      }
      if (localObject2 == null)
      {
        boolean bool3;
        boolean bool5;
        if (x != null)
        {
          if (b(0))
          {
            ((f)x).b(this, 0);
            bool1 = true;
          }
          else
          {
            bool1 = equals();
          }
          if (b(1))
          {
            ((f)x).b(this, 1);
            bool3 = true;
          }
          else
          {
            bool3 = f();
          }
          if ((!bool1) && (bool4) && (buffer != 8) && (a.c == null) && (l.c == null)) {
            paramClassWriter.d(paramClassWriter.a(x.l), localSolverVariable, 0, 1);
          }
          if ((!bool3) && (bool2) && (buffer != 8) && (c.c == null) && (b.c == null) && (t == null)) {
            paramClassWriter.d(paramClassWriter.a(x.b), (SolverVariable)localObject5, 0, 1);
          }
          bool5 = bool1;
        }
        else
        {
          bool3 = false;
          bool5 = false;
        }
        int i7 = data;
        int i2 = head;
        if (i7 >= i2) {
          i2 = i7;
        }
        int i8 = size;
        int i1 = pos;
        if (i8 >= i1) {
          i1 = i8;
        }
        localObject2 = u;
        localObject3 = localObject2[0];
        DimensionBehaviour localDimensionBehaviour = DimensionBehaviour.b;
        int i5 = i2;
        if (localObject3 != localDimensionBehaviour) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (localObject2[1] != localDimensionBehaviour) {
          bool6 = true;
        } else {
          bool6 = false;
        }
        int i9 = top;
        y = i9;
        float f1 = right;
        B = f1;
        int i6 = i;
        int i4 = n;
        int i3;
        if ((f1 > 0.0F) && (buffer != 8))
        {
          i2 = i6;
          if (localObject2[0] == localDimensionBehaviour)
          {
            i2 = i6;
            if (i6 == 0) {
              i2 = 3;
            }
          }
          i3 = i4;
          if (localObject2[1] == localDimensionBehaviour)
          {
            i3 = i4;
            if (i4 == 0) {
              i3 = 3;
            }
          }
          if ((localObject2[0] == localDimensionBehaviour) && (localObject2[1] == localDimensionBehaviour) && (i2 == 3) && (i3 == 3))
          {
            a(bool4, bool2, bool1, bool6);
            i4 = i1;
          }
          else
          {
            if ((localObject2[0] == localDimensionBehaviour) && (i2 == 3))
            {
              y = 0;
              i4 = (int)(f1 * i8);
              if (localObject2[1] != localDimensionBehaviour)
              {
                i2 = 4;
                bool1 = false;
                break label1335;
              }
              bool1 = true;
              break label1335;
            }
            i4 = i1;
            if (localObject2[1] == localDimensionBehaviour)
            {
              i4 = i1;
              if (i3 == 3)
              {
                y = 1;
                if (i9 == -1) {
                  B = (1.0F / f1);
                }
                i1 = (int)(B * i7);
                if (localObject2[0] != localDimensionBehaviour)
                {
                  bool1 = false;
                  i3 = 4;
                  i4 = i5;
                  break label1335;
                }
                i4 = i1;
              }
            }
          }
          bool1 = true;
          i1 = i4;
          i4 = i5;
        }
        else
        {
          bool1 = false;
          i3 = i4;
          i4 = i5;
          i2 = i6;
        }
        label1335:
        localObject2 = o;
        localObject2[0] = i2;
        localObject2[1] = i3;
        finished = bool1;
        if (bool1)
        {
          i5 = y;
          if ((i5 == 0) || (i5 == -1))
          {
            bool7 = true;
            break label1390;
          }
        }
        boolean bool7 = false;
        label1390:
        if (bool1)
        {
          i5 = y;
          if ((i5 == 1) || (i5 == -1))
          {
            bool6 = true;
            break label1422;
          }
        }
        boolean bool6 = false;
        label1422:
        localObject2 = u[0];
        Object localObject9 = DimensionBehaviour.c;
        if ((localObject2 == localObject9) && ((this instanceof f))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
        if (bool8) {
          i4 = 0;
        }
        boolean bool10 = q.remove() ^ true;
        localObject2 = lock;
        int i12 = localObject2[0];
        int i11 = localObject2[1];
        ConstraintAnchor localConstraintAnchor1;
        if ((state != 2) && (!id))
        {
          if (paramBoolean)
          {
            localObject2 = d;
            if (localObject2 != null)
            {
              localObject3 = d;
              if ((i) && (a.i))
              {
                if (paramBoolean)
                {
                  paramClassWriter.a((SolverVariable)localObject1, a);
                  paramClassWriter.a(localSolverVariable, d.a.a);
                  if ((x != null) && (bool4) && (this$0[0] != 0) && (!equals())) {
                    paramClassWriter.d(paramClassWriter.a(x.l), localSolverVariable, 0, 8);
                  }
                  break label1837;
                }
                break label1837;
              }
            }
          }
          localObject2 = x;
          if (localObject2 != null) {
            localObject2 = paramClassWriter.a(l);
          } else {
            localObject2 = null;
          }
          localObject3 = x;
          if (localObject3 != null) {
            localObject3 = paramClassWriter.a(a);
          } else {
            localObject3 = null;
          }
          int i13 = this$0[0];
          localObject7 = u;
          localObject8 = localObject7[0];
          localConstraintAnchor1 = a;
          ConstraintAnchor localConstraintAnchor2 = l;
          i5 = type;
          i6 = head;
          i7 = value[0];
          f1 = height;
          boolean bool9;
          if (localObject7[1] == localDimensionBehaviour) {
            bool9 = true;
          } else {
            bool9 = false;
          }
          a(paramClassWriter, true, bool4, bool2, i13, (SolverVariable)localObject3, (SolverVariable)localObject2, (DimensionBehaviour)localObject8, bool8, localConstraintAnchor1, localConstraintAnchor2, i5, i4, i6, i7, f1, bool7, bool9, bool5, bool3, i12, i2, i3, r, w, v, bool10);
        }
        label1837:
        localObject2 = localObject6;
        boolean bool8 = bool2;
        localObject3 = localObject1;
        localObject1 = localObject5;
        if (paramBoolean)
        {
          localObject5 = e;
          if (localObject5 != null)
          {
            localObject6 = d;
            if ((i) && (a.i))
            {
              paramClassWriter.a((SolverVariable)localObject2, a);
              paramClassWriter.a((SolverVariable)localObject1, e.a.a);
              paramClassWriter.a((SolverVariable)localObject4, e.a.a);
              localObject5 = x;
              if ((localObject5 != null) && (!bool3) && (bool8)) {
                if (this$0[1] != 0) {
                  paramClassWriter.d(paramClassWriter.a(b), (SolverVariable)localObject1, 0, 8);
                } else {}
              }
              i4 = 0;
              break label2003;
            }
          }
        }
        i4 = 1;
        label2003:
        localObject7 = paramClassWriter;
        localObject8 = localObject4;
        localObject4 = this;
        localObject5 = localObject2;
        localObject6 = localObject1;
        if (end == 2) {
          i4 = 0;
        }
        if ((i4 != 0) && (!flags))
        {
          if ((u[1] == localObject9) && ((localObject4 instanceof f))) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          if (paramBoolean) {
            i1 = 0;
          }
          localObject1 = x;
          if (localObject1 != null) {
            localObject1 = ((ClassWriter)localObject7).a(b);
          } else {
            localObject1 = null;
          }
          localObject2 = x;
          if (localObject2 != null) {
            localObject2 = ((ClassWriter)localObject7).a(c);
          } else {
            localObject2 = null;
          }
          if ((key > 0) || (buffer == 8))
          {
            if (t.c != null)
            {
              ((ClassWriter)localObject7).a((SolverVariable)localObject8, (SolverVariable)localObject5, newUTF8(), 8);
              ((ClassWriter)localObject7).a((SolverVariable)localObject8, ((ClassWriter)localObject7).a(t.c), 0, 8);
              if (bool8) {
                ((ClassWriter)localObject7).d((SolverVariable)localObject1, ((ClassWriter)localObject7).a(b), 0, 5);
              }
              bool2 = false;
              break label2288;
            }
            if (buffer == 8) {
              ((ClassWriter)localObject7).a((SolverVariable)localObject8, (SolverVariable)localObject5, 0, 8);
            } else {
              ((ClassWriter)localObject7).a((SolverVariable)localObject8, (SolverVariable)localObject5, newUTF8(), 8);
            }
          }
          bool2 = bool10;
          label2288:
          int i10 = this$0[1];
          localObject7 = u;
          localObject8 = localObject7[1];
          localObject9 = c;
          localConstraintAnchor1 = b;
          i4 = next;
          i5 = pos;
          i6 = value[1];
          f1 = left;
          if (localObject7[0] == localDimensionBehaviour) {
            bool7 = true;
          } else {
            bool7 = false;
          }
          a(paramClassWriter, false, bool8, bool4, i10, (SolverVariable)localObject2, (SolverVariable)localObject1, (DimensionBehaviour)localObject8, paramBoolean, (ConstraintAnchor)localObject9, localConstraintAnchor1, i4, i1, i5, i6, f1, bool6, bool7, bool3, bool5, i11, i3, i2, s, m, z, bool2);
        }
        if (bool1) {
          if (y == 1) {
            paramClassWriter.a((SolverVariable)localObject6, (SolverVariable)localObject5, localSolverVariable, (SolverVariable)localObject3, B, 8);
          } else {
            paramClassWriter.a(localSolverVariable, (SolverVariable)localObject3, (SolverVariable)localObject6, (SolverVariable)localObject5, B, 8);
          }
        }
        localObject1 = this;
        if (q.remove()) {
          paramClassWriter.a((ConstraintWidget)localObject1, q.p().visitParameterAnnotation(), (float)Math.toRadians(width + 90.0F), q.b());
        }
        id = false;
        flags = false;
        return;
      }
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void a(DimensionBehaviour paramDimensionBehaviour)
  {
    u[1] = paramDimensionBehaviour;
  }
  
  public void a(ConstraintWidget paramConstraintWidget, float paramFloat, int paramInt)
  {
    ConstraintAnchor.Type localType = ConstraintAnchor.Type.i;
    append(localType, paramConstraintWidget, localType, paramInt, 0);
    width = paramFloat;
  }
  
  public void a(f paramF, ClassWriter paramClassWriter, HashSet paramHashSet, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!paramHashSet.contains(this)) {
        return;
      }
      Frame.a(paramF, paramClassWriter, this);
      paramHashSet.remove(this);
      a(paramClassWriter, paramF.b(64));
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = a.h();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          nextb.a(paramF, paramClassWriter, paramHashSet, paramInt, true);
        }
      }
      localObject = l.h();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          nextb.a(paramF, paramClassWriter, paramHashSet, paramInt, true);
        }
      }
    }
    else
    {
      localObject = c.h();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          nextb.a(paramF, paramClassWriter, paramHashSet, paramInt, true);
        }
      }
      localObject = b.h();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          nextb.a(paramF, paramClassWriter, paramHashSet, paramInt, true);
        }
      }
      localObject = t.h();
      if (localObject == null) {
        return;
      }
      localObject = ((HashSet)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ConstraintWidget localConstraintWidget = nextb;
      try
      {
        localConstraintWidget.a(paramF, paramClassWriter, paramHashSet, paramInt, true);
      }
      catch (Throwable paramF)
      {
        throw paramF;
      }
    }
    return;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (y == -1) {
      if ((paramBoolean3) && (!paramBoolean4))
      {
        y = 0;
      }
      else if ((!paramBoolean3) && (paramBoolean4))
      {
        y = 1;
        if (top == -1) {
          B = (1.0F / B);
        }
      }
    }
    if ((y == 0) && ((!c.remove()) || (!b.remove()))) {
      y = 1;
    } else if ((y == 1) && ((!a.remove()) || (!l.remove()))) {
      y = 0;
    }
    if ((y == -1) && ((!c.remove()) || (!b.remove()) || (!a.remove()) || (!l.remove()))) {
      if ((c.remove()) && (b.remove()))
      {
        y = 0;
      }
      else if ((a.remove()) && (l.remove()))
      {
        B = (1.0F / B);
        y = 1;
      }
    }
    if (y == -1)
    {
      int i1 = r;
      if ((i1 > 0) && (s == 0))
      {
        y = 0;
        return;
      }
      if ((i1 == 0) && (s > 0))
      {
        B = (1.0F / B);
        y = 1;
      }
    }
  }
  
  public void add()
  {
    a.a();
    c.a();
    l.a();
    b.a();
    t.a();
    g.a();
    p.a();
    q.a();
    x = null;
    width = 0.0F;
    data = 0;
    size = 0;
    right = 0.0F;
    top = -1;
    type = 0;
    next = 0;
    tail = 0;
    modCount = 0;
    key = 0;
    head = 0;
    pos = 0;
    float f1 = ZERO;
    height = f1;
    left = f1;
    Object localObject = u;
    DimensionBehaviour localDimensionBehaviour = DimensionBehaviour.a;
    localObject[0] = localDimensionBehaviour;
    localObject[1] = localDimensionBehaviour;
    parent = null;
    offset = 0;
    buffer = 0;
    in = null;
    first = false;
    cache = false;
    count = 0;
    index = 0;
    expected = false;
    forward = false;
    localObject = P;
    localObject[0] = -1.0F;
    localObject[1] = -1.0F;
    state = -1;
    end = -1;
    localObject = value;
    localObject[0] = Integer.MAX_VALUE;
    localObject[1] = Integer.MAX_VALUE;
    i = 0;
    n = 0;
    v = 1.0F;
    z = 1.0F;
    w = Integer.MAX_VALUE;
    m = Integer.MAX_VALUE;
    r = 0;
    s = 0;
    finished = false;
    y = -1;
    B = 1.0F;
    start = false;
    localObject = this$0;
    localObject[0] = 1;
    localObject[1] = 1;
    F = false;
    localObject = lock;
    localObject[0] = 0;
    localObject[1] = 0;
    K = true;
  }
  
  public void add(float paramFloat)
  {
    P[1] = paramFloat;
  }
  
  public void add(int paramInt)
  {
    buffer = paramInt;
  }
  
  public void add(int paramInt1, int paramInt2)
  {
    c.a(paramInt1);
    b.a(paramInt2);
    next = paramInt1;
    size = (paramInt2 - paramInt1);
    if (length) {
      t.a(paramInt1 + key);
    }
    flags = true;
  }
  
  public void add(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    i = paramInt1;
    r = paramInt2;
    paramInt2 = paramInt3;
    if (paramInt3 == Integer.MAX_VALUE) {
      paramInt2 = 0;
    }
    w = paramInt2;
    v = paramFloat;
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F) && (paramInt1 == 0)) {
      i = 2;
    }
  }
  
  public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2;
    type = paramInt1;
    next = paramInt2;
    if (buffer == 8)
    {
      data = 0;
      size = 0;
      return;
    }
    DimensionBehaviour[] arrayOfDimensionBehaviour = u;
    DimensionBehaviour localDimensionBehaviour1 = arrayOfDimensionBehaviour[0];
    DimensionBehaviour localDimensionBehaviour2 = DimensionBehaviour.a;
    paramInt1 = i1;
    if (localDimensionBehaviour1 == localDimensionBehaviour2)
    {
      paramInt2 = data;
      paramInt1 = i1;
      if (i1 < paramInt2) {
        paramInt1 = paramInt2;
      }
    }
    paramInt2 = paramInt3;
    if (arrayOfDimensionBehaviour[1] == localDimensionBehaviour2)
    {
      paramInt4 = size;
      paramInt2 = paramInt3;
      if (paramInt3 < paramInt4) {
        paramInt2 = paramInt4;
      }
    }
    data = paramInt1;
    size = paramInt2;
    paramInt3 = pos;
    if (paramInt2 < paramInt3) {
      size = paramInt3;
    }
    paramInt2 = head;
    if (paramInt1 < paramInt2) {
      data = paramInt2;
    }
  }
  
  public void add(DimensionBehaviour paramDimensionBehaviour)
  {
    u[0] = paramDimensionBehaviour;
  }
  
  public void add(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = paramBoolean1 & d.add();
    boolean bool1 = paramBoolean2 & e.add();
    androidx.constraintlayout.solver.widgets.analyzer.f localF = d;
    int i1 = d.a;
    m localM = e;
    int i2 = d.a;
    int i4 = a.a;
    int i5 = a.a;
    int i3;
    if ((i4 - i1 >= 0) && (i5 - i2 >= 0) && (i1 != Integer.MIN_VALUE) && (i1 != Integer.MAX_VALUE) && (i2 != Integer.MIN_VALUE) && (i2 != Integer.MAX_VALUE) && (i4 != Integer.MIN_VALUE) && (i4 != Integer.MAX_VALUE) && (i5 != Integer.MIN_VALUE))
    {
      i3 = i5;
      if (i5 != Integer.MAX_VALUE) {}
    }
    else
    {
      i4 = 0;
      i1 = 0;
      i3 = 0;
      i2 = 0;
    }
    i4 -= i1;
    i3 -= i2;
    if (bool2) {
      type = i1;
    }
    if (bool1) {
      next = i2;
    }
    if (buffer == 8)
    {
      data = 0;
      size = 0;
      return;
    }
    if (bool2)
    {
      i1 = i4;
      if (u[0] == DimensionBehaviour.a)
      {
        i2 = data;
        i1 = i4;
        if (i4 < i2) {
          i1 = i2;
        }
      }
      data = i1;
      i2 = head;
      if (i1 < i2) {
        data = i2;
      }
    }
    if (bool1)
    {
      i1 = i3;
      if (u[1] == DimensionBehaviour.a)
      {
        i2 = size;
        i1 = i3;
        if (i3 < i2) {
          i1 = i2;
        }
      }
      size = i1;
      i2 = pos;
      if (i1 < i2) {
        size = i2;
      }
    }
  }
  
  public void append(float paramFloat)
  {
    height = paramFloat;
  }
  
  public void append(int paramInt)
  {
    size = paramInt;
    int i1 = pos;
    if (paramInt < i1) {
      size = i1;
    }
  }
  
  public void append(int paramInt1, int paramInt2)
  {
    type = paramInt1;
    next = paramInt2;
  }
  
  public void append(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2)
  {
    a(paramType1).a(paramConstraintWidget.a(paramType2), paramInt1, paramInt2, true);
  }
  
  public void append(boolean paramBoolean)
  {
    length = paramBoolean;
  }
  
  public void b(ClassWriter paramClassWriter)
  {
    paramClassWriter.a(a);
    paramClassWriter.a(c);
    paramClassWriter.a(l);
    paramClassWriter.a(b);
    if (key > 0) {
      paramClassWriter.a(t);
    }
  }
  
  public void b(ClassWriter paramClassWriter, boolean paramBoolean)
  {
    int i2 = paramClassWriter.set(a);
    int i5 = paramClassWriter.set(c);
    int i4 = paramClassWriter.set(l);
    int i6 = paramClassWriter.set(b);
    int i3 = i2;
    int i1 = i4;
    Object localObject;
    if (paramBoolean)
    {
      localObject = d;
      i3 = i2;
      i1 = i4;
      if (localObject != null)
      {
        paramClassWriter = d;
        i3 = i2;
        i1 = i4;
        if (i)
        {
          localObject = a;
          i3 = i2;
          i1 = i4;
          if (i)
          {
            i3 = a;
            i1 = a;
          }
        }
      }
    }
    i4 = i5;
    i2 = i6;
    if (paramBoolean)
    {
      localObject = e;
      i4 = i5;
      i2 = i6;
      if (localObject != null)
      {
        paramClassWriter = d;
        i4 = i5;
        i2 = i6;
        if (i)
        {
          localObject = a;
          i4 = i5;
          i2 = i6;
          if (i)
          {
            i4 = a;
            i2 = a;
          }
        }
      }
    }
    if ((i1 - i3 >= 0) && (i2 - i4 >= 0) && (i3 != Integer.MIN_VALUE) && (i3 != Integer.MAX_VALUE) && (i4 != Integer.MIN_VALUE) && (i4 != Integer.MAX_VALUE) && (i1 != Integer.MIN_VALUE) && (i1 != Integer.MAX_VALUE) && (i2 != Integer.MIN_VALUE))
    {
      i5 = i1;
      i1 = i2;
      if (i2 != Integer.MAX_VALUE) {}
    }
    else
    {
      i1 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
    }
    add(i3, i4, i5, i1);
  }
  
  public void b(Item paramItem)
  {
    a.a(paramItem);
    c.a(paramItem);
    l.a(paramItem);
    b.a(paramItem);
    t.a(paramItem);
    q.a(paramItem);
    g.a(paramItem);
    p.a(paramItem);
  }
  
  public void b(String paramString)
  {
    encoding = paramString;
  }
  
  public int d()
  {
    ConstraintWidget localConstraintWidget = x;
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof f))) {
      return z + type;
    }
    return type;
  }
  
  public void down(int paramInt)
  {
    index = paramInt;
  }
  
  public void drawLine(float paramFloat)
  {
    left = paramFloat;
  }
  
  public void e(int paramInt)
  {
    type = paramInt;
  }
  
  public boolean equals()
  {
    ConstraintAnchor localConstraintAnchor1 = a;
    ConstraintAnchor localConstraintAnchor2 = c;
    if ((localConstraintAnchor2 == null) || (c != localConstraintAnchor1))
    {
      localConstraintAnchor1 = l;
      localConstraintAnchor2 = c;
    }
    return (localConstraintAnchor2 != null) && (c == localConstraintAnchor1);
  }
  
  public boolean equals(int paramInt)
  {
    int i1;
    if (paramInt == 0)
    {
      if (a.c != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (l.c != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      return paramInt + i1 < 2;
    }
    if (c.c != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (b.c != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (t.c != null) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    return paramInt + i1 + i2 < 2;
  }
  
  public void f(int paramInt)
  {
    a.a(paramInt);
    type = paramInt;
  }
  
  public void f(Object paramObject)
  {
    parent = paramObject;
  }
  
  public void f(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public boolean f()
  {
    ConstraintAnchor localConstraintAnchor1 = c;
    ConstraintAnchor localConstraintAnchor2 = c;
    if ((localConstraintAnchor2 == null) || (c != localConstraintAnchor1))
    {
      localConstraintAnchor1 = b;
      localConstraintAnchor2 = c;
    }
    return (localConstraintAnchor2 != null) && (c == localConstraintAnchor1);
  }
  
  public int get()
  {
    return buffer;
  }
  
  public void get(int paramInt)
  {
    data = paramInt;
    int i1 = head;
    if (paramInt < i1) {
      data = i1;
    }
  }
  
  public int getCount()
  {
    return count;
  }
  
  public int getIcon()
  {
    ConstraintAnchor localConstraintAnchor = a;
    int i1 = 0;
    if (localConstraintAnchor != null) {
      i1 = 0 + a;
    }
    localConstraintAnchor = l;
    int i2 = i1;
    if (localConstraintAnchor != null) {
      i2 = i1 + a;
    }
    return i2;
  }
  
  public int getM()
  {
    return M;
  }
  
  public Object getParent()
  {
    return parent;
  }
  
  public boolean getRangeOrigin()
  {
    return F;
  }
  
  public int getRectF()
  {
    return max() + size;
  }
  
  public boolean getSort()
  {
    return sorter;
  }
  
  public String getString()
  {
    return encoding;
  }
  
  public int getValue()
  {
    if (buffer == 8) {
      return 0;
    }
    return data;
  }
  
  public int getX()
  {
    return pos;
  }
  
  public boolean h()
  {
    return (id) || ((a.i()) && (l.i()));
  }
  
  public boolean hasNext()
  {
    DimensionBehaviour[] arrayOfDimensionBehaviour = u;
    DimensionBehaviour localDimensionBehaviour1 = arrayOfDimensionBehaviour[0];
    DimensionBehaviour localDimensionBehaviour2 = DimensionBehaviour.b;
    return (localDimensionBehaviour1 == localDimensionBehaviour2) && (arrayOfDimensionBehaviour[1] == localDimensionBehaviour2);
  }
  
  public float height()
  {
    return height;
  }
  
  public float height(int paramInt)
  {
    if (paramInt == 0) {
      return height;
    }
    if (paramInt == 1) {
      return left;
    }
    return -1.0F;
  }
  
  public boolean i()
  {
    int i2 = j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((ConstraintAnchor)j.get(i1)).size()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public int indexOf(int paramInt)
  {
    if (paramInt == 0) {
      return getValue();
    }
    if (paramInt == 1) {
      return length();
    }
    return 0;
  }
  
  public void init()
  {
    int i1 = 0;
    id = false;
    flags = false;
    int i2 = j.size();
    while (i1 < i2)
    {
      ((ConstraintAnchor)j.get(i1)).initialize();
      i1 += 1;
    }
  }
  
  public void init(int paramInt)
  {
    if (paramInt < 0)
    {
      pos = 0;
      return;
    }
    pos = paramInt;
  }
  
  public void initialize(boolean paramBoolean)
  {
    K = paramBoolean;
  }
  
  boolean isPrimitive()
  {
    return ((this instanceof d)) || ((this instanceof h));
  }
  
  public DimensionBehaviour iterator()
  {
    return u[0];
  }
  
  public boolean j()
  {
    return (flags) || ((c.i()) && (b.i()));
  }
  
  public boolean l()
  {
    return (K) && (buffer != 8);
  }
  
  public int length()
  {
    if (buffer == 8) {
      return 0;
    }
    return size;
  }
  
  public ConstraintWidget listFiles()
  {
    return x;
  }
  
  public boolean m()
  {
    return buffer != 8;
  }
  
  public int max()
  {
    ConstraintWidget localConstraintWidget = x;
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof f))) {
      return y + next;
    }
    return next;
  }
  
  public int newClass()
  {
    return index;
  }
  
  public int newUTF8()
  {
    return key;
  }
  
  public int next()
  {
    return value[0];
  }
  
  public float p()
  {
    return right;
  }
  
  public ConstraintWidget p(int paramInt)
  {
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    if (paramInt == 0)
    {
      localConstraintAnchor1 = a;
      localConstraintAnchor2 = c;
      if ((localConstraintAnchor2 != null) && (c == localConstraintAnchor1)) {
        return b;
      }
    }
    else if (paramInt == 1)
    {
      localConstraintAnchor1 = c;
      localConstraintAnchor2 = c;
      if ((localConstraintAnchor2 != null) && (c == localConstraintAnchor1)) {
        return b;
      }
    }
    return null;
  }
  
  public void parse(String paramString)
  {
    int i2;
    int i1;
    String str;
    if ((paramString != null) && (paramString.length() != 0))
    {
      int i3 = -1;
      int i5 = paramString.length();
      int i6 = paramString.indexOf(',');
      int i4 = 0;
      i2 = i4;
      i1 = i3;
      if (i6 > 0)
      {
        i2 = i4;
        i1 = i3;
        if (i6 < i5 - 1)
        {
          str = paramString.substring(0, i6);
          if (str.equalsIgnoreCase("W"))
          {
            i1 = 0;
          }
          else
          {
            i1 = i3;
            if (str.equalsIgnoreCase("H")) {
              i1 = 1;
            }
          }
          i2 = i6 + 1;
        }
      }
      i3 = paramString.indexOf(':');
      if ((i3 >= 0) && (i3 < i5 - 1))
      {
        str = paramString.substring(i2, i3);
        paramString = paramString.substring(i3 + 1);
        if ((str.length() <= 0) || (paramString.length() <= 0)) {
          break label245;
        }
      }
    }
    try
    {
      f1 = Float.parseFloat(str);
      float f2 = Float.parseFloat(paramString);
      if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
        break label245;
      }
      if (i1 == 1)
      {
        f1 = f2 / f1;
        f1 = Math.abs(f1);
      }
      else
      {
        f1 /= f2;
        f1 = Math.abs(f1);
      }
    }
    catch (NumberFormatException paramString)
    {
      float f1;
      for (;;) {}
    }
    paramString = paramString.substring(i2);
    if (paramString.length() > 0) {}
    try
    {
      f1 = Float.parseFloat(paramString);
    }
    catch (NumberFormatException paramString)
    {
      label245:
      for (;;) {}
    }
    f1 = 0.0F;
    if (f1 > 0.0F)
    {
      right = f1;
      top = i1;
      return;
      right = 0.0F;
      return;
    }
  }
  
  public int position()
  {
    return curPos;
  }
  
  public void put(int paramInt)
  {
    count = paramInt;
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    type = paramInt1;
    paramInt1 = paramInt2 - paramInt1;
    data = paramInt1;
    paramInt2 = head;
    if (paramInt1 < paramInt2) {
      data = paramInt2;
    }
  }
  
  public void putShort(int paramInt)
  {
    key = paramInt;
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    length = bool;
  }
  
  public boolean q()
  {
    return length;
  }
  
  public ConstraintWidget read(int paramInt)
  {
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    if (paramInt == 0)
    {
      localConstraintAnchor1 = l;
      localConstraintAnchor2 = c;
      if ((localConstraintAnchor2 != null) && (c == localConstraintAnchor1)) {
        return b;
      }
    }
    else if (paramInt == 1)
    {
      localConstraintAnchor1 = b;
      localConstraintAnchor2 = c;
      if ((localConstraintAnchor2 != null) && (c == localConstraintAnchor1)) {
        return b;
      }
    }
    return null;
  }
  
  public void read(int paramInt1, int paramInt2)
  {
    M = paramInt1;
    curPos = paramInt2;
    initialize(false);
  }
  
  public int readLong()
  {
    return value[1];
  }
  
  public int readShort()
  {
    return d() + data;
  }
  
  public int readUnsignedShort()
  {
    return top;
  }
  
  public float remove()
  {
    return left;
  }
  
  public void remove(int paramInt)
  {
    next = paramInt;
  }
  
  public void remove(int paramInt1, int paramInt2)
  {
    next = paramInt1;
    paramInt1 = paramInt2 - paramInt1;
    size = paramInt1;
    paramInt2 = pos;
    if (paramInt1 < paramInt2) {
      size = paramInt2;
    }
  }
  
  protected void remove(int paramInt, boolean paramBoolean)
  {
    lock[paramInt] = paramBoolean;
  }
  
  public int replace()
  {
    return head;
  }
  
  public void send(int paramInt)
  {
    if (paramInt < 0)
    {
      head = 0;
      return;
    }
    head = paramInt;
  }
  
  public void set(int paramInt)
  {
    if (!length) {
      return;
    }
    int i1 = paramInt - key;
    int i2 = size;
    next = i1;
    c.a(i1);
    b.a(i2 + i1);
    t.a(paramInt);
    flags = true;
  }
  
  public int setIcon()
  {
    ConstraintAnchor localConstraintAnchor = a;
    int i1 = 0;
    if (localConstraintAnchor != null) {
      i1 = 0 + c.a;
    }
    int i2 = i1;
    if (l != null) {
      i2 = i1 + b.a;
    }
    return i2;
  }
  
  public void setTitle()
  {
    if (d == null) {
      d = new androidx.constraintlayout.solver.widgets.analyzer.f(this);
    }
    if (e == null) {
      e = new m(this);
    }
  }
  
  public void setTitle(float paramFloat)
  {
    P[0] = paramFloat;
  }
  
  public DimensionBehaviour size()
  {
    return u[1];
  }
  
  public WidgetRun toString(int paramInt)
  {
    if (paramInt == 0) {
      return d;
    }
    if (paramInt == 1) {
      return e;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = in;
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type: ");
      ((StringBuilder)localObject).append(in);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (encoding != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id: ");
      ((StringBuilder)localObject).append(encoding);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("(");
    localStringBuilder.append(type);
    localStringBuilder.append(", ");
    localStringBuilder.append(next);
    localStringBuilder.append(") - (");
    localStringBuilder.append(data);
    localStringBuilder.append(" x ");
    localStringBuilder.append(size);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public DimensionBehaviour valueOf(int paramInt)
  {
    if (paramInt == 0) {
      return iterator();
    }
    if (paramInt == 1) {
      return size();
    }
    return null;
  }
  
  public void visitField(int paramInt)
  {
    value[1] = paramInt;
  }
  
  public void visitField(ConstraintWidget paramConstraintWidget)
  {
    x = paramConstraintWidget;
  }
  
  public void visitMaxs(int paramInt)
  {
    c.a(paramInt);
    next = paramInt;
  }
  
  public void visitMethodInsn(boolean paramBoolean)
  {
    sorter = paramBoolean;
  }
  
  public void visitTypeInsn(int paramInt)
  {
    value[0] = paramInt;
  }
  
  public static enum DimensionBehaviour
  {
    static
    {
      DimensionBehaviour localDimensionBehaviour1 = new DimensionBehaviour("FIXED", 0);
      a = localDimensionBehaviour1;
      DimensionBehaviour localDimensionBehaviour2 = new DimensionBehaviour("WRAP_CONTENT", 1);
      c = localDimensionBehaviour2;
      DimensionBehaviour localDimensionBehaviour3 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
      b = localDimensionBehaviour3;
      DimensionBehaviour localDimensionBehaviour4 = new DimensionBehaviour("MATCH_PARENT", 3);
      g = localDimensionBehaviour4;
      d = new DimensionBehaviour[] { localDimensionBehaviour1, localDimensionBehaviour2, localDimensionBehaviour3, localDimensionBehaviour4 };
    }
  }
}

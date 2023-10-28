package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.solver.widgets.ByteVector;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Frame;
import androidx.constraintlayout.solver.widgets.analyzer.ClassWriter;
import androidx.constraintlayout.solver.widgets.analyzer.Item;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.h;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
  extends ViewGroup
{
  private ArrayList<ConstraintHelper> a = new ArrayList(4);
  protected androidx.constraintlayout.solver.widgets.f b = new androidx.constraintlayout.solver.widgets.f();
  SparseArray<View> c = new SparseArray();
  int d = 0;
  private int e = Integer.MAX_VALUE;
  private SparseArray<ConstraintWidget> f = new SparseArray();
  private int g = -1;
  int h = -1;
  protected boolean i = true;
  private f j = null;
  private int k = 257;
  protected i l = null;
  private int m = -1;
  private int n = 0;
  int o = -1;
  private int p = -1;
  private int s = 0;
  private HashMap<String, Integer> t = new HashMap();
  b v = new b(this);
  private int w = Integer.MAX_VALUE;
  private int x = 0;
  private int y = 0;
  int z = 0;
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0, 0);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt, 0);
  }
  
  private final ConstraintWidget a(int paramInt)
  {
    if (paramInt == 0) {
      return b;
    }
    Object localObject2 = (View)c.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      View localView = findViewById(paramInt);
      localObject2 = localView;
      localObject1 = localObject2;
      if (localView != null)
      {
        localObject1 = localObject2;
        if (localView != this)
        {
          localObject1 = localObject2;
          if (localView.getParent() == this)
          {
            onViewAdded(localView);
            localObject1 = localObject2;
          }
        }
      }
    }
    if (localObject1 == this) {
      return b;
    }
    if (localObject1 == null) {
      return null;
    }
    return getLayoutParamsf;
  }
  
  private void a()
  {
    boolean bool = isInEditMode();
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject1 = a(getChildAt(i1));
      if (localObject1 != null) {
        ((ConstraintWidget)localObject1).add();
      }
      i1 += 1;
    }
    Object localObject3;
    if (bool)
    {
      i1 = 0;
      while (i1 < i2)
      {
        localObject3 = getChildAt(i1);
        try
        {
          localObject2 = getResources().getResourceName(((View)localObject3).getId());
          localObject1 = localObject2;
          a(0, localObject2, Integer.valueOf(((View)localObject3).getId()));
          i3 = ((String)localObject2).indexOf('/');
          if (i3 != -1) {
            localObject1 = ((String)localObject2).substring(i3 + 1);
          }
          a(((View)localObject3).getId()).b((String)localObject1);
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          Object localObject2;
          int i3;
          for (;;) {}
        }
        i1 += 1;
      }
    }
    if (m != -1)
    {
      i1 = 0;
      while (i1 < i2)
      {
        localObject1 = getChildAt(i1);
        if ((((View)localObject1).getId() == m) && ((localObject1 instanceof Constraints))) {
          j = ((Constraints)localObject1).getConstraintSet();
        }
        i1 += 1;
      }
    }
    Object localObject1 = j;
    if (localObject1 != null) {
      ((f)localObject1).a(this, true);
    }
    b.putInt();
    i3 = a.size();
    if (i3 > 0)
    {
      i1 = 0;
      while (i1 < i3)
      {
        ((ConstraintHelper)a.get(i1)).a(this);
        i1 += 1;
      }
    }
    i1 = 0;
    while (i1 < i2)
    {
      localObject1 = getChildAt(i1);
      if ((localObject1 instanceof Placeholder)) {
        ((Placeholder)localObject1).b(this);
      }
      i1 += 1;
    }
    f.clear();
    f.put(0, b);
    f.put(getId(), b);
    i1 = 0;
    while (i1 < i2)
    {
      localObject1 = getChildAt(i1);
      localObject2 = a((View)localObject1);
      f.put(((View)localObject1).getId(), localObject2);
      i1 += 1;
    }
    i1 = 0;
    while (i1 < i2)
    {
      localObject1 = getChildAt(i1);
      localObject2 = a((View)localObject1);
      if (localObject2 != null)
      {
        localObject3 = (LayoutParams)((View)localObject1).getLayoutParams();
        b.a((ConstraintWidget)localObject2);
        a(bool, (View)localObject1, (ConstraintWidget)localObject2, (LayoutParams)localObject3, f);
      }
      i1 += 1;
    }
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    b.f(this);
    b.a(v);
    c.put(getId(), this);
    j = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, paramInt1, paramInt2);
      paramInt2 = paramAttributeSet.getIndexCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        int i1 = paramAttributeSet.getIndex(paramInt1);
        if (i1 == R.styleable.m)
        {
          n = paramAttributeSet.getDimensionPixelOffset(i1, n);
        }
        else if (i1 == R.styleable.j)
        {
          s = paramAttributeSet.getDimensionPixelOffset(i1, s);
        }
        else if (i1 == R.styleable.B)
        {
          e = paramAttributeSet.getDimensionPixelOffset(i1, e);
        }
        else if (i1 == R.styleable.h)
        {
          w = paramAttributeSet.getDimensionPixelOffset(i1, w);
        }
        else if (i1 == R.styleable.n)
        {
          k = paramAttributeSet.getInt(i1, k);
        }
        else if (i1 == R.styleable.o)
        {
          i1 = paramAttributeSet.getResourceId(i1, 0);
          if (i1 == 0) {
            break label294;
          }
        }
        try
        {
          d(i1);
        }
        catch (Resources.NotFoundException localNotFoundException1)
        {
          for (;;) {}
        }
        l = null;
        break label294;
        if (i1 == R.styleable.f) {
          i1 = paramAttributeSet.getResourceId(i1, 0);
        }
        try
        {
          f localF = new f();
          j = localF;
          localF.a(getContext(), i1);
        }
        catch (Resources.NotFoundException localNotFoundException2)
        {
          for (;;) {}
        }
        j = null;
        m = i1;
        label294:
        paramInt1 += 1;
      }
      paramAttributeSet.recycle();
    }
    b.a(k);
  }
  
  private void b()
  {
    i = true;
    g = -1;
    p = -1;
    o = -1;
    h = -1;
    z = 0;
    d = 0;
  }
  
  private int getPaddingWidth()
  {
    int i2 = getPaddingLeft();
    int i1 = 0;
    i2 = Math.max(0, i2);
    int i3 = Math.max(0, getPaddingRight());
    if (Build.VERSION.SDK_INT >= 17)
    {
      i1 = Math.max(0, getPaddingStart());
      i1 = Math.max(0, getPaddingEnd()) + i1;
    }
    if (i1 > 0) {
      return i1;
    }
    return i2 + i3;
  }
  
  private boolean refreshDisplay()
  {
    int i2 = getChildCount();
    boolean bool2 = false;
    int i1 = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      if (getChildAt(i1).isLayoutRequested())
      {
        bool1 = true;
        break;
      }
      i1 += 1;
    }
    if (bool1) {
      a();
    }
    return bool1;
  }
  
  public final ConstraintWidget a(View paramView)
  {
    if (paramView == this) {
      return b;
    }
    if (paramView == null) {
      return null;
    }
    return getLayoutParamsf;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    b localB = v;
    int i1 = k;
    paramInt3 += b;
    paramInt4 += i1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = View.resolveSizeAndState(paramInt3, paramInt1, 0);
      paramInt3 = View.resolveSizeAndState(paramInt4, paramInt2, 0);
      paramInt4 = Math.min(e, paramInt1 & 0xFFFFFF);
      paramInt2 = paramInt4;
      paramInt3 = Math.min(w, paramInt3 & 0xFFFFFF);
      paramInt1 = paramInt3;
      if (paramBoolean1) {
        paramInt2 = paramInt4 | 0x1000000;
      }
      if (paramBoolean2) {
        paramInt1 = paramInt3 | 0x1000000;
      }
      setMeasuredDimension(paramInt2, paramInt1);
      g = paramInt2;
      p = paramInt1;
      return;
    }
    setMeasuredDimension(paramInt3, paramInt4);
    g = paramInt3;
    p = paramInt4;
  }
  
  public void a(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (t == null) {
        t = new HashMap();
      }
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1) {
        paramObject1 = str.substring(paramInt + 1);
      }
      paramInt = ((Integer)paramObject2).intValue();
      t.put(paramObject1, Integer.valueOf(paramInt));
    }
  }
  
  protected void a(androidx.constraintlayout.solver.widgets.f paramF, int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i7 = View.MeasureSpec.getSize(paramInt2);
    int i3 = View.MeasureSpec.getMode(paramInt3);
    int i5 = View.MeasureSpec.getSize(paramInt3);
    int i4 = Math.max(0, getPaddingTop());
    int i1 = Math.max(0, getPaddingBottom());
    int i6 = i4 + i1;
    int i8 = getPaddingWidth();
    v.a(paramInt2, paramInt3, i4, i1, i8, i6);
    if (Build.VERSION.SDK_INT >= 17)
    {
      i1 = Math.max(0, getPaddingStart());
      paramInt2 = i1;
      paramInt3 = Math.max(0, getPaddingEnd());
      if ((i1 <= 0) && (paramInt3 <= 0)) {
        paramInt2 = Math.max(0, getPaddingLeft());
      } else if (get()) {
        paramInt2 = paramInt3;
      }
    }
    else
    {
      paramInt2 = Math.max(0, getPaddingLeft());
    }
    paramInt3 = i7 - i8;
    i1 = i5 - i6;
    a(paramF, i2, paramInt3, i3, i1);
    paramF.add(paramInt1, i2, paramInt3, i3, i1, g, p, paramInt2, i4);
  }
  
  protected void a(androidx.constraintlayout.solver.widgets.f paramF, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = v;
    int i1 = k;
    int i2 = b;
    localObject1 = ConstraintWidget.DimensionBehaviour.a;
    int i3 = getChildCount();
    Object localObject2;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour;
    if (paramInt1 != Integer.MIN_VALUE)
    {
      if (paramInt1 != 0) {
        if (paramInt1 != 1073741824) {
          localObject2 = localObject1;
        }
      }
      do
      {
        paramInt2 = 0;
        break;
        paramInt2 = Math.min(e - i2, paramInt2);
        localObject2 = localObject1;
        break;
        localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.c;
        localObject2 = localDimensionBehaviour;
      } while (i3 != 0);
      paramInt2 = Math.max(0, n);
      localObject2 = localDimensionBehaviour;
    }
    else
    {
      localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.c;
      localObject2 = localDimensionBehaviour;
      if (i3 == 0)
      {
        paramInt2 = Math.max(0, n);
        localObject2 = localDimensionBehaviour;
      }
    }
    if (paramInt3 != Integer.MIN_VALUE)
    {
      if (paramInt3 != 0) {
        if (paramInt3 == 1073741824) {}
      }
      do
      {
        paramInt4 = 0;
        break;
        paramInt4 = Math.min(w - i1, paramInt4);
        break;
        localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.c;
        localObject1 = localDimensionBehaviour;
      } while (i3 != 0);
      paramInt4 = Math.max(0, s);
      localObject1 = localDimensionBehaviour;
    }
    else
    {
      localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.c;
      localObject1 = localDimensionBehaviour;
      if (i3 == 0)
      {
        paramInt4 = Math.max(0, s);
        localObject1 = localDimensionBehaviour;
      }
    }
    if ((paramInt2 != paramF.getValue()) || (paramInt4 != paramF.length())) {
      paramF.close();
    }
    paramF.e(0);
    paramF.remove(0);
    paramF.visitTypeInsn(e - i2);
    paramF.visitField(w - i1);
    paramF.send(0);
    paramF.init(0);
    paramF.add(localObject2);
    paramF.get(paramInt2);
    paramF.a((ConstraintWidget.DimensionBehaviour)localObject1);
    paramF.append(paramInt4);
    paramF.send(n - i2);
    paramF.init(s - i1);
  }
  
  protected void a(boolean paramBoolean, View paramView, ConstraintWidget paramConstraintWidget, LayoutParams paramLayoutParams, SparseArray paramSparseArray)
  {
    paramLayoutParams.add();
    lock = false;
    paramConstraintWidget.add(paramView.getVisibility());
    if (e)
    {
      paramConstraintWidget.visitMethodInsn(true);
      paramConstraintWidget.add(8);
    }
    paramConstraintWidget.f(paramView);
    if ((paramView instanceof ConstraintHelper)) {
      ((ConstraintHelper)paramView).b(paramConstraintWidget, b.c());
    }
    int i1;
    int i2;
    float f1;
    if (start)
    {
      paramView = (h)paramConstraintWidget;
      i1 = time;
      i2 = content;
      f1 = key;
      if (Build.VERSION.SDK_INT < 17)
      {
        i1 = a;
        i2 = b;
        f1 = color;
      }
      if (f1 != -1.0F)
      {
        paramView.a(f1);
        return;
      }
      if (i1 != -1)
      {
        paramView.d(i1);
        return;
      }
      if (i2 != -1) {
        paramView.b(i2);
      }
    }
    else
    {
      int i4 = end;
      int i6 = value;
      i2 = pos;
      int i7 = g;
      f1 = state;
      int i5;
      if (Build.VERSION.SDK_INT < 17)
      {
        i4 = width;
        int i8 = y;
        i3 = l;
        i6 = c;
        i7 = t;
        i5 = u;
        f1 = z;
        i2 = i4;
        i1 = i8;
        if (i4 == -1)
        {
          i2 = i4;
          i1 = i8;
          if (i8 == -1)
          {
            i2 = s;
            if (i2 != -1)
            {
              i1 = i8;
            }
            else
            {
              int i9 = p;
              i2 = i4;
              i1 = i8;
              if (i9 != -1)
              {
                i1 = i9;
                i2 = i4;
              }
            }
          }
        }
        if ((i3 == -1) && (i6 == -1))
        {
          i4 = x;
          if (i4 != -1)
          {
            i3 = i4;
          }
          else
          {
            i4 = height;
            if (i4 != -1)
            {
              i6 = i4;
              i4 = i2;
              i2 = i6;
              i6 = i1;
              i1 = i3;
              break label440;
            }
          }
        }
        i4 = i2;
        i2 = i6;
        i6 = i1;
        i1 = i3;
      }
      else
      {
        i5 = max;
        i1 = current;
      }
      label440:
      int i3 = A;
      if (i3 != -1)
      {
        paramView = (ConstraintWidget)paramSparseArray.get(i3);
        if (paramView != null) {
          paramConstraintWidget.a(paramView, d, B);
        }
      }
      else
      {
        Object localObject;
        if (i4 != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(i4);
          if (paramView != null)
          {
            localObject = ConstraintAnchor.Type.g;
            paramConstraintWidget.append((ConstraintAnchor.Type)localObject, paramView, (ConstraintAnchor.Type)localObject, leftMargin, i7);
          }
        }
        else if (i6 != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(i6);
          if (paramView != null) {
            paramConstraintWidget.append(ConstraintAnchor.Type.g, paramView, ConstraintAnchor.Type.c, leftMargin, i7);
          }
        }
        if (i1 != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(i1);
          if (paramView != null) {
            paramConstraintWidget.append(ConstraintAnchor.Type.c, paramView, ConstraintAnchor.Type.g, rightMargin, i5);
          }
        }
        else if (i2 != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(i2);
          if (paramView != null)
          {
            localObject = ConstraintAnchor.Type.c;
            paramConstraintWidget.append((ConstraintAnchor.Type)localObject, paramView, (ConstraintAnchor.Type)localObject, rightMargin, i5);
          }
        }
        i1 = h;
        if (i1 != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(i1);
          if (paramView != null)
          {
            localObject = ConstraintAnchor.Type.a;
            paramConstraintWidget.append((ConstraintAnchor.Type)localObject, paramView, (ConstraintAnchor.Type)localObject, topMargin, v);
          }
        }
        else
        {
          i1 = i;
          if (i1 != -1)
          {
            paramView = (ConstraintWidget)paramSparseArray.get(i1);
            if (paramView != null) {
              paramConstraintWidget.append(ConstraintAnchor.Type.a, paramView, ConstraintAnchor.Type.b, topMargin, v);
            }
          }
        }
        i1 = k;
        if (i1 != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(i1);
          if (paramView != null) {
            paramConstraintWidget.append(ConstraintAnchor.Type.b, paramView, ConstraintAnchor.Type.a, bottomMargin, r);
          }
        }
        else
        {
          i1 = j;
          if (i1 != -1)
          {
            paramView = (ConstraintWidget)paramSparseArray.get(i1);
            if (paramView != null)
            {
              localObject = ConstraintAnchor.Type.b;
              paramConstraintWidget.append((ConstraintAnchor.Type)localObject, paramView, (ConstraintAnchor.Type)localObject, bottomMargin, r);
            }
          }
        }
        i1 = o;
        if (i1 != -1)
        {
          localObject = (View)c.get(i1);
          paramView = (ConstraintWidget)paramSparseArray.get(o);
          if ((paramView != null) && (localObject != null) && ((((View)localObject).getLayoutParams() instanceof LayoutParams)))
          {
            paramSparseArray = (LayoutParams)((View)localObject).getLayoutParams();
            q = true;
            q = true;
            localObject = ConstraintAnchor.Type.e;
            paramConstraintWidget.a((ConstraintAnchor.Type)localObject).a(paramView.a((ConstraintAnchor.Type)localObject), 0, -1, true);
            paramConstraintWidget.append(true);
            f.append(true);
            paramConstraintWidget.a(ConstraintAnchor.Type.a).a();
            paramConstraintWidget.a(ConstraintAnchor.Type.b).a();
          }
        }
        if (f1 >= 0.0F) {
          paramConstraintWidget.append(f1);
        }
        f1 = w;
        if (f1 >= 0.0F) {
          paramConstraintWidget.drawLine(f1);
        }
      }
      if (paramBoolean)
      {
        i1 = count;
        if ((i1 != -1) || (text != -1)) {
          paramConstraintWidget.append(i1, text);
        }
      }
      if (!first)
      {
        if (width == -1)
        {
          if (min) {
            paramConstraintWidget.add(ConstraintWidget.DimensionBehaviour.b);
          } else {
            paramConstraintWidget.add(ConstraintWidget.DimensionBehaviour.g);
          }
          aga = leftMargin;
          aca = rightMargin;
        }
        else
        {
          paramConstraintWidget.add(ConstraintWidget.DimensionBehaviour.b);
          paramConstraintWidget.get(0);
        }
      }
      else
      {
        paramConstraintWidget.add(ConstraintWidget.DimensionBehaviour.a);
        paramConstraintWidget.get(width);
        if (width == -2) {
          paramConstraintWidget.add(ConstraintWidget.DimensionBehaviour.c);
        }
      }
      if (!size)
      {
        if (height == -1)
        {
          if (flags) {
            paramConstraintWidget.a(ConstraintWidget.DimensionBehaviour.b);
          } else {
            paramConstraintWidget.a(ConstraintWidget.DimensionBehaviour.g);
          }
          aaa = topMargin;
          aba = bottomMargin;
        }
        else
        {
          paramConstraintWidget.a(ConstraintWidget.DimensionBehaviour.b);
          paramConstraintWidget.append(0);
        }
      }
      else
      {
        paramConstraintWidget.a(ConstraintWidget.DimensionBehaviour.a);
        paramConstraintWidget.append(height);
        if (height == -2) {
          paramConstraintWidget.a(ConstraintWidget.DimensionBehaviour.c);
        }
      }
      paramConstraintWidget.parse(buf);
      paramConstraintWidget.setTitle(buffer);
      paramConstraintWidget.add(position);
      paramConstraintWidget.put(next);
      paramConstraintWidget.down(index);
      paramConstraintWidget.add(id, data, type, length);
      paramConstraintWidget.a(status, header, mode, file);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  public LayoutParams applyFont(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public View b(int paramInt)
  {
    return (View)c.get(paramInt);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected void d(int paramInt)
  {
    l = new i(getContext(), this, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = a;
    int i2;
    int i1;
    if (localObject != null)
    {
      i2 = ((ArrayList)localObject).size();
      if (i2 > 0)
      {
        i1 = 0;
        while (i1 < i2)
        {
          ((ConstraintHelper)a.get(i1)).recycle(this);
          i1 += 1;
        }
      }
    }
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      i2 = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int i4 = Integer.parseInt(localObject[0]);
              int i6 = Integer.parseInt(localObject[1]);
              int i5 = Integer.parseInt(localObject[2]);
              int i3 = Integer.parseInt(localObject[3]);
              i4 = (int)(i4 / 1080.0F * f1);
              i6 = (int)(i6 / 1920.0F * f2);
              i5 = (int)(i5 / 1080.0F * f1);
              i3 = (int)(i3 / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              float f3 = i4;
              float f4 = i6;
              float f5 = i4 + i5;
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)localObject);
              float f6 = i6 + i3;
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)localObject);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void forceLayout()
  {
    b();
    super.forceLayout();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public Object get(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      paramObject = (String)paramObject;
      HashMap localHashMap = t;
      if ((localHashMap != null) && (localHashMap.containsKey(paramObject))) {
        return t.get(paramObject);
      }
    }
    return null;
  }
  
  protected boolean get()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i1;
      if ((getContextgetApplicationInfoflags & 0x400000) != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 != 0) && (1 == getLayoutDirection())) {
        return true;
      }
    }
    return false;
  }
  
  public int getMaxHeight()
  {
    return w;
  }
  
  public int getMaxWidth()
  {
    return e;
  }
  
  public int getMinHeight()
  {
    return s;
  }
  
  public int getMinWidth()
  {
    return n;
  }
  
  public int getOptimizationLevel()
  {
    return b.intValue();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      ConstraintWidget localConstraintWidget = f;
      if (((localView.getVisibility() != 8) || (start) || (this$0) || (mExpanded) || (paramBoolean)) && (!e))
      {
        paramInt4 = localConstraintWidget.d();
        int i1 = localConstraintWidget.max();
        int i2 = localConstraintWidget.getValue() + paramInt4;
        int i3 = localConstraintWidget.length() + i1;
        localView.layout(paramInt4, i1, i2, i3);
        if ((localView instanceof Placeholder))
        {
          localView = ((Placeholder)localView).getContent();
          if (localView != null)
          {
            localView.setVisibility(0);
            localView.layout(paramInt4, i1, i2, i3);
          }
        }
      }
      paramInt1 += 1;
    }
    paramInt3 = a.size();
    if (paramInt3 > 0)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3)
      {
        ((ConstraintHelper)a.get(paramInt1)).f(this);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1;
    if (!i)
    {
      int i2 = getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        if (getChildAt(i1).isLayoutRequested())
        {
          i = true;
          break;
        }
        i1 += 1;
      }
    }
    if (!i)
    {
      i1 = x;
      if ((i1 == paramInt1) && (y == paramInt2))
      {
        a(paramInt1, paramInt2, b.getValue(), b.length(), b.e(), b.b());
        return;
      }
      if ((i1 == paramInt1) && (View.MeasureSpec.getMode(paramInt1) == 1073741824) && (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE) && (View.MeasureSpec.getMode(y) == Integer.MIN_VALUE) && (View.MeasureSpec.getSize(paramInt2) >= b.length()))
      {
        x = paramInt1;
        y = paramInt2;
        a(paramInt1, paramInt2, b.getValue(), b.length(), b.e(), b.b());
        return;
      }
    }
    x = paramInt1;
    y = paramInt2;
    b.c(get());
    if (i)
    {
      i = false;
      if (refreshDisplay()) {
        b.clear();
      }
    }
    a(b, k, paramInt1, paramInt2);
    a(paramInt1, paramInt2, b.getValue(), b.length(), b.e(), b.b());
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = a(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof h)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      h localH = new h();
      f = localH;
      start = true;
      ((h)localH).a(name);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).f();
      getLayoutParamsthis$0 = true;
      if (!a.contains(localObject)) {
        a.add(localObject);
      }
    }
    c.put(paramView.getId(), paramView);
    i = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    c.remove(paramView.getId());
    ConstraintWidget localConstraintWidget = a(paramView);
    b.add(localConstraintWidget);
    a.remove(paramView);
    i = true;
  }
  
  protected LayoutParams putShort()
  {
    return new LayoutParams(-2, -2);
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    b();
    super.requestLayout();
  }
  
  public void setConstraintSet(f paramF)
  {
    j = paramF;
  }
  
  public void setId(int paramInt)
  {
    c.remove(getId());
    super.setId(paramInt);
    c.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == w) {
      return;
    }
    w = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == e) {
      return;
    }
    e = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == s) {
      return;
    }
    s = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == n) {
      return;
    }
    n = paramInt;
    requestLayout();
  }
  
  public void setOnConstraintsChanged(NavigationMenuPresenter paramNavigationMenuPresenter)
  {
    i localI = l;
    if (localI != null) {
      localI.c(paramNavigationMenuPresenter);
    }
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    k = paramInt;
    b.a(paramInt);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int A = -1;
    public int B = 0;
    public int a = -1;
    public int b = -1;
    public String buf = null;
    public float buffer = -1.0F;
    public int c = -1;
    public float color = -1.0F;
    int content;
    public int count = -1;
    int current = -1;
    public float d = 0.0F;
    public int data = 0;
    boolean e = false;
    int end = -1;
    ConstraintWidget f = new ConstraintWidget();
    public float file = 1.0F;
    boolean first = true;
    public boolean flags = false;
    int g = -1;
    public int h = -1;
    public int header = 0;
    public int height = -1;
    public int i = -1;
    public int id = 0;
    public int index = 0;
    public int j = -1;
    public int k = -1;
    float key;
    public int l = -1;
    int len = 1;
    public float length = 1.0F;
    public boolean lock = false;
    public int m = -1;
    boolean mExpanded = false;
    int max = -1;
    public boolean min = false;
    public int mode = 0;
    public int n = -1;
    public int name = -1;
    public int next = 0;
    public int o = -1;
    float offset = 0.0F;
    public int p = -1;
    int pos = -1;
    public float position = -1.0F;
    boolean q = false;
    public int r = -1;
    public int s = -1;
    boolean size = true;
    boolean start = false;
    float state = 0.5F;
    public int status = 0;
    public int t = -1;
    public int text = -1;
    boolean this$0 = false;
    int time;
    public String title = null;
    public int type = 0;
    public int u = -1;
    public int v = -1;
    int value = -1;
    public float w = 0.5F;
    public int width = -1;
    public int x = -1;
    public int y = -1;
    public float z = 0.5F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView);
      int i3 = paramContext.getIndexCount();
      int i1 = 0;
      while (i1 < i3)
      {
        int i2 = paramContext.getIndex(i1);
        int i4 = a.next.get(i2);
        String str;
        switch (i4)
        {
        default: 
          switch (i4)
          {
          default: 
            break;
          case 51: 
            title = paramContext.getString(i2);
            break;
          case 50: 
            text = paramContext.getDimensionPixelOffset(i2, text);
            break;
          case 49: 
            count = paramContext.getDimensionPixelOffset(i2, count);
            break;
          case 48: 
            index = paramContext.getInt(i2, 0);
            break;
          case 47: 
            next = paramContext.getInt(i2, 0);
            break;
          case 46: 
            position = paramContext.getFloat(i2, position);
            break;
          case 45: 
            buffer = paramContext.getFloat(i2, buffer);
            break;
          case 44: 
            paramAttributeSet = paramContext.getString(i2);
            buf = paramAttributeSet;
            offset = NaN.0F;
            len = -1;
            if (paramAttributeSet != null)
            {
              i4 = paramAttributeSet.length();
              i2 = buf.indexOf(',');
              if ((i2 > 0) && (i2 < i4 - 1))
              {
                paramAttributeSet = buf.substring(0, i2);
                if (paramAttributeSet.equalsIgnoreCase("W")) {
                  len = 0;
                } else if (paramAttributeSet.equalsIgnoreCase("H")) {
                  len = 1;
                }
                i2 += 1;
              }
              else
              {
                i2 = 0;
              }
              int i5 = buf.indexOf(':');
              if ((i5 >= 0) && (i5 < i4 - 1))
              {
                paramAttributeSet = buf.substring(i2, i5);
                str = buf.substring(i5 + 1);
                if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                  break;
                }
              }
            }
            break;
          }
          break;
        }
        try
        {
          f1 = Float.parseFloat(paramAttributeSet);
          float f2 = Float.parseFloat(str);
          if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
            break label2312;
          }
          if (len == 1)
          {
            f1 = f2 / f1;
            f1 = Math.abs(f1);
            offset = f1;
          }
          else
          {
            f1 /= f2;
            f1 = Math.abs(f1);
            offset = f1;
          }
        }
        catch (NumberFormatException paramAttributeSet)
        {
          float f1;
          for (;;) {}
        }
        paramAttributeSet = buf.substring(i2);
        if (paramAttributeSet.length() > 0) {}
        try
        {
          f1 = Float.parseFloat(paramAttributeSet);
          offset = f1;
        }
        catch (NumberFormatException paramAttributeSet)
        {
          for (;;) {}
        }
        file = Math.max(0.0F, paramContext.getFloat(i2, file));
        status = 2;
        break label2312;
        i4 = mode;
        try
        {
          i4 = paramContext.getDimensionPixelSize(i2, i4);
          mode = i4;
        }
        catch (Exception paramAttributeSet)
        {
          for (;;) {}
        }
        if (paramContext.getInt(i2, mode) == -2)
        {
          mode = -2;
          break label2312;
          i4 = header;
        }
        try
        {
          i4 = paramContext.getDimensionPixelSize(i2, i4);
          header = i4;
        }
        catch (Exception paramAttributeSet)
        {
          for (;;) {}
        }
        if (paramContext.getInt(i2, header) == -2)
        {
          header = -2;
          break label2312;
          length = Math.max(0.0F, paramContext.getFloat(i2, length));
          id = 2;
          break label2312;
          i4 = type;
        }
        try
        {
          i4 = paramContext.getDimensionPixelSize(i2, i4);
          type = i4;
        }
        catch (Exception paramAttributeSet)
        {
          for (;;) {}
        }
        if (paramContext.getInt(i2, type) == -2)
        {
          type = -2;
          break label2312;
          i4 = data;
        }
        try
        {
          i4 = paramContext.getDimensionPixelSize(i2, i4);
          data = i4;
        }
        catch (Exception paramAttributeSet)
        {
          label2312:
          for (;;) {}
        }
        if (paramContext.getInt(i2, data) == -2)
        {
          data = -2;
          break label2312;
          i2 = paramContext.getInt(i2, 0);
          status = i2;
          if (i2 == 1)
          {
            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            break label2312;
            i2 = paramContext.getInt(i2, 0);
            id = i2;
            if (i2 == 1)
            {
              Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
              break label2312;
              w = paramContext.getFloat(i2, w);
              break label2312;
              z = paramContext.getFloat(i2, z);
              break label2312;
              flags = paramContext.getBoolean(i2, flags);
              break label2312;
              min = paramContext.getBoolean(i2, min);
              break label2312;
              n = paramContext.getDimensionPixelSize(i2, n);
              break label2312;
              m = paramContext.getDimensionPixelSize(i2, m);
              break label2312;
              r = paramContext.getDimensionPixelSize(i2, r);
              break label2312;
              u = paramContext.getDimensionPixelSize(i2, u);
              break label2312;
              v = paramContext.getDimensionPixelSize(i2, v);
              break label2312;
              t = paramContext.getDimensionPixelSize(i2, t);
              break label2312;
              i4 = paramContext.getResourceId(i2, height);
              height = i4;
              if (i4 == -1)
              {
                height = paramContext.getInt(i2, -1);
                break label2312;
                i4 = paramContext.getResourceId(i2, x);
                x = i4;
                if (i4 == -1)
                {
                  x = paramContext.getInt(i2, -1);
                  break label2312;
                  i4 = paramContext.getResourceId(i2, s);
                  s = i4;
                  if (i4 == -1)
                  {
                    s = paramContext.getInt(i2, -1);
                    break label2312;
                    i4 = paramContext.getResourceId(i2, p);
                    p = i4;
                    if (i4 == -1)
                    {
                      p = paramContext.getInt(i2, -1);
                      break label2312;
                      i4 = paramContext.getResourceId(i2, o);
                      o = i4;
                      if (i4 == -1)
                      {
                        o = paramContext.getInt(i2, -1);
                        break label2312;
                        i4 = paramContext.getResourceId(i2, j);
                        j = i4;
                        if (i4 == -1)
                        {
                          j = paramContext.getInt(i2, -1);
                          break label2312;
                          i4 = paramContext.getResourceId(i2, k);
                          k = i4;
                          if (i4 == -1)
                          {
                            k = paramContext.getInt(i2, -1);
                            break label2312;
                            i4 = paramContext.getResourceId(i2, i);
                            i = i4;
                            if (i4 == -1)
                            {
                              i = paramContext.getInt(i2, -1);
                              break label2312;
                              i4 = paramContext.getResourceId(i2, h);
                              h = i4;
                              if (i4 == -1)
                              {
                                h = paramContext.getInt(i2, -1);
                                break label2312;
                                i4 = paramContext.getResourceId(i2, c);
                                c = i4;
                                if (i4 == -1)
                                {
                                  c = paramContext.getInt(i2, -1);
                                  break label2312;
                                  i4 = paramContext.getResourceId(i2, l);
                                  l = i4;
                                  if (i4 == -1)
                                  {
                                    l = paramContext.getInt(i2, -1);
                                    break label2312;
                                    i4 = paramContext.getResourceId(i2, y);
                                    y = i4;
                                    if (i4 == -1)
                                    {
                                      y = paramContext.getInt(i2, -1);
                                      break label2312;
                                      i4 = paramContext.getResourceId(i2, width);
                                      width = i4;
                                      if (i4 == -1)
                                      {
                                        width = paramContext.getInt(i2, -1);
                                        break label2312;
                                        color = paramContext.getFloat(i2, color);
                                        break label2312;
                                        b = paramContext.getDimensionPixelOffset(i2, b);
                                        break label2312;
                                        a = paramContext.getDimensionPixelOffset(i2, a);
                                        break label2312;
                                        f1 = paramContext.getFloat(i2, d) % 360.0F;
                                        d = f1;
                                        if (f1 < 0.0F)
                                        {
                                          d = ((360.0F - f1) % 360.0F);
                                          break label2312;
                                          B = paramContext.getDimensionPixelSize(i2, B);
                                          break label2312;
                                          i4 = paramContext.getResourceId(i2, A);
                                          A = i4;
                                          if (i4 == -1)
                                          {
                                            A = paramContext.getInt(i2, -1);
                                            break label2312;
                                            name = paramContext.getInt(i2, name);
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        i1 += 1;
      }
      paramContext.recycle();
      add();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void add()
    {
      start = false;
      first = true;
      size = true;
      int i1 = width;
      if ((i1 == -2) && (min))
      {
        first = false;
        if (id == 0) {
          id = 1;
        }
      }
      int i2 = height;
      if ((i2 == -2) && (flags))
      {
        size = false;
        if (status == 0) {
          status = 1;
        }
      }
      if ((i1 == 0) || (i1 == -1))
      {
        first = false;
        if ((i1 == 0) && (id == 1))
        {
          width = -2;
          min = true;
        }
      }
      if ((i2 == 0) || (i2 == -1))
      {
        size = false;
        if ((i2 == 0) && (status == 1))
        {
          height = -2;
          flags = true;
        }
      }
      if ((color != -1.0F) || (a != -1) || (b != -1))
      {
        start = true;
        first = true;
        size = true;
        if (!(f instanceof h)) {
          f = new h();
        }
        ((h)f).a(name);
      }
    }
    
    public void resolveLayoutDirection(int paramInt)
    {
      int i2 = leftMargin;
      int i3 = rightMargin;
      int i4 = Build.VERSION.SDK_INT;
      int i1 = 0;
      if (i4 >= 17)
      {
        super.resolveLayoutDirection(paramInt);
        if (1 == getLayoutDirection())
        {
          paramInt = 1;
          break label47;
        }
      }
      paramInt = 0;
      label47:
      current = -1;
      pos = -1;
      end = -1;
      value = -1;
      g = -1;
      max = -1;
      g = t;
      max = u;
      float f1 = z;
      state = f1;
      i4 = a;
      time = i4;
      int i5 = b;
      content = i5;
      float f2 = color;
      key = f2;
      if (paramInt != 0)
      {
        paramInt = p;
        if (paramInt != -1) {
          current = paramInt;
        }
        for (;;)
        {
          paramInt = 1;
          break;
          int i6 = s;
          paramInt = i1;
          if (i6 == -1) {
            break;
          }
          pos = i6;
        }
        i1 = x;
        if (i1 != -1)
        {
          value = i1;
          paramInt = 1;
        }
        i1 = height;
        if (i1 != -1)
        {
          end = i1;
          paramInt = 1;
        }
        i1 = m;
        if (i1 != -1) {
          max = i1;
        }
        i1 = n;
        if (i1 != -1) {
          g = i1;
        }
        if (paramInt != 0) {
          state = (1.0F - f1);
        }
        if ((start) && (name == 1)) {
          if (f2 != -1.0F)
          {
            key = (1.0F - f2);
            time = -1;
            content = -1;
          }
          else if (i4 != -1)
          {
            content = i4;
            time = -1;
            key = -1.0F;
          }
          else if (i5 != -1)
          {
            time = i5;
            content = -1;
            key = -1.0F;
          }
        }
      }
      else
      {
        paramInt = p;
        if (paramInt != -1) {
          value = paramInt;
        }
        paramInt = s;
        if (paramInt != -1) {
          end = paramInt;
        }
        paramInt = x;
        if (paramInt != -1) {
          current = paramInt;
        }
        paramInt = height;
        if (paramInt != -1) {
          pos = paramInt;
        }
        paramInt = m;
        if (paramInt != -1) {
          g = paramInt;
        }
        paramInt = n;
        if (paramInt != -1) {
          max = paramInt;
        }
      }
      if ((x == -1) && (height == -1) && (s == -1) && (p == -1))
      {
        paramInt = l;
        if (paramInt != -1)
        {
          current = paramInt;
          if ((rightMargin <= 0) && (i3 > 0)) {
            rightMargin = i3;
          }
        }
        else
        {
          paramInt = c;
          if (paramInt != -1)
          {
            pos = paramInt;
            if ((rightMargin <= 0) && (i3 > 0)) {
              rightMargin = i3;
            }
          }
        }
        paramInt = width;
        if (paramInt != -1)
        {
          end = paramInt;
          if ((leftMargin <= 0) && (i2 > 0)) {
            leftMargin = i2;
          }
        }
        else
        {
          paramInt = y;
          if (paramInt != -1)
          {
            value = paramInt;
            if ((leftMargin <= 0) && (i2 > 0)) {
              leftMargin = i2;
            }
          }
        }
      }
    }
    
    private static class a
    {
      public static final SparseIntArray next;
      
      static
      {
        SparseIntArray localSparseIntArray = new SparseIntArray();
        next = localSparseIntArray;
        localSparseIntArray.append(R.styleable.FF, 8);
        localSparseIntArray.append(R.styleable.RV, 9);
        localSparseIntArray.append(R.styleable.R2, 10);
        localSparseIntArray.append(R.styleable.R1, 11);
        localSparseIntArray.append(R.styleable.Theme_dropDownListViewStyle, 12);
        localSparseIntArray.append(R.styleable.group, 13);
        localSparseIntArray.append(R.styleable.port, 14);
        localSparseIntArray.append(R.styleable.fragment, 15);
        localSparseIntArray.append(R.styleable.title, 16);
        localSparseIntArray.append(R.styleable.address, 2);
        localSparseIntArray.append(R.styleable.data, 3);
        localSparseIntArray.append(R.styleable.T, 4);
        localSparseIntArray.append(R.styleable.value, 49);
        localSparseIntArray.append(R.styleable.Theme_colorPrimaryDark, 50);
        localSparseIntArray.append(R.styleable.DOMAIN, 5);
        localSparseIntArray.append(R.styleable.domain, 6);
        localSparseIntArray.append(R.styleable.ALL, 7);
        localSparseIntArray.append(R.styleable.PROJECTION, 1);
        localSparseIntArray.append(R.styleable.HOST, 17);
        localSparseIntArray.append(R.styleable.PATH, 18);
        localSparseIntArray.append(R.styleable.NUMBER, 19);
        localSparseIntArray.append(R.styleable.DATE, 20);
        localSparseIntArray.append(R.styleable.TIME, 21);
        localSparseIntArray.append(R.styleable.mValue, 22);
        localSparseIntArray.append(R.styleable.ON, 23);
        localSparseIntArray.append(R.styleable.OFF, 24);
        localSparseIntArray.append(R.styleable.NULL, 25);
        localSparseIntArray.append(R.styleable.INTEGER, 26);
        localSparseIntArray.append(R.styleable.labels, 29);
        localSparseIntArray.append(R.styleable.author, 30);
        localSparseIntArray.append(R.styleable.copyright, 44);
        localSparseIntArray.append(R.styleable.image, 45);
        localSparseIntArray.append(R.styleable.tags, 46);
        localSparseIntArray.append(R.styleable.children, 47);
        localSparseIntArray.append(R.styleable.STRING, 48);
        localSparseIntArray.append(R.styleable.STATE, 27);
        localSparseIntArray.append(R.styleable.URL, 28);
        localSparseIntArray.append(R.styleable.NAMESPACE, 31);
        localSparseIntArray.append(R.styleable.description, 32);
        localSparseIntArray.append(R.styleable.enabled, 33);
        localSparseIntArray.append(R.styleable.code, 34);
        localSparseIntArray.append(R.styleable.name, 35);
        localSparseIntArray.append(R.styleable.AUTHORITY, 36);
        localSparseIntArray.append(R.styleable.URI, 37);
        localSparseIntArray.append(R.styleable.TEXT, 38);
        localSparseIntArray.append(R.styleable.UNKNOWN, 39);
        localSparseIntArray.append(R.styleable.BR, 40);
        localSparseIntArray.append(R.styleable.Theme_searchViewStyle, 41);
        localSparseIntArray.append(R.styleable.PROTECTED, 42);
        localSparseIntArray.append(R.styleable.PACKAGE, 43);
        next.append(R.styleable.maxMemory, 51);
      }
    }
  }
  
  class b
    implements Item
  {
    int b;
    ConstraintLayout d;
    int i;
    int j;
    int k;
    int l;
    int s;
    
    public b(ConstraintLayout paramConstraintLayout)
    {
      d = paramConstraintLayout;
    }
    
    private boolean measure(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == paramInt2) {
        return true;
      }
      int m = View.MeasureSpec.getMode(paramInt1);
      View.MeasureSpec.getSize(paramInt1);
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      return (paramInt1 == 1073741824) && ((m == Integer.MIN_VALUE) || (m == 0)) && (paramInt3 == paramInt2);
    }
    
    public final void a()
    {
      int i1 = d.getChildCount();
      int n = 0;
      int m = 0;
      while (m < i1)
      {
        View localView = d.getChildAt(m);
        if ((localView instanceof Placeholder)) {
          ((Placeholder)localView).a(d);
        }
        m += 1;
      }
      i1 = ConstraintLayout.n(d).size();
      if (i1 > 0)
      {
        m = n;
        while (m < i1)
        {
          ((ConstraintHelper)ConstraintLayout.n(d).get(m)).c(d);
          m += 1;
        }
      }
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      j = paramInt3;
      l = paramInt4;
      b = paramInt5;
      k = paramInt6;
      i = paramInt1;
      s = paramInt2;
    }
    
    public final void a(ConstraintWidget paramConstraintWidget, ClassWriter paramClassWriter)
    {
      if (paramConstraintWidget == null) {
        return;
      }
      if ((paramConstraintWidget.get() == 8) && (!paramConstraintWidget.getSort()))
      {
        z = 0;
        s = 0;
        q = 0;
        return;
      }
      if (paramConstraintWidget.listFiles() == null) {
        return;
      }
      Object localObject1 = i;
      Object localObject2 = b;
      int m = f;
      int i2 = j;
      int i3 = j + l;
      int n = b;
      View localView = (View)paramConstraintWidget.getParent();
      Object localObject3 = ConstraintLayout.a.d;
      int i1 = localObject3[localObject1.ordinal()];
      int i4;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              m = 0;
            }
            else
            {
              i1 = ViewGroup.getChildMeasureSpec(i, n, -2);
              if (i == 1) {
                n = 1;
              } else {
                n = 0;
              }
              i4 = c;
              if (i4 != ClassWriter.d)
              {
                m = i1;
                if (i4 != ClassWriter.r) {}
              }
              else
              {
                if (localView.getMeasuredHeight() == paramConstraintWidget.length()) {
                  m = 1;
                } else {
                  m = 0;
                }
                if ((c != ClassWriter.r) && (n != 0) && ((n == 0) || (m == 0)) && (!(localView instanceof Placeholder)) && (!paramConstraintWidget.h())) {
                  n = 0;
                } else {
                  n = 1;
                }
                m = i1;
                if (n != 0) {
                  m = View.MeasureSpec.makeMeasureSpec(paramConstraintWidget.getValue(), 1073741824);
                }
              }
            }
          }
          else {
            m = ViewGroup.getChildMeasureSpec(i, n + paramConstraintWidget.getIcon(), -1);
          }
        }
        else {
          m = ViewGroup.getChildMeasureSpec(i, n, -2);
        }
      }
      else {
        m = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
      }
      n = localObject3[localObject2.ordinal()];
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4)
            {
              n = 0;
            }
            else
            {
              i2 = ViewGroup.getChildMeasureSpec(s, i3, -2);
              if (n == 1) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              i3 = c;
              if (i3 != ClassWriter.d)
              {
                n = i2;
                if (i3 != ClassWriter.r) {}
              }
              else
              {
                if (localView.getMeasuredWidth() == paramConstraintWidget.getValue()) {
                  n = 1;
                } else {
                  n = 0;
                }
                if ((c != ClassWriter.r) && (i1 != 0) && ((i1 == 0) || (n == 0)) && (!(localView instanceof Placeholder)) && (!paramConstraintWidget.j())) {
                  i1 = 0;
                } else {
                  i1 = 1;
                }
                n = i2;
                if (i1 != 0) {
                  n = View.MeasureSpec.makeMeasureSpec(paramConstraintWidget.length(), 1073741824);
                }
              }
            }
          }
          else {
            n = ViewGroup.getChildMeasureSpec(s, i3 + paramConstraintWidget.setIcon(), -1);
          }
        }
        else {
          n = ViewGroup.getChildMeasureSpec(s, i3, -2);
        }
      }
      else {
        n = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
      }
      localObject3 = (androidx.constraintlayout.solver.widgets.f)paramConstraintWidget.listFiles();
      if ((localObject3 != null) && (Frame.b(ConstraintLayout.a(ConstraintLayout.this), 256)) && (localView.getMeasuredWidth() == paramConstraintWidget.getValue()) && (localView.getMeasuredWidth() < ((ConstraintWidget)localObject3).getValue()) && (localView.getMeasuredHeight() == paramConstraintWidget.length()) && (localView.getMeasuredHeight() < ((ConstraintWidget)localObject3).length()) && (localView.getBaseline() == paramConstraintWidget.newUTF8()) && (!paramConstraintWidget.l()))
      {
        if ((measure(paramConstraintWidget.getM(), m, paramConstraintWidget.getValue())) && (measure(paramConstraintWidget.position(), n, paramConstraintWidget.length()))) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          z = paramConstraintWidget.getValue();
          s = paramConstraintWidget.length();
          q = paramConstraintWidget.newUTF8();
          return;
        }
      }
      localObject3 = ConstraintWidget.DimensionBehaviour.b;
      if (localObject1 == localObject3) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (localObject2 == localObject3) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      localObject3 = ConstraintWidget.DimensionBehaviour.g;
      int i5;
      if ((localObject2 != localObject3) && (localObject2 != ConstraintWidget.DimensionBehaviour.a)) {
        i5 = 0;
      } else {
        i5 = 1;
      }
      int i6;
      if ((localObject1 != localObject3) && (localObject1 != ConstraintWidget.DimensionBehaviour.a)) {
        i6 = 0;
      } else {
        i6 = 1;
      }
      int i7;
      if ((i1 != 0) && (right > 0.0F)) {
        i7 = 1;
      } else {
        i7 = 0;
      }
      int i8;
      if ((i2 != 0) && (right > 0.0F)) {
        i8 = 1;
      } else {
        i8 = 0;
      }
      if (localView == null) {
        return;
      }
      localObject1 = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      i3 = c;
      if ((i3 != ClassWriter.d) && (i3 != ClassWriter.r) && (i1 != 0) && (i == 0) && (i2 != 0) && (n == 0))
      {
        i5 = 0;
        i1 = 0;
        i4 = 0;
      }
      else
      {
        if (((localView instanceof VirtualLayout)) && ((paramConstraintWidget instanceof d)))
        {
          localObject2 = (d)paramConstraintWidget;
          ((VirtualLayout)localView).g((d)localObject2, m, n);
        }
        else
        {
          localView.measure(m, n);
        }
        paramConstraintWidget.read(m, n);
        int i10 = localView.getMeasuredWidth();
        int i9 = localView.getMeasuredHeight();
        int i11 = localView.getBaseline();
        i1 = r;
        if (i1 > 0) {
          i2 = Math.max(i1, i10);
        } else {
          i2 = i10;
        }
        i3 = w;
        i1 = i2;
        if (i3 > 0) {
          i1 = Math.min(i3, i2);
        }
        i2 = s;
        if (i2 > 0) {
          i2 = Math.max(i2, i9);
        } else {
          i2 = i9;
        }
        i3 = m;
        i4 = i2;
        if (i3 > 0) {
          i4 = Math.min(i3, i2);
        }
        i3 = i1;
        i2 = i4;
        if (!Frame.b(ConstraintLayout.a(ConstraintLayout.this), 1))
        {
          float f;
          if ((i7 != 0) && (i5 != 0))
          {
            f = right;
            i3 = (int)(i4 * f + 0.5F);
            i2 = i4;
          }
          else
          {
            i3 = i1;
            i2 = i4;
            if (i8 != 0)
            {
              i3 = i1;
              i2 = i4;
              if (i6 != 0)
              {
                f = right;
                i2 = (int)(i1 / f + 0.5F);
                i3 = i1;
              }
            }
          }
        }
        if (i10 == i3)
        {
          i1 = i11;
          i4 = i3;
          i5 = i2;
          if (i9 != i2) {}
        }
        for (;;)
        {
          break;
          if (i10 != i3) {
            m = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
          }
          if (i9 != i2) {
            n = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
          }
          localView.measure(m, n);
          paramConstraintWidget.read(m, n);
          i4 = localView.getMeasuredWidth();
          i5 = localView.getMeasuredHeight();
          i1 = localView.getBaseline();
        }
      }
      boolean bool1;
      if (i1 != -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((i4 == f) && (i5 == j)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      k = bool2;
      if (q) {
        bool1 = true;
      }
      if ((bool1) && (i1 != -1) && (paramConstraintWidget.newUTF8() != i1)) {
        k = true;
      }
      z = i4;
      s = i5;
      e = bool1;
      q = i1;
    }
  }
}

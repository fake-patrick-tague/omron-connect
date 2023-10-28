package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.AnnotationWriter;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper
  extends View
{
  protected Context a;
  protected int[] b = new int[32];
  private HashMap<Integer, String> c = new HashMap();
  protected boolean d = false;
  protected String g;
  private View[] j = null;
  protected int k;
  protected AnnotationWriter l;
  protected String q;
  
  public ConstraintHelper(Context paramContext)
  {
    super(paramContext);
    a = paramContext;
    applyStyle(null);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a = paramContext;
    applyStyle(paramAttributeSet);
  }
  
  private int a(ConstraintLayout paramConstraintLayout, String paramString)
  {
    if (paramString != null)
    {
      if (paramConstraintLayout == null) {
        return 0;
      }
      Resources localResources = a.getResources();
      if (localResources == null) {
        return 0;
      }
      int m = paramConstraintLayout.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= m) {
          break label104;
        }
        View localView = paramConstraintLayout.getChildAt(i);
        Object localObject;
        if (localView.getId() != -1) {
          localObject = null;
        }
        try
        {
          String str = localResources.getResourceEntryName(localView.getId());
          localObject = str;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;) {}
        }
        if (paramString.equals(localObject)) {
          return localView.getId();
        }
        i += 1;
      }
    }
    return 0;
    label104:
    return 0;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == getId()) {
      return;
    }
    int i = k;
    int[] arrayOfInt = b;
    if (i + 1 > arrayOfInt.length) {
      b = Arrays.copyOf(arrayOfInt, arrayOfInt.length * 2);
    }
    arrayOfInt = b;
    i = k;
    arrayOfInt[i] = paramInt;
    k = (i + 1);
  }
  
  private void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (a == null) {
        return;
      }
      String str = paramString.trim();
      paramString = null;
      if ((getParent() instanceof ConstraintLayout)) {
        paramString = (ConstraintLayout)getParent();
      }
      if (paramString == null)
      {
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
      }
      int m = paramString.getChildCount();
      int i = 0;
      while (i < m)
      {
        View localView = paramString.getChildAt(i);
        Object localObject = localView.getLayoutParams();
        if (((localObject instanceof ConstraintLayout.LayoutParams)) && (str.equals(title))) {
          if (localView.getId() == -1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("to use ConstraintTag view ");
            ((StringBuilder)localObject).append(localView.getClass().getSimpleName());
            ((StringBuilder)localObject).append(" must have an ID");
            Log.w("ConstraintHelper", ((StringBuilder)localObject).toString());
          }
          else
          {
            a(localView.getId());
          }
        }
        i += 1;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (a == null) {
        return;
      }
      paramString = paramString.trim();
      if ((getParent() instanceof ConstraintLayout)) {
        localObject = (ConstraintLayout)getParent();
      }
      int i = getIdentifier(paramString);
      if (i != 0)
      {
        c.put(Integer.valueOf(i), paramString);
        a(i);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find id of \"");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\"");
      Log.w("ConstraintHelper", ((StringBuilder)localObject).toString());
    }
  }
  
  private int getIdentifier(String paramString)
  {
    ConstraintLayout localConstraintLayout;
    if ((getParent() instanceof ConstraintLayout)) {
      localConstraintLayout = (ConstraintLayout)getParent();
    } else {
      localConstraintLayout = null;
    }
    boolean bool = isInEditMode();
    int i = 0;
    int m = i;
    if (bool)
    {
      m = i;
      if (localConstraintLayout != null)
      {
        Object localObject = localConstraintLayout.get(0, paramString);
        m = i;
        if ((localObject instanceof Integer)) {
          m = ((Integer)localObject).intValue();
        }
      }
    }
    i = m;
    if (m == 0)
    {
      i = m;
      if (localConstraintLayout != null) {
        i = a(localConstraintLayout, paramString);
      }
    }
    m = i;
    if (i == 0) {}
    try
    {
      m = d.class.getField(paramString).getInt(null);
      if (m == 0) {
        return a.getResources().getIdentifier(paramString, "id", a.getPackageName());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        m = i;
      }
    }
    return m;
  }
  
  public void a(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(g);
    }
    Object localObject1 = l;
    if (localObject1 == null) {
      return;
    }
    ((AnnotationWriter)localObject1).put();
    int i = 0;
    while (i < k)
    {
      int m = b[i];
      Object localObject3 = paramConstraintLayout.b(m);
      localObject1 = localObject3;
      Object localObject2 = localObject1;
      if (localObject3 == null)
      {
        localObject3 = (String)c.get(Integer.valueOf(m));
        m = a(paramConstraintLayout, (String)localObject3);
        localObject2 = localObject1;
        if (m != 0)
        {
          b[i] = m;
          c.put(Integer.valueOf(m), localObject3);
          localObject2 = paramConstraintLayout.b(m);
        }
      }
      if (localObject2 != null) {
        l.a(paramConstraintLayout.a((View)localObject2));
      }
      i += 1;
    }
    l.a(b);
  }
  
  protected void animateOpen()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ConstraintLayout))) {
      b((ConstraintLayout)localViewParent);
    }
  }
  
  protected void applyStyle(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView);
      int m = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < m)
      {
        int n = paramAttributeSet.getIndex(i);
        String str;
        if (n == R.styleable.TextAppearance_android_shadowColor)
        {
          str = paramAttributeSet.getString(n);
          g = str;
          setIds(str);
        }
        else if (n == R.styleable.TextAppearance_android_shadowDx)
        {
          str = paramAttributeSet.getString(n);
          q = str;
          setReferenceTags(str);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  public void b(ConstraintWidget paramConstraintWidget, boolean paramBoolean) {}
  
  protected void b(ConstraintLayout paramConstraintLayout)
  {
    int m = getVisibility();
    float f;
    if (Build.VERSION.SDK_INT >= 21) {
      f = getElevation();
    } else {
      f = 0.0F;
    }
    int i = 0;
    while (i < k)
    {
      View localView = paramConstraintLayout.b(b[i]);
      if (localView != null)
      {
        localView.setVisibility(m);
        if ((f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
          localView.setTranslationZ(localView.getTranslationZ() + f);
        }
      }
      i += 1;
    }
  }
  
  public void c(ConstraintLayout paramConstraintLayout) {}
  
  public void f()
  {
    if (l == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localLayoutParams instanceof ConstraintLayout.LayoutParams)) {
      f = ((ConstraintWidget)l);
    }
  }
  
  public void f(ConstraintLayout paramConstraintLayout) {}
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(b, k);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = g;
    if (str != null) {
      setIds(str);
    }
    str = q;
    if (str != null) {
      setReferenceTags(str);
    }
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (d)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public void recycle(ConstraintLayout paramConstraintLayout) {}
  
  protected void setIds(String paramString)
  {
    g = paramString;
    if (paramString == null) {
      return;
    }
    int i = 0;
    k = 0;
    for (;;)
    {
      int m = paramString.indexOf(',', i);
      if (m == -1)
      {
        b(paramString.substring(i));
        return;
      }
      b(paramString.substring(i, m));
      i = m + 1;
    }
  }
  
  protected void setReferenceTags(String paramString)
  {
    q = paramString;
    if (paramString == null) {
      return;
    }
    int i = 0;
    k = 0;
    for (;;)
    {
      int m = paramString.indexOf(',', i);
      if (m == -1)
      {
        a(paramString.substring(i));
        return;
      }
      a(paramString.substring(i, m));
      i = m + 1;
    }
  }
  
  public void setReferencedIds(int[] paramArrayOfInt)
  {
    g = null;
    int i = 0;
    k = 0;
    while (i < paramArrayOfInt.length)
    {
      a(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    super.setTag(paramInt, paramObject);
    if ((paramObject == null) && (g == null)) {
      a(paramInt);
    }
  }
}

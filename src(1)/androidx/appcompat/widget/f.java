package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

class f
{
  private static final RectF g = new RectF();
  private static ConcurrentHashMap<String, Method> h = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Field> t = new ConcurrentHashMap();
  private final TextView a;
  private TextPaint b;
  private int c = 0;
  private int[] d = new int[0];
  private boolean e = false;
  private final Context m;
  private final LinkedList n;
  private boolean r = false;
  private float x = -1.0F;
  private float y = -1.0F;
  private float z = -1.0F;
  
  f(TextView paramTextView)
  {
    a = paramTextView;
    m = paramTextView.getContext();
    int i = Build.VERSION.SDK_INT;
    if (i >= 29)
    {
      n = new ExclusiveRange.RangeIterator();
      return;
    }
    if (i >= 23)
    {
      n = new LimitedQueue();
      return;
    }
    n = new LinkedList();
  }
  
  private int a(RectF paramRectF)
  {
    int k = d.length;
    if (k != 0)
    {
      int j = 0;
      int i = 1;
      k -= 1;
      while (i <= k)
      {
        j = (i + k) / 2;
        if (a(d[j], paramRectF))
        {
          int i1 = j + 1;
          j = i;
          i = i1;
        }
        else
        {
          j -= 1;
          k = j;
        }
      }
      return d[j];
    }
    throw new IllegalStateException("No available text sizes to choose from.");
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1 = ((Float)put(a, "mSpacingMult", Float.valueOf(1.0F))).floatValue();
    float f2 = ((Float)put(a, "mSpacingAdd", Float.valueOf(0.0F))).floatValue();
    boolean bool = ((Boolean)put(a, "mIncludePad", Boolean.TRUE)).booleanValue();
    return new StaticLayout(paramCharSequence, b, paramInt, paramAlignment, f1, f2, bool);
  }
  
  private static Method a(String paramString)
  {
    Object localObject1 = h;
    try
    {
      localObject1 = ((ConcurrentHashMap)localObject1).get(paramString);
      localObject2 = (Method)localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Method)localObject2).setAccessible(true);
          localObject1 = h;
          ((ConcurrentHashMap)localObject1).put(paramString, localObject2);
          return localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to retrieve TextView#");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("() method");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject2).toString(), localException);
      return null;
    }
    return localException;
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat != a.getPaint().getTextSize())
    {
      a.getPaint().setTextSize(paramFloat);
      boolean bool;
      if (Build.VERSION.SDK_INT >= 18) {
        bool = SizeMetrics.drawText(a);
      } else {
        bool = false;
      }
      if (a.getLayout() != null)
      {
        r = false;
        try
        {
          Method localMethod = a("nullLayouts");
          if (localMethod != null)
          {
            TextView localTextView = a;
            localMethod.invoke(localTextView, new Object[0]);
          }
        }
        catch (Exception localException)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
        }
        if (!bool) {
          a.requestLayout();
        } else {
          a.forceLayout();
        }
        a.invalidate();
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
    throws IllegalArgumentException
  {
    if (paramFloat1 > 0.0F)
    {
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat3 > 0.0F)
        {
          c = 1;
          z = paramFloat1;
          y = paramFloat2;
          x = paramFloat3;
          e = false;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("The auto-size step granularity (");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Minimum auto-size text size (");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int j = paramTypedArray.length();
    int[] arrayOfInt = new int[j];
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        arrayOfInt[i] = paramTypedArray.getDimensionPixelSize(i, -1);
        i += 1;
      }
      d = sort(arrayOfInt);
      c();
    }
  }
  
  private boolean a(int paramInt, RectF paramRectF)
  {
    CharSequence localCharSequence = a.getText();
    Object localObject2 = localCharSequence;
    TransformationMethod localTransformationMethod = a.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localTransformationMethod != null)
    {
      localCharSequence = localTransformationMethod.getTransformation(localCharSequence, a);
      localObject1 = localObject2;
      if (localCharSequence != null) {
        localObject1 = localCharSequence;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16) {
      i = Type.create(a);
    } else {
      i = -1;
    }
    init(paramInt);
    localObject2 = add((CharSequence)localObject1, (Layout.Alignment)add(a, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(right), i);
    if (i != -1)
    {
      if (((StaticLayout)localObject2).getLineCount() > i) {
        break label173;
      }
      if (((Layout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) != ((CharSequence)localObject1).length()) {
        return false;
      }
    }
    return ((Layout)localObject2).getHeight() <= bottom;
    label173:
    return false;
  }
  
  static Object add(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      localObject = a(paramString);
      paramObject1 = ((Method)localObject).invoke(paramObject1, new Object[0]);
      return paramObject1;
    }
    catch (Throwable paramObject1) {}catch (Exception paramObject1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to invoke TextView#");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("() method");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject).toString(), paramObject1);
      return paramObject2;
    }
    throw paramObject1;
  }
  
  private boolean b()
  {
    boolean bool = f();
    int i = 0;
    if ((bool) && (c == 1))
    {
      if ((!e) || (d.length == 0))
      {
        int j = (int)Math.floor((y - z) / x) + 1;
        int[] arrayOfInt = new int[j];
        while (i < j)
        {
          arrayOfInt[i] = Math.round(z + i * x);
          i += 1;
        }
        d = sort(arrayOfInt);
      }
      r = true;
    }
    else
    {
      r = false;
    }
    return r;
  }
  
  private boolean c()
  {
    int[] arrayOfInt = d;
    int i = arrayOfInt.length;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    e = bool;
    if (bool)
    {
      c = 1;
      z = arrayOfInt[0];
      y = arrayOfInt[(i - 1)];
      x = -1.0F;
    }
    return bool;
  }
  
  private void d()
  {
    c = 0;
    z = -1.0F;
    y = -1.0F;
    x = -1.0F;
    d = new int[0];
    r = false;
  }
  
  private boolean f()
  {
    return a instanceof AppCompatEditText ^ true;
  }
  
  private static Field get(String paramString)
  {
    Object localObject1 = t;
    try
    {
      localObject1 = ((ConcurrentHashMap)localObject1).get(paramString);
      localObject2 = (Field)localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = TextView.class.getDeclaredField(paramString);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Field)localObject2).setAccessible(true);
          localObject1 = t;
          ((ConcurrentHashMap)localObject1).put(paramString, localObject2);
          return localObject2;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to access TextView#");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" member");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject2).toString(), localNoSuchFieldException);
      return null;
    }
    return localNoSuchFieldException;
  }
  
  private static Object put(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      localObject = get(paramString);
      if (localObject == null) {
        return paramObject2;
      }
      paramObject1 = ((Field)localObject).get(paramObject1);
      return paramObject1;
    }
    catch (IllegalAccessException paramObject1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to access TextView#");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" member");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject).toString(), paramObject1);
    }
    return paramObject2;
  }
  
  private int[] sort(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    if (k == 0) {
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      int i1 = paramArrayOfInt[i];
      if ((i1 > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(i1)) < 0)) {
        localArrayList.add(Integer.valueOf(i1));
      }
      i += 1;
    }
    if (k == localArrayList.size()) {
      return paramArrayOfInt;
    }
    k = localArrayList.size();
    paramArrayOfInt = new int[k];
    i = j;
    while (i < k)
    {
      paramArrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return paramArrayOfInt;
  }
  
  void a(int paramInt)
  {
    if (f()) {
      if (paramInt != 0)
      {
        Object localObject;
        if (paramInt == 1)
        {
          localObject = m.getResources().getDisplayMetrics();
          a(TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject), TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject), 1.0F);
          if (b()) {
            draw();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown auto-size text type: ");
          ((StringBuilder)localObject).append(paramInt);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        d();
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (f())
    {
      DisplayMetrics localDisplayMetrics = m.getResources().getDisplayMetrics();
      a(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (b()) {
        draw();
      }
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject = m;
    int[] arrayOfInt = R.styleable.a;
    localObject = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0);
    TextView localTextView = a;
    ViewCompat.obtainStyledAttributes(localTextView, localTextView.getContext(), arrayOfInt, paramAttributeSet, (TypedArray)localObject, paramInt, 0);
    paramInt = R.styleable.Theme_windowFixedHeightMinor;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      c = ((TypedArray)localObject).getInt(paramInt, 0);
    }
    paramInt = R.styleable.CircleProgress_circle_text_size;
    float f1;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f1 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f1 = -1.0F;
    }
    paramInt = R.styleable.ArcProgress_arc_stroke_width;
    float f2;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f2 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f2 = -1.0F;
    }
    paramInt = R.styleable.AppCompatTextView_textAllCaps;
    float f3;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f3 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f3 = -1.0F;
    }
    paramInt = R.styleable.NavigationView_menu;
    if (((TypedArray)localObject).hasValue(paramInt))
    {
      paramInt = ((TypedArray)localObject).getResourceId(paramInt, 0);
      if (paramInt > 0)
      {
        paramAttributeSet = ((TypedArray)localObject).getResources().obtainTypedArray(paramInt);
        a(paramAttributeSet);
        paramAttributeSet.recycle();
      }
    }
    ((TypedArray)localObject).recycle();
    if (f())
    {
      if (c == 1)
      {
        if (!e)
        {
          paramAttributeSet = m.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          a(f4, f2, f3);
        }
        b();
      }
    }
    else {
      c = 0;
    }
  }
  
  void a(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (f())
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      if (j > 0)
      {
        int[] arrayOfInt = new int[j];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, j);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = m.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (i >= j) {
              break;
            }
            arrayOfInt[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i], localDisplayMetrics));
            i += 1;
          }
        }
        d = sort((int[])localObject);
        if (!c())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("None of the preset sizes is valid: ");
          ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        e = false;
      }
      if (b()) {
        draw();
      }
    }
  }
  
  boolean a()
  {
    return (f()) && (c != 0);
  }
  
  int add()
  {
    return Math.round(y);
  }
  
  StaticLayout add(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return DescriptorMatcher.create(paramCharSequence, paramAlignment, paramInt1, paramInt2, a, b, n);
    }
    if (i >= 16) {
      return Type.a(paramCharSequence, paramAlignment, paramInt1, a, b);
    }
    return a(paramCharSequence, paramAlignment, paramInt1);
  }
  
  void b(int paramInt, float paramFloat)
  {
    Object localObject = m;
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    a(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
  
  int clear()
  {
    return Math.round(x);
  }
  
  void draw()
  {
    if (!a()) {
      return;
    }
    if (r)
    {
      if (a.getMeasuredHeight() <= 0) {
        return;
      }
      if (a.getMeasuredWidth() <= 0) {
        return;
      }
      int i;
      if (n.set(a)) {
        i = 1048576;
      } else {
        i = a.getMeasuredWidth() - a.getTotalPaddingLeft() - a.getTotalPaddingRight();
      }
      int j = a.getHeight() - a.getCompoundPaddingBottom() - a.getCompoundPaddingTop();
      if (i <= 0) {
        return;
      }
      if (j <= 0) {
        return;
      }
      RectF localRectF = g;
      try
      {
        localRectF.setEmpty();
        right = i;
        bottom = j;
        float f = a(localRectF);
        if (f != a.getTextSize()) {
          b(0, f);
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    r = true;
  }
  
  int[] e()
  {
    return d;
  }
  
  int get()
  {
    return c;
  }
  
  int getValue()
  {
    return Math.round(z);
  }
  
  void init(int paramInt)
  {
    TextPaint localTextPaint = b;
    if (localTextPaint == null) {
      b = new TextPaint();
    } else {
      localTextPaint.reset();
    }
    b.set(a.getPaint());
    b.setTextSize(paramInt);
  }
}

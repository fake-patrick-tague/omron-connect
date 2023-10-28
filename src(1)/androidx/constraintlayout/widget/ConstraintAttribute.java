package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute
{
  boolean a;
  private AttributeType b;
  private int c;
  private String f;
  private float k;
  String l;
  private int n;
  
  public ConstraintAttribute(ConstraintAttribute paramConstraintAttribute, Object paramObject)
  {
    l = l;
    b = b;
    a(paramObject);
  }
  
  public ConstraintAttribute(String paramString, AttributeType paramAttributeType, Object paramObject)
  {
    l = paramString;
    b = paramAttributeType;
    a(paramObject);
  }
  
  public static HashMap a(HashMap paramHashMap, View paramView)
  {
    HashMap localHashMap = new HashMap();
    Class localClass = paramView.getClass();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ConstraintAttribute localConstraintAttribute = (ConstraintAttribute)paramHashMap.get(str);
      try
      {
        boolean bool = str.equals("BackgroundColor");
        Object localObject;
        if (bool)
        {
          localObject = paramView.getBackground();
          localObject = (ColorDrawable)localObject;
          int i = ((ColorDrawable)localObject).getColor();
          localHashMap.put(str, new ConstraintAttribute(localConstraintAttribute, Integer.valueOf(i)));
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getMap");
          ((StringBuilder)localObject).append(str);
          localObject = ((StringBuilder)localObject).toString();
          localObject = localClass.getMethod((String)localObject, new Class[0]);
          localObject = ((Method)localObject).invoke(paramView, new Object[0]);
          localHashMap.put(str, new ConstraintAttribute(localConstraintAttribute, localObject));
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    return localHashMap;
  }
  
  public static void a(Context paramContext, XmlPullParser paramXmlPullParser, HashMap paramHashMap)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.Spinner);
    int j = localTypedArray.getIndexCount();
    Object localObject3 = null;
    XmlPullParser localXmlPullParser = null;
    Object localObject4 = null;
    int i = 0;
    while (i < j)
    {
      int m = localTypedArray.getIndex(i);
      Object localObject2;
      Object localObject1;
      if (m == R.styleable.Theme_android_windowIsFloating)
      {
        String str = localTypedArray.getString(m);
        localObject3 = str;
        localObject2 = localObject3;
        paramXmlPullParser = localXmlPullParser;
        localObject1 = localObject4;
        if (str != null)
        {
          localObject2 = localObject3;
          paramXmlPullParser = localXmlPullParser;
          localObject1 = localObject4;
          if (str.length() > 0)
          {
            paramXmlPullParser = new StringBuilder();
            paramXmlPullParser.append(Character.toUpperCase(str.charAt(0)));
            paramXmlPullParser.append(str.substring(1));
            localObject2 = paramXmlPullParser.toString();
            paramXmlPullParser = localXmlPullParser;
            localObject1 = localObject4;
          }
        }
      }
      else if (m == R.styleable.FLOAT)
      {
        paramXmlPullParser = Boolean.valueOf(localTypedArray.getBoolean(m, false));
        localObject1 = AttributeType.c;
        localObject2 = localObject3;
      }
      else
      {
        if (m == R.styleable.TYPE)
        {
          localObject1 = AttributeType.d;
          paramXmlPullParser = Integer.valueOf(localTypedArray.getColor(m, 0));
        }
        for (;;)
        {
          localObject2 = localObject3;
          break;
          if (m == R.styleable.DOUBLE)
          {
            localObject1 = AttributeType.a;
            paramXmlPullParser = Integer.valueOf(localTypedArray.getColor(m, 0));
          }
          else if (m == R.styleable.E)
          {
            localObject1 = AttributeType.b;
            paramXmlPullParser = Float.valueOf(TypedValue.applyDimension(1, localTypedArray.getDimension(m, 0.0F), paramContext.getResources().getDisplayMetrics()));
          }
          else if (m == R.styleable.u)
          {
            localObject1 = AttributeType.b;
            paramXmlPullParser = Float.valueOf(localTypedArray.getDimension(m, 0.0F));
          }
          else if (m == R.styleable.e)
          {
            localObject1 = AttributeType.g;
            paramXmlPullParser = Float.valueOf(localTypedArray.getFloat(m, NaN.0F));
          }
          else if (m == R.styleable.UNINITIALIZED_THIS)
          {
            localObject1 = AttributeType.i;
            paramXmlPullParser = Integer.valueOf(localTypedArray.getInteger(m, -1));
          }
          else
          {
            localObject2 = localObject3;
            paramXmlPullParser = localXmlPullParser;
            localObject1 = localObject4;
            if (m != R.styleable.w) {
              break;
            }
            localObject1 = AttributeType.e;
            paramXmlPullParser = localTypedArray.getString(m);
          }
        }
      }
      i += 1;
      localObject3 = localObject2;
      localXmlPullParser = paramXmlPullParser;
      localObject4 = localObject1;
    }
    if ((localObject3 != null) && (localXmlPullParser != null)) {
      paramHashMap.put(localObject3, new ConstraintAttribute(localObject3, localObject4, localXmlPullParser));
    }
    localTypedArray.recycle();
  }
  
  public static void a(View paramView, HashMap paramHashMap)
  {
    Class localClass = paramView.getClass();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject3 = (ConstraintAttribute)paramHashMap.get(localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject4 = a.d;
      Object localObject5 = b;
      try
      {
        int i = ((Enum)localObject5).ordinal();
        float f1;
        switch (localObject4[i])
        {
        default: 
          break;
        case 7: 
          localObject4 = Float.TYPE;
          localObject4 = localClass.getMethod((String)localObject2, new Class[] { localObject4 });
          f1 = k;
          ((Method)localObject4).invoke(paramView, new Object[] { Float.valueOf(f1) });
          break;
        case 6: 
          localObject4 = Boolean.TYPE;
          localObject4 = localClass.getMethod((String)localObject2, new Class[] { localObject4 });
          boolean bool = a;
          ((Method)localObject4).invoke(paramView, new Object[] { Boolean.valueOf(bool) });
          break;
        case 5: 
          localObject4 = localClass.getMethod((String)localObject2, new Class[] { CharSequence.class });
          localObject3 = f;
          ((Method)localObject4).invoke(paramView, new Object[] { localObject3 });
          break;
        case 4: 
          localObject4 = Float.TYPE;
          localObject4 = localClass.getMethod((String)localObject2, new Class[] { localObject4 });
          f1 = k;
          ((Method)localObject4).invoke(paramView, new Object[] { Float.valueOf(f1) });
          break;
        case 3: 
          localObject4 = Integer.TYPE;
          localObject4 = localClass.getMethod((String)localObject2, new Class[] { localObject4 });
          i = c;
          ((Method)localObject4).invoke(paramView, new Object[] { Integer.valueOf(i) });
          break;
        case 2: 
          localObject4 = localClass.getMethod((String)localObject2, new Class[] { Drawable.class });
          localObject5 = new ColorDrawable();
          i = n;
          ((ColorDrawable)localObject5).setColor(i);
          ((Method)localObject4).invoke(paramView, new Object[] { localObject5 });
          break;
        case 1: 
          localObject4 = Integer.TYPE;
          localObject4 = localClass.getMethod((String)localObject2, new Class[] { localObject4 });
          i = n;
          ((Method)localObject4).invoke(paramView, new Object[] { Integer.valueOf(i) });
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" Custom Attribute \"");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("\" not found on ");
        ((StringBuilder)localObject3).append(localClass.getName());
        Log.e("TransitionLayout", ((StringBuilder)localObject3).toString());
        localInvocationTargetException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" Custom Attribute \"");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("\" not found on ");
        ((StringBuilder)localObject3).append(localClass.getName());
        Log.e("TransitionLayout", ((StringBuilder)localObject3).toString());
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.e("TransitionLayout", localNoSuchMethodException.getMessage());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" Custom Attribute \"");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\" not found on ");
        localStringBuilder.append(localClass.getName());
        Log.e("TransitionLayout", localStringBuilder.toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localClass.getName());
        ((StringBuilder)localObject1).append(" must have a method ");
        ((StringBuilder)localObject1).append(localIllegalAccessException);
        Log.e("TransitionLayout", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(Object paramObject)
  {
    switch (a.d[b.ordinal()])
    {
    default: 
      return;
    case 7: 
      k = ((Float)paramObject).floatValue();
      return;
    case 6: 
      a = ((Boolean)paramObject).booleanValue();
      return;
    case 5: 
      f = ((String)paramObject);
      return;
    case 4: 
      k = ((Float)paramObject).floatValue();
      return;
    case 3: 
      c = ((Integer)paramObject).intValue();
      return;
    }
    n = ((Integer)paramObject).intValue();
  }
  
  public static enum AttributeType
  {
    static
    {
      AttributeType localAttributeType1 = new AttributeType("INT_TYPE", 0);
      i = localAttributeType1;
      AttributeType localAttributeType2 = new AttributeType("FLOAT_TYPE", 1);
      g = localAttributeType2;
      AttributeType localAttributeType3 = new AttributeType("COLOR_TYPE", 2);
      d = localAttributeType3;
      AttributeType localAttributeType4 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
      a = localAttributeType4;
      AttributeType localAttributeType5 = new AttributeType("STRING_TYPE", 4);
      e = localAttributeType5;
      AttributeType localAttributeType6 = new AttributeType("BOOLEAN_TYPE", 5);
      c = localAttributeType6;
      AttributeType localAttributeType7 = new AttributeType("DIMENSION_TYPE", 6);
      b = localAttributeType7;
      p = new AttributeType[] { localAttributeType1, localAttributeType2, localAttributeType3, localAttributeType4, localAttributeType5, localAttributeType6, localAttributeType7 };
    }
  }
}

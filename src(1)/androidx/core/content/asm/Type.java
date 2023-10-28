package androidx.core.content.asm;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v7.v7.R.styleable;
import v7.v7.Rings;
import v7.v7.widget.MathUtils;

public final class Type
{
  private static final ThreadLocal<TypedValue> slot = new ThreadLocal();
  
  private static int a(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i;
    if ((paramFloat2 >= 0.0F) && (paramFloat2 <= 100.0F)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramFloat1 == 1.0F) && (i == 0)) {
      return paramInt;
    }
    int k = MathUtils.constrain((int)(Color.alpha(paramInt) * paramFloat1 + 0.5F), 0, 255);
    int j = paramInt;
    if (i != 0)
    {
      m localM = m.a(paramInt);
      j = m.d(localM.h(), localM.a(), paramFloat2);
    }
    return j & 0xFFFFFF | k << 24;
  }
  
  public static ColorStateList create(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      paramResources = create(paramResources, paramResources.getXml(paramInt), paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.e("CSLCompat", "Failed to inflate ColorStateList.", paramResources);
    }
    return null;
  }
  
  public static ColorStateList create(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return create(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public static ColorStateList create(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    String str = paramXmlPullParser.getName();
    if (str.equals("selector")) {
      return init(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid color state list tag ");
    paramResources.append(str);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  private static boolean get(Resources paramResources, int paramInt)
  {
    TypedValue localTypedValue = getValue();
    paramResources.getValue(paramInt, localTypedValue, true);
    paramInt = type;
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  private static TypedValue getValue()
  {
    ThreadLocal localThreadLocal = slot;
    TypedValue localTypedValue2 = (TypedValue)localThreadLocal.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      localThreadLocal.set(localTypedValue1);
    }
    return localTypedValue1;
  }
  
  private static ColorStateList init(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i3 = paramXmlPullParser.getDepth() + 1;
    Object localObject1 = new int[20][];
    Object localObject2 = new int[20];
    int i;
    for (int j = 0;; j = i)
    {
      Resources localResources = paramResources;
      int k = paramXmlPullParser.next();
      if (k == 1) {
        break;
      }
      int m = paramXmlPullParser.getDepth();
      if ((m < i3) && (k == 3)) {
        break;
      }
      Object localObject4 = localObject1;
      Object localObject3 = localObject2;
      i = j;
      if (k == 2)
      {
        localObject4 = localObject1;
        localObject3 = localObject2;
        i = j;
        if (m <= i3) {
          if (!paramXmlPullParser.getName().equals("item"))
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            i = j;
          }
          else
          {
            localObject3 = obtainAttributes(localResources, paramTheme, paramAttributeSet, R.styleable.h);
            i = R.styleable.cw;
            k = ((TypedArray)localObject3).getResourceId(i, -1);
            if ((k == -1) || (get(localResources, k))) {}
          }
        }
      }
      try
      {
        i = create(localResources, localResources.getXml(k), paramTheme).getDefaultColor();
      }
      catch (Exception localException)
      {
        float f1;
        float f2;
        int i4;
        int n;
        for (;;) {}
      }
      i = ((TypedArray)localObject3).getColor(R.styleable.cw, -65281);
      break label220;
      i = ((TypedArray)localObject3).getColor(i, -65281);
      label220:
      f1 = 1.0F;
      k = R.styleable.value;
      if (((TypedArray)localObject3).hasValue(k))
      {
        f1 = ((TypedArray)localObject3).getFloat(k, 1.0F);
      }
      else
      {
        k = R.styleable.key;
        if (((TypedArray)localObject3).hasValue(k)) {
          f1 = ((TypedArray)localObject3).getFloat(k, 1.0F);
        }
      }
      if (Build.VERSION.SDK_INT >= 31)
      {
        k = R.styleable.MAX_CHANNELS;
        if (((TypedArray)localObject3).hasValue(k))
        {
          f2 = ((TypedArray)localObject3).getFloat(k, -1.0F);
          break label325;
        }
      }
      f2 = ((TypedArray)localObject3).getFloat(R.styleable.rdiam, -1.0F);
      label325:
      ((TypedArray)localObject3).recycle();
      i4 = paramAttributeSet.getAttributeCount();
      localObject3 = new int[i4];
      k = 0;
      for (m = 0; k < i4; m = n)
      {
        int i2 = paramAttributeSet.getAttributeNameResource(k);
        int i1 = i2;
        n = m;
        if (i2 != 16843173)
        {
          n = m;
          if (i2 != 16843551)
          {
            n = m;
            if (i2 != Rings.rdiam)
            {
              n = m;
              if (i2 != Rings.coordiantes)
              {
                if (!paramAttributeSet.getAttributeBooleanValue(k, false)) {
                  i1 = -i2;
                }
                localObject3[m] = i1;
                n = m + 1;
              }
            }
          }
        }
        k += 1;
      }
      localObject4 = StateSet.trimStateSet((int[])localObject3, m);
      localObject3 = ByteVector.get((int[])localObject2, j, a(i, f1, f2));
      localObject4 = (int[][])ByteVector.add((Object[])localObject1, j, localObject4);
      i = j + 1;
      localObject1 = localObject4;
      localObject2 = localObject3;
    }
    paramResources = new int[j];
    paramXmlPullParser = new int[j][];
    System.arraycopy(localObject2, 0, paramResources, 0, j);
    System.arraycopy(localObject1, 0, paramXmlPullParser, 0, j);
    return new ColorStateList(paramXmlPullParser, paramResources);
  }
  
  private static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
}

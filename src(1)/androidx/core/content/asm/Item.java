package androidx.core.content.asm;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v7.v7.R.styleable;

public class Item
{
  private static h a(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.styleable_VectorDrawablePath);
    int i = R.styleable.Theme_windowFixedWidthMinor;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.CircleProgress_circle_max;
    }
    int k = paramResources.getInt(i, 400);
    i = R.styleable.Theme_windowFixedHeightMinor;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.Theme_windowActionBar;
    }
    boolean bool;
    if (1 == paramResources.getInt(i, 0)) {
      bool = true;
    } else {
      bool = false;
    }
    i = R.styleable.Theme_windowFixedHeightMajor;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.Theme_windowNoTitle;
    }
    int j = R.styleable.AppCompatTheme_windowFixedHeightMinor;
    if (!paramResources.hasValue(j)) {
      j = R.styleable.Theme_windowActionBarOverlay;
    }
    String str1 = paramResources.getString(j);
    j = paramResources.getInt(i, 0);
    i = R.styleable.c;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.d;
    }
    int m = paramResources.getResourceId(i, 0);
    String str2 = paramResources.getString(i);
    paramResources.recycle();
    while (paramXmlPullParser.next() != 3) {
      a(paramXmlPullParser);
    }
    return new h(str2, k, bool, str1, j, m);
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = 1;
    while (i > 0)
    {
      int j = paramXmlPullParser.next();
      if (j != 2)
      {
        if (j == 3) {
          i -= 1;
        }
      }
      else {
        i += 1;
      }
    }
  }
  
  private static Object get(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return initialize(paramXmlPullParser, paramResources);
    }
    a(paramXmlPullParser);
    return null;
  }
  
  private static int getType(TypedArray paramTypedArray, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl.getType(paramTypedArray, paramInt);
    }
    TypedValue localTypedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, localTypedValue);
    return type;
  }
  
  public static Object inflate(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return get(paramXmlPullParser, paramResources);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  private static Object initialize(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    java.lang.Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.styleable_VectorDrawableGroup);
    String str1 = ((TypedArray)localObject).getString(R.styleable.text_size_multiplier_outer);
    String str2 = ((TypedArray)localObject).getString(R.styleable.numbers_radius_multiplier_inner);
    String str3 = ((TypedArray)localObject).getString(R.styleable.text_size_multiplier_inner);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.SlidingMenu_viewAbove, 0);
    int j = ((TypedArray)localObject).getInteger(R.styleable.SlidingMenu_viewBehind, 1);
    int k = ((TypedArray)localObject).getInteger(R.styleable.MaterialRippleLayout_mrl_rippleFadeDuration, 500);
    String str4 = ((TypedArray)localObject).getString(R.styleable.MaterialRippleLayout_mrl_rippleBackground);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        a(paramXmlPullParser);
      }
      return new NavigationMenuPresenter(new v7.v7.asm.h(str1, str2, str3, load(paramResources, i)), j, k, str4);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(a(paramXmlPullParser, paramResources));
        } else {
          a(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new i((h[])((List)localObject).toArray(new h[0]));
  }
  
  public static List load(Resources paramResources, int paramInt)
  {
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    try
    {
      int i = localTypedArray.length();
      if (i == 0)
      {
        paramResources = Collections.emptyList();
        localTypedArray.recycle();
        return paramResources;
      }
      ArrayList localArrayList = new ArrayList();
      i = getType(localTypedArray, 0);
      if (i == 1)
      {
        paramInt = 0;
        for (;;)
        {
          i = localTypedArray.length();
          if (paramInt >= i) {
            break;
          }
          i = localTypedArray.getResourceId(paramInt, 0);
          if (i != 0) {
            localArrayList.add(read(paramResources.getStringArray(i)));
          }
          paramInt += 1;
        }
      }
      localArrayList.add(read(paramResources.getStringArray(paramInt)));
      localTypedArray.recycle();
      return localArrayList;
    }
    catch (Throwable paramResources)
    {
      localTypedArray.recycle();
      throw paramResources;
    }
  }
  
  private static List read(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    return localArrayList;
  }
}

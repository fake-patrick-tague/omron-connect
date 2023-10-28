package androidx.core.content.asm;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v7.v7.R.styleable;

final class Status
{
  private static Shader.TileMode create(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return Shader.TileMode.CLAMP;
      }
      return Shader.TileMode.MIRROR;
    }
    return Shader.TileMode.REPEAT;
  }
  
  static Shader inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    Object localObject = paramXmlPullParser.getName();
    if (((String)localObject).equals("gradient"))
    {
      localObject = StringBuilder.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.styleable_VectorDrawableClipPath);
      float f1 = StringBuilder.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "startX", R.styleable.mViewportWidth, 0.0F);
      float f2 = StringBuilder.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "startY", R.styleable.mViewportHeight, 0.0F);
      float f3 = StringBuilder.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "endX", R.styleable.CalendarView_weekDayTextAppearance, 0.0F);
      float f4 = StringBuilder.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "endY", R.styleable.ArcProgress_arc_bottom_text, 0.0F);
      float f5 = StringBuilder.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "centerX", R.styleable.DUE, 0.0F);
      float f6 = StringBuilder.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "centerY", R.styleable.BottomSheet_bs_numColumns, 0.0F);
      int i = StringBuilder.getString((TypedArray)localObject, paramXmlPullParser, "type", R.styleable.numberpicker_defaultValue, 0);
      int j = StringBuilder.newInstance((TypedArray)localObject, paramXmlPullParser, "startColor", R.styleable.AppChooserPreference_allowUseDefault, 0);
      boolean bool = StringBuilder.get(paramXmlPullParser, "centerColor");
      int k = StringBuilder.newInstance((TypedArray)localObject, paramXmlPullParser, "centerColor", R.styleable.ProgressBar_android_minHeight, 0);
      int m = StringBuilder.newInstance((TypedArray)localObject, paramXmlPullParser, "endColor", R.styleable.SeekBarPreference_valueFormat, 0);
      int n = StringBuilder.getString((TypedArray)localObject, paramXmlPullParser, "tileMode", R.styleable.BottomSheet_bs_listItemTitleTextAppearance, 0);
      float f7 = StringBuilder.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "gradientRadius", R.styleable.BottomSheet_bs_titleTextAppearance, 0.0F);
      ((TypedArray)localObject).recycle();
      paramResources = write(parse(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme), j, m, bool, k);
      if (i != 1)
      {
        if (i != 2) {
          return new LinearGradient(f1, f2, f3, f4, array, pos, create(n));
        }
        return new SweepGradient(f5, f6, array, pos);
      }
      if (f7 > 0.0F) {
        return new RadialGradient(f5, f6, f7, array, pos, create(n));
      }
      throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }
    paramResources = new java.lang.StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid gradient color tag ");
    paramResources.append((String)localObject);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  private static Document parse(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth() + 1;
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList(20);
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break label241;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break label241;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        TypedArray localTypedArray = StringBuilder.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.styleable_AnimatedVectorDrawable);
        k = R.styleable.CardView_cardBackgroundColor;
        boolean bool1 = localTypedArray.hasValue(k);
        j = R.styleable.offset;
        boolean bool2 = localTypedArray.hasValue(j);
        if ((!bool1) || (!bool2)) {
          break;
        }
        k = localTypedArray.getColor(k, 0);
        float f = localTypedArray.getFloat(j, 0.0F);
        localTypedArray.recycle();
        localArrayList2.add(Integer.valueOf(k));
        localArrayList1.add(Float.valueOf(f));
      }
    }
    paramResources = new java.lang.StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    throw new XmlPullParserException(paramResources.toString());
    label241:
    if (localArrayList2.size() > 0) {
      return new Document(localArrayList2, localArrayList1);
    }
    return null;
  }
  
  private static Document write(Document paramDocument, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramDocument != null) {
      return paramDocument;
    }
    if (paramBoolean) {
      return new Document(paramInt1, paramInt3, paramInt2);
    }
    return new Document(paramInt1, paramInt2);
  }
}

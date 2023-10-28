package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;

class l
{
  float a = NaN.0F;
  float b = NaN.0F;
  float c = NaN.0F;
  f f;
  int i = -1;
  float m = NaN.0F;
  
  public l(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.CollapsingAppBarLayout_LayoutParams);
    int k = paramXmlPullParser.getIndexCount();
    int j = 0;
    while (j < k)
    {
      int n = paramXmlPullParser.getIndex(j);
      if (n == R.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseMode)
      {
        i = paramXmlPullParser.getResourceId(n, i);
        Object localObject = paramContext.getResources().getResourceTypeName(i);
        paramContext.getResources().getResourceName(i);
        if ("layout".equals(localObject))
        {
          localObject = new f();
          f = ((f)localObject);
          ((f)localObject).b(paramContext, i);
        }
      }
      else if (n == R.styleable.count)
      {
        b = paramXmlPullParser.getDimension(n, b);
      }
      else if (n == R.styleable.cp)
      {
        c = paramXmlPullParser.getDimension(n, c);
      }
      else if (n == R.styleable.coefficients)
      {
        a = paramXmlPullParser.getDimension(n, a);
      }
      else if (n == R.styleable.check)
      {
        m = paramXmlPullParser.getDimension(n, m);
      }
      else
      {
        Log.v("ConstraintLayoutStates", "Unknown tag");
      }
      j += 1;
    }
    paramXmlPullParser.recycle();
  }
}

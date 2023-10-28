package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class e
{
  ArrayList<a.b> a = new ArrayList();
  f b;
  int h = -1;
  int i;
  
  public e(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.ButtonBarLayout);
    int k = paramXmlPullParser.getIndexCount();
    int j = 0;
    while (j < k)
    {
      int m = paramXmlPullParser.getIndex(j);
      if (m == R.styleable.ButtonBarLayout_allowStacking)
      {
        i = paramXmlPullParser.getResourceId(m, i);
      }
      else if (m == R.styleable.k)
      {
        h = paramXmlPullParser.getResourceId(m, h);
        Object localObject = paramContext.getResources().getResourceTypeName(h);
        paramContext.getResources().getResourceName(h);
        if ("layout".equals(localObject))
        {
          localObject = new f();
          b = ((f)localObject);
          ((f)localObject).b(paramContext, h);
        }
      }
      j += 1;
    }
    paramXmlPullParser.recycle();
  }
  
  void a(l paramL)
  {
    a.add(paramL);
  }
}

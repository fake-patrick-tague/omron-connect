package androidx.core.content.asm;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class f
{
  private int a;
  private final Shader m;
  private final ColorStateList w;
  
  private f(Shader paramShader, ColorStateList paramColorStateList, int paramInt)
  {
    m = paramShader;
    w = paramColorStateList;
    a = paramInt;
  }
  
  static f a(int paramInt)
  {
    return new f(null, null, paramInt);
  }
  
  public static f a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      paramResources = create(paramResources, paramInt, paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", paramResources);
    }
    return null;
  }
  
  private static f create(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
    do
    {
      paramInt = localXmlResourceParser.next();
    } while ((paramInt != 2) && (paramInt != 1));
    if (paramInt == 2)
    {
      String str = localXmlResourceParser.getName();
      str.hashCode();
      if (!str.equals("gradient"))
      {
        if (str.equals("selector")) {
          return init(Type.create(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
        }
        paramResources = new StringBuilder();
        paramResources.append(localXmlResourceParser.getPositionDescription());
        paramResources.append(": unsupported complex color tag ");
        paramResources.append(str);
        throw new XmlPullParserException(paramResources.toString());
      }
      return e(Status.inflate(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  static f e(Shader paramShader)
  {
    return new f(paramShader, null, 0);
  }
  
  static f init(ColorStateList paramColorStateList)
  {
    return new f(null, paramColorStateList, paramColorStateList.getDefaultColor());
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    if (add())
    {
      ColorStateList localColorStateList = w;
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if (i != a)
      {
        a = i;
        return true;
      }
    }
    return false;
  }
  
  public boolean add()
  {
    if (m == null)
    {
      ColorStateList localColorStateList = w;
      if ((localColorStateList != null) && (localColorStateList.isStateful())) {
        return true;
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    a = paramInt;
  }
  
  public boolean c()
  {
    return (g()) || (a != 0);
  }
  
  public boolean g()
  {
    return m != null;
  }
  
  public int getColor()
  {
    return a;
  }
  
  public Shader size()
  {
    return m;
  }
}

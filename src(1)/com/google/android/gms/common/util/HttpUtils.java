package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.Buffer;
import com.google.android.gms.internal.common.Element;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@KeepForSdk
public class HttpUtils
{
  private static final Pattern P = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final Pattern PAT_DT_ETC = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
  private static final Pattern PAT_EE_IE = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  
  private HttpUtils() {}
  
  private static String decode(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "ISO-8859-1";
    }
    try
    {
      paramString1 = URLDecoder.decode(paramString1, str);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new IllegalArgumentException(paramString1);
    }
  }
  
  public static Map parse(URI paramURI, String paramString)
  {
    Object localObject = Collections.emptyMap();
    paramURI = paramURI.getRawQuery();
    Element localElement;
    Iterator localIterator;
    if ((paramURI != null) && (paramURI.length() > 0))
    {
      localObject = new HashMap();
      localElement = Element.process(Buffer.read('='));
      localIterator = Element.process(Buffer.read('&')).createElement().parse(paramURI).iterator();
    }
    while (localIterator.hasNext())
    {
      paramURI = localElement.get((String)localIterator.next());
      if ((!paramURI.isEmpty()) && (paramURI.size() <= 2))
      {
        String str = decode((String)paramURI.get(0), paramString);
        if (paramURI.size() == 2) {
          paramURI = decode((String)paramURI.get(1), paramString);
        } else {
          paramURI = null;
        }
        ((Map)localObject).put(str, paramURI);
      }
      else
      {
        throw new IllegalArgumentException("bad parameter");
        return localObject;
      }
    }
    return localObject;
  }
}

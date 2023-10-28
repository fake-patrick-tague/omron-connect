package com.google.android.datatransport.api;

import com.google.android.datatransport.Type;
import com.google.android.datatransport.asm.Label;
import com.google.android.datatransport.b;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class i
  implements Label
{
  public static final i a;
  public static final i b;
  private static final String c;
  static final String d;
  static final String e;
  private static final Set<b> s;
  private final String g;
  private final String i;
  
  static
  {
    String str1 = Token.readString("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
    e = str1;
    String str2 = Token.readString("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
    d = str2;
    String str3 = Token.readString("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
    c = str3;
    s = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Type[] { Type.valueOf("proto"), Type.valueOf("json") })));
    a = new i(str1, null);
    b = new i(str2, str3);
  }
  
  public i(String paramString1, String paramString2)
  {
    g = paramString1;
    i = paramString2;
  }
  
  public static i a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-8"));
    if (paramArrayOfByte.startsWith("1$"))
    {
      paramArrayOfByte = paramArrayOfByte.substring(2).split(Pattern.quote("\\"), 2);
      if (paramArrayOfByte.length == 2)
      {
        byte b2 = paramArrayOfByte[0];
        if (!b2.isEmpty())
        {
          byte b1 = paramArrayOfByte[1];
          paramArrayOfByte = b1;
          if (b1.isEmpty()) {
            paramArrayOfByte = null;
          }
          return new i(b2, paramArrayOfByte);
        }
        throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
      }
      throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
    }
    throw new IllegalArgumentException("Version marker missing from extras");
  }
  
  public byte[] a()
  {
    String str2 = i;
    if ((str2 == null) && (g == null)) {
      return null;
    }
    String str3 = g;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return String.format("%s%s%s%s", new Object[] { "1$", str3, "\\", str1 }).getBytes(Charset.forName("UTF-8"));
  }
  
  public String b()
  {
    return g;
  }
  
  public String c()
  {
    return i;
  }
  
  public Set d()
  {
    return s;
  }
  
  public byte[] getExtras()
  {
    return a();
  }
  
  public String getName()
  {
    return "cct";
  }
}

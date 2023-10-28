package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

@KeepForSdk
@ShowFirstParty
public class FastParser<T extends FastJsonResponse>
{
  private static final char[] ALPHABET;
  private static final char[] alphabet;
  private static final char[] c;
  private static final zai<Float> context;
  private static final zai<Long> handler;
  private static final zai<Double> message;
  private static final zai<BigInteger> offset = new DefaultTypeAdapters.NumberTypeAdapter();
  private static final zai<Integer> params;
  private static final char[] pos = { 117, 108, 108 };
  private static final zai<String> reader;
  private static final zai<Boolean> size;
  private static final zai<BigDecimal> stream = new DefaultTypeAdapters.LongDeserializer();
  private static final char[] table;
  private static final char[] type;
  private final StringBuilder cursor = new StringBuilder(32);
  private final char[] length = new char['?'];
  private final char[] next = new char[1];
  private final StringBuilder text = new StringBuilder(1024);
  private final Stack<Integer> this$0 = new Stack();
  private final char[] value = new char[32];
  
  static
  {
    ALPHABET = new char[] { 114, 117, 101 };
    alphabet = new char[] { 114, 117, 101, 34 };
    c = new char[] { 97, 108, 115, 101 };
    table = new char[] { 97, 108, 115, 101, 34 };
    type = new char[] { '\n' };
    params = new DefaultTypeAdapters.DefaultJavaSqlDateTypeAdapter();
    handler = new DefaultTypeAdapters.LocaleTypeAdapter();
    context = new DefaultTypeAdapters.DefaultInetAddressAdapter();
    message = new DefaultTypeAdapters.StringTypeAdapter();
    size = new DefaultTypeAdapters.BigIntegerTypeAdapter();
    reader = new DefaultTypeAdapters.UrlTypeAdapter();
  }
  
  public FastParser() {}
  
  private final void append(int paramInt)
    throws FastParser.ParseException
  {
    if (!this$0.isEmpty())
    {
      int i = ((Integer)this$0.pop()).intValue();
      if (i == paramInt) {
        return;
      }
      localStringBuilder = new StringBuilder(46);
      localStringBuilder.append("Expected state ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" but had ");
      localStringBuilder.append(i);
      throw new ParseException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(46);
    localStringBuilder.append("Expected state ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" but had empty stack");
    throw new ParseException(localStringBuilder.toString());
  }
  
  private final boolean encode(BufferedReader paramBufferedReader, boolean paramBoolean)
    throws FastParser.ParseException, IOException
  {
    char c1 = next(paramBufferedReader);
    if (c1 != '"')
    {
      char[] arrayOfChar;
      if (c1 != 'f')
      {
        if (c1 != 'n')
        {
          if (c1 == 't')
          {
            if (paramBoolean) {
              arrayOfChar = alphabet;
            } else {
              arrayOfChar = ALPHABET;
            }
            read(paramBufferedReader, arrayOfChar);
            return true;
          }
          paramBufferedReader = new StringBuilder(19);
          paramBufferedReader.append("Unexpected token: ");
          paramBufferedReader.append(c1);
          throw new ParseException(paramBufferedReader.toString());
        }
        read(paramBufferedReader, pos);
        return false;
      }
      if (paramBoolean) {
        arrayOfChar = table;
      } else {
        arrayOfChar = c;
      }
      read(paramBufferedReader, arrayOfChar);
      return false;
    }
    if (!paramBoolean) {
      return encode(paramBufferedReader, true);
    }
    throw new ParseException("No boolean value found in string");
  }
  
  private final String get(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    return get(paramBufferedReader, value, cursor, null);
  }
  
  private final String get(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    int i = next(paramBufferedReader);
    if (i != 34)
    {
      if (i == 110)
      {
        read(paramBufferedReader, pos);
        return null;
      }
      throw new ParseException("Expected string");
    }
    return parse(paramBufferedReader, paramArrayOfChar1, paramStringBuilder, paramArrayOfChar2);
  }
  
  private final float getFloat(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = parse(paramBufferedReader, length);
    if (i == 0) {
      return 0.0F;
    }
    return Float.parseFloat(new String(length, 0, i));
  }
  
  private final BigDecimal getValue(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = parse(paramBufferedReader, length);
    if (i == 0) {
      return null;
    }
    return new BigDecimal(new String(length, 0, i));
  }
  
  private final char next(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    if (paramBufferedReader.read(next) != -1)
    {
      while (Character.isWhitespace(next[0])) {
        if (paramBufferedReader.read(next) == -1) {
          return '\000';
        }
      }
      return next[0];
    }
    return '\000';
  }
  
  private final int parse(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    char c1 = next(paramBufferedReader);
    if (c1 != 0)
    {
      if (c1 != ',')
      {
        if (c1 == 'n')
        {
          read(paramBufferedReader, pos);
          return 0;
        }
        paramBufferedReader.mark(1024);
        int k;
        if (c1 == '"')
        {
          i = 0;
          int j = 0;
          for (;;)
          {
            k = i;
            if (i >= 1024) {
              break label261;
            }
            k = i;
            if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
              break label261;
            }
            c1 = paramArrayOfChar[i];
            if (Character.isISOControl(c1)) {
              break;
            }
            if (c1 == '"')
            {
              if (j == 0)
              {
                paramBufferedReader.reset();
                paramBufferedReader.skip(i + 1);
                return i;
              }
            }
            else if (c1 == '\\')
            {
              j ^= 0x1;
              break label140;
            }
            j = 0;
            label140:
            i += 1;
          }
          throw new ParseException("Unexpected control character while reading string");
        }
        paramArrayOfChar[0] = c1;
        int i = 1;
        for (;;)
        {
          k = i;
          if (i >= 1024) {
            break label261;
          }
          k = i;
          if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
            break label261;
          }
          c1 = paramArrayOfChar[i];
          if ((c1 == '}') || (c1 == ',') || (Character.isWhitespace(c1)) || (paramArrayOfChar[i] == ']')) {
            break;
          }
          i += 1;
        }
        paramBufferedReader.reset();
        paramBufferedReader.skip(i - 1);
        paramArrayOfChar[i] = '\000';
        return i;
        label261:
        if (k == 1024) {
          throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
      }
      throw new ParseException("Missing value");
    }
    throw new ParseException("Unexpected EOF");
  }
  
  private final String parse(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    paramBufferedReader.mark(1024);
    int k = next(paramBufferedReader);
    int j = 1;
    int i;
    int m;
    char c1;
    if (k != 34)
    {
      if (k != 44)
      {
        if (k != 91)
        {
          if (k != 123)
          {
            paramBufferedReader.reset();
            parse(paramBufferedReader, length);
          }
          else
          {
            this$0.push(Integer.valueOf(1));
            paramBufferedReader.mark(32);
            i = next(paramBufferedReader);
            if (i == 125)
            {
              append(1);
            }
            else if (i == 34)
            {
              paramBufferedReader.reset();
              toString(paramBufferedReader);
              while (parse(paramBufferedReader) != null) {}
              append(1);
            }
            else
            {
              paramBufferedReader = new StringBuilder(18);
              paramBufferedReader.append("Unexpected token ");
              paramBufferedReader.append(i);
              throw new ParseException(paramBufferedReader.toString());
            }
          }
        }
        else
        {
          this$0.push(Integer.valueOf(5));
          paramBufferedReader.mark(32);
          if (next(paramBufferedReader) == ']')
          {
            append(5);
          }
          else
          {
            paramBufferedReader.reset();
            m = 0;
            k = 0;
            while (j > 0)
            {
              i = next(paramBufferedReader);
              c1 = i;
              if (i != 0)
              {
                if (!Character.isISOControl(i))
                {
                  int n = m;
                  if (i == 34)
                  {
                    n = m;
                    if (k == 0) {
                      n = m ^ 0x1;
                    }
                    c1 = '"';
                  }
                  m = j;
                  char c2 = c1;
                  if (c1 == '[')
                  {
                    m = j;
                    if (n == 0) {
                      m = j + 1;
                    }
                    c2 = '[';
                  }
                  j = m;
                  if (c2 == ']')
                  {
                    j = m;
                    if (n == 0) {
                      j = m - 1;
                    }
                  }
                  if ((c2 == '\\') && (n != 0))
                  {
                    k ^= 0x1;
                    m = n;
                  }
                  else
                  {
                    k = 0;
                    m = n;
                  }
                }
                else
                {
                  throw new ParseException("Unexpected control character while reading array");
                }
              }
              else {
                throw new ParseException("Unexpected EOF while parsing array");
              }
            }
            append(5);
          }
        }
      }
      else {
        throw new ParseException("Missing value");
      }
    }
    else
    {
      if (paramBufferedReader.read(next) == -1) {
        break label588;
      }
      k = next[0];
      j = 0;
    }
    for (;;)
    {
      m = k;
      c1 = j;
      if (k == 34) {
        if (j != 0)
        {
          m = 34;
          c1 = '\001';
        }
        else
        {
          i = next(paramBufferedReader);
          if (i != 44)
          {
            if (i == 125)
            {
              append(2);
              return null;
            }
            paramBufferedReader = new StringBuilder(18);
            paramBufferedReader.append("Unexpected token ");
            paramBufferedReader.append(i);
            throw new ParseException(paramBufferedReader.toString());
          }
          append(2);
          return toString(paramBufferedReader);
        }
      }
      if (m == 92) {
        j = c1 ^ 0x1;
      } else {
        j = 0;
      }
      if (paramBufferedReader.read(next) == -1) {
        break label577;
      }
      i = next[0];
      if (Character.isISOControl(i)) {
        break;
      }
      k = i;
    }
    throw new ParseException("Unexpected control character while reading string");
    label577:
    throw new ParseException("Unexpected EOF while parsing string");
    label588:
    throw new ParseException("Unexpected EOF while parsing string");
  }
  
  private static final String parse(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfChar1.length);
    int k = 0;
    int i = 0;
    for (;;)
    {
      int n = paramBufferedReader.read(paramArrayOfChar1);
      if (n == -1) {
        break;
      }
      int j = 0;
      while (j < n)
      {
        char c1 = paramArrayOfChar1[j];
        if (Character.isISOControl(c1))
        {
          if (paramArrayOfChar2 != null)
          {
            int m = 0;
            while (m <= 0)
            {
              if (paramArrayOfChar2[m] == c1) {
                break label97;
              }
              m += 1;
            }
          }
          throw new ParseException("Unexpected control character while reading string");
        }
        label97:
        if (c1 == '"')
        {
          if (i == 0)
          {
            paramStringBuilder.append(paramArrayOfChar1, 0, j);
            paramBufferedReader.reset();
            paramBufferedReader.skip(j + 1);
            if (k != 0) {
              return JsonUtils.unescapeString(paramStringBuilder.toString());
            }
            return paramStringBuilder.toString();
          }
        }
        else if (c1 == '\\')
        {
          i ^= 0x1;
          k = 1;
          break label172;
        }
        i = 0;
        label172:
        j += 1;
      }
      paramStringBuilder.append(paramArrayOfChar1, 0, n);
      paramBufferedReader.mark(paramArrayOfChar1.length);
    }
    throw new ParseException("Unexpected EOF while parsing string");
  }
  
  private final ArrayList parse(BufferedReader paramBufferedReader, FastJsonResponse.Field paramField)
    throws FastParser.ParseException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    char c1 = next(paramBufferedReader);
    if (c1 != ']')
    {
      if (c1 != 'n')
      {
        if (c1 == '{')
        {
          this$0.push(Integer.valueOf(1));
          try
          {
            for (;;)
            {
              FastJsonResponse localFastJsonResponse = paramField.append();
              boolean bool = parse(paramBufferedReader, localFastJsonResponse);
              if (!bool) {
                break label251;
              }
              localArrayList.add(localFastJsonResponse);
              c1 = next(paramBufferedReader);
              if (c1 != ',')
              {
                if (c1 == ']')
                {
                  append(5);
                  return localArrayList;
                }
                paramBufferedReader = new StringBuilder(19);
                paramBufferedReader.append("Unexpected token: ");
                paramBufferedReader.append(c1);
                throw new ParseException(paramBufferedReader.toString());
              }
              if (next(paramBufferedReader) != '{') {
                break;
              }
              this$0.push(Integer.valueOf(1));
            }
            throw new ParseException("Expected start of next object in array");
          }
          catch (IllegalAccessException paramBufferedReader)
          {
            throw new ParseException("Error instantiating inner object", paramBufferedReader);
          }
          catch (InstantiationException paramBufferedReader)
          {
            throw new ParseException("Error instantiating inner object", paramBufferedReader);
          }
        }
        paramBufferedReader = new StringBuilder(19);
        paramBufferedReader.append("Unexpected token: ");
        paramBufferedReader.append(c1);
        throw new ParseException(paramBufferedReader.toString());
      }
      read(paramBufferedReader, pos);
      append(5);
      return null;
    }
    append(5);
    label251:
    return localArrayList;
  }
  
  private final boolean parse(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse)
    throws FastParser.ParseException, IOException
  {
    Map localMap = paramFastJsonResponse.getFieldMappings();
    java.lang.Object localObject2 = toString(paramBufferedReader);
    java.lang.Object localObject1 = localObject2;
    Integer localInteger = Integer.valueOf(1);
    if (localObject2 != null)
    {
      while (localObject1 != null)
      {
        localObject2 = (FastJsonResponse.Field)localMap.get(localObject1);
        if (localObject2 == null)
        {
          localObject1 = parse(paramBufferedReader);
        }
        else
        {
          this$0.push(Integer.valueOf(4));
          int i = size;
          label361:
          String str;
          switch (i)
          {
          default: 
            paramBufferedReader = new StringBuilder(30);
            paramBufferedReader.append("Invalid field type ");
            paramBufferedReader.append(i);
            throw new ParseException(paramBufferedReader.toString());
          case 11: 
            if (this$0)
            {
              i = next(paramBufferedReader);
              if (i == 110)
              {
                read(paramBufferedReader, pos);
                paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject2, data, null);
              }
              else
              {
                this$0.push(Integer.valueOf(5));
                if (i == 91) {
                  paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject2, data, parse(paramBufferedReader, (FastJsonResponse.Field)localObject2));
                } else {
                  throw new ParseException("Expected array start");
                }
              }
            }
            else
            {
              i = next(paramBufferedReader);
              if (i != 110) {
                break label361;
              }
              read(paramBufferedReader, pos);
              paramFastJsonResponse.addConcreteTypeInternal((FastJsonResponse.Field)localObject2, data, null);
            }
            for (;;)
            {
              break label1149;
              this$0.push(localInteger);
              if (i == 123) {
                try
                {
                  localObject1 = ((FastJsonResponse.Field)localObject2).append();
                  parse(paramBufferedReader, (FastJsonResponse)localObject1);
                  str = data;
                  paramFastJsonResponse.addConcreteTypeInternal((FastJsonResponse.Field)localObject2, str, (FastJsonResponse)localObject1);
                }
                catch (IllegalAccessException paramBufferedReader)
                {
                  throw new ParseException("Error instantiating inner object", paramBufferedReader);
                }
                catch (InstantiationException paramBufferedReader)
                {
                  throw new ParseException("Error instantiating inner object", paramBufferedReader);
                }
              }
            }
            throw new ParseException("Expected start of object");
          case 10: 
            i = next(paramBufferedReader);
            if (i == 110)
            {
              read(paramBufferedReader, pos);
              localObject1 = null;
            }
            else
            {
              if (i != 123) {
                break label769;
              }
              this$0.push(localInteger);
              localObject1 = new HashMap();
            }
            for (;;)
            {
              i = next(paramBufferedReader);
              if (i == 0) {
                break;
              }
              if (i != 34)
              {
                if (i != 125) {
                  continue;
                }
                append(1);
              }
              else
              {
                str = parse(paramBufferedReader, value, cursor, null);
                if (next(paramBufferedReader) != ':')
                {
                  paramBufferedReader = String.valueOf(str);
                  if (paramBufferedReader.length() != 0) {
                    paramBufferedReader = "No map value found for key ".concat(paramBufferedReader);
                  } else {
                    paramBufferedReader = new String("No map value found for key ");
                  }
                  throw new ParseException(paramBufferedReader);
                }
                if (next(paramBufferedReader) != '"')
                {
                  paramBufferedReader = String.valueOf(str);
                  if (paramBufferedReader.length() != 0) {
                    paramBufferedReader = "Expected String value for key ".concat(paramBufferedReader);
                  } else {
                    paramBufferedReader = new String("Expected String value for key ");
                  }
                  throw new ParseException(paramBufferedReader);
                }
                ((HashMap)localObject1).put(str, parse(paramBufferedReader, value, cursor, null));
                c1 = next(paramBufferedReader);
                if (c1 == ',') {
                  break label755;
                }
                if (c1 != '}') {
                  break label719;
                }
                append(1);
              }
              paramFastJsonResponse.update((FastJsonResponse.Field)localObject2, (Map)localObject1);
              break label833;
              paramBufferedReader = new StringBuilder(48);
              paramBufferedReader.append("Unexpected character while parsing string map: ");
              paramBufferedReader.append(c1);
              throw new ParseException(paramBufferedReader.toString());
            }
            throw new ParseException("Unexpected EOF");
            throw new ParseException("Expected start of a map object");
          case 9: 
            paramFastJsonResponse.append((FastJsonResponse.Field)localObject2, Base64Utils.decodeUrlSafe(get(paramBufferedReader, length, text, type)));
            break;
          case 8: 
            label719:
            label755:
            label769:
            paramFastJsonResponse.append((FastJsonResponse.Field)localObject2, Base64Utils.decode(get(paramBufferedReader, length, text, type)));
          }
          for (;;)
          {
            label833:
            break;
            if (this$0)
            {
              paramFastJsonResponse.processBytes((FastJsonResponse.Field)localObject2, read(paramBufferedReader, reader));
            }
            else
            {
              paramFastJsonResponse.operate((FastJsonResponse.Field)localObject2, get(paramBufferedReader));
              continue;
              if (this$0)
              {
                paramFastJsonResponse.update((FastJsonResponse.Field)localObject2, read(paramBufferedReader, size));
              }
              else
              {
                paramFastJsonResponse.warn((FastJsonResponse.Field)localObject2, encode(paramBufferedReader, false));
                continue;
                if (this$0)
                {
                  paramFastJsonResponse.endElement((FastJsonResponse.Field)localObject2, read(paramBufferedReader, stream));
                }
                else
                {
                  paramFastJsonResponse.put((FastJsonResponse.Field)localObject2, getValue(paramBufferedReader));
                  continue;
                  if (this$0)
                  {
                    paramFastJsonResponse.copyTo((FastJsonResponse.Field)localObject2, read(paramBufferedReader, message));
                  }
                  else
                  {
                    paramFastJsonResponse.put((FastJsonResponse.Field)localObject2, parseNumber(paramBufferedReader));
                    continue;
                    if (this$0)
                    {
                      paramFastJsonResponse.operate((FastJsonResponse.Field)localObject2, read(paramBufferedReader, context));
                    }
                    else
                    {
                      paramFastJsonResponse.append((FastJsonResponse.Field)localObject2, getFloat(paramBufferedReader));
                      continue;
                      if (this$0)
                      {
                        paramFastJsonResponse.reference((FastJsonResponse.Field)localObject2, read(paramBufferedReader, handler));
                      }
                      else
                      {
                        paramFastJsonResponse.skip((FastJsonResponse.Field)localObject2, parseLong(paramBufferedReader));
                        continue;
                        if (this$0)
                        {
                          paramFastJsonResponse.performDownload((FastJsonResponse.Field)localObject2, read(paramBufferedReader, offset));
                        }
                        else
                        {
                          paramFastJsonResponse.append((FastJsonResponse.Field)localObject2, read(paramBufferedReader));
                          continue;
                          if (this$0) {
                            paramFastJsonResponse.handleData((FastJsonResponse.Field)localObject2, read(paramBufferedReader, params));
                          } else {
                            paramFastJsonResponse.append((FastJsonResponse.Field)localObject2, parseInt(paramBufferedReader));
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          label1149:
          append(4);
          append(2);
          char c1 = next(paramBufferedReader);
          if (c1 != ',')
          {
            if (c1 == '}')
            {
              localObject1 = null;
            }
            else
            {
              paramBufferedReader = new StringBuilder(55);
              paramBufferedReader.append("Expected end of object or field separator, but found: ");
              paramBufferedReader.append(c1);
              throw new ParseException(paramBufferedReader.toString());
            }
          }
          else {
            localObject1 = toString(paramBufferedReader);
          }
        }
      }
      append(1);
      return true;
    }
    append(1);
    return false;
  }
  
  private final int parseInt(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int n = parse(paramBufferedReader, length);
    if (n == 0) {
      return 0;
    }
    paramBufferedReader = length;
    if (n > 0)
    {
      int i = paramBufferedReader[0];
      int m;
      if (i == 45) {
        m = Integer.MIN_VALUE;
      } else {
        m = -2147483647;
      }
      if (i == 45) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      int k;
      if (i < n)
      {
        j = i + 1;
        k = Character.digit(paramBufferedReader[i], 10);
        if (k >= 0) {
          k = -k;
        } else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      else
      {
        k = 0;
        j = i;
      }
      while (j < n)
      {
        int i1 = Character.digit(paramBufferedReader[j], 10);
        if (i1 >= 0)
        {
          if (k >= -214748364)
          {
            k *= 10;
            if (k >= m + i1)
            {
              k -= i1;
              j += 1;
            }
            else
            {
              throw new ParseException("Number too large");
            }
          }
          else
          {
            throw new ParseException("Number too large");
          }
        }
        else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      if (i != 0)
      {
        if (j > 1) {
          return k;
        }
        throw new ParseException("No digits to parse");
      }
      return -k;
    }
    throw new ParseException("No number to parse");
  }
  
  private final long parseLong(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int k = parse(paramBufferedReader, length);
    if (k == 0) {
      return 0L;
    }
    paramBufferedReader = length;
    if (k > 0)
    {
      int i = 0;
      int j = paramBufferedReader[0];
      long l2;
      if (j == 45) {
        l2 = Long.MIN_VALUE;
      } else {
        l2 = -9223372036854775807L;
      }
      if (j == 45) {
        i = 1;
      }
      int m;
      long l1;
      if (i < k)
      {
        j = i + 1;
        m = Character.digit(paramBufferedReader[i], 10);
        if (m >= 0) {
          l1 = -m;
        } else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      else
      {
        l1 = 0L;
        j = i;
      }
      while (j < k)
      {
        m = Character.digit(paramBufferedReader[j], 10);
        if (m >= 0)
        {
          if (l1 >= -922337203685477580L)
          {
            l1 *= 10L;
            long l3 = m;
            if (l1 >= l2 + l3)
            {
              l1 -= l3;
              j += 1;
            }
            else
            {
              throw new ParseException("Number too large");
            }
          }
          else
          {
            throw new ParseException("Number too large");
          }
        }
        else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      if (i != 0)
      {
        if (j > 1) {
          return l1;
        }
        throw new ParseException("No digits to parse");
      }
      return -l1;
    }
    throw new ParseException("No number to parse");
  }
  
  private final double parseNumber(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = parse(paramBufferedReader, length);
    if (i == 0) {
      return 0.0D;
    }
    return Double.parseDouble(new String(length, 0, i));
  }
  
  private final BigInteger read(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = parse(paramBufferedReader, length);
    if (i == 0) {
      return null;
    }
    return new BigInteger(new String(length, 0, i));
  }
  
  private final ArrayList read(BufferedReader paramBufferedReader, Object paramObject)
    throws FastParser.ParseException, IOException
  {
    int i = next(paramBufferedReader);
    if (i == 110)
    {
      read(paramBufferedReader, pos);
      return null;
    }
    if (i == 91)
    {
      this$0.push(Integer.valueOf(5));
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        paramBufferedReader.mark(1024);
        i = next(paramBufferedReader);
        if (i == 0) {
          break label107;
        }
        if (i != 44)
        {
          if (i == 93) {
            break;
          }
          paramBufferedReader.reset();
          localArrayList.add(paramObject.deserialize(this, paramBufferedReader));
        }
      }
      append(5);
      return localArrayList;
      label107:
      throw new ParseException("Unexpected EOF");
    }
    throw new ParseException("Expected start of array");
  }
  
  private final void read(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    int i = 0;
    for (;;)
    {
      int j = paramArrayOfChar.length;
      if (i >= j) {
        return;
      }
      int k = paramBufferedReader.read(value, 0, j - i);
      if (k == -1) {
        break;
      }
      j = 0;
      while (j < k) {
        if (paramArrayOfChar[(j + i)] == value[j]) {
          j += 1;
        } else {
          throw new ParseException("Unexpected character");
        }
      }
      i += k;
    }
    throw new ParseException("Unexpected EOF");
  }
  
  private final String toString(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    this$0.push(Integer.valueOf(2));
    char c1 = next(paramBufferedReader);
    if (c1 != '"')
    {
      if (c1 != ']')
      {
        if (c1 == '}')
        {
          append(2);
          return null;
        }
        paramBufferedReader = new StringBuilder(19);
        paramBufferedReader.append("Unexpected token: ");
        paramBufferedReader.append(c1);
        throw new ParseException(paramBufferedReader.toString());
      }
      append(2);
      append(1);
      append(5);
      return null;
    }
    this$0.push(Integer.valueOf(3));
    String str = parse(paramBufferedReader, value, cursor, null);
    append(3);
    if (next(paramBufferedReader) == ':') {
      return str;
    }
    throw new ParseException("Expected key/value separator");
  }
  
  public void parse(InputStream paramInputStream, FastJsonResponse paramFastJsonResponse)
    throws FastParser.ParseException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
    java.lang.Object localObject = this$0;
    try
    {
      ((Stack)localObject).push(Integer.valueOf(0));
      char c1 = next(paramInputStream);
      if (c1 != 0)
      {
        if (c1 != '[')
        {
          if (c1 == '{')
          {
            localObject = this$0;
            ((Stack)localObject).push(Integer.valueOf(1));
            parse(paramInputStream, paramFastJsonResponse);
          }
          else
          {
            paramFastJsonResponse = new StringBuilder(19);
            paramFastJsonResponse.append("Unexpected token: ");
            paramFastJsonResponse.append(c1);
            paramFastJsonResponse = new ParseException(paramFastJsonResponse.toString());
            throw paramFastJsonResponse;
          }
        }
        else
        {
          localObject = this$0;
          ((Stack)localObject).push(Integer.valueOf(5));
          localObject = paramFastJsonResponse.getFieldMappings();
          int i = ((Map)localObject).size();
          if (i != 1) {
            break label246;
          }
          localObject = ((Map)localObject).entrySet().iterator().next();
          localObject = (Map.Entry)localObject;
          localObject = ((Map.Entry)localObject).getValue();
          localObject = (FastJsonResponse.Field)localObject;
          ArrayList localArrayList = parse(paramInputStream, (FastJsonResponse.Field)localObject);
          String str = data;
          paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject, str, localArrayList);
        }
        append(0);
      }
    }
    catch (Throwable paramFastJsonResponse) {}catch (IOException paramFastJsonResponse)
    {
      label235:
      throw new ParseException(paramFastJsonResponse);
    }
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      break label235;
    }
    Log.w("FastParser", "Failed to close reader while parsing.");
    return;
    label246:
    paramFastJsonResponse = new ParseException("Object array response class must have a single Field");
    throw paramFastJsonResponse;
    paramFastJsonResponse = new ParseException("No data to parse");
    throw paramFastJsonResponse;
    try
    {
      paramInputStream.close();
    }
    catch (IOException paramInputStream)
    {
      for (;;) {}
    }
    Log.w("FastParser", "Failed to close reader while parsing.");
    throw paramFastJsonResponse;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static class ParseException
    extends Exception
  {
    public ParseException(String paramString)
    {
      super();
    }
    
    public ParseException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public ParseException(Throwable paramThrowable)
    {
      super();
    }
  }
}

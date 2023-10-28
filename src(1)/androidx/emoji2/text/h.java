package androidx.emoji2.text;

import android.graphics.Typeface;
import androidx.emoji2.text.asm.Attribute;
import java.io.IOException;
import java.nio.ByteBuffer;
import v7.v7.menu.TraceCompat;
import v7.v7.util.Log;

public final class h
{
  private final Typeface a;
  private final Attribute j;
  private final f m;
  private final char[] n;
  
  private h(Typeface paramTypeface, Attribute paramAttribute)
  {
    a = paramTypeface;
    j = paramAttribute;
    m = new f(1024);
    n = new char[paramAttribute.a() * 2];
    a(paramAttribute);
  }
  
  public static h a(Typeface paramTypeface, ByteBuffer paramByteBuffer)
    throws IOException
  {
    try
    {
      TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
      paramTypeface = new h(paramTypeface, Type.a(paramByteBuffer));
      TraceCompat.beginSection();
      return paramTypeface;
    }
    catch (Throwable paramTypeface)
    {
      TraceCompat.beginSection();
      throw paramTypeface;
    }
  }
  
  private void a(Attribute paramAttribute)
  {
    int k = paramAttribute.a();
    int i = 0;
    while (i < k)
    {
      paramAttribute = new i(this, i);
      Character.toChars(paramAttribute.e(), n, i * 2);
      a(paramAttribute);
      i += 1;
    }
  }
  
  int a()
  {
    return j.b();
  }
  
  void a(i paramI)
  {
    Log.get(paramI, "emoji metadata cannot be null");
    boolean bool;
    if (paramI.add() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Log.setText(bool, "invalid metadata codepoint length");
    m.a(paramI, 0, paramI.add() - 1);
  }
  
  public Attribute b()
  {
    return j;
  }
  
  f f()
  {
    return m;
  }
  
  public char[] j()
  {
    return n;
  }
  
  Typeface n()
  {
    return a;
  }
}

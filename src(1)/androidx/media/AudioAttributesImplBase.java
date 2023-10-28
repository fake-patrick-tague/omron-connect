package androidx.media;

import java.util.Arrays;

class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  int a = 0;
  int b = 0;
  int c = -1;
  int s = 0;
  
  AudioAttributesImplBase() {}
  
  public int b()
  {
    int i = c;
    if (i != -1) {
      return i;
    }
    return AudioAttributesCompat.write(false, b, s);
  }
  
  public int d()
  {
    return s;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplBase)) {
      return false;
    }
    paramObject = (AudioAttributesImplBase)paramObject;
    return (a == paramObject.n()) && (b == paramObject.f()) && (s == paramObject.d()) && (c == c);
  }
  
  public int f()
  {
    int j = b;
    int k = b();
    int i;
    if (k == 6)
    {
      i = j | 0x4;
    }
    else
    {
      i = j;
      if (k == 7) {
        i = j | 0x1;
      }
    }
    return i & 0x111;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(s), Integer.valueOf(c) });
  }
  
  public int n()
  {
    return a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (c != -1)
    {
      localStringBuilder.append(" stream=");
      localStringBuilder.append(c);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=");
    localStringBuilder.append(AudioAttributesCompat.getResultString(s));
    localStringBuilder.append(" content=");
    localStringBuilder.append(a);
    localStringBuilder.append(" flags=0x");
    localStringBuilder.append(Integer.toHexString(b).toUpperCase());
    return localStringBuilder.toString();
  }
}

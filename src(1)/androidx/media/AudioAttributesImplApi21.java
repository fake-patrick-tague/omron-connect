package androidx.media;

import android.media.AudioAttributes;

class AudioAttributesImplApi21
  implements AudioAttributesImpl
{
  AudioAttributes b;
  int c = -1;
  
  AudioAttributesImplApi21() {}
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplApi21)) {
      return false;
    }
    paramObject = (AudioAttributesImplApi21)paramObject;
    return b.equals(b);
  }
  
  public int hashCode()
  {
    return b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioAttributesCompat: audioattributes=");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
}

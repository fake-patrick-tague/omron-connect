package androidx.media;

import androidx.versionedparcelable.ByteVector;

public final class AudioAttributesImplBaseParcelizer
{
  public AudioAttributesImplBaseParcelizer() {}
  
  public static AudioAttributesImplBase read(ByteVector paramByteVector)
  {
    AudioAttributesImplBase localAudioAttributesImplBase = new AudioAttributesImplBase();
    s = paramByteVector.a(s, 1);
    a = paramByteVector.a(a, 2);
    b = paramByteVector.a(b, 3);
    c = paramByteVector.a(c, 4);
    return localAudioAttributesImplBase;
  }
  
  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, ByteVector paramByteVector)
  {
    paramByteVector.add(false, false);
    paramByteVector.add(s, 1);
    paramByteVector.add(a, 2);
    paramByteVector.add(b, 3);
    paramByteVector.add(c, 4);
  }
}

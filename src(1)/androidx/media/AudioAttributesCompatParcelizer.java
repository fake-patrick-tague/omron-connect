package androidx.media;

import androidx.versionedparcelable.ByteVector;

public final class AudioAttributesCompatParcelizer
{
  public AudioAttributesCompatParcelizer() {}
  
  public static AudioAttributesCompat read(ByteVector paramByteVector)
  {
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    b = ((AudioAttributesImpl)paramByteVector.add(b, 1));
    return localAudioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, ByteVector paramByteVector)
  {
    paramByteVector.add(false, false);
    paramByteVector.a(b, 1);
  }
}

package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.ByteVector;

public final class AudioAttributesImplApi21Parcelizer
{
  public AudioAttributesImplApi21Parcelizer() {}
  
  public static AudioAttributesImplApi21 read(ByteVector paramByteVector)
  {
    AudioAttributesImplApi21 localAudioAttributesImplApi21 = new AudioAttributesImplApi21();
    b = ((AudioAttributes)paramByteVector.read(b, 1));
    c = paramByteVector.a(c, 2);
    return localAudioAttributesImplApi21;
  }
  
  public static void write(AudioAttributesImplApi21 paramAudioAttributesImplApi21, ByteVector paramByteVector)
  {
    paramByteVector.add(false, false);
    paramByteVector.add(b, 1);
    paramByteVector.add(c, 2);
  }
}

package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.ByteVector;

public final class IconCompatParcelizer
  extends androidx.core.graphics.drawable.IconCompatParcelizer
{
  public IconCompatParcelizer() {}
  
  public static IconCompat read(ByteVector paramByteVector)
  {
    return androidx.core.graphics.drawable.IconCompatParcelizer.read(paramByteVector);
  }
  
  public static void write(IconCompat paramIconCompat, ByteVector paramByteVector)
  {
    androidx.core.graphics.drawable.IconCompatParcelizer.write(paramIconCompat, paramByteVector);
  }
}

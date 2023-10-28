package android.support.v4.app;

import androidx.core.package_10.RemoteActionCompat;
import androidx.versionedparcelable.ByteVector;

public final class RemoteActionCompatParcelizer
  extends androidx.core.package_10.RemoteActionCompatParcelizer
{
  public RemoteActionCompatParcelizer() {}
  
  public static RemoteActionCompat read(ByteVector paramByteVector)
  {
    return androidx.core.package_10.RemoteActionCompatParcelizer.read(paramByteVector);
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, ByteVector paramByteVector)
  {
    androidx.core.package_10.RemoteActionCompatParcelizer.write(paramRemoteActionCompat, paramByteVector);
  }
}

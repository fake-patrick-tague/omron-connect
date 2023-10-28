package androidx.core.package_10;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.ByteVector;

public class RemoteActionCompatParcelizer
{
  public RemoteActionCompatParcelizer() {}
  
  public static RemoteActionCompat read(ByteVector paramByteVector)
  {
    RemoteActionCompat localRemoteActionCompat = new RemoteActionCompat();
    n = ((IconCompat)paramByteVector.add(n, 1));
    a = paramByteVector.a(a, 2);
    s = paramByteVector.a(s, 3);
    c = ((PendingIntent)paramByteVector.read(c, 4));
    b = paramByteVector.a(b, 5);
    N = paramByteVector.a(N, 6);
    return localRemoteActionCompat;
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, ByteVector paramByteVector)
  {
    paramByteVector.add(false, false);
    paramByteVector.a(n, 1);
    paramByteVector.write(a, 2);
    paramByteVector.write(s, 3);
    paramByteVector.add(c, 4);
    paramByteVector.put(b, 5);
    paramByteVector.put(N, 6);
  }
}

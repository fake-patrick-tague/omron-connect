package androidx.core.graphics;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

class IOUtils
{
  static ParcelFileDescriptor openFile(ContentResolver paramContentResolver, Uri paramUri, String paramString, CancellationSignal paramCancellationSignal)
    throws FileNotFoundException
  {
    return paramContentResolver.openFileDescriptor(paramUri, paramString, paramCancellationSignal);
  }
}

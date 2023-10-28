package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Objects;

@KeepForSdk
@ShowFirstParty
@SafeParcelable.Class(creator="BitmapTeleporterCreator")
public class BitmapTeleporter
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new DiscreteSeekBar.CustomState.1();
  private Bitmap a;
  @SafeParcelable.Field(id=2)
  ParcelFileDescriptor data;
  private File dir;
  private boolean state;
  @SafeParcelable.VersionField(id=1)
  final int type;
  @SafeParcelable.Field(id=3)
  final int width;
  
  BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    type = paramInt1;
    data = paramParcelFileDescriptor;
    width = paramInt2;
    a = null;
    state = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    type = 1;
    data = null;
    width = 0;
    a = paramBitmap;
    state = true;
  }
  
  private static final void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("BitmapTeleporter", "Could not close stream", paramCloseable);
    }
  }
  
  public Bitmap get()
  {
    if (!state)
    {
      Object localObject1 = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor)Preconditions.checkNotNull(data)));
      try
      {
        int i = ((DataInputStream)localObject1).readInt();
        byte[] arrayOfByte = new byte[i];
        i = ((DataInputStream)localObject1).readInt();
        int j = ((DataInputStream)localObject1).readInt();
        Object localObject2 = Bitmap.Config.valueOf(((DataInputStream)localObject1).readUTF());
        ((DataInputStream)localObject1).read(arrayOfByte);
        closeQuietly((Closeable)localObject1);
        localObject1 = ByteBuffer.wrap(arrayOfByte);
        localObject2 = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject2);
        ((Bitmap)localObject2).copyPixelsFromBuffer((Buffer)localObject1);
        a = ((Bitmap)localObject2);
        state = true;
      }
      catch (Throwable localThrowable) {}catch (IOException localIOException)
      {
        throw new IllegalStateException("Could not read from parcel file descriptor", localIOException);
      }
      closeQuietly((Closeable)localObject1);
      throw localIOException;
    }
    return a;
  }
  
  public void release()
  {
    if (!state)
    {
      Object localObject = data;
      try
      {
        localObject = Preconditions.checkNotNull(localObject);
        localObject = (ParcelFileDescriptor)localObject;
        ((ParcelFileDescriptor)localObject).close();
        return;
      }
      catch (IOException localIOException)
      {
        Log.w("BitmapTeleporter", "Could not close PFD", localIOException);
      }
    }
  }
  
  public void setTempDir(File paramFile)
  {
    Objects.requireNonNull(paramFile, "Cannot set null temp directory");
    dir = paramFile;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    Object localObject1;
    Object localObject2;
    if (data == null)
    {
      localBitmap = (Bitmap)Preconditions.checkNotNull(a);
      localObject1 = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer((Buffer)localObject1);
      localObject1 = ((ByteBuffer)localObject1).array();
      localObject2 = dir;
      if (localObject2 == null) {}
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = File.createTempFile("teleporter", ".tmp", (File)localObject2);
      }
      catch (IOException paramParcel)
      {
        FileOutputStream localFileOutputStream;
        ParcelFileDescriptor localParcelFileDescriptor;
        throw new IllegalStateException("Could not create temporary file", paramParcel);
      }
      try
      {
        localFileOutputStream = new FileOutputStream((File)localObject2);
        localParcelFileDescriptor = ParcelFileDescriptor.open((File)localObject2, 268435456);
        data = localParcelFileDescriptor;
        ((File)localObject2).delete();
        localObject2 = new DataOutputStream(new BufferedOutputStream(localFileOutputStream));
        i = localObject1.length;
        try
        {
          ((DataOutputStream)localObject2).writeInt(i);
          ((DataOutputStream)localObject2).writeInt(localBitmap.getWidth());
          ((DataOutputStream)localObject2).writeInt(localBitmap.getHeight());
          ((DataOutputStream)localObject2).writeUTF(localBitmap.getConfig().toString());
          ((DataOutputStream)localObject2).write((byte[])localObject1);
          closeQuietly((Closeable)localObject2);
        }
        catch (Throwable paramParcel) {}catch (IOException paramParcel)
        {
          throw new IllegalStateException("Could not write into unlinked file", paramParcel);
        }
        closeQuietly((Closeable)localObject2);
        throw paramParcel;
      }
      catch (FileNotFoundException paramParcel) {}
    }
    throw new IllegalStateException("Temporary file is somehow already deleted");
    throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
    i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, type);
    SafeParcelWriter.writeParcelable(paramParcel, 2, data, paramInt | 0x1, false);
    SafeParcelWriter.writeInt(paramParcel, 3, width);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    data = null;
  }
}

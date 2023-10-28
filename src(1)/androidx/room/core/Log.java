package androidx.room.core;

import android.database.AbstractCursor;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7.td.data.Context;
import v7.td.data.Transaction;

public class Log
{
  public static Cursor get(RoomDatabase paramRoomDatabase, Transaction paramTransaction, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    paramTransaction = paramRoomDatabase.query(paramTransaction, paramCancellationSignal);
    paramRoomDatabase = paramTransaction;
    if (paramBoolean)
    {
      paramRoomDatabase = paramTransaction;
      if ((paramTransaction instanceof AbstractWindowedCursor))
      {
        paramCancellationSignal = (AbstractWindowedCursor)paramTransaction;
        int j = paramCancellationSignal.getCount();
        int i;
        if (paramCancellationSignal.hasWindow()) {
          i = paramCancellationSignal.getWindow().getNumRows();
        } else {
          i = j;
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramRoomDatabase = paramTransaction;
          if (i >= j) {}
        }
        else
        {
          paramRoomDatabase = Set.onLoadFinished(paramCancellationSignal);
        }
      }
    }
    return paramRoomDatabase;
  }
  
  public static void initialize(Context paramContext)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = paramContext.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    try
    {
      for (;;)
      {
        boolean bool = ((Cursor)localObject1).moveToNext();
        if (!bool) {
          break;
        }
        ((List)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith("room_fts_content_sync_"))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DROP TRIGGER IF EXISTS ");
          localStringBuilder.append((String)localObject2);
          paramContext.execSQL(localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      ((Cursor)localObject1).close();
      throw paramContext;
    }
  }
  
  public static int read(File paramFile)
    throws IOException
  {
    FileChannel localFileChannel = null;
    Object localObject = localFileChannel;
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localObject = localFileChannel;
      localFileChannel = new FileInputStream(paramFile).getChannel();
      paramFile = localFileChannel;
      localObject = paramFile;
      localFileChannel.tryLock(60L, 4L, true);
      localObject = paramFile;
      localFileChannel.position(60L);
      localObject = paramFile;
      int i = localFileChannel.read(localByteBuffer);
      if (i == 4)
      {
        localObject = paramFile;
        localByteBuffer.rewind();
        localObject = paramFile;
        i = localByteBuffer.getInt();
        localFileChannel.close();
        return i;
      }
      localObject = paramFile;
      throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
    }
    catch (Throwable paramFile)
    {
      if (localObject != null) {
        ((FileChannel)localObject).close();
      }
      throw paramFile;
    }
  }
}

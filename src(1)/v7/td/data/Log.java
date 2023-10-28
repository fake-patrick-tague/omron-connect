package v7.td.data;

import java.io.Closeable;

public abstract interface Log
  extends Closeable
{
  public abstract void close();
  
  public abstract String getDatabaseName();
  
  public abstract Context getWritableDatabase();
  
  public abstract void setWriteAheadLoggingEnabled(boolean paramBoolean);
}

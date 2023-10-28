package androidx.room;

import java.io.File;
import v7.td.data.Database;
import v7.td.data.Log;
import v7.td.data.Paint;
import v7.td.data.h;

class StatementExecutor
  implements Paint
{
  private final File context;
  private final Paint dao;
  private final String parent;
  
  StatementExecutor(String paramString, File paramFile, Paint paramPaint)
  {
    parent = paramString;
    context = paramFile;
    dao = paramPaint;
  }
  
  public Log create(h paramH)
  {
    return new SQLiteAssetHelper(w, parent, context, y.name, dao.create(paramH));
  }
}

package androidx.room;

public class Resources
{
  public static String toString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
}

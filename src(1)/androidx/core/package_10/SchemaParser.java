package androidx.core.package_10;

import android.app.RemoteInput.Builder;
import android.content.Intent;
import java.util.Map;
import java.util.Set;

class SchemaParser
{
  static RemoteInput.Builder build(RemoteInput.Builder paramBuilder, String paramString, boolean paramBoolean)
  {
    return paramBuilder.setAllowDataType(paramString, paramBoolean);
  }
  
  static Map build(Intent paramIntent, String paramString)
  {
    return android.app.RemoteInput.getDataResultsFromIntent(paramIntent, paramString);
  }
  
  static Set build(Object paramObject)
  {
    return ((android.app.RemoteInput)paramObject).getAllowedDataTypes();
  }
  
  static void build(RemoteInput paramRemoteInput, Intent paramIntent, Map paramMap)
  {
    android.app.RemoteInput.addDataResultToIntent(RemoteInput.build(paramRemoteInput), paramIntent, paramMap);
  }
}

package com.braze.support;

import android.os.BaseBundle;
import android.os.Bundle;
import com.braze.models.IPutIntoJson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.a0;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.Level;

public final class JsonUtils
{
  private static final String DONE = BrazeLogger.INSTANCE.getBrazeLogTag("JsonUtils");
  
  public static final boolean areJsonObjectsEqual(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null)) {
      return true;
    }
    if (paramJSONObject1 != null)
    {
      if (paramJSONObject2 == null) {
        return false;
      }
      if (paramJSONObject1.length() != paramJSONObject2.length()) {
        return false;
      }
      Iterator localIterator = paramJSONObject1.keys();
      i.d(localIterator, "target.keys()");
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if (!paramJSONObject2.has((String)localObject2)) {
          return false;
        }
        Object localObject1 = paramJSONObject1.opt((String)localObject2);
        localObject2 = paramJSONObject2.opt((String)localObject2);
        if (((localObject1 instanceof JSONObject)) && ((localObject2 instanceof JSONObject)))
        {
          if (!isEqualTo((JSONObject)localObject1, (JSONObject)localObject2)) {
            return false;
          }
        }
        else if ((localObject1 != null) && (localObject2 != null) && (!i.a(localObject1, localObject2))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static final JSONArray constructJsonArray(Collection paramCollection)
  {
    i.e(paramCollection, "<this>");
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localJSONArray.put(((IPutIntoJson)paramCollection.next()).forJsonPut());
    }
    return localJSONArray;
  }
  
  public static final JSONArray constructJsonArray(Object[] paramArrayOfObject)
  {
    i.e(paramArrayOfObject, "<this>");
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(paramArrayOfObject[i]);
      i += 1;
    }
    return localJSONArray;
  }
  
  public static final Map convertJSONObjectToMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return a0.d();
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramJSONObject.keys();
    i.d(localIterator, "this.keys()");
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      i.d(str1, "key");
      String str2 = paramJSONObject.getString(str1);
      i.d(str2, "this.getString(key)");
      localLinkedHashMap.put(str1, str2);
    }
    return localLinkedHashMap;
  }
  
  public static final List convertStringJsonArrayToList(final JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    int i = 0;
    int j = paramJSONArray.length();
    while (i < j)
    {
      try
      {
        String str = paramJSONArray.getString(i);
        i.d(str, "this.getString(i)");
        localArrayList.add(str);
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(DONE, BrazeLogger.Priority.this$0, localException, new a(i, paramJSONArray));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static final JSONObject deepcopy(JSONObject paramJSONObject)
  {
    i.e(paramJSONObject, "<this>");
    return new JSONObject(paramJSONObject.toString());
  }
  
  public static final Integer getColorIntegerOrNull(JSONObject paramJSONObject, String paramString)
  {
    i.e(paramJSONObject, "<this>");
    if ((paramString != null) && (paramJSONObject.has(paramString))) {
      try
      {
        int i = paramJSONObject.getInt(paramString);
        return Integer.valueOf(i);
      }
      catch (Throwable paramJSONObject)
      {
        BrazeLogger.INSTANCE.brazelog(DONE, BrazeLogger.Priority.this$0, paramJSONObject, b.SingleTap);
      }
    }
    return null;
  }
  
  public static final Double getDoubleOrNull(JSONObject paramJSONObject, String paramString)
  {
    i.e(paramJSONObject, "<this>");
    if ((paramJSONObject.has(paramString)) && (!paramJSONObject.isNull(paramString))) {
      return Double.valueOf(paramJSONObject.optDouble(paramString));
    }
    return null;
  }
  
  public static final String getOptionalString(JSONObject paramJSONObject, String paramString)
  {
    i.e(paramJSONObject, "<this>");
    if ((paramJSONObject.has(paramString)) && (!paramJSONObject.isNull(paramString))) {
      return paramJSONObject.optString(paramString);
    }
    return null;
  }
  
  public static final String getPrettyPrintedString(JSONObject paramJSONObject)
  {
    String str = "";
    if (paramJSONObject == null) {
      return "";
    }
    try
    {
      paramJSONObject = paramJSONObject.toString(2);
    }
    catch (Throwable paramJSONObject)
    {
      BrazeLogger.INSTANCE.brazelog(DONE, BrazeLogger.Priority.this$0, paramJSONObject, c.SingleTap);
      paramJSONObject = str;
    }
    i.d(paramJSONObject, "try {\n        this.toStr?ring.\" }\n        \"\"\n    }");
    return paramJSONObject;
  }
  
  public static final boolean isEqualTo(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return areJsonObjectsEqual(paramJSONObject1, paramJSONObject2);
  }
  
  public static final JSONObject mergeJsonObjects(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    i.e(paramJSONObject1, "oldJson");
    i.e(paramJSONObject2, "newJson");
    JSONObject localJSONObject = new JSONObject();
    Object localObject = paramJSONObject1.keys();
    i.d(localObject, "oldJson.keys()");
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      try
      {
        localJSONObject.put(str, paramJSONObject1.get(str));
      }
      catch (JSONException localJSONException2)
      {
        BrazeLogger.INSTANCE.brazelog(DONE, BrazeLogger.Priority.this$0, localJSONException2, new i(str));
      }
    }
    paramJSONObject1 = paramJSONObject2.keys();
    i.d(paramJSONObject1, "newJson.keys()");
    while (paramJSONObject1.hasNext())
    {
      localObject = (String)paramJSONObject1.next();
      try
      {
        localJSONObject.put((String)localObject, paramJSONObject2.get((String)localObject));
      }
      catch (JSONException localJSONException1)
      {
        BrazeLogger.INSTANCE.brazelog(DONE, BrazeLogger.Priority.this$0, localJSONException1, new j((String)localObject));
      }
    }
    return localJSONObject;
  }
  
  public static final Enum optEnum(JSONObject paramJSONObject, String paramString, Class paramClass, Enum paramEnum)
  {
    i.e(paramJSONObject, "jsonObject");
    i.e(paramString, "key");
    i.e(paramClass, "targetEnumClass");
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      i.d(paramJSONObject, "jsonObject.getString(key)");
      paramString = Locale.US;
      i.d(paramString, "US");
      paramJSONObject = paramJSONObject.toUpperCase(paramString);
      i.d(paramJSONObject, "this as java.lang.String).toUpperCase(locale)");
      paramJSONObject = Level.valueOf(paramJSONObject, paramClass);
      if (paramJSONObject == null) {
        return paramEnum;
      }
      return paramJSONObject;
    }
    catch (Exception paramJSONObject) {}
    return paramEnum;
  }
  
  public static final Bundle parseJsonObjectIntoBundle(String paramString)
  {
    localBundle = new Bundle();
    int i;
    if ((paramString != null) && (!g.o(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return localBundle;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        Object localObject = localIterator.next();
        localObject = (String)localObject;
        localBundle.putString((String)localObject, paramString.getString((String)localObject));
      }
      return localBundle;
    }
    catch (Exception paramString)
    {
      BrazeLogger.INSTANCE.brazelog(DONE, BrazeLogger.Priority.this$0, paramString, k.SingleTap);
    }
  }
  
  public static final JSONObject plus(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    i.e(paramJSONObject1, "<this>");
    i.e(paramJSONObject2, "otherJson");
    return mergeJsonObjects(paramJSONObject1, paramJSONObject2);
  }
  
  static final class a
    extends j
    implements a<String>
  {
    a(int paramInt, JSONArray paramJSONArray)
    {
      super();
    }
    
    public final String encode()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to get string for item at index: ");
      localStringBuilder.append(wordCount);
      localStringBuilder.append(" and array: ");
      localStringBuilder.append(paramJSONArray);
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b SingleTap = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to retrieve color integer from JSON";
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    public static final c SingleTap = new c();
    
    c()
    {
      super();
    }
    
    public final String getText()
    {
      return "Caught Throwable while generating pretty printed json. Returning blank string.";
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    i(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Caught exception merging JSON for old key ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    j(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Caught exception merging JSON for new key ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    public static final k SingleTap = new k();
    
    k()
    {
      super();
    }
    
    public final String getText()
    {
      return "Unable parse JSON into a bundle.";
    }
  }
}

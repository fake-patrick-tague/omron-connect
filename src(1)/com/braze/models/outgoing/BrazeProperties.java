package com.braze.models.outgoing;

import com.braze.enums.BrazeDateFormat;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.SignatureReader;

public final class BrazeProperties
  implements IPutIntoJson<JSONObject>
{
  public static final a Companion = new a(null);
  private JSONObject propertiesJSONObject = new JSONObject();
  
  public BrazeProperties() {}
  
  public BrazeProperties(JSONObject paramJSONObject)
  {
    propertiesJSONObject = clean$default(this, paramJSONObject, false, 2, null);
  }
  
  private final JSONObject clean(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramJSONObject.keys();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      i.d(localObject3, "jsonObjectIterator.next()");
      ((List)localObject1).add(localObject3);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((paramBoolean) && (!Companion.add((String)localObject2)))
      {
        paramJSONObject.remove((String)localObject2);
      }
      else
      {
        localObject3 = paramJSONObject.get((String)localObject2);
        if ((localObject3 instanceof Date)) {
          paramJSONObject.put((String)localObject2, DateTimeUtils.formatDate$default((Date)localObject3, BrazeDateFormat.LONG, null, 2, null));
        }
        if ((localObject3 instanceof JSONArray)) {
          paramJSONObject.put((String)localObject2, SignatureReader.a((JSONArray)localObject3));
        }
        if ((localObject3 instanceof JSONObject)) {
          paramJSONObject.put((String)localObject2, clean((JSONObject)localObject3, false));
        }
      }
    }
    return paramJSONObject;
  }
  
  public final BrazeProperties addProperty(String paramString, Object paramObject)
  {
    i.e(paramString, "key");
    if (!Companion.add(paramString)) {
      return this;
    }
    if ((paramObject instanceof Long)) {
      localObject = propertiesJSONObject;
    }
    try
    {
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (Number)paramObject;
      ((JSONObject)localObject).put(paramString, paramObject.longValue());
      return this;
    }
    catch (JSONException paramString)
    {
      BrazeDateFormat localBrazeDateFormat;
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramString, c.ri);
    }
    if ((paramObject instanceof Integer))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (Number)paramObject;
      ((JSONObject)localObject).put(paramString, paramObject.intValue());
      return this;
    }
    if ((paramObject instanceof Double))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (Number)paramObject;
      ((JSONObject)localObject).put(paramString, paramObject.doubleValue());
      return this;
    }
    if ((paramObject instanceof Boolean))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (Boolean)paramObject;
      ((JSONObject)localObject).put(paramString, paramObject.booleanValue());
      return this;
    }
    if ((paramObject instanceof Date))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (Date)paramObject;
      localBrazeDateFormat = BrazeDateFormat.LONG;
      ((JSONObject)localObject).put(paramString, DateTimeUtils.formatDate$default(paramObject, localBrazeDateFormat, null, 2, null));
      return this;
    }
    if ((paramObject instanceof String))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (String)paramObject;
      ((JSONObject)localObject).put(paramString, ValidationUtils.ensureBrazeFieldLength(paramObject));
      return this;
    }
    if ((paramObject instanceof JSONArray))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (JSONArray)paramObject;
      ((JSONObject)localObject).put(paramString, SignatureReader.a(paramObject));
      return this;
    }
    if ((paramObject instanceof JSONObject))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (JSONObject)paramObject;
      ((JSONObject)localObject).put(paramString, clean$default(this, paramObject, false, 2, null));
      return this;
    }
    if ((paramObject instanceof Map))
    {
      localObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramObject = (Map)paramObject;
      ((JSONObject)localObject).put(paramString, clean$default(this, new JSONObject(SignatureReader.a(paramObject)), false, 2, null));
      return this;
    }
    if (paramObject == null)
    {
      paramObject = propertiesJSONObject;
      paramString = ValidationUtils.ensureBrazeFieldLength(paramString);
      localObject = JSONObject.NULL;
      paramObject.put(paramString, localObject);
      return this;
    }
    paramObject = BrazeLogger.INSTANCE;
    Object localObject = BrazeLogger.Priority.PREPARED;
    BrazeLogger.brazelog$default(paramObject, this, (BrazeLogger.Priority)localObject, null, new b(paramString), 2, null);
    return this;
    return this;
  }
  
  public final BrazeProperties clone()
  {
    try
    {
      BrazeProperties localBrazeProperties = new BrazeProperties(new JSONObject(forJsonPut().toString()));
      return localBrazeProperties;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, d.STARTED);
    }
    return null;
  }
  
  public JSONObject forJsonPut()
  {
    return propertiesJSONObject;
  }
  
  public final long getByteSize()
  {
    String str = propertiesJSONObject.toString();
    i.d(str, "propertiesJSONObject.toString()");
    return StringUtils.getByteSize(str);
  }
  
  public final int getSize()
  {
    return propertiesJSONObject.length();
  }
  
  public final boolean isInvalid()
  {
    return getByteSize() > 51200L;
  }
  
  public static final class a
  {
    private a() {}
    
    public final boolean add(String paramString)
    {
      i.e(paramString, "key");
      if (g.o(paramString))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, a.lock, 2, null);
        return false;
      }
      if (g.v(paramString, "$", false, 2, null))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, b.lock, 2, null);
        return false;
      }
      return true;
    }
    
    static final class a
      extends j
      implements a<String>
    {
      public static final a lock = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "The BrazeProperties key cannot be null or contain only whitespaces. Not adding property.";
      }
    }
    
    static final class b
      extends j
      implements a<String>
    {
      public static final b lock = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "The leading character in the key string may not be '$'. Not adding property.";
      }
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Value type is not supported. Cannot add property ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    public static final c ri = new c();
    
    c()
    {
      super();
    }
    
    public final String getText()
    {
      return "Caught json exception trying to add property.";
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d STARTED = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to clone BrazeProperties";
    }
  }
}

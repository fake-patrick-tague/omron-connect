package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectRequest
  extends JsonRequest<JSONObject>
{
  public JsonObjectRequest(int paramInt, String paramString, JSONObject paramJSONObject, Response.Listener paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramJSONObject, paramListener, paramErrorListener);
  }
  
  public JsonObjectRequest(String paramString, JSONObject paramJSONObject, Response.Listener paramListener, Response.ErrorListener paramErrorListener)
  {
    this(i, paramString, paramJSONObject, paramListener, paramErrorListener);
  }
  
  protected Response parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    Object localObject = data;
    Map localMap = headers;
    try
    {
      localObject = new String((byte[])localObject, HttpHeaderParser.parseCharset(localMap, "utf-8"));
      paramNetworkResponse = Response.success(new JSONObject((String)localObject), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return paramNetworkResponse;
    }
    catch (JSONException paramNetworkResponse)
    {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    catch (UnsupportedEncodingException paramNetworkResponse) {}
    return Response.error(new ParseError(paramNetworkResponse));
  }
}

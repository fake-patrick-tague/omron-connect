package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class JsonArrayRequest
  extends JsonRequest<JSONArray>
{
  public JsonArrayRequest(int paramInt, String paramString, JSONArray paramJSONArray, Response.Listener paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramJSONArray, paramListener, paramErrorListener);
  }
  
  public JsonArrayRequest(String paramString, Response.Listener paramListener, Response.ErrorListener paramErrorListener)
  {
    super(0, paramString, null, paramListener, paramErrorListener);
  }
  
  protected Response parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    Object localObject = data;
    Map localMap = headers;
    try
    {
      localObject = new String((byte[])localObject, HttpHeaderParser.parseCharset(localMap, "utf-8"));
      paramNetworkResponse = Response.success(new JSONArray((String)localObject), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
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

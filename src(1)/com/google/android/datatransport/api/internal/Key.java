package com.google.android.datatransport.api.internal;

final class Key
  extends Label
{
  private final String a;
  private final String c;
  private final String code;
  private final String id;
  private final String identifier;
  private final String label;
  private final String name;
  private final String text;
  private final String title;
  private final String type;
  private final Integer value;
  private final String x;
  
  private Key(Integer paramInteger, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    value = paramInteger;
    id = paramString1;
    c = paramString2;
    a = paramString3;
    x = paramString4;
    text = paramString5;
    title = paramString6;
    type = paramString7;
    code = paramString8;
    name = paramString9;
    label = paramString10;
    identifier = paramString11;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Label))
    {
      paramObject = (Label)paramObject;
      Object localObject = value;
      if (localObject == null ? paramObject.get() == null : ((Integer)localObject).equals(paramObject.get()))
      {
        localObject = id;
        if (localObject == null ? paramObject.getUrl() == null : ((String)localObject).equals(paramObject.getUrl()))
        {
          localObject = c;
          if (localObject == null ? paramObject.getName() == null : ((String)localObject).equals(paramObject.getName()))
          {
            localObject = a;
            if (localObject == null ? paramObject.getIcon() == null : ((String)localObject).equals(paramObject.getIcon()))
            {
              localObject = x;
              if (localObject == null ? paramObject.getX() == null : ((String)localObject).equals(paramObject.getX()))
              {
                localObject = text;
                if (localObject == null ? paramObject.getText() == null : ((String)localObject).equals(paramObject.getText()))
                {
                  localObject = title;
                  if (localObject == null ? paramObject.getTitle() == null : ((String)localObject).equals(paramObject.getTitle()))
                  {
                    localObject = type;
                    if (localObject == null ? paramObject.getType() == null : ((String)localObject).equals(paramObject.getType()))
                    {
                      localObject = code;
                      if (localObject == null ? paramObject.getCode() == null : ((String)localObject).equals(paramObject.getCode()))
                      {
                        localObject = name;
                        if (localObject == null ? paramObject.getKey() == null : ((String)localObject).equals(paramObject.getKey()))
                        {
                          localObject = label;
                          if (localObject == null ? paramObject.getLabel() == null : ((String)localObject).equals(paramObject.getLabel()))
                          {
                            localObject = identifier;
                            if (localObject == null)
                            {
                              if (paramObject.getId() == null) {
                                return true;
                              }
                            }
                            else if (((String)localObject).equals(paramObject.getId())) {
                              return true;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public Integer get()
  {
    return value;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public String getIcon()
  {
    return a;
  }
  
  public String getId()
  {
    return identifier;
  }
  
  public String getKey()
  {
    return name;
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public String getName()
  {
    return c;
  }
  
  public String getText()
  {
    return text;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public String getType()
  {
    return type;
  }
  
  public String getUrl()
  {
    return id;
  }
  
  public String getX()
  {
    return x;
  }
  
  public int hashCode()
  {
    Object localObject = value;
    int i7 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    localObject = id;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = c;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = a;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    localObject = x;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((String)localObject).hashCode();
    }
    localObject = text;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((String)localObject).hashCode();
    }
    localObject = title;
    int i2;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((String)localObject).hashCode();
    }
    localObject = type;
    int i3;
    if (localObject == null) {
      i3 = 0;
    } else {
      i3 = ((String)localObject).hashCode();
    }
    localObject = code;
    int i4;
    if (localObject == null) {
      i4 = 0;
    } else {
      i4 = ((String)localObject).hashCode();
    }
    localObject = name;
    int i5;
    if (localObject == null) {
      i5 = 0;
    } else {
      i5 = ((String)localObject).hashCode();
    }
    localObject = label;
    int i6;
    if (localObject == null) {
      i6 = 0;
    } else {
      i6 = ((String)localObject).hashCode();
    }
    localObject = identifier;
    if (localObject != null) {
      i7 = ((String)localObject).hashCode();
    }
    return (((((((((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ i3) * 1000003 ^ i4) * 1000003 ^ i5) * 1000003 ^ i6) * 1000003 ^ i7;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AndroidClientInfo{sdkVersion=");
    localStringBuilder.append(value);
    localStringBuilder.append(", model=");
    localStringBuilder.append(id);
    localStringBuilder.append(", hardware=");
    localStringBuilder.append(c);
    localStringBuilder.append(", device=");
    localStringBuilder.append(a);
    localStringBuilder.append(", product=");
    localStringBuilder.append(x);
    localStringBuilder.append(", osBuild=");
    localStringBuilder.append(text);
    localStringBuilder.append(", manufacturer=");
    localStringBuilder.append(title);
    localStringBuilder.append(", fingerprint=");
    localStringBuilder.append(type);
    localStringBuilder.append(", locale=");
    localStringBuilder.append(code);
    localStringBuilder.append(", country=");
    localStringBuilder.append(name);
    localStringBuilder.append(", mccMnc=");
    localStringBuilder.append(label);
    localStringBuilder.append(", applicationBuild=");
    localStringBuilder.append(identifier);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

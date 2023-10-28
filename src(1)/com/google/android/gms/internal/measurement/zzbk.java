package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzbk
  extends zzaw
{
  protected zzbk()
  {
    this$0.add(zzbl.dir);
    this$0.add(zzbl.client);
    this$0.add(zzbl.NETWORK);
    this$0.add(zzbl.r);
    this$0.add(zzbl.alt);
    this$0.add(zzbl.title);
    this$0.add(zzbl.SMS_MO);
    this$0.add(zzbl.CALL_MO);
    this$0.add(zzbl.header);
    this$0.add(zzbl.zzag);
    this$0.add(zzbl.zzak);
    this$0.add(zzbl.zzal);
    this$0.add(zzbl.zzam);
  }
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    Object localObject = zzbl.list;
    int m = ByteVector.get(paramString).ordinal();
    int j = 0;
    int k = 0;
    int i = 0;
    if (m != 3)
    {
      if (m != 14)
      {
        if (m != 24)
        {
          if (m != 33)
          {
            if (m != 49)
            {
              if (m != 58)
              {
                if (m != 17)
                {
                  if (m != 18)
                  {
                    if ((m != 35) && (m != 36))
                    {
                      switch (m)
                      {
                      default: 
                        return super.add(paramString);
                      case 64: 
                        ByteVector.add(zzbl.zzam.name(), 1, paramList);
                        paramString = paramList.iterator();
                        while (paramString.hasNext())
                        {
                          paramList = paramHeaders.get((zzap)paramString.next());
                          if ((paramList instanceof zzat)) {
                            paramHeaders.add(paramList.getValue(), zzap.this$0);
                          } else {
                            throw new IllegalArgumentException(String.format("Expected string for var name. got %s", new Object[] { paramList.getClass().getCanonicalName() }));
                          }
                        }
                        return zzap.this$0;
                      case 63: 
                        ByteVector.set(zzbl.zzal.name(), 0, paramList);
                        return zzap.this$0;
                      }
                      ByteVector.set(zzbl.zzak.name(), 1, paramList);
                      paramString = paramHeaders.get((zzap)paramList.get(0));
                      if ((paramString instanceof zzau))
                      {
                        paramString = "undefined";
                      }
                      else if ((paramString instanceof zzaf))
                      {
                        paramString = "boolean";
                      }
                      else if ((paramString instanceof zzah))
                      {
                        paramString = "number";
                      }
                      else if ((paramString instanceof zzat))
                      {
                        paramString = "string";
                      }
                      else if ((paramString instanceof zzao))
                      {
                        paramString = "function";
                      }
                      else
                      {
                        if (((paramString instanceof zzaq)) || ((paramString instanceof zzag))) {
                          break label364;
                        }
                        paramString = "object";
                      }
                      return new zzat(paramString);
                      label364:
                      throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[] { paramString }));
                    }
                    ByteVector.set(zzbl.CALL_MO.name(), 2, paramList);
                    paramString = paramHeaders.get((zzap)paramList.get(0));
                    paramHeaders = paramHeaders.get((zzap)paramList.get(1));
                    if (((paramString instanceof zzae)) && (ByteVector.add(paramHeaders))) {
                      return ((zzae)paramString).get(paramHeaders.get().intValue());
                    }
                    if ((paramString instanceof zzal)) {
                      return ((zzal)paramString).get(paramHeaders.getValue());
                    }
                    if ((paramString instanceof zzat))
                    {
                      if ("length".equals(paramHeaders.getValue())) {
                        return new zzah(Double.valueOf(paramString.getValue().length()));
                      }
                      if ((ByteVector.add(paramHeaders)) && (paramHeaders.get().doubleValue() < paramString.getValue().length())) {
                        return new zzat(String.valueOf(paramString.getValue().charAt(paramHeaders.get().intValue())));
                      }
                    }
                    return zzap.this$0;
                  }
                  if (paramList.isEmpty()) {
                    return new zzam();
                  }
                  if (paramList.size() % 2 == 0)
                  {
                    paramString = new zzam();
                    for (;;)
                    {
                      if (i >= paramList.size() - 1) {
                        break label1463;
                      }
                      localObject = paramHeaders.get((zzap)paramList.get(i));
                      zzap localZzap = paramHeaders.get((zzap)paramList.get(i + 1));
                      if (((localObject instanceof zzag)) || ((localZzap instanceof zzag))) {
                        break;
                      }
                      paramString.add(((zzap)localObject).getValue(), localZzap);
                      i += 2;
                    }
                    throw new IllegalStateException("Failed to evaluate map entry");
                  }
                  throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", new Object[] { Integer.valueOf(paramList.size()) }));
                }
                if (paramList.isEmpty()) {
                  return new zzae();
                }
                paramString = new zzae();
                paramList = paramList.iterator();
                i = j;
                for (;;)
                {
                  if (!paramList.hasNext()) {
                    break label1465;
                  }
                  localObject = paramHeaders.get((zzap)paramList.next());
                  if ((localObject instanceof zzag)) {
                    break;
                  }
                  paramString.add(i, (zzap)localObject);
                  i += 1;
                }
                throw new IllegalStateException("Failed to evaluate array element");
              }
              ByteVector.set(zzbl.zzag.name(), 3, paramList);
              paramString = paramHeaders.get((zzap)paramList.get(0));
              localObject = paramHeaders.get((zzap)paramList.get(1));
              paramHeaders = paramHeaders.get((zzap)paramList.get(2));
              if ((paramString != zzap.this$0) && (paramString != zzap.items))
              {
                if (((paramString instanceof zzae)) && ((localObject instanceof zzah)))
                {
                  ((zzae)paramString).add(((zzap)localObject).get().intValue(), paramHeaders);
                  return paramHeaders;
                }
                if ((paramString instanceof zzal))
                {
                  ((zzal)paramString).add(((zzap)localObject).getValue(), paramHeaders);
                  return paramHeaders;
                }
              }
              else
              {
                throw new IllegalStateException(String.format("Can't set property %s of %s", new Object[] { ((zzap)localObject).getValue(), paramString.getValue() }));
              }
            }
            else
            {
              ByteVector.set(zzbl.header.name(), 0, paramList);
              return zzap.items;
            }
          }
          else
          {
            ByteVector.set(zzbl.title.name(), 1, paramList);
            paramString = paramHeaders.get((zzap)paramList.get(0));
            if ((paramString instanceof zzat)) {
              return paramHeaders.get(paramString.getValue());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", new Object[] { paramString.getClass().getCanonicalName() }));
          }
        }
        else
        {
          ByteVector.add(zzbl.alt.name(), 1, paramList);
          paramString = zzap.this$0;
          i = k;
          for (;;)
          {
            if (i >= paramList.size()) {
              return paramString;
            }
            localObject = paramHeaders.get((zzap)paramList.get(i));
            paramString = (String)localObject;
            if ((localObject instanceof zzag)) {
              break;
            }
            i += 1;
          }
          throw new IllegalStateException("ControlValue cannot be in an expression list");
        }
      }
      else
      {
        ByteVector.add(zzbl.client.name(), 2, paramList);
        if (paramList.size() % 2 == 0)
        {
          i = 0;
          while (i < paramList.size() - 1)
          {
            paramString = paramHeaders.get((zzap)paramList.get(i));
            if ((paramString instanceof zzat))
            {
              paramHeaders.put(paramString.getValue(), paramHeaders.get((zzap)paramList.get(i + 1)));
              i += 2;
            }
            else
            {
              throw new IllegalArgumentException(String.format("Expected string for const name. got %s", new Object[] { paramString.getClass().getCanonicalName() }));
            }
          }
          return zzap.this$0;
        }
        throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", new Object[] { Integer.valueOf(paramList.size()) }));
      }
    }
    else
    {
      ByteVector.set(zzbl.dir.name(), 2, paramList);
      paramString = paramHeaders.get((zzap)paramList.get(0));
      if ((paramString instanceof zzat))
      {
        if (paramHeaders.set(paramString.getValue()))
        {
          paramList = paramHeaders.get((zzap)paramList.get(1));
          paramHeaders.set(paramString.getValue(), paramList);
          return paramList;
        }
        throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", new Object[] { paramString.getValue() }));
      }
      throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", new Object[] { paramString.getClass().getCanonicalName() }));
      label1463:
      return paramString;
      label1465:
      return paramString;
    }
    return paramHeaders;
    return paramString;
  }
}

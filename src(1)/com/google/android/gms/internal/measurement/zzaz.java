package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzaz
  extends zzaw
{
  protected zzaz()
  {
    this$0.add(zzbl.items);
    this$0.add(zzbl.TAG);
    this$0.add(zzbl.instance);
    this$0.add(zzbl.context);
    this$0.add(zzbl.u);
    this$0.add(zzbl.OK);
    this$0.add(zzbl.g);
    this$0.add(zzbl.action);
    this$0.add(zzbl.FALSE);
    this$0.add(zzbl.zzac);
    this$0.add(zzbl.zzaf);
    this$0.add(zzbl.zzai);
    this$0.add(zzbl.zzaj);
  }
  
  private static zzap add(Headers paramHeaders, List paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    Object localObject = zzbl.list;
    int i = ByteVector.get(paramString).ordinal();
    if (i != 2)
    {
      if (i != 15)
      {
        if (i != 25)
        {
          zzap localZzap;
          if (i != 41)
          {
            if (i != 54)
            {
              if (i != 57)
              {
                if (i != 19)
                {
                  if (i != 20) {
                    if (i != 60) {
                      if (i == 61) {}
                    }
                  }
                  switch (i)
                  {
                  default: 
                    return super.add(paramString);
                  case 12: 
                    ByteVector.set(zzbl.instance.name(), 0, paramList);
                    return zzap.NaN;
                  case 11: 
                    return paramHeaders.get().get(new zzae(paramList));
                    ByteVector.set(zzbl.zzaj.name(), 3, paramList);
                    if (paramHeaders.get((zzap)paramList.get(0)).value().booleanValue()) {
                      return paramHeaders.get((zzap)paramList.get(1));
                    }
                    return paramHeaders.get((zzap)paramList.get(2));
                    ByteVector.set(zzbl.zzai.name(), 3, paramList);
                    paramString = paramHeaders.get((zzap)paramList.get(0));
                    localObject = paramHeaders.get((zzap)paramList.get(1));
                    localZzap = paramHeaders.get((zzap)paramList.get(2));
                    if ((localObject instanceof zzae))
                    {
                      if ((localZzap instanceof zzae))
                      {
                        paramList = (zzae)localObject;
                        localObject = (zzae)localZzap;
                        int j = 0;
                        i = 0;
                        while (j < paramList.next())
                        {
                          if ((i == 0) && (!paramString.equals(paramHeaders.get(paramList.get(j)))))
                          {
                            i = 0;
                          }
                          else
                          {
                            localZzap = paramHeaders.get(((zzae)localObject).get(j));
                            if ((localZzap instanceof zzag))
                            {
                              if (!((zzag)localZzap).getEntry().equals("break")) {
                                break label476;
                              }
                              return zzap.this$0;
                            }
                            i = 1;
                          }
                          j += 1;
                        }
                        if (paramList.next() + 1 == ((zzae)localObject).next())
                        {
                          paramString = paramHeaders.get(((zzae)localObject).get(paramList.next()));
                          if ((paramString instanceof zzag))
                          {
                            paramHeaders = ((zzag)paramString).getEntry();
                            if ((paramHeaders.equals("return")) || (paramHeaders.equals("continue"))) {
                              break;
                            }
                            break label479;
                            label476:
                            return localZzap;
                          }
                        }
                        label479:
                        return zzap.this$0;
                      }
                      throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                    }
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                    ByteVector.add(zzbl.g.name(), 2, paramList);
                    paramString = add(paramHeaders, paramList);
                    paramList = (zzai)paramString;
                    if (paramList.booleanValue() == null)
                    {
                      paramHeaders.set("", paramString);
                      return paramString;
                    }
                    paramHeaders.set(paramList.booleanValue(), paramString);
                    return paramString;
                  }
                }
                else
                {
                  if (paramList.isEmpty()) {
                    return zzap.this$0;
                  }
                  paramString = paramHeaders.get((zzap)paramList.get(0));
                  if ((paramString instanceof zzae)) {
                    return paramHeaders.get((zzae)paramString);
                  }
                  return zzap.this$0;
                }
              }
              else
              {
                if (paramList.isEmpty()) {
                  return zzap.menu;
                }
                ByteVector.set(zzbl.zzaf.name(), 1, paramList);
                return new zzag("return", paramHeaders.get((zzap)paramList.get(0)));
              }
            }
            else {
              return new zzae(paramList);
            }
          }
          else
          {
            ByteVector.add(zzbl.FALSE.name(), 2, paramList);
            localObject = paramHeaders.get((zzap)paramList.get(0));
            localZzap = paramHeaders.get((zzap)paramList.get(1));
            if (paramList.size() > 2) {
              paramString = paramHeaders.get((zzap)paramList.get(2));
            } else {
              paramString = null;
            }
            paramList = zzap.this$0;
            if (((zzap)localObject).value().booleanValue()) {
              paramString = paramHeaders.get((zzae)localZzap);
            } else if (paramString != null) {
              paramString = paramHeaders.get((zzae)paramString);
            } else {
              paramString = paramList;
            }
            if ((paramString instanceof zzag)) {
              return paramString;
            }
            return paramList;
          }
        }
        else
        {
          return add(paramHeaders, paramList);
        }
      }
      else
      {
        ByteVector.set(zzbl.instance.name(), 0, paramList);
        return zzap.uri;
      }
    }
    else
    {
      ByteVector.set(zzbl.items.name(), 3, paramList);
      paramString = paramHeaders.get((zzap)paramList.get(0));
      localObject = paramHeaders.get((zzap)paramList.get(1)).getValue();
      paramList = paramHeaders.get((zzap)paramList.get(2));
      if ((paramList instanceof zzae))
      {
        if (!((String)localObject).isEmpty()) {
          return paramString.zzbN((String)localObject, paramHeaders, ((zzae)paramList).getList());
        }
        throw new IllegalArgumentException("Function name for apply is undefined");
      }
      throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", new Object[] { paramList.getClass().getCanonicalName() }));
    }
    return paramString;
  }
}

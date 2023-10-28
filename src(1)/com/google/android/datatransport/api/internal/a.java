package com.google.android.datatransport.api.internal;

import com.google.firebase.common.Paint;
import java.io.IOException;

final class a
  implements com.google.firebase.p.d<com.google.android.datatransport.cct.internal.a>
{
  private static final Paint a;
  private static final Paint b;
  private static final Paint c;
  private static final Paint d = Paint.valueOf("applicationBuild");
  private static final Paint e;
  private static final Paint f;
  static final a g = new a();
  private static final Paint h = Paint.valueOf("sdkVersion");
  private static final Paint k;
  private static final Paint m;
  private static final Paint p;
  private static final Paint q;
  private static final Paint r;
  
  static
  {
    b = Paint.valueOf("model");
    r = Paint.valueOf("hardware");
    p = Paint.valueOf("device");
    q = Paint.valueOf("product");
    f = Paint.valueOf("osBuild");
    k = Paint.valueOf("manufacturer");
    m = Paint.valueOf("fingerprint");
    c = Paint.valueOf("locale");
    a = Paint.valueOf("country");
    e = Paint.valueOf("mccMnc");
  }
  
  private a() {}
  
  public void a(Label paramLabel, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(h, paramLabel.get());
    paramD.append(b, paramLabel.getUrl());
    paramD.append(r, paramLabel.getName());
    paramD.append(p, paramLabel.getIcon());
    paramD.append(q, paramLabel.getX());
    paramD.append(f, paramLabel.getText());
    paramD.append(k, paramLabel.getTitle());
    paramD.append(m, paramLabel.getType());
    paramD.append(c, paramLabel.getCode());
    paramD.append(a, paramLabel.getKey());
    paramD.append(e, paramLabel.getLabel());
    paramD.append(d, paramLabel.getId());
  }
}

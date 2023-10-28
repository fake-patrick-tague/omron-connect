package com.google.android.gms.common;

final class NullEncoder
  extends Value
{
  NullEncoder(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  protected final byte[] encode()
  {
    return Type.encode("0?\006\0040?\003??\003\002\001\002\002\024\003?????r?k??!?<D`/?e?0\r\006\t*?H??\r\001\001\013\005\0000??1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1-0+\006\003U\004\003\f$com_google_android_gms-rotation-20200 \027\r200309195702Z\030\01720500309195702Z0??1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1-0+\006\003U\004\003\f$com_google_android_gms-rotation-20200?\002\"0\r\006\t*?H??\r\001\001\001\005\000\003?\002\017\0000?\002\n\002?\002\001\000????D?#???&?\006)?J??IO?v'5?J\033D/???S??p????\035?0??\030C???\022#??\026???\034??????j???e?|?IM?\021\"?????????0os&???s\005\030?T\021E|?=?LG????\005j}?_K\020`g\017O?\020s???M?k?Ujs?=????:E?\031\000??0y??>g?3\033?????,?Z?,$b?)?Y??p?\fD?\016<????\001?,Mc,l?J|k??%\017`\000??UTTi???????9?~???^?I\002??\nv???????W??????\032\001w?\"<0G.DA?)%?7\005??=???V.?{$??6?Y -????x?L???\033\036T?Q????\020}??Qn?????ns?\002?\b\007???2??s?h?!????\037?f?0S<H?X?8Ck??U??^??\r???o????P?.5\001?Z?=E5\021?Z??????????:?!gH??KF\031m\036D\026???q#~?\004?????s?T]?I$??\r???,??\0322\035\002???Z!:s??~KT?$\\??!?\032??]!f]\fT?\035?F? ??@?l.?F?????I?;??\rTh%????_ N6\025?e\023+??h.Fs\002\003\001\000\001?P0N0\f\006\003U\035\023\004\0050\003\001\001?0\035\006\003U\035\016\004\026\004\024???????yJ?\n??\002\016?]u??0\037\006\003U\035#\004\0300\026?\024???????yJ?\n??\002\016?]u??0\r\006\t*?H??\r\001\001\013\005\000\003?\002\001\000|\024?F\036????7?>: pmSe??\025?-?])????\002??pB?\"?\002g\\:?\ny7\016\006e5????R????d\005G5\022??\003?s$??^?r?\b>?f?\\?\b???p\017qU+h\024???k???V?]nFiS??ai?\022?7?\022;?????\ts)\030?6???8w[\025?\b?????F\004?\035\f?s?;v?5r\b\021V\020?]??2??z??\\C?????:lF??Yt\004??????\031??>?I<\b?e3Z?????\016???{???1??0\023?n?&?Z\023\022\023????O\t?\r??YK???Cr<7`e?U6*??K?y?A?????????x\017?gx.?R??>N?xh?N??`0h???????U\023l?5-\005???pa?G\\WQa??T?????\004?n9^h???t?\036*?\001?\\\bX?`\016+????$;\001\005??s\013(??C?K??{\016????p??)i???h\013o??\037K-U\031???<d?X??`?\017??l?\t\r`?\030??Q??x?p?F-l?\032N{QQ?c2Zkl??3???\030 ??`G/???x?a#(?\b?F???zj3?@$L??????W~f?<-?\034f?vt\017|?U?\t??z\007{???QR?");
  }
}
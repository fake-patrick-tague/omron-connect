package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

public enum zzbl
{
  private static final Map zzao;
  private final int zzaq;
  
  static
  {
    id = new zzbl("AND", 1, 1);
    items = new zzbl("APPLY", 2, 2);
    dir = new zzbl("ASSIGN", 3, 3);
    start = new zzbl("BITWISE_AND", 4, 56);
    content = new zzbl("BITWISE_LEFT_SHIFT", 5, 57);
    message = new zzbl("BITWISE_NOT", 6, 58);
    code = new zzbl("BITWISE_OR", 7, 59);
    map = new zzbl("BITWISE_RIGHT_SHIFT", 8, 60);
    name = new zzbl("BITWISE_UNSIGNED_RIGHT_SHIFT", 9, 61);
    owner = new zzbl("BITWISE_XOR", 10, 62);
    TAG = new zzbl("BLOCK", 11, 53);
    instance = new zzbl("BREAK", 12, 4);
    context = new zzbl("CASE", 13, 5);
    client = new zzbl("CONST", 14, 52);
    OK = new zzbl("CONTINUE", 15, 6);
    SAVED = new zzbl("CONTROL", 16, 49);
    NETWORK = new zzbl("CREATE_ARRAY", 17, 7);
    r = new zzbl("CREATE_OBJECT", 18, 8);
    u = new zzbl("DEFAULT", 19, 9);
    g = new zzbl("DEFINE_FUNCTION", 20, 50);
    y = new zzbl("DIVIDE", 21, 10);
    lat = new zzbl("DO", 22, 11);
    lon = new zzbl("EQUALS", 23, 12);
    alt = new zzbl("EXPRESSION_LIST", 24, 13);
    action = new zzbl("FN", 25, 51);
    order = new zzbl("FOR_IN", 26, 47);
    type = new zzbl("FOR_IN_CONST", 27, 54);
    values = new zzbl("FOR_IN_LET", 28, 55);
    NONE = new zzbl("FOR_LET", 29, 63);
    ZERO = new zzbl("FOR_OF", 30, 64);
    ONE = new zzbl("FOR_OF_CONST", 31, 65);
    head = new zzbl("FOR_OF_LET", 32, 66);
    title = new zzbl("GET", 33, 15);
    CALL_MO_ACTIVE = new zzbl("GET_CONTAINER_VARIABLE", 34, 48);
    SMS_MO = new zzbl("GET_INDEX", 35, 16);
    CALL_MO = new zzbl("GET_PROPERTY", 36, 17);
    SMS_MT = new zzbl("GREATER_THAN", 37, 18);
    END = new zzbl("GREATER_THAN_EQUALS", 38, 19);
    ERROR = new zzbl("IDENTITY_EQUALS", 39, 20);
    WARNING = new zzbl("IDENTITY_NOT_EQUALS", 40, 21);
    FALSE = new zzbl("IF", 41, 22);
    UNKNOWN = new zzbl("LESS_THAN", 42, 23);
    NULL = new zzbl("LESS_THAN_EQUALS", 43, 24);
    data = new zzbl("MODULUS", 44, 25);
    p = new zzbl("MULTIPLY", 45, 26);
    q = new zzbl("NEGATE", 46, 27);
    x = new zzbl("NOT", 47, 28);
    d = new zzbl("NOT_EQUALS", 48, 29);
    header = new zzbl("NULL", 49, 45);
    item = new zzbl("OR", 50, 30);
    Background = new zzbl("PLUS_EQUALS", 51, 31);
    zzaa = new zzbl("POST_DECREMENT", 52, 32);
    zzab = new zzbl("POST_INCREMENT", 53, 33);
    zzac = new zzbl("QUOTE", 54, 46);
    zzad = new zzbl("PRE_DECREMENT", 55, 34);
    zzae = new zzbl("PRE_INCREMENT", 56, 35);
    zzaf = new zzbl("RETURN", 57, 36);
    zzag = new zzbl("SET_PROPERTY", 58, 43);
    zzah = new zzbl("SUBTRACT", 59, 37);
    zzai = new zzbl("SWITCH", 60, 38);
    zzaj = new zzbl("TERNARY", 61, 39);
    zzak = new zzbl("TYPEOF", 62, 40);
    zzal = new zzbl("UNDEFINED", 63, 44);
    zzam = new zzbl("VAR", 64, 41);
    zzan = new zzbl("WHILE", 65, 42);
    zzap = new zzbl[] { list, id, items, dir, start, content, message, code, map, name, owner, TAG, instance, context, client, OK, SAVED, NETWORK, r, u, g, y, lat, lon, alt, action, order, type, values, NONE, ZERO, ONE, head, title, CALL_MO_ACTIVE, SMS_MO, CALL_MO, SMS_MT, END, ERROR, WARNING, FALSE, UNKNOWN, NULL, data, p, q, x, d, header, item, Background, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zzal, zzam, zzan };
    zzao = new HashMap();
    zzbl[] arrayOfZzbl = values();
    int j = arrayOfZzbl.length;
    int i = 0;
    while (i < j)
    {
      zzbl localZzbl = arrayOfZzbl[i];
      zzao.put(Integer.valueOf(zzaq), localZzbl);
      i += 1;
    }
  }
  
  private zzbl(int paramInt)
  {
    zzaq = paramInt;
  }
  
  public static zzbl join(int paramInt)
  {
    return (zzbl)zzao.get(Integer.valueOf(paramInt));
  }
  
  public final Integer next()
  {
    return Integer.valueOf(zzaq);
  }
  
  public final String toString()
  {
    return Integer.valueOf(zzaq).toString();
  }
}

package com.google.android.gms.internal.measurement;

import java.util.logging.Logger;

abstract class zzjy
{
  private static final Logger log = Logger.getLogger(zzjl.class.getName());
  private static final String name = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
  
  zzjy() {}
  
  /* Error */
  static zzjq newInstance(Class paramClass)
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokevirtual 52	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   5: astore_2
    //   6: aload_0
    //   7: ldc 54
    //   9: invokevirtual 58	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +10 -> 22
    //   15: getstatic 30	com/google/android/gms/internal/measurement/zzjy:name	Ljava/lang/String;
    //   18: astore_1
    //   19: goto +45 -> 64
    //   22: aload_0
    //   23: invokevirtual 62	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   26: ldc 2
    //   28: invokevirtual 62	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   31: invokevirtual 58	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +295 -> 329
    //   37: ldc 64
    //   39: iconst_2
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: invokevirtual 62	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   49: invokevirtual 67	java/lang/Package:getName	()Ljava/lang/String;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: aload_0
    //   56: invokevirtual 70	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload_1
    //   65: iconst_1
    //   66: aload_2
    //   67: invokestatic 80	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   70: astore_1
    //   71: aload_1
    //   72: iconst_0
    //   73: anewarray 14	java/lang/Class
    //   76: invokevirtual 84	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   79: astore_1
    //   80: aload_1
    //   81: iconst_0
    //   82: anewarray 4	java/lang/Object
    //   85: invokevirtual 89	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore_1
    //   89: aload_1
    //   90: checkcast 2	com/google/android/gms/internal/measurement/zzjy
    //   93: astore_1
    //   94: aload_0
    //   95: aload_1
    //   96: invokevirtual 93	com/google/android/gms/internal/measurement/zzjy:substring	()Lcom/google/android/gms/internal/measurement/zzjq;
    //   99: invokevirtual 97	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore_1
    //   103: aload_1
    //   104: checkcast 54	com/google/android/gms/internal/measurement/zzjq
    //   107: areturn
    //   108: astore_1
    //   109: new 99	java/lang/IllegalStateException
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   117: astore_1
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: new 99	java/lang/IllegalStateException
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   129: astore_1
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: new 99	java/lang/IllegalStateException
    //   136: dup
    //   137: aload_1
    //   138: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   141: astore_1
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: new 99	java/lang/IllegalStateException
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   153: astore_1
    //   154: aload_1
    //   155: athrow
    //   156: ldc 2
    //   158: aload_2
    //   159: invokestatic 108	java/util/ServiceLoader:load	(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/ServiceLoader;
    //   162: invokevirtual 112	java/util/ServiceLoader:iterator	()Ljava/util/Iterator;
    //   165: astore_2
    //   166: new 114	java/util/ArrayList
    //   169: dup
    //   170: invokespecial 115	java/util/ArrayList:<init>	()V
    //   173: astore_1
    //   174: aload_2
    //   175: invokeinterface 121 1 0
    //   180: ifeq +58 -> 238
    //   183: aload_2
    //   184: invokeinterface 125 1 0
    //   189: astore_3
    //   190: aload_3
    //   191: checkcast 2	com/google/android/gms/internal/measurement/zzjy
    //   194: astore_3
    //   195: aload_1
    //   196: aload_0
    //   197: aload_3
    //   198: invokevirtual 93	com/google/android/gms/internal/measurement/zzjy:substring	()Lcom/google/android/gms/internal/measurement/zzjq;
    //   201: invokevirtual 97	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   204: invokevirtual 128	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: goto -34 -> 174
    //   211: astore_3
    //   212: getstatic 26	com/google/android/gms/internal/measurement/zzjy:log	Ljava/util/logging/Logger;
    //   215: getstatic 134	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   218: ldc -120
    //   220: ldc -119
    //   222: ldc -117
    //   224: aload_0
    //   225: invokevirtual 70	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   228: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   231: aload_3
    //   232: invokevirtual 147	java/util/logging/Logger:logp	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   235: goto -61 -> 174
    //   238: aload_1
    //   239: invokevirtual 151	java/util/ArrayList:size	()I
    //   242: iconst_1
    //   243: if_icmpne +12 -> 255
    //   246: aload_1
    //   247: iconst_0
    //   248: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   251: checkcast 54	com/google/android/gms/internal/measurement/zzjq
    //   254: areturn
    //   255: aload_1
    //   256: invokevirtual 151	java/util/ArrayList:size	()I
    //   259: ifne +5 -> 264
    //   262: aconst_null
    //   263: areturn
    //   264: aload_0
    //   265: ldc -99
    //   267: iconst_1
    //   268: anewarray 14	java/lang/Class
    //   271: dup
    //   272: iconst_0
    //   273: ldc -97
    //   275: aastore
    //   276: invokevirtual 163	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   279: astore_0
    //   280: aload_0
    //   281: aconst_null
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload_1
    //   289: aastore
    //   290: invokevirtual 169	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   293: astore_0
    //   294: aload_0
    //   295: checkcast 54	com/google/android/gms/internal/measurement/zzjq
    //   298: areturn
    //   299: astore_0
    //   300: new 99	java/lang/IllegalStateException
    //   303: dup
    //   304: aload_0
    //   305: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   308: athrow
    //   309: astore_0
    //   310: new 99	java/lang/IllegalStateException
    //   313: dup
    //   314: aload_0
    //   315: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   318: athrow
    //   319: astore_0
    //   320: new 99	java/lang/IllegalStateException
    //   323: dup
    //   324: aload_0
    //   325: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   328: athrow
    //   329: new 171	java/lang/IllegalArgumentException
    //   332: dup
    //   333: aload_0
    //   334: invokevirtual 18	java/lang/Class:getName	()Ljava/lang/String;
    //   337: invokespecial 174	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   340: athrow
    //   341: astore_1
    //   342: goto -186 -> 156
    //   345: astore_1
    //   346: goto -190 -> 156
    //   349: astore_1
    //   350: goto -194 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramClass	Class
    //   18	86	1	localObject1	Object
    //   108	6	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   117	2	1	localIllegalStateException1	IllegalStateException
    //   120	6	1	localIllegalAccessException	IllegalAccessException
    //   129	2	1	localIllegalStateException2	IllegalStateException
    //   132	6	1	localInstantiationException	InstantiationException
    //   141	2	1	localIllegalStateException3	IllegalStateException
    //   144	6	1	localNoSuchMethodException	NoSuchMethodException
    //   153	136	1	localObject2	Object
    //   341	1	1	localClassNotFoundException1	ClassNotFoundException
    //   345	1	1	localClassNotFoundException2	ClassNotFoundException
    //   349	1	1	localClassNotFoundException3	ClassNotFoundException
    //   5	179	2	localObject3	Object
    //   189	9	3	localObject4	Object
    //   211	21	3	localServiceConfigurationError	java.util.ServiceConfigurationError
    // Exception table:
    //   from	to	target	type
    //   71	80	108	java/lang/reflect/InvocationTargetException
    //   80	89	108	java/lang/reflect/InvocationTargetException
    //   71	80	120	java/lang/IllegalAccessException
    //   80	89	120	java/lang/IllegalAccessException
    //   71	80	132	java/lang/InstantiationException
    //   80	89	132	java/lang/InstantiationException
    //   71	80	144	java/lang/NoSuchMethodException
    //   80	89	144	java/lang/NoSuchMethodException
    //   183	190	211	java/util/ServiceConfigurationError
    //   195	208	211	java/util/ServiceConfigurationError
    //   264	280	299	java/lang/reflect/InvocationTargetException
    //   280	294	299	java/lang/reflect/InvocationTargetException
    //   264	280	309	java/lang/IllegalAccessException
    //   280	294	309	java/lang/IllegalAccessException
    //   264	280	319	java/lang/NoSuchMethodException
    //   280	294	319	java/lang/NoSuchMethodException
    //   64	71	341	java/lang/ClassNotFoundException
    //   71	80	345	java/lang/ClassNotFoundException
    //   80	89	345	java/lang/ClassNotFoundException
    //   94	103	349	java/lang/ClassNotFoundException
    //   109	118	349	java/lang/ClassNotFoundException
    //   121	130	349	java/lang/ClassNotFoundException
    //   133	142	349	java/lang/ClassNotFoundException
    //   145	154	349	java/lang/ClassNotFoundException
  }
  
  protected abstract zzjq substring();
}

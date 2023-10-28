package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class PathParser
{
  private static void addNode(ArrayList paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new PathDataNode(paramChar, paramArrayOfFloat));
  }
  
  public static boolean canMorph(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2)
  {
    if (paramArrayOfPathDataNode1 != null)
    {
      if (paramArrayOfPathDataNode2 == null) {
        return false;
      }
      if (paramArrayOfPathDataNode1.length != paramArrayOfPathDataNode2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfPathDataNode1.length) {
        if (type == type)
        {
          if (params.length != params.length) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  static float[] copyOfRange(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfFloat.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        float[] arrayOfFloat = new float[paramInt2];
        System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, i);
        return arrayOfFloat;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static PathDataNode[] createNodesFromPathData(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length())
    {
      j = nextStart(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = getFloats(str);
        addNode(localArrayList, str.charAt(0), arrayOfFloat);
      }
      i = j;
      j += 1;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      addNode(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (PathDataNode[])localArrayList.toArray(new PathDataNode[localArrayList.size()]);
  }
  
  public static Path createPathFromPathData(String paramString)
  {
    Path localPath = new Path();
    Object localObject = createNodesFromPathData(paramString);
    if (localObject != null) {
      try
      {
        PathDataNode.nodesToPath((PathDataNode[])localObject, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error in parsing ");
        ((StringBuilder)localObject).append(paramString);
        throw new RuntimeException(((StringBuilder)localObject).toString(), localRuntimeException);
      }
    }
    return null;
  }
  
  public static PathDataNode[] deepCopyNodes(PathDataNode[] paramArrayOfPathDataNode)
  {
    if (paramArrayOfPathDataNode == null) {
      return null;
    }
    PathDataNode[] arrayOfPathDataNode = new PathDataNode[paramArrayOfPathDataNode.length];
    int i = 0;
    while (i < paramArrayOfPathDataNode.length)
    {
      arrayOfPathDataNode[i] = new PathDataNode(paramArrayOfPathDataNode[i]);
      i += 1;
    }
    return arrayOfPathDataNode;
  }
  
  private static void extract(String paramString, int paramInt, ExtractFloatResult paramExtractFloatResult)
  {
    mEndWithNegOrDot = false;
    int j = paramInt;
    int i = 0;
    int m = 0;
    int k = 0;
    while (j < paramString.length())
    {
      int n = paramString.charAt(j);
      if (n != 32)
      {
        if ((n != 69) && (n != 101)) {}
        switch (n)
        {
        default: 
          break;
        case 46: 
          if (m == 0)
          {
            i = 0;
            m = 1;
            break label152;
          }
          mEndWithNegOrDot = true;
          break;
        case 45: 
          if ((j != paramInt) && (i == 0))
          {
            mEndWithNegOrDot = true;
          }
          else
          {
            i = 0;
            break label152;
            i = 1;
          }
          break;
        }
      }
      i = 0;
      k = 1;
      label152:
      if (k != 0) {
        break;
      }
      j += 1;
    }
    mEndPosition = j;
  }
  
  private static float[] getFloats(String paramString)
  {
    if ((paramString.charAt(0) != 'z') && (paramString.charAt(0) != 'Z')) {
      try
      {
        int i = paramString.length();
        float[] arrayOfFloat = new float[i];
        localObject = new ExtractFloatResult();
        int n = paramString.length();
        i = 1;
        int k = 0;
        while (i < n)
        {
          extract(paramString, i, (ExtractFloatResult)localObject);
          int m = mEndPosition;
          int j = k;
          if (i < m)
          {
            float f = Float.parseFloat(paramString.substring(i, m));
            arrayOfFloat[k] = f;
            j = k + 1;
          }
          if (mEndWithNegOrDot)
          {
            i = m;
            k = j;
          }
          else
          {
            i = m + 1;
            k = j;
          }
        }
        arrayOfFloat = copyOfRange(arrayOfFloat, 0, k);
        return arrayOfFloat;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error in parsing \"");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\"");
        throw new RuntimeException(((StringBuilder)localObject).toString(), localNumberFormatException);
      }
    }
    return new float[0];
  }
  
  private static int nextStart(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((((i - 65) * (i - 90) <= 0) || ((i - 97) * (i - 122) <= 0)) && (i != 101) && (i != 69)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static void updateNodes(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2)
  {
    int i = 0;
    while (i < paramArrayOfPathDataNode2.length)
    {
      type = type;
      int j = 0;
      while (j < params.length)
      {
        params[j] = params[j];
        j += 1;
      }
      i += 1;
    }
  }
  
  class ExtractFloatResult
  {
    int mEndPosition;
    boolean mEndWithNegOrDot;
    
    ExtractFloatResult() {}
  }
  
  public class PathDataNode
  {
    public float[] params;
    public char type;
    
    PathDataNode(float[] paramArrayOfFloat)
    {
      type = this$1;
      params = paramArrayOfFloat;
    }
    
    PathDataNode()
    {
      type = type;
      this$1 = params;
      params = PathParser.copyOfRange(this$1, 0, this$1.length);
    }
    
    private static void addCommand(Path paramPath, float[] paramArrayOfFloat1, char paramChar1, char paramChar2, float[] paramArrayOfFloat2)
    {
      float f7 = paramArrayOfFloat1[0];
      float f8 = paramArrayOfFloat1[1];
      float f9 = paramArrayOfFloat1[2];
      float f10 = paramArrayOfFloat1[3];
      float f1 = paramArrayOfFloat1[4];
      float f2 = paramArrayOfFloat1[5];
      float f5 = f7;
      float f6 = f8;
      float f3 = f9;
      float f4 = f10;
      switch (paramChar2)
      {
      default: 
        f5 = f7;
        f6 = f8;
        f3 = f9;
        f4 = f10;
        break;
      case 'L': 
      case 'M': 
      case 'T': 
      case 'l': 
      case 'm': 
      case 't': 
      case 'Z': 
      case 'z': 
        for (;;)
        {
          c1 = '\002';
          break;
          paramPath.close();
          paramPath.moveTo(f1, f2);
          f5 = f1;
          f3 = f1;
          f6 = f2;
          f4 = f2;
        }
      case 'Q': 
      case 'S': 
      case 'q': 
      case 's': 
        c1 = '\004';
        f5 = f7;
        f6 = f8;
        f3 = f9;
        f4 = f10;
        break;
      case 'H': 
      case 'V': 
      case 'h': 
      case 'v': 
        c1 = '\001';
        f5 = f7;
        f6 = f8;
        f3 = f9;
        f4 = f10;
        break;
      case 'C': 
      case 'c': 
        c1 = '\006';
        f5 = f7;
        f6 = f8;
        f3 = f9;
        f4 = f10;
        break;
      }
      char c1 = '\007';
      f4 = f10;
      f3 = f9;
      f6 = f8;
      f5 = f7;
      char c2 = '\000';
      int i = paramChar1;
      paramChar1 = c2;
      f7 = f2;
      f8 = f1;
      f2 = f6;
      f1 = f5;
      for (;;)
      {
        c2 = paramChar2;
        if (paramChar1 >= paramArrayOfFloat2.length) {
          break;
        }
        label1250:
        label1568:
        label1575:
        boolean bool1;
        boolean bool2;
        if (c2 != 'A')
        {
          int j;
          int k;
          if (c2 != 'C')
          {
            if (c2 != 'H')
            {
              if (c2 != 'Q')
              {
                if (c2 != 'V')
                {
                  if (c2 != 'a')
                  {
                    if (c2 != 'c') {
                      if (c2 != 'h') {
                        if (c2 != 'q') {
                          if (c2 != 'v') {
                            if (c2 != 'L') {
                              if (c2 != 'M') {
                                if (c2 != 'S') {
                                  if (c2 != 'T') {
                                    if (c2 != 'l') {
                                      if (c2 != 'm') {
                                        if (c2 != 's') {
                                          if (c2 != 't') {
                                            break label2097;
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
                    for (;;)
                    {
                      if ((i != 113) && (i != 116) && (i != 81) && (i != 84))
                      {
                        f3 = 0.0F;
                        f4 = 0.0F;
                      }
                      else
                      {
                        f5 = f1 - f3;
                        f3 = f2 - f4;
                        f4 = f5;
                      }
                      i = paramChar1 + '\000';
                      f5 = paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      paramPath.rQuadTo(f4, f3, f5, paramArrayOfFloat2[c2]);
                      f4 += f1;
                      f5 = f3 + f2;
                      f1 += paramArrayOfFloat2[i];
                      f2 += paramArrayOfFloat2[c2];
                      f3 = f4;
                      f4 = f5;
                      continue;
                      if ((i != 99) && (i != 115) && (i != 67) && (i != 83))
                      {
                        f3 = 0.0F;
                        f4 = 0.0F;
                      }
                      else
                      {
                        f4 = f2 - f4;
                        f3 = f1 - f3;
                      }
                      i = paramChar1 + '\000';
                      f5 = paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      f6 = paramArrayOfFloat2[c2];
                      j = paramChar1 + '\002';
                      f9 = paramArrayOfFloat2[j];
                      k = paramChar1 + '\003';
                      paramPath.rCubicTo(f3, f4, f5, f6, f9, paramArrayOfFloat2[k]);
                      f3 = paramArrayOfFloat2[i] + f1;
                      f4 = paramArrayOfFloat2[c2] + f2;
                      f1 += paramArrayOfFloat2[j];
                      f5 = paramArrayOfFloat2[k];
                      break label1568;
                      i = paramChar1 + '\000';
                      f1 += paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      f2 += paramArrayOfFloat2[c2];
                      if (paramChar1 > 0)
                      {
                        paramPath.rLineTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                      }
                      else
                      {
                        paramPath.rMoveTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                        break label1250;
                        i = paramChar1 + '\000';
                        f5 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        paramPath.rLineTo(f5, paramArrayOfFloat2[c2]);
                        f1 += paramArrayOfFloat2[i];
                        for (f5 = paramArrayOfFloat2[c2];; f5 = paramArrayOfFloat2[i])
                        {
                          f2 += f5;
                          break;
                          if ((i != 113) && (i != 116) && (i != 81))
                          {
                            f5 = f1;
                            f6 = f2;
                            if (i != 84) {}
                          }
                          else
                          {
                            f5 = f1 * 2.0F - f3;
                            f6 = f2 * 2.0F - f4;
                          }
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          paramPath.quadTo(f5, f6, f1, paramArrayOfFloat2[c2]);
                          f1 = paramArrayOfFloat2[i];
                          f4 = f6;
                          f3 = f5;
                          f2 = paramArrayOfFloat2[c2];
                          break;
                          if ((i != 99) && (i != 115) && (i != 67))
                          {
                            f6 = f1;
                            f5 = f2;
                            if (i != 83) {}
                          }
                          else
                          {
                            f6 = f1 * 2.0F - f3;
                            f5 = f2 * 2.0F - f4;
                          }
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          f2 = paramArrayOfFloat2[c2];
                          j = paramChar1 + '\002';
                          f3 = paramArrayOfFloat2[j];
                          k = paramChar1 + '\003';
                          paramPath.cubicTo(f6, f5, f1, f2, f3, paramArrayOfFloat2[k]);
                          f3 = paramArrayOfFloat2[i];
                          f4 = paramArrayOfFloat2[c2];
                          f1 = paramArrayOfFloat2[j];
                          f2 = paramArrayOfFloat2[k];
                          break label1575;
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          f2 = paramArrayOfFloat2[c2];
                          if (paramChar1 > 0)
                          {
                            paramPath.lineTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                            break;
                          }
                          paramPath.moveTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                          f7 = f2;
                          f8 = f1;
                          break;
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          paramPath.lineTo(f1, paramArrayOfFloat2[c2]);
                          f1 = paramArrayOfFloat2[i];
                          f2 = paramArrayOfFloat2[c2];
                          break;
                          i = paramChar1 + '\000';
                          paramPath.rLineTo(0.0F, paramArrayOfFloat2[i]);
                        }
                        i = paramChar1 + '\000';
                        f3 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        f4 = paramArrayOfFloat2[c2];
                        j = paramChar1 + '\002';
                        f5 = paramArrayOfFloat2[j];
                        k = paramChar1 + '\003';
                        paramPath.rQuadTo(f3, f4, f5, paramArrayOfFloat2[k]);
                        f3 = paramArrayOfFloat2[i] + f1;
                        f4 = paramArrayOfFloat2[c2] + f2;
                        f1 += paramArrayOfFloat2[j];
                        f5 = paramArrayOfFloat2[k];
                        break label1568;
                        i = paramChar1 + '\000';
                        paramPath.rLineTo(paramArrayOfFloat2[i], 0.0F);
                        f1 += paramArrayOfFloat2[i];
                        continue;
                        f3 = paramArrayOfFloat2[(paramChar1 + '\000')];
                        f4 = paramArrayOfFloat2[(paramChar1 + '\001')];
                        i = paramChar1 + '\002';
                        f5 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\003';
                        f6 = paramArrayOfFloat2[c2];
                        j = paramChar1 + '\004';
                        f9 = paramArrayOfFloat2[j];
                        k = paramChar1 + '\005';
                        paramPath.rCubicTo(f3, f4, f5, f6, f9, paramArrayOfFloat2[k]);
                        f3 = paramArrayOfFloat2[i] + f1;
                        f4 = paramArrayOfFloat2[c2] + f2;
                        f1 += paramArrayOfFloat2[j];
                        f5 = paramArrayOfFloat2[k];
                        f2 += f5;
                      }
                    }
                  }
                  i = paramChar1 + '\005';
                  f3 = paramArrayOfFloat2[i];
                  c2 = paramChar1 + '\006';
                  f4 = paramArrayOfFloat2[c2];
                  f5 = paramArrayOfFloat2[(paramChar1 + '\000')];
                  f6 = paramArrayOfFloat2[(paramChar1 + '\001')];
                  f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
                  if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  }
                  if (paramArrayOfFloat2[(paramChar1 + '\004')] != 0.0F) {
                    bool2 = true;
                  } else {
                    bool2 = false;
                  }
                  drawArc(paramPath, f1, f2, f3 + f1, f4 + f2, f5, f6, f9, bool1, bool2);
                  f1 += paramArrayOfFloat2[i];
                  f2 += paramArrayOfFloat2[c2];
                }
                else
                {
                  i = paramChar1 + '\000';
                  paramPath.lineTo(f1, paramArrayOfFloat2[i]);
                  f2 = paramArrayOfFloat2[i];
                  break label2097;
                }
              }
              else
              {
                i = paramChar1 + '\000';
                f1 = paramArrayOfFloat2[i];
                c2 = paramChar1 + '\001';
                f2 = paramArrayOfFloat2[c2];
                j = paramChar1 + '\002';
                f3 = paramArrayOfFloat2[j];
                k = paramChar1 + '\003';
                paramPath.quadTo(f1, f2, f3, paramArrayOfFloat2[k]);
                f1 = paramArrayOfFloat2[j];
                f2 = paramArrayOfFloat2[k];
                f3 = paramArrayOfFloat2[i];
                f4 = paramArrayOfFloat2[c2];
                break label2097;
              }
            }
            else
            {
              i = paramChar1 + '\000';
              paramPath.lineTo(paramArrayOfFloat2[i], f2);
              f1 = paramArrayOfFloat2[i];
              break label2097;
            }
          }
          else
          {
            f1 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f2 = paramArrayOfFloat2[(paramChar1 + '\001')];
            i = paramChar1 + '\002';
            f3 = paramArrayOfFloat2[i];
            c2 = paramChar1 + '\003';
            f4 = paramArrayOfFloat2[c2];
            j = paramChar1 + '\004';
            f5 = paramArrayOfFloat2[j];
            k = paramChar1 + '\005';
            paramPath.cubicTo(f1, f2, f3, f4, f5, paramArrayOfFloat2[k]);
            f1 = paramArrayOfFloat2[j];
            f2 = paramArrayOfFloat2[k];
            f4 = paramArrayOfFloat2[c2];
            f3 = paramArrayOfFloat2[i];
            break label2097;
          }
        }
        else
        {
          i = paramChar1 + '\005';
          f3 = paramArrayOfFloat2[i];
          c2 = paramChar1 + '\006';
          f4 = paramArrayOfFloat2[c2];
          f5 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f6 = paramArrayOfFloat2[(paramChar1 + '\001')];
          f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
          if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (paramArrayOfFloat2[(paramChar1 + '\004')] != 0.0F) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          drawArc(paramPath, f1, f2, f3, f4, f5, f6, f9, bool1, bool2);
          f1 = paramArrayOfFloat2[i];
          f2 = paramArrayOfFloat2[c2];
        }
        f4 = f2;
        f3 = f1;
        label2097:
        paramChar1 += c1;
        i = paramChar2;
      }
      paramArrayOfFloat1[0] = f1;
      paramArrayOfFloat1[1] = f2;
      paramArrayOfFloat1[2] = f3;
      paramArrayOfFloat1[3] = f4;
      paramArrayOfFloat1[4] = f8;
      paramArrayOfFloat1[5] = f7;
    }
    
    private static void arcToBezier(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
    {
      int j = (int)Math.ceil(Math.abs(paramDouble9 * 4.0D / 3.141592653589793D));
      double d5 = Math.cos(paramDouble7);
      double d6 = Math.sin(paramDouble7);
      paramDouble7 = Math.cos(paramDouble8);
      double d1 = Math.sin(paramDouble8);
      double d2 = -paramDouble3;
      double d7 = d2 * d5;
      double d8 = paramDouble4 * d6;
      double d9 = d2 * d6;
      double d10 = paramDouble4 * d5;
      double d11 = paramDouble9 / j;
      paramDouble4 = d1 * d9 + paramDouble7 * d10;
      paramDouble9 = d7 * d1 - d8 * paramDouble7;
      int i = 0;
      paramDouble7 = paramDouble6;
      paramDouble6 = paramDouble5;
      paramDouble5 = paramDouble9;
      for (;;)
      {
        paramDouble9 = paramDouble3;
        if (i >= j) {
          break;
        }
        d2 = paramDouble8 + d11;
        double d4 = Math.sin(d2);
        double d12 = Math.cos(d2);
        double d3 = paramDouble1 + paramDouble9 * d5 * d12 - d8 * d4;
        paramDouble9 = paramDouble2 + paramDouble9 * d6 * d12 + d10 * d4;
        d1 = d7 * d4 - d8 * d12;
        d4 = d4 * d9 + d12 * d10;
        paramDouble8 = d2 - paramDouble8;
        d12 = Math.tan(paramDouble8 / 2.0D);
        paramDouble8 = Math.sin(paramDouble8) * (Math.sqrt(d12 * 3.0D * d12 + 4.0D) - 1.0D) / 3.0D;
        paramPath.rLineTo(0.0F, 0.0F);
        paramPath.cubicTo((float)(paramDouble6 + paramDouble5 * paramDouble8), (float)(paramDouble7 + paramDouble4 * paramDouble8), (float)(d3 - paramDouble8 * d1), (float)(paramDouble9 - paramDouble8 * d4), (float)d3, (float)paramDouble9);
        i += 1;
        paramDouble6 = d3;
        paramDouble8 = d2;
        paramDouble4 = d4;
        paramDouble5 = d1;
        paramDouble7 = paramDouble9;
      }
    }
    
    private static void drawArc(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
    {
      double d5 = Math.toRadians(paramFloat7);
      double d6 = Math.cos(d5);
      double d7 = Math.sin(d5);
      double d8 = paramFloat1;
      double d9 = paramFloat2;
      double d10 = paramFloat5;
      double d1 = (d8 * d6 + d9 * d7) / d10;
      double d2 = -paramFloat1;
      double d11 = paramFloat6;
      double d4 = (d2 * d7 + d9 * d6) / d11;
      double d3 = paramFloat3;
      d2 = paramFloat4;
      double d12 = (d3 * d6 + d2 * d7) / d10;
      double d13 = (-paramFloat3 * d7 + d2 * d6) / d11;
      double d15 = d1 - d12;
      double d14 = d4 - d13;
      d3 = (d1 + d12) / 2.0D;
      d2 = (d4 + d13) / 2.0D;
      double d16 = d15 * d15 + d14 * d14;
      if (d16 == 0.0D)
      {
        Log.w("PathParser", " Points are coincident");
        return;
      }
      double d17 = 1.0D / d16 - 0.25D;
      if (d17 < 0.0D)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Points are too far apart ");
        localStringBuilder.append(d16);
        Log.w("PathParser", localStringBuilder.toString());
        float f = (float)(Math.sqrt(d16) / 1.99999D);
        drawArc(paramPath, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5 * f, paramFloat6 * f, paramFloat7, paramBoolean1, paramBoolean2);
        return;
      }
      d16 = Math.sqrt(d17);
      d15 *= d16;
      d14 = d16 * d14;
      if (paramBoolean1 == paramBoolean2)
      {
        d3 -= d14;
        d2 += d15;
      }
      else
      {
        d3 += d14;
        d2 -= d15;
      }
      d14 = Math.atan2(d4 - d2, d1 - d3);
      d4 = Math.atan2(d13 - d2, d12 - d3) - d14;
      boolean bool = d4 < 0.0D;
      if (!bool) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      d1 = d4;
      if (paramBoolean2 != paramBoolean1) {
        if (bool) {
          d1 = d4 - 6.283185307179586D;
        } else {
          d1 = d4 + 6.283185307179586D;
        }
      }
      d3 *= d10;
      d2 *= d11;
      arcToBezier(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, d10, d11, d8, d9, d5, d14, d1);
    }
    
    public static void nodesToPath(PathDataNode[] paramArrayOfPathDataNode, Path paramPath)
    {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      int i = 0;
      while (i < paramArrayOfPathDataNode.length)
      {
        addCommand(paramPath, arrayOfFloat, c, type, params);
        c = type;
        i += 1;
      }
    }
    
    public void interpolatePathDataNode(PathDataNode paramPathDataNode1, PathDataNode paramPathDataNode2, float paramFloat)
    {
      type = type;
      int i = 0;
      for (;;)
      {
        float[] arrayOfFloat = params;
        if (i >= arrayOfFloat.length) {
          break;
        }
        params[i] = (arrayOfFloat[i] * (1.0F - paramFloat) + params[i] * paramFloat);
        i += 1;
      }
    }
  }
}

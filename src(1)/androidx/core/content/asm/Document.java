package androidx.core.content.asm;

import java.util.List;

final class Document
{
  final int[] array;
  final float[] pos;
  
  Document(int paramInt1, int paramInt2)
  {
    array = new int[] { paramInt1, paramInt2 };
    pos = new float[] { 0.0F, 1.0F };
  }
  
  Document(int paramInt1, int paramInt2, int paramInt3)
  {
    array = new int[] { paramInt1, paramInt2, paramInt3 };
    pos = new float[] { 0.0F, 0.5F, 1.0F };
  }
  
  Document(List paramList1, List paramList2)
  {
    int j = paramList1.size();
    array = new int[j];
    pos = new float[j];
    int i = 0;
    while (i < j)
    {
      array[i] = ((Integer)paramList1.get(i)).intValue();
      pos[i] = ((Float)paramList2.get(i)).floatValue();
      i += 1;
    }
  }
}

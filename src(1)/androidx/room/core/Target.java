package androidx.room.core;

import androidx.room.q.f.c;

class Target
  implements Comparable<f.c>
{
  final int length;
  final int location;
  final String name;
  final String values;
  
  Target(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    length = paramInt1;
    location = paramInt2;
    name = paramString1;
    values = paramString2;
  }
  
  public int compareTo(Target paramTarget)
  {
    int j = length - length;
    int i = j;
    if (j == 0) {
      i = location - location;
    }
    return i;
  }
}

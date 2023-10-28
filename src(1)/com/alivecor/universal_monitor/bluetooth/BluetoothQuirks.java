package com.alivecor.universal_monitor.bluetooth;

import android.os.Build;
import java.util.HashSet;
import java.util.Set;
import org.objectweb.asm.MethodWriter;

public class BluetoothQuirks
{
  private static final Set<String> NEED_NEW_BOND_BOARDS;
  public static final String PIXEL_1_BOARD = "sailfish";
  public static final String PIXEL_1_XL_BOARD = "marlin";
  
  static
  {
    HashSet localHashSet = new HashSet();
    NEED_NEW_BOND_BOARDS = localHashSet;
    localHashSet.add("marlin");
    localHashSet.add("sailfish");
  }
  
  public BluetoothQuirks() {}
  
  public static boolean deleteBondEveryTime()
  {
    boolean bool = NEED_NEW_BOND_BOARDS.contains(Build.BOARD);
    MethodWriter.a("deleteBondEveryTime: %s needs?", Build.BOARD, new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
}

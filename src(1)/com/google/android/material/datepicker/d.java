package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.BaseBundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.l;
import androidx.fragment.package_11.DialogFragment;
import androidx.fragment.package_11.Fragment;
import androidx.fragment.package_11.FragmentManager;
import androidx.fragment.package_11.Item;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.drawable;
import org.org.org.ui.R.id;
import org.org.org.ui.R.raw;
import org.org.org.ui.R.string;
import org.org.org.ui.Switch;
import org.org.org.ui.action.MainMenu.1;
import v7.v7.package_13.ViewCompat;

public final class d<S>
  extends l
{
  static final Object k = "CANCEL_BUTTON_TAG";
  static final Object o = "CONFIRM_BUTTON_TAG";
  static final Object s = "TOGGLE_BUTTON_TAG";
  private TextView B;
  private int a;
  private CheckableImageButton b;
  private DateSelector<S> c;
  private CalendarConstraints d;
  private final LinkedHashSet<DialogInterface.OnDismissListener> f = new LinkedHashSet();
  private final LinkedHashSet<View.OnClickListener> h = new LinkedHashSet();
  private Button l;
  private final LinkedHashSet<f<? super S>> mSelectedItemsPositions = new LinkedHashSet();
  private MaterialCalendar<S> n;
  private final LinkedHashSet<DialogInterface.OnCancelListener> p = new LinkedHashSet();
  private k<S> r;
  private org.org.org.ui.asm.f this$0;
  private CharSequence title;
  private int v;
  private int x;
  private boolean y;
  
  public d() {}
  
  private void a()
  {
    String str = e();
    B.setContentDescription(String.format(getString(Switch.A), new Object[] { str }));
    B.setText(str);
  }
  
  private void a(CheckableImageButton paramCheckableImageButton)
  {
    if (b.isChecked()) {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(Switch.t);
    } else {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(Switch.g);
    }
    b.setContentDescription(paramCheckableImageButton);
  }
  
  static boolean a(Context paramContext)
  {
    return a(paramContext, 16843277);
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(org.org.org.ui.menu.Label.a(paramContext, ClassWriter.d, MaterialCalendar.class.getCanonicalName()), new int[] { paramInt });
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    return bool;
  }
  
  private static int b(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getDimensionPixelSize(R.raw.i);
    int j = paramContext.getDimensionPixelOffset(R.raw.h);
    int m = paramContext.getDimensionPixelOffset(R.raw.w);
    int i1 = paramContext.getDimensionPixelSize(R.raw.m);
    int i2 = h.b;
    return i + j + m + i1 + (paramContext.getDimensionPixelSize(R.raw.a) * i2 + (i2 - 1) * paramContext.getDimensionPixelOffset(R.raw.k)) + paramContext.getDimensionPixelOffset(R.raw.o);
  }
  
  static boolean d(Context paramContext)
  {
    return a(paramContext, ClassWriter.p);
  }
  
  private int f(Context paramContext)
  {
    int i = v;
    if (i != 0) {
      return i;
    }
    return c.add(paramContext);
  }
  
  private static Drawable getDrawable(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = v7.internal.transition.util.View.getDrawable(paramContext, R.drawable.abc_cab_background_top_material);
    localStateListDrawable.addState(new int[] { 16842912 }, localDrawable);
    paramContext = v7.internal.transition.util.View.getDrawable(paramContext, R.drawable.abc_cab_background_internal_bg);
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  private static int init(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getDimensionPixelOffset(R.raw.q);
    int j = nextb;
    return i * 2 + paramContext.getDimensionPixelSize(R.raw.j) * j + (j - 1) * paramContext.getDimensionPixelOffset(R.raw.g);
  }
  
  private void onCreate()
  {
    int i = f(requireContext());
    n = MaterialCalendar.a(c, i, d);
    if (b.isChecked()) {
      localObject = e.a(c, i, d);
    } else {
      localObject = n;
    }
    r = ((Label)localObject);
    a();
    Object localObject = getChildFragmentManager().beginTransaction();
    ((Item)localObject).add(R.id.d, r);
    ((Item)localObject).add();
    r.a(new b(this));
  }
  
  private void onCreateView(Context paramContext)
  {
    b.setTag(s);
    b.setImageDrawable(getDrawable(paramContext));
    paramContext = b;
    boolean bool;
    if (x != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.setChecked(bool);
    ViewCompat.a(b, null);
    a(b);
    b.setOnClickListener(new AbstractFilePickerFragment.2(this));
  }
  
  public final Object add()
  {
    return c.a();
  }
  
  public String e()
  {
    return c.toString(getContext());
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    Iterator localIterator = p.iterator();
    while (localIterator.hasNext()) {
      ((DialogInterface.OnCancelListener)localIterator.next()).onCancel(paramDialogInterface);
    }
    super.onCancel(paramDialogInterface);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    v = localBundle.getInt("OVERRIDE_THEME_RES_ID");
    c = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    d = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    a = localBundle.getInt("TITLE_TEXT_RES_ID_KEY");
    title = localBundle.getCharSequence("TITLE_TEXT_KEY");
    x = localBundle.getInt("INPUT_MODE_KEY");
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new Dialog(requireContext(), f(requireContext()));
    Context localContext = paramBundle.getContext();
    y = a(localContext);
    int i = org.org.org.ui.menu.Label.a(localContext, ClassWriter.a, e.class.getCanonicalName());
    org.org.org.ui.asm.f localF = new org.org.org.ui.asm.f(localContext, null, ClassWriter.d, R.string.text);
    this$0 = localF;
    localF.d(localContext);
    this$0.setColor(ColorStateList.valueOf(i));
    this$0.add(ViewCompat.getElevation(paramBundle.getWindow().getDecorView()));
    return paramBundle;
  }
  
  public final android.view.View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i;
    if (y) {
      i = org.org.org.ui.h.a;
    } else {
      i = org.org.org.ui.h.l;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup);
    paramViewGroup = paramLayoutInflater.getContext();
    if (y)
    {
      paramLayoutInflater.findViewById(R.id.d).setLayoutParams(new LinearLayout.LayoutParams(init(paramViewGroup), -2));
    }
    else
    {
      paramBundle = paramLayoutInflater.findViewById(R.id.b);
      localObject = paramLayoutInflater.findViewById(R.id.d);
      paramBundle.setLayoutParams(new LinearLayout.LayoutParams(init(paramViewGroup), -1));
      ((android.view.View)localObject).setMinimumHeight(b(requireContext()));
    }
    paramBundle = (TextView)paramLayoutInflater.findViewById(R.id.settings);
    B = paramBundle;
    ViewCompat.setBackground(paramBundle, 1);
    b = ((CheckableImageButton)paramLayoutInflater.findViewById(R.id.list));
    paramBundle = (TextView)paramLayoutInflater.findViewById(R.id.text);
    Object localObject = title;
    if (localObject != null) {
      paramBundle.setText((CharSequence)localObject);
    } else {
      paramBundle.setText(a);
    }
    onCreateView(paramViewGroup);
    l = ((Button)paramLayoutInflater.findViewById(R.id.header));
    if (c.booleanValue()) {
      l.setEnabled(true);
    } else {
      l.setEnabled(false);
    }
    l.setTag(o);
    l.setOnClickListener(new DashboardFragment.3(this));
    paramViewGroup = (Button)paramLayoutInflater.findViewById(R.id.a);
    paramViewGroup.setTag(k);
    paramViewGroup.setOnClickListener(new DashboardFragment.2(this));
    return paramLayoutInflater;
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject = f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((DialogInterface.OnDismissListener)((Iterator)localObject).next()).onDismiss(paramDialogInterface);
    }
    localObject = (ViewGroup)getView();
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViews();
    }
    super.onDismiss(paramDialogInterface);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("OVERRIDE_THEME_RES_ID", v);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", c);
    CalendarConstraints.b localB = new CalendarConstraints.b(d);
    if (n.a() != null) {
      localB.a(n.a().d);
    }
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", localB.a());
    paramBundle.putInt("TITLE_TEXT_RES_ID_KEY", a);
    paramBundle.putCharSequence("TITLE_TEXT_KEY", title);
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = requireDialog().getWindow();
    if (y)
    {
      localWindow.setLayout(-1, -1);
      localWindow.setBackgroundDrawable(this$0);
    }
    else
    {
      localWindow.setLayout(-2, -2);
      int i = getResources().getDimensionPixelOffset(R.raw.predefmaps);
      Rect localRect = new Rect(i, i, i, i);
      localWindow.setBackgroundDrawable(new InsetDrawable(this$0, i, i, i, i));
      localWindow.getDecorView().setOnTouchListener(new MainMenu.1(requireDialog(), localRect));
    }
    onCreate();
  }
  
  public void onStop()
  {
    r.b();
    super.onStop();
  }
}

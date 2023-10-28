package androidx.appcompat.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsSpinner;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDialog;
import v7.internal.R.attr;
import v7.v7.package_13.TintableBackgroundView;
import v7.v7.package_13.ViewCompat;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  private static final int[] ATTRS_ANDROID_SPINNERMODE = { 16843505 };
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  int mDropDownWidth;
  private ListPopupWindow.ForwardingListener mForwardingListener;
  private i mPopup;
  private final android.content.Context mPopupContext;
  private final boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  final Rect mTempRect;
  
  public AppCompatSpinner(android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.metrics);
  }
  
  public AppCompatSpinner(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 87	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 89	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 91	android/graphics/Rect:<init>	()V
    //   15: putfield 93	androidx/appcompat/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 99	android/view/View:getContext	()Landroid/content/Context;
    //   23: invokestatic 105	androidx/appcompat/widget/ThemeUtils:a	(Landroid/view/View;Landroid/content/Context;)V
    //   26: aload_1
    //   27: aload_2
    //   28: getstatic 110	v7/internal/R$styleable:Spinner	[I
    //   31: iload_3
    //   32: iconst_0
    //   33: invokestatic 116	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   36: astore 10
    //   38: aload_0
    //   39: new 118	androidx/appcompat/widget/AppCompatBackgroundHelper
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 121	androidx/appcompat/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   47: putfield 123	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   50: aload 5
    //   52: ifnull +20 -> 72
    //   55: aload_0
    //   56: new 125	v7/internal/view/ContextThemeWrapper
    //   59: dup
    //   60: aload_1
    //   61: aload 5
    //   63: invokespecial 128	v7/internal/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   66: putfield 130	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   69: goto +41 -> 110
    //   72: aload 10
    //   74: getstatic 133	v7/internal/R$styleable:TextInputLayout_errorTextAppearance	I
    //   77: iconst_0
    //   78: invokevirtual 137	androidx/appcompat/widget/TintTypedArray:getResourceId	(II)I
    //   81: istore 6
    //   83: iload 6
    //   85: ifeq +20 -> 105
    //   88: aload_0
    //   89: new 125	v7/internal/view/ContextThemeWrapper
    //   92: dup
    //   93: aload_1
    //   94: iload 6
    //   96: invokespecial 140	v7/internal/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   99: putfield 130	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   102: goto +8 -> 110
    //   105: aload_0
    //   106: aload_1
    //   107: putfield 130	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   110: aconst_null
    //   111: astore 8
    //   113: iload 4
    //   115: istore 6
    //   117: iload 4
    //   119: iconst_m1
    //   120: if_icmpne +134 -> 254
    //   123: getstatic 65	androidx/appcompat/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   126: astore 5
    //   128: aload_1
    //   129: aload_2
    //   130: aload 5
    //   132: iload_3
    //   133: iconst_0
    //   134: invokevirtual 145	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   137: astore 9
    //   139: aload 9
    //   141: astore 5
    //   143: aload 5
    //   145: astore 8
    //   147: aload 9
    //   149: iconst_0
    //   150: invokevirtual 151	android/content/res/TypedArray:hasValue	(I)Z
    //   153: istore 7
    //   155: aload 5
    //   157: astore 8
    //   159: iload 4
    //   161: istore 6
    //   163: iload 7
    //   165: ifeq +20 -> 185
    //   168: aload 5
    //   170: astore 8
    //   172: aload 9
    //   174: iconst_0
    //   175: iconst_0
    //   176: invokevirtual 154	android/content/res/TypedArray:getInt	(II)I
    //   179: istore 6
    //   181: aload 5
    //   183: astore 8
    //   185: aload 8
    //   187: invokevirtual 157	android/content/res/TypedArray:recycle	()V
    //   190: goto +64 -> 254
    //   193: astore 9
    //   195: goto +12 -> 207
    //   198: astore_1
    //   199: goto +43 -> 242
    //   202: astore 9
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 5
    //   209: astore 8
    //   211: ldc -97
    //   213: ldc -95
    //   215: aload 9
    //   217: invokestatic 166	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   220: pop
    //   221: iload 4
    //   223: istore 6
    //   225: aload 5
    //   227: ifnull +27 -> 254
    //   230: aload 5
    //   232: astore 8
    //   234: iload 4
    //   236: istore 6
    //   238: goto -53 -> 185
    //   241: astore_1
    //   242: aload 8
    //   244: ifnull +8 -> 252
    //   247: aload 8
    //   249: invokevirtual 157	android/content/res/TypedArray:recycle	()V
    //   252: aload_1
    //   253: athrow
    //   254: iload 6
    //   256: ifeq +112 -> 368
    //   259: iload 6
    //   261: iconst_1
    //   262: if_icmpeq +6 -> 268
    //   265: goto +134 -> 399
    //   268: new 32	androidx/appcompat/widget/AppCompatSpinner$h
    //   271: dup
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 130	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   277: aload_2
    //   278: iload_3
    //   279: invokespecial 169	androidx/appcompat/widget/AppCompatSpinner$h:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   282: astore 5
    //   284: aload_0
    //   285: getfield 130	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   288: aload_2
    //   289: getstatic 110	v7/internal/R$styleable:Spinner	[I
    //   292: iload_3
    //   293: iconst_0
    //   294: invokestatic 116	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   297: astore 8
    //   299: aload_0
    //   300: aload 8
    //   302: getstatic 172	v7/internal/R$styleable:SherlockActionBar_height	I
    //   305: bipush -2
    //   307: invokevirtual 175	androidx/appcompat/widget/TintTypedArray:getLayoutDimension	(II)I
    //   310: putfield 177	androidx/appcompat/widget/AppCompatSpinner:mDropDownWidth	I
    //   313: aload 5
    //   315: aload 8
    //   317: getstatic 180	v7/internal/R$styleable:CirclePageIndicator_android_background	I
    //   320: invokevirtual 184	androidx/appcompat/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   323: invokevirtual 190	androidx/appcompat/widget/ListPopupWindow:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   326: aload 5
    //   328: aload 10
    //   330: getstatic 193	v7/internal/R$styleable:MultiSelectListPreference_entries	I
    //   333: invokevirtual 197	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   336: invokevirtual 201	androidx/appcompat/widget/AppCompatSpinner$h:setPromptText	(Ljava/lang/CharSequence;)V
    //   339: aload 8
    //   341: invokevirtual 202	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   344: aload_0
    //   345: aload 5
    //   347: putfield 204	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$i;
    //   350: aload_0
    //   351: new 13	androidx/appcompat/widget/AppCompatSpinner$a
    //   354: dup
    //   355: aload_0
    //   356: aload_0
    //   357: aload 5
    //   359: invokespecial 207	androidx/appcompat/widget/AppCompatSpinner$a:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$h;)V
    //   362: putfield 209	androidx/appcompat/widget/AppCompatSpinner:mForwardingListener	Landroidx/appcompat/widget/ListPopupWindow$ForwardingListener;
    //   365: goto +34 -> 399
    //   368: new 26	androidx/appcompat/widget/AppCompatSpinner$f
    //   371: dup
    //   372: aload_0
    //   373: invokespecial 212	androidx/appcompat/widget/AppCompatSpinner$f:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;)V
    //   376: astore 5
    //   378: aload_0
    //   379: aload 5
    //   381: putfield 204	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$i;
    //   384: aload 5
    //   386: aload 10
    //   388: getstatic 193	v7/internal/R$styleable:MultiSelectListPreference_entries	I
    //   391: invokevirtual 197	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   394: invokeinterface 213 2 0
    //   399: aload 10
    //   401: getstatic 216	v7/internal/R$styleable:MultiSelectListPreference_android_entries	I
    //   404: invokevirtual 220	androidx/appcompat/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   407: astore 5
    //   409: aload 5
    //   411: ifnull +28 -> 439
    //   414: new 222	android/widget/ArrayAdapter
    //   417: dup
    //   418: aload_1
    //   419: ldc -33
    //   421: aload 5
    //   423: invokespecial 226	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   426: astore_1
    //   427: aload_1
    //   428: getstatic 231	v7/internal/R$layout:support_simple_spinner_dropdown_item	I
    //   431: invokevirtual 235	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   434: aload_0
    //   435: aload_1
    //   436: invokevirtual 239	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   439: aload 10
    //   441: invokevirtual 202	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   444: aload_0
    //   445: iconst_1
    //   446: putfield 241	androidx/appcompat/widget/AppCompatSpinner:mPopupSet	Z
    //   449: aload_0
    //   450: getfield 243	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   453: astore_1
    //   454: aload_1
    //   455: ifnull +13 -> 468
    //   458: aload_0
    //   459: aload_1
    //   460: invokevirtual 239	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   463: aload_0
    //   464: aconst_null
    //   465: putfield 243	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   468: aload_0
    //   469: getfield 123	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   472: aload_2
    //   473: iload_3
    //   474: invokevirtual 247	androidx/appcompat/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   477: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	AppCompatSpinner
    //   0	478	1	paramContext	android.content.Context
    //   0	478	2	paramAttributeSet	AttributeSet
    //   0	478	3	paramInt1	int
    //   0	478	4	paramInt2	int
    //   0	478	5	paramTheme	Resources.Theme
    //   81	182	6	i	int
    //   153	11	7	bool	boolean
    //   111	229	8	localObject	Object
    //   137	36	9	localTypedArray	android.content.res.TypedArray
    //   193	1	9	localException1	Exception
    //   202	14	9	localException2	Exception
    //   36	404	10	localTintTypedArray	TintTypedArray
    // Exception table:
    //   from	to	target	type
    //   147	155	193	java/lang/Exception
    //   172	181	193	java/lang/Exception
    //   128	139	198	java/lang/Throwable
    //   128	139	202	java/lang/Exception
    //   147	155	241	java/lang/Throwable
    //   172	181	241	java/lang/Throwable
    //   211	221	241	java/lang/Throwable
  }
  
  int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int k = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i3 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    i = Math.max(0, i - (15 - (i3 - i)));
    Object localObject = null;
    int j = 0;
    while (i < i3)
    {
      int n = paramSpinnerAdapter.getItemViewType(i);
      int m = k;
      if (n != k)
      {
        localObject = null;
        m = n;
      }
      android.view.View localView = paramSpinnerAdapter.getView(i, (android.view.View)localObject, this);
      localObject = localView;
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i1, i2);
      j = Math.max(j, localView.getMeasuredWidth());
      i += 1;
      k = m;
    }
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(mTempRect);
      paramSpinnerAdapter = mTempRect;
      return j + (left + right);
    }
    return j;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.applySupportBackgroundTint();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    i localI = mPopup;
    if (localI != null) {
      return localI.getHorizontalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    i localI = mPopup;
    if (localI != null) {
      return localI.getVerticalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (mPopup != null) {
      return mDropDownWidth;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  final i getInternalPopup()
  {
    return mPopup;
  }
  
  public Drawable getPopupBackground()
  {
    i localI = mPopup;
    if (localI != null) {
      return localI.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public android.content.Context getPopupContext()
  {
    return mPopupContext;
  }
  
  public CharSequence getPrompt()
  {
    i localI = mPopup;
    if (localI != null) {
      return localI.getHintText();
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    i localI = mPopup;
    if ((localI != null) && (localI.isShowing())) {
      mPopup.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (showDropdown)
    {
      paramParcelable = getViewTreeObserver();
      if (paramParcelable != null) {
        paramParcelable.addOnGlobalLayoutListener(new b());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    i localI = mPopup;
    boolean bool;
    if ((localI != null) && (localI.isShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    showDropdown = bool;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ListPopupWindow.ForwardingListener localForwardingListener = mForwardingListener;
    if ((localForwardingListener != null) && (localForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    i localI = mPopup;
    if (localI != null)
    {
      if (!localI.isShowing()) {
        show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!mPopupSet)
    {
      mTempAdapter = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (mPopup != null)
    {
      android.content.Context localContext2 = mPopupContext;
      android.content.Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = getContext();
      }
      mPopup.setAdapter(new g(paramSpinnerAdapter, localContext1.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.loadFromAttributes(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    i localI = mPopup;
    if (localI != null)
    {
      localI.setBackgroundDrawable(paramInt);
      mPopup.setHorizontalOffset(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownHorizontalOffset(paramInt);
    }
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    i localI = mPopup;
    if (localI != null)
    {
      localI.setVerticalOffset(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownVerticalOffset(paramInt);
    }
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (mPopup != null)
    {
      mDropDownWidth = paramInt;
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownWidth(paramInt);
    }
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    i localI = mPopup;
    if (localI != null)
    {
      localI.setBackgroundDrawable(paramDrawable);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setPopupBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(v7.internal.transition.util.View.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    i localI = mPopup;
    if (localI != null)
    {
      localI.setPromptText(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  void show()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      mPopup.show(d.findById(this), d.create(this));
      return;
    }
    mPopup.show(-1, -1);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean showDropdown;
    
    SavedState(Parcel paramParcel)
    {
      super();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      showDropdown = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeByte((byte)showDropdown);
    }
    
    class a
      implements Parcelable.Creator<AppCompatSpinner.SavedState>
    {
      a() {}
      
      public AppCompatSpinner.SavedState[] a(int paramInt)
      {
        return new AppCompatSpinner.SavedState[paramInt];
      }
      
      public AppCompatSpinner.SavedState readDate(Parcel paramParcel)
      {
        return new AppCompatSpinner.SavedState(paramParcel);
      }
    }
  }
  
  class a
    extends ListPopupWindow.ForwardingListener
  {
    a(android.view.View paramView, AppCompatSpinner.h paramH)
    {
      super();
    }
    
    public androidx.appcompat.view.menu.ListPopupWindow getPopup()
    {
      return paramTheme;
    }
    
    public boolean onForwardingStarted()
    {
      if (!getInternalPopup().isShowing()) {
        show();
      }
      return true;
    }
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public void onGlobalLayout()
    {
      if (!getInternalPopup().isShowing()) {
        show();
      }
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          AppCompatSpinner.c.removeOnGlobalLayoutListener(localViewTreeObserver, this);
          return;
        }
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
    }
  }
  
  private static final class c
  {
    static void removeOnGlobalLayoutListener(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
  }
  
  private static final class d
  {
    static int create(android.view.View paramView)
    {
      return paramView.getTextAlignment();
    }
    
    static int findById(android.view.View paramView)
    {
      return paramView.getTextDirection();
    }
    
    static void onDismiss(android.view.View paramView, int paramInt)
    {
      paramView.setTextDirection(paramInt);
    }
    
    static void setPosition(android.view.View paramView, int paramInt)
    {
      paramView.setTextAlignment(paramInt);
    }
  }
  
  private static final class e
  {
    static void create(android.widget.ThemedSpinnerAdapter paramThemedSpinnerAdapter, Resources.Theme paramTheme)
    {
      if (!v7.v7.util.Context.equals(paramThemedSpinnerAdapter.getDropDownViewTheme(), paramTheme)) {
        paramThemedSpinnerAdapter.setDropDownViewTheme(paramTheme);
      }
    }
  }
  
  class f
    implements AppCompatSpinner.i, DialogInterface.OnClickListener
  {
    private ListAdapter mListAdapter;
    AlertDialog mPopup;
    private CharSequence mPrompt;
    
    f() {}
    
    public void dismiss()
    {
      AlertDialog localAlertDialog = mPopup;
      if (localAlertDialog != null)
      {
        localAlertDialog.dismiss();
        mPopup = null;
      }
    }
    
    public Drawable getBackground()
    {
      return null;
    }
    
    public CharSequence getHintText()
    {
      return mPrompt;
    }
    
    public int getHorizontalOffset()
    {
      return 0;
    }
    
    public int getVerticalOffset()
    {
      return 0;
    }
    
    public boolean isShowing()
    {
      AlertDialog localAlertDialog = mPopup;
      if (localAlertDialog != null) {
        return localAlertDialog.isShowing();
      }
      return false;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      setSelection(paramInt);
      if (getOnItemClickListener() != null) {
        performItemClick(null, paramInt, mListAdapter.getItemId(paramInt));
      }
      dismiss();
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      mListAdapter = paramListAdapter;
    }
    
    public void setBackgroundDrawable(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }
    
    public void setHorizontalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      mPrompt = paramCharSequence;
    }
    
    public void setVerticalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }
    
    public void show(int paramInt1, int paramInt2)
    {
      if (mListAdapter == null) {
        return;
      }
      Object localObject = new AlertDialog.Builder(getPopupContext());
      CharSequence localCharSequence = mPrompt;
      if (localCharSequence != null) {
        ((AlertDialog.Builder)localObject).setTitle(localCharSequence);
      }
      localObject = ((AlertDialog.Builder)localObject).setSingleChoiceItems(mListAdapter, getSelectedItemPosition(), this).create();
      mPopup = ((AlertDialog)localObject);
      localObject = ((AlertDialog)localObject).getListView();
      if (Build.VERSION.SDK_INT >= 17)
      {
        AppCompatSpinner.d.onDismiss((android.view.View)localObject, paramInt1);
        AppCompatSpinner.d.setPosition((android.view.View)localObject, paramInt2);
      }
      mPopup.show();
    }
  }
  
  private static class g
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public g(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        mListAdapter = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null)
      {
        if ((Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)))
        {
          AppCompatSpinner.e.create((android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter, paramTheme);
          return;
        }
        if ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter))
        {
          paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return 0;
      }
      return localSpinnerAdapter.getCount();
    }
    
    public android.view.View getDropDownView(int paramInt, android.view.View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter == null) {
        return -1L;
      }
      return localSpinnerAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public android.view.View getView(int paramInt, android.view.View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      return (localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  class h
    extends ListPopupWindow
    implements AppCompatSpinner.i
  {
    ListAdapter mAdapter;
    private CharSequence mHintText;
    private int mPadding;
    private final Rect mVisibleRect = new Rect();
    
    public h(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setAdapter(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new a(AppCompatSpinner.this));
    }
    
    void computeContentWidth()
    {
      Object localObject = getBackground();
      int i = 0;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
          i = mTempRect.right;
        } else {
          i = -mTempRect.left;
        }
      }
      else
      {
        localObject = mTempRect;
        right = 0;
        left = 0;
      }
      int n = getPaddingLeft();
      int i1 = getPaddingRight();
      int i2 = getWidth();
      localObject = AppCompatSpinner.this;
      int j = mDropDownWidth;
      if (j == -2)
      {
        int k = ((AppCompatSpinner)localObject).compatMeasureContentWidth((SpinnerAdapter)mAdapter, getBackground());
        j = k;
        int m = getContext().getResources().getDisplayMetrics().widthPixels;
        localObject = mTempRect;
        m = m - left - right;
        if (k > m) {
          j = m;
        }
        setContentWidth(Math.max(j, i2 - n - i1));
      }
      else if (j == -1)
      {
        setContentWidth(i2 - n - i1);
      }
      else
      {
        setContentWidth(j);
      }
      if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
        i += i2 - i1 - getWidth() - getPadding();
      } else {
        i += n + getPadding();
      }
      setHorizontalOffset(i);
    }
    
    public CharSequence getHintText()
    {
      return mHintText;
    }
    
    public int getPadding()
    {
      return mPadding;
    }
    
    boolean isVisibleToUser(android.view.View paramView)
    {
      return (ViewCompat.d(paramView)) && (paramView.getGlobalVisibleRect(mVisibleRect));
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      mAdapter = paramListAdapter;
    }
    
    public void setBackgroundDrawable(int paramInt)
    {
      mPadding = paramInt;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      mHintText = paramCharSequence;
    }
    
    public void show(int paramInt1, int paramInt2)
    {
      boolean bool = isShowing();
      computeContentWidth();
      show(2);
      super.show();
      Object localObject = getListView();
      ((AbsListView)localObject).setChoiceMode(1);
      if (Build.VERSION.SDK_INT >= 17)
      {
        AppCompatSpinner.d.onDismiss((android.view.View)localObject, paramInt1);
        AppCompatSpinner.d.setPosition((android.view.View)localObject, paramInt2);
      }
      setSelection(getSelectedItemPosition());
      if (bool) {
        return;
      }
      localObject = getViewTreeObserver();
      if (localObject != null)
      {
        final b localB = new b();
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(localB);
        setOnDismissListener(new c(localB));
      }
    }
    
    class a
      implements AdapterView.OnItemClickListener
    {
      a(AppCompatSpinner paramAppCompatSpinner) {}
      
      public void onItemClick(AdapterView paramAdapterView, android.view.View paramView, int paramInt, long paramLong)
      {
        setSelection(paramInt);
        if (getOnItemClickListener() != null)
        {
          paramAdapterView = AppCompatSpinner.h.this;
          this$0.performItemClick(paramView, paramInt, mAdapter.getItemId(paramInt));
        }
        dismiss();
      }
    }
    
    class b
      implements ViewTreeObserver.OnGlobalLayoutListener
    {
      b() {}
      
      public void onGlobalLayout()
      {
        AppCompatSpinner.h localH = AppCompatSpinner.h.this;
        if (!localH.isVisibleToUser(this$0))
        {
          dismiss();
          return;
        }
        computeContentWidth();
        AppCompatSpinner.h.access$getShow(AppCompatSpinner.h.this);
      }
    }
    
    class c
      implements PopupWindow.OnDismissListener
    {
      c(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
      
      public void onDismiss()
      {
        ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
        if (localViewTreeObserver != null) {
          localViewTreeObserver.removeGlobalOnLayoutListener(localB);
        }
      }
    }
  }
  
  static abstract interface i
  {
    public abstract void dismiss();
    
    public abstract Drawable getBackground();
    
    public abstract CharSequence getHintText();
    
    public abstract int getHorizontalOffset();
    
    public abstract int getVerticalOffset();
    
    public abstract boolean isShowing();
    
    public abstract void setAdapter(ListAdapter paramListAdapter);
    
    public abstract void setBackgroundDrawable(int paramInt);
    
    public abstract void setBackgroundDrawable(Drawable paramDrawable);
    
    public abstract void setHorizontalOffset(int paramInt);
    
    public abstract void setPromptText(CharSequence paramCharSequence);
    
    public abstract void setVerticalOffset(int paramInt);
    
    public abstract void show(int paramInt1, int paramInt2);
  }
}

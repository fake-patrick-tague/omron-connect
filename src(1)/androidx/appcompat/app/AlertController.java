package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.c;
import java.lang.ref.WeakReference;
import v7.internal.R.attr;
import v7.internal.R.id;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

class AlertController
{
  private Drawable b;
  private Drawable icon;
  ListAdapter mAdapter;
  private int mAlertDialogLayout;
  private final View.OnClickListener mButtonHandler = new a();
  Button mButtonNegative;
  Message mButtonNegativeMessage;
  private CharSequence mButtonNegativeText;
  Button mButtonNeutral;
  Message mButtonNeutralMessage;
  private CharSequence mButtonNeutralText;
  private int mButtonPanelLayoutHint = 0;
  private int mButtonPanelSideLayout;
  Button mButtonPositive;
  Message mButtonPositiveMessage;
  private CharSequence mButtonPositiveText;
  int mCheckedItem = -1;
  private final Context mContext;
  private View mCustomTitleView;
  final AppCompatDialog mDialog;
  Handler mHandler;
  private Drawable mIcon;
  private int mIconId = 0;
  private ImageView mIconView;
  int mListItemLayout;
  int mListLayout;
  ListView mListView;
  private CharSequence mMessage;
  private TextView mMessageView;
  int mMultiChoiceItemLayout;
  NestedScrollView mScrollView;
  private boolean mSelected;
  int mSingleChoiceItemLayout;
  private Drawable mState;
  private CharSequence mTitle;
  private TextView mTitleView;
  private View mView;
  private int mViewLayoutResId;
  private int mViewSpacingBottom;
  private int mViewSpacingLeft;
  private int mViewSpacingRight;
  private boolean mViewSpacingSpecified = false;
  private int mViewSpacingTop;
  private final Window mWindow;
  private final int width;
  
  public AlertController(Context paramContext, AppCompatDialog paramAppCompatDialog, Window paramWindow)
  {
    mContext = paramContext;
    mDialog = paramAppCompatDialog;
    mWindow = paramWindow;
    mHandler = new g(paramAppCompatDialog);
    paramContext = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    mAlertDialogLayout = paramContext.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    mButtonPanelSideLayout = paramContext.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    mListLayout = paramContext.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    mMultiChoiceItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    mSingleChoiceItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    mListItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    mSelected = paramContext.getBoolean(R.styleable.SlidingDrawer_animateOnClick, true);
    width = paramContext.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_padding, 0);
    paramContext.recycle();
    paramAppCompatDialog.supportRequestWindowFeature(1);
  }
  
  static boolean canTextInput(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i = paramView.getChildCount();
    while (i > 0)
    {
      int j = i - 1;
      i = j;
      if (canTextInput(paramView.getChildAt(j))) {
        return true;
      }
    }
    return false;
  }
  
  private void centerButton(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    gravity = 1;
    weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  private ViewGroup resolvePanel(View paramView1, View paramView2)
  {
    if (paramView1 == null)
    {
      paramView1 = paramView2;
      if ((paramView2 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView2).inflate();
      }
      return (ViewGroup)paramView1;
    }
    if (paramView2 != null)
    {
      ViewParent localViewParent = paramView2.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView2);
      }
    }
    paramView2 = paramView1;
    if ((paramView1 instanceof ViewStub)) {
      paramView2 = ((ViewStub)paramView1).inflate();
    }
    return (ViewGroup)paramView2;
  }
  
  private int selectContentView()
  {
    int i = mButtonPanelSideLayout;
    if (i == 0) {
      return mAlertDialogLayout;
    }
    if (mButtonPanelLayoutHint == 1) {
      return i;
    }
    return mAlertDialogLayout;
  }
  
  private void setScrollIndicators(ViewGroup paramViewGroup, final View paramView, int paramInt1, int paramInt2)
  {
    View localView2 = mWindow.findViewById(R.id.scrollIndicatorUp);
    Object localObject2 = localView2;
    View localView1 = mWindow.findViewById(R.id.scrollIndicatorDown);
    Object localObject1 = localView1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      ViewCompat.setScrollIndicators(paramView, paramInt1, paramInt2);
      if (localView2 != null) {
        paramViewGroup.removeView(localView2);
      }
      if (localView1 != null) {
        paramViewGroup.removeView(localView1);
      }
    }
    else
    {
      paramView = (View)localObject2;
      if (localView2 != null)
      {
        paramView = (View)localObject2;
        if ((paramInt1 & 0x1) == 0)
        {
          paramViewGroup.removeView(localView2);
          paramView = null;
        }
      }
      localObject2 = localObject1;
      if (localView1 != null)
      {
        localObject2 = localObject1;
        if ((paramInt1 & 0x2) == 0)
        {
          paramViewGroup.removeView(localView1);
          localObject2 = null;
        }
      }
      if ((paramView != null) || (localObject2 != null))
      {
        if (mMessage != null)
        {
          mScrollView.setOnScrollChangeListener(new b(paramView, (View)localObject2));
          mScrollView.post(new c(paramView, (View)localObject2));
          return;
        }
        localObject1 = mListView;
        if (localObject1 != null)
        {
          ((AbsListView)localObject1).setOnScrollListener(new d(paramView, (View)localObject2));
          mListView.post(new e(paramView, (View)localObject2));
          return;
        }
        if (paramView != null) {
          paramViewGroup.removeView(paramView);
        }
        if (localObject2 != null) {
          paramViewGroup.removeView((View)localObject2);
        }
      }
    }
  }
  
  private void setupButtons(ViewGroup paramViewGroup)
  {
    Object localObject = (Button)paramViewGroup.findViewById(16908313);
    mButtonPositive = ((Button)localObject);
    ((View)localObject).setOnClickListener(mButtonHandler);
    boolean bool = TextUtils.isEmpty(mButtonNeutralText);
    int j = 1;
    int i;
    if ((bool) && (b == null))
    {
      mButtonPositive.setVisibility(8);
      i = 0;
    }
    else
    {
      mButtonPositive.setText(mButtonNeutralText);
      localObject = b;
      if (localObject != null)
      {
        i = width;
        ((Drawable)localObject).setBounds(0, 0, i, i);
        mButtonPositive.setCompoundDrawables(b, null, null, null);
      }
      mButtonPositive.setVisibility(0);
      i = 1;
    }
    localObject = (Button)paramViewGroup.findViewById(16908314);
    mButtonNegative = ((Button)localObject);
    ((View)localObject).setOnClickListener(mButtonHandler);
    int k;
    if ((TextUtils.isEmpty(mButtonNegativeText)) && (mState == null))
    {
      mButtonNegative.setVisibility(8);
    }
    else
    {
      mButtonNegative.setText(mButtonNegativeText);
      localObject = mState;
      if (localObject != null)
      {
        k = width;
        ((Drawable)localObject).setBounds(0, 0, k, k);
        mButtonNegative.setCompoundDrawables(mState, null, null, null);
      }
      mButtonNegative.setVisibility(0);
      i |= 0x2;
    }
    localObject = (Button)paramViewGroup.findViewById(16908315);
    mButtonNeutral = ((Button)localObject);
    ((View)localObject).setOnClickListener(mButtonHandler);
    if ((TextUtils.isEmpty(mButtonPositiveText)) && (icon == null))
    {
      mButtonNeutral.setVisibility(8);
    }
    else
    {
      mButtonNeutral.setText(mButtonPositiveText);
      localObject = icon;
      if (localObject != null)
      {
        k = width;
        ((Drawable)localObject).setBounds(0, 0, k, k);
        mButtonNeutral.setCompoundDrawables(icon, null, null, null);
      }
      mButtonNeutral.setVisibility(0);
      i |= 0x4;
    }
    if (shouldCenterSingleButton(mContext)) {
      if (i == 1) {
        centerButton(mButtonPositive);
      } else if (i == 2) {
        centerButton(mButtonNegative);
      } else if (i == 4) {
        centerButton(mButtonNeutral);
      }
    }
    if (i != 0) {
      i = j;
    } else {
      i = 0;
    }
    if (i == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void setupContent(ViewGroup paramViewGroup)
  {
    Object localObject = (NestedScrollView)mWindow.findViewById(R.id.scrollView);
    mScrollView = ((NestedScrollView)localObject);
    ((View)localObject).setFocusable(false);
    mScrollView.setNestedScrollingEnabled(false);
    localObject = (TextView)paramViewGroup.findViewById(16908299);
    mMessageView = ((TextView)localObject);
    if (localObject == null) {
      return;
    }
    CharSequence localCharSequence = mMessage;
    if (localCharSequence != null)
    {
      ((TextView)localObject).setText(localCharSequence);
      return;
    }
    ((View)localObject).setVisibility(8);
    mScrollView.removeView(mMessageView);
    if (mListView != null)
    {
      paramViewGroup = (ViewGroup)mScrollView.getParent();
      int i = paramViewGroup.indexOfChild(mScrollView);
      paramViewGroup.removeViewAt(i);
      paramViewGroup.addView(mListView, i, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void setupCustomContent(ViewGroup paramViewGroup)
  {
    View localView = mView;
    int i = 0;
    if (localView == null) {
      if (mViewLayoutResId != 0) {
        localView = LayoutInflater.from(mContext).inflate(mViewLayoutResId, paramViewGroup, false);
      } else {
        localView = null;
      }
    }
    if (localView != null) {
      i = 1;
    }
    if ((i == 0) || (!canTextInput(localView))) {
      mWindow.setFlags(131072, 131072);
    }
    if (i != 0)
    {
      FrameLayout localFrameLayout = (FrameLayout)mWindow.findViewById(R.id.custom);
      localFrameLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      if (mViewSpacingSpecified) {
        localFrameLayout.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
      }
      if (mListView != null) {
        getLayoutParamsweight = 0.0F;
      }
    }
    else
    {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void setupTitle(ViewGroup paramViewGroup)
  {
    if (mCustomTitleView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(mCustomTitleView, 0, localLayoutParams);
      mWindow.findViewById(R.id.title_template).setVisibility(8);
      return;
    }
    mIconView = ((ImageView)mWindow.findViewById(16908294));
    if (((TextUtils.isEmpty(mTitle) ^ true)) && (mSelected))
    {
      paramViewGroup = (TextView)mWindow.findViewById(R.id.icon);
      mTitleView = paramViewGroup;
      paramViewGroup.setText(mTitle);
      int i = mIconId;
      if (i != 0)
      {
        mIconView.setImageResource(i);
        return;
      }
      paramViewGroup = mIcon;
      if (paramViewGroup != null)
      {
        mIconView.setImageDrawable(paramViewGroup);
        return;
      }
      mTitleView.setPadding(mIconView.getPaddingLeft(), mIconView.getPaddingTop(), mIconView.getPaddingRight(), mIconView.getPaddingBottom());
      mIconView.setVisibility(8);
      return;
    }
    mWindow.findViewById(R.id.title_template).setVisibility(8);
    mIconView.setVisibility(8);
    paramViewGroup.setVisibility(8);
  }
  
  private void setupView()
  {
    Object localObject4 = mWindow.findViewById(R.id.root);
    int i = R.id.contentPanel;
    Object localObject3 = ((View)localObject4).findViewById(i);
    int j = R.id.mWindow;
    Object localObject2 = ((View)localObject4).findViewById(j);
    int k = R.id.buttonPanel;
    Object localObject1 = ((View)localObject4).findViewById(k);
    localObject4 = (ViewGroup)((View)localObject4).findViewById(R.id.customPanel);
    setupCustomContent((ViewGroup)localObject4);
    View localView3 = ((View)localObject4).findViewById(i);
    View localView2 = ((View)localObject4).findViewById(j);
    View localView1 = ((View)localObject4).findViewById(k);
    localObject3 = resolvePanel(localView3, (View)localObject3);
    localObject2 = resolvePanel(localView2, (View)localObject2);
    localObject1 = resolvePanel(localView1, (View)localObject1);
    setupContent((ViewGroup)localObject2);
    setupButtons((ViewGroup)localObject1);
    setupTitle((ViewGroup)localObject3);
    i = ((View)localObject4).getVisibility();
    j = 0;
    if (i != 8) {
      i = 1;
    } else {
      i = 0;
    }
    int m;
    if ((localObject3 != null) && (((View)localObject3).getVisibility() != 8)) {
      m = 1;
    } else {
      m = 0;
    }
    boolean bool;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && (localObject2 != null))
    {
      localObject1 = ((View)localObject2).findViewById(R.id.textSpacerNoButtons);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    if (m != 0)
    {
      localObject1 = mScrollView;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setClipToPadding(true);
      }
      localObject1 = null;
      if ((mMessage != null) || (mListView != null)) {
        localObject1 = ((View)localObject3).findViewById(R.id.parentPanel);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    else if (localObject2 != null)
    {
      localObject1 = ((View)localObject2).findViewById(R.id.topPanel);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    localObject1 = mListView;
    if ((localObject1 instanceof RecycleListView)) {
      ((RecycleListView)localObject1).a(m, bool);
    }
    if (i == 0)
    {
      localObject1 = mListView;
      if (localObject1 == null) {
        localObject1 = mScrollView;
      }
      if (localObject1 != null)
      {
        i = j;
        if (bool) {
          i = 2;
        }
        setScrollIndicators((ViewGroup)localObject2, (View)localObject1, m | i, 3);
      }
    }
    localObject1 = mListView;
    if (localObject1 != null)
    {
      localObject2 = mAdapter;
      if (localObject2 != null)
      {
        ((ListView)localObject1).setAdapter((ListAdapter)localObject2);
        i = mCheckedItem;
        if (i > -1)
        {
          ((AbsListView)localObject1).setItemChecked(i, true);
          ((ListView)localObject1).setSelection(i);
        }
      }
    }
  }
  
  private static boolean shouldCenterSingleButton(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, localTypedValue, true);
    return data != 0;
  }
  
  public Button getButton(int paramInt)
  {
    if (paramInt != -3)
    {
      if (paramInt != -2)
      {
        if (paramInt != -1) {
          return null;
        }
        return mButtonPositive;
      }
      return mButtonNegative;
    }
    return mButtonNeutral;
  }
  
  public int getIconAttributeResId(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    mContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return resourceId;
  }
  
  public ListView getListView()
  {
    return mListView;
  }
  
  public void installContent()
  {
    int i = selectContentView();
    mDialog.setContentView(i);
    setupView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = mScrollView;
    return (localNestedScrollView != null) && (localNestedScrollView.executeKeyEvent(paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = mScrollView;
    return (localNestedScrollView != null) && (localNestedScrollView.executeKeyEvent(paramKeyEvent));
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    Message localMessage = paramMessage;
    if (paramMessage == null)
    {
      localMessage = paramMessage;
      if (paramOnClickListener != null) {
        localMessage = mHandler.obtainMessage(paramInt, paramOnClickListener);
      }
    }
    if (paramInt != -3)
    {
      if (paramInt != -2)
      {
        if (paramInt == -1)
        {
          mButtonNeutralText = paramCharSequence;
          mButtonNeutralMessage = localMessage;
          b = paramDrawable;
          return;
        }
        throw new IllegalArgumentException("Button does not exist");
      }
      mButtonNegativeText = paramCharSequence;
      mButtonNegativeMessage = localMessage;
      mState = paramDrawable;
      return;
    }
    mButtonPositiveText = paramCharSequence;
    mButtonPositiveMessage = localMessage;
    icon = paramDrawable;
  }
  
  public void setCustomTitle(View paramView)
  {
    mCustomTitleView = paramView;
  }
  
  public void setIcon(int paramInt)
  {
    mIcon = null;
    mIconId = paramInt;
    ImageView localImageView = mIconView;
    if (localImageView != null)
    {
      if (paramInt != 0)
      {
        localImageView.setVisibility(0);
        mIconView.setImageResource(mIconId);
        return;
      }
      localImageView.setVisibility(8);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    mIcon = paramDrawable;
    mIconId = 0;
    ImageView localImageView = mIconView;
    if (localImageView != null)
    {
      if (paramDrawable != null)
      {
        localImageView.setVisibility(0);
        mIconView.setImageDrawable(paramDrawable);
        return;
      }
      localImageView.setVisibility(8);
    }
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    mMessage = paramCharSequence;
    TextView localTextView = mMessageView;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    TextView localTextView = mTitleView;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void setView(int paramInt)
  {
    mView = null;
    mViewLayoutResId = paramInt;
    mViewSpacingSpecified = false;
  }
  
  public void setView(View paramView)
  {
    mView = paramView;
    mViewLayoutResId = 0;
    mViewSpacingSpecified = false;
  }
  
  public void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mView = paramView;
    mViewLayoutResId = 0;
    mViewSpacingSpecified = true;
    mViewSpacingLeft = paramInt1;
    mViewSpacingTop = paramInt2;
    mViewSpacingRight = paramInt3;
    mViewSpacingBottom = paramInt4;
  }
  
  public static class RecycleListView
    extends ListView
  {
    private final int j;
    private final int k;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockTheme);
      j = paramContext.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, -1);
      k = paramContext.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, -1);
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((!paramBoolean2) || (!paramBoolean1))
      {
        int n = getPaddingLeft();
        int i;
        if (paramBoolean1) {
          i = getPaddingTop();
        } else {
          i = k;
        }
        int i1 = getPaddingRight();
        int m;
        if (paramBoolean2) {
          m = getPaddingBottom();
        } else {
          m = j;
        }
        setPadding(n, i, i1, m);
      }
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      AlertController localAlertController = AlertController.this;
      Message localMessage;
      if (paramView == mButtonPositive)
      {
        localMessage = mButtonNeutralMessage;
        if (localMessage != null)
        {
          paramView = Message.obtain(localMessage);
          break label82;
        }
      }
      if (paramView == mButtonNegative)
      {
        localMessage = mButtonNegativeMessage;
        if (localMessage != null)
        {
          paramView = Message.obtain(localMessage);
          break label82;
        }
      }
      if (paramView == mButtonNeutral)
      {
        paramView = mButtonPositiveMessage;
        if (paramView != null)
        {
          paramView = Message.obtain(paramView);
          break label82;
        }
      }
      paramView = null;
      label82:
      if (paramView != null) {
        paramView.sendToTarget();
      }
      paramView = AlertController.this;
      mHandler.obtainMessage(1, mDialog).sendToTarget();
    }
  }
  
  class b
    implements NestedScrollView.c
  {
    b(View paramView1, View paramView2) {}
    
    public void onScrollChange(NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AlertController.access$800(paramNestedScrollView, paramView, val$bottom);
    }
  }
  
  class c
    implements Runnable
  {
    c(View paramView1, View paramView2) {}
    
    public void run()
    {
      AlertController.access$800(mScrollView, paramView, val$bottom);
    }
  }
  
  class d
    implements AbsListView.OnScrollListener
  {
    d(View paramView1, View paramView2) {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      AlertController.access$800(paramAbsListView, paramView, val$bottom);
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  }
  
  class e
    implements Runnable
  {
    e(View paramView1, View paramView2) {}
    
    public void run()
    {
      AlertController.access$800(mListView, paramView, a);
    }
  }
  
  public static class f
  {
    public String EVENT_LOCATION;
    public CharSequence filePath;
    public DialogInterface.OnClickListener listener;
    public ListAdapter mAdapter;
    public boolean mCancelable;
    public int mCheckedItem = -1;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public Drawable mIcon;
    public int mIconAttrId = 0;
    public int mIconId = 0;
    public final LayoutInflater mInflater;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public DialogInterface.OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public DialogInterface.OnClickListener mNeutralButtonListener;
    public Drawable mNeutralButtonText;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface.OnClickListener mOnClickListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public e mOnPrepareListViewListener;
    public Drawable mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public boolean mRecycleOnMeasure = true;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public boolean mViewSpacingSpecified = false;
    public int mViewSpacingTop;
    public Drawable this$0;
    
    public f(Context paramContext)
    {
      mContext = paramContext;
      mCancelable = true;
      mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
    
    private void createListView(AlertController paramAlertController)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
    }
    
    public void apply(AlertController paramAlertController)
    {
      Object localObject = mCustomTitleView;
      if (localObject != null)
      {
        paramAlertController.setCustomTitle((View)localObject);
      }
      else
      {
        localObject = mTitle;
        if (localObject != null) {
          paramAlertController.setTitle((CharSequence)localObject);
        }
        localObject = mIcon;
        if (localObject != null) {
          paramAlertController.setIcon((Drawable)localObject);
        }
        i = mIconId;
        if (i != 0) {
          paramAlertController.setIcon(i);
        }
        i = mIconAttrId;
        if (i != 0) {
          paramAlertController.setIcon(paramAlertController.getIconAttributeResId(i));
        }
      }
      localObject = mMessage;
      if (localObject != null) {
        paramAlertController.setMessage((CharSequence)localObject);
      }
      localObject = mPositiveButtonText;
      if ((localObject != null) || (mPositiveButtonListener != null)) {
        paramAlertController.setButton(-1, (CharSequence)localObject, mNeutralButtonListener, null, mPositiveButtonListener);
      }
      localObject = mNegativeButtonText;
      if ((localObject != null) || (mNeutralButtonText != null)) {
        paramAlertController.setButton(-2, (CharSequence)localObject, mNegativeButtonListener, null, mNeutralButtonText);
      }
      localObject = filePath;
      if ((localObject != null) || (this$0 != null)) {
        paramAlertController.setButton(-3, (CharSequence)localObject, listener, null, this$0);
      }
      if ((mItems != null) || (mCursor != null) || (mAdapter != null)) {
        createListView(paramAlertController);
      }
      localObject = mView;
      if (localObject != null)
      {
        if (mViewSpacingSpecified)
        {
          paramAlertController.setView((View)localObject, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
          return;
        }
        paramAlertController.setView((View)localObject);
        return;
      }
      int i = mViewLayoutResId;
      if (i != 0) {
        paramAlertController.setView(i);
      }
    }
    
    class a
      extends ArrayAdapter<CharSequence>
    {
      a(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence, AlertController.RecycleListView paramRecycleListView)
      {
        super(paramInt1, paramInt2, paramArrayOfCharSequence);
      }
      
      public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        paramView = super.getView(paramInt, paramView, paramViewGroup);
        paramViewGroup = mCheckedItems;
        if ((paramViewGroup != null) && (paramViewGroup[paramInt] != 0)) {
          val$listView.setItemChecked(paramInt, true);
        }
        return paramView;
      }
    }
    
    class b
      extends CursorAdapter
    {
      private final int mIsCheckedIndex;
      private final int mLabelIndex;
      
      b(Context paramContext, Cursor paramCursor, boolean paramBoolean, AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController)
      {
        super(paramCursor, paramBoolean);
        paramContext = getCursor();
        mLabelIndex = paramContext.getColumnIndexOrThrow(mLabelColumn);
        mIsCheckedIndex = paramContext.getColumnIndexOrThrow(EVENT_LOCATION);
      }
      
      public void bindView(View paramView, Context paramContext, Cursor paramCursor)
      {
        ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(mLabelIndex));
        paramView = val$listView;
        int i = paramCursor.getPosition();
        int j = paramCursor.getInt(mIsCheckedIndex);
        boolean bool = true;
        if (j != 1) {
          bool = false;
        }
        paramView.setItemChecked(i, bool);
      }
      
      public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
      {
        return mInflater.inflate(val$dialog.mMultiChoiceItemLayout, paramViewGroup, false);
      }
    }
    
    class c
      implements AdapterView.OnItemClickListener
    {
      c(AlertController paramAlertController) {}
      
      public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        mOnClickListener.onClick(val$dialog.mDialog, paramInt);
        if (!mIsSingleChoice) {
          val$dialog.mDialog.dismiss();
        }
      }
    }
    
    class d
      implements AdapterView.OnItemClickListener
    {
      d(AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController) {}
      
      public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        paramAdapterView = mCheckedItems;
        if (paramAdapterView != null) {
          paramAdapterView[paramInt] = val$listView.isItemChecked(paramInt);
        }
        mOnCheckboxClickListener.onClick(val$dialog.mDialog, paramInt, val$listView.isItemChecked(paramInt));
      }
    }
    
    public static abstract interface e
    {
      public abstract void onPrepareListView(ListView paramListView);
    }
  }
  
  private static final class g
    extends Handler
  {
    private WeakReference<DialogInterface> mDialog;
    
    public g(DialogInterface paramDialogInterface)
    {
      mDialog = new WeakReference(paramDialogInterface);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = what;
      if ((i != -3) && (i != -2) && (i != -1))
      {
        if (i != 1) {
          return;
        }
        ((DialogInterface)obj).dismiss();
        return;
      }
      ((DialogInterface.OnClickListener)obj).onClick((DialogInterface)mDialog.get(), what);
    }
  }
  
  private static class h
    extends ArrayAdapter<CharSequence>
  {
    public h(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt1, paramInt2, paramArrayOfCharSequence);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
}

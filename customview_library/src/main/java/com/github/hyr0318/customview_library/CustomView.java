package com.github.hyr0318.customview_library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Description:
 * 作者：hyr on 2016/7/25 17:53
 * 邮箱：2045446584@qq.com
 */
public class CustomView extends RelativeLayout {
    private Context mContext;
    private Drawable mLeftIcon;
    private ImageView mLeftImageView;
    private boolean isShowLeftIcon;
    private int defaultBgColor = 0xFFFFFFFF;//默认背景颜色
    private int defaultTextColor = 0xFF000000;//默认黑色字体颜色
    private int defaultTextSize;
    private int mBackgroudColor;
    private String mLeftText;
    private int defMarginLeft;
    private int marginLeft;
    private TextView leftTextView;
    private LayoutParams leftTextLayoutParams;
    private int leftTextColor;
    private int leftTextSize;
    private Drawable mRigthIcon;
    private boolean isShowRightIcon;
    private int mMarginRight;
    private Drawable mRigthButton;
    private Button mRightButton;
    private String mRightButtonTextStr;
    private int defWidth = LayoutParams.WRAP_CONTENT;
    private int defHeight = LayoutParams.WRAP_CONTENT;
    private int mRightButtonHeight;
    private int mRightButtonWidth;
    private int mLeftIconHeight;
    private int mLeftIconWidth;
    private int mRightIconHeight;
    private int mRightIconWidth;
    private int mRightButtonTextSize;
    private int mRightBtTextColor;
    private Drawable mCenterIcon;
    private ImageView mCenterImageView;
    private int mCenterIconHeight;
    private int mCenterIconWidth;
    private String mCenterStr;
    private int mCenterTextColor;
    private int mCenterTextSize;
    private String mRightTextStr1;
    private String mRightTextStr2;
    private String mRightTextStr3;
    private int mRightTextMarginRight;
    private int defMarginRiht = 10;
    private boolean isShowTopLine;
    private boolean isShowBottomLine;
    private int defaultLineColor = 0xFFE8E8E8;
    private int defTopMarginLeft = 0;
    private int defTopMarginRight = 0;
    private int mTopLineMarginLeft;
    private int mTopLineMarginRight;
    private int lineColor;
    private int mBottomLineMarginLeft;
    private int mBottomMarginRight;
    private boolean isShowBorder;
    private String mRightEditTextHint;
    private int mRightEditTextSize;
    private int mRightEditTextColor;
    private int mRightTextNum;
    private int mRightTextSize1;
    private int mRightTextSize2;
    private int mRightTextSize3;
    private int mRightTextColor1;
    private int mRightTextColor2;
    private int mRightTextColor3;
    private int mRightTextMarginLeft;
    private int mRightTextMarginTop;
    private int mRightTextMarginBottom;
    private String mLeftEditTextHint;
    private int mLeftEditTextSize;
    private int mLeftEditTextColor;


    public CustomView(Context context) {
        super(context);
    }


    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.mContext = context;

        defaultTextSize = sp2px(context, 16);

        defMarginLeft = dip2px(context, 5);

        getAttrs(attrs);

        initLayout();

    }


    private void initLayout() {

        if (mLeftIcon != null) {

            initLeftIcon();
        }

        if (mLeftText != null) {
            initLeftText();
        }

        if (mRigthIcon != null) {

            initRightIcon();
        }

        if (mRigthButton != null) {
            initRightButton();
        }

        if (mCenterIcon != null) {
            initCenterIcon();
        }

        if (mCenterStr != null) {
            initCenterStr();
        }

        if (mRightTextNum != 0) {
            initRightText();
        }

        if (isShowTopLine) {
            initTopLine();
        }

        if (isShowBottomLine) {
            initBottomLine();
        }

        if (isShowBorder) {
            initTopLine();
            initBottomLine();
        }
        if (mRightEditTextHint != null) {
            initEditText();
        }

        if (mLeftEditTextHint != null) {
            initLeftEditText();
        }
        initBackgroudColor();
    }


    /**
     * 设置左边编辑框
     */
    @SuppressLint("NewApi") private void initLeftEditText() {

        EditText editText = new EditText(mContext);

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(LEFT_OF, R.id.center_image_id);
        layoutParams.addRule(LEFT_OF,R.id.center_text_id);
        layoutParams.setMargins(marginLeft, 0, 0, 0);

        editText.setHint(mLeftEditTextHint);

        editText.setSelection(editText.length());

        editText.setBackground(null);

        editText.setTextColor(mLeftEditTextColor);

        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mLeftEditTextSize);

        editText.setLayoutParams(layoutParams);

        addView(editText);
    }


    /**
     * 显示右边编辑框
     */
    @SuppressLint("NewApi") private void initEditText() {
        EditText editText = new EditText(mContext);

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        layoutParams.addRule(LEFT_OF, R.id.right_image_id);

        layoutParams.setMargins(0, 0, mRightTextMarginRight, 0);

        editText.setLayoutParams(layoutParams);

        editText.setBackground(null);

        editText.setId(R.id.right_editText);

        editText.setHint(mRightEditTextHint);

        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightEditTextSize);

        editText.setTextColor(mRightEditTextColor);

        addView(editText);
    }


    /**
     * 显示底部边框线
     */
    private void initBottomLine() {

        View bottomLine = new View(mContext);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
            dip2px(mContext, 1));

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, TRUE);

        layoutParams.setMargins(mBottomLineMarginLeft, 0, mBottomMarginRight, 0);

        bottomLine.setLayoutParams(layoutParams);

        bottomLine.setBackgroundColor(lineColor);

        addView(bottomLine);
    }


    /**
     * 显示上边框线
     */
    private void initTopLine() {

        View topLine = new View(mContext);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
            dip2px(mContext, 1));

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, TRUE);

        layoutParams.setMargins(mTopLineMarginLeft, 0, mTopLineMarginRight, 0);

        topLine.setLayoutParams(layoutParams);

        topLine.setBackgroundColor(lineColor);

        addView(topLine);
    }


    /**
     * 设置右边文字
     */
    private void initRightText() {
        if (mRightTextNum >= 4) {

            throw new IllegalStateException("最多只能3个TextView");
        }

        RelativeLayout relativeLayout = new RelativeLayout(mContext);

        LayoutParams rlLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);

        rlLayoutParams.setMargins(mRightTextMarginLeft, mRightTextMarginTop, mBottomMarginRight,
            mRightTextMarginBottom);

        if (mCenterStr != null) {
            rlLayoutParams.addRule(RIGHT_OF, R.id.center_text_id);
        } else {
            if (mLeftText != null) {
                rlLayoutParams.addRule(RIGHT_OF, R.id.left_text_id);
            } else {
                rlLayoutParams.addRule(RIGHT_OF, R.id.left_image_id);
            }
        }

        rlLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        rlLayoutParams.addRule(LEFT_OF, R.id.right_image_id);

        relativeLayout.setLayoutParams(rlLayoutParams);

        if (mRightTextStr1 != null) {
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);

            TextView mRightTextView1 = new TextView(mContext);

            mRightTextView1.setId(R.id.right_textView1);

            mRightTextView1.setText(mRightTextStr1);

            mRightTextView1.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightTextSize1);

            mRightTextView1.setTextColor(mRightTextColor1);

            mRightTextView1.setLayoutParams(layoutParams);

            relativeLayout.addView(mRightTextView1);

        }

        if (mRightTextStr2 != null) {

            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
            layoutParams.addRule(RelativeLayout.BELOW, R.id.right_textView1);

            TextView mRightTextView2 = new TextView(mContext);

            mRightTextView2.setText(mRightTextStr2);

            mRightTextView2.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightTextSize2);

            mRightTextView2.setTextColor(mRightTextColor2);

            mRightTextView2.setId(R.id.right_textView2);

            mRightTextView2.setLayoutParams(layoutParams);

            relativeLayout.addView(mRightTextView2);
        }

        if (mRightTextStr3 != null) {
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
            layoutParams.addRule(RelativeLayout.BELOW, R.id.right_textView2);

            TextView mRightTextView3 = new TextView(mContext);

            mRightTextView3.setText(mRightTextStr3);

            mRightTextView3.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightTextSize3);

            mRightTextView3.setTextColor(mRightTextColor3);

            mRightTextView3.setLayoutParams(layoutParams);

            relativeLayout.addView(mRightTextView3);
        }

        addView(relativeLayout);

    }


    /**
     * 设置中间文字
     */
    private void initCenterStr() {
        TextView mCenterTextView = new TextView(mContext);

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.addRule(CENTER_VERTICAL, TRUE);

        layoutParams.addRule(CENTER_IN_PARENT, TRUE);

        mCenterTextView.setLayoutParams(layoutParams);

        mCenterTextView.setText(mCenterStr);
        mCenterTextView.setId(R.id.center_text_id);
        mCenterTextView.setTextColor(mCenterTextColor);

        mCenterTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mCenterTextSize);

        addView(mCenterTextView);
    }


    /**
     * 设置居中图片
     */
    private void initCenterIcon() {

        mCenterImageView = new ImageView(mContext);

        LayoutParams layoutParams = new LayoutParams(mCenterIconWidth, mCenterIconHeight);

        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);

        mCenterImageView.setLayoutParams(layoutParams);

        mCenterImageView.setId(R.id.center_image_id);

        mCenterImageView.setScaleType(ImageView.ScaleType.CENTER);

        mCenterImageView.setLayoutParams(layoutParams);

        mCenterImageView.setImageDrawable(mCenterIcon);

        addView(mCenterImageView);
    }


    /**
     * 设置右边button
     */
    @SuppressLint("NewApi") private void initRightButton() {
        mRightButton = new Button(mContext);

        LayoutParams rightButtonLayoutParams = new LayoutParams(mRightButtonWidth,
            mRightButtonHeight);

        rightButtonLayoutParams.addRule(RIGHT_OF, TRUE);

        rightButtonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);

        rightButtonLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        rightButtonLayoutParams.setMargins(0, 0, mMarginRight, 0);

        mRightButton.setLayoutParams(rightButtonLayoutParams);

        mRightButton.setBackground(mRigthButton);

        mRightButton.setText(mRightButtonTextStr);

        mRightButton.setId(R.id.right_button_id);

        mRightButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightButtonTextSize);

        mRightButton.setTextColor(mRightBtTextColor);
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                if (onRightBtnClicklistener != null) {
                    onRightBtnClicklistener.onRightBtnClick();
                }
            }
        });
        addView(mRightButton);
    }


    /**
     * 设置右边图片
     */
    private void initRightIcon() {
        ImageView mRightImageView = new ImageView(mContext);

        LayoutParams mRightIconLayoutParams = new LayoutParams(mRightIconWidth,
            mRightIconHeight);

        mRightIconLayoutParams.addRule(ALIGN_PARENT_RIGHT, TRUE);

        mRightIconLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        mRightIconLayoutParams.setMargins(0, 0, mMarginRight, 0);

        mRightImageView.setScaleType(ImageView.ScaleType.CENTER);

        mRightImageView.setLayoutParams(mRightIconLayoutParams);

        mRightImageView.setImageDrawable(mRigthIcon);

        mRightImageView.setId(R.id.right_image_id);
        mRightImageView.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                if (onRightImageClickListener != null) {
                    onRightImageClickListener.OnRightImageClick();
                }
            }
        });
        addView(mRightImageView);
    }


    /**
     * 设置左边文字
     */
    private void initLeftText() {

        leftTextView = new TextView(mContext);

        leftTextLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT);

        leftTextLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        leftTextLayoutParams.addRule(RelativeLayout.RIGHT_OF, R.id.left_image_id);

        leftTextLayoutParams.setMargins(marginLeft, 0, 0, 0);

        leftTextView.setLayoutParams(leftTextLayoutParams);

        leftTextView.setText(mLeftText);
        leftTextView.setId(R.id.left_text_id);
        leftTextView.setTextColor(leftTextColor);

        leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);

        addView(leftTextView);
    }


    /**
     * 设置背景颜色
     */
    private void initBackgroudColor() {
        this.setBackgroundColor(mBackgroudColor);

    }


    /**
     * 设置左边的图片
     */
    private void initLeftIcon() {

        mLeftImageView = new ImageView(mContext);

        LayoutParams mLeftIconLayoutParams = new LayoutParams(mLeftIconWidth,
            mLeftIconHeight);

        mLeftIconLayoutParams.addRule(ALIGN_PARENT_LEFT, TRUE);

        mLeftIconLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);

        mLeftIconLayoutParams.setMargins(marginLeft, 0, 0, 0);

        mLeftImageView.setScaleType(ImageView.ScaleType.CENTER);

        mLeftImageView.setLayoutParams(mLeftIconLayoutParams);

        mLeftImageView.setId(R.id.left_image_id);

        mLeftImageView.setImageDrawable(mLeftIcon);

        addView(mLeftImageView);

    }


    /**
     * 获取自定义的属性值
     */
    private void getAttrs(AttributeSet attrs) {

        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomView);

        mLeftIcon = typedArray.getDrawable(R.styleable.CustomView_cv_LeftIconRes);

        isShowLeftIcon = typedArray.getBoolean(R.styleable.CustomView_cv_isShowLeftIcon, false);

        mBackgroudColor = typedArray.getColor(R.styleable.CustomView_cv_BackgroudColor,
            defaultBgColor);

        mLeftText = typedArray.getString(R.styleable.CustomView_cv_LeftText);

        marginLeft = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_marginLeft, defMarginLeft);

        leftTextColor = typedArray.getColor(R.styleable.CustomView_cv_left_textColor,
            defaultTextColor);

        leftTextSize = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_left_textSize, defaultTextSize);

        mRigthIcon = typedArray.getDrawable(R.styleable.CustomView_cv_rigth_icon);

        isShowRightIcon = typedArray.getBoolean(R.styleable.CustomView_cv_isShowRightIcon, false);

        mMarginRight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_marginRight, defMarginLeft);

        mRigthButton = typedArray.getDrawable(R.styleable.CustomView_cv_right_button);

        mRightButtonTextStr = typedArray.getString(R.styleable.CustomView_cv_right_button_text);

        mRightButtonHeight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_button_height, defHeight);
        mRightButtonWidth = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_button_height, defWidth);

        mLeftIconHeight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_left_icon_height, defHeight);

        mLeftIconWidth = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_left_icon_width, defWidth);

        mRightIconHeight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_left_icon_height, defHeight);

        mRightIconWidth = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_left_icon_width, defWidth);

        mRightButtonTextSize = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_button_text_size, defaultTextSize);
        mRightBtTextColor = typedArray.getColor(R.styleable.CustomView_cv_right_button_text_color,
            defaultTextColor);

        mCenterIcon = typedArray.getDrawable(R.styleable.CustomView_cv_center_icon);

        mCenterIconHeight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_center_icon_height, defHeight);
        mCenterIconWidth = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_center_icon_width, defWidth);

        mCenterStr = typedArray.getString(R.styleable.CustomView_cv_center_textStr);

        mCenterTextColor = typedArray.getColor(
            R.styleable.CustomView_cv_center_text_color, defaultTextColor);

        mCenterTextSize = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_center_text_size, defaultTextSize);

        mRightTextStr1 = typedArray.getString(R.styleable.CustomView_cv_right_text_str1);

        mRightTextStr2 = typedArray.getString(R.styleable.CustomView_cv_right_text_str2);

        mRightTextStr3 = typedArray.getString(R.styleable.CustomView_cv_right_text_str3);

        mRightTextMarginRight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_text_marginRight, defMarginRiht);

        isShowTopLine = typedArray.getBoolean(R.styleable.CustomView_cv_is_show_top_line, false);

        isShowBottomLine = typedArray.getBoolean(R.styleable.CustomView_cv_is_show_bottom_line,
            false);

        mTopLineMarginLeft = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_top_line_marginLeft, defTopMarginLeft);

        mTopLineMarginRight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_top_line_marginLeft, defTopMarginRight);

        lineColor = typedArray.getColor(R.styleable.CustomView_cv_line_color, defaultLineColor);

        mBottomLineMarginLeft = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_bottom_line_marginLeft, defTopMarginLeft);

        mBottomMarginRight = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_bottom_line_marginRight, defTopMarginLeft);

        isShowBorder = typedArray.getBoolean(R.styleable.CustomView_cv_is_show_border, false);

        mRightEditTextHint
            = typedArray.getString(R.styleable.CustomView_cv_right_editText_hint_str);

        mRightEditTextSize = typedArray.getColor(R.styleable.CustomView_cv_right_editText_size,
            defaultTextSize);

        mRightEditTextColor = typedArray.getColor(
            R.styleable.CustomView_cv_right_editText_color, defaultTextColor);

        mRightTextNum = typedArray.getInteger(R.styleable.CustomView_cv_right_text_number, 1);

        mRightTextSize1 = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_text_size1, defaultTextColor);
        mRightTextSize2 = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_text_size2, defaultTextColor);
        mRightTextSize3 = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_text_size3, defaultTextColor);

        mRightTextColor1 = typedArray.getColor(
            R.styleable.CustomView_cv_right_text_color1, defaultTextColor);
        mRightTextColor2 = typedArray.getColor(
            R.styleable.CustomView_cv_right_text_color2, defaultTextColor);
        mRightTextColor3 = typedArray.getColor(
            R.styleable.CustomView_cv_right_text_color3, defaultTextColor);

        mRightTextMarginLeft = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_text_margin_left, defMarginLeft);

        mRightTextMarginTop = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_text_margin_top, defMarginLeft);

        mRightTextMarginBottom = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_right_text_margin_bottom, defMarginLeft);
        mLeftEditTextHint = typedArray.getString(R.styleable.CustomView_cv_left_editText_hint);
        mLeftEditTextSize = typedArray.getDimensionPixelSize(
            R.styleable.CustomView_cv_left_editText_size, defaultTextSize);

        mLeftEditTextColor = typedArray.getColor(R.styleable.CustomView_cv_left_editText_color,
            defaultTextColor);
        typedArray.recycle();
    }


    public int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    public int sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }


    public interface OnRightBtnClicklistener {
        void onRightBtnClick();
    }


    public interface OnRightImageClickListener {
        void OnRightImageClick();
    }


    public void setOnRightBtnClicklistener(OnRightBtnClicklistener onRightBtnClicklistener) {
        this.onRightBtnClicklistener = onRightBtnClicklistener;
    }


    public OnRightBtnClicklistener onRightBtnClicklistener;


    public void setOnRightImageClickListener(OnRightImageClickListener onRightImageClickListener) {
        this.onRightImageClickListener = onRightImageClickListener;
    }


    public OnRightImageClickListener onRightImageClickListener;
}

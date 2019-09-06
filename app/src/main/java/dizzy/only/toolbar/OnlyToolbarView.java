package dizzy.only.toolbar;

import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：OnlyToolbarView
 */
public class OnlyToolbarView extends Toolbar {

    Context mContext;
    ViewGroup.LayoutParams mWpWpParams;
    ViewGroup.LayoutParams mWpMhParams;
    LinearLayout onlyToolbarLl;
    LinearLayout onlyNegativeLl;
    LinearLayout onlyTitleLl;
    LinearLayout onlyPositiveLl;
    TextView mTitleText;
    ImageView mTitleImage;
    TextView mSTitleText;
    ImageView mSTitleImage;
    boolean mRippleState;
    int mBackgroundBorderless;

    public OnlyToolbarView(Context context) {
        this(context, null);
    }

    public OnlyToolbarView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public OnlyToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.setContentInsetsAbsolute(0, 0);
        View view = View.inflate(context, R.layout.only_toolbar_view, this);
        onlyToolbarLl = view.findViewById(R.id.only_toolbar_ll);
        onlyNegativeLl = view.findViewById(R.id.only_negative_ll);
        onlyTitleLl = view.findViewById(R.id.only_title_ll);
        onlyPositiveLl = view.findViewById(R.id.only_positive_ll);
        setBackgroundBorderless(true);
    }

    public void setBackgroundBorderless(boolean rippleState) {
        this.mRippleState = rippleState;
        if (mRippleState) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                TypedValue typedValue = new TypedValue();
                mContext.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, typedValue, true);
                this.mBackgroundBorderless = typedValue.resourceId;
            } else {
                this.mRippleState = false;
            }
        }
    }

    /************************* TitleText *************************/
    public TextView setTitleText(@StringRes int stringId, @ColorRes int colorId) {
        return setTitleText(mContext.getString(stringId), colorId, null, null);
    }

    public TextView setTitleText(String string, @ColorRes int colorId) {
        return setTitleText(string, colorId, null, null);
    }

    public TextView setTitleText(@StringRes int stringId, @ColorRes int colorId,
                                 OnClickListener onClickListener) {
        return setTitleText(mContext.getString(stringId), colorId, onClickListener, null);
    }

    public TextView setTitleText(String string, @ColorRes int colorId,
                                 OnClickListener onClickListener) {
        return setTitleText(string, colorId, onClickListener, null);
    }

    public TextView setTitleText(@StringRes int stringId, @ColorRes int colorId,
                                 OnLongClickListener onLongClickListener) {
        return setTitleText(mContext.getString(stringId), colorId, null, onLongClickListener);
    }

    public TextView setTitleText(String string, @ColorRes int colorId,
                                 OnLongClickListener onLongClickListener) {
        return setTitleText(string, colorId, null, onLongClickListener);
    }

    public TextView setTitleText(@StringRes int stringId, @ColorRes int colorId,
                                 OnClickListener onClickListener,
                                 OnLongClickListener onLongClickListener) {
        return setTitleText(mContext.getString(stringId), colorId, onClickListener, onLongClickListener);
    }

    public TextView setTitleText(String string, @ColorRes int colorId,
                                 OnClickListener onClickListener,
                                 OnLongClickListener onLongClickListener) {
        if (mTitleText == null) {
            mTitleText = getTitleText();
            if (mTitleImage != null) {
                onlyTitleLl.removeView(mTitleImage);
                mTitleImage = null;
            }
            onlyTitleLl.addView(mTitleText, 0);
        }
        mTitleText.setText(string);
        mTitleText.setTextColor(ContextCompat.getColor(mContext, colorId));
        if (onClickListener != null) {
            mTitleText.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            mTitleText.setOnLongClickListener(onLongClickListener);
        }
        return mTitleText;
    }

    /************************* TitleImage *************************/
    public ImageView setTitleImage(@DrawableRes int drawableId) {
        return setTitleImage(drawableId, null, null);
    }

    public ImageView setTitleImage(@DrawableRes int drawableId, OnClickListener onClickListener) {
        return setTitleImage(drawableId, onClickListener, null);
    }

    public ImageView setTitleImage(@DrawableRes int drawableId, OnLongClickListener onLongClickListener) {
        return setTitleImage(drawableId, null, onLongClickListener);
    }

    public ImageView setTitleImage(@DrawableRes int drawableId,
                                   OnClickListener onClickListener,
                                   OnLongClickListener onLongClickListener) {
        if (mTitleImage == null) {
            mTitleImage = getTitleImage();
            if (mTitleText != null) {
                onlyTitleLl.removeView(mTitleText);
                mTitleText = null;
            }
            onlyTitleLl.addView(mTitleImage, 0);
        }
        mTitleImage.setImageDrawable(ContextCompat.getDrawable(mContext, drawableId));
        if (onClickListener != null) {
            mTitleImage.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            mTitleImage.setOnLongClickListener(onLongClickListener);
        }
        return mTitleImage;
    }

    /************************* SubTitleText *************************/
    public TextView setSubTitleText(@StringRes int stringId, @ColorRes int colorId) {
        return setSubTitleText(mContext.getString(stringId), colorId, null, null);
    }

    public TextView setSubTitleText(String string, @ColorRes int colorId) {
        return setSubTitleText(string, colorId, null, null);
    }

    public TextView setSubTitleText(@StringRes int stringId, @ColorRes int colorId,
                                    OnClickListener onClickListener) {
        return setSubTitleText(mContext.getString(stringId), colorId, onClickListener, null);
    }

    public TextView setSubTitleText(String string, @ColorRes int colorId,
                                    OnClickListener onClickListener) {
        return setSubTitleText(string, colorId, onClickListener, null);
    }

    public TextView setSubTitleText(@StringRes int stringId, @ColorRes int colorId,
                                    OnLongClickListener onLongClickListener) {
        return setSubTitleText(mContext.getString(stringId), colorId, null, onLongClickListener);
    }

    public TextView setSubTitleText(String string, @ColorRes int colorId,
                                    OnLongClickListener onLongClickListener) {
        return setSubTitleText(string, colorId, null, onLongClickListener);
    }

    public TextView setSubTitleText(@StringRes int stringId, @ColorRes int colorId,
                                    OnClickListener onClickListener,
                                    OnLongClickListener onLongClickListener) {
        return setSubTitleText(mContext.getString(stringId), colorId, onClickListener, onLongClickListener);
    }

    public TextView setSubTitleText(String string, @ColorRes int colorId,
                                    OnClickListener onClickListener,
                                    OnLongClickListener onLongClickListener) {
        if (mSTitleText == null) {
            mSTitleText = getSubTitleText();
            if (mSTitleImage != null) {
                onlyTitleLl.removeView(mSTitleImage);
                mSTitleImage = null;
            }
            onlyTitleLl.addView(mSTitleText);
        }
        mSTitleText.setText(string);
        mSTitleText.setTextColor(ContextCompat.getColor(mContext, colorId));
        if (onClickListener != null) {
            mSTitleText.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            mSTitleText.setOnLongClickListener(onLongClickListener);
        }
        return mSTitleText;
    }

    /************************* SubTitleImage *************************/
    public ImageView setSubTitleImage(@DrawableRes int drawableId) {
        return setSubTitleImage(drawableId, null, null);
    }

    public ImageView setSubTitleImage(@DrawableRes int drawableId, OnClickListener onClickListener) {
        return setSubTitleImage(drawableId, onClickListener, null);
    }

    public ImageView setSubTitleImage(@DrawableRes int drawableId, OnLongClickListener onLongClickListener) {
        return setSubTitleImage(drawableId, null, onLongClickListener);
    }

    public ImageView setSubTitleImage(@DrawableRes int drawableId,
                                      OnClickListener onClickListener,
                                      OnLongClickListener onLongClickListener) {
        if (mSTitleImage == null) {
            mSTitleImage = getSubTitleImage();
            if (mSTitleText != null) {
                onlyTitleLl.removeView(mSTitleText);
                mSTitleText = null;
            }
            onlyTitleLl.addView(mSTitleImage);
        }
        mSTitleImage.setImageDrawable(ContextCompat.getDrawable(mContext, drawableId));
        if (onClickListener != null) {
            mSTitleImage.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            mSTitleImage.setOnLongClickListener(onLongClickListener);
        }
        return mSTitleImage;
    }

    /************************* NegativeText *************************/
    public TextView addNegativeText(@StringRes int stringId, @ColorRes int colorId) {
        return addNegativeText(mContext.getString(stringId), colorId, null, null);
    }

    public TextView addNegativeText(String string, @ColorRes int colorId) {
        return addNegativeText(string, colorId, null, null);
    }

    public TextView addNegativeText(@StringRes int stringId, @ColorRes int colorId,
                                    OnClickListener onClickListener) {
        return addNegativeText(mContext.getString(stringId), colorId, onClickListener, null);
    }

    public TextView addNegativeText(String string, @ColorRes int colorId,
                                    OnClickListener onClickListener) {
        return addNegativeText(string, colorId, onClickListener, null);
    }

    public TextView addNegativeText(@StringRes int stringId, @ColorRes int colorId,
                                    OnLongClickListener onLongClickListener) {
        return addNegativeText(mContext.getString(stringId), colorId, null, onLongClickListener);
    }

    public TextView addNegativeText(String string, @ColorRes int colorId,
                                    OnLongClickListener onLongClickListener) {
        return addNegativeText(string, colorId, null, onLongClickListener);
    }

    public TextView addNegativeText(@StringRes int stringId, @ColorRes int colorId,
                                    OnClickListener onClickListener,
                                    OnLongClickListener onLongClickListener) {
        return addNegativeText(mContext.getString(stringId), colorId, onClickListener, onLongClickListener);
    }

    public TextView addNegativeText(String string, @ColorRes int colorId,
                                    OnClickListener onClickListener,
                                    OnLongClickListener onLongClickListener) {
        TextView textView = getNPTiveText();
        textView.setText(string);
        textView.setTextColor(ContextCompat.getColor(mContext, colorId));
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            textView.setOnLongClickListener(onLongClickListener);
        }
        onlyNegativeLl.addView(textView);
        return textView;
    }

    /************************* NegativeImage *************************/
    public ImageView addNegativeImage(@DrawableRes int drawableId) {
        return addNegativeImage(drawableId, null, null);
    }

    public ImageView addNegativeImage(@DrawableRes int drawableId, OnClickListener onClickListener) {
        return addNegativeImage(drawableId, onClickListener, null);
    }

    public ImageView addNegativeImage(@DrawableRes int drawableId, OnLongClickListener onLongClickListener) {
        return addNegativeImage(drawableId, null, onLongClickListener);
    }

    public ImageView addNegativeImage(@DrawableRes int drawableId,
                                      OnClickListener onClickListener,
                                      OnLongClickListener onLongClickListener) {
        ImageView imageView = getNPTiveImage();
        imageView.setImageDrawable(ContextCompat.getDrawable(mContext, drawableId));
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            imageView.setOnLongClickListener(onLongClickListener);
        }
        onlyNegativeLl.addView(imageView);
        return imageView;
    }

    /************************* PositiveText *************************/
    public TextView addPositiveText(@StringRes int stringId, @ColorRes int colorId) {
        return addPositiveText(mContext.getString(stringId), colorId, null, null);
    }

    public TextView addPositiveText(String string, @ColorRes int colorId) {
        return addPositiveText(string, colorId, null, null);
    }

    public TextView addPositiveText(@StringRes int stringId, @ColorRes int colorId,
                                    OnClickListener onClickListener) {
        return addPositiveText(mContext.getString(stringId), colorId, onClickListener, null);
    }

    public TextView addPositiveText(String string, @ColorRes int colorId,
                                    OnClickListener onClickListener) {
        return addPositiveText(string, colorId, onClickListener, null);
    }

    public TextView addPositiveText(@StringRes int stringId, @ColorRes int colorId,
                                    OnLongClickListener onLongClickListener) {
        return addPositiveText(mContext.getString(stringId), colorId, null, onLongClickListener);
    }

    public TextView addPositiveText(String string, @ColorRes int colorId,
                                    OnLongClickListener onLongClickListener) {
        return addPositiveText(string, colorId, null, onLongClickListener);
    }

    public TextView addPositiveText(@StringRes int stringId, @ColorRes int colorId,
                                    OnClickListener onClickListener,
                                    OnLongClickListener onLongClickListener) {
        return addPositiveText(mContext.getString(stringId), colorId, onClickListener, onLongClickListener);
    }

    public TextView addPositiveText(String string, @ColorRes int colorId,
                                    OnClickListener onClickListener,
                                    OnLongClickListener onLongClickListener) {
        TextView textView = getNPTiveText();
        textView.setText(string);
        textView.setTextColor(ContextCompat.getColor(mContext, colorId));
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            textView.setOnLongClickListener(onLongClickListener);
        }
        onlyPositiveLl.addView(textView, 0);
        return textView;
    }

    /************************* PositiveImage *************************/
    public ImageView addPositiveImage(@DrawableRes int drawableId) {
        return addPositiveImage(drawableId, null, null);
    }

    public ImageView addPositiveImage(@DrawableRes int drawableId, OnClickListener onClickListener) {
        return addPositiveImage(drawableId, onClickListener, null);
    }

    public ImageView addPositiveImage(@DrawableRes int drawableId, OnLongClickListener onLongClickListener) {
        return addPositiveImage(drawableId, null, onLongClickListener);
    }

    public ImageView addPositiveImage(@DrawableRes int drawableId,
                                      OnClickListener onClickListener,
                                      OnLongClickListener onLongClickListener) {
        ImageView imageView = getNPTiveImage();
        imageView.setImageDrawable(ContextCompat.getDrawable(mContext, drawableId));
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
        if (onLongClickListener != null) {
            imageView.setOnLongClickListener(onLongClickListener);
        }
        onlyPositiveLl.addView(imageView, 0);
        return imageView;
    }

    /************************* GetView *************************/
    private TextView getTitleText() {
        TextView textView = new TextView(mContext);
        textView.setTextSize(18);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.getPaint().setFakeBoldText(true);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(getWpWpParams());
        return textView;
    }

    private ImageView getTitleImage() {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(getWpWpParams());
        return imageView;
    }

    private TextView getSubTitleText() {
        TextView textView = new TextView(mContext);
        textView.setTextSize(12);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(getWpWpParams());
        return textView;
    }

    private ImageView getSubTitleImage() {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(getWpWpParams());
        return imageView;
    }

    private TextView getNPTiveText() {
        TextView textView = new TextView(mContext);
        textView.setTextSize(16);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(getWpMhParams());
        if (mRippleState) {
            textView.setBackgroundResource(mBackgroundBorderless);
        }
        return textView;
    }

    private ImageView getNPTiveImage() {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(getWpMhParams());
        if (mRippleState) {
            imageView.setBackgroundResource(mBackgroundBorderless);
        }
        return imageView;
    }

    private ViewGroup.LayoutParams getWpWpParams() {
        if (mWpWpParams == null) {
            mWpWpParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        }
        return mWpWpParams;
    }

    private ViewGroup.LayoutParams getWpMhParams() {
        if (mWpMhParams == null) {
            mWpMhParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
        }
        return mWpMhParams;
    }

    public LinearLayout getToolbarLayout() {
        return onlyToolbarLl;
    }

    public LinearLayout getNegativeLayout() {
        return onlyNegativeLl;
    }

    public LinearLayout getTitleLayout() {
        return onlyTitleLl;
    }

    public LinearLayout getPositiveLayout() {
        return onlyPositiveLl;
    }

    /************************* Settings *************************/
    public void setToolbarView(View view) {
        if (view == null) {
            return;
        }
        onlyToolbarLl.removeAllViews();
        onlyToolbarLl.addView(view);
    }

    public void removeToolbarView() {
        OnlyToolbarView.this.removeAllViews();
    }

}

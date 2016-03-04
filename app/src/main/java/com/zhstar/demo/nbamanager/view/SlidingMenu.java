package com.zhstar.demo.nbamanager.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;
import com.zhstar.demo.nbamanager.R;

/**
 * Created by ceeg on 2015/5/4.
 */
public class SlidingMenu extends HorizontalScrollView {

    private int windowWidth;
    private LinearLayout wrapper;
    private ViewGroup menu;
    private ViewGroup content;

    private int menuToRight = 50;
    private boolean measured = false;

    private int menuWidth;

    boolean menuShow = false;

    public SlidingMenu(Context context) {
        this(context, null);
    }

    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

        menuToRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SlidingMenu, defStyleAttr, 0);

        int n = a.getIndexCount();

        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.SlidingMenu_rightPadding:
                    menuToRight = a.getDimensionPixelSize(attr, menuToRight);
                    break;
                default:
                    break;
            }
        }
        a.recycle();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        windowWidth = dm.widthPixels;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!measured) {
            wrapper = (LinearLayout) getChildAt(0);
            menu = (ViewGroup) wrapper.getChildAt(0);
            content = (ViewGroup) wrapper.getChildAt(1);

            menuWidth = menu.getLayoutParams().width = windowWidth - menuToRight;
            content.getLayoutParams().width = windowWidth;
            measured = true;
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        super.onLayout(changed, l, t, r, b);

        //if (changed)
            this.scrollTo(menuWidth, 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (scrollX >= menuWidth / 2) {
                    this.smoothScrollTo(menuWidth, 0);
                    menuShow = false;
                } else {
                    this.smoothScrollTo(0, 0);
                    menuShow = true;
                }

                return true;
        }

        return super.onTouchEvent(ev);
    }

    public void showMenu() {
        if (!menuShow) {
            this.smoothScrollTo(0, 0);
            menuShow = true;
            //loading team info lateast update
        }
    }

    public void hideMenu() {
        if (menuShow) {
            this.smoothScrollTo(menuWidth, 0);
            menuShow = false;
        }
    }

    public void toggleMenu() {
        if (menuShow) {
            hideMenu();
        } else {
            showMenu();
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //when wrappper move right,menu move left,to stay at the border
        ViewHelper.setTranslationX(menu, l*0.9f);

        float scale = (float) l / (float) menuWidth;

        float menuSizeScale = 1f - scale * 0.3f;
        float menuAlphaScale = 1f - scale * 0.4f;

        float contentSizeScale = 1f - (1f - scale) * 0.3f;
        //float contentAlphaScale = 1f - (1f - scale) * 0.4f;

        ViewHelper.setPivotX(menu, 0);
        ViewHelper.setPivotY(menu, menu.getHeight() / 2);
        ViewHelper.setScaleX(menu, menuSizeScale);
        ViewHelper.setScaleY(menu, menuSizeScale);
        ViewHelper.setAlpha(menu, menuAlphaScale);

        ViewHelper.setPivotX(content, 0);
        ViewHelper.setPivotY(content, content.getHeight() / 2);
        ViewHelper.setScaleX(content, contentSizeScale);
        ViewHelper.setScaleY(content, contentSizeScale);
    }
}

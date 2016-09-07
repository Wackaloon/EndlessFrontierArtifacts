package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by vladimiryuyukin on 22.04.16.
 */
public class ExRelativeLayout extends RelativeLayout {
    public ExRelativeLayout(Context context) {
        super(context);
    }

    public ExRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public float getXFraction() {
        int width = getWidth();
        return (width == 0) ? 0 : getX() / (float) width;
    }

    public void setXFraction(float xFraction) {
        int width = getWidth();
        setX((width > 0) ? (xFraction * width) : 0);
    }

    public float getYFraction() {
        int height = getHeight();
        return (height == 0) ? 0 : getY() / (float) height;
    }

    public void setYFraction(float yFraction) {
        int height = getHeight();
        setY((height > 0) ? (yFraction * height) : 0);
    }
}

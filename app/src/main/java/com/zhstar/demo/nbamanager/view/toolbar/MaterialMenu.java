package com.zhstar.demo.nbamanager.view.toolbar;

import android.view.animation.Interpolator;

import com.nineoldandroids.animation.Animator;
import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuDrawable.IconState;

/**
 * API for interaction with {@link MaterialMenuDrawable}
 */
public interface MaterialMenu {
    /**
     * Change icon without animation
     *
     * @param state new icon state
     */
    void setState(IconState state);

    /**
     * Return current icon state
     *
     * @return icon state
     */
    IconState getState();

    /**
     * Animate icon to given state.
     *
     * @param state new icon state
     */
    void animateState(IconState state);

    /**
     * Animate icon to given state and draw touch circle
     *
     * @param state new icon state
     * @deprecated Pressed state is not supported. Use {@link #animateState(IconState)}
     */
    @Deprecated
    void animatePressedState(IconState state);

    /**
     * Set color of icon
     *
     * @param color new icon color
     */
    void setColor(int color);

    /**
     * Set visibility of icon
     *
     * @param visible new value for visibility
     */
    void setVisible(boolean visible);

    /**
     * Set duration of transformation animations
     *
     * @param duration new animation duration
     */
    void setTransformationDuration(int duration);

    /**
     * Set interpolator for transformation animations
     *
     * @param interpolator new interpolator
     */
    void setInterpolator(Interpolator interpolator);

    /**
     * Set listener for {@code MaterialMenuDrawable} animation events
     *
     * @param listener new listener or null to remove any listener
     */
    void setAnimationListener(Animator.AnimatorListener listener);


    void setRTLEnabled(boolean rtlEnabled);


    void setTransformationOffset(MaterialMenuDrawable.AnimationState animationState, float value);


    MaterialMenuDrawable getDrawable();
}

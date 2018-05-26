package com.lty.animator;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TrembleAni extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        t.getMatrix().setTranslate(
                0,
                (float) Math.sin(interpolatedTime * 50) * 8
        );// 50越大频率越高，8越小振幅越小
        super.applyTransformation(interpolatedTime, t);
    }
}
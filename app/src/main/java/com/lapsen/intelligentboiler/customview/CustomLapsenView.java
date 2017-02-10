package com.lapsen.intelligentboiler.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.model.LottieComposition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * Created by lapsen_wang on 2017/2/10/0010.
 */

public class CustomLapsenView extends LinearLayout {

    private final Map<String, LottieComposition> compositionMap = new HashMap<>();
    private final List<View> views = new ArrayList<>();

    private final char[] lapsen = {'L', 'A', 'P', 'S', 'E', 'N'};

    @Nullable
    private LottieAnimationView cursorView;

    public CustomLapsenView(Context context) {
        super(context);
        init();
    }

    public CustomLapsenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomLapsenView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        for (int i = 0; i < lapsen.length; i++) {
                start(i);
        }
    }

    private void start(int i) {
        String letter = "" + Character.toUpperCase(lapsen[i]);
        final String fileName = letter + ".json";
        if (compositionMap.containsKey(fileName)) {
            addComposition(compositionMap.get(fileName));
        } else {
            LottieComposition.fromAssetFileName(getContext(), fileName,
                    new LottieComposition.OnCompositionLoadedListener() {
                        @Override
                        public void onCompositionLoaded(LottieComposition composition) {
                            compositionMap.put(fileName, composition);
                            addComposition(composition);
                        }
                    });
        }
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        if (index == -1) {
            views.add(child);
        } else {
            views.add(index, child);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (views.isEmpty()) {
            return;
        }
        int currentX = getPaddingTop();
        int currentY = getPaddingLeft();

        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            currentX += view.getWidth();
        }
        setMeasuredDimension(getMeasuredWidth(), currentY + views.get(views.size() - 1).getMeasuredHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (views.isEmpty()) {
            return;
        }
        int currentX = getPaddingTop();
        int currentY = getPaddingLeft();

        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            view.layout(currentX, currentY, currentX + view.getMeasuredWidth(),
                    currentY + view.getMeasuredHeight());
            currentX += view.getWidth();
        }
    }

    private void addComposition(LottieComposition composition) {

        LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
        CustomLapsenView.LayoutParams layoutParams = new CustomLapsenView.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.width = 120;
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = Gravity.CENTER;
        lottieAnimationView.setLayoutParams(layoutParams);
        lottieAnimationView.setComposition(composition);
        lottieAnimationView.playAnimation();
        if (cursorView == null) {
            addView(lottieAnimationView);
        } else {
            int index = indexOfChild(cursorView);
            addView(lottieAnimationView, index);
        }
    }

    private void removeLastView() {
        if (views.size() > 1) {
            int position = views.size() - 2;
            removeView(views.get(position));
            views.remove(position);
        }
    }

    private boolean isEnd(){
        if ( !cursorView.isAnimating()){
            return true;
        }
        return false;
    }
}

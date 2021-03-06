package com.gogocosmo.cosmoqiu.fire_sticker.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gogocosmo.cosmoqiu.fire_sticker.R;


public class CardFragment extends Fragment {

    private final String TAG = "MEMORY-ACC";

    private TextView mCard;
    private int mMarked = 0;
    private int mStamp = 0;
    private int mColor;
    private String mText;
    private int mIsLocked = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_card,
                container, false);

        ImageView lockStamp = (ImageView) view.findViewById(R.id.item_card_lock);
        ImageView bookMark = (ImageView) view.findViewById(R.id.item_card_bookmark);
        ImageView stampDone = (ImageView) view.findViewById(R.id.item_card_done);
        mCard = (TextView) view.findViewById(R.id.card);
        mCard.setBackgroundColor(mColor);

        if (mIsLocked == 1) {
            lockStamp.setVisibility(View.VISIBLE);
            bookMark.setVisibility(View.INVISIBLE);
            stampDone.setVisibility(View.INVISIBLE);
            return view;
        } else {
            lockStamp.setVisibility(View.INVISIBLE);
        }

        mCard.setText(mText);

        int cardPadding = 50;
        mCard.setPadding(cardPadding, cardPadding, cardPadding, cardPadding);

        if (mMarked == 0) {
            bookMark.setVisibility(View.INVISIBLE);
        }

        if (mStamp == 0) {
            stampDone.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    public void swipeDownEvent(String text) {

//        Integer colorFrom = Color.rgb(43, 94, 125);
//        Integer colorTo = mColor;
//        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
//        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animator) {
//                mCard.setBackgroundColor((Integer)animator.getAnimatedValue());
//            }
//
//        });
//        colorAnimation.start();
//        mCard.setBackgroundColor(mColor);
        if (mIsLocked == 1) {
            return ;
        }
        mCard.setText(text);
    }

    public void swipeUpEvent(String text) {

//        Integer colorFrom = mColor;
//        Integer colorTo = Targetcolor;
//        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
//        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animator) {
//                mCard.setBackgroundColor((Integer)animator.getAnimatedValue());
//            }
//
//        });
//        colorAnimation.start();

        if (mIsLocked == 1) {
            return ;
        }
        mCard.setText(text);
    }

    public void setCardColor(int color) {
        mColor = color;
    }

    public void setCardText(String text) {
        mText = text;
    }

    public void setMarked(int marked) {
        mMarked = marked;
    }

    public void setStamp(int stamp) {
        mStamp = stamp;
    }

    public void setLock(int lock) {
        mIsLocked = lock;
    }

    private void adjustCardTextFormat() {
        // If the line count in an EditText more than two, the texts should start from left;
        // else we put it in the center.

        mCard.post(new Runnable() {
            @Override
            public void run() {
                int lineCountFront = mCard.getLineCount();

                if (lineCountFront <= 1) {
                    mCard.setGravity(Gravity.CENTER);
                } else {
                    mCard.setGravity(Gravity.CENTER_VERTICAL);
                }
            }
        });
    }
}

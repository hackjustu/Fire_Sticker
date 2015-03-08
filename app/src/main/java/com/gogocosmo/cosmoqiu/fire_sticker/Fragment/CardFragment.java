package com.gogocosmo.cosmoqiu.fire_sticker.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gogocosmo.cosmoqiu.fire_sticker.R;


public class CardFragment extends Fragment {

    private final String TAG = "MEMORY-ACC";
    private TextView _card;
    private int _marked = 0;
    private int _stamp = 0;
    private int _color;
    private String _text;

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

        _card = (TextView) view.findViewById(R.id.card);
        _card.setBackgroundColor(_color);
        _card.setText(_text);

        int cardPadding = 50;
        _card.setPadding(cardPadding, cardPadding ,cardPadding ,cardPadding);

        ImageView bookMark = (ImageView) view.findViewById(R.id.item_card_bookmark);
        if (_marked == 0) {
            bookMark.setVisibility(View.INVISIBLE);
        }

        ImageView stampDone = (ImageView) view.findViewById(R.id.item_card_done);
        if (_stamp == 0) {
            stampDone.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    public void swipeDownEvent(String text) {

//        Integer colorFrom = Color.rgb(43, 94, 125);
//        Integer colorTo = _color;
//        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
//        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animator) {
//                _card.setBackgroundColor((Integer)animator.getAnimatedValue());
//            }
//
//        });
//        colorAnimation.start();
//        _card.setBackgroundColor(_color);
        _card.setText(text);
    }

    public void swipeUpEvent(String text) {

//        Integer colorFrom = _color;
//        Integer colorTo = Targetcolor;
//        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
//        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animator) {
//                _card.setBackgroundColor((Integer)animator.getAnimatedValue());
//            }
//
//        });
//        colorAnimation.start();

        _card.setText(text);
    }

    public void setCardColor(int color) {
        _color = color;
    }

    public void setCardText(String text) {
        _text = text;
    }

    public void setMarked(int marked) {
        _marked = marked;
    }

    public void setStamp(int stamp) {
        _stamp = stamp;
    }
}

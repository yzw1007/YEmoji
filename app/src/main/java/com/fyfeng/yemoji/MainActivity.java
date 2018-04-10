package com.fyfeng.yemoji;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.rockerhieu.emojicon.EmojiconEditText;
import io.github.rockerhieu.emojicon.EmojiconTextView;
import io.github.rockerhieu.emojicon.emoji.Emojicon;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements ExpFragment.OnFragmentInteractionListener {

    EmojiconEditText mEditEmojicon;
    EmojiconTextView mTxtEmojicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);

        ExpPagerAdapter expPagerAdapter = new ExpPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(expPagerAdapter);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        mEditEmojicon = findViewById(R.id.editEmojicon);
        mTxtEmojicon = findViewById(R.id.txtEmojicon);
        mEditEmojicon.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTxtEmojicon.setText(s);
            }
        });

    }

    public void onClickDeleteEdit(View view) {
        EmojiHelper.backspace(mEditEmojicon);
    }

    @Override
    public void onFragmentInteraction(Emojicon emojicon) {
        EmojiHelper.input(mEditEmojicon, emojicon);
    }

}

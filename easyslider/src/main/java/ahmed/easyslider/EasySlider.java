package ahmed.easyslider;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ahmed shaban on 5/11/2018.
 */

public class EasySlider extends RelativeLayout {
    View root;
    ViewPager pager;
    private List<SliderItem> sliderItems = new ArrayList<>();
    private SliderAdapter mSectionsPagerAdapter;
    private  Context context;
    private  int counter = 3000;
    static int min = 1;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int active = -1;
    private boolean hasDots = true;
    private boolean isFirstSwipe = true;
    private EasySliderListener easySliderListener;
    private View dots_container;

    public EasySlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        root = inflate(context,R.layout.slider_content,this);
        pager = root.findViewById(R.id.pager);
        dotsLayout = root.findViewById(R.id.dots_layout);
        dots_container = root.findViewById(R.id.dots_container);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switchDots(position,active);
                SliderFragment newfragment = (SliderFragment) mSectionsPagerAdapter.instantiateItem(pager, position);

                if(active!=-1){
                    SliderFragment oldfragment = (SliderFragment) mSectionsPagerAdapter.instantiateItem(pager, active);
                    oldfragment.hideTitle();
                }
                newfragment.showTitle();



                active = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }

    public  void  showDots(){
        dots_container.setVisibility(VISIBLE);
    }

    public  void  hideDots(){
        dots_container.setVisibility(GONE);
    }

    private void switchDots(int position, int active) {
        if(active!=-1){
            TextView oldPosition = (TextView) dotsLayout.getChildAt(active);
            TextView newPosition = (TextView) dotsLayout.getChildAt(position);
            oldPosition.setTextColor(Color.parseColor("#50ffffff"));
            newPosition.setTextColor(Color.WHITE);
        }
    }

    public  void setPages(List<SliderItem>  sliderItems){
        this.sliderItems.clear();
        this.sliderItems.addAll(sliderItems);
        mSectionsPagerAdapter = new SliderAdapter(((android.support.v4.app.FragmentActivity) context).getSupportFragmentManager(),sliderItems,easySliderListener);
        if(sliderItems.size() > 0){
            pager.setAdapter(mSectionsPagerAdapter);
            pager.setOffscreenPageLimit(sliderItems.size());
        }






        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                try {
                    if(min  < mSectionsPagerAdapter.sliderItems.size()){
                        pager.setCurrentItem(min);
                        min++;
                    }else {
                        min = 0;
                        pager.setCurrentItem(min);
                    }

                } catch (Exception e) {

                }

                handler.postDelayed(this, counter);
            }
        }, counter);


        initDots();

    }

    private void initDots() {
        dotsLayout.removeAllViews();
        dots = new TextView[sliderItems.size()];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            if(i!=0){
                dots[i].setTextColor(Color.parseColor("#50ffffff"));

            }else{
                dots[i].setTextColor(Color.WHITE);

            }
            dotsLayout.addView(dots[i]);
        }
    }

    public  void setTimer(int timer){
        try {
            if(timer >= 1000){
                this.counter = timer;
            }else{
                throw new Exception();
            }
        }catch (Exception timer1){
            Log.d("Slider error","timer must be equals or greater than 1 second ");
        }

    }

    public  void setOnItemClickListener(EasySliderListener easySliderListener){
        this.easySliderListener = easySliderListener;
    }
}

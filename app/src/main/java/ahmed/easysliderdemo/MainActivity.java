package ahmed.easysliderdemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class MainActivity extends AppCompatActivity {


    private EasySlider easySlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easySlider = findViewById(R.id.slider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("title1",R.drawable.slide2));
        sliderItems.add(new SliderItem("title2",R.drawable.slide3));
        sliderItems.add(new SliderItem("title3",R.drawable.slide4));
        sliderItems.add(new SliderItem("title4",R.drawable.slide6));
        easySlider.setPages(sliderItems);




    }



}

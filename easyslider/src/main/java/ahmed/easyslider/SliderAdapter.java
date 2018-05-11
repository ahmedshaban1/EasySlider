package ahmed.easyslider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Ahmed shaban on 5/11/2018.
 */

public class SliderAdapter extends FragmentPagerAdapter {
        List<SliderItem> sliderItems;

        public SliderAdapter(FragmentManager fm, List<SliderItem>  sliderItems) {
            super(fm);
           this.sliderItems = sliderItems;
        }

        @Override
        public Fragment getItem(int position) {

            return SliderFragment.newInstance(sliderItems.get(position));
        }

        @Override
        public int getCount() {
            return sliderItems.size();
        }
}


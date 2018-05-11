package ahmed.easyslider;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Ahmed shaban on 5/11/2018.
 */





/**
 * A placeholder fragment containing a simple view.
 */
public  class SliderFragment extends Fragment {

    SliderItem  item;
    LinearLayout title_layout ;
    TextView title;
    ImageView imageView;





    public SliderFragment() {
    }

    public static SliderFragment newInstance(SliderItem item) {
        SliderFragment fragment = new SliderFragment();
        Bundle args = new Bundle();
        args.putParcelable("item",item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = getArguments()
                .getParcelable("item");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.slider_item_container, container, false);
        title  = rootView.findViewById(R.id.title);
        title_layout = rootView.findViewById(R.id.title_layout);
        imageView = rootView.findViewById(R.id.img);

        if(item.getTitle() != null){
            title.setText(item.getTitle());
            title_layout.setVisibility(View.VISIBLE);
        }else{
            title_layout.setVisibility(View.GONE);
        }

        if(item.getResID()!=0){
            Picasso.get()
                    .load(item.getResID())
                    .into(imageView);
        }

        if(item.getUrl()!=null){
            Picasso.get()
                    .load(item.getUrl())
                    .into(imageView);
        }



        return rootView;
    }

    public void showTitle() {
       // hideTitle();
        Animation bottomUp = AnimationUtils.loadAnimation(getContext(),
                R.anim.bottom_up);
        title_layout.startAnimation(bottomUp);
        title_layout.setVisibility(View.VISIBLE);
    }

    public void hideTitle() {
        title_layout.setVisibility(View.GONE);
    }
}


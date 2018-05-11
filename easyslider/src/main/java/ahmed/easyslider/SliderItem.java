package ahmed.easyslider;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ahmed shaban on 5/11/2018.
 */

public class SliderItem implements Parcelable {
    private  String title;
    private  String url = null;

    public SliderItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public SliderItem(String title, int resID) {
        this.title = title;
        this.resID = resID;
    }

    protected SliderItem(Parcel in) {


        title = in.readString();
        url = in.readString();
        resID = in.readInt();
    }

    public static final Creator<SliderItem> CREATOR = new Creator<SliderItem>() {
        @Override
        public SliderItem createFromParcel(Parcel in) {
            return new SliderItem(in);
        }

        @Override
        public SliderItem[] newArray(int size) {
            return new SliderItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    private  int resID = 0;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(url);
        parcel.writeInt(resID);
    }
}

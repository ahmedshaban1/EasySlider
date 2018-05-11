# Easy Slider

Easy Slider is one of android libs that helping to create slider as fast as possible

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.



### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

```
dependencies {
	        implementation 'com.github.ahmedshaban1:EasySlider:1.0.0'
	}
```




### And coding style tests

Explain what these tests test and why 
* xml code
```
 <ahmed.easyslider.EasySlider
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/slider"/>
```

* java code 
```
  EasySlider easySlider = findViewById(R.id.slider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("title1",R.drawable.slide2));
        sliderItems.add(new SliderItem("title2",R.drawable.slide3));
        sliderItems.add(new SliderItem("title3",R.drawable.slide4));
        sliderItems.add(new SliderItem("title4",R.drawable.slide6));
        easySlider.setPages(sliderItems);
```

* you can add image url instead of  image id


* Screenshots  

 ![alt text](https://github.com/ahmedshaban1/EasySlider/blob/master/Screenshot_2018-05-11-18-44-00.png)
 ![alt text](https://github.com/ahmedshaban1/EasySlider/blob/master/Screenshot_2018-05-11-18-44-06.png)
 ![alt text](https://github.com/ahmedshaban1/EasySlider/blob/master/Screenshot_2018-05-11-18-44-10.png)


## Built With

* [picasso](http://square.github.io/picasso/)- Loading images framework


## Authors

* **Ahmed Shaban** 


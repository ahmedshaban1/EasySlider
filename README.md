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

## Built With

0* [picasso](http://square.github.io/picasso/)- Loading images framework

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Ahmed Shaban** 


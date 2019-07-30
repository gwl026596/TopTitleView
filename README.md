# TopTitleView
自定义方便好用的标题栏，可以添加标题，右边标题

在根 build.gradle中repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

可以直接在项目中在app build.gradle下添加
implementation 'com.github.gwl026596:TopTitleView:1.1.1'

```
<com.williamgeng.wight.TopView
    android:id="@+id/topView"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    app:title_color_toolbar="#FF6699"
    app:title_toolbar="我的钱包"
    app:title_size="17sp"
    />
```

可以添加标题栏的标题，标题颜色 标题右边的文本，或图片（样式如下图）
![image](https://github.com/gwl026596/TopTitleView/blob/master/app/src/main/res/mipmap-xxhdpi/test.jpg?raw=true)


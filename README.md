# CustomView


>介绍


####是不是觉得通常在设置界面中，我们会有很多相同的布局，只是显示不同效果，就造成了布局文件中存在大量相同的代码，复用性和可读性很差？ 写完布局之后，自己看都不想再看一下了？ 那么问题来了，只要你拥有这款DD，你就会省去一半的代码，对，你没有听错，没有看错，超简单，快试试吧。

----------

>截图

![](https://github.com/hyr0318/CustomView/blob/master/gif.gif)


----------

>使用方法

*	Gradle中添加：`compile 'cn.huangyirui.android:customview_library:1.0'`	

*	` xmlns:app="http://schemas.android.com/apk/res-auto"`


*	```
    <com.github.hyr0318.customview_library.CustomView
        android:layout_width="match_parent"
        android:layout_height="50dp"
        app:cv_center_icon="@mipmap/weixin"
        app:cv_is_show_bottom_line="true"/>



----------

>常用方法

    app:cv_center_icon="@mipmap/weixin" //设置中间图片

    app:cv_is_show_bottom_line="true"  //是否显示下边框

    app:cv_is_show_border="true"  //是否同时显示上下边框

    app:cv_center_textStr="中间文字"  //设置中间文字

    app:cv_center_text_size="14sp"   //设置中间文字大小

    app:cv_LeftIconRes="@mipmap/space_round"  //设置左边图片

    app:cv_LeftText="左边文字" //设置左边文字





####Development by
<br>Developer / Author: hyr0318
#####QQ:2045446584
#####Email:2045446584@qq.com
#####Github:[https://github.com/hyr0318/](https://github.com/hyr0318/)
----------
``` 
Copyright 2016 HuangYiRui

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
	
```

# imgReady
Use Javascript to determine if the picture has been loaded

因为在加载图片时有一个时间差，导致我获得img的length和width为0。
我也去网上找了一些方法，但是无论是原生js的onload还是jQuery的load。依旧会出现异步的情况。

后来我在[某个博客中](http://blog.phpdr.net/js-get-image-size.html)找到了一个好用的方法。现在我把它记录下来，并且感谢原po。

具体代码在utils中，这个方法的用法类似于Jquery的load，但是显然效果更佳。

ps.如果要获取动态的img的src

```
imgReady($("#pic")[0].src,function () {
         var $thisPic=$('#pic');
         var $thisSlider=$('#slider');
         var width=$thisPic.width();
         var height=$thisPic.height();
         function changePic() {
             var sliderVal=$thisSlider.slider( "value" )/100;
             $thisPic.width(width*sliderVal);
             $thisPic.height(height*sliderVal);
         }
         $thisSlider.slider({
             orientation: "horizontal",
             range: "min",
             max: 200,
             slide: changePic,
             change: changePic
             });
             $thisSlider.slider( "value", 100);
         });
```

```
<img id="pic" src="/appUser/getImg/{{item.signpicname}}">
```


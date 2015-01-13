package com.szq;

public class Content {
	static String[] title = { "文本1", "文本2" };
	static String[] content = {
			" 使用Fragment的时候可能需要在两个Fragment之间进行参数的传递，开始想着可以使用SharedPreferences进行处理，想想这些简单的参数没有必要使用这么麻烦的方式去实现，翻了一下Fragment的API，找到一个方法就能实现像Activity一样便捷的实现参数传递 程序中的一段代码",
			" 可以使用bundle进行参数传递，这样在两个Fragment跳转的时候就可以带上参数了，在另外一个Fragment获取参数的方式只需要一个语句String string = getArguments().getString();  key是自己定义的一个标识，参数的形式只要bundle能传递都可以实现" };
}

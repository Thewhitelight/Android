package geniuz.pathbuttons;

import android.app.Activity;
import android.os.Bundle;

import android.view.Window;
import android.widget.TextView;

public class BusContent extends Activity {
	private TextView busname = null;
	private TextView bustime = null;
	private TextView busfare = null;
	private TextView busremark = null;
	private TextView businfo = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bus);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// 淡入淡出效果
		busname = (TextView) findViewById(R.id.busname);
		bustime = (TextView) findViewById(R.id.bustime);
		busfare = (TextView) findViewById(R.id.busfare);
		busremark = (TextView) findViewById(R.id.busremark);
		businfo = (TextView) findViewById(R.id.businfo);
		long list_id = getIntent().getLongExtra("list_id", 0);
		if (list_id == 1) {
			busname.setText("101路");
			bustime.setText("客运中心  夏 6:00-17:40  冬 6:00-17:20" + "\n"
					+ "小芝  夏 5:50-17:20  冬6:00-17:00");
			busfare.setText("全程票价:14元");
			busremark.setText("15-20分钟/班");
			businfo.setText("客运中心—花街工业园—办事大厅—市一医院—职教中心—大洋小区—三峰—绿化—台州学院—双桥—丁家洋—佐溪-洛河—塘里-山前—礁墩—新街口—大田医院—大田交警队—大田刘村—横溪—法轮寺—上沙-勤勇—三佳—西洋头—格溪—大路头—沙溪下—下安—-麻山-呈岐-岭根—康谷—娄村—长坦—跃进—车口-下里—乌岩—丰-乌石头-小芝");

		}
		if (list_id == 2) {
			busname.setText("108路A");
			bustime.setText("夏 6:20-17:20  冬 7:20-17:0");
			busfare.setText("全程票价:7元");
			busremark.setText("60分钟/班");
			businfo.setText("客运中心——花街工业园客运中心—银泰城—市政府—农林水大厦—闸头—山峰—绿化—台州学院—双桥—丁家洋—佐溪—洛河—塘里—山前—礁墩—横街—新街口—大田站—大田中队—大田刘—横溪—白竹—岭头—两头门—峻头—下曼—牌前—江根—猫里岭—仙人桥 ");
		}
		if (list_id == 3) {
			busname.setText("108路B");
			bustime.setText("夏 6:00-17:00  冬 6:00-16:50");
			busfare.setText("全程票价:6元");
			busremark.setText("60分钟/班");
			businfo.setText("客运中心—银泰城—市政府—农林水大厦—闸头—山峰—绿化—台州学院—双桥—丁家洋—佐溪—洛河—塘里—山前—礁墩—横街—新街口—大田站—大田中队—大田刘—横溪—白竹—岭头—两头门—峻头—下曼—牌前—江根—西岙—桐岩岭 ");
		}
		if (list_id == 4) {
			busname.setText("108路C");
			bustime.setText("夏 6:40-17:40  冬 6:40-17:20");
			busfare.setText("全程票价:6元");
			busremark.setText("60分钟/班");
			businfo.setText("客运中心—银泰城—市政府—农林水大厦—闸头—山峰—绿化—台州学院—双桥—丁家洋—佐溪—洛河—塘里—山前—礁墩—横街—新街口—大田站—大田中队—大田刘—横溪—白竹—岭头—两头门—峻头—南城—利岙—西溪村");
		}
		if (list_id == 5) {
			busname.setText("109路");
			bustime.setText("夏 6:30-17:30  冬 6:30-17:10");
			busfare.setText("全程票价:6元");
			busremark.setText("60分钟/班");
			businfo.setText("客运中心—银泰城—市政府—农林水大厦—闸头—三峰—绿化—台州学院—双桥—丁家洋—佐溪—洛河—塘里—山前—礁墩—横街—新街口—大田下街—大田刘—青田—寺后—岩二—乌墩—东溪单—屈家—绚珠—庙西—金色佳苑—镇政府 ");
		}
		if (list_id == 6) {
			busname.setText("202路 绿化——市区——绿化");
			bustime.setText("夏 6:00-22:30  冬 6:30-22:00");
			busfare.setText("全程票价:2元");
			busremark.setText("8-12分钟/班");
			businfo.setText("绿化村—回浦中学—台州学院—绿化路口—三峰路口—大洋小区—职教中心—市一医院—办事大厅—花街工业园—客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园—耀达商场—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—妇幼保健院—耀达大厦—客运中心—花街工业园—办事大厅—市一医院—职教中心—大洋小区—三峰路口—绿化路口—台州学院—回浦中学—绿化村 ");
		}
		if (list_id == 7) {
			busname.setText("202路 三峰寺——市区——三峰寺");
			bustime.setText("夏 6:00-17:00  冬 6:30-17:00");
			busfare.setText("全程票价:2元");
			busremark.setText("定时发车");
			businfo.setText("三峰寺—三峰村—绿化村—回浦中学—台州学院—绿化路口—三峰路口—大洋小区—职教中心—市一医院—办事大厅—花街工业园—客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园—耀达商场—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—妇幼保健院—耀达大厦—客运中心—花街工业园—办事大厅—市一医院—职教中心—大洋小区—三峰路口—绿化路口—台州学院—回浦中学—绿化村—三峰村—三峰寺 ");
		}
		if (list_id == 8) {
			busname.setText("205路");
			bustime.setText("夏 6:00-22:30  冬 6:30-22:00");
			busfare.setText("全程票价:4元");
			busremark.setText("8-16分钟/班");
			businfo.setText("大田站—新街口—山前—塘里—洛河—丁家洋—双桥—台州学院—绿化—闸头—临海宾馆—市政府—银泰城—台州府路口—国际家园—洪池路口—揽胜门—哲商小学—方一仁—中心菜场—国贸宾馆—崇和门—小商品—耀达雍怡广场—市政府—闸头—绿化—台州学院—双桥—丁家洋—洛河—塘里—山前—横溪—新街口—大田站");
		}
		if (list_id == 10) {
			busname.setText("201路");
			bustime.setText("夏 6:00-18:00  冬 6:00-17:30");
			busfare.setText("全程票价:2元");
			busremark.setText("10分钟/班");
			businfo.setText("临海客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园—耀达商场（中医院）—台州宾馆—台州医院—临海中学—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—白云小区—花街—临海客运中心");
		}
		if (list_id == 11) {
			busname.setText("202路 绿化——市区——绿化");
			bustime.setText("夏 6:00-22:30  冬 6:30-22:00");
			busfare.setText("全程票价:2元");
			busremark.setText("8-12分钟/班");
			businfo.setText("绿化村—回浦中学—台州学院—绿化路口—三峰路口—大洋小区—职教中心—市一医院—办事大厅—花街工业园—客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园—耀达商场—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—妇幼保健院—耀达大厦—客运中心—花街工业园—办事大厅—市一医院—职教中心—大洋小区—三峰路口—绿化路口—台州学院—回浦中学—绿化村 ");
		}
		if (list_id == 12) {
			busname.setText("202路 三峰寺——市区——三峰寺");
			bustime.setText("夏 6:00-17:00  冬 6:30-17:00");
			busfare.setText("全程票价:2元");
			busremark.setText("定时发车");
			businfo.setText("三峰寺—三峰村—绿化村—回浦中学—台州学院—绿化路口—三峰路口—大洋小区—职教中心—市一医院—办事大厅—花街工业园—客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园—耀达商场—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—妇幼保健院—耀达大厦—客运中心—花街工业园—办事大厅—市一医院—职教中心—大洋小区—三峰路口—绿化路口—台州学院—回浦中学—绿化村—三峰村—三峰寺 ");
		}
		if (list_id == 13) {
			busname.setText("203路");
			bustime.setText("夏 6:00-22:30  冬 6:20-22:00");
			busfare.setText("全程票价:7元");
			busremark.setText("8-16分钟/班");
			businfo.setText("格溪沈—东塍车站—镇政府—杨塍—屈家路口—大房—上沙—法轮寺—横溪—大田刘—大田中队—大田站—新街口—礁墩—山前—塘里—洛河—第二职教中（新哲商）—学府家园—洛河公园（台州中学）—新桥头小区—林桥小区—商业步行街—体育中心—人才劳力市场—公安局—大柏叶—花街工业园—临海客运中心—耀达大厦—妇幼保健院——巾山小区——新江路口—小商品城—东湖公园—耀达商场（中医院）—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—妇幼保健院—耀达大厦—临海客运中心—花街工业园—大柏叶—公安局—人才劳力市场—体育中心—商业步行街—林桥小区—新桥头小区—洛河公园（台州中学）—学府家园—第二职教中心（新哲商  ）洛河—塘里-山前—礁墩—新街口—大田站—大田交警队—大田刘村—横溪—法轮寺—上沙—大房—屈家路口—杨塍—镇政府—东塍车站—格溪沈 ");
		}
		if (list_id == 14) {
			busname.setText("204路");
			bustime.setText("夏 5:50-18:00  冬 5:50-17:30");
			busfare.setText("全程票价:6元");
			busremark.setText("15分钟/班");
			businfo.setText("牛头山度假区—水管局—鼠岙村—山岔路口—塘上—柏树下—塘头—燕头—丁桥—大路章—大路魏—大路魏新村—邵家渡—邵家渡办事处—笕桥闸—枧桥董—前洋—枧西路口—大路王—五峰—西洋—洋头—大柏叶—花街工业园—临海客运中心—花街—白云小区—巾山小区—新江路口—小商品城—东湖公园—耀达商场（中医院）—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—白云小区—花街—临海客运中心—花街工业园—大柏叶—洋头—西洋—五峰—大路王 —枧西路口—前洋—枧桥董—笕桥闸—邵家渡办事处—邵家渡—大路魏新村—大路魏—大路章—丁桥—燕头—塘头—柏树下—塘上—山岔路口—鼠岙村—水管局—牛头山度假区 ");
		}
		if (list_id == 15) {
			busname.setText("205路");
			bustime.setText("夏 6:00-22:30  冬 6:30-22:00");
			busfare.setText("全程票价:4元");
			busremark.setText("8-16分钟/班");
			businfo.setText("大田站—新街口—山前—塘里—洛河—丁家洋—双桥—台州学院—绿化—闸头—临海宾馆—市政府—银泰城—台州府路口—国际家园—洪池路口—揽胜门—哲商小学—方一仁—中心菜场—国贸宾馆—崇和门—小商品—耀达雍怡广场—市政府—闸头—绿化—台州学院—双桥—丁家洋—洛河—塘里—山前—横溪—新街口—大田站");
		}
		if (list_id == 16) {
			busname.setText("209路");
			bustime.setText("夏 6:45-17:50  冬 6:45-17:30");
			busfare.setText("全程票价:2元");
			busremark.setText("30分钟/班");
			businfo.setText("临海客运中心—耀达大厦—妇幼保健院—巾山小区—金秋路口—兰田路口—小商品—东湖公园—耀达商场（中医院）—台州宾馆—哲商小学—台州初级中学—长城揽胜门—电大附中—古城办事处—小商品城—公管所—耀达大厦—临海客运中心 ");
		}
		if (list_id == 17) {
			busname.setText("211路");
			bustime.setText("夏 6:10-21:00  冬 6:10-21:00");
			busfare.setText("全程票价:4元");
			busremark.setText("10-15分钟/班（末班车时间与末班火车到达时间一致）");
			businfo.setText("火车站—山下坦—下沙马—西新村—恒源公司—前江村—伟星拉链—塘里—高新技术园—洛河公园—台州中学—湖景国际—儿童乐园—灵湖—体育中心—人才劳力市场—公安局—大柏叶—花街工业园—临海客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园");
		}
		if (list_id == 18) {
			busname.setText("211路");
			bustime.setText("夏 6:10-21:00  冬 6:10-21:00");
			busfare.setText("全程票价:4元");
			busremark.setText("10-15分钟/班（末班车时间与末班火车到达时间一致）");
			businfo.setText("东湖公园—国贸宾馆—新江路口—巾山小区—妇幼保健院—耀达大厦—临海客运中心—花街工业园—大柏叶—公安局—人才劳力市场—体育中心—儿童乐园—湖景国际—台州中学—洛河公园—高新技术园—塘里—伟星拉链—前江村—恒源公司—西新村—下沙马—山下坦—火车站");
		}
		if (list_id == 19) {
			busname.setText("215路");
			bustime.setText("夏 6:20-17:50  冬 6:20-17:30");
			busfare.setText("全程票价:2元");
			busremark.setText("70分钟/班");
			businfo.setText("松二—松一—松山—许墅—合利—殡仪馆—车门桥—后山检测站—后岭—后山村—洪池路口—东湖公园—耀达商场—台州宾馆—中心菜场—中意宾馆—国贸宾馆—崇和门—洪池路口—后山村—后岭—后山检测站—车门桥—殡仪馆—合利—松山—许墅—松山—松一—松二（大岭山）");
		}
		if (list_id == 20) {
			busname.setText("216路");
			bustime.setText("夏 6:00-21:00  冬 6:00-21:00");
			busfare.setText("全程票价:4元");
			busremark.setText("45分钟/班");
			businfo.setText("邵家渡—笕桥闸—前洋—枧西路口—大路王—台州中学—湖景国际—儿童乐园—洋头—大柏叶—花街工业园—客运中心—白云小区—巾山小区—新江路口—国贸宾馆—东湖公园—小商品城—新江路口—巾山小区—白云小区—东方百货—客运中心—花街工业园—邵家渡");
		}
		if (list_id == 21) {
			busname.setText("217路");
			bustime.setText("客运中心 6:20 8:00 10:00 14:00 16:30\n龙潭岙 6:50 9:00 11:00 15:00 17:20\n紫沙岙 7:05 9:15 11:15 15:15 17:35");
			busfare.setText("全程票价:2元");
			busremark.setText("定时发车");
			businfo.setText("临海客运中心—耀达大厦—妇幼保健院—阳光购物—下桥路—老市区中队—水果市场—颐高数码城—农业银行—小商品城—东湖公园—小姑岭—巾山新村—临海六中—拘留所—九畹兰庄—紫沙岙—九畹兰庄—拘留所—灵江小区—望江门—望江门菜场—捷能化工厂—岔路口—长家山—延龙桥—岙口—山头王—金家—延庆寺—上王 ");
		}
		if (list_id == 22) {
			busname.setText("217路");
			bustime.setText("客运中心 6:20 8:00 10:00 14:00 16:30\n龙潭岙 6:50 9:00 11:00 15:00 17:20\n紫沙岙 7:05 9:15 11:15 15:15 17:35");
			busfare.setText("全程票价:2元");
			busremark.setText("定时发车");
			businfo.setText("上王—延庆寺—金家—山头王—岙口—延龙桥—长家山—岔路口—捷能化工厂—望江门菜场—望江门—灵江小区—拘留所—九畹兰庄—紫沙岙—九畹兰庄—拘留所—临海六中—巾山新村—小姑岭—国贸宾馆—农业银行—颐高数码城—水果市场—老市区中队—下桥路—阳光购物—妇幼保健院—耀达大厦—临海客运中心 ");
		}
		if (list_id == 23) {
			busname.setText("218路");
			bustime.setText("崇和门 7:00 8:00 13:00 14:00");
			busfare.setText("全程票价:18元");
			busremark.setText("定时发车");
			businfo.setText("崇和门—临海客运中心—法轮寺—桃渚城址—海山公园—桃渚城址—法轮寺—临海客运中心—崇和门");
		}
		if (list_id == 24) {
			busname.setText("222路");
			bustime.setText("7:00 8:30 10:00 12:00 13:20 14:40 16:00 17:20");
			busfare.setText("全程票价:3元");
			busremark.setText("定时发车");
			businfo.setText("双桥村—下沈村—浙江临海监狱—亘古电缆—佐溪路口—丁家洋—永利驾校—林桥—吉利学院—商业街—大洋小区—职教中心—市一医院—办事大厅—花街工业园—客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园—耀达商场—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—白云小区—客运中心—花街工业园—办事大厅—市一医院—职教中心—大洋小区—商业街—吉利学院—永利驾校—丁家洋—佐溪路口—亘古电缆—浙江临海监狱—下沈村—双桥");
		}
		if (list_id == 25) {
			busname.setText("222路");
			bustime.setText("7:00 9:10 11:00 12:50 15:00");
			busfare.setText("全程票价:5元");
			busremark.setText("定时发车");
			businfo.setText("家具城—青田—横溪—大田刘—大田交警队—大田站—方家弄—双山—永强—佐溪—临海监狱—亘古电缆—丁家洋—永利驾校—林桥—吉利学院—商业街—大洋小区—职教中心—市一医院—办事大厅—花街工业园—客运中心—耀达大厦—耀达雍怡广场—小商品城—东湖公园—耀达商场—台州宾馆—中心菜场—中意宾馆—国贸宾馆—新江路口—巾山小区—白云小区—客运中心—花街工业园—办事大厅—市一医院—职教中心—大洋小区—商业街—吉利学院—永利驾校—丁家洋—佐溪路口—亘古电缆—浙江临海监狱—佐溪—永强—双山—方家弄—大满堂—大田站—横溪—青田—家具城 ");
		}
	}
}

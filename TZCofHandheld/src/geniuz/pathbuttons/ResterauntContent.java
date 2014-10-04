package geniuz.pathbuttons;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.widget.TextView;

public class ResterauntContent extends Activity {
	private TextView resterauntname = null;
	private TextView resterauntnumber1 = null;
	private TextView resterauntnumber2 = null;
	private TextView resterauntnumber3 = null;
	private TextView foodmenu = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resteraunt_content);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// 淡入淡出效果
		resterauntname = (TextView) findViewById(R.id.resterauntname);
		resterauntnumber1 = (TextView) findViewById(R.id.resterauntnumber1);
		resterauntnumber2 = (TextView) findViewById(R.id.resterauntnumber2);
		resterauntnumber3 = (TextView) findViewById(R.id.resterauntnumber3);
		foodmenu = (TextView) findViewById(R.id.foodmenu);
		long list_id = getIntent().getLongExtra("list_id", 0);
		if (list_id == 0) {
			String number1 = "656325  ";
			String number2 = "818888  ";
			resterauntname.append("八仟八");
			resterauntname.setTextColor(Color.BLACK);
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("东坡肉（蔬菜+米饭） 套餐A 10元 套餐B 11元\n回锅肉（蔬菜+米饭） 套餐A 10元 套餐B 11元\n鸭肉（蔬菜+米饭） 套餐A 10元 套餐B 11元\n小排（蔬菜+米饭） 套餐A 10元 套餐B 11元\n红烧牛肉（蔬菜+米饭） 套餐A 10元 套餐B 11元\n鱼类（蔬菜+米饭） 套餐A 10元 套餐B 11元\n可乐鸡翅（蔬菜+米饭） 套餐A 10元 套餐B 11元\n大排（蔬菜+米饭） 套餐A 10元 套餐B 11元\n红烧肉（蔬菜+米饭） 套餐A 10元 套餐B 11元\n肉片类（蔬菜+米饭） 套餐A 10元 套餐B 11元\n肉丝类（蔬菜+米饭） 套餐A 10元 套餐B 11元\n肉蒸蛋（蔬菜+米饭） 套餐A 9元 套餐B 10元\n香肠（蔬菜+米饭） 套餐A 9元 套餐B 10元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
			// foodmenu.setTextColor(Color.BLACK);
			foodmenu.setTextColor(0xffff00ff);// 0X颜色整数标记 FF透明度标记 FF00FF为颜色标记
		}
		if (list_id == 1) {
			String number1 = "673866  ";
			String number2 = "13958553866  ";
			resterauntname.append("菜芽桶");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("鸡腿饭 10元\n鱼香肉丝饭 10元\n新奥尔良鸡排饭 11元\n叉烧饭 12元\n红烧排骨饭 12元\n咖喱鸡饭 12元\n黑椒牛柳饭 12元\n猪排饭 13元\n 番茄意式肉酱面 12元\n黑椒意式肉酱面 12元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 2) {
			String number1 = "663989  ";
			String number2 = "18858624710  ";
			resterauntname.append("茶余饭后");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber3.setText("684710");
			resterauntnumber3.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【特色主食】\n经典鸡腿堡       8元\n超级鸡腿堡       12元\n奥尔良鸡腿堡     9元\n至尊全虾堡       9元\n田园脆鸡堡      6元\n经典牛肉堡       6元\n巨无霸牛肉堡     8元\n墨西哥鸡肉卷     7元\n【精美配餐】\n脆皮全鸡         18元\n蜜汁手扒鸡       18元\n奥尔良烤翅       7元\n香辣鸡翅         6元\n黄金蝴蝶虾     5元/2只\n骨肉相连       5元/2串\n川香鸡柳       5元/2串\n经典鸡块         5元\n黄金鸡柳       5元/5串\n劲爆鸡米花       5元\n美式薯条         6元\n黄金小鸡腿       3元\n葡式蛋挞       6元/2只\n油炸冰淇淋     5元/4只\n香芋地瓜丸     5元/5只\n芒果慕斯       5元/3根\n劲爆爆米花（大包） 8元\n【饮品专区】\n皇家奶茶             7元\n奶茶烧香草           5元\n牛奶烧仙草           5元\n经典奶茶             3元\n香芋奶茶             5元\n红豆奶茶             4元\n布丁奶茶             4元\n红豆布丁奶茶         5元\n红豆泡沫奶           5元\n冰爽青柠             3元\n柠檬红茶             4元\n玫瑰花茶             5元\n金桔柠檬             5元\n酷夏青橘             5元\n冰糖芦荟             4元\n芦荟柠檬             5元\n蜂蜜柚子茶           5元\n金桔柚子茶           5元\n古早酸梅汁           5元\n红豆布丁             5元\n芋圆布丁             5元\n原味旋风             5元\n摩卡旋风             5元\n抹茶红豆             5元\n红豆仙草抹茶         6元\n红豆布丁抹茶         6元\n蓝莓养颜沙冰         5元\n香浓芒果冰沙         5元\n甘酸相思豆冰沙      5元\n花式刨冰（蓝莓/芒果）5元\n可乐（小/大）        3/4元\n雪碧（小/大）        3/4元\n橙汁（小/大）        3/4元\n啤酒                 4元 \n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 3) {
			String number1 = "13252459951  ";
			resterauntname.append("大田排面");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【炒糕类】\n大排炒糕     10元\n小排炒糕     10元\n三鲜炒糕     8元\n肉丝炒糕     7元\n鸡蛋炒糕     7元\n【汤糕类】\n大排汤糕     10元\n小排汤糕     10元\n三鲜汤糕     8元\n肉丝汤糕     7元\n鸡蛋汤糕     7元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 4) {
			String number1 = "665163  ";
			resterauntname.append("大嘴巴风味美食");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【炒饭】\n蛋炒饭 6元\n梅干菜蛋炒饭 6元\n香辣肉丝蛋炒饭 7元\n扬州蛋炒饭 7元\n【炒面】\n鸡蛋炒面 7元\n鸡蛋肉丝炒面 8元\n牛炒面 9元\n【套餐】\n香辣肉丝套餐 8元\n腊肉套餐 8元\n梅菜扣肉套餐 9元\n牛肉套餐 9元\n北京烤鸭套餐 9元\n辣子鸡丁套餐 9元\n三黄土鸡套餐 9元\n排骨套餐 10元");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 5) {
			String number1 = "660366  ";
			String number2 = "13606655163  ";
			resterauntname.append("顶好美味");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【美味套餐】\n腊肠套餐  8元\n香辣菜肉丝套餐  8元\n腊肉套餐  8元\n老干妈腊肉套餐  9元\n梅菜扣肉套餐  9元\n牛肉套餐  9元\n老干妈牛肉套餐  9元\n北京烤鸭套餐  9元\n红烧大虾套餐  10元\n带鱼套餐  10元\n排骨套餐  10元\n老干妈排骨套餐  10元\n香辣小鱼套餐  10元\n【美味盖浇饭类】\n腊肠盖浇饭  7元\n梅菜火腿盖浇饭  7元\n酸豆角肉丝盖浇饭  7元\n梅香烤肉盖浇饭  8元\n香辣菜肉丝盖浇饭  8元\n炖肉盖浇饭  8元\n梅菜扣肉盖浇饭  8元\n北京烤鸭盖浇饭  8元\n五香牛肉盖浇饭  8元\n带鱼盖浇饭  9元\n排骨盖浇饭  9元\n红烧大虾盖浇饭  9元\n香辣小鱼盖浇饭  9元\n【其它】\n加荷包蛋 1.5元\n  加肉丝 2元  \n加腊肠 2元  \n加火腿肠 2元  \n雪碧/可乐 3元/罐）\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 6) {
			String number2 = "621923";
			resterauntname.append("东北大馅水饺");
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("猪肉芹菜0.6/个\n 猪肉白菜0.6/个\n 猪肉韭菜0.6/个\n 纯牛肉1/个\n 小盘6/盘（10个）\n 中盘9/盘（15个）\n 大盘12/盘（20个）\n红烧肉盖浇饭 9元\n 各种炝拌小菜 4元/盘");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 7) {
			String number1 = "628153  ";
			String number2 = "18858675592";
			resterauntname.append("饭宝宝");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("咖喱炒饭           7元\n扬州炒饭           6元\n腊肉炒饭           8元\n羊肉炒饭           8元\n蛋炒饭             5元\n妈妈炒饭           7元\n香菇鸡肉炒饭       7元\n鱼香肉丝盖饭       8元\n辣子鸡丁盖饭       8元\n香肠美极炒饭       7元\n 小日本豆腐盖饭     10元\n牛肉粉丝           5元\n（单笔消费满50赠送蛋炒饭）");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 8) {
			String number2 = "18069306171";
			resterauntname.append("云南过桥米线");
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("鸡蛋炒饭 7元\n 火腿炒饭 7元\n 鸡肉炒饭 7元\n 鸡蛋火腿 8元\n 鸡蛋炒年糕 7元\n 鸡肉炒年糕 7元\n 香肠炒饭 7元\n 肉丝炒饭 7元\n牛肉炒饭 9元\n 牛肉炒年糕 9元\n 香肠炒年糕 7元\n 肉丝炒年糕 7元\n 素菜：青菜 鹌鹑蛋 蘑菇 木耳 豆芽 千张皮\n 荤菜：鱼丸 虾丸 鱼肉片 夹心鱼豆腐 牛肉丸 燕肉饺 桂花肠\n 火腿 牛肉 里脊 鸡肉 香肠 蟹棒 蟹排\n 8元 6种素菜 送1种荤菜 米线6两\n 鸡蛋炒米线9 肉丝炒米线9 香肠炒米线9 牛肉炒米线10 凉拌米线6\n鸭脖5 鸭翅膀4 鸭头3 鸭爪1.5/个；5元/4个\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 9) {
			String number2 = "15888631612";
			resterauntname.append("豪大大香鸡排");
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("大鸡排9 \n超级大鸡排11 \n脆皮鸡腿9 \n葱烧鸡翅6 \n盐酥鸡（原味/柠檬）6\n鱿鱼酥5\n 脆皮鸡块5 \n甜不辣5\n 碳烤大鸡排11 \n碳烤鸡腿9\n 碳烤鸡翅6\n花枝丸5 脆\n皮鸡块（黑胡椒）5 \n香芋甜心5\n 香肠小丸子5 \n芋头糕5 \n米血糕5 \n甘梅地瓜5\n 四季豆3 \n糯米肠5 \n台湾香肠3 \n大肠包小肠7\n 热狗大亨4 \n黄金鸡排卷7\n起送价：20");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 10) {
			String number1 = "660366  ";
			String number2 = "15068629399  ";
			resterauntname.append("荷香特色美食");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber3.setText("679399");
			resterauntnumber3.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【特色蛋炒饭】\n甜玉米蛋炒饭               6元\n咖喱饭炒饭                 6元\n梅干菜蛋炒饭               6元\n鸡汁萝卜蛋炒饭（微辣）     6元\n老干妈蛋炒饭（微辣）       6元\n香辣菜蛋炒饭（微辣）       6元\n酸豆角蛋炒饭（微辣）       6元\n肉丝蛋炒饭                 7元\n酸豆角肉丝蛋炒饭（微辣）   7元\n小虾米蛋炒饭               7元\n腊肠蛋炒饭                7元\n【炒面类】（小麦面）\n鸡蛋炒面                   7元\n肉丝炒面                   8元\n牛肉炒面                   9元\n孜然烤肉炒面               9元\n【特色蛋炒饭类】\n梅干菜火腿肠蛋炒饭         7元\n火腿肠蛋炒饭               7元\n梅菜扣肉蛋炒饭             8元\n腊肉蛋炒饭                 8元\n香叶鸡蛋炒饭               9元\n辣子鸡丁蛋炒饭（辣）       9元\n孜然烤肉蛋炒饭             9元\n烤鸭蛋炒饭                 9元\n五香牛肉蛋炒饭（微辣）     9元\n啦干嘛牛肉蛋炒饭（微辣）   9元\n排骨蛋炒饭                 10元\n【其它】\n加荷包蛋                   1.5元\n加腊肠/火腿肠              2元\n加肉丝                     2元\n【饮料】\n雪碧/可乐                  3元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 11) {
			String number1 = "85190210  ";
			resterauntname.append("华莱士");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("汉堡+玉米杯+中可=10元\n鸡肉卷+玉米杯+中可=10元\n汉堡+小薯条+中可=13元\n鸡肉卷 +小薯条+中可=13元\n汉堡+鸡米花+中可=14元\n鸡肉卷+鸡腿+中可=14元\n汉堡+2串华香脆骨串+中可=14元\n鸡肉卷+黑椒鸡块+中可=14元\n汉堡+烤翅+薯条+中可=17元\n鸡肉卷+鸡翅+薯条+中可=17元\n汉堡+玉米杯+鸡腿+中可=17元\n鸡肉卷+黑椒鸡块+薯条+中可=17元\n【单点】\n无骨鸡柳 6元\n无骨大亨 7元\n劲脆鲜虾堡 8元\n秘制鸡腿堡 8元\n香鸡堡 8元\n牛肉堡 7元\n辣味鸡肉卷 8元\n泰式鸡肉卷 8元\n鸡米花 5元\n【脆皮鸡/蜜汁手扒鸡 18元/只】");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 12) {
			String number1 = "645153  ";
			String number2 = "18767685153";
			resterauntname.append("劲道拉面");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("牛肉炒拉面 13元\n劲道浓骨拉面 13元\n蒜香浓骨拉面 13元\n日式酱油拉面 13元\n极品海鲜拉面 15元\n超级辛口拉面 13元\n老北京炸酱面 13元\n延吉牛肉冷面 15元\n芥末乌冬拌面 15元\n冰镇酸梅汤 4元\n蜂蜜柚子茶 4元\n可乐/雪碧/芬达 3元\n【费用】外加一元打包费");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 13) {
			String number1 = "669742  ";
			String number2 = "85318309";
			resterauntname.append("拉面大王");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("牛肉拉面      7元\n牛肉刀削面    7元\n牛肉凉拌面    8元\n牛肉炒拉面    10元\n牛肉炒刀面    10元\n牛肉炸酱面    10元\n羊肉泡馍      12元\n牛肉泡馍      12元\n红烧牛肉面    10元\n鸡蛋拉面      7元\n牛肉烩面      10元\n牛肉粉丝汤    8元\n牛肉汤米面    7元\n牛肉炒面片    12元\n【拌面类】\n红烧牛肉拌面  12元\n红烧鸡块拌面  12元\n青椒牛肉拌面  10元\n葱油拌面       8元\n青椒土豆丝拌面 8元\n土豆牛肉拌面  10元\n洋葱炒肉拌面  10元\n孜然羊肉拌面  12元\n酸辣白菜拌面  8元\n蒜苔炒肉拌面  10元\n蘑菇炒肉拌面  10元\n番茄炒蛋拌面  10元\n葱爆炒肉拌面  10元\n新疆拌面      12元\n  【特色炒菜类】\n孜然羊肉         30元\n红烧牛肉         30元\n土豆烧牛肉       25元\n新疆大盘鸡       55元\n酸菜白菜         10元\n蘑菇炒牛肉       20元\n番茄炒蛋         10元\n凉拌牛肉         25元\n青椒炒牛肉       15元\n蒜苔炒牛肉       15元\n【炒饭    炒年糕】\n牛肉炒饭         7元\n鸡蛋炒饭         7元\n番茄蛋炒饭       8元\n兰州炒饭         8元\n牛肉炒年糕       7元\n鸡蛋炒年糕       7元\n青菜炒年糕       7元\n牛肉炒米面       7元\n【盖浇饭类】\n青椒炒肉盖浇饭   8元\n红烧牛肉盖浇饭   10元\n蒜苔炒肉盖浇饭   8元\n土豆牛肉盖浇饭   8元\n蘑菇炒肉盖浇饭   8元\n孜然炒肉盖浇饭   10元\n洋葱炒肉盖浇饭   8元\n青椒土豆丝盖浇饭 7元\n番茄炒蛋盖浇饭   8元\n红烧鸡块盖浇饭   10元\n葱爆羊肉盖浇饭   8元\n鱼香肉丝盖浇饭   10元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 14) {
			String number1 = "665163  ";
			String number2 = "13606655163";
			resterauntname.append("美味苑");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【盖浇饭】\n酸豆角肉丝 盖浇饭 7元\n腊肠盖浇饭 7元\n梅菜火腿盖浇饭 7元\n炖肉盖浇饭 8元\n梅菜扣肉盖浇饭 8元\n农家腊肉盖浇饭 8元\n梅香烤肉盖浇饭 9元\n鼎香烤肉盖浇饭 9元\n辣子鸡丁盖浇饭 9元\n烤鸭盖浇饭 9元\n五香牛肉盖浇饭 9元\n排骨盖浇饭 10元\n【炒面】\n鸡蛋炒面 7元\n肉丝炒面 8元\n牛肉炒面 9元\n【蒸面】\n酸豆角肉丝蒸面 8元\n梅菜火腿蒸面 8元\n肉丝蒸面 8元\n烤鸭蒸面 9元\n五香牛肉蒸面 9元\n排骨蒸面 10元\n【蛋炒饭】\n蛋炒饭 6元\n咖喱蛋炒饭 6元\n老干妈蛋炒饭 6元\n梅干菜蛋炒饭 6元\n酸豆角蛋炒饭 6元\n肉丝蛋炒饭 7元\n酸豆角肉丝蛋炒饭 7元\n梅菜火腿蛋炒饭 7元\n腊肠蛋炒饭 7元\n梅菜扣肉蛋炒饭 8元\n农家腊肉蛋炒饭 8元\n梅香烤肉蛋炒饭 9元\n烤鸭蛋炒饭 9元\n鼎香鸡蛋炒饭 9元\n五香牛肉蛋炒饭 9元\n排骨蛋炒饭 10元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 15) {
			String number1 = "672390";
			resterauntname.append("米宝宝");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("脆皮鸡腿饭 13元\n韭黄炒蛋饭 8元\n火腿肠炒饭 8元\n鱼香肉丝饭 9元\n台式鱼排饭 10元\n台式香肠饭 10元\n红烧狮子头饭 10元\n宫保鸡丁饭 10元\n台式排骨饭 11元\n梅菜扣肉饭 11元\n蜜汁叉烧饭 11元\n台湾卤肉饭 11元\n台湾鸡排饭 12元\n糖醋排骨饭 12元\n港式牛排饭 12元\n酱鸭腿饭 13元");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 16) {
			String number1 = "660690  ";
			String number2 = "13706762276";
			resterauntname.append("秘方排骨饭");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("排骨饭 10元\n排骨粉 10元\n（每份配有多种素菜，另加排骨1块3元）");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 17) {
			String number1 = "668878";
			resterauntname.append("农嫂坛子菜");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【土坛烤鸡类】\n木炭烤鸡腿+排骨汤+蔬菜+小菜+米饭=12元\n爽口盐水鸡+排骨汤+蔬菜+小菜+米饭=12元\n秘制红油鸡+排骨汤+蔬菜+小菜+米饭=12元\n冰花梅酱鸡+排骨汤+蔬菜+小菜+米饭=12元\n桂花香酥鸡+排骨汤+蔬菜+小菜+米饭=12元\n秘制口水鸡+排骨汤+蔬菜+小菜+米饭=12元\n【土坛烤鸭类】\n木炭烤鸭腿+排骨汤+蔬菜+小菜+米饭=12元\n爽口盐水鸭+排骨汤+蔬菜+小菜+米饭=12元\n秘制红油鸭+排骨汤+蔬菜+小菜+米饭=12元\n冰花梅酱鸭+排骨汤+蔬菜+小菜+米饭=12元\n桂花香酥鸭+排骨汤+蔬菜+小菜+米饭=12元\n秘制口水鸭+排骨汤+蔬菜+小菜+米饭=12元\n【土坛煨菜类】\n狮子头+排骨汤+蔬菜+小菜+米饭=12元\n鸡爪+排骨汤+蔬菜+小菜+米饭=11元\n馋嘴鸭+排骨汤+蔬菜+小菜+米饭=11元\n鸡块+排骨汤+蔬菜+小菜+米饭=11元\n排骨+排骨汤+蔬菜+小菜+米饭=12元\n【卤水类】\n卤鸡腿+排骨汤+蔬菜+小菜+米饭=12元\n卤猪蹄+排骨汤+蔬菜+小菜+米饭=12元\n卤肉+排骨汤+蔬菜+小菜+米饭=12元\n红烧肉+排骨汤+蔬菜+小菜+米饭=12元\n【其他类】\n孜然猪排+排骨汤+蔬菜+小菜+米饭=9元\n椒盐猪排+排骨汤+蔬菜+小菜+米饭=9元\n香辣猪排+排骨汤+蔬菜+小菜+米饭=9元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 18) {
			String number1 = "679856";
			resterauntname.append("壹间餐馆");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("香汁排骨+2配菜=12元\n鼎香肥牛+2配菜=12元\n鸡腿+2配菜=10元\n鱼饼+2配菜=10元\n古法狮子头+2配菜=10元\n雪碧3元 可乐3元 加多宝5元");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 19) {
			String number1 = "652376  ";
			String number2 = "669983";
			resterauntname.append("意大利铁板饭");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("意大利铁板面 10元\n炸酱饭 7元\n热狗炸酱饭 8元\n香肠炸酱饭 8元\n梅菜扣肉炸酱饭 9元\n鸡排炸酱饭 9元\n上校鸡块炸酱饭 10元\n烤鸡炸酱饭 10元\n烤肉炸酱饭 11元\n大排炸酱放 11元\n牛肉炸酱饭 12元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 20) {
			String number1 = "664082";
			resterauntname.append("遇见寿司坊");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【每周一特价】\n蛋黄鱿鱼卷 16元\n黄金甲 16元\n吉利炸虾卷 14元\n李公主卷 12元\n培根热狗卷 14元\n瑞丽卷 20元\n樱花卷 12元\n招牌海苔寿司 8元\n加州鲜果卷 12元\n香酥肌肉卷 14元\n黑椒牛肉卷 16元\n【卷类】\n青瓜细卷 5元/8个\n酱瓜细卷 5元/8个\n苹果细卷 5元/8个\n泡菜卷 6元/8个\n海草卷 6元/8个\n培根细卷 8元/8个\n鳗鱼卷 10元/8个\n三文鱼细卷 12元/8个\n金枪鱼时蔬卷 10元/8个\n加州卷 12元/8个\n【主食】\n韩式辣年糕 10元\n海鲜乌冬面 18元\n咖喱牛肉饭 18元\n【小吃】\n薯条 9元\n鸡米花 9元\n韩国泡菜 9元\n味付海草 6元\n【套餐】\n遇见寿司套餐 20元\n握寿司套餐 30元\n【握类】\n鳗鱼手卷 8元\n三文鱼卷 8元\n吉利炸虾握 8元\n【手卷】\n培根时蔬手卷 8元\n大虾手卷 10元\n鳗鱼手卷 8元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 21) {
			String number1 = "652376  ";
			String number2 = "669983  ";
			resterauntname.append("茶余饭后");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber3.setText("15967639983");
			resterauntnumber3.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("【套餐】\n素菜套餐       8元\n热狗套餐       9元\n香肠套餐       9元\n鸡排套餐       9元\n烤鸭套餐       10元\n梅菜扣肉套餐   10元\n鸡肉套餐       10元\n烤肉套餐       11元\n大排套餐       12元\n牛肉套餐       12元\n【蛋炒饭】\n老干妈蛋炒饭   6元\n孜然蛋炒饭     6元\n梅干菜蛋炒饭   6元\n青菜蛋炒饭     6元\n番茄鸡蛋炒饭   7元\n虾皮蛋炒饭     7元\n炸酱蛋炒饭     7元\n热狗蛋炒饭     7元\n香肠蛋炒饭     7元\n梅菜扣肉蛋炒饭 8元\n烤鸭蛋炒饭     9元\n烤鸡蛋炒饭     9元\n大排蛋炒饭     11元\n【炸酱饭】\n炸酱饭           7元\n热狗炸酱饭       8元\n香肠炸酱饭       8元\n梅菜扣肉炸酱饭   9元\n鸡排炸酱饭       9元\n上校鸡块炸酱饭   10元\n烤鸭炸酱饭       10元\n烤鸡炸酱饭       10元\n烤肉炸酱饭       11元\n大排炸酱饭       11元\n牛肉炸酱饭       12元\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
	}
}

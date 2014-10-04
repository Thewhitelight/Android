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
		// TODO �Զ����ɵķ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resteraunt_content);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// ���뵭��Ч��
		resterauntname = (TextView) findViewById(R.id.resterauntname);
		resterauntnumber1 = (TextView) findViewById(R.id.resterauntnumber1);
		resterauntnumber2 = (TextView) findViewById(R.id.resterauntnumber2);
		resterauntnumber3 = (TextView) findViewById(R.id.resterauntnumber3);
		foodmenu = (TextView) findViewById(R.id.foodmenu);
		long list_id = getIntent().getLongExtra("list_id", 0);
		if (list_id == 0) {
			String number1 = "656325  ";
			String number2 = "818888  ";
			resterauntname.append("��Ǫ��");
			resterauntname.setTextColor(Color.BLACK);
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("�����⣨�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n�ع��⣨�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\nѼ�⣨�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\nС�ţ��߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n����ţ�⣨�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n���ࣨ�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n���ּ��ᣨ�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n���ţ��߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n�����⣨�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n��Ƭ�ࣨ�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n��˿�ࣨ�߲�+�׷��� �ײ�A 10Ԫ �ײ�B 11Ԫ\n���������߲�+�׷��� �ײ�A 9Ԫ �ײ�B 10Ԫ\n�㳦���߲�+�׷��� �ײ�A 9Ԫ �ײ�B 10Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
			// foodmenu.setTextColor(Color.BLACK);
			foodmenu.setTextColor(0xffff00ff);// 0X��ɫ������� FF͸���ȱ�� FF00FFΪ��ɫ���
		}
		if (list_id == 1) {
			String number1 = "673866  ";
			String number2 = "13958553866  ";
			resterauntname.append("��ѿͰ");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("���ȷ� 10Ԫ\n������˿�� 10Ԫ\n�°¶������ŷ� 11Ԫ\n���շ� 12Ԫ\n�����ŹǷ� 12Ԫ\n��଼��� 12Ԫ\n�ڽ�ţ���� 12Ԫ\n���ŷ� 13Ԫ\n ������ʽ�⽴�� 12Ԫ\n�ڽ���ʽ�⽴�� 12Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 2) {
			String number1 = "663989  ";
			String number2 = "18858624710  ";
			resterauntname.append("���෹��");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber3.setText("684710");
			resterauntnumber3.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("����ɫ��ʳ��\n���伦�ȱ�       8Ԫ\n�������ȱ�       12Ԫ\n�¶������ȱ�     9Ԫ\n����ȫϺ��       9Ԫ\n��԰�༦��      6Ԫ\n����ţ�Ɽ       6Ԫ\n���ް�ţ�Ɽ     8Ԫ\nī���缦���     7Ԫ\n��������͡�\n��Ƥȫ��         18Ԫ\n��֭�ְǼ�       18Ԫ\n�¶�������       7Ԫ\n��������         6Ԫ\n�ƽ����Ϻ     5Ԫ/2ֻ\n��������       5Ԫ/2��\n���㼦��       5Ԫ/2��\n���伦��         5Ԫ\n�ƽ���       5Ԫ/5��\n�������׻�       5Ԫ\n��ʽ����         6Ԫ\n�ƽ�С����       3Ԫ\n��ʽ��̢       6Ԫ/2ֻ\n��ը�����     5Ԫ/4ֻ\n����ع���     5Ԫ/5ֻ\nâ��Ľ˹       5Ԫ/3��\n�������׻�������� 8Ԫ\n����Ʒר����\n�ʼ��̲�             7Ԫ\n�̲������           5Ԫ\nţ�����ɲ�           5Ԫ\n�����̲�             3Ԫ\n�����̲�             5Ԫ\n�춹�̲�             4Ԫ\n�����̲�             4Ԫ\n�춹�����̲�         5Ԫ\n�춹��ĭ��           5Ԫ\n��ˬ����             3Ԫ\n���ʺ��             4Ԫ\nõ�廨��             5Ԫ\n�������             5Ԫ\n��������             5Ԫ\n����«��             4Ԫ\n«������             5Ԫ\n�������Ӳ�           5Ԫ\n������Ӳ�           5Ԫ\n������÷֭           5Ԫ\n�춹����             5Ԫ\n��Բ����             5Ԫ\nԭζ����             5Ԫ\nĦ������             5Ԫ\nĨ��춹             5Ԫ\n�춹�ɲ�Ĩ��         6Ԫ\n�춹����Ĩ��         6Ԫ\n��ݮ����ɳ��         5Ԫ\n��Ũâ����ɳ         5Ԫ\n������˼����ɳ      5Ԫ\n��ʽ�ٱ�����ݮ/â����5Ԫ\n���֣�С/��        3/4Ԫ\nѩ�̣�С/��        3/4Ԫ\n��֭��С/��        3/4Ԫ\nơ��                 4Ԫ \n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 3) {
			String number1 = "13252459951  ";
			resterauntname.append("��������");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("�������ࡿ\n���ų���     10Ԫ\nС�ų���     10Ԫ\n���ʳ���     8Ԫ\n��˿����     7Ԫ\n��������     7Ԫ\n�������ࡿ\n��������     10Ԫ\nС������     10Ԫ\n��������     8Ԫ\n��˿����     7Ԫ\n��������     7Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 4) {
			String number1 = "665163  ";
			resterauntname.append("����ͷ�ζ��ʳ");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("��������\n������ 6Ԫ\n÷�ɲ˵����� 6Ԫ\n������˿������ 7Ԫ\n���ݵ����� 7Ԫ\n�����桿\n�������� 7Ԫ\n������˿���� 8Ԫ\nţ���� 9Ԫ\n���ײ͡�\n������˿�ײ� 8Ԫ\n�����ײ� 8Ԫ\n÷�˿����ײ� 9Ԫ\nţ���ײ� 9Ԫ\n������Ѽ�ײ� 9Ԫ\n���Ӽ����ײ� 9Ԫ\n���������ײ� 9Ԫ\n�Ź��ײ� 10Ԫ");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 5) {
			String number1 = "660366  ";
			String number2 = "13606655163  ";
			resterauntname.append("������ζ");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("����ζ�ײ͡�\n�����ײ�  8Ԫ\n��������˿�ײ�  8Ԫ\n�����ײ�  8Ԫ\n�ϸ��������ײ�  9Ԫ\n÷�˿����ײ�  9Ԫ\nţ���ײ�  9Ԫ\n�ϸ���ţ���ײ�  9Ԫ\n������Ѽ�ײ�  9Ԫ\n���մ�Ϻ�ײ�  10Ԫ\n�����ײ�  10Ԫ\n�Ź��ײ�  10Ԫ\n�ϸ����Ź��ײ�  10Ԫ\n����С���ײ�  10Ԫ\n����ζ�ǽ����ࡿ\n�����ǽ���  7Ԫ\n÷�˻��ȸǽ���  7Ԫ\n�ᶹ����˿�ǽ���  7Ԫ\n÷�㿾��ǽ���  8Ԫ\n��������˿�ǽ���  8Ԫ\n����ǽ���  8Ԫ\n÷�˿���ǽ���  8Ԫ\n������Ѽ�ǽ���  8Ԫ\n����ţ��ǽ���  8Ԫ\n����ǽ���  9Ԫ\n�ŹǸǽ���  9Ԫ\n���մ�Ϻ�ǽ���  9Ԫ\n����С��ǽ���  9Ԫ\n��������\n�Ӻɰ��� 1.5Ԫ\n  ����˿ 2Ԫ  \n������ 2Ԫ  \n�ӻ��ȳ� 2Ԫ  \nѩ��/���� 3Ԫ/�ޣ�\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 6) {
			String number2 = "621923";
			resterauntname.append("��������ˮ��");
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("�����۲�0.6/��\n ����ײ�0.6/��\n ����²�0.6/��\n ��ţ��1/��\n С��6/�̣�10����\n ����9/�̣�15����\n ����12/�̣�20����\n������ǽ��� 9Ԫ\n ��������С�� 4Ԫ/��");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 7) {
			String number1 = "628153  ";
			String number2 = "18858675592";
			resterauntname.append("������");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("��ଳ���           7Ԫ\n���ݳ���           6Ԫ\n���⳴��           8Ԫ\n���⳴��           8Ԫ\n������             5Ԫ\n���賴��           7Ԫ\n�㹽���⳴��       7Ԫ\n������˿�Ƿ�       8Ԫ\n���Ӽ����Ƿ�       8Ԫ\n�㳦��������       7Ԫ\n С�ձ������Ƿ�     10Ԫ\nţ���˿           5Ԫ\n������������50���͵�������");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 8) {
			String number2 = "18069306171";
			resterauntname.append("���Ϲ�������");
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("�������� 7Ԫ\n ���ȳ��� 7Ԫ\n ���⳴�� 7Ԫ\n �������� 8Ԫ\n ��������� 7Ԫ\n ���⳴��� 7Ԫ\n �㳦���� 7Ԫ\n ��˿���� 7Ԫ\nţ�⳴�� 9Ԫ\n ţ�⳴��� 9Ԫ\n �㳦����� 7Ԫ\n ��˿����� 7Ԫ\n �زˣ���� ���ȵ� Ģ�� ľ�� ��ѿ ǧ��Ƥ\n ��ˣ����� Ϻ�� ����Ƭ �����㶹�� ţ���� ����� �𻨳�\n ���� ţ�� �Ｙ ���� �㳦 з�� з��\n 8Ԫ 6���ز� ��1�ֻ�� ����6��\n ����������9 ��˿������9 �㳦������9 ţ�⳴����10 ��������6\nѼ��5 Ѽ���4 Ѽͷ3 Ѽצ1.5/����5Ԫ/4��\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 9) {
			String number2 = "15888631612";
			resterauntname.append("������㼦��");
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("����9 \n��������11 \n��Ƥ����9 \n���ռ���6 \n���ּ���ԭζ/���ʣ�6\n������5\n ��Ƥ����5 \n����5\n ̼������11 \n̼������9\n ̼������6\n��֦��5 ��\nƤ���飨�ں�����5 \n��������5\n �㳦С����5 \n��ͷ��5 \n��Ѫ��5 \n��÷�ع�5\n �ļ���3 \nŴ�׳�5 \n̨���㳦3 \n�󳦰�С��7\n �ȹ����4 \n�ƽ��ž�7\n���ͼۣ�20");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 10) {
			String number1 = "660366  ";
			String number2 = "15068629399  ";
			resterauntname.append("������ɫ��ʳ");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber3.setText("679399");
			resterauntnumber3.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("����ɫ��������\n�����׵�����               6Ԫ\n��ଷ�����                 6Ԫ\n÷�ɲ˵�����               6Ԫ\n��֭�ܲ���������΢����     6Ԫ\n�ϸ��走������΢����       6Ԫ\n�����˵�������΢����       6Ԫ\n�ᶹ�ǵ�������΢����       6Ԫ\n��˿������                 7Ԫ\n�ᶹ����˿��������΢����   7Ԫ\nСϺ�׵�����               7Ԫ\n����������                7Ԫ\n�������ࡿ��С���棩\n��������                   7Ԫ\n��˿����                   8Ԫ\nţ�⳴��                   9Ԫ\n��Ȼ���⳴��               9Ԫ\n����ɫ�������ࡿ\n÷�ɲ˻��ȳ�������         7Ԫ\n���ȳ�������               7Ԫ\n÷�˿��⵰����             8Ԫ\n���⵰����                 8Ԫ\n��Ҷ��������               9Ԫ\n���Ӽ���������������       9Ԫ\n��Ȼ���⵰����             9Ԫ\n��Ѽ������                 9Ԫ\n����ţ�⵰������΢����     9Ԫ\n������ţ�⵰������΢����   9Ԫ\n�Źǵ�����                 10Ԫ\n��������\n�Ӻɰ���                   1.5Ԫ\n������/���ȳ�              2Ԫ\n����˿                     2Ԫ\n�����ϡ�\nѩ��/����                  3Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 11) {
			String number1 = "85190210  ";
			resterauntname.append("����ʿ");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("����+���ױ�+�п�=10Ԫ\n�����+���ױ�+�п�=10Ԫ\n����+С����+�п�=13Ԫ\n����� +С����+�п�=13Ԫ\n����+���׻�+�п�=14Ԫ\n�����+����+�п�=14Ԫ\n����+2�������Ǵ�+�п�=14Ԫ\n�����+�ڽ�����+�п�=14Ԫ\n����+����+����+�п�=17Ԫ\n�����+����+����+�п�=17Ԫ\n����+���ױ�+����+�п�=17Ԫ\n�����+�ڽ�����+����+�п�=17Ԫ\n�����㡿\n�޹Ǽ��� 6Ԫ\n�޹Ǵ�� 7Ԫ\n������Ϻ�� 8Ԫ\n���Ƽ��ȱ� 8Ԫ\n�㼦�� 8Ԫ\nţ�Ɽ 7Ԫ\n��ζ����� 8Ԫ\n̩ʽ����� 8Ԫ\n���׻� 5Ԫ\n����Ƥ��/��֭�ְǼ� 18Ԫ/ֻ��");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 12) {
			String number1 = "645153  ";
			String number2 = "18767685153";
			resterauntname.append("��������");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("ţ�⳴���� 13Ԫ\n����Ũ������ 13Ԫ\n����Ũ������ 13Ԫ\n��ʽ�������� 13Ԫ\n��Ʒ�������� 15Ԫ\n������������ 13Ԫ\n�ϱ���ը���� 13Ԫ\n�Ӽ�ţ������ 15Ԫ\n��ĩ�ڶ����� 15Ԫ\n������÷�� 4Ԫ\n�������Ӳ� 4Ԫ\n����/ѩ��/�Ҵ� 3Ԫ\n�����á����һԪ�����");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 13) {
			String number1 = "669742  ";
			String number2 = "85318309";
			resterauntname.append("�������");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("ţ������      7Ԫ\nţ�⵶����    7Ԫ\nţ��������    8Ԫ\nţ�⳴����    10Ԫ\nţ�⳴����    10Ԫ\nţ��ը����    10Ԫ\n��������      12Ԫ\nţ������      12Ԫ\n����ţ����    10Ԫ\n��������      7Ԫ\nţ�����      10Ԫ\nţ���˿��    8Ԫ\nţ��������    7Ԫ\nţ�⳴��Ƭ    12Ԫ\n�������ࡿ\n����ţ�����  12Ԫ\n���ռ������  12Ԫ\n�ཷţ�����  10Ԫ\n���Ͱ���       8Ԫ\n�ཷ����˿���� 8Ԫ\n����ţ�����  10Ԫ\n��г������  10Ԫ\n��Ȼ�������  12Ԫ\n�����ײ˰���  8Ԫ\n��̦�������  10Ԫ\nĢ���������  10Ԫ\n���ѳ�������  10Ԫ\n�б��������  10Ԫ\n�½�����      12Ԫ\n  ����ɫ�����ࡿ\n��Ȼ����         30Ԫ\n����ţ��         30Ԫ\n������ţ��       25Ԫ\n�½����̼�       55Ԫ\n��˰ײ�         10Ԫ\nĢ����ţ��       20Ԫ\n���ѳ���         10Ԫ\n����ţ��         25Ԫ\n�ཷ��ţ��       15Ԫ\n��̦��ţ��       15Ԫ\n������    ����⡿\nţ�⳴��         7Ԫ\n��������         7Ԫ\n���ѵ�����       8Ԫ\n���ݳ���         8Ԫ\nţ�⳴���       7Ԫ\n���������       7Ԫ\n��˳����       7Ԫ\nţ�⳴����       7Ԫ\n���ǽ����ࡿ\n�ཷ����ǽ���   8Ԫ\n����ţ��ǽ���   10Ԫ\n��̦����ǽ���   8Ԫ\n����ţ��ǽ���   8Ԫ\nĢ������ǽ���   8Ԫ\n��Ȼ����ǽ���   10Ԫ\n��г���ǽ���   8Ԫ\n�ཷ����˿�ǽ��� 7Ԫ\n���ѳ����ǽ���   8Ԫ\n���ռ���ǽ���   10Ԫ\n�б�����ǽ���   8Ԫ\n������˿�ǽ���   10Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 14) {
			String number1 = "665163  ";
			String number2 = "13606655163";
			resterauntname.append("��ζԷ");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("���ǽ�����\n�ᶹ����˿ �ǽ��� 7Ԫ\n�����ǽ��� 7Ԫ\n÷�˻��ȸǽ��� 7Ԫ\n����ǽ��� 8Ԫ\n÷�˿���ǽ��� 8Ԫ\nũ������ǽ��� 8Ԫ\n÷�㿾��ǽ��� 9Ԫ\n���㿾��ǽ��� 9Ԫ\n���Ӽ����ǽ��� 9Ԫ\n��Ѽ�ǽ��� 9Ԫ\n����ţ��ǽ��� 9Ԫ\n�ŹǸǽ��� 10Ԫ\n�����桿\n�������� 7Ԫ\n��˿���� 8Ԫ\nţ�⳴�� 9Ԫ\n�����桿\n�ᶹ����˿���� 8Ԫ\n÷�˻������� 8Ԫ\n��˿���� 8Ԫ\n��Ѽ���� 9Ԫ\n����ţ������ 9Ԫ\n�Ź����� 10Ԫ\n����������\n������ 6Ԫ\n��ଵ����� 6Ԫ\n�ϸ��走���� 6Ԫ\n÷�ɲ˵����� 6Ԫ\n�ᶹ�ǵ����� 6Ԫ\n��˿������ 7Ԫ\n�ᶹ����˿������ 7Ԫ\n÷�˻��ȵ����� 7Ԫ\n���������� 7Ԫ\n÷�˿��⵰���� 8Ԫ\nũ�����⵰���� 8Ԫ\n÷�㿾�⵰���� 9Ԫ\n��Ѽ������ 9Ԫ\n���㼦������ 9Ԫ\n����ţ�⵰���� 9Ԫ\n�Źǵ����� 10Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 15) {
			String number1 = "672390";
			resterauntname.append("�ױ���");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("��Ƥ���ȷ� 13Ԫ\n�»Ƴ����� 8Ԫ\n���ȳ����� 8Ԫ\n������˿�� 9Ԫ\n̨ʽ���ŷ� 10Ԫ\n̨ʽ�㳦�� 10Ԫ\n����ʨ��ͷ�� 10Ԫ\n���������� 10Ԫ\n̨ʽ�ŹǷ� 11Ԫ\n÷�˿��ⷹ 11Ԫ\n��֭���շ� 11Ԫ\n̨��±�ⷹ 11Ԫ\n̨�弦�ŷ� 12Ԫ\n�Ǵ��ŹǷ� 12Ԫ\n��ʽţ�ŷ� 12Ԫ\n��Ѽ�ȷ� 13Ԫ");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 16) {
			String number1 = "660690  ";
			String number2 = "13706762276";
			resterauntname.append("�ط��ŹǷ�");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("�ŹǷ� 10Ԫ\n�ŹǷ� 10Ԫ\n��ÿ�����ж����زˣ�����Ź�1��3Ԫ��");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 17) {
			String number1 = "668878";
			resterauntname.append("ũɩ̳�Ӳ�");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("����̳�����ࡿ\nľ̿������+�Ź���+�߲�+С��+�׷�=12Ԫ\nˬ����ˮ��+�Ź���+�߲�+С��+�׷�=12Ԫ\n���ƺ��ͼ�+�Ź���+�߲�+С��+�׷�=12Ԫ\n����÷����+�Ź���+�߲�+С��+�׷�=12Ԫ\n�����ּ�+�Ź���+�߲�+С��+�׷�=12Ԫ\n���ƿ�ˮ��+�Ź���+�߲�+С��+�׷�=12Ԫ\n����̳��Ѽ�ࡿ\nľ̿��Ѽ��+�Ź���+�߲�+С��+�׷�=12Ԫ\nˬ����ˮѼ+�Ź���+�߲�+С��+�׷�=12Ԫ\n���ƺ���Ѽ+�Ź���+�߲�+С��+�׷�=12Ԫ\n����÷��Ѽ+�Ź���+�߲�+С��+�׷�=12Ԫ\n������Ѽ+�Ź���+�߲�+С��+�׷�=12Ԫ\n���ƿ�ˮѼ+�Ź���+�߲�+С��+�׷�=12Ԫ\n����̳�в��ࡿ\nʨ��ͷ+�Ź���+�߲�+С��+�׷�=12Ԫ\n��צ+�Ź���+�߲�+С��+�׷�=11Ԫ\n����Ѽ+�Ź���+�߲�+С��+�׷�=11Ԫ\n����+�Ź���+�߲�+С��+�׷�=11Ԫ\n�Ź�+�Ź���+�߲�+С��+�׷�=12Ԫ\n��±ˮ�ࡿ\n±����+�Ź���+�߲�+С��+�׷�=12Ԫ\n±����+�Ź���+�߲�+С��+�׷�=12Ԫ\n±��+�Ź���+�߲�+С��+�׷�=12Ԫ\n������+�Ź���+�߲�+С��+�׷�=12Ԫ\n�������ࡿ\n��Ȼ����+�Ź���+�߲�+С��+�׷�=9Ԫ\n��������+�Ź���+�߲�+С��+�׷�=9Ԫ\n��������+�Ź���+�߲�+С��+�׷�=9Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 18) {
			String number1 = "679856";
			resterauntname.append("Ҽ��͹�");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("��֭�Ź�+2���=12Ԫ\n�����ţ+2���=12Ԫ\n����+2���=10Ԫ\n���+2���=10Ԫ\n�ŷ�ʨ��ͷ+2���=10Ԫ\nѩ��3Ԫ ����3Ԫ �Ӷ౦5Ԫ");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 19) {
			String number1 = "652376  ";
			String number2 = "669983";
			resterauntname.append("��������巹");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("����������� 10Ԫ\nը���� 7Ԫ\n�ȹ�ը���� 8Ԫ\n�㳦ը���� 8Ԫ\n÷�˿���ը���� 9Ԫ\n����ը���� 9Ԫ\n��У����ը���� 10Ԫ\n����ը���� 10Ԫ\n����ը���� 11Ԫ\n����ը���� 11Ԫ\nţ��ը���� 12Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 20) {
			String number1 = "664082";
			resterauntname.append("������˾��");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("��ÿ��һ�ؼۡ�\n��������� 16Ԫ\n�ƽ�� 16Ԫ\n����ըϺ�� 14Ԫ\n����� 12Ԫ\n����ȹ��� 14Ԫ\n������ 20Ԫ\nӣ���� 12Ԫ\n���ƺ�̦��˾ 8Ԫ\n�����ʹ��� 12Ԫ\n���ּ���� 14Ԫ\n�ڽ�ţ��� 16Ԫ\n�����ࡿ\n���ϸ�� 5Ԫ/8��\n����ϸ�� 5Ԫ/8��\nƻ��ϸ�� 5Ԫ/8��\n�ݲ˾� 6Ԫ/8��\n���ݾ� 6Ԫ/8��\n���ϸ�� 8Ԫ/8��\n����� 10Ԫ/8��\n������ϸ�� 12Ԫ/8��\n��ǹ��ʱ�߾� 10Ԫ/8��\n���ݾ� 12Ԫ/8��\n����ʳ��\n��ʽ����� 10Ԫ\n�����ڶ��� 18Ԫ\n���ţ�ⷹ 18Ԫ\n��С�ԡ�\n���� 9Ԫ\n���׻� 9Ԫ\n�����ݲ� 9Ԫ\nζ������ 6Ԫ\n���ײ͡�\n������˾�ײ� 20Ԫ\n����˾�ײ� 30Ԫ\n�����ࡿ\n�����־� 8Ԫ\n������� 8Ԫ\n����ըϺ�� 8Ԫ\n���־�\n���ʱ���־� 8Ԫ\n��Ϻ�־� 10Ԫ\n�����־� 8Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
		if (list_id == 21) {
			String number1 = "652376  ";
			String number2 = "669983  ";
			resterauntname.append("���෹��");
			resterauntnumber1.setText(number1);
			resterauntnumber1.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber2.setText(number2);
			resterauntnumber2.setMovementMethod(LinkMovementMethod
					.getInstance());
			resterauntnumber3.setText("15967639983");
			resterauntnumber3.setMovementMethod(LinkMovementMethod
					.getInstance());
			foodmenu.setText("���ײ͡�\n�ز��ײ�       8Ԫ\n�ȹ��ײ�       9Ԫ\n�㳦�ײ�       9Ԫ\n�����ײ�       9Ԫ\n��Ѽ�ײ�       10Ԫ\n÷�˿����ײ�   10Ԫ\n�����ײ�       10Ԫ\n�����ײ�       11Ԫ\n�����ײ�       12Ԫ\nţ���ײ�       12Ԫ\n����������\n�ϸ��走����   6Ԫ\n��Ȼ������     6Ԫ\n÷�ɲ˵�����   6Ԫ\n��˵�����     6Ԫ\n���Ѽ�������   7Ԫ\nϺƤ������     7Ԫ\nը��������     7Ԫ\n�ȹ�������     7Ԫ\n�㳦������     7Ԫ\n÷�˿��⵰���� 8Ԫ\n��Ѽ������     9Ԫ\n����������     9Ԫ\n���ŵ�����     11Ԫ\n��ը������\nը����           7Ԫ\n�ȹ�ը����       8Ԫ\n�㳦ը����       8Ԫ\n÷�˿���ը����   9Ԫ\n����ը����       9Ԫ\n��У����ը����   10Ԫ\n��Ѽը����       10Ԫ\n����ը����       10Ԫ\n����ը����       11Ԫ\n����ը����       11Ԫ\nţ��ը����       12Ԫ\n");
			foodmenu.setMovementMethod(ScrollingMovementMethod.getInstance());
		}
	}
}

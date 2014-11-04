package textview;

import com.example.autocomplettextview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
//自动完成文本框
public class AutoCompleteTextview extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setTitle("textview");//重置标题
		setContentView(R.layout.atuocompletetextview);
		String[] str={"China","Chechen","Russia","Ruishi","Germany","Ukraine","Belarus","USA","Beijing","Gete","TaiWan"};
		AutoCompleteTextView textview=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, str);//初始化适配器
		textview.setAdapter(adapter);//设置适配器
		textview.setThreshold(1);//这是匹配字符数
		textview.setCompletionHint("单击选择符合的一项");//设置提示信息
		//textview.setDropDownBackgroundResource(R.drawable.ic_launcher);设置背景图片
		textview.setDropDownBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));//另一种设置背景图片方法
		textview.setDropDownHeight(200);//设置高度
		textview.setDropDownWidth(500);//设置宽度
		textview.setOnItemClickListener(new AdapterView.OnItemClickListener() {//toast视图显示选择项
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO 自动生成的方法存根
			Toast.makeText(getApplicationContext(), "您选择的为："+arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_LONG).show();	
			}
		});
	}

}

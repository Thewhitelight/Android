package textview;

import com.example.autocomplettextview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
//�Զ�����ı���
public class AutoCompleteTextview extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setTitle("textview");//���ñ���
		setContentView(R.layout.atuocompletetextview);
		String[] str={"China","Chechen","Russia","Ruishi","Germany","Ukraine","Belarus","USA","Beijing","Gete","TaiWan"};
		AutoCompleteTextView textview=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, str);//��ʼ��������
		textview.setAdapter(adapter);//����������
		textview.setThreshold(1);//����ƥ���ַ���
		textview.setCompletionHint("����ѡ����ϵ�һ��");//������ʾ��Ϣ
		//textview.setDropDownBackgroundResource(R.drawable.ic_launcher);���ñ���ͼƬ
		textview.setDropDownBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));//��һ�����ñ���ͼƬ����
		textview.setDropDownHeight(200);//���ø߶�
		textview.setDropDownWidth(500);//���ÿ��
		textview.setOnItemClickListener(new AdapterView.OnItemClickListener() {//toast��ͼ��ʾѡ����
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO �Զ����ɵķ������
			Toast.makeText(getApplicationContext(), "��ѡ���Ϊ��"+arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_LONG).show();	
			}
		});
	}

}

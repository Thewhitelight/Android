package test;

import com.example.activitysave.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class Main extends Activity{
	private EditText content=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        content=(EditText)findViewById(R.id.et);
        if(savedInstanceState!=null){
            //�õ����������
            String saveString=savedInstanceState.getString("content");
            //�ָ�����
            content.setText(saveString);
        }
    }
    /**
     * �ڸ÷����б���״̬����
     */
    @Override
    protected void onPause() {
        super.onPause();
        //�õ�Ҫ���������������
        String saveString=content.getText().toString();
        SharedPreferences sp=this.getSharedPreferences("save",MODE_PRIVATE);
        //��������������
        sp.edit().putString("content", saveString).commit();
    }
    /**
     * �ڸ÷����лָ�״̬����
     */
    @Override
    protected void onResume() {
        //�õ����������
        String saveString=this.getSharedPreferences("save", MODE_PRIVATE).getString("content", null);
        //�ָ�����
        content.setText(saveString);
        super.onResume();
    }
    /**
     * �ڸ÷����б���״̬����
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //�õ�Ҫ���������������
        String saveString=content.getText().toString();
        //��������������
        outState.putString("content", saveString);
        super.onSaveInstanceState(outState);
    }

}

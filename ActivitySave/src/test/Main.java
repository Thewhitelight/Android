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
            //得到保存的数据
            String saveString=savedInstanceState.getString("content");
            //恢复数据
            content.setText(saveString);
        }
    }
    /**
     * 在该方法中保存状态数据
     */
    @Override
    protected void onPause() {
        super.onPause();
        //得到要保存的输入框的内容
        String saveString=content.getText().toString();
        SharedPreferences sp=this.getSharedPreferences("save",MODE_PRIVATE);
        //保存输入框的内容
        sp.edit().putString("content", saveString).commit();
    }
    /**
     * 在该方法中恢复状态数据
     */
    @Override
    protected void onResume() {
        //得到保存的内容
        String saveString=this.getSharedPreferences("save", MODE_PRIVATE).getString("content", null);
        //恢复内容
        content.setText(saveString);
        super.onResume();
    }
    /**
     * 在该方法中保存状态数据
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //得到要保存的输入框的内容
        String saveString=content.getText().toString();
        //保存输入框的内容
        outState.putString("content", saveString);
        super.onSaveInstanceState(outState);
    }

}

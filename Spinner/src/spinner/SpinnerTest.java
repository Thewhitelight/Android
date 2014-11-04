package spinner;

import java.util.ArrayList;

import com.example.spinner.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		Spinner s1=(Spinner)findViewById(R.id.spr01);
		String [] countries={"中国","美国","德国","法国","英国","俄罗斯","澳大利亚"};
		ArrayList<String> allcountries=new ArrayList<String>();//list对象
		for (int i = 0; i < countries.length; i++) //添加数据
		{
			allcountries.add(countries[i]);
		}
		ArrayAdapter<String>aspnCountries=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, allcountries);
		//ArrayAdapter<String>aspnCountries=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, allcountries);
	    //ArrayAdapter<String>aspnCountries=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, allcountries);//初始化适配器
		aspnCountries.setDropDownViewResource(android.R.layout.simple_spinner_item);
		s1.setAdapter(aspnCountries);//设置适配器
		s1.setPrompt("请选择国籍");//设置标题
	}
}

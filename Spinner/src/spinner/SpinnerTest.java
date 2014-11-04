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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		Spinner s1=(Spinner)findViewById(R.id.spr01);
		String [] countries={"�й�","����","�¹�","����","Ӣ��","����˹","�Ĵ�����"};
		ArrayList<String> allcountries=new ArrayList<String>();//list����
		for (int i = 0; i < countries.length; i++) //�������
		{
			allcountries.add(countries[i]);
		}
		ArrayAdapter<String>aspnCountries=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, allcountries);
		//ArrayAdapter<String>aspnCountries=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, allcountries);
	    //ArrayAdapter<String>aspnCountries=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, allcountries);//��ʼ��������
		aspnCountries.setDropDownViewResource(android.R.layout.simple_spinner_item);
		s1.setAdapter(aspnCountries);//����������
		s1.setPrompt("��ѡ�����");//���ñ���
	}
}

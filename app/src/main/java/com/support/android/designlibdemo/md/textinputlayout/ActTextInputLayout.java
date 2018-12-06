package com.support.android.designlibdemo.md.textinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.support.android.designlibdemo.R;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo.md.textinputlayout
 * @description: https://blog.csdn.net/u012792686/article/details/73089227
 * @date: 2018/12/6 0006  
 * @time: 下午 5:34
 */
public class ActTextInputLayout extends AppCompatActivity
{
	
	TextInputLayout pwd,user;
	EditText edUser,edPwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_txetinputlayot);
		edUser=findViewById(R.id.ed_user);
		edPwd=findViewById(R.id.ed_pwd);
		pwd=findViewById(R.id.textView_pwd);
		user=findViewById(R.id.textView_user);
		
		edPwd.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				pwd.setError("邮箱格式错误");
				pwd.setErrorEnabled(true);
				//if(!RegexUtils.isEmail(charSequence)){
				//	pwd.setError("邮箱格式错误");
				//	pwd.setErrorEnabled(true);
				//}else {
				//	pwd.setErrorEnabled(false);
				//}
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
			
			}
		});
		
	}
}

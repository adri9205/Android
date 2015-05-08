package com.example.a01034348_laboratorio_bienvenida;

import com.example.a01034348_laboratorio_bienvenida.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	Button miButton;
	EditText miEdit;
	TextView miText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		miButton = (Button)findViewById(R.id.button1);
		miButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view) {
        		miEdit   = (EditText)findViewById(R.id.editText1);
        		miText = (TextView)findViewById(R.id.textView1);
        		miText.setText("Bienvenido "+miEdit.getText().toString()+"!");
        	}
        });
	}
}

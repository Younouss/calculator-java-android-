package edu.uco.ythiam.p2younouss_t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddActivity extends Activity {
    private Button add;
    private TextView num1view;
    private TextView num2view;
    private TextView resultview;
    public TextView num1;
    public TextView num2;
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        num1view = (TextView) findViewById(R.id.num1view);
        num2view = (TextView) findViewById(R.id.num2view);
        resultview = (TextView) findViewById(R.id.resultview);
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
        add = (Button) findViewById(R.id.add);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String num1String = bundle.getString("num1");
        String num2String = bundle.getString("num2");
        num1.setText(num1String);
        num2.setText(num2String);
        MyListener listener = new MyListener();
        add.setOnClickListener(listener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == add) {
                String resultString = Double.toString(Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString()));
                result.setText(resultString);

            }
        }
    }

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("result", result.getText());
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

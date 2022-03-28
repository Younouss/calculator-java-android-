package edu.uco.ythiam.p2younouss_t;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ComputeActivity extends Activity {
    private Button add;
    private Button multiply;
    private TextView num1view;
    private TextView num2view;
    private TextView num3view;
    public EditText num1;
    public EditText num2;
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        add = (Button) findViewById(R.id.add);
        multiply = (Button) findViewById(R.id.multiply);
        result = (TextView) findViewById(R.id.result);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        MyListener listen =  new MyListener();
        add.setOnClickListener(listen);
        multiply.setOnClickListener(listen);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 0 ) {
                if (data != null)
                result.setText(data.getStringExtra("result"));
            }
            if (requestCode == 1 ) {
                if (data != null)
                    result.setText(data.getStringExtra("result"));
            }
        }
    }
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v == add){
                Intent intent = new Intent(ComputeActivity.this, AddActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("num1",num1.getText().toString());
                bundle.putString("num2",num2.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
            if(v == multiply){
                Intent intent = new Intent(ComputeActivity.this, MultiplyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("num1",num1.getText().toString());
                bundle.putString("num2",num2.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compute, menu);
        return true;
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

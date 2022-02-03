package sn.ept.git.dic2.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);
        ImageButton backButton;

        backButton = findViewById(R.id.back_button);

        Intent intent = getIntent();
        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                backToList();
            }
        });
    }

    public void backToList(){
        Intent intent = new Intent(this, ListPersonActivity.class);
        startActivity(intent);
    }
}

package com.example.practice_4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch start;
    RadioButton radio[] = new RadioButton[3];
    ImageView img;
    Button end, clear;
    TextView q1;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        start = (Switch) findViewById(R.id.start);
        radio[0] = (RadioButton) findViewById(R.id.first);
        radio[1] = (RadioButton) findViewById(R.id.second);
        radio[2] = (RadioButton) findViewById(R.id.third);
        img = (ImageView) findViewById(R.id.img);
        end = (Button) findViewById(R.id.end);
        clear = (Button) findViewById(R.id.clear);
        q1 = (TextView) findViewById(R.id.q1);
        group = (RadioGroup) findViewById(R.id.group);

        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (start.isChecked() == true){
                    q1.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                    end.setVisibility(View.VISIBLE);
                    clear.setVisibility(View.VISIBLE);
                }
                else {
                    q1.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    end.setVisibility(View.INVISIBLE);
                    clear.setVisibility(View.INVISIBLE);
                }
            }
        });

        final int draw[] = {R.drawable.logo, R.drawable.oreo, R.drawable.jelly};

        for (int i = 0; i < radio.length; i++){
            final int index;
            index = i;
            radio[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    img.setImageResource(draw[index]);
                }
            });
        }

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q1.setVisibility(View.INVISIBLE);
                group.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);
                end.setVisibility(View.INVISIBLE);
                clear.setVisibility(View.INVISIBLE);

                group.clearCheck();
                start.setChecked(false);
            }
        });

    }
}
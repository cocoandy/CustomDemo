package com.wulias.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.wulias.view.img.ImgColor;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener ,View.OnClickListener {

    private ImgColor img;
    private RadioGroup colorType;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private SeekBar seekBar4;
    private SeekBar seekBar5;
    private ImageView img1;
    private ImageView img3;
    private ImageView img2;
    private RadioButton radioButton;
    private int type = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        colorType = findViewById(R.id.color_type);
        seekBar1 = findViewById(R.id.color_1);
        seekBar2 = findViewById(R.id.color_2);
        seekBar3 = findViewById(R.id.color_3);
        seekBar4 = findViewById(R.id.color_4);
        seekBar5 = findViewById(R.id.color_5);
        img1 = findViewById(R.id.img_1);
        img2 = findViewById(R.id.img_2);
        img3 = findViewById(R.id.img_3);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        radioButton = findViewById(R.id.color_r);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar4.setOnSeekBarChangeListener(this);
        seekBar5.setOnSeekBarChangeListener(this);

        colorType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.color_r:
                        type = 1;
                        changeSeekBar(img.getValue(type));
                        break;
                    case R.id.color_g:
                        type = 2;
                        changeSeekBar(img.getValue(type));
                        break;
                    case R.id.color_b:
                        type = 3;
                        changeSeekBar(img.getValue(type));
                        break;
                    case R.id.color_a:
                        type = 4;
                        changeSeekBar(img.getValue(type));
                        break;
                }
            }
        });

        radioButton.setChecked(true);
    }

    public void changeSeekBar(float[] values) {
        seekBar1.setProgress(100 + (int) (values[0] * 100));
        seekBar2.setProgress(100 + (int) (values[1] * 100));
        seekBar3.setProgress(100 + (int) (values[2] * 100));
        seekBar4.setProgress(100 + (int) (values[3] * 100));
        seekBar5.setProgress(100 + (int) (values[4] * 100));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        float persent = i * 1F - 100;
        float value = persent / 100F;
        switch (seekBar.getId()) {
            case R.id.color_1:
                img.setRGBA(type, 1, value);
                break;
            case R.id.color_2:
                img.setRGBA(type, 2, value);
                break;
            case R.id.color_3:
                img.setRGBA(type, 3, value);
                break;
            case R.id.color_4:
                img.setRGBA(type, 4, value);
                break;
            case R.id.color_5:
                img.setRGBA(type, 5, value);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_1:
                img.setImge(this,R.mipmap.a11);
                break;
            case R.id.img_2:
                img.setImge(this,R.mipmap.a22);
                break;
            case R.id.img_3:
                img.setImge(this,R.mipmap.a33);
                break;
        }
    }
}

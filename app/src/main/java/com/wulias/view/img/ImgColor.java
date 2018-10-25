package com.wulias.view.img;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wulias.view.R;

/**
 * Created by 曹小贼 on 2018/10/25.
 */

public class ImgColor extends View {

    private ColorMatrix colorMatrix;
    private float[] colorValue;
    private Paint paint;
    private Bitmap bitmap;

    public ImgColor(Context context) {
        this(context, null);
    }

    public ImgColor(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImgColor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a22);
        colorMatrix = new ColorMatrix();
        paint = new Paint();
        initColorValue();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        colorMatrix.set(colorValue);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    public void setImge(Context context,int res){
        bitmap = BitmapFactory.decodeResource(context.getResources(), res);
        initColorValue();
        invalidate();
    }

    /**
     * 设置RGBA的
     *
     * @param col   行 1~4
     * @param row   列 1~5
     * @param value 值 -1~1
     */
    public void setRGBA(int col, int row, float value) {
        int index = 5 * (col - 1) + row - 1;
        colorValue[index] = value;
        invalidate();
    }



    public void initColorValue() {
        colorValue = new float[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0
        };
    }

    public float[] getValue(int col) {
        float[] values = new float[5];
        for (int i = 5 * (col - 1), end = 5 * col; i <end;i++){
            values[i%5] = colorValue[i];
        }
        return values;
    }


}

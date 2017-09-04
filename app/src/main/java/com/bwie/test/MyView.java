package com.bwie.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 类作用：自定义View
 * 时  间：2017/9/4 - 9:07.
 * 创建人：张刚
 */

public class MyView extends View {

    Context context;
    private Paint paint;

    private int color;
    private float xiaohuan;
    private float dahuan;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        //获取自定义的属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        color = typedArray.getColor(R.styleable.MyView_colorhuan, Color.RED);
        xiaohuan = typedArray.getDimension(R.styleable.MyView_xiaokuan, 100);
        dahuan = typedArray.getDimension(R.styleable.MyView_dakuan, 109);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        int center = getWidth() / 2;
        int height = getHeight() / 2;
//        int innerCircle = dip2px(context, 83);
//        int rightWidth = dip2px(context, 10);

        //绘制内圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(5);
        canvas.drawCircle(center, height, xiaohuan, this.paint);

        //绘制圆环,设置圆环的颜色修改画笔的颜色
        this.paint.setColor(color);
        this.paint.setStrokeWidth(10);//设置圆环宽度
        canvas.drawCircle(center, height, xiaohuan + 1 + dahuan / 2, this.paint);//圆环宽度为中间圆

        //绘制外圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center, height, xiaohuan + dahuan, this.paint);


        super.onDraw(canvas);
    }

    public interface setcolorLener{
        void setcolor1();
    }

//    private int dip2px(Context context, float dpValue) {
//        final float scale = context.getResources().getDisplayMetrics().density;
//        return (int) (dpValue * scale + 0.5f);
//    }
}

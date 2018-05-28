package tmu2018.trunkcarassistant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by anorb on 09.04.2018.
 */

public class PackIconView extends View
{
    public int w = 420;
    public int h = 365;
    public int w1 = w/3;
    public int h1 = h/3;

    private Paint p, p2, p3, p4;

    private int heightScreen,widthScreen;

    public PackIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.BLACK);
        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.LTGRAY);
        p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setColor(Color.DKGRAY);
        p4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p4.setColor(Color.RED);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        heightScreen = h;
        widthScreen = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //canvas.drawCircle(50,50,50, p2);

        RectF rectF = new RectF (0, 0, w, h);
        canvas.drawRect(rectF,p2);
        Path path = new Path();
        path.moveTo( w,h*(float)0.822);
        path.lineTo( w*(float)0.258,h*(float)0.822);
        path.lineTo( w*(float)0.147,h*(float)0.700);
        path.lineTo( w*(float)0.147,h*(float)0.600);
        path.lineTo( w*(float)0.240,h*(float)0.480);
        path.lineTo( w*(float)0.571,h*(float)0.438);
        path.lineTo( w*(float)0.381,h*(float)0.055);
        path.lineTo( w*(float)0.429,h*(float)0.055);
        path.lineTo( w*(float)0.607,h*(float)0.411);
        path.lineTo( w*(float)0.810,h*(float)0.164);
        path.lineTo( w*(float)0.905,h*(float)0.110);
        path.lineTo( w,h*(float)0.110);
        path.lineTo( w,h*(float)0.822);
        path.close();
        canvas.drawPath(path, p4);

        canvas.drawCircle(w*(float)0.258,h*(float)0.697,w*(float)0.11, p4);
        canvas.drawCircle(w*(float)0.258,h*(float)0.607,w*(float)0.11, p4);
        canvas.drawCircle(w*(float)0.902,h*(float)0.238,w*(float)0.11, p4);

        Path path2 = new Path();
        path2.moveTo( w,h*(float)0.164);
        path2.lineTo( w*(float)0.885,h*(float)0.164);
        path2.lineTo( w*(float)0.683,h*(float)0.411);
        path2.lineTo( w,h*(float)0.411);
        path2.lineTo( w,h*(float)0.164);
        path2.close();
        canvas.drawPath(path2, p2);

        canvas.drawCircle(w*(float)0.643,h*(float)0.822,w*(float)0.16, p2);
        canvas.drawCircle(w*(float)0.643,h*(float)0.822,w*(float)0.13, p3);
        canvas.drawCircle(w*(float)0.643,h*(float)0.822,w*(float)0.07, p2);


        RectF rectL1 = new RectF (w1*(float)0.031,h1*(float)0.316, w1*(float)0.119,h1*(float)0.845);
        canvas.drawRect(rectL1,p3);
        RectF rectL2 = new RectF (w1*(float)0.109,h1*(float)0.223,w1*(float)0.188,h1*(float)0.949);
        canvas.drawRect(rectL2,p3);
        canvas.drawCircle(w1*(float)0.109,h1*(float)0.31,w1*(float)0.078, p3);
        canvas.drawCircle(w1*(float)0.109,h1*(float)0.856,w1*(float)0.078, p3);
        RectF rectC = new RectF (w1*(float)0.219,h1*(float)0.223,w1*(float)0.781,h1*(float)0.949);
        canvas.drawRect(rectC,p3);
        RectF rectR1 = new RectF (w1*(float)0.813,h1*(float)0.223,w1*(float)0.891,h1*(float)0.949);
        canvas.drawRect(rectR1,p3);
        RectF rectR2 = new RectF (w1*(float)0.881,h1*(float)0.316,w1*(float)0.964,h1*(float)0.845);
        canvas.drawRect(rectR2,p3);
        canvas.drawCircle(w1*(float)0.891,h1*(float)0.31,w1*(float)0.078, p3);
        canvas.drawCircle(w1*(float)0.891,h1*(float)0.856,w1*(float)0.078, p3);
        RectF rectHCircle1 = new RectF (w1*(float)0.342,h1*(float)0.034,w1*(float)0.49,h1*(float)0.223);
        canvas.drawArc(rectHCircle1, 180,90,true,p3);
        RectF rectHCircle2 = new RectF (w1*(float)0.485,h1*(float)0.034,w1*(float)0.645,h1*(float)0.223);
        canvas.drawArc(rectHCircle2, 270,90,true,p3);
        RectF rectHL1 = new RectF (w1*(float)0.344,h1*(float)0.130,w1*(float)0.422,h1*(float)0.223);
        canvas.drawRect(rectHL1,p3);
        RectF rectHR2 = new RectF (w1*(float)0.578,h1*(float)0.130,w1*(float)0.656,h1*(float)0.223);
        canvas.drawRect(rectHR2,p3);
        RectF rectHC = new RectF (w1*(float)0.42,h1*(float)0.037,w1*(float)0.578,h1*(float)0.13);
        canvas.drawRect(rectHC,p3);

    }


}


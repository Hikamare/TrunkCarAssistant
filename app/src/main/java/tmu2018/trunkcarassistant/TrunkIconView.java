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

public class TrunkIconView extends View
{
    public int w = 320;
    public int h = 135;

    private Paint p, p2, p3;
    private int heightScreen,widthScreen;

    public TrunkIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.RED);
        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.LTGRAY);
        p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setColor(Color.GREEN);

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

        RectF rectF = new RectF (0, 0, 320, 270);
        canvas.drawRect(rectF,p2);

        RectF rectC1 = new RectF (15, 110, 305, 195);
        canvas.drawRect(rectC1,p);
        RectF rectC2 = new RectF (40, 85, 280, 110);
        canvas.drawRect(rectC2,p);
        canvas.drawCircle(40,110,25, p);
        canvas.drawCircle(280,110,25, p);
        RectF rectC3 = new RectF (40, 195, 90, 220);
        canvas.drawRect(rectC3,p);
        RectF rectC4 = new RectF (230, 195, 280, 220);
        canvas.drawRect(rectC4,p);
        canvas.drawCircle(65,220,25, p);
        canvas.drawCircle(255,220,25, p);

        Path path = new Path();
        path.moveTo( 40, 85);
        path.lineTo( 65 , 85);
        path.lineTo( 100,40);
        path.lineTo( 75 , 40);
        path.lineTo( 40, 85);
        path.close();
        canvas.drawPath(path, p);

        Path path2 = new Path();
        path2.moveTo( 255, 85);
        path2.lineTo( 280 , 85);
        path2.lineTo( 245,40);
        path2.lineTo( 220 , 40);
        path2.moveTo( 255, 85);
        path2.close();
        canvas.drawPath(path2, p);

        RectF rectC5 = new RectF (109, 25, 209, 50);
        canvas.drawRect(rectC5,p);
        RectF rectHCircle1 = new RectF (72, 25, 140, 75);
        canvas.drawOval(rectHCircle1,p);
        RectF rectHCircle2 = new RectF (176, 25, 248, 75);
        canvas.drawOval(rectHCircle2,p);

        Path path3 = new Path();
        path3.moveTo( 65, 85);
        path3.lineTo( 255 , 85);
        path3.lineTo( 225,45);
        path3.lineTo( 95 , 45);
        path3.moveTo( 65, 85);
        path3.close();
        canvas.drawPath(path3, p2);

        canvas.drawCircle(65,125,15, p2);
        canvas.drawCircle(255,125,15, p2);


    }

}


package tmu2018.trunkcarassistant.icons;

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
    public int w = 420;
    public int h = 365;

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
        //canvas.setMatrix();
        RectF rectF = new RectF (0, 0, w, h);
        canvas.drawRect(rectF,p2);

        RectF rectC1 = new RectF (w*(float)0.047, h*(float)0.41, w*(float)0.953, h*(float)0.736);
        canvas.drawRect(rectC1,p);
        RectF rectC2 = new RectF (w*(float)0.125, h*(float)0.316, w*(float)0.875, h*(float)0.41);
        canvas.drawRect(rectC2,p);
        canvas.drawCircle(w*(float)0.125,h*(float)0.41,w*(float)0.078, p);
        canvas.drawCircle(w*(float)0.875,h*(float)0.41,w*(float)0.078, p);
        RectF rectC3 = new RectF (w*(float)0.125,h*(float)0.726,w*(float)0.281,h*(float)0.819);
        canvas.drawRect(rectC3,p);
        RectF rectC4 = new RectF (w*(float)0.719,h*(float)0.726,w*(float)0.875,h*(float)0.819);
        canvas.drawRect(rectC4,p);
        canvas.drawCircle(w*(float)0.203,h*(float)0.819,w*(float)0.078, p);
        canvas.drawCircle(w*(float)0.797,h*(float)0.819,w*(float)0.078, p);

        Path path = new Path();
        path.moveTo( w*(float)0.125,h*(float)0.316);
        path.lineTo( w*(float)0.203,h*(float)0.316);
        path.lineTo( w*(float)0.313,h*(float)0.149);
        path.lineTo( w*(float)0.234,h*(float)0.149);
        path.lineTo( w*(float)0.125,h*(float)0.316);
        path.close();
        canvas.drawPath(path, p);

        Path path2 = new Path();
        path2.moveTo( w*(float)0.797,h*(float)0.316);
        path2.lineTo( w*(float)0.875,h*(float)0.316);
        path2.lineTo( w*(float)0.766,h*(float)0.149);
        path2.lineTo( w*(float)0.688,h*(float)0.149);
        path2.moveTo( w*(float)0.797,h*(float)0.316);
        path2.close();
        canvas.drawPath(path2, p);

        RectF rectC5 = new RectF (w*(float)0.341,h*(float)0.093,w*(float)0.653,h*(float)0.186);
        canvas.drawRect(rectC5,p);
        RectF rectHCircle1 = new RectF (w*(float)0.225,h*(float)0.093,w*(float)0.438,h*(float)0.279);
        canvas.drawOval(rectHCircle1,p);
        RectF rectHCircle2 = new RectF (w*(float)0.55,h*(float)0.093,w*(float)0.775,h*(float)0.279);
        canvas.drawOval(rectHCircle2,p);

        Path path3 = new Path();
        path3.moveTo( w*(float)0.203,h*(float)0.316);
        path3.lineTo( w*(float)0.797,h*(float)0.316);
        path3.lineTo( w*(float)0.703,h*(float)0.168);
        path3.lineTo( w*(float)0.297,h*(float)0.168);
        path3.moveTo( w*(float)0.203,h*(float)0.316);
        path3.close();
        canvas.drawPath(path3, p2);

        canvas.drawCircle(w*(float)0.203,h*(float)0.465,w*(float)0.047, p2);
        canvas.drawCircle(w*(float)0.797,h*(float)0.465,w*(float)0.047, p2);


    }

}


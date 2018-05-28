package tmu2018.trunkcarassistant;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by anorb on 09.04.2018.
 */


public class LuggageIconView extends View
{
    public int w = 420;
    public int h = 365;

    private Paint p, p2, p3;
    private int heightScreen,widthScreen;

    public LuggageIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.RED);
        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.LTGRAY);
        p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setColor(Color.BLACK);
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
        RectF rectL1 = new RectF (w*(float)0.031,h*(float)0.316, w*(float)0.109,h*(float)0.859);
        canvas.drawRect(rectL1,p);
        RectF rectL2 = new RectF (w*(float)0.109,h*(float)0.223,w*(float)0.188,h*(float)0.949);
        canvas.drawRect(rectL2,p);
        canvas.drawCircle(w*(float)0.109,h*(float)0.314,w*(float)0.078, p);
        canvas.drawCircle(w*(float)0.109,h*(float)0.859,w*(float)0.078, p);
        RectF rectC = new RectF (w*(float)0.219,h*(float)0.223,w*(float)0.781,h*(float)0.949);
        canvas.drawRect(rectC,p);
        RectF rectR1 = new RectF (w*(float)0.813,h*(float)0.223,w*(float)0.891,h*(float)0.949);
        canvas.drawRect(rectR1,p);
        RectF rectR2 = new RectF (w*(float)0.890,h*(float)0.316,w*(float)0.969,h*(float)0.859);
        canvas.drawRect(rectR2,p);
        canvas.drawCircle(w*(float)0.891,h*(float)0.314,w*(float)0.078, p);
        canvas.drawCircle(w*(float)0.891,h*(float)0.859,w*(float)0.078, p);
        RectF rectHCircle1 = new RectF (w*(float)0.344,h*(float)0.036,w*(float)0.5,h*(float)0.216);
        canvas.drawArc(rectHCircle1, 180,90,true,p);
        RectF rectHCircle2 = new RectF (w*(float)0.49,h*(float)0.036,w*(float)0.654,h*(float)0.216);
        canvas.drawArc(rectHCircle2, 270,90,true,p);
        RectF rectHL1 = new RectF (w*(float)0.345,h*(float)0.125,w*(float)0.422,h*(float)0.225);
        canvas.drawRect(rectHL1,p);
        RectF rectHR2 = new RectF (w*(float)0.578,h*(float)0.125,w*(float)0.658,h*(float)0.225);
        canvas.drawRect(rectHR2,p);
        RectF rectHC = new RectF (w*(float)0.422,h*(float)0.037,w*(float)0.578,h*(float)0.13);
        canvas.drawRect(rectHC,p);

    }

}


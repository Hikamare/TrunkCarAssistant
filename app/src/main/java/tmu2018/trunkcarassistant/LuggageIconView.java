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
    public int w = 320;
    public int h = 135;

    private Paint p, p2, p3;
    private int heightScreen,widthScreen;

    public LuggageIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.RED);
        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.LTGRAY);

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

        RectF rectF = new RectF (0, 0, 320, 270);
        canvas.drawRect(rectF,p2);
        RectF rectL1 = new RectF (10, 85, 35, 240);
        canvas.drawRect(rectL1,p);
        RectF rectL2 = new RectF (35, 60, 60, 255);
        canvas.drawRect(rectL2,p);
        canvas.drawCircle(35,85,25, p);
        canvas.drawCircle(35,230,25, p);
        RectF rectC = new RectF (70, 60, 250, 255);
        canvas.drawRect(rectC,p);
        RectF rectR1 = new RectF (260, 60, 285, 255);
        canvas.drawRect(rectR1,p);
        RectF rectR2 = new RectF (285, 85, 310, 240);
        canvas.drawRect(rectR2,p);
        canvas.drawCircle(285,85,25, p);
        canvas.drawCircle(285,230,25, p);
        RectF rectHCircle1 = new RectF (110, 10, 160, 60);
        canvas.drawArc(rectHCircle1, 180,90,true,p);
        RectF rectHCircle2 = new RectF (160, 10, 210, 60);
        canvas.drawArc(rectHCircle2, 270,90,true,p);
        RectF rectHL1 = new RectF (110, 35, 135, 60);
        canvas.drawRect(rectHL1,p);
        RectF rectHR2 = new RectF (185, 35, 210, 60);
        canvas.drawRect(rectHR2,p);
        RectF rectHC = new RectF (135, 10, 185, 35);
        canvas.drawRect(rectHC,p);


        //while (int i<10);

    }

}


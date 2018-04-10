package tmu2018.trunkcarassistant;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by anorb on 09.04.2018.
 */


public class LuggageIconView extends View
{
    public int w = 100;
    public int h = 100;

    private Paint p;
    private Paint p2;

    public LuggageIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.RED);
        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.BLUE);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(100, 100, 300, 300, p);
        canvas.drawCircle(300,300,100, p);
        //canvas.drawRect(200,400,200,400,p);

        //while (int i<10);

    }

}


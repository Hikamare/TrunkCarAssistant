package tmu2018.trunkcarassistant.rendering;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import tmu2018.trunkcarassistant.objects.Trunk;

/**
 * Created by Wojtek on 16.03.2018.
 */

//This class is used to drawing trunk and luggages

public class TrunkView extends View {
    private Paint cFront = new Paint();
    private Paint cEnd = new Paint();
    private Paint cLuggageEnd = new Paint();
    private Paint cLugg = new Paint();
    private Paint[] cTable = new Paint[10];

    private boolean isInit = false;
    private float heightTrunkReal, widthTrunkReal, lengthTrunkReal; // CarLuggage
    private float heightTrunkScale, widthTrunkScale, lengthTrunkScale; // CarLuggage
    private float heightTrunkNow, widthTrunkNow, lengthTrunkNow; // CarLuggage
    private int heightScreen, widthScreen;

    private Trunk trunk;
    private boolean isLuggage = false;
    //Variables to test TrunkView
    private Paint circle = new Paint();


    public Trunk getTrunk() {
        return trunk;
    }

    public void setTrunk(Trunk trunk) {
        this.trunk = trunk;
        isLuggage = true;
    }


    public TrunkView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        for (int i = 0; i < cTable.length; i++) {
            cTable[i] = new Paint();
            cTable[i].setStyle(Paint.Style.FILL);
        }
        cTable[0].setColor(Color.rgb(205, 255, 0));
        cTable[1].setColor(Color.rgb(0, 255, 230));
        cTable[2].setColor(Color.rgb(9, 0, 255));
        cTable[3].setColor(Color.rgb(255, 0, 51));
        cTable[4].setColor(Color.rgb(255, 0, 205));
        cTable[5].setColor(Color.rgb(198, 15, 243));
        cTable[6].setColor(Color.rgb(15, 144, 243));
        cTable[7].setColor(Color.rgb(243, 243, 15));
        cTable[8].setColor(Color.rgb(243, 190, 15));
        cTable[9].setColor(Color.rgb(243, 68, 15));


    }

    private void initCarLaggage() {
        cFront.setColor(Color.RED);
        cEnd.setColor(Color.GRAY);
        cLuggageEnd.setColor(Color.BLACK);
        cLugg.setColor(Color.BLUE);
        cLugg.setStyle(Paint.Style.FILL);
        widthTrunkScale = (float) Math.sqrt(Math.pow(((widthScreen / 4 + widthScreen / 16) - (widthScreen * 3 / 4 + widthScreen / 16)), 2) + Math.pow((heightScreen / 2 - heightScreen / 2), 2));
        heightTrunkScale = (float) Math.sqrt(Math.pow((widthScreen * 3 / 4 + widthScreen / 16) - (widthScreen * 3 / 4 + widthScreen / 16), 2) + Math.pow((heightScreen / 2 - heightScreen / 6), 2));

        float x1 = (widthScreen / 4 + widthScreen / 16);
        float y1 = heightScreen / 2;
        float x2 = widthScreen / 4 + widthScreen / 16 - 120;
        float y2 = heightScreen / 2 + 120;
        lengthTrunkScale = (float) Math.sqrt(Math.pow((double) (x1 - x2), 2) + Math.pow((double) (y1 - y2), 2));

        /*widthTrunkNow = 0;
        heightTrunkNow = 0;
        lengthTrunkNow = 0;
*/

        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (trunk == null) {
            return;
        }
        if (trunk.isAcvite()) {

            if (!isInit) {
                initCarLaggage();
            }
            //drawTrunkpart1(canvas);
            //widthTrunkNow = 0;
            //heightTrunkNow = 0;
            //lengthTrunkNow = 0;
            //if(isLuggage == true)
            // {
            //if(trunk.isP() == true) {

            for (int i = 0; i < trunk.howLuggages(); i++) {
                //if (trunk.isAcvite()) {
                //  if (trunk.getLuggage(i).isActive()) {
                //    if (trunk.getLuggage(i).isNew()) {
                trunk.scaleLuggages(heightTrunkScale, widthTrunkScale, lengthTrunkScale);
                trunk.getLuggage(i).setRefWidth(widthTrunkNow);
                //widthTrunkNow += trunk.getLuggage(i).getWidthScale();
                //System.out.println(trunk.getLuggage(i).getWidthScale());
                //  }
                // }
                // }
                //trunk.info();
                //   }
                //trunk.isntNew();
                //drawLuggage(canvas);
                //drawLuggages(canvas);
            }
            drawTrunkpart1(canvas);
            drawLuggages(canvas);
            drawTrunkpart2(canvas);

        }

        //This circle is used as a reference point
        //canvas.drawCircle(widthScreen/4 + widthScreen/16,heightScreen/2,5,circle);
    }


    private void drawTrunkpart2(Canvas c) {
        //4
        c.drawLine(widthScreen * 3 / 4 + widthScreen / 16, heightScreen / 2, widthScreen * 3 / 4 + widthScreen / 16 - 120, heightScreen / 2 + 120, cFront);
        //5
        c.drawLine(widthScreen / 4 + widthScreen / 16 - 120, heightScreen / 2 + 120, widthScreen * 3 / 4 + widthScreen / 16 - 120, heightScreen / 2 + 120, cFront);
        //6
        c.drawLine(widthScreen / 4 + widthScreen / 16, heightScreen / 6, widthScreen * 3 / 4 + widthScreen / 16, heightScreen / 6, cFront);
        //7
        c.drawLine(widthScreen * 3 / 4 + widthScreen / 16, heightScreen / 2, widthScreen * 3 / 4 + widthScreen / 16, heightScreen / 6, cFront);
        //8
        c.drawLine(widthScreen * 3 / 4 + widthScreen / 16 - 120, heightScreen / 2 + 120, widthScreen * 3 / 4 + widthScreen / 16 - 120, heightScreen / 6 + 120, cFront);
        //9
        c.drawLine(widthScreen / 4 + widthScreen / 16 - 120, heightScreen * 1 / 6 + 120, widthScreen * 3 / 4 + widthScreen / 16 - 120, heightScreen / 6 + 120, cFront);
        //10
        c.drawLine(widthScreen / 4 + widthScreen / 16 - 120, heightScreen / 2 + 120, widthScreen / 4 + widthScreen / 16 - 120, heightScreen * 1 / 6 + 120, cFront);
        //11
        c.drawLine(widthScreen * 3 / 4 + widthScreen / 16 - 120, heightScreen / 6 + 120, widthScreen * 3 / 4 + widthScreen / 16, heightScreen / 6, cFront);
        //12
        c.drawLine(widthScreen / 4 + widthScreen / 16 - 120, heightScreen / 6 + 120, widthScreen / 4 + widthScreen / 16, heightScreen / 6, cFront);
    }

    private void drawTrunkpart1(Canvas c) {
        //1
        c.drawLine(widthScreen / 4 + widthScreen / 16, heightScreen / 2, widthScreen * 3 / 4 + widthScreen / 16, heightScreen / 2, cEnd);
        //2
        c.drawLine(widthScreen / 4 + widthScreen / 16, heightScreen / 2, widthScreen / 4 + widthScreen / 16, heightScreen * 1 / 6, cEnd);
        //3
        c.drawLine(widthScreen / 4 + widthScreen / 16, heightScreen / 2, widthScreen / 4 + widthScreen / 16 - 120, heightScreen / 2 + 120, cEnd);

    }

    public void drawLuggages(Canvas c) {

        for (int i = 0; i < trunk.howLuggages(); i++) {


            float y = (widthScreen / 4 + widthScreen / 16);
            float x = heightScreen / 2;

            c.drawLine(y, x, y, (float) (x - 14.2), cLugg);

            Path luggageV = new Path();
            luggageV.reset();
            luggageV.moveTo((float) (y + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71));
            luggageV.lineTo((float) (y + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (x - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71)));
            luggageV.lineTo(y + (float) (trunk.getLuggage(i).getyViewScale()) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), x - trunk.getLuggage(i).getHeightScale() - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71));
            luggageV.lineTo(y + trunk.getLuggage(i).getWidthScale() + (float) (trunk.getLuggage(i).getyViewScale()) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), x - trunk.getLuggage(i).getHeightScale() - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71));
            luggageV.lineTo(y + trunk.getLuggage(i).getWidthScale() + (float) (trunk.getLuggage(i).getyViewScale()) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), x + (float) (trunk.getLuggage(i).getxViewScale() * 0.71) - (float) (trunk.getLuggage(i).getzViewScale()));
            luggageV.lineTo((float) (y + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) + (float) (trunk.getLuggage(i).getyViewScale())) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71));
            luggageV.lineTo((float) (y + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71));
            cLugg.setColor(trunk.getLuggage(i).getColor());
            c.drawPath(luggageV, cLugg);


            //10
            c.drawLine((float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (y + (float) (trunk.getLuggage(i).getyViewScale()) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71)), cLuggageEnd);
            //12
            c.drawLine((float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71)), y + (float) (trunk.getLuggage(i).getyViewScale()) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), x - trunk.getLuggage(i).getHeightScale() - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), cLuggageEnd);
            //6
            c.drawLine(y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()), x - trunk.getLuggage(i).getHeightScale() - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), y + trunk.getLuggage(i).getWidthScale() + (float) (trunk.getLuggage(i).getyViewScale()) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), x - trunk.getLuggage(i).getHeightScale() - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), cLuggageEnd);
            //7
            c.drawLine(y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + trunk.getLuggage(i).getWidthScale() + (float) (trunk.getLuggage(i).getyViewScale()), x - trunk.getLuggage(i).getHeightScale() - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), y + trunk.getLuggage(i).getWidthScale() + (float) (trunk.getLuggage(i).getyViewScale()) - (float) (trunk.getLuggage(i).getxViewScale() * 0.71), x + (float) (trunk.getLuggage(i).getxViewScale() * 0.71) - (float) (trunk.getLuggage(i).getzViewScale()), cLuggageEnd);
            //4
            c.drawLine((float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + trunk.getLuggage(i).getWidthScale() + (float) (trunk.getLuggage(i).getyViewScale())), x + (float) (trunk.getLuggage(i).getxViewScale() * 0.71) - (float) (trunk.getLuggage(i).getzViewScale()), (float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) + (float) (trunk.getLuggage(i).getyViewScale())), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), cLuggageEnd);
            //5
            c.drawLine((float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) + (float) (trunk.getLuggage(i).getyViewScale())), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), cLuggageEnd);//6
            //8
            c.drawLine((float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) + (float) (trunk.getLuggage(i).getyViewScale())), (float) (x + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) + trunk.getLuggage(i).getWidthScale()), (float) (x - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71)), cLuggageEnd);
            //11
            c.drawLine((float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) + trunk.getLuggage(i).getWidthScale()), (float) (x - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71)), (float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71)), cLuggageEnd);
            //12
            c.drawLine(y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + trunk.getLuggage(i).getWidthScale() + (float) (trunk.getLuggage(i).getyViewScale()), x - trunk.getLuggage(i).getHeightScale() - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71), (float) (y - (float) (trunk.getLuggage(i).getxViewScale() * 0.71) + (float) (trunk.getLuggage(i).getyViewScale()) - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) + trunk.getLuggage(i).getWidthScale()), (float) (x - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - (float) (trunk.getLuggage(i).getzViewScale()) + (float) (trunk.getLuggage(i).getxViewScale() * 0.71)), cLuggageEnd);

        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        heightScreen = h;
        widthScreen = w;
    }

}

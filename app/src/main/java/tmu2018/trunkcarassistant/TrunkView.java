package tmu2018.trunkcarassistant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

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
    private float heightTrunkReal,widthTrunkReal,lengthTrunkReal; // CarLuggage
    private float heightTrunkScale,widthTrunkScale,lengthTrunkScale; // CarLuggage
    private float heightTrunkNow,widthTrunkNow,lengthTrunkNow; // CarLuggage
    private int heightScreen,widthScreen;

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
        for(int i =0; i<cTable.length; i++)
        {
            cTable[i] = new Paint();
            cTable[i].setStyle(Paint.Style.FILL);
        }
        cTable[0].setColor(Color.rgb(205,255,0));
        cTable[1].setColor(Color.rgb(0,255,230));
        cTable[2].setColor(Color.rgb(9,0,255));
        cTable[3].setColor(Color.rgb(255,0,51));
        cTable[4].setColor(Color.rgb(255,0,205));
        cTable[5].setColor(Color.rgb(198,15,243));
        cTable[6].setColor(Color.rgb(15,144,243));
        cTable[7].setColor(Color.rgb(243,243,15));
        cTable[8].setColor(Color.rgb(243,190,15));
        cTable[9].setColor(Color.rgb(243,68,15));



    }
    private void initCarLaggage()
    {
        cFront.setColor(Color.RED);
        cEnd.setColor(Color.GRAY);
        cLuggageEnd.setColor(Color.BLACK);
        cLugg.setColor(Color.BLUE);
        cLugg.setStyle(Paint.Style.FILL);
        widthTrunkScale = (float) Math.sqrt(Math.pow(((widthScreen/4+ widthScreen/16)-(widthScreen*3/4+ widthScreen/16)),2)+Math.pow((heightScreen/2-heightScreen/2),2));
        heightTrunkScale = (float) Math.sqrt(Math.pow((widthScreen*3/4+ widthScreen/16)-(widthScreen*3/4+ widthScreen/16),2)+Math.pow((heightScreen/2 - heightScreen/6),2));

        float x1 = (widthScreen/4+ widthScreen/16);
        float y1 = heightScreen/2;
        float x2 = widthScreen/4+ widthScreen/16 - 120;
        float y2 = heightScreen/2 + 120;
        lengthTrunkScale = (float) Math.sqrt( Math.pow((double)(x1-x2),2) + Math.pow((double)(y1-y2),2));

        /*widthTrunkNow = 0;
        heightTrunkNow = 0;
        lengthTrunkNow = 0;
*/

        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            if(trunk == null)
            {return;}

            if (!isInit) {
                initCarLaggage();
            }
            drawTrunk(canvas);
        widthTrunkNow = 0;
        heightTrunkNow = 0;
        lengthTrunkNow = 0;
        //if(isLuggage == true)
       // {
        //if(trunk.isP() == true) {

            for (int i = 0; i < trunk.howLuggages(); i++) {
                //if (trunk.isAcvite()) {
                  //  if (trunk.getLuggage(i).isActive()) {
                    //    if (trunk.getLuggage(i).isNew()) {
                            trunk.scaleLuggages(heightTrunkScale, widthTrunkScale, lengthTrunkScale);
                            trunk.getLuggage(i).setRefWidth(widthTrunkNow);
                            widthTrunkNow += trunk.getLuggage(i).getWidthScale();
                            System.out.println(trunk.getLuggage(i).getWidthScale());
                      //  }
                   // }
               // }
                //trunk.info();
         //   }
            //trunk.isntNew();
            drawLuggage(canvas);
        }
            //This circle is used as a reference point
            //canvas.drawCircle(widthScreen/4 + widthScreen/16,heightScreen/2,5,circle);
        }


    private void drawTrunk(Canvas c)
    {
        //1
        c.drawLine(widthScreen/4+ widthScreen/16,heightScreen/2,widthScreen*3/4+ widthScreen/16,heightScreen/2,cEnd);
        //2
        c.drawLine(widthScreen/4+ widthScreen/16,heightScreen/2,widthScreen/4+ widthScreen/16,heightScreen*1/6,cEnd);
        //3
        c.drawLine(widthScreen/4+ widthScreen/16,heightScreen/2,widthScreen/4+ widthScreen/16 - 120,heightScreen/2+120,cEnd);
        //4
        c.drawLine(widthScreen*3/4+ widthScreen/16,heightScreen/2,widthScreen*3/4+ widthScreen/16-120,heightScreen/2+120,cFront);
        //5
        c.drawLine(widthScreen/4+ widthScreen/16-120,heightScreen/2+120,widthScreen*3/4+ widthScreen/16-120,heightScreen/2+120,cFront);
        //6
        c.drawLine(widthScreen/4+ widthScreen/16,heightScreen/6,widthScreen*3/4+ widthScreen/16,heightScreen/6,cFront);
        //7
        c.drawLine(widthScreen*3/4+ widthScreen/16,heightScreen/2,widthScreen*3/4+ widthScreen/16,heightScreen/6,cFront);
        //8
        c.drawLine(widthScreen*3/4+ widthScreen/16-120,heightScreen/2+120,widthScreen*3/4+ widthScreen/16-120,heightScreen/6+120,cFront);
        //9
        c.drawLine(widthScreen/4+ widthScreen/16-120,heightScreen*1/6+120,widthScreen*3/4+ widthScreen/16-120,heightScreen/6+120,cFront);
        //10
        c.drawLine(widthScreen/4+ widthScreen/16-120,heightScreen/2+120,widthScreen/4+ widthScreen/16-120,heightScreen*1/6+120,cFront);
        //11
        c.drawLine(widthScreen*3/4+ widthScreen/16-120,heightScreen/6+120,widthScreen*3/4+ widthScreen/16,heightScreen/6,cFront);
        //12
        c.drawLine(widthScreen/4+ widthScreen/16-120,heightScreen/6+120,widthScreen/4+ widthScreen/16,heightScreen/6,cFront);
    }

    private void drawLuggage(Canvas c) {
        float refDepth = 0;
        float refWeight = 0;
        float refHeight = 0;

        refDepth = this.lengthTrunkScale - this.lengthTrunkNow;
        refWeight = this.widthTrunkScale - this.widthTrunkNow;
        refHeight = this.heightTrunkScale - this.heightTrunkNow;

        for(int i =0;i<trunk.howLuggages();i++) {

            if (trunk.getLuggage(i).getWidthScale() < refWeight && trunk.getLuggage(i).getHeightScale() < refHeight && trunk.getLuggage(i).getLengthScale() < refDepth) {
                Random r = new Random();
                int a = r.nextInt(10);
                cLugg = cTable[a];
                float x = (widthScreen / 4 + widthScreen / 16) + trunk.getLuggage(i).getRefWidth();
                float y = heightScreen / 2;

                Path luggageV = new Path();
                luggageV.reset();
                luggageV.moveTo((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
                luggageV.lineTo((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
                luggageV.lineTo(x, y - trunk.getLuggage(i).getHeightScale());
                luggageV.lineTo(x + trunk.getLuggage(i).getWidthScale(), y - trunk.getLuggage(i).getHeightScale());
                luggageV.lineTo(x + trunk.getLuggage(i).getWidthScale(), y);
                luggageV.lineTo( (float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
                luggageV.lineTo((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
                c.drawPath(luggageV,cLugg);

                //1
                //c.drawLine(x, y, x + trunk.getLuggage(i).getWidthScale(), y,cLuggageEnd );
                //2
                //c.drawLine(x, y, x, y - trunk.getLuggage(i).getHeightScale(), cLuggageEnd);
                //3
                //c.drawLine(x, y, (float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)),cLuggageEnd );
                //4
                c.drawLine(x + trunk.getLuggage(i).getWidthScale(), y, (float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), cLuggageEnd);
                //5
                c.drawLine((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), cLuggageEnd);
                //6
                c.drawLine(x, y - trunk.getLuggage(i).getHeightScale(), x + trunk.getLuggage(i).getWidthScale(), y - trunk.getLuggage(i).getHeightScale(), cLuggageEnd);
                //7
                c.drawLine(x + trunk.getLuggage(i).getWidthScale(), y, x + trunk.getLuggage(i).getWidthScale(), y - trunk.getLuggage(i).getHeightScale(), cLuggageEnd);
                //8
                c.drawLine((float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), cLuggageEnd);
                //9
                c.drawLine((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - trunk.getLuggage(i).getHeightScale()), (float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - trunk.getLuggage(i).getHeightScale()), cLuggageEnd);//6
                //10
                c.drawLine((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), cLuggageEnd);
                //11
                c.drawLine(x + trunk.getLuggage(i).getWidthScale(), y - trunk.getLuggage(i).getHeightScale(), (float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0) - trunk.getLuggage(i).getHeightScale()), cLuggageEnd);
                //12
                c.drawLine(x, y - trunk.getLuggage(i).getHeightScale(), (float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)),cLuggageEnd);
            }
        }
    }

    public void drawLuggages(Canvas c){

        for(int i =0;i<trunk.howLuggages();i++) {
            Random r = new Random();
            int a = r.nextInt(10);
            cLugg = cTable[a];
            float x = (widthScreen / 4 + widthScreen / 16) + trunk.getLuggage(i).getRefWidth();
            float y = heightScreen / 2;

            Path luggageV = new Path();
            luggageV.reset();
            luggageV.moveTo((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
            luggageV.lineTo((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y - trunk.getLuggage(i).getHeightScale() + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
            luggageV.lineTo(x, y - trunk.getLuggage(i).getHeightScale());
            luggageV.lineTo(x + trunk.getLuggage(i).getWidthScale(), y - trunk.getLuggage(i).getHeightScale());
            luggageV.lineTo(x + trunk.getLuggage(i).getWidthScale(), y);
            luggageV.lineTo((float) (x + trunk.getLuggage(i).getWidthScale() - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
            luggageV.lineTo((float) (x - trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)), (float) (y + trunk.getLuggage(i).getLengthScale() / Math.sqrt(2.0)));
            c.drawPath(luggageV, cLugg);

        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        heightScreen = h;
        widthScreen = w;
    }

}

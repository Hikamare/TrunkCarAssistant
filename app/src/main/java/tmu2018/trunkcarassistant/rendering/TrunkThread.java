package tmu2018.trunkcarassistant.rendering;

import tmu2018.trunkcarassistant.objects.Luggage;
import tmu2018.trunkcarassistant.objects.Trunk;

/**
 * Created by Wojtek on 16.03.2018.
 */

public class TrunkThread implements Runnable {

    private android.os.Handler handler;
    private Trunk trunkModel;
    private Luggage[] bb;
    private TrunkView trunkView;
    public TrunkThread(android.os.Handler h, Trunk clm, TrunkView clv)
    {
        handler = h;
        trunkModel = clm;
        trunkView = clv;

    }

    @Override
    public void run() {

            System.out.println("Jestem w nowym wątku");

            trunkView.setTrunk(trunkModel);

            try {
                Thread.sleep(1);

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        trunkView.invalidate();
                    }
                });

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Koniec watku");
        }
    }


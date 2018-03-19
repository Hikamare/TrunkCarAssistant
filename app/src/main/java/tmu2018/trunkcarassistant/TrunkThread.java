package tmu2018.trunkcarassistant;

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

            trunkView.setTrunk(trunkModel);

            try {
                Thread.sleep(1000);

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
        }
    }


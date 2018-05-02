package asange.android80_study;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
        final String aa = "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "abcdefgghgsfggdsfgjfjdsfgdsffdfsfw" +
                "" +
                "" +
                "" +
                "";


        int subLength = 5;
        long start = SystemClock.elapsedRealtimeNanos();
        aa.substring(subLength);
        long end = SystemClock.elapsedRealtimeNanos();
        Log.d("------->1", "time:" + (end - start));

        long start2 = SystemClock.elapsedRealtimeNanos();
        aa.substring(0, aa.length() - subLength);
        long end2 = SystemClock.elapsedRealtimeNanos();
        Log.d("------->2", "time:" + (end2 - start2));

        StringBuilder stringBuilder = new StringBuilder(aa);
        long start3 = SystemClock.elapsedRealtimeNanos();
        stringBuilder.delete(0, stringBuilder.length() - subLength).toString();
        long end3 = SystemClock.elapsedRealtimeNanos();
        Log.d("------->3", "time:" + (end3 - start3));

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        StringBuilder stringBuilder2 = new StringBuilder(aa);
        long start4 = SystemClock.elapsedRealtimeNanos();
        for (int i = 0; i < 10; i++) {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1).toString();
        }
        long end4 = SystemClock.elapsedRealtimeNanos();
        Log.d("------->4", "time:" + (end4 - start4));


        stringBuilder2 = new StringBuilder(aa);
        long start5 = SystemClock.elapsedRealtimeNanos();
        for (int i = 0; i < 10; i++) {
            stringBuilder2.deleteCharAt(0).toString();
        }
        long end5 = SystemClock.elapsedRealtimeNanos();
        Log.d("------->5", "time:" + (end5 - start5));


        ///测试1

    }
}

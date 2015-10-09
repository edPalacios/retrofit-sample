package retrofitsample.com.ep.retrofitsample;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by Eduardo on 09/10/2015.
 */
public class VideoIntentService extends IntentService {

    public VideoIntentService() {
        super("VideoIntentService");
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context,VideoIntentService.class);
    }

    public static Intent makeIntent(Context context, Uri videoUri, Video video) {
        Bundle bundle = new Bundle();
        bundle.putLong("id", video.getId());
        bundle.putString("title", video.getTitle());
        return new Intent(context, VideoIntentService.class)
                .setData(videoUri).putExtra("bundle", bundle);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        VideoServerMediator serverMediator = new VideoServerMediator();
        serverMediator.callGetVideos();
    }
}

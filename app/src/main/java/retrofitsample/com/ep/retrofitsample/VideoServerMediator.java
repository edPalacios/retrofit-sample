package retrofitsample.com.ep.retrofitsample;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Eduardo on 09/10/2015.
 */
public class VideoServerMediator {

    private static VideoServerProxy mVideoServiceProxy;
    private static VideoServerMediator mInstance;
    private Retrofit retrofit;
    private SimpleOkHttpClient client;
    private final static String BASE_URL = "http://foo.com";

    public VideoServerMediator() {
        client = new SimpleOkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .build();
        mVideoServiceProxy = retrofit.create(VideoServerProxy.class);
    }

    public void callGetVideos() {
        Call<List<Video>> call =  mVideoServiceProxy.getVideoList();
        //call.execute();  --> Synchronous Request <--
        call.enqueue(new Callback<List<Video>>() { // --> Asynchronous Request <--
            @Override
            public void onResponse(Response<List<Video>> response, Retrofit retrofit) {
                //do something with the response (like get the videos)
                List<Video> mVideos = response.body();
            }

            @Override
            public void onFailure(Throwable t) {
                //handle the if fail
            }
        });
    }

    public void callGetVideo(Video video) {
        Call<Video> call = mVideoServiceProxy.getVideoById(video.getId());
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Response<Video> response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public void callAddVideo(Video video) {
        Call<Video> call = mVideoServiceProxy.postVideo(video);
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Response<Video> response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

}

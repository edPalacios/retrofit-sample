package retrofitsample.com.ep.retrofitsample;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;


/**
 * Created by Eduardo on 09/10/2015.
 */
public interface VideoServerProxy {

    public static final String VIDEO_SVC_PATH = "/videos";

    @GET(VIDEO_SVC_PATH)
    Call<List<Video>> getVideoList();

    @GET(VIDEO_SVC_PATH + "/{id}")
    Call<Video>getVideoById(@Path("id") long id);

    @POST(VIDEO_SVC_PATH)
    Call<Video> postVideo(@Body Video Video);

}

package retrofitsample.com.ep.retrofitsample;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;



/**
 * Created by Eduardo on 09/10/2015.
 */
public class SimpleOkHttpClient extends  OkHttpClient {

    private OkHttpClient client;

    public SimpleOkHttpClient() {
        client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            // Do anything with response here
            return response;
        }
    });
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }
}

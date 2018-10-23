package tools;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import java.net.URL;

/**
 * Created URL and send request.
 */
public class HttpClient {
    OkHttpClient client = new OkHttpClient();

    public String doGetRequest(URL url) {
        Request request = new Request.Builder().url(url).build();
        Response response;
        String strResp = null;
        try {
            response = client.newCall(request).execute();
            strResp = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Check internet connection or health API");
        }

        return strResp;
    }

    public URL createURL(String date) {
        URL url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.exchangeratesapi.io")
                .addPathSegments(date)
                .addQueryParameter("base", "USD")
                .build().url();
        return url;
    }
}

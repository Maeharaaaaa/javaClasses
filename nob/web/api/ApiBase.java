package nob.web.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

class ApiBase {
    private URL apiUrl = null;
    private int responseCode = 0;
    private String method = "GET";
    private String param = "";
    private String response ="";

    protected final boolean access(){

        HttpURLConnection httpcon = this.connect();
        this.setOutputStream();

        // レスポンスを受信する
        int iResponseCode = httpcon.getResponseCode();
        // 接続が確立したとき
        if (iResponseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder resultBuilder = new StringBuilder();
            String line = "";
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            // レスポンスの読み込み
            while ((line = br.readLine()) != null) {
                resultBuilder.append(String.format("%s%s", line, "\r\n"));
            }
            String result = "";
            result = resultBuilder.toString();
        }
        return true;
    }

    private HttpURLConnection connect() {
        HttpURLConnection httpcon = null;
        try {
            httpcon = (HttpURLConnection) ((new URL(this.apiUrl).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestMethod(this.method);
            httpcon.connect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpcon;
    }

    private void setOutputStream(HttpURLConnection httpcon) {
        try(
                OutputStream os = httpcon.getOutputStream();
        ) {
            byte[] outputBytes = this.param.getBytes("utf-8");
            os.write(outputBytes);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    protected int getResponceCode() {
        return this.responseCode;
    }

    protected BufferedReader getResult() {
        BufferedReader br = null;
        return br;
    }

    protected void setParam(String param) {
        this.param = param;
    }

    protected void setMethod(String method) {
        this.method = method;
    }
    protected void setApiUrl(String apiUrl) {
        try {
            this.apiUrl = new URL(apiUrl);
        } catch (MalformedURLException e) {
        }

    }

}
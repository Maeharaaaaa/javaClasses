import nob.web.api.ApiSlack;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

class Main {
    private final static String EOL = "\r\n";
    public static void main(String rgs[]) {
        ApiSlack slack = new ApiSlack();
        slack.sendMassage("aaaa");
        try {

            String apiUrl = "https://hooks.slack.com/services/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";
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL(apiUrl).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            byte[] outputBytes = "payload={\"text\": \"GitLabで通知があったよっていうテストです。masdasaffffffeha12ra\", \"channel\":\"#general\"}".getBytes("UTF-8");

            OutputStream os = httpcon.getOutputStream();
            os.write(outputBytes);
            os.close();

            // レスポンスを受信する
            int iResponseCode = httpcon.getResponseCode();
            // 接続が確立したとき
//            if (iResponseCode == HttpURLConnection.HTTP_OK) {
//                    StringBuilder resultBuilder = new StringBuilder();
//                    String line = "";
//                    BufferedReader br = null;
//                    br = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
//                // レスポンスの読み込み
//                while ((line = br.readLine()) != null) {
//                        resultBuilder.append(String.format("%s%s", line, EOL));
//                }
//                String result = "";
//                result = resultBuilder.toString();
//            }
            // TODO: aaaaa
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("終了");


    }


}



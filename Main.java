import nob.web.ApiSlack;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

class Main {
    private final static String EOL = "\r\n";
    public static void main(String rgs[]) {
        ApiSlack slack = new ApiSlack();
        slack.test();
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
            System.out.println("11111");

            // レスポンスを受信する
            int iResponseCode = httpcon.getResponseCode();
            System.out.println(httpcon.getResponseMessage());
            System.out.println(iResponseCode);
            // 接続が確立したとき
            if (iResponseCode == HttpURLConnection.HTTP_OK) {
                    StringBuilder resultBuilder = new StringBuilder();
                    String line = "";
                    BufferedReader br = null;
                    br = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
                // レスポンスの読み込み
                while ((line = br.readLine()) != null) {
                        resultBuilder.append(String.format("%s%s", line, EOL));
                }
                String result = "";
                result = resultBuilder.toString();
                System.out.println("3333");
                System.out.println(result);
            }
            // TODO: aaaaa
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("22222");
        }
        System.out.println("終了");
    }


}



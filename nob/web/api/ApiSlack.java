package nob.web.api;

import java.util.HashMap;
import java.util.Map;

public class ApiSlack extends ApiBase {
    private HashMap<String, String> param = null;
    private String channel = null;

    public ApiSlack() {
        this.param = new HashMap<String, String>();
        this.channel = "#general";
    }

    public String sendMassage(String message) {
        this.setApiUrl("https://hooks.slack.com/services/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");
        this.setMethod("POST");
        this.param.put("text", message);
        this.setParam(buildJsonParam(this.param));
        this.access();
        this.getResult();

        return "aaaa";
    }


    private String buildJsonParam(HashMap<String, String> params) {
        this.param.put("channel", channel);

        String paramStr = "payload={";
        for(Map.Entry<String, String> param : params.entrySet()) {
            paramStr += "\"" + param.getKey() + "\" : " + "\"" + param.getValue() + "\" ,";
        }

        paramStr += "}";
        return paramStr;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }






}

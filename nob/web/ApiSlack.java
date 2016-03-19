package nob.web;


public class ApiSlack extends AccessApi {
    
    public ApiSlack() {
        super("https://hooks.slack.com/services/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\"");
    }
    
    @Override

    public void test() {
        System.out.println(this.apiUrl);
    }

}

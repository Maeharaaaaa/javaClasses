package nob.web;

import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;


abstract class AccessApi implements Api{
    private URL apiUrl = null;

    protected AccessApi(String url) {
        try {
            apiUrl = new URL(url);
        } catch(MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(apiUrl);
    }
    abstract protected void test();

    public boolean access(){
        return true;
    }
    public void setParam(String param) {

    }
    public int getResponceCode() {
        return 200;
    }
    public BufferedReader getResponce() {
        BufferedReader br = null;
        return br;
    }
}
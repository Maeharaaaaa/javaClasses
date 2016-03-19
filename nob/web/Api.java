package nob.web;
import java.net.URL;
import java.io.BufferedReader;

interface Api {
    URL apiUrl = null;

    boolean access();
    void setParam(String param);
    int getResponceCode();
    BufferedReader getResponce();
}

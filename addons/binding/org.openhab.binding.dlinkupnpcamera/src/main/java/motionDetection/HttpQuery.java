package motionDetection;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class HttpQuery extends Thread {

    private String url;
    private boolean move;
    private boolean detectMotion;

    public HttpQuery(String url) {
        this.url = url;
        this.move = false;
    }

    public HttpQuery() {
        this.url = null;
        this.move = false;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    boolean getMove() {
        return this.move;
    }

    public void controlCamera(String urlp) {

        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });

        URL url = null;
        try {
            url = new URL(urlp);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (url.getUserInfo() != null) {
            new Base64();
            String basicAuth = "Basic " + new String(Base64.encode(url.getUserInfo().getBytes()));
            urlConnection.setRequestProperty("Authorization", basicAuth);
        }

        try {
            InputStream inputStream = urlConnection.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            System.out.print("");// Strange behaviour if we comment this line

            if (detectMotion) {
                this.move = true;
                setDetectMotion(false);
                controlCamera(url);
                System.out.println("D�tection de mouvement.");

                this.move = false;
            }

        }

    }

    public void setDetectMotion(boolean b) {
        this.detectMotion = b;
    }

    public boolean getDetectMotion() {
        return this.detectMotion;
    }
}

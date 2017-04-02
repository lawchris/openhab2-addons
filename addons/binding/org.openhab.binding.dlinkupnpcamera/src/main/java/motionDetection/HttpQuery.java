package motionDetection;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

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

    // public void controlCamera(String string_url) {
    //
    // Authenticator.setDefault(new Authenticator() {
    // @Override
    // protected PasswordAuthentication getPasswordAuthentication() {
    // return new PasswordAuthentication(username, password.toCharArray());
    // }
    // });
    //
    // URL url = null;
    // try {
    // url = new URL(String.format(string_url));
    // } catch (MalformedURLException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // HttpURLConnection urlConnection = null;
    // try {
    // urlConnection = (HttpURLConnection) url.openConnection();
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    //
    // try {
    // InputStream inputStream = urlConnection.getInputStream();
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    //
    // }

    public void sendHttpRequest(String string_url) {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("admin", "azerty".toCharArray());
            }
        });
        URL url = null;
        try {
            url = new URL(String.format(string_url));
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
        } catch (IOException e) {
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
                sendHttpRequest(url);
                // System.out.println("D�tection de mouvement.");

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

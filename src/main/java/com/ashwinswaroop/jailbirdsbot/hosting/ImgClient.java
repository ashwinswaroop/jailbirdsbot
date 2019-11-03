package com.ashwinswaroop.jailbirdsbot.hosting;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.*;

public class ImgClient extends HostingClient<HttpURLConnection, String, String> {

    private String clientId;
    private String directoryLocation;
    private String name;


    public ImgClient(String clientId, String directoryLocation, String name) {
        this.clientId = clientId;
        this.directoryLocation = directoryLocation;
        this.name = name;
    }

    @Override
    protected HttpURLConnection getRequest() {
        HttpURLConnection connection = null;
        try {
            URL url;
            url = new URL(IMG_ENDPOINT + IMAGE);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(POST);
            connection.setRequestProperty(AUTHORIZATION, CLIENT_HEADER + SPACE + clientId);
            connection.setRequestProperty(CONTENT_TYPE_HEADER,
                    FORM_URLENCODED);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;

    }

    @Override
    protected String getData() {
        String data = null;
        File file = new File(directoryLocation + VIRGULE + name);
        System.out.println(file.getPath());
        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, PNG_FORMAT, byteArrayOutputStream);
            byte[] byteImage = byteArrayOutputStream.toByteArray();
            String dataImage = Base64.getEncoder().encodeToString(byteImage);
            data = URLEncoder.encode(IMAGE, UTF_8) + EQUALS
                    + URLEncoder.encode(dataImage, UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public String uploadImage() {
        HttpURLConnection connection = getRequest();
        StringBuilder response = new StringBuilder();
        try {
            connection.connect();
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(getData());
            wr.flush();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line).append("\n");
            }
            wr.close();
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject responseJson = JsonParser.parseString(response.toString()).getAsJsonObject();
        String link = responseJson.get("data").getAsJsonObject().get("link").toString().replace("\"","");
        System.out.println(link);
        return link;
    }
}

package util.net;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*

    aqui venia como enviar mensajes al telegram :

    https://dds861.medium.com/sending-message-to-telegram-group-channel-using-bot-from-android-or-java-apps-3c68ffe04a46

    hay que crear un bot, se puede hacer usando el bot botfather, pide que
    le des un nombre, y un usuario
    yo le puse botmanu22, usuario manu4916bot ( parece que en el nombre
    se puede poner cualquier cosa, pero en el usuario no )

    despues hay que averiguar el chatid de tu telefono, hay un bot
    que se llama chatid, que al entrar, ya te dice tu id

    con eso y las 4 lineas de codigo de abajo se puede enviar lo que se
    quiera a ese bot de telegram, facil, rapido y funciona

    este es el json que devuelve :

    {"ok":true,"result":{"message_id":5,"from":{"id":5064856467,"is_bot":true,"first_name":"botmanu22","username":"manu4916bot"},"chat":{"id":293596589,"first_name":"manu","username":"manuelytt","type":"private"},"date":1641172630,"text":"xxxx23"}}

 */

public class EnvMsgTelegr {

    public static void main(String[] args) {
        String line = "";
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        String apiToken = "5064856467:AAHmTjEOZa63Axidr6ZGGYxtXumkDXG4H6U";
        String chatId = "293596589";
        String text = "xxxx23";
        urlString = String.format(urlString, apiToken, chatId, text);
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while ((line = reader.readLine()) != null) {
                    System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

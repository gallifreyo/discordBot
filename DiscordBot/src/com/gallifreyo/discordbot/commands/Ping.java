package com.gallifreyo.discordbot.commands;

import com.gallifreyo.discordbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Main.prefix + "ping")){
            if(args.length > 1){
                // too many arguments
                EmbedBuilder ping = new EmbedBuilder();
                ping.setColor(0xffff23);
                ping.setTitle("Too many arguments");
                event.getChannel().sendMessage(ping.build()).queue();
            }else{
                EmbedBuilder ping = new EmbedBuilder();
                ping.setColor(0xffff23);
                ping.setAuthor(event.getAuthor().getName(), null, event.getJDA().getSelfUser().getAvatarUrl());
                ping.setTitle("Pong 🏓");
                ping.setDescription("Latency is " + event.getJDA().getGatewayPing() + "ms");
                event.getChannel().sendMessage(ping.build()).queue();
            }

        }
    }


}

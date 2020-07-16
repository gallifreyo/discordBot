package com.gallifreyo.discordbot.commands;

import com.gallifreyo.discordbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equalsIgnoreCase(Main.prefix + "help")){

            EmbedBuilder help = new EmbedBuilder();
            help.setColor(0xffff23);
            help.setAuthor(event.getAuthor().getName(), null, event.getJDA().getSelfUser().getAvatarUrl());
            help.setTitle("HELP ❔");
            help.addField("~Ping","for see your ping",false);
            help.addField("~Clear [number]","clear the chat ",false);
            help.addField("~DefineRole","define role for member",false);

            event.getChannel().sendMessage(help.build()).queue();
        }
    }



}

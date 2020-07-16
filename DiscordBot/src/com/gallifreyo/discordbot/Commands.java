package com.gallifreyo.discordbot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {



    // everytime event GuildMessageReceivedEvent ocurres run code in this method
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        //check for prefix like !p or t@
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if(args[0].equalsIgnoreCase(Main.prefix + "info")){

            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("🎶 Information");
            info.setDescription("Completely useless information");
            info.addField("Creator", "techtoolbox", false);
            info.setColor(0xff0000);
            info.setFooter("Created by gallifreyo", event.getMember().getUser().getAvatarUrl());

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }
    }

}

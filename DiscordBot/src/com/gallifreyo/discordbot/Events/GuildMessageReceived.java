package com.gallifreyo.discordbot.Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equalsIgnoreCase("F")){
            event.getMessage().addReaction("❌").queue();
        }
    }

}

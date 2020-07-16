package com.gallifreyo.discordbot.Events;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){

        if(event.getReactionEmote().getName().equals("❌") && !event.getMember().getUser().equals(event.getJDA().getSelfUser())){
            if(event.getMember().getUser().equals(event.getChannel().retrieveMessageById(event.getMessageId()).complete().getAuthor())){
                //if is the author delete the message
                event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();
            }else{
                //if is not the author
                event.getReaction().removeReaction().queue();
            }
        }

    }
}

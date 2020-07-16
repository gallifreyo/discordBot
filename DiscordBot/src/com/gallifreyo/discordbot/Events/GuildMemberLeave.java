package com.gallifreyo.discordbot.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {

    String[] messages = {
            "[member] left the server.",
    };

    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0xf48342);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

        //ADD ROLE
        event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Member", true)).complete();
    }

}

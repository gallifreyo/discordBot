package com.gallifreyo.discordbot;

import com.gallifreyo.discordbot.Events.GuildMemberJoin;
import com.gallifreyo.discordbot.Events.GuildMemberLeave;
import com.gallifreyo.discordbot.Events.GuildMessageReactionAdd;
import com.gallifreyo.discordbot.Events.GuildMessageReceived;
import com.gallifreyo.discordbot.commands.Clear;
import com.gallifreyo.discordbot.commands.Help;
import com.gallifreyo.discordbot.commands.Ping;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {


    public static JDA jda;
    public static String prefix = "~";

    public static void main(String[] args) throws LoginException {

        String token = "NzIyOTQ5OTUxNDQ5MDcxNjU2.XuqnEQ.yxGZuOupgJf5w9pDuh-DLxW6GBE";

        int botStatus = -1;

        jda = new JDABuilder(AccountType.BOT).setToken(token).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        //for watching
        jda.getPresence().setActivity(Activity.watching("Doctor Who"));
        //for streaming
        //jda.getPresence().setActivity(Activity.streaming("Name"));
        //for playing
        //jda.getPresence().setActivity(Activity.playing("Name"));
        jda.addEventListener(new Commands());
        jda.addEventListener(new Clear());
        jda.addEventListener(new Ping());
        jda.addEventListener(new Help());
        //jda.addEventListener(new DefineRole());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
        jda.addEventListener(new GuildMessageReceived());
        jda.addEventListener(new GuildMessageReactionAdd());






    }
}

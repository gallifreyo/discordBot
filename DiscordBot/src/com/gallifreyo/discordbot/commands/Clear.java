package com.gallifreyo.discordbot.commands;

import com.gallifreyo.discordbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.List;

public class Clear extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Main.prefix+"clear")){
            if(args.length < 2){
                // too many messages
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(0xff3923);
                usage.setTitle("Specify amount to delete");
                usage.setDescription("Usage: " + Main.prefix + "clear [# of messages]");
                event.getChannel().sendMessage(usage.build()).queue();

            }else{
                try{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();

                    //sucess
                    EmbedBuilder sucess = new EmbedBuilder();
                    sucess.setColor(0x22ff2a);
                    sucess.setTitle("Sucessfully deleted " + args[1] + ".");
                    sucess.setDescription("Between 1-100 messages can be deleted at one time");
                    event.getChannel().sendMessage(sucess.build()).queue();

                }catch(IllegalArgumentException e){
                    if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                        //to many messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("✋ too many messages selected");
                        error.setDescription("Between 1-100 messages can be deleted at one time");
                        event.getChannel().sendMessage(error.build()).queue();


                    }else{
                        // Messages too old
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("🔴 Selected messages are older than 2 weeks");
                        error.setDescription("Messages older than 2 weeks cannot be deleted.");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }

            }
        }
    }

}

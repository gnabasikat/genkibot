import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class PingEvent {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().toUpperCase().startsWith(BotUtils.BOT_PREFIX + "PING"))
            BotUtils.sendMessage(event.getChannel(), "pong");
    }
}

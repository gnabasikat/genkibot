import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class PongEvent {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().toUpperCase().startsWith(BotUtils.BOT_PREFIX + "PONG"))
            BotUtils.sendMessage(event.getChannel(), "ping");
    }
}

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;

public class HugEvent {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {

        String message = event.getMessage().getContent();
        IGuild guild = event.getGuild();
        String user = event.getAuthor().getNicknameForGuild(guild);

        if(message.toUpperCase().startsWith(BotUtils.BOT_PREFIX + "HUG")) {
            String target = event.getMessage().getContent().substring(5, message.length());
            BotUtils.sendMessage(event.getChannel(), user + " hugs " + target);
        }
    }
}

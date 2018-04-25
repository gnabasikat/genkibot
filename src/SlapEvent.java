import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;

public class SlapEvent {

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {

        String message = event.getMessage().getContent();
        IGuild guild = event.getGuild();
        String user = event.getAuthor().getDisplayName(guild);

        if(message.toUpperCase().startsWith(BotUtils.BOT_PREFIX + "SLAP")) {
            String target = event.getMessage().getContent().substring(5, message.length());
            BotUtils.sendMessage(event.getChannel(), user + " slaps " + target);
        }
    }
}

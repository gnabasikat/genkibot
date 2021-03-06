import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;

public class HugEvent {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {

        String message = event.getMessage().getContent();

        if (!message.contains("@everyone")) {
            IGuild guild = event.getGuild();
            String user = event.getAuthor().getDisplayName(guild);

            if (message.toUpperCase().startsWith(BotUtils.BOT_PREFIX + "HUG")) {
                String target = event.getMessage().getContent().substring(4, message.length());
                BotUtils.sendMessage(event.getChannel(), user + " hugs " + target);
            }
        }
    }
}

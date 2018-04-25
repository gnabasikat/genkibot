import sx.blah.discord.api.IDiscordClient;

public class Main {

    public static void main(String[] args) {

        IDiscordClient cli = BotUtils.getBuiltDiscordClient("NDM4NTM1MDk3MDM0MDgwMjU4.DcGBTw.VPnxsAO77dk8TAA1-6NWwzvms4k");

        /*
        // Commented out as you don't really want duplicate listeners unless you're intentionally writing your code
        // like that.
        // Register a listener via the IListener interface
        cli.getDispatcher().registerListener(new IListener<MessageReceivedEvent>() {
            public void handle(MessageReceivedEvent event) {
                if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "test"))
                    BotUtils.sendMessage(event.getChannel(), "I am sending a message from an IListener listener");
            }
        });
        */

        // Register a listener via the EventSubscriber annotation which allows for organisation and delegation of events
        cli.getDispatcher().registerListener(new MyEvents());
        cli.getDispatcher().registerListener(new ReeeEvent());
        cli.getDispatcher().registerListener(new SlapEvent());
        cli.getDispatcher().registerListener(new HugEvent());

        // Only login after all events are registered otherwise some may be missed.
        cli.login();

    }
}

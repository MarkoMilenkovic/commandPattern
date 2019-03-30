package command;

public enum CommandsEnum {

    LIGHT(0, LightOnCommand.class, LightOffCommand.class),
    GARAGE(1, GarageUpCommand.class, GarageDownCommand.class);

    private int commandNum;
    private Class<? extends Command> onCommandClass;
    private  Class<? extends Command> offCommandClass;

    CommandsEnum(int commandNum, Class<? extends Command> onCommandClass, Class<? extends Command> offCommandClass) {
        this.commandNum = commandNum;
        this.onCommandClass = onCommandClass;
        this.offCommandClass = offCommandClass;
    }

    public int getCommandNum() {
        return commandNum;
    }

    public Class<? extends Command> getOnCommandClass() {
        return onCommandClass;
    }

    public Class<? extends Command> getOffCommandClass() {
        return offCommandClass;
    }

    public static int commandsSize(){
        return CommandsEnum.values().length;
    }
}

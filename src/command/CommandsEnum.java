package command;

public enum CommandsEnum {

    LIGHT(0),
    GARAGE(1);

    private int commandNum;
//    private command.Command command;

//    command.CommandsEnum(int commandNum, command.Command command) {
//        this.commandNum = commandNum;
//        this.command = command;
//    }


    CommandsEnum(int commandNum) {
        this.commandNum = commandNum;
    }

    public int getCommandNum() {
        return commandNum;
    }

    public static int commandsSize(){
        return CommandsEnum.values().length;
    }
}

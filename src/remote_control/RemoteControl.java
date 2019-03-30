package remote_control;


import command.Command;
import command.CommandsEnum;
import command.NoCommand;

public class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command[] lastCommands;

    public RemoteControl() {
        int numOfCommands = CommandsEnum.commandsSize();
        onCommands = new Command[numOfCommands];
        offCommands = new Command[numOfCommands];
        Command noCommand = new NoCommand();
        lastCommands = new Command[]{noCommand};

        for (int i = 0; i < numOfCommands; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(CommandsEnum commandNum, Command onCommand, Command offCommand) {
        if (onCommand.getClass().equals(offCommand.getClass())) {
            throw new IllegalArgumentException("On and off commands must be different.");
        }
        if (!onCommand.getClass().equals(commandNum.getOnCommandClass()) ||
                !offCommand.getClass().equals(commandNum.getOffCommandClass())) {
            throw new IllegalArgumentException("On and off commands must be complementary.");
        }
        onCommands[commandNum.getCommandNum()] = onCommand;
        offCommands[commandNum.getCommandNum()] = offCommand;
    }

    public void callOnCommands(CommandsEnum... commandNum) {
        lastCommands = new Command[commandNum.length];
        for (CommandsEnum num : commandNum) {
            onCommands[num.getCommandNum()].execute();
            lastCommands[num.getCommandNum()] = onCommands[num.getCommandNum()];
        }
    }

    public void callOffCommands(CommandsEnum... commandNum) {
        lastCommands = new Command[commandNum.length];
        for (CommandsEnum num : commandNum) {
            offCommands[num.getCommandNum()].execute();
            lastCommands[num.getCommandNum()] = offCommands[num.getCommandNum()];
        }
    }

    public void undo() {
        for (Command lastCommand : lastCommands) {
            lastCommand.undo();
        }
    }

    public void printCommands() {
        System.out.println("\nCommands: ");
        for (int i = 0; i < CommandsEnum.commandsSize(); i++) {
            if (!(onCommands[i] instanceof NoCommand)) {
                System.out.println("\tOn command: " + onCommands[i] + ", and off command: " + offCommands[i]);
            }
        }
    }
}

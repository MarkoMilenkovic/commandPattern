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

    public void setCommand(int commandNum, Command onCommand, Command offCommand) {
        onCommands[commandNum] = onCommand;
        offCommands[commandNum] = offCommand;
    }

    public void callOnCommand(int commandNum) {
        onCommands[commandNum].execute();
        lastCommands = new Command[]{onCommands[commandNum]};
    }

    public void callOffCommand(int commandNum) {
        offCommands[commandNum].execute();
        lastCommands = new Command[]{offCommands[commandNum]};
    }

    public void callOnCommands(int... commandNum) {
        lastCommands = new Command[commandNum.length];
        for (int num : commandNum) {
            onCommands[num].execute();
            lastCommands[num] = onCommands[num];
        }
    }

    public void callOffCommands(int... commandNum) {
        lastCommands = new Command[commandNum.length];
        for (int num : commandNum) {
            offCommands[num].execute();
            lastCommands[num] = offCommands[num];
        }
    }

    public void undo() {
        for (int i = 0; i < lastCommands.length; i++) {
            lastCommands[i].undo();
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

import command.*;
import domain.Garage;
import domain.Light;
import remote_control.RemoteControl;

public class CommandPatternExampleMain {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light("Living room");
        Garage garage = new Garage("Garage door");
        remoteControl.setCommand(CommandsEnum.LIGHT.getCommandNum(), new LightOnCommand(light), new LightOffCommand(light));
        remoteControl.setCommand(CommandsEnum.GARAGE.getCommandNum(), new GarageUpCommand(garage), new GarageDownCommand(garage));

        remoteControl.callOnCommand(CommandsEnum.LIGHT.getCommandNum());
        remoteControl.callOffCommand(CommandsEnum.LIGHT.getCommandNum());
        remoteControl.undo();

        remoteControl.callOnCommands(CommandsEnum.LIGHT.getCommandNum(), CommandsEnum.GARAGE.getCommandNum());
        remoteControl.callOffCommands(CommandsEnum.LIGHT.getCommandNum(), CommandsEnum.GARAGE.getCommandNum());

        remoteControl.undo();

//        remoteControl.printCommands();
    }

}

import command.*;
import domain.Garage;
import domain.Light;
import remote_control.RemoteControl;

public class CommandPatternExampleMain {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light("Living room");
        Garage garage = new Garage("Garage door");
        remoteControl.setCommand(CommandsEnum.LIGHT, new LightOnCommand(light), new LightOffCommand(light));
        remoteControl.setCommand(CommandsEnum.GARAGE, new GarageUpCommand(garage), new GarageDownCommand(garage));

        remoteControl.callOnCommands(CommandsEnum.LIGHT);
        remoteControl.callOffCommands(CommandsEnum.LIGHT);
        remoteControl.undo();

        remoteControl.callOnCommands(CommandsEnum.LIGHT, CommandsEnum.GARAGE);
        remoteControl.callOffCommands(CommandsEnum.LIGHT, CommandsEnum.GARAGE);

        remoteControl.undo();

        remoteControl.printCommands();
    }

}

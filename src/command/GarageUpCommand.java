package command;


import domain.Garage;

public class GarageUpCommand implements Command {

    private Garage garage;

    public GarageUpCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.up();
    }

    @Override
    public void undo() {
        garage.down();
    }

    @Override
    public String toString() {
        return "Garage up command";
    }
}

package command;


import domain.Garage;

public class GarageDownCommand implements Command {

    private Garage garage;

    public GarageDownCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.down();
    }

    @Override
    public void undo() {
        garage.up();
    }

    @Override
    public String toString() {
        return "Garage down command";
    }
}

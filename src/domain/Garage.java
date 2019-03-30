package domain;

public class Garage {

    private String descripton;

    public Garage(String descripton) {
        this.descripton = descripton;
    }

    public void up() {
        System.out.println(descripton + " - Garage up!");
    }

    public void down() {
        System.out.println(descripton + " - Garage down!");
    }

}

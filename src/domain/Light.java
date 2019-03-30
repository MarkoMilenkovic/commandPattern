package domain;

public class Light {

    private String descripton;

    public Light(String descripton) {
        this.descripton = descripton;
    }

    public void on(){
        System.out.println(descripton + " - Light on!");
    }

    public void off(){
        System.out.println(descripton + " - Light off!");
    }

}

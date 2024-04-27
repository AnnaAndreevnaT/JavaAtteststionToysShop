
/*
Класс игрушки. Принимает имя, частоту выпадения, количество, и название.
*/
public class Toy {
    private int Idtoy;
    private String Nametoy;
    private int CountToy;
    private double FrequencyToy;
    public String getNametoy(){
        return Nametoy;
    }
    public int getIdtoy() {
        return Idtoy;
    }
    public int getСountToy() {
        return CountToy;
    }
    public double getFrequencyToy() {
        return FrequencyToy;
    }
    public void setNametoy(String Name){
        this.Nametoy=Name;
    }
    public void setIdtoy(int id) {
        this.Idtoy=id;
    }
    public void setCountToy(int count) {
        this.CountToy=count;
    }
    public void setFrequencyToy(double freq) {
        this.FrequencyToy=freq;
    }
    public Toy(int IdToy, String NameToy, double FrequencyToy, int count){
        this.Idtoy=IdToy;
        this.Nametoy=NameToy;
        this.FrequencyToy=FrequencyToy;
        this.CountToy=count;
    }
}
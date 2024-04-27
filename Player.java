
//     Класс описывающий участника лотереи. Здесь принимает 3 параметра:
// 1. ID участника
// 2. Его имя.
// 3. Номер билета участника
// 4. Статус. Он идёт у всех участников и устанавливается случайно. Т.е., каждый участник получает статус True, или False, в зависимости
// от того, участвует ли он в данном раунде в розыгрыше призов. В противном случае, те участники которые не прошли в раунд, проходят дальше.
// И так происходит до того момента, пока не окончатся все игрушки.
// */
public class Player {
    private int Id;
    private String Name;
    private  int Number;
    private  boolean Status;
    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public int getNumber() {
        return Number;
    }
    public boolean getStatus() {
        return Status;
    }
    public void setId(int id) {
        this.Id=id;
    }
    public void setName(String name) {
        this.Name=name;
    }
    public void setNumber(int number) {
        this.Number=number;
    }
    public void setStatus(boolean type) {
        this.Status=type;
    }
    public Player(int id,String name,int number,boolean status){
        this.Id=id;
        this.Name=name;
        this.Number=number;
        this.Status=status;
    }
}

    

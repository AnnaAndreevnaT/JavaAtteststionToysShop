import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/*
Класс функций для игрушек. Можно сказать, что тут будут все методы, касаемые как игрушек, так и участников.
Здесь происходит не только их инициализация, но и всё остальное.
 */
public class ToysFunctions {
    public List<Player> Players;
    public PriorityQueue<Toy> QueneToy;
    public Scanner sc;
    public ToysFunctions(){
        this.Players=new ArrayList<Player>();
        this.QueneToy=new PriorityQueue<Toy>(new ComparatorToys());
        this.sc=new Scanner(System.in);
    }
    //Метод добавления игрушек (автоматически)
    public void addToy(){
        Random rand=new Random();
        String[] a = {"Велосипед","Мяч","Погремушка","Паззл","Лего"};
        double[] freq={10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0};
        int[] cnt={10,3,2,4,5,1,6,11};
        int k=0;
        for(int i=0;i<10;i++){
            k=i+1;
            Toy tg=new Toy(k,a[rand.nextInt(a.length)]+Integer.toString(k),freq[rand.nextInt(freq.length)],cnt[rand.nextInt(cnt.length)]);
            QueneToy.add(tg);
        }
    }
    //Метод вывода очереди призов
    public void PrintQuene(){
        if(QueneToy.size()==0){
            System.out.println("Игрушек для розыгрыша нет!");
        }
        else{
            Iterator<Toy> iter = QueneToy.iterator();
            while(iter.hasNext()) {
                Toy obj = iter.next();
                System.out.println(Integer.toString(obj.getIdtoy())+"  "+obj.getNametoy()+" "+Double.toString(obj.getFrequencyToy())+"  "+Integer.toString(obj.getСountToy()));
            }
        }
    }
    //Метод изменения частоты выпадения игрушки
    public void ChangeFrequency(){
        if(QueneToy.size()==0){
            System.out.println("Игрушек нет!");
        }
        else{
            System.out.println("Введите номер игрушки");
            int k= sc.nextInt();
            System.out.println("Введите частоту выпадения:");
            double fr= sc.nextDouble();
            Iterator<Toy> iter = QueneToy.iterator();
            while(iter.hasNext()) {
                Toy obj = iter.next();
                if (obj.getIdtoy()==k) {
                    obj.setFrequencyToy(fr);
                }
            }
        }

    }
    //Метод добавления игрушек (вручную)
    public void addToyUser(){
        System.out.println("Введите название игрушки");
        String name=sc.nextLine();
        System.out.println("Введите частоту выпадения игрушки");
        double freq=sc.nextDouble();
        System.out.println("Введите количество типа данной игрушки");
        int cnt=sc.nextInt();
        Toy newtoy=new Toy(QueneToy.size()+1,name,freq,cnt);
        QueneToy.add(newtoy);
    }
    //Метод добавления игрока (вручную)
    public void addPlayerUser(){
        System.out.println("Введите имя игрока");
        String name=sc.nextLine();
        System.out.println("Введите номер билета игрока");
        int number=sc.nextInt();
        Player newtoy=new Player(Players.size()+1,name,number,new Random().nextBoolean());
        Players.add(newtoy);
    }
    //Метод добавления участников
    public void addPlayer() {
        Random rand=new Random();
        String[] names = {"Лена","Катя","Настя","Инна","Юля","Марина"};
        int k=0;
        for(int i=0;i<QueneToy.size()*3;i++){
            k=i+1;
            Player pl=new Player(k,names[rand.nextInt(names.length)],rand.nextInt(100,200),rand.nextBoolean());
            Players.add(pl);
        }
    }
    //Метод вывода игроков
    public void PrintPlayer(){
        if(Players.size()==0){
            System.out.println("Нет игроков для розыгрыша!");
        }
        else{
            for(int i=0;i<Players.size();i++){
                System.out.println(Integer.toString(Players.get(i).getId())+"  "+Players.get(i).getName()+" "+Integer.toString(Players.get(i).getNumber())+"  "+Boolean.toString(Players.get(i).getStatus()));
            }
        }
    }

    //Метод "установки статуса игроков".Установка того, что он попадёт в следующий тур. (как при добавлении игроков)
    public void GenChancePlayer(){
        for(int i=0;i<Players.size();i++){
            Players.get(i).setStatus(new Random().nextBoolean());
        }
    }
    //Метод "обнуления" игроков. Вызывается тогда, когда окончатся все игрушки. Т.е., все призы были разыграны
    //соответственно никто не участвует в розыгрыше
    public void ClearPlayersAll(){
        for(int i=0;i<Players.size();i++){
            Players.get(i).setStatus(false);
        }
    }
    //Метод получения количества игроков, учавствующих в розыгрыше
    public int GetCountWinPlayers(){
        int k=0;
        for (int i=0;i<Players.size();i++){
            if(Players.get(i).getStatus()==true){
                k++;
            }
        }
        return k;
    }
    //Метод получения случайного игрока, который учавствует на данный момент в розыгрыше
    public Player GetRandomPlayer(){
        ArrayList<Player> playerWin =new ArrayList<Player>();
        //Получаем всех игроков у которых статус true (учавствуют в розыгрыше)
        for (int i=0;i<Players.size();i++){
            if(Players.get(i).getStatus()==true){
                playerWin.add(Players.get(i));
            }
        }
        //Свободно выбираем любого игрока, которому достанется приз - победителя розыгрыша.
        int change=new Random().nextInt(0,playerWin.size());
        Player winpl=playerWin.get(change);
        playerWin.clear();
        //Удаляем игрока, так как он получил приз
        Players.remove(change);
        return winpl;
    }
    //Метод уменьшения количества игрушек (удаления)
    public Toy DelToy(){
        //Берём игрушку
        Toy ts=QueneToy.poll();
        //Если её количество больше нуля
        if(ts.getСountToy()>0){
            //Уменьшаем количество этого типа игрушек на 1
            ts.setCountToy(ts.getСountToy()-1);
            //Если ещё остались игрушки этого типа, то добавляем их в розыгрыш
            if (ts.getСountToy()!=0){
                QueneToy.add(ts);
            }
        }
        return ts;
    }
    //Метод розыгрыша
    public void PlayGame(){
        //Если игрушки ещё есть
        if(QueneToy.size()!=0){
            //Если игроков не осталось
            if(Players.size()==0){
                System.out.println("Все игроки получили игрушки! Добавьте нового игрока.");
            }
            else {
                //Если у игроков не выставлен статус True
                if(GetCountWinPlayers()==0){
                    GenChancePlayer();
                    System.out.println("Не один игрок не учавствует в розыгрыше. Их статус будет обновлён.");
                }
                else{
                    Toy ts=DelToy();
                    //Toy ts=QueneToy.poll();
                    Player pl=GetRandomPlayer();
                    //Устанавливаем новый статус всем игрокам, чтобы приз мог получить каждый из них
                    GenChancePlayer();
                    //Записываем игрушку и игрока в файл
                    SaveToy(ts,pl);
                    System.out.println(ts);
                    System.out.println(pl);
                }
            }
        }
        else{
            //Обнуляем статус всех участников, если игрушек нет.
            ClearPlayersAll();
            System.out.println("Все игрушки были разыграны!");
        }
    }
    //Метод записи в файл
    public void SaveToy(Toy ts1,Player pl1){

        String toy= ts1.getIdtoy() +"  "+ts1.getNametoy()+" "+ts1.getFrequencyToy()+"--->";
        String player=pl1.getId()+"  "+pl1.getName()+"  "+ pl1.getNumber()+"\n";
        String text=toy+player;
        try {
            Files.write(Paths.get("file.txt"), text.getBytes(), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
    


import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            ToysFunctions func = new ToysFunctions();
            func.addToy();
            func.addPlayer();
            Scanner sc =new Scanner(System.in);
            int chng=0;
            while (true){
                System.out.println("\nВыберите пункт меню (цифрой): \n"+
                        "1.Вывести игроков.\n"+
                        "2.Вывести призы.\n"+
                        "3.Лотерея.\n"+
                        "4.Сменить частоту выпадения игрушки\n"+
                        "5.Добавить игрока\n"+
                        "6.Добавить игрушку\n"+
                        "7.Выход\n"
                        );
                chng=sc.nextInt();
                switch (chng){
                    case 1:
                        func.PrintPlayer();
                        break;
                    case 2:
                        func.PrintQuene();
                        break;
                    case 3:
                        func.PlayGame();
                        break;
                    case 4:
                        func.ChangeFrequency();
                        break;
                    case 5:
                        func.addPlayerUser();
                        break;
                    case 6:
                        func.addToyUser();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Такого пункта нет в меню!");
                        break;
                }
            }
    
        }
    }
    


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("album1","Alan walker");
        album1.addSong("Alone",5.2);
        album1.addSong("Faded",4.5);
        album1.addSong("DarkSide",3.5);

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlayList("Alone",myPlayList);
       album1.addToPlayList("DarkSide",myPlayList);

       play(myPlayList);
    }
    public static void play(LinkedList<Song> playList){
      Scanner sc = new Scanner(System.in);
        ListIterator<Song> itr = playList.listIterator();
        if(!itr.hasNext()){
            System.out.println("playList is Empty");
            return;
        }
        System.out.println("you are now listening "+ itr.next());
        showMenu();
        while(true)
        {
            int option = sc.nextInt();
            switch (option)
            {
                case 0:
                    System.out.println("Thank you for listening");
                    return;
                case 1:
                    showMenu();
                    break;
                case 2:
                    printList(playList);
                    break;
            }
        }
    }
    public static void printList(LinkedList<Song> playList){
        ListIterator<Song> itr = playList.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        return;
    }
    public static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. show the list of all songs in the playList");
        System.out.println("3. play next song");
        System.out.println("4. play previous song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");
    }
}
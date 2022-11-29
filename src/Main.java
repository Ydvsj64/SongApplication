import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("album1","Alan walker");
        album1.addSong("Song1",5.2);
        album1.addSong("Song2",4.5);
        album1.addSong("Song3",3.5);
        album1.addSong("Song4",5.2);
        album1.addSong("Song5",4.5);
        album1.addSong("Song6",3.5);

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlayList("Song1",myPlayList);
        album1.addToPlayList("Song2",myPlayList);
        album1.addToPlayList("Song3",myPlayList);
        album1.addToPlayList("Song4",myPlayList);
        album1.addToPlayList("Song5",myPlayList);

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
        boolean forward = true;
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
                case 3:
                    if(!forward){
                        if(itr.hasNext())
                        itr.next();
                        else
                            System.out.println("no next song");
                    }
                    if(!itr.hasNext()){
                        System.out.println("you have reached the end of the playlist");
                    }
                    else{
                        System.out.println("you are listening to "+itr.next());
                    }
                    forward = true;
                    break;
                case 4:
                    if(forward){
                        if(itr.hasPrevious())
                            itr.previous();
                        else
                            System.out.println("no previous song");
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("you have reached the start of the playlist");
                    }
                    else{
                        System.out.println("you are listening to "+itr.previous());
                    }
                    forward = false;
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
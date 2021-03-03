package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//class updator extends Thread{
//    ArrayList<ThreadSocket> threadList;
//    public updator(ArrayList<ThreadSocket> threadList) {
//        this.threadList = threadList;
//    }
//    public void run(){
//        while (true){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(updator.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            //lay data va kiem tra xem da thay doi chua
//            // bool changed = true;
//            int listL = threadList.size();
//            for (int i=0; i < listL;i++){
//                if (threadList.get(i).disconnected){
//                    threadList.remove(i);
//                    i--;
//                    continue;
//                }
//                // if changed -> gui cho thang thread thu i
//            }
//        }
//    }
//}
public class ServerSystem{
    static ArrayList<ThreadSocket> threads = new ArrayList<>();
    static ServerSocket ss;
    public static void main(String[] args) {
        
    
    {
        
         try {
            ss = new ServerSocket(9999);// Tao cong 9999 de server lang nghe
             System.out.println("connenting...");
            while (true)// Cho client ket noi
            {              
                // Su dung multithread
                // Khi co 1 client gui yeu cau toi thi se tao ra 1 thread phuc vu client do
                ThreadSocket tmp = new ThreadSocket(ss.accept());
                threads.add(tmp);
                tmp.start();
//                new ThreadSocket(ss.accept()).start();
                System.out.println("success");
                
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
//    public static void closeServer(){
//        try {
//            ss.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ServerSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}  }
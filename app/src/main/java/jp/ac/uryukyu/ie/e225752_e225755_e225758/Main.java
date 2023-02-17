package jp.ac.uryukyu.ie.e225752_e225755_e225758;
import jp.ac.uryukyu.ie.e225752_e225755_e225758.Cardlist;
import jp.ac.uryukyu.ie.e225752_e225755_e225758.Player;

import java.util.Scanner;

public class Main  {
    public static void main(String[] args){
        Cardlist clist = new Cardlist();
        Player P1 = new Player("P1", clist);
        Player P2 = new Player("P2", clist);
        Dealer Dl = new Dealer("D1", clist);
        Scanner scanner = new Scanner(System.in);
        while(true){
            
            if(P1.totalValue() <= 21 || P2.totalValue() <= 21){
                System.out.println("1.引く。⒉．引かない");
                System.out.print(P1.name+"はカードを引きますか？ =>");
                int selec_number_PL1 = scanner.nextInt();
                System.out.println();
                System.out.print(P2.name+"はカードを引きますか？ =>");
                int selec_number_PL2 = scanner.nextInt();
                if(selec_number_PL1 == 1){
                    P1.draw();
                }
                if(selec_number_PL2 == 1){
                    P2.draw();
                }
                if(selec_number_PL1 == 2 && selec_number_PL2 == 2){
                    System.out.println("ディーラーのターン");
                    Dl.dealerAutoDraw();
                
                    
                    int hikaku_P1 = P1.totalValue() - Dl.totalValue();
                    int hikaku_P2 = P2.totalValue() - Dl.totalValue();
                    if(hikaku_P1 > 0 && hikaku_P2 > 0){
                        System.out.println(P1.name+"と"+P2.name+"の勝ち");
                       break;
                    }
                    if(hikaku_P1 > 0 && hikaku_P2 < 0){
                        System.out.println(P1.name+"の勝ち");
                        break;
                    }
                    if(hikaku_P2 > 0 && hikaku_P1 < 0){
                        System.out.println(P2.name+"の勝ち");
                        break;
                    }   
                    if(hikaku_P1 == 0 && hikaku_P2 == 0){
                        System.out.println("同点");
                        break;
                    }
                    if(hikaku_P1 < 0 && hikaku_P2 < 0){                            
                        System.out.println("ディーラーの勝ち");
                        break;
                    }
                      
                }
                
            }
            
            
        }
    }
}
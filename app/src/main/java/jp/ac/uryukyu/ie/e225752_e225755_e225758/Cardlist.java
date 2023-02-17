package jp.ac.uryukyu.ie.e225752_e225755_e225758;
import java.util.ArrayList;

public class Cardlist {
    ArrayList<String> card_list = new ArrayList<String>();//型を指定
    String[] Card_Pattern = {"J", "K", "Q"};

    public Cardlist(){
        Make_Cardlist();
    }
    
    public void Make_Cardlist(){
        for(int i = 1; i <= 11; i++){
            if(i == 1){
                card_list.add("♤ A");
                card_list.add("♡ A");
                card_list.add("♢ A");
                card_list.add("♧ A");
            }
            if(i == 11){
                for(String a: Card_Pattern){
                    card_list.add("♤ "+ a);
                    card_list.add("♡ "+ a);
                    card_list.add("♢ "+ a);
                    card_list.add("♧ "+ a);
                }
                
            }
            if (i>1 && i<11){
                card_list.add("♤ "+i);
                card_list.add("♡ "+i);
                card_list.add("♢ "+i);
                card_list.add("♧ "+i);
            }
        }
        card_list.add("Black Joker");
        card_list.add("Color Joker");
    }
    
    public static void Card_remove(String Card_name){
        card_list.remove(Card_name);
    }
    
    public static void Card_add(String Card_name){
        card_list.add(Card_name);
    }

    //getterメソッドを追加する。
    public static ArrayList<String> getCardList(){
        return card_list;
    }


    
}
package jp.ac.uryukyu.ie.e225752_e225755_e225758;
import java.util.Random;
import java.lang.constant.DirectMethodHandleDesc;
import java.util.ArrayList; //スペルミスを修正
import org.apache.commons.lang3.StringUtils;
import jp.ac.uryukyu.ie.e225752_e225755_e225758.Cardlist;


public class Human {


    //フィールド記述。
    String name;
    ArrayList<String> hand = new ArrayList<>();//スペルミスを修正
    int score = 0;
    Cardlist clist; //追加（山札用）
    
    public Human(String _name, Cardlist _cardlist){ //コンストラクタ追加
        this.name = _name;
        this.clist = _cardlist;
    }

    

    //メソッドを記述。
    //ランダムを用いてカードリストから選び、手札に追加するメソッド。
    public String draw(){
        Random rd = new Random(); //()を追加
        int randint = rd.nextInt(clist.card_list.size());
        //System.out.println(randint);
        //Cardlist card_list = clist.card_list.getCardList(); //クラスメソッドを直接使うのではなく、オブジェクトのメソッドを使う
        String drawed_card = clist.card_list.get(randint); //配列インデックス指定ではなく、getメソッドを使う
        hand.add(drawed_card);
        clist.card_list.remove(drawed_card); //オブジェクトのメソッドを使う
        System.out.println("draw(): " + hand);

        return drawed_card;
    }

    
    
    //ドローした後の合計得点を示すメソッド。
    public int totalValue(){
        int totalvalue = 0;
        int joker =0;

        for(int i = 0; i < hand.size(); i++){
            String card = hand.get(i);
            char last = card.charAt(card.length() - 1);
            String cardvalue = String.valueOf(last);

            //取り出した値が数字の場合
            if(Character.isDigit(last)){
                totalvalue += Integer.parseInt(cardvalue);
                if(Integer.parseInt(cardvalue) == 0){
                    totalvalue += 10;
                }                           
            }           
            //取り出した値がJ,Q,Kの場合
            if(cardvalue.equals("J") || cardvalue.equals("Q") || cardvalue.equals("K")){
                totalvalue += 10;
            }
            //取り出した値がAの場合
            if(cardvalue.equals("A")){
                if(totalvalue <= 10){
                    totalvalue += 11;
                }else{
                    totalvalue += 1;
                }
            }
            //取り出した値がJokerの場合
            if(cardvalue.equals("r")){
                joker += 1;
            }
        }
        for(int i = 0; i < joker; i++){
            if(totalvalue <= 10){
                totalvalue += 11;
            }else if(totalvalue == 11){
                totalvalue += 10;
            }else{
                totalvalue += 21 - totalvalue;
            }  
        } 
        if(totalvalue > 21){
            totalvalue = 0; 
        }     
        return totalvalue;
    }

    //試運転
    
    public static void main(String[] args) {
        Cardlist clist = new Cardlist();
        Human demo = new Human("demo", clist);
        demo.draw();
        demo.draw();
        demo.totalValue();  
    }    
}
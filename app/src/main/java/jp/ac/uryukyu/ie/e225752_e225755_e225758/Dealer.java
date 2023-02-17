package jp.ac.uryukyu.ie.e225752_e225755_e225758;
//パッケージ名を修正

public class Dealer extends Human{ //クラス名を修正

    public Dealer(String _name, Cardlist _cardlist){ //コンストラクタ名を修正
        super(_name, _cardlist);
    }

    public void dealerAutoDraw(){
        while(totalValue() < 17){
            String drawedcard = draw();
            if(totalValue() == 0){
                break;
            }
            System.out.println("ディーラーは" + drawedcard + "を引いた。" + "得点は" + totalValue());
        }
        
        
        /*if(totalValue() < 17){
            String drawedcard = draw();
            System.out.println("ディーラーは" + drawedcard + "を引いた。" + "得点は" + totalValue());
        }*/
    }

    //試運転
    public static void main(String[] args){
        Cardlist clist = new Cardlist();
        Dealer demo = new Dealer("demo", clist);
        demo.dealerAutoDraw();
    }
}
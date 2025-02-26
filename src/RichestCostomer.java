public class RichestCostomer {
    public int MaximumWealth(int[][] accounts){
        int p1 = 0;
        int p2 = 0;
        for (int i = 0 ; i< accounts.length;i++){
            for (int j=0 ; j<accounts[i].length;j++) {
                if (i==0){
                    p1 = p1 + accounts[0][j];
                }
                else{
                p2 = p2 + accounts[1][j];
            }
            }
        }
        if (p1>p2){
            return  p1;
        }
        if (p1 == p2){
            return -p1;
        }
        return p2;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {3,5,9},
                {4,6,7}
        };
        RichestCostomer obj = new RichestCostomer();
        int result = obj.MaximumWealth(arr);
        if (result<0){
            System.out.println("Both person have same wealth : " + result*-1);
        }
        else {
            System.out.println("Max wealth : " + result);
        }
    }
}

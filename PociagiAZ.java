public class PociagiAZ{
    static int graph[][] = new int[][] {
            {  0,300,402,356,  0,  0,  0,  0,  0},
            {300,  0,  0,  0,440,474,  0,  0,  0},
            {402,  0,  0,  0,  0,330,  0,  0,  0},
            {356,  0,  0,  0,  0,  0,823,  0,  0},
            {  0,440,  0,  0,  0,  0,  0,430,  0},
            {  0,474,330,  0,  0,  0,813,365,774},
            {  0,  0,  0,823,  0,813,  0,  0,403},
            {  0,  0,  0,  0,430,365,  0,  0,768},
            {  0,  0,  0,  0,  0,774,403,768,  0}};

    static int dix[][] = {
            {1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1}};

    static int vert[] = {1,1,1,1,1,1,1,1,1};

    static boolean vertempty(){
        int sum = 0;
        for(int i = 0; i<vert.length; i++)
            sum+=vert[i];
        if(sum==0)
            return false;
        else
            return true;
    }

    static int shortest(){
        int tempVal = 10000000;
        int tempInd = -1;
        for(int i=0;  i<dix[0].length; i++){
            if (vert[i]>0&&dix[0][i]<tempVal){
                tempVal=dix[0][i];
                tempInd=i;
            }
        }
        return tempInd;
    }


    public static void main(String[] args) {
        int start = 0;
        int koniec = 8;

        dix[0][start]=0;
        dix[1][start]=0;

        while (vertempty()){
            int currnetVer = shortest();
            vert[currnetVer]=0;

            for(int i = 0; i<graph.length; i++){
                if(graph[currnetVer][i]>0&&vert[i]>0){
                    if(dix[0][i]>dix[0][currnetVer]+graph[i][currnetVer]){
                        dix[0][i]=dix[0][currnetVer]+graph[i][currnetVer];
                        dix[1][i]=currnetVer;
                    }
                }
            }
        }

        for (int i = 0; i< dix[0].length; i++){
            System.out.print(dix[0][i]+"\t");
        }
        System.out.println();
        for (int i = 0; i< dix[0].length; i++){
            System.out.print(dix[1][i]+"\t");
        }
        System.out.println();
        int odleglosc = 0;
        while (koniec!=start){
            System.out.print(koniec+" ");
            odleglosc+=graph[koniec][dix[1][koniec]];
            koniec=dix[1][koniec];
        }
        System.out.println(odleglosc);
    }
}
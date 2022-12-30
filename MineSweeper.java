import java.util.Scanner;

public class MineSweeper {
 private int cols;
    private int rows;
    private int mines;
    Scanner in=new Scanner(System.in);

    public void startGame(){
    System.out.println("-------------!!Welcome My Minesweeper Game!!----------------");
        System.out.println("===========================");
    System.out.print("Please enter the number of rows:");
    rows=in.nextInt();
    System.out.print("Please enter the number of columns:");
    cols=in.nextInt();
     int elementsNumbers = rows * cols;
    mines= elementsNumbers /4;
     String[][] local = defaultLocal();
     String[][] mineLocal = mineLocal();
    mineLocation(mineLocal);
     int inCol;
     int inRow;
     do{
         for(String []rows: local)
         {
             for(String col:rows)
             {
                 System.out.print(col);
             }
             System.out.println();
         }

     do {
         System.out.print("Please enter a row:");
         inRow =in.nextInt();
     }while(inRow <0|| inRow >=rows);
      do {
          System.out.print("Please enter a col:");
          inCol =in.nextInt();
      } while(inCol <0|| inCol >=cols);
         System.out.println("===========================");
      if(mineLocal[inRow][inCol].equals("*")||mineLocal[inRow][inCol].equals("* "))
      {
          System.out.println("You Lose!");
          break;
      }
      else {
          int counter=0;
          for(int i=0;i<rows;i++)
          {
              for(int j=0;j<cols;j++)
              {
                  if((i-inRow >-2&&i- inRow <2)&&(j- inCol >-2&&j- inCol <2)&&(mineLocal[i][j].equals("*")||mineLocal[i][j].equals("* ")))
                  {

                          counter++;
                  }

              }
          }
          if(inCol==cols-1)
           local[inRow][inCol]=Integer.toString(counter);
          else
              local[inRow][inCol]=counter+" ";
      }

  }while(mineLocal[inRow][inCol].equals("-")||mineLocal[inRow][inCol].equals("- "));

}

private String[][] mineLocal(){
     String [][]mine=new String[rows][cols];
       for(int i=0;i<rows;i++)
       {
          for(int j=0;j<cols;j++)
          {
              if(j==cols-1)
              {
                  mine[i][j]="-";
                  continue;
              }
              mine[i][j]="- ";
          }
       }


       while(mines>0)
       {
           int row= (int) (Math.random()*rows);
           int col=(int)(Math.random()*cols);
            if(mine[row][col].equals("-")||mine[row][col].equals("- "))
           {
               if(col==cols-1)
               { mine[row][col]="*";}
               else
               { mine[row][col]="* ";}
                    mines--;
           }
       }




return mine;
}
private String[][] defaultLocal(){
String [][]a=new String[rows][cols];
    for(int i=0;i<rows;i++)
    {
        for(int j=0;j<cols;j++)
        {
            if(j==cols-1)
            {
                a[i][j]="-";
                continue;
            }
           a[i][j]="- ";
        }
    }

return a;
 }

private void mineLocation(String [][]mine){
    System.out.println("Mayinlarin Konumu");
    for(String[]rows:mine)
    {
        for(String c:rows)
        {
            System.out.print(c);
        }
        System.out.println();
    }
    System.out.println("===========================");
}


}

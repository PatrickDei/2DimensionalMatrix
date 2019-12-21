package main;

import java.util.Scanner;

public class Glavna {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
		        double x1,y1,k1,x2,y2,k2,x3,y3,k3,fx,fy;
		        Scanner sc = new Scanner(System.in);
		        
		        //postavi problem
		        System.out.println("Unesite  F(x,y)=/?/x + /?/y");
		        fx=sc.nextInt();
		        sc.nextLine();
		        fx=-fx;
		        fy=sc.nextInt();
		        sc.nextLine();
		        fy=-fy;
		        
		        
		        //prvi red(uvjet)
		        System.out.println("Uvjet 1:");
		        System.out.println("Unesite /?/x + /?/y <= /?/");
		        x1=sc.nextInt();
		        sc.nextLine();
		        y1=sc.nextInt();
		        sc.nextLine();
		        k1=sc.nextInt();
		        sc.nextLine();
		        
		        //drugi red(uvjet)
		        System.out.println("Uvjet 2:");
		        System.out.println("Unesite /?/x + /?/y <= /?/");
		        x2=sc.nextInt();
		        sc.nextLine();
		        y2=sc.nextInt();
		        sc.nextLine();
		        k2=sc.nextInt();
		        sc.nextLine();
		        
		        //treci red(uvjet)
		        System.out.println("Uvjet 3:");
		        System.out.println("Unesite /?/x + /?/y <= /?/");
		        x3=sc.nextInt();
		        sc.nextLine();
		        y3=sc.nextInt();
		        sc.nextLine();
		        k3=sc.nextInt();
		        sc.nextLine();
		        
		        //unos u tablicu
		        double [][] tab= new double[4][7];
		        tab[0][0]=x1;
		        tab[0][1]=y1;
		        tab[0][2]=1;
		        tab[0][3]=0;
		        tab[0][4]=0;
		        tab[0][5]=0;
		        tab[0][6]=k1;
		        
		        tab[1][0]=x2;
		        tab[1][1]=y2;
		        tab[1][2]=0;
		        tab[1][3]=1;
		        tab[1][4]=0;
		        tab[1][5]=0;
		        tab[1][6]=k2;
		        
		        tab[2][0]=x3;
		        tab[2][1]=y3;
		        tab[2][2]=0;
		        tab[2][3]=0;
		        tab[2][4]=1;
		        tab[2][5]=0;
		        tab[2][6]=k3;
		        
		        tab[3][0]=fx;
		        tab[3][1]=fy;
		        tab[3][2]=0;
		        tab[3][3]=0;
		        tab[3][4]=0;
		        tab[3][5]=1;
		        tab[3][6]=0;
		        
		        double min=0, minp=999999999, m=1, piv;
		        double [] pivot=new double [3];
		        int koo=0, koop=0;
		        while(tab[3][0]<0 || tab[3][1]<0 || tab[3][2]<0 || tab[3][3]<0 || tab[3][4]<0){ //prolazi
		            min=0;
		            minp=99999999;
		            for(int i = 0; i < 7; i++){
		                if(tab[3][i]<min){
		                 min=tab[3][i];
		                 koo=i;
		                }
		            }	
			        pivot[0]=tab[0][6]/tab[0][koo];
			        pivot[1]=tab[1][6]/tab[1][koo];
			        pivot[2]=tab[2][6]/tab[2][koo];
			        for(int i=0; i<3; i++){ //redak pivota
			            if(pivot[i]<minp){
			                minp=pivot[i];
			                koop=i;
			            }
			        }
			        piv=tab[koop][koo];
			        for(int i=0; i<7; i++){  //pretvori pivot u jedan skup s njegovim redom
			            tab[koop][i]=tab[koop][i]/piv;
			        }
			        for(int i=0; i<4; i++){ //ides pi redovim
			            if(i!=koop){
			                m=-tab[i][koo];
			                for(int j=0; j<7; j++){   //Redak pivota mnozimo da bi mogli zbrojit
			                    tab[koop][j]=tab[koop][j]*m;
			                }
			                for(int k=0; k<7; k++){ 
			                    tab[i][k]=tab[i][k]+tab[koop][k];
			                }
			                for(int q=0; q<7; q++){
			                    tab[koop][q]=tab[koop][q]/m;
			                }
			            }
			        }  
		        }
		        System.out.println("\nRješenje X i Y");
		        for(int i=0; i<2; i++){
		        	if(tab[0][i]==1){
		        		if(i==0)
		                    System.out.println("X="+tab[0][6]);
		        		else
		                    System.out.println("Y="+tab[0][6]);
		           }
		           if(tab[1][i]==1){
		               	if(i==0)
		                    System.out.println("X="+tab[1][6]);
		               	else
		                    System.out.println("Y="+tab[1][6]);
		           }
		           if(tab[2][i]==1){
		               	if(i==0)
		                    System.out.println("X="+tab[2][6]);
		               	else
		                    System.out.println("Y="+tab[2][6]);
		           }
		        }
	}
}

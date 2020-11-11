import java.text.*;
import java.util.*;

public class Calendar {

 static boolean isLeap(int year){
	 if((year%4) == 0)
          {
           
             if(year%100 == 0 )
                     {
                      	if(year%400 == 0) return true;                     
      	                else return false ;  	
                     }

              return true ;
         }

     return false;
}

public static void main(String[] args) {
	
	Date date = new Date();
	SimpleDateFormat curr_month = new SimpleDateFormat("M");
	SimpleDateFormat current_year = new SimpleDateFormat("yyyy");

	String week[] = { "Sun" , "Mon" , "Tues" , "Wed" , "Thurs" , "Fri" , "Sat" } ;

	int count_year , count_day = 0 , entered_month = 0 , entered_year  , start_week_day ; 

    /*checking if any extra argument is given in the command line or not , 
    if given then that will be stored in the entered_month otherwise 
	current month will be taken */

	try
	{
		entered_month = Integer.parseInt(args[0]);
	}

	catch(Exception e)
	{
		entered_month = Integer.parseInt(curr_month.format(date)) ;
	}
   
/* checking for the second argument if passed then it will be 
taken as year else default current year will be considered */
   try
	{
		entered_year = Integer.parseInt(args[1]);
	}

	catch(Exception e)
	{
		entered_year = Integer.parseInt(current_year.format(date)) ;
	}


	System.out.print("\n\n\t\t.......... Calendar of "+entered_month+" "+entered_year+"..........\n\n\n\t");

//printing all the days of the weak with a tab space so that they are displayed with a gap
	for (int i = 0 ; i<7 ; i++ ) {

		System.out.print(week[i]+"\t");
	}

	System.out.println("\n\t") ;
	//System.out.println("n") ;

	 int week_no = 1 , count_leap_year = 0 ;

     int endOFmonth[] = { 31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31 } ;
     
   
     if(isLeap(entered_year)) {
     	endOFmonth[1] = 29 ; 
     } 
  
    else{ 
    	 endOFmonth[1] = 28 ;
       }

   /* it will count all the days till then given month 8 */
       if(entered_year < 2011 )
       {
       	count_year = 2011 - entered_year - 1 ;
       	for(int j = 12 ; j>= entered_month ; j--)
       	      {
                  count_day += endOFmonth[j-1];
                //  System.out.println(count_day);
       	      }

       	for(int j = 2010 ; j>entered_year ; j--)
       	{
             if(isLeap(j)) 
             	{  
             		//System.out.println("bsj\n"+j);
             		count_leap_year++;
             	}
          //  System.out.println(count_leap_year);
       	} 

       	   count_day += (count_year*365) + count_leap_year ;
       	   start_week_day = (7 - (count_day%7));
       }

       else{
       	count_year = entered_year - 2011 ;

       	for (int j=1;j<entered_month ;j++ ) {

       		 count_day+=endOFmonth[j-1];
       	}
       	for (int j=2011;j<entered_year ;j++ ) {

       		if(isLeap(j)) count_leap_year++;
          	}

        count_day += (count_year*365) + count_leap_year ;
       	start_week_day = (count_day%7);
       	if(start_week_day==0) start_week_day=7;
       }

       for (int k = 1 ; k<start_week_day ;k++ ) System.out.print("\t");
       week_no = start_week_day ;
       
       for (int i = 1; i<=endOFmonth[entered_month-1] ;i++ ) {
       	  if((week_no%7)==0)
       	  {
       	  	week_no = 0 ;
       	  	System.out.println("\t"+i);

       	  }
       	  else{

       	  	System.out.print("\t"+i);
       	  	week_no++;
       	  }
       }      

}

}
import java.util.*;
public class MainClass {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		MediaSystem library=new MediaSystem();
		library.database();
		while(true)
		{
			System.out.println("\n1. View List of all Songs.");
			System.out.println("2. View List of all movies.");
			System.out.println("3. View List of top Songs.");
			System.out.println("4. View List of top movies.");
			System.out.println("5. Search and display songs based on genre.");
			System.out.println("6. Search and display movies based on director.");
			System.out.println("7. Edit the rating of a song.");
			System.out.println("8. Edit the rating of a movie.");
			System.out.println("9. Display the count of number of songs.");
			System.out.println("10. Display the count of number of movies.");
			System.out.println("11. Search and display all the songs of a given movie.");
			System.out.println("12. Serialize Media");
			System.out.println("13. deserialize Media");
			System.out.println("14. Encrpt Media");
			System.out.println("15. Dcrpt Media");		
			System.out.println("16. Close");
			System.out.print("Enter your choice : ");
			int ch=s.nextInt();
			if(ch==1) library.display(0); 
			else if(ch==2) library.display(1);
			else if(ch==3) library.top_media(s,0);
			else if(ch==4) library.top_media(s,1);
			else if(ch==5) library.search_song(s);
			else if(ch==6) library.search_movie(s);
			else if(ch==7) library.edit_ratingsong(s);
			else if(ch==8) library.edit_ratingmovie(s);
			else if(ch==9) library.count(0);
			else if(ch==10) library.count(1);
			else if(ch==11) library.search_song_bymovie(s);
			else if(ch==12) library.ser();
			else if(ch==13) library.deser();
			else if(ch==14) library.encrpt();
			else if(ch==15) library.decrpt();
			else {library.close();break;}
		}
		s.close();
	}
}

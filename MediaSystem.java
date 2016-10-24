import java.io.*;
import java.util.*;
import java.util.*;
public class MediaSystem {
	ArrayList<Media> movie =new ArrayList<Media>();
	ArrayList<Media> song =new ArrayList<Media>();
	void create_database(String data,int flag)
	{
		String str[]=data.split(",");
		String mov=new String();
		int i=0;
		String name=str[i++];
		if(flag==1){ mov=str[i++];}
		String artist=str[i++];
		int year=Integer.parseInt(str[i++]);
		String genre=str[i++];
		double size=Double.parseDouble(str[i++]);
		int rating=Integer.parseInt(str[i++]);
		String duration=str[i++];
		if(flag==0)
		{	
			String director=str[i++];
			String producer=str[i++];
			String certi=str[i++];
			Media u=new Movies(name,artist,duration,year,rating,size,genre,director,producer,certi);
			movie.add(u);
		}
		else
		{
			Media u=new Songs(name,artist,duration,year,rating,size,genre,mov);
			song.add(u);
		}
	}
	void database()
	{
		try{
			FileReader mov=new FileReader("movie.txt");
			FileReader son=new FileReader("song.txt");
			BufferedReader brm=new BufferedReader(mov);
			BufferedReader brs=new BufferedReader(son);
			int count=0;String str1=brm.readLine();
			while(str1!=null)
			{
				if(count>0) create_database(str1,0);
				str1=brm.readLine();
				++count;
			}
			count=0;String str2=brs.readLine();
			while(str2!=null)
			{
				if(count>0)	create_database(str2,1);
				str2=brs.readLine();
				++count;
			}
			brs.close();brm.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
	void ser()
	{
		try{
			int i=0;File fm = new File("movie.dat");
			File fs=new File("song.dat");
			if(!fm.exists()) fm.createNewFile();
			if(!fs.exists()) fs.createNewFile();
			FileOutputStream filem=new FileOutputStream("moive.dat");
			ObjectOutputStream outm=new ObjectOutputStream(filem);
			while(i<movie.size()) {outm.writeObject(movie.get(i));++i;}

			i=0;FileOutputStream files=new FileOutputStream("song.dat");
			ObjectOutputStream outs=new ObjectOutputStream(files);
			while(i<song.size()) {outs.writeObject(song.get(i));++i;}
			
			outm.close();filem.close();
			outs.close();files.close();
		}
		catch(IOException e){e.printStackTrace();}
	}
	void deser()
	{
		boolean check=true;
		while(check){
			try{
				File fm = new File("movie.dat");
				File fs = new File("song.dat");
				if(!fm.exists()) fm.createNewFile();
				if(!fs.exists()) fs.createNewFile();
				FileInputStream filem=new FileInputStream("moive.dat");
				ObjectInputStream inm=new ObjectInputStream(filem);
				Media str=(Media)inm.readObject();
				while(str!=null) {	str=(Media)inm.readObject();}
				inm.close();	filem.close();
			}
			catch(IOException e) {check=false;}
			catch(Exception e) {e.printStackTrace();}
		}
		check=true;
		while(check){
			try{
				File fs = new File("song.dat");
				if(!fs.exists()) fs.createNewFile();
				FileInputStream files=new FileInputStream("song.dat");
				ObjectInputStream ins=new ObjectInputStream(files);
				Media st=(Media)ins.readObject();
				while(st!=null) {	;st=(Media)ins.readObject();}
				ins.close();	files.close();
			}
			catch(IOException e) {check=false;}
			catch(Exception e) {e.printStackTrace();}
		}	
	}
	void top_media(Scanner s,int flag)
	{
		System.out.print("Enter the Number which you want : ");
		int i=0,ch=s.nextInt();
		ArrayList<Media> m=movie;
		ArrayList<Media> st=song;
		Collections.sort(m);
		Collections.sort(st);
		if(flag==1)
		{	System.out.println("Top " + ch + " Movies");
			while(i<ch){ System.out.println("Title : " + m.get(i).get_title() + "\n" + "Rating : " + m.get(i).get_rating() + "\n");++i;}
		}
		else
		{	System.out.println("Top " + ch + " Songs");i=0;
			while(i<ch){ System.out.println("Title : " + st.get(i).get_title() + "\n" + "Rating : " + st.get(i).get_rating()  + "\n");++i;}
		}
	}
	void count(int flag)
	{
		if(flag==0) System.out.println("Number of songs in the library : " + song.size());
		else System.out.println("Number of movies in the library : " + movie.size());
	}
	void print(int i,int flag)
	{
		if(flag==0)
		{
			System.out.println("\nSong Title : " + song.get(i).get_title());
			System.out.println("Movie : " + song.get(i).get_moviename());
			System.out.println("Artist : " + song.get(i).get_artist());
			System.out.println("Year of release : " + song.get(i).get_year());
			System.out.println("Genre : " + song.get(i).get_genre());
			System.out.println("Size : " + song.get(i).get_size());
			System.out.println("Rating : " + song.get(i).get_rating());
			System.out.println("Duration : " + song.get(i).get_duration());
		}
		else
		{
			System.out.println("\nMovie name : " + movie.get(i).get_title());
			System.out.println("Artist : " + movie.get(i).get_artist());
			System.out.println("Year of release : " + movie.get(i).get_year());
			System.out.println("Genre : " + movie.get(i).get_genre());
			System.out.println("Size : " + movie.get(i).get_size());
			System.out.println("Rating : " + movie.get(i).get_rating());
			System.out.println("Duration : " + movie.get(i).get_duration());
			System.out.println("Director : " + movie.get(i).get_director());
			System.out.println("Producer : " + movie.get(i).get_producer());
			System.out.println("Certification : " + movie.get(i).get_certification());
		}
	}
	void display(int flag)
	{
		int i=0;
		if(flag==0)
		{	System.out.println("---Songs--- \n");
			while(i<song.size()) {	print(i,0);++i;}
		}
		else {
			i=0;System.out.println("\n\n---Moviess--- \n");
			while(i<movie.size()) {	print(i,1);++i;}
		}
	}
	void search_song(Scanner s)
	{
		s.nextLine();
		int i=0,flag=0;String gen;System.out.print("Enter the genre : ");
		gen=s.nextLine();
		while(i<song.size()) { if(song.get(i).compare(gen)==1) {flag=1;print(i,0);} ++i;}		
		if(flag==0) System.out.println("Doesnot exist");
	}
	void search_movie(Scanner s)
	{
		s.nextLine();
		int i=0,flag=0;String dir;System.out.print("Enter the director : ");
		dir=s.nextLine();
		while(i<movie.size()) {if(movie.get(i).compare(dir)==1) {flag=1;print(i,1);} ++i;}		
		if(flag==0) System.out.println("Doesnot exist");
	}	
	void edit_ratingsong(Scanner s)
	{
		s.nextLine();
		System.out.print("Enter the song which You want edit : ");
		int i=0,flag=0,x=0;String st=s.nextLine();
		while(i<song.size())
		{
			if(song.get(i).comparing(st))
			{
				x=song.get(i).get_rating();
				System.out.print("Enter your rating : ");int a=s.nextInt();
				song.get(i).set_rating(a);flag=1;;break;
			}
			++i;
		}
		if(flag==0) System.out.println("Song does not exist");
		else System.out.println("Rating of " + song.get(i).get_title() + " updated from " + x + " to " + song.get(i).get_rating());
	}
	void edit_ratingmovie(Scanner s)
	{
		s.nextLine();
		System.out.print("Enter the movie which You want edit : ");
		int i=0,flag=0,x=0;String st=s.nextLine();
		while(i<movie.size())
		{
			if(movie.get(i).comparing(st))
			{
				x=movie.get(i).get_rating();
				System.out.print("Enter your rating : ");int a=s.nextInt();
				movie.get(i).set_rating(a);flag=1;break;
			}
			++i;
		}
		if(flag==0) System.out.println("Movie does not exist");
		else System.out.println("Rating of " + movie.get(i).get_title() + " updated from " + x + " to " + movie.get(i).get_rating());
	}
	void search_song_bymovie(Scanner s)
	{
		s.nextLine();
		System.out.print("Enter the movie name : ");int i=0,flag=0;String st=s.nextLine();
		while(i<song.size())
		{
			if(song.get(i).comp_mov_name(st))
			{	
				flag=1;
				print(i,0);
			}
			++i;
		}
		if(flag==0) System.out.println("Song does not exist.");
	}
	public void encrpt()
	{
		/*List<String> l=new LinkedList<String>();
		Stream st=new Readingstream(new Basestream());*/
		String str;int i=0;
		try{
			File f=new File("sample.txt");
			if(!f.exists()) f.createNewFile();
			FileWriter fil=new Writingdata("sample.txt");
			while(i<movie.size())
			{
				fil.write(movie.get(i).get_title() + ",");
				fil.write(movie.get(i).get_artist() + ",");
				fil.write(movie.get(i).get_year() + ",");
				fil.write(movie.get(i).get_genre() + ",");
				fil.write(movie.get(i).get_size() + ",");
				fil.write(movie.get(i).get_rating() + ",");
				fil.write(movie.get(i).get_duration() + ",");
				fil.write(movie.get(i).get_director() + ",");
				fil.write(movie.get(i).get_producer() + ",");
				fil.write(movie.get(i).get_certification());
				fil.write("\n");
				++i;
			}
			fil.close();
		}
		catch(Exception e){}
	}
	public void decrpt()
	{
		try{
		FileReader fil=new FileReader("sample.txt");
		BufferedReader f=new ReadingData(fil);
		String str=f.readLine();
		System.out.println(str);
		
		}
		catch(Exception e){}
	}
	public void textwrite()
	{
		try{
			int i=0;
			FileWriter filem=new FileWriter("movie.txt");
			FileWriter files=new FileWriter("song.txt");
			BufferedWriter bwm=new BufferedWriter(filem);
			BufferedWriter bws=new BufferedWriter(files);
			while(i<movie.size())
			{
				bwm.write(movie.get(i).get_title() + ",");
				bwm.write(movie.get(i).get_artist() + ",");
				bwm.write(movie.get(i).get_year() + ",");
				bwm.write(movie.get(i).get_genre() + ",");
				bwm.write(movie.get(i).get_size() + ",");
				bwm.write(movie.get(i).get_rating() + ",");
				bwm.write(movie.get(i).get_duration() + ",");
				bwm.write(movie.get(i).get_director() + ",");
				bwm.write(movie.get(i).get_producer() + ",");
				bwm.write(movie.get(i).get_certification());
				bwm.write("\n");
				++i;
			}
			i=0;
			while(i<song.size())
			{
				bws.write(song.get(i).get_title() + ",");
				bws.write(song.get(i).get_moviename() + ",");
				bws.write(song.get(i).get_artist() + ",");
				bws.write(song.get(i).get_year() + ",");
				bws.write(song.get(i).get_genre() + ",");
				bws.write(song.get(i).get_size() + ",");
				bws.write(song.get(i).get_rating() + ",");
				bws.write(song.get(i).get_duration() + ",");
				bws.write("\n");
				++i;
			}
			bwm.close();bws.close();
		}
		catch(Exception e){}
	}
	public void close()
	{
		ser();
		textwrite();
		System.out.println("ALL the data has been updated in databases.");
	}
}

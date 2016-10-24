abstract class Media implements java.io.Serializable,Comparable<Media>
{
	private String title;
	private String artist;
	private int year;
	private double size;
	private int rating;
	private String duration;
	private String genre;
	Media(String t,String a,String d,int y,int r,double s,String g)
	{
		this.title=t;
		this.artist=a;
		this.year=y;
		this.size=s;
		this.rating=r;
		this.duration=d;
		this.genre=g;
	}
	public String get_title() {return this.title;}
	public String get_artist() {return this.artist;}
	public String get_duration() {return this.duration;}
	public String get_genre() {return this.genre;}
	public double get_size() {return this.size;}
	public int get_rating() {return this.rating;}
	public int get_year() {return this.year;}
	public void set_rating(int a){ this.rating=a;}
	public String get_moviename(){ return null;}
	public String get_director(){ return null;}
	public String get_producer(){return null;}
	public String get_certification(){return null;}
	public boolean comp_mov_name(String st) {return false;}
	public int compareTo(Media m)
	{
		return (m.get_rating()-this.rating);
	}
	abstract public int compare(String st);
	abstract public boolean comparing(String st);
}
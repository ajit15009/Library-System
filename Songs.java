class Songs extends Media
{
	private String movie_name;
	Songs(String t,String a,String d,int y,int r,double s,String g,String m)
	{
		super(t,a,d,y,r,s,g);
		this.movie_name=m;
	}
	public String get_moviename() {return this.movie_name;}
	public int compare(String st)
	{
		if(st.equals(get_genre())) return 1;
		else return 0;
	}
	public boolean comparing(String st)
	{
		if(st.equals(get_title())) return true;
		else return false;
	}
	public boolean comp_mov_name(String st)
	{
		if(st.equals(this.movie_name)) return true;
		else return false;
	}
}
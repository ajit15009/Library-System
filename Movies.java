class Movies extends Media 
{
	private String director;
	private String producer;
	private String certification;
	Movies(String t,String a,String d,int y,int r,double s,String g,String dr,String p,String c)
	{
		super(t,a,d,y,r,s,g);
		this.director=dr;
		this.producer=p;
		this.certification=c;
	}
	public String get_director() {return this.director;}
	public String get_producer() {return this.producer;}
	public String get_certification() {return this.certification;}
	public int compare(String st)
	{
		if(st.equals(this.director)) return 1;
		else return 0;
	}
	public boolean comparing(String st)
	{
		if(st.equals(get_title())) return true;
		else return false;
	}
}
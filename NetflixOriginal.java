public class NetflixOriginal
{
	public static final String[] VALID_GENRES =
	{"drama","comedy","horror","action","science fiction","anime","reality","unknown"};

	private String name;
	private double starRating;
	private String genre;

	public NetflixOriginal()
	{
		name = "Unknown";
		starRating = 0.0;
		genre = "unknown";
	}

	public NetflixOriginal(String name, double starRating, String genre)
	{
		if(!setStarRating(starRating) || !setGenre(genre))
		{
			System.out.println("ERROR: Invalid data passed to NetflixOriginal constructor. Exiting...");
			System.exit(0);
		}
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public double getStarRating()
	{
		return starRating;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean setStarRating(double starRating)
	{
		if(starRating >= 0.0 && starRating <= 5.0)
		{
			this.starRating = starRating;
			return true;
		}

		return false;
	}

	public boolean setGenre(String genre)
	{
		for(int i = 0; i < VALID_GENRES.length; i++)
		{
			if(genre.equalsIgnoreCase(VALID_GENRES[i]))
			{
				this.genre = VALID_GENRES[i];
				return true;
			}
		}

		return false;
	}

	public boolean setAll(String name, double starRating, String genre)
	{
		this.name = name;

		boolean ratingIsSet = setStarRating(starRating);
		boolean genreIsSet = setGenre(genre);

		return ratingIsSet && genreIsSet;
	}

	public String toString()
	{
		return String.format("%s,%.1f,%s", name, starRating, genre);
	}

	public boolean equals(NetflixOriginal other)
	{
		return name.equals(other.name)
			&& starRating == other.starRating
			&& genre.equals(other.genre);
	}
}
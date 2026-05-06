import java.util.Scanner;

public class Main
{
    // Method to create ONE NetflixOriginal from user input
    public static NetflixOriginal instantiateFromInput(Scanner input)
    {
        NetflixOriginal show = new NetflixOriginal();

        // name (no validation needed)
        System.out.print("Please enter the name of the show: ");
        String name = input.nextLine();
        show.setName(name);

        // star rating (must be 0–5)
        boolean validRating = false;
        while(!validRating)
        {
            System.out.print("Please enter the star rating: ");
            double rating = input.nextDouble();
            input.nextLine(); // clear buffer

            validRating = show.setStarRating(rating);

            if(!validRating)
            {
                System.out.println("Invalid rating. Must be between 0 and 5.");
            }
        }

        // genre (must be in VALID_GENRES)
        boolean validGenre = false;
        while(!validGenre)
        {
            System.out.print("Please enter the genre: ");
            String genre = input.nextLine();

            validGenre = show.setGenre(genre);

            if(!validGenre)
            {
                System.out.println("Invalid genre. Try again.");
            }
        }

        // print result
        System.out.println(show);

        return show;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // array of size 2
        NetflixOriginal[] shows = new NetflixOriginal[2];

        // fill array using method
        for(int i = 0; i < shows.length; i++)
        {
            shows[i] = instantiateFromInput(input);
        }

        input.close();
    }
}
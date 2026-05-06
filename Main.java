import java.util.Scanner;

public class Main
{
    public static NetflixOriginal instantiateFromInput(Scanner input)
    {
        NetflixOriginal show = new NetflixOriginal();

        System.out.print("Please enter the name of the show: ");
        String name = input.nextLine();
        show.setName(name);

        boolean validRating = false;
        while(!validRating)
        {
            System.out.print("Please enter the star rating: ");

            if(input.hasNextDouble())
            {
                double rating = input.nextDouble();
                input.nextLine();

                validRating = show.setStarRating(rating);

                if(!validRating)
                {
                    System.out.println("Invalid rating. Must be between 0 and 5.");
                }
            }
            else
            {
                System.out.println("Invalid input. Enter a number.");
                input.nextLine();
            }
        }

        boolean validGenre = false;
        while(!validGenre)
        {
            System.out.print("Please enter the genre: ");
            String genre = input.nextLine().trim();

            validGenre = show.setGenre(genre);

            if(!validGenre)
            {
                System.out.println("Invalid genre. Try again.");
            }
        }

        System.out.println(show);
        return show;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        NetflixOriginal[] shows = new NetflixOriginal[2];

        for(int i = 0; i < shows.length; i++)
        {
            shows[i] = instantiateFromInput(input);
        }

        input.close();
    }
}
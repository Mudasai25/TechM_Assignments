package Sample;
import java.util.*;

class Movie {
    private String movieName;
    private String company;
    private String genre;
    private int budget;

    // Constructor
    public Movie(String movieName, String company, String genre, int budget) {
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }

    // Getters and Setters
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return movieName + " " + company + " " + genre + " " + budget;
    }
}

class Solutionn {
    // Static method to filter movies by genre
    public static Movie[] getMovieByGenre(Movie[] movies, String searchGenre) {
        List<Movie> result = new ArrayList<>();
        
        // Filter movies with the given genre (case insensitive)
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(searchGenre)) {
                result.add(movie);
            }
        }
        
        // Convert list to array and return
        return result.toArray(new Movie[0]);
    }
}

public class Assign_Movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading data for 4 Movie objects
        Movie[] movies = new Movie[4];
        
        for (int i = 0; i < 4; i++) {
            String movieName = sc.next();
            String company = sc.next();
            String genre = sc.next();
            int budget = sc.nextInt();
            movies[i] = new Movie(movieName, company, genre, budget);
        }
        
        // Reading the genre to search for
        String searchGenre = sc.next();
        
        // Calling the getMovieByGenre method
        Movie[] result = Solutionn.getMovieByGenre(movies, searchGenre);
        
        // Printing the result based on budget
        for (Movie movie : result) {
            if (movie.getBudget() > 80000000) {
                System.out.println("High Budget Movie");
            } else {
                System.out.println("Low Budget Movie");
            }
        }
    }
}


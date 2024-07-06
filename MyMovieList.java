import java.util.Scanner;
class Movie{
   private  String title;
   private int releaseYear;
    private double rating;


    Movie(String title, int releaseYear, double rating){
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }
    // the getters 
    public String gettitle(){
        return this.title;
    }
    public int getreleaseYear(){
        return this.releaseYear;
    }
    public double getrating(){
        return this.rating;
    }

// Setters
    public void settitle(String title){
        this.title= title;
    }
    public void setreleaseYear(int releaseYear){
        this.releaseYear=  releaseYear;
    }
    public void setrating(double rating){
        this.rating= rating;
    }
    public String toString(){
        String my_String = "Movie{"+"title = "+ this.title + " releaseYear = " +this.releaseYear + " rating =  "+ this.rating + "}";
        return  my_String;
    }
    

}



public class MyMovieList {
    public static void main(String[] args) {
            
         CustomArrayList movieList = new CustomArrayList();
         Scanner input = new Scanner(System.in);
         
         int my_choice;

// a do-while loop to aid in the menu based 
        do {
            System.out.println("Movie List Menu:");
            System.out.println("1. Add a new movie you want ");
            System.out.println("2. Display all movies that have been added ");
            System.out.println("3. Calculate average rating of all movies added ");
            System.out.println("4. Remove a movie by its title");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            my_choice = input.nextInt();

            input.nextLine(); 

            switch (my_choice) {
                case 1:
                    addNewMovie(movieList, input);
                    break;
                case 2:
                   displayAllMovies(movieList);
                    break;
                case 3:
                    double averageRating = averageRating(movieList);
                    System.out.println("Average rating of all movies is : " + averageRating);
                    break;
                case 4:
                    System.out.print("Enter the title of the movie to remove: ");
                    String title = input.nextLine();
                    removeMovieByTitle(title,movieList);
                    break;
                case 5:
                    System.out.println("Exiting the Movie application. Thanks ");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (my_choice != 5);

        input.close();
    }
// method to add a new movie
    public static void addNewMovie(CustomArrayList movieList, Scanner input) {
        
            System.out.print("please enter the movie title: ");
            while(!input.hasNext()){
                System.out.println("This is an invalid input");
                input.next();
            }
            String title = input.nextLine();

            
         //to add a the release year
        System.out.print("please enter the release year: ");

        while(!input.hasNextInt()){
            System.out.println("This is an invalid input");
            input.next();
        }
        int releaseYear = input.nextInt();

        double rating;
        // to ensure that the rating entered by the user is between 0 and 10
        while (true) {
            System.out.print("please enter the rating between 0 and 10: ");
            rating = input.nextDouble();
            if (rating >= 0 && rating <= 10) {
                break;
            } else {
                System.out.println("The entered rating is invalid. Please enter a rating between 0 and 10.");
            }
        }
        movieList.add(new Movie(title, releaseYear, rating));
        System.out.println("Movie has been added !");
    }

    // a method to display all the movie in the list

    public  static void displayAllMovies(CustomArrayList movieList) {
    if (movieList.isEmpty()) {
        System.out.println("No movies in the list.");
    } else {
         System.out.println("All Movies:");
        System.out.println(movieList.display());
    }
 }


   //method to remove the movie by the title(what about a case where they share the same title but rating and release year is different)
    public static void removeMovieByTitle(String title, CustomArrayList movieList){
        for(int i = 0;i<movieList.size();i++){
            Movie my_movie =(Movie)movieList.get(i);
            if(my_movie.gettitle().equals(title)){
                movieList.remove(i);
                i--; // so we can check the one just before
                 
            }
        }
    }
    // method to calculate the average rating 
   public static double averageRating(CustomArrayList movieList){
    if (movieList.isEmpty()){
        return 0.0;
    }
    double addedRating = 0;
     
    for (int i = 0;i<movieList.size();i++){
        Movie movie = (Movie)movieList.get(i);
        addedRating += movie.getrating();
        
    }
    return addedRating /movieList.size()   ;
   }

        
    }
    


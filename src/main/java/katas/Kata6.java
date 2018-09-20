package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().flatMap(m -> m.getBoxarts().stream())
        	.reduce((a,b) -> (a.getHeight()*a.getWidth()) > (b.getHeight()*b.getWidth())?a:b )
        	.map(b -> b.getUrl()).get();
    }
}

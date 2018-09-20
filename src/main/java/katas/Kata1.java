package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.Movie;
import util.DataUtil;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map<String, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();        
        return movies.stream().map(m -> ImmutableMap.of("id", m.getId().toString(), "title", m.getTitle())).collect(Collectors.toList());
        
    }
}

package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
       return movieLists.stream()
        	.flatMap(l -> l.getVideos().stream())
        	.map(v -> ImmutableMap.of("id", v.getId(), "title", v.getTitle(), 
        		"time",        			
                		v.getInterestingMoments().stream()
                			.reduce((a,b) -> (a.getType().equals("Middle") ?a:b))
                			.map(z -> z.getTime())
                			.get()
        		,"url", 
        			v.getBoxarts().stream()
        				.reduce((a,b) -> (a.getUrl().length() < b.getUrl().length()?a:b))
        				.map(t -> t.getUrl())
        				.get()))
        	.collect(Collectors.toList());
        }
}

package com.dac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired	
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		System.out.println("In :- 8080");
		
		
		//WebClient webClient = WebClient.create();
		//RestTemplate restTemplate = new RestTemplate();
		//Movie movie = restTemplate.getForObject("http://localhost:8081/ratingdata/foo/", Movie.class);
		
		
		// get all rated movies Id's
		/*List<Rating> ratings = Arrays.asList(
				new Rating("Ghost in the shell", 4),
				new Rating("Lucy", 5)
		);*/
		
		//UserRating userRating = restTemplate.getForObject("http://localhost:8081/ratingdata/users/"+userId, UserRating.class);
		UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingdata/users/"+userId, UserRating.class);
		
		
		List<CatalogItem> list = new ArrayList<>();
		for (Rating rating : userRating.getUserRating()) {
			
			// for each movie id call info service  get details
			//Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			
			
			//put them together
			list.add(new CatalogItem(movie.getName(),"Most wanted",rating.getRating()));
		}
		
		 return list;
		//return Collections.singletonList(new CatalogItem("IronMan1", "Action movie" ,2));
		
		
	}
	
	/*
	    Movie movie = webClient // --> building buider pattern & giving you a client
					     .get()     // --> using GET method 
						.uri("http://localhost:8082/movies/"+rating.getMovieId()) // --> URL that you need to access
						.retrieve() // --> it will go the fetch
						.bodyToMono(Movie.class) // --> saying whatever body you get back convert it into an instance of this movie class
						.block(); // --> you are blocking execution till that mono is fulfilled.(making synchronous)
			
			// bodyToMono : it is a reactive way of saying you are getting an object back but not right away you're gonna get it sometime
			// in the future so our MONO is king of like promise that this thing is eventually gonna get you what you want that's we do asynchronus.
			
	 * */
	
}






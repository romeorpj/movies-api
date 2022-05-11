package com.codeup.fortran_movies_api.web;

        import com.codeup.fortran_movies_api.data.Movie;
        import com.codeup.fortran_movies_api.data.MoviesRepository;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.server.ResponseStatusException;

        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    // TODO: put the expected path out to the side of the method annotation
    //  -> this helps to keep track so we don't have to guess if methods conflict on the same path
    @GetMapping("all")
    public List<Movie> getAll() {
        return moviesRepository.findAll(); // TODO: findAll() will return a list of objects and is provided by the JpaRepository
    }


    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        return moviesRepository.findById(id).orElse(null);
    }

    @GetMapping("search")
    public List<Movie> getByTitle(@RequestParam("title") String title){
        // TODO: we need to create the findByTitle() method in our MoviesRepository - magic!
        return moviesRepository.findByTitle(title);
    }

    @GetMapping("search/year")
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear){
        // TODO: @RequestParam expects a query parameter in the request URL
        //  to have a param matching what is in the annotation (ie: @RequestParam("startYear"))
        return moviesRepository.findByYearRange(startYear, endYear);
    }

    @PostMapping
    public void create(@RequestBody Movie movie){
        moviesRepository.save(movie);
    }

    @PostMapping ("many")
    public void createMany(@RequestBody List<Movie> movies){
        moviesRepository.saveAll(movies);
    }
@DeleteMapping("{id}")
    public void deleteById(@PathVariable int id, HttpServletResponse response) throws IOException {
        try{
            moviesRepository.deleteById(id);
        } catch(Exception ex){
throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie ID not found", ex);
        }
}
}
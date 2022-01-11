package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionDtoMapper(MovieService movieService,
                                 CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionRequestDto toDto(MovieSession movieSession) {
        MovieSessionRequestDto responseDto = new MovieSessionRequestDto();
        responseDto.setMovieId(movieSession.getId());
        responseDto.setShowTime(movieSession.getShowTime());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setMovieId(movieSession.getMovie().getId());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        movieSession.setCinemaHall(cinemaHallService
                .get(movieSessionRequestDto.getCinemaHallId()));
        return movieSession;
    }
}

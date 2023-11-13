package com.vti.movie;

import com.vti.movie.entity.Movie;
import com.vti.movie.entity.Room;
import com.vti.movie.entity.Seat;
import com.vti.movie.repository.*;
import com.vti.movie.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class MovieApplication {
//    private final UserService userService;
//


    private final IUserRepository userRepository;

    private final ICinemaRepository cinemaRepository;

    private final ISeatRepository seatRepository;

    private final IRoomRepository roomRepository;

    private IMovieRepository movieRepository;

    public MovieApplication(IUserRepository userRepository, ICinemaRepository cinemaRepository
            , IRoomRepository roomRepository, ISeatRepository seatRepository, IMovieRepository movieRepository) {
        this.userRepository = userRepository;

        this.cinemaRepository =cinemaRepository;
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
    }

    public void init() {
        Room room = roomRepository.findById(1).get();
        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("A"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("B"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("C"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("D"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("E"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("F"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("G"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("H"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("I"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        for(int i=1;i<=8;i++){
            Seat seat = new Seat();
            seat.setName("J"+i);
            seat.setRoom(room);
            seatRepository.save(seat);
        }

        List<Movie> movies = movieRepository.findAll();
        if(movies.isEmpty()){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Movie kedochanh = addNewMovie("KẺ ĐỘC HÀNH","1","Bộ phim sẽ được phát sóng dự kiến vào tháng 10/2022 Với 08 tập phim theo dạng web series, cùng sự góp mặt với hơn 30 nghệ sỹ, diễn viên… Với chi phí đầu tư lớn và được phát sóng trên nền tảng VOD. Ai Chết Giơ Tay (new season) với tên gọi Kẻ Độc Hành. Đây là dự án tâm huyết của Lập đã được chuẩn bị hơn 1 năm, đã được bấm máy vào tháng 05/2021 tại Long Xuyên AG (quê nhà của Lập) và sẽ được hậu kỳ hơn 1 năm."
                    ,"Adam Wingard","Kyle Chandler, Rebecca Hall, Eiza González, Millie Bobby Brown","hành động, giả tưởng, ly kỳ, thần thoại"
                    , LocalDate.parse("2022-11-05", formatter),"120 phut","2D/Digital","1","Mỹ",5);
        }
    }

    private Movie addNewMovie(String name, String imgURL, String description
            , String director, String actors, String categories
            , LocalDate release_Date, String duration
            , String format, String trailerURL
            , String nation_producter, int rated) {
    Movie movie = new Movie();
    movie.setName(name);
    movie.setImgURL(imgURL);
    movie.setDescription(description);
    movie.setDirector(director);
    movie.setActors(actors);
    movie.setCategories(categories);
    movie.setReleaseDate(release_Date);
    movie.setDuration(duration);
    movie.setFormat(format);
    movie.setTrailerURL(trailerURL);
    movie.setNationProducter(nation_producter);
    movie.setRated(rated);

        return movie;
    }


    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
//
//
//
//
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(MovieApplication.class, args);
//        UserService userService = context.getBean(UserService.class);
//        CinemaService cinemaService = context.getBean(CinemaService.class);
//        // Call the createUser method
//        userService.createRootUser();
//        cinemaService.createListCinema();
//
//    }

//    @PostConstruct
//    public void addSeatToRoom(){
//        Integer roomId = 1;
//        Seat seat = new Seat();
//        seat.setName("");
//
//        seatService.addSeatToRoom(roomId, seat);
//
//        System.out.println("Seat added to Room sucessfully");
//    }
//
//    @PostConstruct
//    public void addRoomToCinema(){
//        Integer cinemaId = 1;
//        Room room = new Room();
//        room.setName("");
//
//        roomService.addRoomToCinema(cinemaId, room);
//
//        System.out.println("Room added to Cinema successfully");
//    }

}

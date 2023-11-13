package com.vti.movie.service;

import com.vti.movie.dtos.CinemaDTO;
import com.vti.movie.entity.Cinema;
import com.vti.movie.entity.Room;
import com.vti.movie.entity.Seat;
import com.vti.movie.repository.ICinemaRepository;
import com.vti.movie.repository.IRoomRepository;
import com.vti.movie.repository.ISeatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService implements ICinemaService {

    private final ICinemaRepository cinemaRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CinemaService(ICinemaRepository cinemaRepository) {
        this.modelMapper = new ModelMapper();

        this.cinemaRepository = cinemaRepository;

    }

    @Override
    public List<CinemaDTO> getCinemaesThatShowTheMovie(Integer movieId) {
        return cinemaRepository.getCinemaThatShowTheMovie(movieId)
                .stream().map(cinema -> modelMapper.map(cinema, CinemaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getCinemaById(int id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    @Override
    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema updateCinema(int id, Cinema updatedCinema) {
        Cinema existingCinema = cinemaRepository.findById(id).orElse(null);
        if (existingCinema != null) {
            existingCinema.setName(updatedCinema.getName());
            existingCinema.setDiaChi(updatedCinema.getDiaChi());

            existingCinema.setImgURL(updatedCinema.getImgURL());
            return cinemaRepository.save(existingCinema);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCinema(int id) {
        cinemaRepository.deleteById(id);
    }

//    @Autowired
//    private IRoomRepository roomRepository;
//    @Autowired
//    private ISeatRepository seatRepository;
//    public void createListCinema() {
//
//        if (cinemaRepository.findAll().size() == 0) {
//            Cinema cinema1 = new Cinema();
//            cinema1.setId(1);
//            cinema1.setName("BHD Star Cineplex - 3/2");
//            cinema1.setDiaChi("L5-Vincom 3/2, 3C Đường 3/2, Q.10");
//            cinema1.setImgURL("http://movie0706.cybersoft.edu.vn/hinhanh/bhd-star-cineplex.png");
//            cinema1 = cinemaRepository.save(cinema1);
//            System.out.println("a1");
//
//            Room room1 = new Room();
//            room1.setId(1);
//            room1.setName("Rap 1");
//            room1.setTotalAreaNormal(72);
//            room1.setTotalAreaNormal(88);
//            room1.setCapacity(160);
//            room1.setCinema(cinema1);
//            room1 = roomRepository.save(room1);
//            System.out.println("a2");
//
//         String [] alphBet = {"A","B","C","D","E","F","G","H","I","J"};
//         int index = 0;
//            for (int i=0;i<160;i++){
//                if (i % 16 ==0) {
//                    index =0;
//
//                }
//                System.out.println("h"+i);
//                Seat seat1 = new Seat();
//
//                seat1.setName(alphBet[i/16] + index);
//                seat1.setRoom(room1);
//                seat1 = seatRepository.save(seat1);
//                index++;
//            }
//
//
//            Room room2 = new Room();
//            room2.setId(1);
//            room2.setName("Rap 2");
//            room2.setTotalAreaNormal(72);
//            room2.setTotalAreaNormal(88);
//            room2.setCapacity(160);
//            room2.setCinema(cinema1);
//            roomRepository.save(room2);
//
//            index=0;
//            for (int i=0;i<160;i++){
//                if (i % 16 ==0) {
//                    index =0;
//                }
//                Seat seat1 = new Seat();
//
//                seat1.setName(alphBet[i/16] + index);
//                seat1.setRoom(room2);
//                seatRepository.save(seat1);
//                index++;
//            }
//
//
//
//            Cinema cinema2 = new Cinema();
//            cinema2.setId(2);
//            cinema2.setName("BHD Star Cineplex - Bitexco");
//            cinema2.setDiaChi("L3-Bitexco Icon 68, 2 Hải Triều, Q.1");
//            cinema2.setImgURL("http://movie0706.cybersoft.edu.vn/hinhanh/bhd-star-cineplex.png");
//            cinemaRepository.save(cinema2);
//        }
//    }
}

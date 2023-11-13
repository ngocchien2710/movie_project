package com.vti.movie.service;

import com.vti.movie.dtos.RoomDTO;
import com.vti.movie.entity.Cinema;
import com.vti.movie.entity.Room;
import com.vti.movie.entity.Seat;
import com.vti.movie.repository.ICinemaRepository;
import com.vti.movie.repository.IRoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService {

    private final IRoomRepository roomRepository;


    private final ModelMapper modelMapper;

    private final ICinemaRepository cinemaRepository;

    @Autowired
    public RoomService(IRoomRepository roomRepository, ICinemaRepository cinemaRepository){
        this.modelMapper = new ModelMapper();
        this.roomRepository = roomRepository;
        this.cinemaRepository = cinemaRepository;
    }


    @Override
    public List<RoomDTO> getRooms(Integer movieId, Integer cinemaId, String startDate, String startTime) {
        return roomRepository.getRoomByCinemaAndMovieAndSchedule(movieId,cinemaId, LocalDate.parse(startDate), LocalTime.parse(startTime))
                .stream().map(room -> modelMapper.map(room,RoomDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(int id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id).orElse(null);
        if (existingRoom != null) {
            existingRoom.setName(updatedRoom.getName());
            existingRoom.setCapacity(updatedRoom.getCapacity());
            existingRoom.setTotalAreaVip(updatedRoom.getTotalAreaVip());
//            existingRoom.setImgURL(updatedRoom.getImgURL());
            existingRoom.setTotalAreaNormal(updatedRoom.getTotalAreaNormal());
            existingRoom.setCinema(updatedRoom.getCinema());
            return roomRepository.save(existingRoom);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }



//    public void addRoomToCinema(Integer id, Room room) {
//        Cinema cinema = cinemaRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Cinema not found"));
//
//        room.setCinema(cinema);
//        cinema.getRooms().add(room);
//
//        cinemaRepository.save(cinema);
//    }
}

//package com.vti.movie.database;
//
//import com.vti.movie.entity.Cinema;
//import com.vti.movie.entity.ERole;
//import com.vti.movie.entity.User;
//import com.vti.movie.repository.ICinemaRepository;
//import com.vti.movie.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class Database {
//
//    @Autowired
//    PasswordEncoder encoder;
//    @Bean
//    CommandLineRunner initDatabase(IUserRepository userRepository, ICinemaRepository cinemaRepository) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                if(userRepository.findAll().size()==0){
//                    User admin = new User();
//                    admin.setId(1);
//                    admin.setUsername("ngocchien2710");
//                    admin.setEmail("chiendang2710@gmail.com");
////                    admin.setCreatedDate(LocalDateTime.now());
//                    admin.setFullName("Dang Ngoc Chien");
//                    admin.setPhoneNumber("0386355914");
//                    admin.setRole(ERole.ADMIN);
//                    System.out.println("Database:"+encoder.encode("Azd1232421@#"));
//                    admin.setPassword(encoder.encode("Azd1232421@#"));
//
//                    userRepository.save(admin);
//
//
//                }
//                if(cinemaRepository.findAll().size()==0){
//                    Cinema cinema1 = new Cinema();
//                    cinema1.setId(1);
//                    cinema1.setName("BHD Star Cineplex - 3/2");
//                    cinema1.setDiaChi("L5-Vincom 3/2, 3C Đường 3/2, Q.10");
//                    cinema1.setImgURL("http://movie0706.cybersoft.edu.vn/hinhanh/bhd-star-cineplex.png");
//                    cinemaRepository.save(cinema1);
//
//                    Cinema cinema2 = new Cinema();
//                    cinema1.setId(2);
//                    cinema1.setName("BHD Star Cineplex - Bitexco");
//                    cinema1.setDiaChi("L3-Bitexco Icon 68, 2 Hải Triều, Q.1");
//                    cinema1.setImgURL("http://movie0706.cybersoft.edu.vn/hinhanh/bhd-star-cineplex.png");
//                    cinemaRepository.save(cinema2);
//                }
//            }
//        };
//    }
//}

package com.vti.movie.dtos;

import com.vti.movie.entity.ERole;
import com.vti.movie.entity.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO implements UserDetails {
    private int id;
    private String username;
    private ERole role;
    private String fullname;
    private String email;
    private String phoneNumber;

    public SignUpDTO(Integer id, String fullName, String username, String email, ERole role, String phoneNumber) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}



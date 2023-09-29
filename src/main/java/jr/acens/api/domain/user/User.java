package jr.acens.api.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jr.acens.api.domain.user.DTO.UserDTO;
import jr.acens.api.domain.user.DTO.UserForgotDTO;
import jr.acens.api.domain.user.DTO.UserUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String login;
    private String password;

    @Column(name = "token_email")
    private String tokenEmail;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "token_expiration")
    private LocalDateTime tokenExpiration;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private Date birthday;
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve seguir o formato 999.999.999-99")
    private String cpf;
    @Enumerated(EnumType.STRING)
    private UserProfile profile;
    @Column(name = "professional_id")
    private String professionalId;
    private String phone;

    public User (UserDTO data) {
        this.login = data.login();
        this.password = data.password();
        this.name = data.name();
        this.birthday = data.birthday();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.profile = data.profile();
        this.professionalId = data.professionalId();
        this.role = UserRole.USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setPassword(String encodedPassword) {
        this.password = encodedPassword;
    }


    public void forgotPassword(UserForgotDTO data) {
        this.tokenEmail = data.tokenEmail();
        this.tokenExpiration = data.tokenExpiration();
    }

    public void setTokenEmail(String tokenEmail) {
        this.tokenEmail = tokenEmail;
    }

    public void setAdmin() { this.role = UserRole.ADMIN; }

    public void updateUser(UserUpdateDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.birthday() != null) {
            this.birthday = data.birthday();
        }
        if (data.profile() != null) {
            this.profile = data.profile();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
    }
}

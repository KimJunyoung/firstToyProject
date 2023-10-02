package toyproject.buyandlogin.domain.jpa;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String userName;

    private String userId;

    private String userPassword;

    @Embedded
    private Address userAddress;

    public void makeUser(String username, String userId, String userPassword, Address address){
        this.userName = username;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userAddress = address;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Address getUserAddress() {
        return userAddress;
    }

}

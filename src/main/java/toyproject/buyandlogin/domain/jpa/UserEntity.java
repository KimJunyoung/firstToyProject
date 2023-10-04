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

    private String userIdName;

    private String userPassword;

    @Embedded
    private Address userAddress;

    public void makeUser(String username, String userIdName, String userPassword, Address address){
        this.userName = username;
        this.userIdName = userIdName;
        this.userPassword = userPassword;
        this.userAddress = address;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserIdName() {
        return userIdName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Address getUserAddress() {
        return userAddress;
    }

}

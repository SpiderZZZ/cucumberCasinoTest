package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Player {

    private String username;

    private String externalId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String hall;
    private String balance;
    private Date registrationDate;
    private String lastVisit;
    private String lastVisitIp;
    private Boolean verifiedPlayer;
    private Boolean online;
    private String status;

    public Player() {
    }

    public String getUsername() {
        return username;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getHall() {
        return hall;
    }

    public String getBalance() {
        return balance;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public String getLastVisitIp() {
        return lastVisitIp;
    }

    public Boolean getVerifiedPlayer() {
        return verifiedPlayer;
    }

    public Boolean getOnline() {
        return online;
    }

    public String getStatus() {
        return status;
    }

    public Player setUsername(String username) {
        this.username = username;
        return this;
    }

    public Player setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Player setEmail(String email) {
        this.email = email;
        return this;
    }

    public Player setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Player setHall(String hall) {
        this.hall = hall;
        return this;
    }

    public Player setBalance(String balance) {
        this.balance = balance;
        return this;
    }

    public Player setRegistrationDate(String registrationDate) throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.registrationDate = dateFormat.parse(registrationDate);
        return this;
    }

    public Player setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
        return this;
    }

    public Player setLastVisitIp(String lastVisitIp) {
        this.lastVisitIp = lastVisitIp;
        return this;
    }

    public Player setVerifiedPlayer(String verifiedPlayer) {
        if(verifiedPlayer.equals("Yes"))
        {
            this.verifiedPlayer = true;
        }
        if(verifiedPlayer.equals("No"))
        {
            this.verifiedPlayer = false;
        }
        return this;
    }

    public Player setOnline(String online) {
        if(online.equals("Yes"))
        {
            this.online = true;
        }
        if(online.equals("No"))
        {
            this.online = false;
        }
        return this;
    }

    public Player setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(username, player.username) &&
                Objects.equals(externalId, player.externalId) &&
                Objects.equals(name, player.name) &&
                Objects.equals(lastName, player.lastName) &&
                Objects.equals(email, player.email) &&
                Objects.equals(phone, player.phone) &&
                Objects.equals(hall, player.hall) &&
                Objects.equals(balance, player.balance) &&
                Objects.equals(registrationDate, player.registrationDate) &&
                Objects.equals(lastVisit, player.lastVisit) &&
                Objects.equals(lastVisitIp, player.lastVisitIp) &&
                Objects.equals(verifiedPlayer, player.verifiedPlayer) &&
                Objects.equals(online, player.online) &&
                Objects.equals(status, player.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, externalId, name, lastName, email, phone, hall, balance, registrationDate, lastVisit, lastVisitIp, verifiedPlayer, online, status);
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", externalId='" + externalId + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hall='" + hall + '\'' +
                ", balance='" + balance + '\'' +
                ", registrationDate=" + registrationDate +
                ", lastVisit='" + lastVisit + '\'' +
                ", lastVisitIp='" + lastVisitIp + '\'' +
                ", verifiedPlayer=" + verifiedPlayer +
                ", online=" + online +
                ", status='" + status + '\'' +
                '}';
    }
}

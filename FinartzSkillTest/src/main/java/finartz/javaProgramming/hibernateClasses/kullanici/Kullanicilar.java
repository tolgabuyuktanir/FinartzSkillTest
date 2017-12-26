package finartz.javaProgramming.hibernateClasses.kullanici;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component(value = "kullanicilar")
@Entity
@Table(name = "KULLANICILAR")
public class Kullanicilar implements Serializable {

    private Integer id;

    private String kullaniciAdi;

    private String eMail;

    private String ad;

    private String soyad;

    private String telNo;

    private String adres;


    public Kullanicilar() {

    }

    public Kullanicilar(Integer id)
    {
        this.id=id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "KullaniciAdi", length = 20)
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
    @Column(name = "MAIL", length = 50)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    @Column(name = "Ad", length = 20)
    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    @Column(name = "Soyad", length = 20)
    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    @Column(name = "TelNo", length = 15)
    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    @Column(name = "Adres", length = 100)
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }


}

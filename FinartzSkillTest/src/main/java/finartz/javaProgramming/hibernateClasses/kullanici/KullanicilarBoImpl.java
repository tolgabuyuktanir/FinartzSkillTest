package finartz.javaProgramming.hibernateClasses.kullanici;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import java.util.List;
import java.util.Map;


@Component(value = "kullanicilarBoImpl")
public class KullanicilarBoImpl implements KullanicilarBo {
    private static Logger logger = Logger.getLogger(KullanicilarBoImpl.class);
    private String buttonValue;
    private String message;

    @Autowired
    private Kullanicilar kullanicilar;
    @Autowired
    private KullanicilarDao kullanicilarDao;


    @Override
    public void save(Object object) throws Exception {
        kullanicilarDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        kullanicilarDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        kullanicilarDao.saveOrUpdate(object);
        FacesContext fc=FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Mesage:", "Successfully saved!"));
        logger.info("Successfully saved!");
    }

    @Override
    public void delete(Object object) throws Exception {
        kullanicilarDao.delete(object);
        FacesContext fc=FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Mesage:", "Successfully deleted!"));
        logger.info("Successfully Deleted!");
    }

    @Override
    public boolean isValueInDatabase(Object object) throws Exception {
        return kullanicilarDao.isValueInDatabase(object);
    }

    @Override
    public List<Kullanicilar> allValues() throws Exception {
        logger.info("Select:kullanicilarDao.allValues() calistirildi!");
        return kullanicilarDao.allValues();
    }

    @Override
    public List<Kullanicilar> findById(String id) throws Exception {
        return kullanicilarDao.findById(id);
    }

    public void edit() {
        FacesContext fc = FacesContext.getCurrentInstance();
        setButtonValue("Update");
        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
        if(params.get("id")!=null) {
            RequestContext.getCurrentInstance().execute("PF('dlg2').show(); return false;");
            try {
                for (Kullanicilar k : findById(params.get("id"))) {
                    kullanicilar.setId(k.getId());
                    kullanicilar.setAd(k.getAd());
                    kullanicilar.setSoyad(k.getSoyad());
                    kullanicilar.setKullaniciAdi(k.getKullaniciAdi());
                    kullanicilar.setTelNo(k.getTelNo());
                    kullanicilar.seteMail(k.geteMail());
                    kullanicilar.setAdres(k.getAdres());
                    logger.info(k.getId()+" "+k.getKullaniciAdi()+"listelendi.");
                }
            } catch (Exception e) {
                logger.error("Kullanıcı getirilirken hata oluştu.Detay: " + e.getMessage());
            }
        }


    }
    public void createNewUser()
    {
        kullanicilar.setId(null);
        kullanicilar.setAd("");
        kullanicilar.setSoyad("");
        kullanicilar.setKullaniciAdi("");
        kullanicilar.setTelNo("");
        kullanicilar.seteMail("");
        kullanicilar.setAdres("");
        setButtonValue("Create");
        RequestContext.getCurrentInstance().execute("PF('dlg2').show(); return false;");
    }

    public Kullanicilar getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(Kullanicilar kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public String getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

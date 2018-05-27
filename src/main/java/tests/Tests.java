package tests;

import modules.Butik;
import modules.Product;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Config;

import static tests.Base.*;
import static modules.Home.*;
import static modules.Product.*;
import static modules.Butik.*;

public class Tests {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) {
        Base.setUp(browser);
    }

    @AfterClass(alwaysRun = true)
    static void clean() {
        tearDown();
    }

    @Test
    public void loginTest() {
        login();
    }


    @Test(priority = 3)
    public void cocuk() {
        openTab(Tabs.COCUK.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void kadin() {
        openTab(Tabs.KADIN.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void ayakkabiCanta() {
        openTab(Tabs.AYAKKABICANTA.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void evYasam() {
        openTab(Tabs.EVYASAM.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void hizliTeslimat() {
        openTab(Tabs.HIZLITESLIMAT.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void kozmetik() {
        openTab(Tabs.KOZMETIK.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void saatAksesuar() {
        openTab(Tabs.SAATAKSESUAR.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void erkek() {
        openTab(Tabs.ERKEK.idAttr());
        checkTabImages();
    }

    @Test(priority = 3)
    public void sporGiyim() {
         openTab(Tabs.SPORGIYIM.idAttr());
         checkTabImages();
    }

    @Test(priority = 4)
    public void tumButikler() { //link anasayfadan kaldırılmış olduğundan butik sayfasından ulaşılacak
        goToARandomButikOnPage();
        Butik.clickTumButikler();
        checkTabImages();
    }

    @Test(priority = 5)
    public void openAButik() {
        goToARandomButikOnPage();
        checkProductImages();
    }

    @Test(priority = 6)
    public void goToAProductDetail() {
        goToAProduct();
    }

    @Test(priority = 7)
    public void addToCart() {
        selectSize(); // select "beden" if possible
        sepeteEkle();
        //checkCartSize(1);
    }
}


Feature: US1001 Kullanici Hepsiburada Sayfasinda Arama Yapar

@iphone
  Scenario: TC01 kullanici hepsiburada'da iPhone aratir

    Given Kullanici hepsiburada.com sitesini ziyaret eder.
    Then Kullanici iPhone icin arama islemi yapar
    And Kullanici arama sonucunda gelen urun listesinden urun secer ve urun detay sayfasina gider.
    And Kullanici secilen urun için urun detayda “Yorumlar” tabina gider.
    And Kullanici gelen yorumlar icerisinde ilk yorumun “Evet” butonuna basar.
    And Kullanici “Teşekkür Ederiz” yazisini gorur.
    And Kullanici eger yorumlar tab’inda hic yorum gelmiyorsa herhangi bir islem yapmaz.
    And Kullanici sayfayi kapatir.


package com.exampl.autochampion.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.exampl.config.properties.PropConfiguration;
import io.qameta.allure.selenide.AllureSelenide;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.exampl.config.properties.ConfigurationManager.getConfiguration;

public class BaseTest {
    @Inject
    PropConfiguration cfg;

    @BeforeAll
    public static void setUpAll() {
        if (getConfiguration().remoteRun()) {
            Configuration.remote = getConfiguration().selenoidUrl();
        }
        Configuration.browser = getConfiguration().browserName();
        Configuration.browserSize = "1280x800";
        Configuration.headless = getConfiguration().browserHeadless();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open(cfg.baseUrl());
    }
}

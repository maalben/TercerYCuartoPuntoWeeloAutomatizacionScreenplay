package com.weelo.millionandup.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://newdesign.millionandup.com/")
public class VideocallScheduleUserInterfaces extends PageObject {

    public static final Target ARROW_BUTTON_SCHEDULE_VIDEOCALL = Target.the("Boton para programar videocall").located(By.xpath("//i[@class='icon btn-icon icon-arrow-forward btn-white__icon']"));

    public static final Target ARROW_BUTTON_CALENDAR = Target.the("Boton para abrir calendario").located(By.xpath("//i[@class='icon-arrow-down']"));

    public static final Target BUTTON_OPTION_ZOOM = Target.the("Boton opcion Zoom").located(By.xpath("//div[@class='type-schedule-section']//button[2]"));

    public static final Target TEXTFIELD_EMAIL = Target.the("Campo de texto email").located(By.xpath("//form[@id='frmScheduleLeadModal']/div[@class='required-inputs-lead lead__container-popup']/div[2]//input[1]"));

    public static final Target BUTTON_ACCEPT_SCHEDULE = Target.the("Boton para aceptar la programacion").located(By.id("btnSendModal"));

    public static final Target TEXTFIELD_NAME = Target.the("Campo de texto nombre").located(By.xpath("//form[@id='frmScheduleLeadModal']/div[3]/div[3]/input"));

    public static final Target TEXTFIELD_MOBILE_PHONE = Target.the("Campo de texto celular").located(By.xpath("//form[@id='frmScheduleLeadModal']/div[3]/div[4]//input[@name='phone']"));

    public static final Target LABEL_VALIDATION_MESSAGE = Target.the("Etiqueta de validacion de mensaje").located(By.xpath("//div[@class='d-flex schedule-response-text']"));

    public static final Target LABEL_VALIDATION_MESSAGE_ERROR = Target.the("Etiqueta de validacion de mensaje de error").located(By.xpath("//span[@class='validation-msg-schedule schedule__validation-footer-text']"));

    public static final Target LABEL_VALIDATION_EMAIL_ERROR =
            Target.the("Etiqueta validacion de error email").located(By.xpath("//span[@class='validation-msg lead__validation-footer-text']"));
}

package com.weelo.millionandup.stepdefinitions;

import com.weelo.millionandup.exceptions.AssertionsVideoCallSchedule;
import com.weelo.millionandup.questions.VerifyMessageError;
import com.weelo.millionandup.questions.VerifyMessageErrorWithoutEmail;
import com.weelo.millionandup.questions.VerifyMessageSuccess;
import com.weelo.millionandup.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class VideocallScheduleStepdefinitions {

    @Managed(driver ="chrome")
    private WebDriver hisBrowser;
    Actor mario = Actor.named("Mario");

    @Before
    public void setup()
    {
        mario.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^Yo Ingreso a la pagina de programacion de videollamadas millionandup$")
    public void yoIngresoALaPaginaDeProgramacionDeVideollamadasMillionandup() {
        mario.wasAbleTo(Enter.toThePageMillionandup());
    }

    @Given("^Yo cargo los datos del estudiante$")
    public void yoCargoLosDatosDelEstudiante(List<Map<String, String>> dataVideocall) {
        mario.wasAbleTo(Load.testData(dataVideocall.get(0)));
    }


    @When("^Yo diligencio toda la informacion para la programacion de la videollamada$")
    public void yoDiligencioTodaLaInformacionParaLaProgramacionDeLaVideollamada() {
        mario.attemptsTo(FillOutFull.formVideocall());
    }

    @Then("^Yo verifico que se muestre el mensaje \"([^\"]*)\"$")
    public void yoVerificoQueSeMuestreElMensaje(String message) {
        mario.should(seeThat(VerifyMessageSuccess.is(), equalTo(message)).orComplainWith(AssertionsVideoCallSchedule.class, AssertionsVideoCallSchedule.NO_FOUND_ELEMENT));
    }

    @When("^Yo diligencio informacion de programacion de la videollamada sin hora$")
    public void yoDiligencioInformacionDeProgramacionDeLaVideollamadaSinHora() {
        mario.attemptsTo(FillOutWithoutTime.formVideocall());
    }

    @Then("^Yo deberia ver el mensaje de error \"([^\"]*)\"$")
    public void yoDeberiaVerElMensajeDeError(String message) {
        mario.should(seeThat(VerifyMessageError.is(), equalTo(message)).orComplainWith(AssertionsVideoCallSchedule.class, AssertionsVideoCallSchedule.NO_FOUND_ELEMENT));
    }

    @When("^Yo diligencio informacion de programacion de la videollamada sin email$")
    public void yoDiligencioInformacionDeProgramacionDeLaVideollamadaSinEmail() {
        mario.attemptsTo(FillOutWithoutEmail.formVideocall());
    }

    @Then("^Yo deberia ver el mensaje de error referente al email \"([^\"]*)\"$")
    public void yoDeberiaVerElMensajeDeErrorReferenteAlEmail(String message) {
        mario.should(seeThat(VerifyMessageErrorWithoutEmail.is(), equalTo(message)).orComplainWith(AssertionsVideoCallSchedule.class, AssertionsVideoCallSchedule.NO_FOUND_ELEMENT));
    }

}

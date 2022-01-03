package com.weelo.millionandup.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.weelo.millionandup.userinterfaces.VideocallScheduleUserInterfaces.LABEL_VALIDATION_MESSAGE_ERROR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyMessageError implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_VALIDATION_MESSAGE_ERROR, isVisible()).forNoMoreThan(10).seconds());

        return LABEL_VALIDATION_MESSAGE_ERROR.resolveFor(actor).getText();
    }

    public static VerifyMessageError is() {
        return new VerifyMessageError();
    }
}

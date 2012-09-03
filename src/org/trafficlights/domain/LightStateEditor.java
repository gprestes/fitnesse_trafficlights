package org.trafficlights.domain;

import java.beans.PropertyEditorSupport;

public class LightStateEditor extends PropertyEditorSupport {

    public String getAsText() {
        LightState state = (LightState) getValue();
        return state.description;
    }

    public void setAsText(String state) {
        setValue(LightState.valueFor(state));
    }
}
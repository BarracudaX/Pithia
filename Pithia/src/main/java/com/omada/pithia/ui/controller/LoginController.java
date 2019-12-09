package com.omada.pithia.ui.controller;

public class LoginController {

    private final ViewSwitchController controller;

    public LoginController(ViewSwitchController controller) {
        this.controller = controller;
    }

    public void requestForLogin() {
        controller.requestForHomePage();
    }

}

package web;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;


public class End extends UI
{


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        Label label = new Label("Terve, end");

        layout.addComponent(label);
        setContent(layout);
    }


    @WebServlet(urlPatterns = {"/end/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(ui = End.class, productionMode = false)
    public static class EndServlet extends VaadinServlet {}
}
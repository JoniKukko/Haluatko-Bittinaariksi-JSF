package web;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;


public class Start extends UI
{


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        final TextField nameInput = new TextField("Anna nimesi");
        layout.addComponent(nameInput);

        Button button = new Button("Do not press this button");


        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                Notification.show( nameInput.getValue() );
            }
        });

        layout.addComponent(button);
        setContent(layout);
    }


    @WebServlet(urlPatterns = {"/start/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(ui = Start.class, productionMode = false)
    public static class StartServlet extends VaadinServlet {}
}

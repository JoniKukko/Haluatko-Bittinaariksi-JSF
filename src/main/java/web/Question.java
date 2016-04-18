package web;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;


public class Question extends UI
{


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        Label label = new Label("Terve, question");

        layout.addComponent(label);
        setContent(layout);
    }


    @WebServlet(urlPatterns = {"/question/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(ui = Question.class, productionMode = false)
    public static class QuestionServlet extends VaadinServlet {}
}
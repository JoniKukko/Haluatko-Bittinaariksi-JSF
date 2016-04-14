package UI;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;



public class Start extends UI
{
    @Override
    public void init(VaadinRequest request)
    {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.addComponent(new Label("Hello, world2!"));
    }

    @WebServlet(urlPatterns = "/*", name = "BittiServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Start.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
